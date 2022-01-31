package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Environment;
import android.text.TextUtils;
import bace;
import bcdu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class MiniAppFileManager
{
  public static final String FILE_PREFIX_PRE_CACHE = "precache";
  public static final String FILE_PREFIX_STORE = "store";
  public static final String FILE_PREFIX_TMP = "tmp";
  public static final String FILE_PREFIX_USR = "usr";
  public static final int FILE_TYPE_PRE_CACHE = 4;
  public static final int FILE_TYPE_STORE = 1;
  public static final int FILE_TYPE_TMP = 0;
  public static final int FILE_TYPE_UNKOWN = 9999;
  public static final int FILE_TYPE_USR = 2;
  private static final long MINI_APP_STORAGE_MAX_SIZE = 10485760L;
  private static final String MINI_FILE_ROOT_NAME = "/tencent/mini/";
  private static final String MINI_FILE_ROOT_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/";
  private static final String MINI_FILE_SAVE_PATH = MINI_FILE_ROOT_PATH + "files/";
  private static final String MINI_FILE_SUB_NAME = "files/";
  private static final long MINI_GAME_STORAGE_MAX_SIZE = 52428800L;
  private static final String TAG = "MiniAppFileManager";
  public static final String WXFILE_PREFIX_PRE_CACHE;
  public static final String WXFILE_PREFIX_STORE;
  public static final String WXFILE_PREFIX_TMP = MiniAppGlobal.STR_WXFILE + "tmp_";
  public static final String WXFILE_PREFIX_USR;
  private static boolean hasCheckUsrDir;
  private static boolean isNoMediaCreated;
  private static volatile MiniAppFileManager sInstance;
  private ApkgBaseInfo apkgInfo;
  private String curMiniAppId;
  private ConcurrentHashMap<String, String> curWxFileToLocalMap;
  private ArrayList<String> mTmpFileNeed2DeleteAsync = new ArrayList();
  
  static
  {
    WXFILE_PREFIX_STORE = MiniAppGlobal.STR_WXFILE + "store_";
    WXFILE_PREFIX_USR = MiniAppGlobal.STR_WXFILE + "usr";
    WXFILE_PREFIX_PRE_CACHE = MiniAppGlobal.STR_WXFILE + "precache";
  }
  
  private static void checkUsrDir(String paramString)
  {
    if (hasCheckUsrDir) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    hasCheckUsrDir = true;
  }
  
  /* Error */
  private static void createNoMediaInMiniPath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 136	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 104	java/io/File
    //   18: dup
    //   19: getstatic 111	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:MINI_FILE_SAVE_PATH	Ljava/lang/String;
    //   22: ldc 138
    //   24: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +15 -> 49
    //   37: aload_2
    //   38: invokevirtual 128	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 131	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 128	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 147	java/io/File:createNewFile	()Z
    //   60: pop
    //   61: iconst_1
    //   62: putstatic 136	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: ldc 149
    //   71: iconst_1
    //   72: ldc 151
    //   74: aload_1
    //   75: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -67 -> 11
    //   81: astore_1
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   27	30	1	localFile1	File
    //   68	7	1	localIOException	java.io.IOException
    //   81	5	1	localObject	Object
    //   32	13	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   28	33	68	java/io/IOException
    //   37	49	68	java/io/IOException
    //   49	61	68	java/io/IOException
    //   61	65	68	java/io/IOException
    //   3	7	81	finally
    //   15	28	81	finally
    //   28	33	81	finally
    //   37	49	81	finally
    //   49	61	81	finally
    //   61	65	81	finally
    //   69	78	81	finally
  }
  
  private void deleteTmpFolder()
  {
    bace.a(getMiniFolderPath(0), false);
  }
  
  private String getCurAppSdcardDir()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.curMiniAppId)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + this.curMiniAppId);
      return MINI_FILE_SAVE_PATH;
    }
    return MINI_FILE_SAVE_PATH + bcdu.d(this.curMiniAppId) + "/" + bcdu.d(str);
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + paramString);
      return MINI_FILE_SAVE_PATH;
    }
    return MINI_FILE_SAVE_PATH + bcdu.d(paramString) + "/" + bcdu.d(str);
  }
  
  private String getFileName(String paramString)
  {
    if (paramString.startsWith(WXFILE_PREFIX_TMP)) {
      return paramString.replace(WXFILE_PREFIX_TMP, "");
    }
    if (paramString.startsWith(WXFILE_PREFIX_STORE)) {
      return paramString.replace(WXFILE_PREFIX_STORE, "");
    }
    if (paramString.startsWith(WXFILE_PREFIX_USR)) {
      return new File(paramString.replace(WXFILE_PREFIX_USR, "")).getName();
    }
    return "";
  }
  
  public static String getFileSuffix(File paramFile)
  {
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf(".");
    if (i < 0) {
      return "";
    }
    return paramFile.substring(i + 1);
  }
  
  public static MiniAppFileManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniAppFileManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private String getMiniFolderPath(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      str = "tmp";
    }
    for (;;)
    {
      createNoMediaInMiniPath();
      str = getCurAppSdcardDir() + "/" + str;
      if (paramInt == 2) {
        checkUsrDir(str);
      }
      return str;
      str = "tmp";
      continue;
      str = "store";
      continue;
      str = "usr";
      continue;
      str = "precache";
    }
  }
  
  private static String getMiniFolderPath(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      str = "tmp";
    }
    for (;;)
    {
      createNoMediaInMiniPath();
      paramString = getCurAppSdcardDir(paramString) + "/" + str;
      if (paramInt == 2) {
        checkUsrDir(paramString);
      }
      return paramString;
      str = "tmp";
      continue;
      str = "store";
      continue;
      str = "usr";
      continue;
      str = "precache";
    }
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2)
  {
    Object localObject = null;
    File localFile = new File(getMiniFolderPath(4, paramString1), paramString2);
    paramString2 = localObject;
    try
    {
      if (localFile.getCanonicalPath().startsWith(getCurAppSdcardDir(paramString1))) {
        paramString2 = localFile.getAbsolutePath();
      }
      return paramString2;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppFileManager", 1, "getUsrPath error", paramString1);
    }
    return null;
  }
  
  private static String getSuffixByPath(String paramString)
  {
    String str2 = "";
    try
    {
      str1 = new URL(paramString).getPath();
      paramString = str1;
    }
    catch (Throwable localThrowable)
    {
      String str1;
      label17:
      int i;
      break label17;
    }
    str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".");
      str1 = str2;
      if (i != -1)
      {
        str1 = str2;
        if (i + 1 < paramString.length()) {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    return str1;
  }
  
  private void renameTmpFolder()
  {
    String str1 = getMiniFolderPath(0);
    String str2 = str1 + "_del_";
    bace.c(str1, str2);
    this.mTmpFileNeed2DeleteAsync.add(str2);
  }
  
  /* Error */
  public String copyTmpFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 104	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 104	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: iconst_0
    //   19: invokespecial 162	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   22: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 5
    //   27: aload 4
    //   29: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   32: aload 5
    //   34: invokevirtual 287	java/io/File:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +5 -> 42
    //   40: aload_1
    //   41: areturn
    //   42: new 104	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: aload 4
    //   49: invokestatic 289	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getFileSuffix	(Ljava/io/File;)Ljava/lang/String;
    //   52: invokevirtual 292	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 9
    //   60: sipush 8192
    //   63: newarray byte
    //   65: astore 7
    //   67: new 294	java/io/BufferedInputStream
    //   70: dup
    //   71: new 296	java/io/FileInputStream
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 302	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 4
    //   85: new 304	java/io/BufferedOutputStream
    //   88: dup
    //   89: new 306	java/io/FileOutputStream
    //   92: dup
    //   93: aload 9
    //   95: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: invokespecial 310	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore_1
    //   102: aload_1
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 4
    //   111: aload 7
    //   113: invokevirtual 316	java/io/InputStream:read	([B)I
    //   116: istore_2
    //   117: iload_2
    //   118: iconst_m1
    //   119: if_icmple +76 -> 195
    //   122: aload_1
    //   123: astore 6
    //   125: aload 4
    //   127: astore 5
    //   129: aload_1
    //   130: aload 7
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual 322	java/io/OutputStream:write	([BII)V
    //   137: goto -35 -> 102
    //   140: astore 7
    //   142: aload_1
    //   143: astore 6
    //   145: aload 4
    //   147: astore 5
    //   149: ldc 46
    //   151: ldc_w 324
    //   154: aload 7
    //   156: invokestatic 329	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   159: pop
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 332	java/io/OutputStream:close	()V
    //   168: aload 4
    //   170: ifnull +154 -> 324
    //   173: aload 4
    //   175: invokevirtual 333	java/io/InputStream:close	()V
    //   178: iconst_0
    //   179: istore_2
    //   180: aload 8
    //   182: astore_1
    //   183: iload_2
    //   184: ifeq +9 -> 193
    //   187: aload 9
    //   189: invokevirtual 261	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: areturn
    //   195: aload_1
    //   196: astore 6
    //   198: aload 4
    //   200: astore 5
    //   202: aload_1
    //   203: invokevirtual 336	java/io/OutputStream:flush	()V
    //   206: iconst_1
    //   207: istore_3
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 332	java/io/OutputStream:close	()V
    //   216: iload_3
    //   217: istore_2
    //   218: aload 4
    //   220: ifnull -40 -> 180
    //   223: aload 4
    //   225: invokevirtual 333	java/io/InputStream:close	()V
    //   228: iload_3
    //   229: istore_2
    //   230: goto -50 -> 180
    //   233: astore_1
    //   234: iload_3
    //   235: istore_2
    //   236: goto -56 -> 180
    //   239: astore_1
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -62 -> 180
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 4
    //   252: aload 6
    //   254: ifnull +8 -> 262
    //   257: aload 6
    //   259: invokevirtual 332	java/io/OutputStream:close	()V
    //   262: aload 4
    //   264: ifnull +8 -> 272
    //   267: aload 4
    //   269: invokevirtual 333	java/io/InputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: goto -59 -> 216
    //   278: astore_1
    //   279: goto -111 -> 168
    //   282: astore 5
    //   284: goto -22 -> 262
    //   287: astore 4
    //   289: goto -17 -> 272
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 6
    //   296: goto -44 -> 252
    //   299: astore_1
    //   300: aload 5
    //   302: astore 4
    //   304: goto -52 -> 252
    //   307: astore 7
    //   309: aconst_null
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 4
    //   314: goto -172 -> 142
    //   317: astore 7
    //   319: aconst_null
    //   320: astore_1
    //   321: goto -179 -> 142
    //   324: iconst_0
    //   325: istore_2
    //   326: goto -146 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	MiniAppFileManager
    //   0	329	1	paramString	String
    //   116	210	2	i	int
    //   207	28	3	j	int
    //   11	257	4	localObject1	Object
    //   287	1	4	localIOException1	java.io.IOException
    //   302	11	4	localObject2	Object
    //   25	176	5	localObject3	Object
    //   282	19	5	localIOException2	java.io.IOException
    //   103	192	6	str	String
    //   65	66	7	arrayOfByte	byte[]
    //   140	15	7	localIOException3	java.io.IOException
    //   307	1	7	localIOException4	java.io.IOException
    //   317	1	7	localIOException5	java.io.IOException
    //   1	180	8	localObject4	Object
    //   58	130	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   109	117	140	java/io/IOException
    //   129	137	140	java/io/IOException
    //   202	206	140	java/io/IOException
    //   223	228	233	java/io/IOException
    //   173	178	239	java/io/IOException
    //   67	85	245	finally
    //   212	216	274	java/io/IOException
    //   164	168	278	java/io/IOException
    //   257	262	282	java/io/IOException
    //   267	272	287	java/io/IOException
    //   85	102	292	finally
    //   109	117	299	finally
    //   129	137	299	finally
    //   149	160	299	finally
    //   202	206	299	finally
    //   67	85	307	java/io/IOException
    //   85	102	317	java/io/IOException
  }
  
  public void deleteTmpFileNeed2DeleteAsync()
  {
    if ((this.mTmpFileNeed2DeleteAsync != null) && (this.mTmpFileNeed2DeleteAsync.size() > 0))
    {
      int i = this.mTmpFileNeed2DeleteAsync.size() - 1;
      while (i >= 0)
      {
        if (this.mTmpFileNeed2DeleteAsync.get(i) != null)
        {
          bace.a((String)this.mTmpFileNeed2DeleteAsync.get(i), false);
          this.mTmpFileNeed2DeleteAsync.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public String getAbsolutePath(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))) {
        return paramString;
      }
      if (this.curWxFileToLocalMap != null)
      {
        String str2 = (String)this.curWxFileToLocalMap.get(paramString);
        str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          break label444;
        }
      }
      str1 = paramString;
      if (!paramString.startsWith(MiniAppGlobal.STR_WXFILE))
      {
        if (!paramString.startsWith("wxfile://")) {
          break label160;
        }
        str1 = paramString.replace("wxfile://", MiniAppGlobal.STR_WXFILE);
      }
      while (str1.startsWith(WXFILE_PREFIX_TMP))
      {
        paramString = str1.replace(WXFILE_PREFIX_TMP, "");
        paramString = new File(getMiniFolderPath(0), paramString);
        if ((!paramString.exists()) || (!paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
          break label441;
        }
        return paramString.getAbsolutePath();
        label160:
        str1 = paramString;
        if (paramString.startsWith("qqfile://")) {
          str1 = paramString.replace("qqfile://", MiniAppGlobal.STR_WXFILE);
        }
      }
      if (str1.startsWith(WXFILE_PREFIX_STORE))
      {
        paramString = str1.replace(WXFILE_PREFIX_STORE, "");
        paramString = new File(getMiniFolderPath(1), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
          return paramString.getAbsolutePath();
        }
      }
      else if (str1.startsWith(WXFILE_PREFIX_USR))
      {
        paramString = str1.replace(WXFILE_PREFIX_USR, "");
        paramString = new File(getMiniFolderPath(2), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
          return paramString.getAbsolutePath();
        }
      }
      else if (str1.startsWith(WXFILE_PREFIX_PRE_CACHE))
      {
        paramString = str1.replace(WXFILE_PREFIX_PRE_CACHE, "");
        paramString = new File(getMiniFolderPath(4), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
          return paramString.getAbsolutePath();
        }
      }
      else
      {
        paramString = new File(this.apkgInfo.getFilePath(str1));
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath())))
        {
          paramString = this.apkgInfo.getFilePath(str1);
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppFileManager", 1, "getAbsolutePath error.", paramString);
      return "";
    }
    label441:
    String str1 = "";
    label444:
    return str1;
    return paramString;
  }
  
  public String getRootFileDir()
  {
    return MINI_FILE_ROOT_PATH;
  }
  
  public File[] getSaveFileList()
  {
    File[] arrayOfFile = null;
    File localFile = new File(getMiniFolderPath(1));
    try
    {
      if (localFile.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
        arrayOfFile = localFile.listFiles();
      }
      return arrayOfFile;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppFileManager", 1, "getSaveFileList error", localThrowable);
    }
    return null;
  }
  
  public String getTmpPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "." + paramString)
    {
      paramString = MD5.toMD5(new StringBuilder().append(System.nanoTime()).append("").toString()) + paramString;
      File localFile = new File(getMiniFolderPath(0));
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, paramString).getAbsolutePath();
    }
  }
  
  public String getTmpPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = "";; paramString2 = "." + paramString2)
    {
      paramString2 = MD5.toMD5(new StringBuilder().append(System.nanoTime()).append("").toString()) + paramString2;
      paramString2 = new File(getMiniFolderPath(0, paramString1), paramString2);
      try
      {
        if (!paramString2.getCanonicalPath().startsWith(getCurAppSdcardDir(paramString1))) {
          break;
        }
        paramString1 = paramString2.getAbsolutePath();
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("MiniAppFileManager", 1, "getTmpPath error", paramString1);
        return null;
      }
    }
    return null;
  }
  
  public String getTmpPathByUrl(String paramString)
  {
    return getTmpPath(getSuffixByPath(paramString));
  }
  
  public String getTmpPathFromOut(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    int i = paramString1.lastIndexOf(".");
    if ((i < 0) || (paramString1.length() - 1 < i)) {
      return "";
    }
    return getInstance().getTmpPath(paramString2, paramString1.substring(i + 1));
  }
  
  public String getUsrPath(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramString.startsWith(WXFILE_PREFIX_USR))
      {
        paramString = paramString.replace(WXFILE_PREFIX_USR, "");
        paramString = new File(getMiniFolderPath(2), paramString);
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
        localObject1 = paramString.getAbsolutePath();
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppFileManager", 1, "getUsrPath error", paramString);
    }
    return null;
  }
  
  public String getWxFilePath(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new File(paramString);
        String str = ((File)localObject).getParentFile().getAbsolutePath();
        if ((getMiniFolderPath(0).equals(str)) || (getMiniFolderPath(1).equals(str)))
        {
          if (((File)localObject).getParentFile().getName().equals("store"))
          {
            localObject = "store";
            paramString = new File(paramString).getName();
            return MiniAppGlobal.STR_WXFILE + (String)localObject + "_" + paramString;
          }
        }
        else
        {
          if (str.startsWith(getMiniFolderPath(2)))
          {
            paramString = getMiniFolderPath(2);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return WXFILE_PREFIX_USR + paramString;
          }
          if (str.startsWith(getMiniFolderPath(4)))
          {
            paramString = getMiniFolderPath(4);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return WXFILE_PREFIX_PRE_CACHE + paramString;
          }
          if (new File(paramString).exists()) {
            return getWxFilePathByExistLocalPath(paramString);
          }
          return "";
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      Object localObject = "tmp";
    }
  }
  
  public String getWxFilePathByExistLocalPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = getSuffixByPath(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (str = "";; str = "." + str)
    {
      str = MD5.toMD5(new StringBuilder().append(System.nanoTime()).append("").toString()) + str;
      str = MiniAppGlobal.STR_WXFILE + "tmp" + "_" + str;
      this.curWxFileToLocalMap.put(str, paramString);
      return str;
    }
  }
  
  public String getWxFileTmpPath(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (paramString.length() - 1 < i)) {
      return "";
    }
    return getTmpPath(paramString.substring(i + 1));
  }
  
  public int getWxFileType(String paramString)
  {
    if (paramString.startsWith(WXFILE_PREFIX_TMP)) {
      return 0;
    }
    if (paramString.startsWith(WXFILE_PREFIX_STORE)) {
      return 1;
    }
    if (paramString.startsWith(WXFILE_PREFIX_PRE_CACHE)) {
      return 4;
    }
    if (paramString.startsWith(WXFILE_PREFIX_USR)) {
      return 2;
    }
    return 9999;
  }
  
  public void initFileManager(ApkgBaseInfo paramApkgBaseInfo, boolean paramBoolean)
  {
    updateCurApkgInfo(paramApkgBaseInfo);
    if (paramBoolean)
    {
      renameTmpFolder();
      return;
    }
    deleteTmpFolder();
  }
  
  public boolean isFolderCanWrite(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.apkgInfo == null) || (this.apkgInfo.appConfig == null) || (this.apkgInfo.appConfig.config == null))
    {
      QLog.w("[mini] ", 1, "check isFolderCanWrite on null apkgInfo or  null apkgInfo.appConfig or null apkgInfo.appConfig.config");
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramLong <= 0L);
    int i;
    label66:
    long l3;
    if (paramInt == 1)
    {
      i = 1;
      l3 = bace.b(getMiniFolderPath(i));
      if (!this.apkgInfo.isEngineTypeMiniGame()) {
        break label160;
      }
    }
    label160:
    for (long l1 = 52428800L;; l1 = 10485760L)
    {
      long l2 = l1;
      if (paramInt == 2)
      {
        l2 = l1;
        if (this.apkgInfo.appConfig.config.usrFileSizeLimit > 0L) {
          l2 = this.apkgInfo.appConfig.config.usrFileSizeLimit;
        }
      }
      bool1 = bool2;
      if (l3 + paramLong <= l2) {
        break;
      }
      return false;
      i = 2;
      break label66;
    }
  }
  
  public boolean isPackageRelativePath(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(this.apkgInfo.getFilePath(paramString));
      boolean bool1 = bool2;
      if (paramString.exists())
      {
        boolean bool3 = paramString.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public String savePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith(WXFILE_PREFIX_STORE));
    String str = getAbsolutePath(paramString);
    if (new File(str).exists())
    {
      paramString = getFileName(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (bace.d(str, new File(getMiniFolderPath(1), paramString).getAbsolutePath())) {
        return MiniAppGlobal.STR_WXFILE + "store" + "_" + paramString;
      }
    }
    return null;
  }
  
  public void updateCurApkgInfo(ApkgBaseInfo paramApkgBaseInfo)
  {
    this.curMiniAppId = paramApkgBaseInfo.appId;
    this.apkgInfo = paramApkgBaseInfo;
    if (this.curWxFileToLocalMap == null) {
      this.curWxFileToLocalMap = new ConcurrentHashMap();
    }
    this.curWxFileToLocalMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */