package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.manager.MiniGameStorageExceedManager;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MiniAppFileManager
  implements IMiniAppFileManager
{
  public static final String DEFAULT_MINIAPP_FILE_STR = "wxfile://";
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
  private static final long MINI_GAME_STORAGE_MAX_SIZE = 52428800L;
  private static String TAG = "MiniAppFileManager";
  public static final String WXFILE_PREFIX_PRE_CACHE = "wxfile://precache";
  public static final String WXFILE_PREFIX_STORE = "wxfile://store_";
  public static final String WXFILE_PREFIX_TMP = "wxfile://tmp_";
  public static final String WXFILE_PREFIX_USR = "wxfile://usr";
  private static MiniAppFileManager currInstance;
  private static String currentAppId;
  private static String currentAppSdcardDir;
  private static String currentUin;
  private static boolean hasCheckUsrDir;
  private static boolean isNoMediaCreated = false;
  private static final Map<ApkgBaseInfo, MiniAppFileManager> mapMiniAppFileManager = new HashMap();
  private Map<String, String> curWxFileToLocalMap;
  private String currentAppSdcardPath;
  private CountDownLatch initStoreCountDown;
  private CountDownLatch initUsrCountDown;
  private ApkgBaseInfo mApkgBaseInfo;
  private ArrayList<String> mTmpFileNeed2DeleteAsync = new ArrayList();
  private long storageLimit;
  private AtomicLong storeFolderSize = new AtomicLong(0L);
  private AtomicInteger storeUpdateCount = new AtomicInteger(0);
  private AtomicLong usrFolderSize = new AtomicLong(0L);
  private AtomicInteger usrUpdateCount = new AtomicInteger(0);
  
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
  
  private void createApkgResFolder(String paramString)
  {
    try
    {
      int i = paramString.lastIndexOf("/");
      String str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      paramString = new File(str);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e(TAG, "createApkgResFolder error.", paramString);
    }
  }
  
  /* Error */
  private static void createNoMediaInMiniPath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 97	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:isNoMediaCreated	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 144	java/io/File
    //   18: dup
    //   19: invokestatic 185	com/tencent/qqmini/sdk/utils/MiniSDKConst:getMiniCacheFilePath	()Ljava/lang/String;
    //   22: ldc 187
    //   24: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 194	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +15 -> 49
    //   37: aload_2
    //   38: invokevirtual 150	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 153	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 150	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 197	java/io/File:createNewFile	()Z
    //   60: pop
    //   61: iconst_1
    //   62: putstatic 97	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:isNoMediaCreated	Z
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: getstatic 95	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:TAG	Ljava/lang/String;
    //   72: ldc 199
    //   74: aload_1
    //   75: invokestatic 176	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppFileManager.1(this));
  }
  
  private String getAbsoluteRealPath(String paramString)
  {
    if (paramString.startsWith("wxfile://tmp_"))
    {
      paramString = paramString.replace("wxfile://tmp_", "");
      paramString = new File(getMiniFolderPath(0), paramString);
      if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://store_"))
    {
      paramString = paramString.replace("wxfile://store_", "");
      paramString = new File(getMiniFolderPath(1), paramString);
      if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://usr"))
    {
      paramString = paramString.replace("wxfile://usr", "");
      paramString = new File(getMiniFolderPath(2), paramString);
      if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://precache"))
    {
      paramString = paramString.replace("wxfile://precache", "");
      paramString = new File(getMiniFolderPath(4), paramString);
      if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
        return paramString.getAbsolutePath();
      }
    }
    else
    {
      Object localObject1 = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(paramString));
      if ((((File)localObject1).exists()) && (((File)localObject1).getCanonicalPath().startsWith(new File(this.mApkgBaseInfo.getApkgFolderPath()).getCanonicalPath()))) {
        return this.mApkgBaseInfo.getChildFileAbsolutePath(paramString);
      }
      if ((this.mApkgBaseInfo instanceof ApkgInfo))
      {
        localObject1 = ((ApkgInfo)this.mApkgBaseInfo).readApkgToStream(paramString);
        if (localObject1 == null) {
          return "";
        }
        createApkgResFolder(this.mApkgBaseInfo.getChildFileAbsolutePath(paramString));
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        Object localObject2 = new byte[8192];
        for (;;)
        {
          int i = ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, i);
        }
        paramString = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(paramString));
        paramString.setWritable(true);
        localObject2 = new FileOutputStream(paramString);
        ((FileOutputStream)localObject2).write(localByteArrayOutputStream.toByteArray());
        ((FileOutputStream)localObject2).close();
        localByteArrayOutputStream.close();
        ((ByteArrayInputStream)localObject1).close();
        return paramString.getAbsolutePath();
      }
    }
    return "";
  }
  
  private String getCurAppSdcardDir()
  {
    if (this.mApkgBaseInfo != null) {}
    for (String str = this.mApkgBaseInfo.appId;; str = null) {
      return getCurAppSdcardDir(str);
    }
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    if (LoginManager.getInstance().getAccount() != null) {}
    for (String str = LoginManager.getInstance().getAccount(); (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)); str = "")
    {
      QMLog.e(TAG, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + paramString);
      return MiniSDKConst.getMiniCacheFilePath();
    }
    if ((str.equals(currentUin)) && (paramString.equals(currentAppId)) && (!TextUtils.isEmpty(currentAppSdcardDir))) {
      return currentAppSdcardDir;
    }
    currentAppId = paramString;
    currentUin = str;
    currentAppSdcardDir = MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(paramString) + "/" + MD5Utils.toMD5(str);
    return currentAppSdcardDir;
  }
  
  private String getFileName(String paramString)
  {
    if (paramString.startsWith("wxfile://tmp_")) {
      return paramString.replace("wxfile://tmp_", "");
    }
    if (paramString.startsWith("wxfile://store_")) {
      return paramString.replace("wxfile://store_", "");
    }
    if (paramString.startsWith("wxfile://usr")) {
      return new File(paramString.replace("wxfile://usr", "")).getName();
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
  
  @Deprecated
  public static MiniAppFileManager getInstance()
  {
    return currInstance;
  }
  
  public static String getLocalPathSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.length();
    if (i != 0)
    {
      i = paramString.charAt(i - 1);
      if ((i != 47) && (i != 92) && (i != 46)) {}
    }
    else
    {
      return "";
    }
    i = paramString.lastIndexOf('.');
    if (i <= Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'))) {
      return "";
    }
    return paramString.substring(i + 1).toLowerCase();
  }
  
  public static MiniAppFileManager getMiniAppFileManager(ApkgBaseInfo paramApkgBaseInfo)
  {
    if (paramApkgBaseInfo == null) {
      return null;
    }
    return (MiniAppFileManager)mapMiniAppFileManager.get(paramApkgBaseInfo);
  }
  
  public static MiniAppFileManager getMiniAppFileManager(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = mapMiniAppFileManager.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.equals(((ApkgBaseInfo)localEntry.getKey()).appId)) {
        return (MiniAppFileManager)localEntry.getValue();
      }
    }
    return null;
  }
  
  private String getMiniFolderPath(int paramInt)
  {
    if (this.mApkgBaseInfo != null) {}
    for (String str = this.mApkgBaseInfo.appId;; str = null) {
      return getMiniFolderPath(str, paramInt);
    }
  }
  
  private static String getMiniFolderPath(String paramString, int paramInt)
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
    return getPreCacheFilePath(null, paramString2);
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str = getMiniFolderPath(paramString1, 4);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + File.separator + paramString2;
    }
    return paramString1 + File.separator + paramString3;
  }
  
  private String getRandomFileName()
  {
    return MD5Utils.toMD5(Thread.currentThread().getId() + System.nanoTime());
  }
  
  private static String getSuffixByPath(String paramString)
  {
    if (URLUtil.isNetworkUrl(paramString)) {
      return getUrlPathSuffix(paramString);
    }
    return getLocalPathSuffix(paramString);
  }
  
  private static String getUrlPathSuffix(String paramString)
  {
    String str2 = "";
    try
    {
      str1 = new URL(paramString).getPath();
      paramString = str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        int i;
        QMLog.e(TAG, "getSuffixByPath error", localThrowable);
      }
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
  
  private void initFileSize()
  {
    this.initUsrCountDown = new CountDownLatch(1);
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppFileManager.2(this));
    this.initStoreCountDown = new CountDownLatch(1);
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppFileManager.3(this));
  }
  
  private void renameTmpFolder()
  {
    String str1 = getMiniFolderPath(0);
    String str2 = str1 + "_del_";
    FileUtils.rename(str1, str2);
    this.mTmpFileNeed2DeleteAsync.add(str2);
  }
  
  public void clearAllCache()
  {
    FileUtils.delete(MiniSDKConst.getMiniCacheFilePath(), false);
    this.usrFolderSize.set(0L);
    this.storeFolderSize.set(0L);
    hasCheckUsrDir = false;
  }
  
  public void clearFileCache(String paramString)
  {
    paramString = MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(paramString);
    if (new File(paramString).exists())
    {
      FileUtils.delete(paramString, false);
      this.usrFolderSize.set(0L);
      this.storeFolderSize.set(0L);
    }
    hasCheckUsrDir = false;
  }
  
  /* Error */
  public String copyTmpFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 144	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 144	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: iconst_0
    //   19: invokespecial 128	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   22: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 5
    //   27: aload 4
    //   29: invokevirtual 194	java/io/File:getParentFile	()Ljava/io/File;
    //   32: aload 5
    //   34: invokevirtual 494	java/io/File:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +5 -> 42
    //   40: aload_1
    //   41: areturn
    //   42: new 144	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: aload 4
    //   49: invokestatic 496	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getFileSuffix	(Ljava/io/File;)Ljava/lang/String;
    //   52: invokevirtual 499	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 9
    //   60: sipush 8192
    //   63: newarray byte
    //   65: astore 7
    //   67: new 501	java/io/BufferedInputStream
    //   70: dup
    //   71: new 503	java/io/FileInputStream
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 504	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 4
    //   85: new 509	java/io/BufferedOutputStream
    //   88: dup
    //   89: new 269	java/io/FileOutputStream
    //   92: dup
    //   93: aload 9
    //   95: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: invokespecial 512	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore_1
    //   102: aload_1
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 4
    //   111: aload 7
    //   113: invokevirtual 515	java/io/InputStream:read	([B)I
    //   116: istore_2
    //   117: iload_2
    //   118: iconst_m1
    //   119: if_icmple +77 -> 196
    //   122: aload_1
    //   123: astore 6
    //   125: aload 4
    //   127: astore 5
    //   129: aload_1
    //   130: aload 7
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual 518	java/io/OutputStream:write	([BII)V
    //   137: goto -35 -> 102
    //   140: astore 7
    //   142: aload_1
    //   143: astore 6
    //   145: aload 4
    //   147: astore 5
    //   149: getstatic 95	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:TAG	Ljava/lang/String;
    //   152: ldc_w 520
    //   155: aload 7
    //   157: invokestatic 525	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   160: pop
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 526	java/io/OutputStream:close	()V
    //   169: aload 4
    //   171: ifnull +154 -> 325
    //   174: aload 4
    //   176: invokevirtual 527	java/io/InputStream:close	()V
    //   179: iconst_0
    //   180: istore_2
    //   181: aload 8
    //   183: astore_1
    //   184: iload_2
    //   185: ifeq +9 -> 194
    //   188: aload 9
    //   190: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   193: astore_1
    //   194: aload_1
    //   195: areturn
    //   196: aload_1
    //   197: astore 6
    //   199: aload 4
    //   201: astore 5
    //   203: aload_1
    //   204: invokevirtual 530	java/io/OutputStream:flush	()V
    //   207: iconst_1
    //   208: istore_3
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 526	java/io/OutputStream:close	()V
    //   217: iload_3
    //   218: istore_2
    //   219: aload 4
    //   221: ifnull -40 -> 181
    //   224: aload 4
    //   226: invokevirtual 527	java/io/InputStream:close	()V
    //   229: iload_3
    //   230: istore_2
    //   231: goto -50 -> 181
    //   234: astore_1
    //   235: iload_3
    //   236: istore_2
    //   237: goto -56 -> 181
    //   240: astore_1
    //   241: iconst_0
    //   242: istore_2
    //   243: goto -62 -> 181
    //   246: astore_1
    //   247: aconst_null
    //   248: astore 6
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 6
    //   255: ifnull +8 -> 263
    //   258: aload 6
    //   260: invokevirtual 526	java/io/OutputStream:close	()V
    //   263: aload 4
    //   265: ifnull +8 -> 273
    //   268: aload 4
    //   270: invokevirtual 527	java/io/InputStream:close	()V
    //   273: aload_1
    //   274: athrow
    //   275: astore_1
    //   276: goto -59 -> 217
    //   279: astore_1
    //   280: goto -111 -> 169
    //   283: astore 5
    //   285: goto -22 -> 263
    //   288: astore 4
    //   290: goto -17 -> 273
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 6
    //   297: goto -44 -> 253
    //   300: astore_1
    //   301: aload 5
    //   303: astore 4
    //   305: goto -52 -> 253
    //   308: astore 7
    //   310: aconst_null
    //   311: astore_1
    //   312: aconst_null
    //   313: astore 4
    //   315: goto -173 -> 142
    //   318: astore 7
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -180 -> 142
    //   325: iconst_0
    //   326: istore_2
    //   327: goto -146 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	MiniAppFileManager
    //   0	330	1	paramString	String
    //   116	211	2	i	int
    //   208	28	3	j	int
    //   11	258	4	localObject1	Object
    //   288	1	4	localIOException1	java.io.IOException
    //   303	11	4	localObject2	Object
    //   25	177	5	localObject3	Object
    //   283	19	5	localIOException2	java.io.IOException
    //   103	193	6	str	String
    //   65	66	7	arrayOfByte	byte[]
    //   140	16	7	localIOException3	java.io.IOException
    //   308	1	7	localIOException4	java.io.IOException
    //   318	1	7	localIOException5	java.io.IOException
    //   1	181	8	localObject4	Object
    //   58	131	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   109	117	140	java/io/IOException
    //   129	137	140	java/io/IOException
    //   203	207	140	java/io/IOException
    //   224	229	234	java/io/IOException
    //   174	179	240	java/io/IOException
    //   67	85	246	finally
    //   213	217	275	java/io/IOException
    //   165	169	279	java/io/IOException
    //   258	263	283	java/io/IOException
    //   268	273	288	java/io/IOException
    //   85	102	293	finally
    //   109	117	300	finally
    //   129	137	300	finally
    //   149	161	300	finally
    //   203	207	300	finally
    //   67	85	308	java/io/IOException
    //   85	102	318	java/io/IOException
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
          FileUtils.delete((String)this.mTmpFileNeed2DeleteAsync.get(i), false);
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
      if ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https://")))
      {
        String str1;
        if (this.curWxFileToLocalMap != null)
        {
          String str2 = (String)this.curWxFileToLocalMap.get(paramString);
          str1 = str2;
          if (!TextUtils.isEmpty(str2)) {}
        }
        else
        {
          str1 = paramString;
          if (!paramString.startsWith("wxfile://"))
          {
            if (!paramString.startsWith("wxfile://")) {
              break label104;
            }
            str1 = paramString.replace("wxfile://", "wxfile://");
          }
          for (;;)
          {
            return getAbsoluteRealPath(str1);
            label104:
            str1 = paramString;
            if (paramString.startsWith("qqfile://")) {
              str1 = paramString.replace("qqfile://", "wxfile://");
            }
          }
        }
        return str1;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e(TAG, "getAbsolutePath error.", paramString);
      str1 = "";
    }
    return paramString;
  }
  
  public File[] getSaveFileList()
  {
    File localFile = new File(getMiniFolderPath(1));
    if (localFile.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
      return localFile.listFiles();
    }
    return null;
  }
  
  public String getSaveStorePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while (!new File(getAbsolutePath(paramString)).exists());
      paramString = getFileName(paramString);
    } while (TextUtils.isEmpty(paramString));
    return new File(getMiniFolderPath(1), paramString).getAbsolutePath();
  }
  
  public String getTmpPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "." + paramString)
    {
      paramString = getRandomFileName() + paramString;
      File localFile = new File(getMiniFolderPath(0));
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, paramString).getAbsolutePath();
    }
  }
  
  public String getTmpPathByUrl(String paramString)
  {
    return getTmpPath(getSuffixByPath(paramString));
  }
  
  public String getUsrPath(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramString.startsWith("wxfile://usr"))
      {
        paramString = paramString.replace("wxfile://usr", "");
        paramString = new File(getMiniFolderPath(this.mApkgBaseInfo.appId, 2), paramString);
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
      QMLog.e(TAG, "getUsrPath error", paramString);
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
            return "wxfile://" + (String)localObject + "_" + paramString;
          }
        }
        else
        {
          if (str.startsWith(getMiniFolderPath(2)))
          {
            paramString = getMiniFolderPath(2);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return "wxfile://usr" + paramString;
          }
          if (str.startsWith(getMiniFolderPath(4)))
          {
            paramString = getMiniFolderPath(4);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return "wxfile://precache" + paramString;
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
      str = "wxfile://" + "tmp" + "_" + getRandomFileName() + str;
      this.curWxFileToLocalMap.put(str, paramString);
      return str;
    }
  }
  
  public int getWxFileType(String paramString)
  {
    if (paramString.startsWith("wxfile://tmp_")) {
      return 0;
    }
    if (paramString.startsWith("wxfile://store_")) {
      return 1;
    }
    if (paramString.startsWith("wxfile://precache")) {
      return 4;
    }
    if (paramString.startsWith("wxfile://usr")) {
      return 2;
    }
    return 9999;
  }
  
  public void initFileManager(ApkgBaseInfo paramApkgBaseInfo, boolean paramBoolean)
  {
    mapMiniAppFileManager.put(paramApkgBaseInfo, this);
    currInstance = this;
    updateCurApkgInfo(paramApkgBaseInfo);
    if (paramBoolean) {
      renameTmpFolder();
    }
    for (;;)
    {
      this.currentAppSdcardPath = null;
      this.currentAppSdcardPath = getCurAppSdcardDir();
      initFileSize();
      return;
      deleteTmpFolder();
    }
  }
  
  public boolean isFolderCanWrite(int paramInt, long paramLong, boolean paramBoolean, MiniAppInfo paramMiniAppInfo, Activity paramActivity)
  {
    if ((paramInt != 2) && (paramInt != 1)) {
      return true;
    }
    if (paramLong <= 0L) {
      return true;
    }
    long l4 = System.currentTimeMillis();
    long l2;
    if (paramInt == 1)
    {
      l2 = this.storeFolderSize.get();
      if (!paramBoolean) {
        break label201;
      }
    }
    label201:
    for (long l1 = 52428800L;; l1 = 10485760L)
    {
      long l3 = l1;
      if (paramInt == 2)
      {
        l3 = l1;
        if (this.storageLimit > 0L) {
          l3 = this.storageLimit;
        }
      }
      QMLog.d(TAG, "isFolderCanWrite usrFileSizeLimit : " + l3 + " size used : " + l2);
      if (l2 + paramLong <= l3) {
        break label209;
      }
      if (paramBoolean) {
        MiniGameStorageExceedManager.showStorageExceedDialog(new WeakReference(paramActivity), LoginManager.getInstance().getAccount(), paramMiniAppInfo);
      }
      QMLog.i(TAG, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - l4) + "ms ]");
      return false;
      l2 = this.usrFolderSize.get();
      break;
    }
    label209:
    QMLog.i(TAG, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - l4) + "ms ]");
    return true;
  }
  
  public boolean isPackageRelativePath(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(paramString));
      boolean bool1 = bool2;
      if (paramString.exists())
      {
        boolean bool3 = paramString.getCanonicalPath().startsWith(new File(this.mApkgBaseInfo.getApkgFolderPath()).getCanonicalPath());
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
    } while (paramString.startsWith("wxfile://store_"));
    String str = getAbsolutePath(paramString);
    if (new File(str).exists())
    {
      paramString = getFileName(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (FileUtils.copyFile(str, new File(getMiniFolderPath(1), paramString).getAbsolutePath())) {
        return "wxfile://" + "store" + "_" + paramString;
      }
    }
    return null;
  }
  
  public void setStorageLimit(long paramLong)
  {
    this.storageLimit = paramLong;
  }
  
  public void updateCurApkgInfo(ApkgBaseInfo paramApkgBaseInfo)
  {
    this.mApkgBaseInfo = paramApkgBaseInfo;
    if (this.curWxFileToLocalMap == null) {
      this.curWxFileToLocalMap = new HashMap();
    }
  }
  
  public void updateFolderSize(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      if (this.initStoreCountDown == null) {}
    }
    long l;
    while (paramInt != 2) {
      try
      {
        this.initStoreCountDown.await();
        if (this.storeUpdateCount.incrementAndGet() % 100 == 0)
        {
          paramLong = FileUtils.getFileOrFolderSize(getMiniFolderPath(1));
          this.storeFolderSize.set(paramLong);
          QMLog.i(TAG, "updateFolderSize fileType=store realSize=" + paramLong);
          return;
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        for (;;)
        {
          localInterruptedException1.printStackTrace();
        }
        l = this.storeFolderSize.addAndGet(paramLong);
        QMLog.i(TAG, "updateFolderSize fileType=store delta=" + paramLong + " size=" + l);
        return;
      }
    }
    if (this.initUsrCountDown != null) {}
    try
    {
      this.initUsrCountDown.await();
      if (this.usrUpdateCount.incrementAndGet() % 100 == 0)
      {
        paramLong = FileUtils.getFileOrFolderSize(getMiniFolderPath(2));
        this.usrFolderSize.set(paramLong);
        QMLog.i(TAG, "updateFolderSize fileType=usr realSize=" + paramLong);
        return;
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        localInterruptedException2.printStackTrace();
      }
      l = this.usrFolderSize.addAndGet(paramLong);
      QMLog.i(TAG, "updateFolderSize fileType=usr delta=" + paramLong + " size=" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */