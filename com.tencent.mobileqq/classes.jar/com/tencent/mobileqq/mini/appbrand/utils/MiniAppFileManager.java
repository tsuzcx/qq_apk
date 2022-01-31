package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.os.Environment;
import android.text.TextUtils;
import bdcs;
import bduw;
import bfhi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

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
  public static final String MINI_FILE_ROOT_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/";
  public static final String MINI_FILE_SAVE_PATH = MINI_FILE_ROOT_PATH + "files/";
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
  private WeakReference<Activity> activityWeakReference;
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
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    hasCheckUsrDir = true;
  }
  
  public static void clearFileCache(String paramString)
  {
    paramString = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(paramString);
    if (new File(paramString).exists()) {
      bdcs.a(paramString, false);
    }
    hasCheckUsrDir = false;
  }
  
  /* Error */
  private static void createNoMediaInMiniPath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 159	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 127	com/tencent/mm/vfs/VFSFile
    //   18: dup
    //   19: getstatic 114	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:MINI_FILE_SAVE_PATH	Ljava/lang/String;
    //   22: ldc 161
    //   24: invokespecial 164	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 168	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +15 -> 49
    //   37: aload_2
    //   38: invokevirtual 133	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 136	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 133	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 171	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   60: pop
    //   61: iconst_1
    //   62: putstatic 159	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: ldc 173
    //   71: iconst_1
    //   72: ldc 175
    //   74: aload_1
    //   75: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -67 -> 11
    //   81: astore_1
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   27	30	1	localVFSFile1	VFSFile
    //   68	7	1	localIOException	java.io.IOException
    //   81	5	1	localObject	Object
    //   32	13	2	localVFSFile2	VFSFile
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
    FileUtils.delete(getMiniFolderPath(0), false);
  }
  
  private String getCurAppSdcardDir()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.curMiniAppId)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + this.curMiniAppId);
      return MINI_FILE_SAVE_PATH;
    }
    return MINI_FILE_SAVE_PATH + bfhi.d(this.curMiniAppId) + "/" + bfhi.d(str);
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + paramString);
      return MINI_FILE_SAVE_PATH;
    }
    return MINI_FILE_SAVE_PATH + bfhi.d(paramString) + "/" + bfhi.d(str);
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
      return new VFSFile(paramString.replace(WXFILE_PREFIX_USR, "")).getName();
    }
    return "";
  }
  
  public static String getFileSuffix(VFSFile paramVFSFile)
  {
    paramVFSFile = paramVFSFile.getName();
    int i = paramVFSFile.lastIndexOf(".");
    if (i < 0) {
      return "";
    }
    return paramVFSFile.substring(i + 1);
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
    return getPreCacheFilePath(paramString1, null, paramString2);
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str2 = getMiniFolderPath(4, paramString1);
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2)) {
      str1 = str2 + File.separator + paramString2;
    }
    paramString2 = new VFSFile(str1, paramString3);
    try
    {
      if (bduw.b(paramString2.getPath()).startsWith(getCurAppSdcardDir(paramString1)))
      {
        paramString1 = paramString2.getAbsolutePath();
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppFileManager", 1, "getUsrPath error", paramString1);
      return null;
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
    FileUtils.rename(str1, str2);
    this.mTmpFileNeed2DeleteAsync.add(str2);
  }
  
  /* Error */
  public String copyTmpFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore_3
    //   5: new 127	com/tencent/mm/vfs/VFSFile
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 129	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: new 127	com/tencent/mm/vfs/VFSFile
    //   18: dup
    //   19: aload_0
    //   20: iconst_0
    //   21: invokespecial 186	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   24: invokespecial 129	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 284	com/tencent/mm/vfs/VFSFile:getPath	()Ljava/lang/String;
    //   30: iconst_1
    //   31: invokestatic 321	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   34: astore 5
    //   36: aload 4
    //   38: invokevirtual 168	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   41: invokevirtual 284	com/tencent/mm/vfs/VFSFile:getPath	()Ljava/lang/String;
    //   44: aload 5
    //   46: invokevirtual 324	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +31 -> 80
    //   52: ldc 46
    //   54: iconst_1
    //   55: new 71	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 326
    //   65: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: areturn
    //   80: new 127	com/tencent/mm/vfs/VFSFile
    //   83: dup
    //   84: aload_0
    //   85: aload 4
    //   87: invokestatic 328	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getFileSuffix	(Lcom/tencent/mm/vfs/VFSFile;)Ljava/lang/String;
    //   90: invokevirtual 331	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokespecial 129	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   96: astore 9
    //   98: sipush 8192
    //   101: newarray byte
    //   103: astore 7
    //   105: new 333	java/io/BufferedInputStream
    //   108: dup
    //   109: new 335	com/tencent/mm/vfs/VFSFileInputStream
    //   112: dup
    //   113: aload 4
    //   115: invokespecial 338	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   118: invokespecial 341	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore 4
    //   123: new 343	java/io/BufferedOutputStream
    //   126: dup
    //   127: new 345	com/tencent/mm/vfs/VFSFileOutputStream
    //   130: dup
    //   131: aload 9
    //   133: invokespecial 346	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   136: invokespecial 349	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore_1
    //   140: aload_1
    //   141: astore 6
    //   143: aload 4
    //   145: astore 5
    //   147: aload 4
    //   149: aload 7
    //   151: invokevirtual 355	java/io/InputStream:read	([B)I
    //   154: istore_2
    //   155: iload_2
    //   156: iconst_m1
    //   157: if_icmple +76 -> 233
    //   160: aload_1
    //   161: astore 6
    //   163: aload 4
    //   165: astore 5
    //   167: aload_1
    //   168: aload 7
    //   170: iconst_0
    //   171: iload_2
    //   172: invokevirtual 361	java/io/OutputStream:write	([BII)V
    //   175: goto -35 -> 140
    //   178: astore 7
    //   180: aload_1
    //   181: astore 6
    //   183: aload 4
    //   185: astore 5
    //   187: ldc 46
    //   189: ldc_w 363
    //   192: aload 7
    //   194: invokestatic 368	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   197: pop
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 371	java/io/OutputStream:close	()V
    //   206: aload 4
    //   208: ifnull +152 -> 360
    //   211: aload 4
    //   213: invokevirtual 372	java/io/InputStream:close	()V
    //   216: iconst_0
    //   217: istore_2
    //   218: aload 8
    //   220: astore_1
    //   221: iload_2
    //   222: ifeq +9 -> 231
    //   225: aload 9
    //   227: invokevirtual 292	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   230: astore_1
    //   231: aload_1
    //   232: areturn
    //   233: aload_1
    //   234: astore 6
    //   236: aload 4
    //   238: astore 5
    //   240: aload_1
    //   241: invokevirtual 375	java/io/OutputStream:flush	()V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 371	java/io/OutputStream:close	()V
    //   252: iload_3
    //   253: istore_2
    //   254: aload 4
    //   256: ifnull -38 -> 218
    //   259: aload 4
    //   261: invokevirtual 372	java/io/InputStream:close	()V
    //   264: iload_3
    //   265: istore_2
    //   266: goto -48 -> 218
    //   269: astore_1
    //   270: iload_3
    //   271: istore_2
    //   272: goto -54 -> 218
    //   275: astore_1
    //   276: iconst_0
    //   277: istore_2
    //   278: goto -60 -> 218
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 6
    //   285: aconst_null
    //   286: astore 4
    //   288: aload 6
    //   290: ifnull +8 -> 298
    //   293: aload 6
    //   295: invokevirtual 371	java/io/OutputStream:close	()V
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 372	java/io/InputStream:close	()V
    //   308: aload_1
    //   309: athrow
    //   310: astore_1
    //   311: goto -59 -> 252
    //   314: astore_1
    //   315: goto -109 -> 206
    //   318: astore 5
    //   320: goto -22 -> 298
    //   323: astore 4
    //   325: goto -17 -> 308
    //   328: astore_1
    //   329: aconst_null
    //   330: astore 6
    //   332: goto -44 -> 288
    //   335: astore_1
    //   336: aload 5
    //   338: astore 4
    //   340: goto -52 -> 288
    //   343: astore 7
    //   345: aconst_null
    //   346: astore_1
    //   347: aconst_null
    //   348: astore 4
    //   350: goto -170 -> 180
    //   353: astore 7
    //   355: aconst_null
    //   356: astore_1
    //   357: goto -177 -> 180
    //   360: iconst_0
    //   361: istore_2
    //   362: goto -144 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	MiniAppFileManager
    //   0	365	1	paramString	String
    //   154	208	2	i	int
    //   4	267	3	j	int
    //   13	291	4	localObject1	Object
    //   323	1	4	localIOException1	java.io.IOException
    //   338	11	4	localObject2	Object
    //   34	205	5	localObject3	Object
    //   318	19	5	localIOException2	java.io.IOException
    //   141	190	6	str	String
    //   103	66	7	arrayOfByte	byte[]
    //   178	15	7	localIOException3	java.io.IOException
    //   343	1	7	localIOException4	java.io.IOException
    //   353	1	7	localIOException5	java.io.IOException
    //   1	218	8	localObject4	Object
    //   96	130	9	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   147	155	178	java/io/IOException
    //   167	175	178	java/io/IOException
    //   240	244	178	java/io/IOException
    //   259	264	269	java/io/IOException
    //   211	216	275	java/io/IOException
    //   105	123	281	finally
    //   248	252	310	java/io/IOException
    //   202	206	314	java/io/IOException
    //   293	298	318	java/io/IOException
    //   303	308	323	java/io/IOException
    //   123	140	328	finally
    //   147	155	335	finally
    //   167	175	335	finally
    //   187	198	335	finally
    //   240	244	335	finally
    //   105	123	343	java/io/IOException
    //   123	140	353	java/io/IOException
  }
  
  public void deleteTmpFileNeed2DeleteAsync()
  {
    if ((this.mTmpFileNeed2DeleteAsync != null) && (this.mTmpFileNeed2DeleteAsync.size() > 0))
    {
      ArrayList localArrayList2 = new ArrayList();
      synchronized (this.mTmpFileNeed2DeleteAsync)
      {
        localArrayList2.addAll(this.mTmpFileNeed2DeleteAsync);
        this.mTmpFileNeed2DeleteAsync.clear();
        int i = localArrayList2.size() - 1;
        if (i >= 0)
        {
          if (localArrayList2.get(i) != null)
          {
            FileUtils.delete((String)localArrayList2.get(i), false);
            localArrayList2.remove(i);
          }
          i -= 1;
        }
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
          break label482;
        }
      }
      str1 = paramString;
      if (!paramString.startsWith(MiniAppGlobal.STR_WXFILE))
      {
        if (!paramString.startsWith("wxfile://")) {
          break label167;
        }
        str1 = paramString.replace("wxfile://", MiniAppGlobal.STR_WXFILE);
      }
      while (str1.startsWith(WXFILE_PREFIX_TMP))
      {
        paramString = str1.replace(WXFILE_PREFIX_TMP, "");
        paramString = new VFSFile(getMiniFolderPath(0), paramString);
        if ((!paramString.exists()) || (!bduw.b(paramString.getPath()).startsWith(getCurAppSdcardDir()))) {
          break label479;
        }
        return VFSFileOp.exportExternalPath(paramString.getAbsolutePath(), true);
        label167:
        str1 = paramString;
        if (paramString.startsWith("qqfile://")) {
          str1 = paramString.replace("qqfile://", MiniAppGlobal.STR_WXFILE);
        }
      }
      if (str1.startsWith(WXFILE_PREFIX_STORE))
      {
        paramString = str1.replace(WXFILE_PREFIX_STORE, "");
        paramString = new VFSFile(getMiniFolderPath(1), paramString);
        if ((paramString.exists()) && (bduw.b(paramString.getPath()).startsWith(getCurAppSdcardDir()))) {
          return VFSFileOp.exportExternalPath(paramString.getAbsolutePath(), true);
        }
      }
      else if (str1.startsWith(WXFILE_PREFIX_USR))
      {
        paramString = str1.replace(WXFILE_PREFIX_USR, "");
        paramString = new VFSFile(getMiniFolderPath(2), paramString);
        if ((paramString.exists()) && (bduw.b(paramString.getPath()).startsWith(getCurAppSdcardDir()))) {
          return VFSFileOp.exportExternalPath(paramString.getAbsolutePath(), true);
        }
      }
      else if (str1.startsWith(WXFILE_PREFIX_PRE_CACHE))
      {
        paramString = str1.replace(WXFILE_PREFIX_PRE_CACHE, "");
        paramString = new VFSFile(getMiniFolderPath(4), paramString);
        if ((paramString.exists()) && (bduw.b(paramString.getPath()).startsWith(getCurAppSdcardDir()))) {
          return VFSFileOp.exportExternalPath(paramString.getAbsolutePath(), true);
        }
      }
      else
      {
        paramString = new VFSFile(this.apkgInfo.getFilePath(str1));
        if ((paramString.exists()) && (bduw.b(paramString.getPath()).startsWith(bduw.b(new VFSFile(this.apkgInfo.getApkgFolderPath()).getPath()))))
        {
          paramString = VFSFileOp.exportExternalPath(this.apkgInfo.getFilePath(str1), true);
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppFileManager", 1, "getAbsolutePath error.", paramString);
      return "";
    }
    label479:
    String str1 = "";
    label482:
    return str1;
    return paramString;
  }
  
  public String getRootFileDir()
  {
    return MINI_FILE_ROOT_PATH;
  }
  
  public VFSFile[] getSaveFileList()
  {
    VFSFile[] arrayOfVFSFile = null;
    VFSFile localVFSFile = new VFSFile(getMiniFolderPath(1));
    try
    {
      if (bduw.b(localVFSFile.getPath()).startsWith(getCurAppSdcardDir())) {
        arrayOfVFSFile = localVFSFile.listFiles();
      }
      return arrayOfVFSFile;
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
      VFSFile localVFSFile = new VFSFile(getMiniFolderPath(0));
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      return VFSFileOp.exportExternalPath(new VFSFile(localVFSFile, paramString).getAbsolutePath(), true);
    }
  }
  
  public String getTmpPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = "";; paramString2 = "." + paramString2)
    {
      paramString2 = MD5.toMD5(new StringBuilder().append(System.nanoTime()).append("").toString()) + paramString2;
      paramString2 = new VFSFile(getMiniFolderPath(0, paramString1), paramString2);
      try
      {
        if (!bduw.b(paramString2.getPath()).startsWith(getCurAppSdcardDir(paramString1))) {
          break;
        }
        paramString1 = VFSFileOp.exportExternalPath(paramString2.getAbsolutePath(), true);
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
        paramString = new VFSFile(getMiniFolderPath(2), paramString);
        localObject1 = localObject2;
      }
    }
    try
    {
      if (bduw.b(paramString.getPath()).startsWith(getCurAppSdcardDir())) {
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
        localObject = new VFSFile(paramString);
        String str = ((VFSFile)localObject).getParentFile().getAbsolutePath();
        if ((getMiniFolderPath(0).equals(str)) || (getMiniFolderPath(1).equals(str)))
        {
          if (((VFSFile)localObject).getParentFile().getName().equals("store"))
          {
            localObject = "store";
            paramString = new VFSFile(paramString).getName();
            return MiniAppGlobal.STR_WXFILE + (String)localObject + "_" + paramString;
          }
        }
        else
        {
          if (str.startsWith(getMiniFolderPath(2)))
          {
            paramString = getMiniFolderPath(2);
            paramString = ((VFSFile)localObject).getAbsolutePath().replace(paramString, "");
            return WXFILE_PREFIX_USR + paramString;
          }
          if (str.startsWith(getMiniFolderPath(4)))
          {
            paramString = getMiniFolderPath(4);
            paramString = ((VFSFile)localObject).getAbsolutePath().replace(paramString, "");
            return WXFILE_PREFIX_PRE_CACHE + paramString;
          }
          if (new VFSFile(paramString).exists()) {
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
      l3 = FileUtils.getFileOrFolderSize(getMiniFolderPath(i));
      if (!this.apkgInfo.isEngineTypeMiniGame()) {
        break label223;
      }
    }
    label223:
    for (long l1 = 52428800L;; l1 = 10485760L)
    {
      long l2 = l1;
      if (paramInt == 2)
      {
        l2 = l1;
        if (this.apkgInfo.appConfig.config.usrFileSizeLimit > 0L)
        {
          l2 = this.apkgInfo.appConfig.config.usrFileSizeLimit;
          QLog.d("MiniAppFileManager", 1, "isFolderCanWrite usrFileSizeLimit : " + l2);
        }
      }
      bool1 = bool2;
      if (l3 + paramLong <= l2) {
        break;
      }
      if (this.apkgInfo.isEngineTypeMiniGame()) {
        MiniGameStorageExceedManager.showStorageExceedDialog(this.activityWeakReference, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.apkgInfo.appConfig.config);
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
      paramString = new VFSFile(this.apkgInfo.getFilePath(paramString));
      boolean bool1 = bool2;
      if (paramString.exists())
      {
        boolean bool3 = bduw.b(paramString.getPath()).startsWith(bduw.b(new VFSFile(this.apkgInfo.getApkgFolderPath()).getPath()));
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
    if (new VFSFile(str).exists())
    {
      paramString = getFileName(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (FileUtils.copyFile(str, new VFSFile(getMiniFolderPath(1), paramString).getAbsolutePath())) {
        return MiniAppGlobal.STR_WXFILE + "store" + "_" + paramString;
      }
    }
    return null;
  }
  
  public void setBaseActivity(Activity paramActivity)
  {
    this.activityWeakReference = new WeakReference(paramActivity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */