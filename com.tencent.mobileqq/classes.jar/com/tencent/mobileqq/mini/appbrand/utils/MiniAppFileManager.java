package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class MiniAppFileManager
{
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
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
  public static final String MINI_FILE_ROOT_PATH = getExternalPath() + "/tencent/mini/";
  public static final String MINI_FILE_SAVE_PATH = MINI_FILE_ROOT_PATH + "files/";
  private static final String MINI_FILE_SUB_NAME = "files/";
  private static final long MINI_GAME_STORAGE_MAX_SIZE = 52428800L;
  private static final String MINI_LOADING_AD_NAME = "adcache/";
  private static final String TAG = "MiniAppFileManager";
  public static final String WXFILE_PREFIX_PRE_CACHE;
  public static final String WXFILE_PREFIX_STORE;
  public static final String WXFILE_PREFIX_TMP = MiniAppGlobal.STR_WXFILE + "tmp_";
  public static final String WXFILE_PREFIX_USR;
  private static String currentAppId;
  private static String currentAppSdcardDir;
  private static String currentUin;
  private static boolean hasCheckUsrDir;
  private static boolean isNoMediaCreated;
  private static volatile MiniAppFileManager sInstance;
  private WeakReference<Activity> activityWeakReference;
  private ApkgBaseInfo apkgInfo;
  private String curMiniAppId;
  private ConcurrentHashMap<String, String> curWxFileToLocalMap;
  private String currentAppSdcardPath = "";
  private CountDownLatch initStoreCountDown;
  private CountDownLatch initUsrCountDown;
  private ArrayList<String> mTmpFileNeed2DeleteAsync = new ArrayList();
  private AtomicLong storeFolderSize = new AtomicLong(0L);
  private AtomicInteger storeUpdateCount = new AtomicInteger(0);
  private AtomicLong usrFolderSize = new AtomicLong(0L);
  private AtomicInteger usrUpdateCount = new AtomicInteger(0);
  
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
    //   3: getstatic 190	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 176	java/io/File
    //   18: dup
    //   19: getstatic 125	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:MINI_FILE_SAVE_PATH	Ljava/lang/String;
    //   22: ldc 192
    //   24: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +15 -> 49
    //   37: aload_2
    //   38: invokevirtual 182	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 185	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 182	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 202	java/io/File:createNewFile	()Z
    //   60: pop
    //   61: iconst_1
    //   62: putstatic 190	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:isNoMediaCreated	Z
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: ldc 204
    //   71: iconst_1
    //   72: ldc 206
    //   74: aload_1
    //   75: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    FileUtils.delete(getMiniFolderPath(0), false);
  }
  
  private String getCurAppSdcardDir()
  {
    if (!TextUtils.isEmpty(this.currentAppSdcardPath)) {
      return this.currentAppSdcardPath;
    }
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.curMiniAppId)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + this.curMiniAppId);
      return MINI_FILE_SAVE_PATH;
    }
    return MINI_FILE_SAVE_PATH + MD5Utils.toMD5(this.curMiniAppId) + "/" + MD5Utils.toMD5(str);
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("MiniAppFileManager", 1, "getCurAppSdcardDir error. uin : " + str + "; curMiniAppId : " + paramString);
      return MINI_FILE_SAVE_PATH;
    }
    if ((str.equals(currentUin)) && (paramString.equals(currentAppId)) && (!TextUtils.isEmpty(currentAppSdcardDir))) {
      return currentAppSdcardDir;
    }
    currentAppId = paramString;
    currentUin = str;
    currentAppSdcardDir = MINI_FILE_SAVE_PATH + MD5Utils.toMD5(paramString) + "/" + MD5Utils.toMD5(str);
    return currentAppSdcardDir;
  }
  
  private static String getExternalPath()
  {
    Object localObject3 = null;
    try
    {
      Object localObject1 = BaseApplicationImpl.getContext().getExternalCacheDir();
      if (localObject1 != null)
      {
        QLog.e("MiniAppFileManager", 1, "getExternalPath : " + ((File)localObject1).getParent());
        localObject1 = ((File)localObject1).getParent();
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          localObject2 = null;
        }
        localObject2 = localObject3;
      } while (!"mounted".equals(Environment.getExternalStorageState()));
      Object localObject2 = Environment.getExternalStorageDirectory();
      if (localObject2 != null)
      {
        QLog.e("MiniAppFileManager", 1, "getExternalPath1 : " + ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/");
        return ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/";
      }
      localObject2 = BaseApplicationImpl.getContext().getFilesDir();
      if (localObject2 != null)
      {
        QLog.e("MiniAppFileManager", 1, "getExternalPath2 : " + ((File)localObject2).getParent());
        return ((File)localObject2).getParent();
      }
      QLog.e("MiniAppFileManager", 1, "getExternalPath3 : /data/data/com.tencent.mobileqq/");
    }
    return "/data/data/com.tencent.mobileqq/";
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
  
  public static String getLoadingAdCacheFilePath(String paramString1, String paramString2)
  {
    return getLoadingAdCacheFolder() + MD5Utils.toMD5(paramString1) + "_" + MD5Utils.toMD5(paramString2);
  }
  
  public static String getLoadingAdCacheFolder()
  {
    return MINI_FILE_SAVE_PATH + "adcache/";
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
    paramString2 = new File(str1, paramString3);
    try
    {
      if (paramString2.getCanonicalPath().startsWith(getCurAppSdcardDir(paramString1)))
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
  
  private String getRandomFileName()
  {
    return MD5.toMD5(Thread.currentThread().getId() + System.nanoTime());
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
        QMLog.e("MiniAppFileManager", "getSuffixByPath error", localThrowable);
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
    ThreadPools.getDiskIOThreadPool().execute(new MiniAppFileManager.1(this));
    this.initStoreCountDown = new CountDownLatch(1);
    ThreadPools.getDiskIOThreadPool().execute(new MiniAppFileManager.2(this));
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
    FileUtils.delete(MiniAppGlobal.getMiniCacheFilePath(), false);
    this.usrFolderSize.set(0L);
    this.storeFolderSize.set(0L);
    hasCheckUsrDir = false;
  }
  
  public void clearFileCache(String paramString)
  {
    paramString = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(paramString);
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
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: new 176	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: new 176	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: iconst_0
    //   21: invokespecial 160	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   24: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   30: astore 5
    //   32: aload 4
    //   34: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   37: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   40: aload 5
    //   42: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +31 -> 76
    //   48: ldc 52
    //   50: iconst_1
    //   51: new 90	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 482
    //   61: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: areturn
    //   76: new 176	java/io/File
    //   79: dup
    //   80: aload_0
    //   81: aload 4
    //   83: invokestatic 484	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getFileSuffix	(Ljava/io/File;)Ljava/lang/String;
    //   86: invokevirtual 487	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 9
    //   94: sipush 8192
    //   97: newarray byte
    //   99: astore 7
    //   101: new 489	java/io/BufferedInputStream
    //   104: dup
    //   105: new 491	java/io/FileInputStream
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 494	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: invokespecial 497	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   117: astore 4
    //   119: new 499	java/io/BufferedOutputStream
    //   122: dup
    //   123: new 501	java/io/FileOutputStream
    //   126: dup
    //   127: aload 9
    //   129: invokespecial 502	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: invokespecial 505	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore_1
    //   136: aload_1
    //   137: astore 6
    //   139: aload 4
    //   141: astore 5
    //   143: aload 4
    //   145: aload 7
    //   147: invokevirtual 511	java/io/InputStream:read	([B)I
    //   150: istore_2
    //   151: iload_2
    //   152: iconst_m1
    //   153: if_icmple +76 -> 229
    //   156: aload_1
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: aload_1
    //   164: aload 7
    //   166: iconst_0
    //   167: iload_2
    //   168: invokevirtual 517	java/io/OutputStream:write	([BII)V
    //   171: goto -35 -> 136
    //   174: astore 7
    //   176: aload_1
    //   177: astore 6
    //   179: aload 4
    //   181: astore 5
    //   183: ldc 52
    //   185: ldc_w 519
    //   188: aload 7
    //   190: invokestatic 524	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   193: pop
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 527	java/io/OutputStream:close	()V
    //   202: aload 4
    //   204: ifnull +152 -> 356
    //   207: aload 4
    //   209: invokevirtual 528	java/io/InputStream:close	()V
    //   212: iconst_0
    //   213: istore_2
    //   214: aload 8
    //   216: astore_1
    //   217: iload_2
    //   218: ifeq +9 -> 227
    //   221: aload 9
    //   223: invokevirtual 391	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   226: astore_1
    //   227: aload_1
    //   228: areturn
    //   229: aload_1
    //   230: astore 6
    //   232: aload 4
    //   234: astore 5
    //   236: aload_1
    //   237: invokevirtual 531	java/io/OutputStream:flush	()V
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 527	java/io/OutputStream:close	()V
    //   248: iload_3
    //   249: istore_2
    //   250: aload 4
    //   252: ifnull -38 -> 214
    //   255: aload 4
    //   257: invokevirtual 528	java/io/InputStream:close	()V
    //   260: iload_3
    //   261: istore_2
    //   262: goto -48 -> 214
    //   265: astore_1
    //   266: iload_3
    //   267: istore_2
    //   268: goto -54 -> 214
    //   271: astore_1
    //   272: iconst_0
    //   273: istore_2
    //   274: goto -60 -> 214
    //   277: astore_1
    //   278: aconst_null
    //   279: astore 6
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 6
    //   286: ifnull +8 -> 294
    //   289: aload 6
    //   291: invokevirtual 527	java/io/OutputStream:close	()V
    //   294: aload 4
    //   296: ifnull +8 -> 304
    //   299: aload 4
    //   301: invokevirtual 528	java/io/InputStream:close	()V
    //   304: aload_1
    //   305: athrow
    //   306: astore_1
    //   307: goto -59 -> 248
    //   310: astore_1
    //   311: goto -109 -> 202
    //   314: astore 5
    //   316: goto -22 -> 294
    //   319: astore 4
    //   321: goto -17 -> 304
    //   324: astore_1
    //   325: aconst_null
    //   326: astore 6
    //   328: goto -44 -> 284
    //   331: astore_1
    //   332: aload 5
    //   334: astore 4
    //   336: goto -52 -> 284
    //   339: astore 7
    //   341: aconst_null
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 4
    //   346: goto -170 -> 176
    //   349: astore 7
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -177 -> 176
    //   356: iconst_0
    //   357: istore_2
    //   358: goto -144 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	MiniAppFileManager
    //   0	361	1	paramString	String
    //   150	208	2	i	int
    //   1	266	3	j	int
    //   13	287	4	localObject1	Object
    //   319	1	4	localIOException1	java.io.IOException
    //   334	11	4	localObject2	Object
    //   30	205	5	localObject3	Object
    //   314	19	5	localIOException2	java.io.IOException
    //   137	190	6	str	String
    //   99	66	7	arrayOfByte	byte[]
    //   174	15	7	localIOException3	java.io.IOException
    //   339	1	7	localIOException4	java.io.IOException
    //   349	1	7	localIOException5	java.io.IOException
    //   3	212	8	localObject4	Object
    //   92	130	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   143	151	174	java/io/IOException
    //   163	171	174	java/io/IOException
    //   236	240	174	java/io/IOException
    //   255	260	265	java/io/IOException
    //   207	212	271	java/io/IOException
    //   101	119	277	finally
    //   244	248	306	java/io/IOException
    //   198	202	310	java/io/IOException
    //   289	294	314	java/io/IOException
    //   299	304	319	java/io/IOException
    //   119	136	324	finally
    //   143	151	331	finally
    //   163	171	331	finally
    //   183	194	331	finally
    //   236	240	331	finally
    //   101	119	339	java/io/IOException
    //   119	136	349	java/io/IOException
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
  
  public String getTmpPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = "";; paramString2 = "." + paramString2)
    {
      paramString2 = getRandomFileName() + paramString2;
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
      str = MiniAppGlobal.STR_WXFILE + "tmp" + "_" + getRandomFileName() + str;
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
  
  public boolean isFolderCanWrite(int paramInt, long paramLong)
  {
    long l4 = System.currentTimeMillis();
    if ((this.apkgInfo == null) || (this.apkgInfo.appConfig == null) || (this.apkgInfo.appConfig.config == null))
    {
      QLog.w("[mini] ", 1, "check isFolderCanWrite on null apkgInfo or  null apkgInfo.appConfig or null apkgInfo.appConfig.config");
      return false;
    }
    if (paramLong > 0L)
    {
      long l2;
      if (paramInt == 1)
      {
        l2 = this.storeFolderSize.get();
        if (!this.apkgInfo.isEngineTypeMiniGame()) {
          break label262;
        }
      }
      label262:
      for (long l1 = 52428800L;; l1 = 10485760L)
      {
        long l3 = l1;
        if (paramInt == 2)
        {
          l3 = l1;
          if (this.apkgInfo.appConfig.config.usrFileSizeLimit > 0L) {
            l3 = this.apkgInfo.appConfig.config.usrFileSizeLimit;
          }
        }
        QLog.d("MiniAppFileManager", 1, "isFolderCanWrite usrFileSizeLimit : " + l3 + " size used : " + l2);
        if (l2 + paramLong <= l3) {
          break label270;
        }
        if (this.apkgInfo.isEngineTypeMiniGame()) {
          MiniGameStorageExceedManager.showStorageExceedDialog(this.activityWeakReference, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.apkgInfo.appConfig.config);
        }
        QLog.i("MiniAppFileManager", 1, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - l4) + "ms ]");
        return false;
        l2 = this.usrFolderSize.get();
        break;
      }
    }
    label270:
    QLog.i("MiniAppFileManager", 1, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - l4) + "ms ]");
    return true;
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
      if (FileUtils.copyFile(str, new File(getMiniFolderPath(1), paramString).getAbsolutePath())) {
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
          QLog.i("MiniAppFileManager", 1, "updateFolderSize fileType=store realSize=" + paramLong);
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
        QLog.i("MiniAppFileManager", 1, "updateFolderSize fileType=store delta=" + paramLong + " size=" + l);
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
        QLog.i("MiniAppFileManager", 1, "updateFolderSize fileType=usr realSize=" + paramLong);
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
      QLog.i("MiniAppFileManager", 1, "updateFolderSize fileType=usr delta=" + paramLong + " size=" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */