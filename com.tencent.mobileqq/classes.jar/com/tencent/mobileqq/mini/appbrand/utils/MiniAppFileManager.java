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
import java.io.IOException;
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
  public static final String MINI_FILE_ROOT_PATH;
  public static final String MINI_FILE_SAVE_PATH;
  private static final String MINI_FILE_SUB_NAME = "files/";
  private static final long MINI_GAME_STORAGE_MAX_SIZE = 52428800L;
  private static final String MINI_LOADING_AD_NAME = "adcache/";
  private static final String TAG = "MiniAppFileManager";
  public static final String WXFILE_PREFIX_PRE_CACHE;
  public static final String WXFILE_PREFIX_STORE;
  public static final String WXFILE_PREFIX_TMP;
  public static final String WXFILE_PREFIX_USR;
  private static String currentAppId;
  private static String currentAppSdcardDir;
  private static String currentUin;
  private static boolean hasCheckUsrDir;
  private static boolean isNoMediaCreated = false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.STR_WXFILE);
    localStringBuilder.append("tmp_");
    WXFILE_PREFIX_TMP = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.STR_WXFILE);
    localStringBuilder.append("store_");
    WXFILE_PREFIX_STORE = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.STR_WXFILE);
    localStringBuilder.append("usr");
    WXFILE_PREFIX_USR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.STR_WXFILE);
    localStringBuilder.append("precache");
    WXFILE_PREFIX_PRE_CACHE = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getExternalPath());
    localStringBuilder.append("/tencent/mini/");
    MINI_FILE_ROOT_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MINI_FILE_ROOT_PATH);
    localStringBuilder.append("files/");
    MINI_FILE_SAVE_PATH = localStringBuilder.toString();
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
  
  private static void createNoMediaInMiniPath()
  {
    try
    {
      boolean bool = isNoMediaCreated;
      if (bool) {
        return;
      }
      File localFile1 = new File(MINI_FILE_SAVE_PATH, ".nomedia");
      try
      {
        File localFile2 = localFile1.getParentFile();
        if ((localFile2 != null) && (!localFile2.exists())) {
          localFile2.mkdirs();
        }
        if (!localFile1.exists()) {
          localFile1.createNewFile();
        }
        isNoMediaCreated = true;
      }
      catch (IOException localIOException)
      {
        QLog.e("[mini] ", 1, "exception in create .nomedia of mini files", localIOException);
      }
      return;
    }
    finally {}
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(this.curMiniAppId)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MINI_FILE_SAVE_PATH);
      localStringBuilder.append(MD5Utils.toMD5(this.curMiniAppId));
      localStringBuilder.append("/");
      localStringBuilder.append(MD5Utils.toMD5((String)localObject));
      return localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurAppSdcardDir error. curMiniAppId : ");
    ((StringBuilder)localObject).append(this.curMiniAppId);
    QLog.e("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
    return MINI_FILE_SAVE_PATH;
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
    {
      if ((((String)localObject).equals(currentUin)) && (paramString.equals(currentAppId)) && (!TextUtils.isEmpty(currentAppSdcardDir))) {
        return currentAppSdcardDir;
      }
      currentAppId = paramString;
      currentUin = (String)localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MINI_FILE_SAVE_PATH);
      localStringBuilder.append(MD5Utils.toMD5(paramString));
      localStringBuilder.append("/");
      localStringBuilder.append(MD5Utils.toMD5((String)localObject));
      currentAppSdcardDir = localStringBuilder.toString();
      return currentAppSdcardDir;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurAppSdcardDir error. curMiniAppId : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
    return MINI_FILE_SAVE_PATH;
  }
  
  private static String getExternalPath()
  {
    StringBuilder localStringBuilder = null;
    try
    {
      localObject = BaseApplicationImpl.getContext().getExternalCacheDir();
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label12:
      break label12;
    }
    localObject = null;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExternalPath : ");
      localStringBuilder.append(((File)localObject).getParent());
      QLog.e("MiniAppFileManager", 1, localStringBuilder.toString());
      return ((File)localObject).getParent();
    }
    localObject = localStringBuilder;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject = Environment.getExternalStorageDirectory();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getExternalPath1 : ");
        localStringBuilder.append(((File)localObject).getPath());
        localStringBuilder.append("/Android/data/com.tencent.mobileqq/");
        QLog.e("MiniAppFileManager", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getPath());
        localStringBuilder.append("/Android/data/com.tencent.mobileqq/");
        return localStringBuilder.toString();
      }
      localObject = BaseApplicationImpl.getContext().getFilesDir();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getExternalPath2 : ");
        localStringBuilder.append(((File)localObject).getParent());
        QLog.e("MiniAppFileManager", 1, localStringBuilder.toString());
        return ((File)localObject).getParent();
      }
      QLog.e("MiniAppFileManager", 1, "getExternalPath3 : /data/data/com.tencent.mobileqq/");
      localObject = "/data/data/com.tencent.mobileqq/";
    }
    return localObject;
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniAppFileManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static String getLoadingAdCacheFilePath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLoadingAdCacheFolder());
    localStringBuilder.append(MD5Utils.toMD5(paramString1));
    localStringBuilder.append("_");
    localStringBuilder.append(MD5Utils.toMD5(paramString2));
    return localStringBuilder.toString();
  }
  
  public static String getLoadingAdCacheFolder()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MINI_FILE_SAVE_PATH);
    localStringBuilder.append("adcache/");
    return localStringBuilder.toString();
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
      if ((i != 47) && (i != 92))
      {
        if (i == 46) {
          return "";
        }
        i = paramString.lastIndexOf('.');
        if (i <= Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'))) {
          return "";
        }
        return paramString.substring(i + 1).toLowerCase();
      }
    }
    return "";
  }
  
  private String getMiniFolderPath(int paramInt)
  {
    Object localObject2 = "tmp";
    Object localObject1 = localObject2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            localObject1 = localObject2;
          } else {
            localObject1 = "precache";
          }
        }
        else {
          localObject1 = "usr";
        }
      }
      else {
        localObject1 = "store";
      }
    }
    createNoMediaInMiniPath();
    localObject2 = new StringBuilder(getCurAppSdcardDir());
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    if (paramInt == 2) {
      checkUsrDir((String)localObject1);
    }
    return localObject1;
  }
  
  private static String getMiniFolderPath(int paramInt, String paramString)
  {
    String str2 = "tmp";
    String str1 = str2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            str1 = str2;
          } else {
            str1 = "precache";
          }
        }
        else {
          str1 = "usr";
        }
      }
      else {
        str1 = "store";
      }
    }
    createNoMediaInMiniPath();
    paramString = new StringBuilder(getCurAppSdcardDir(paramString));
    paramString.append("/");
    paramString.append(str1);
    paramString = paramString.toString();
    if (paramInt == 2) {
      checkUsrDir(paramString);
    }
    return paramString;
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2)
  {
    return getPreCacheFilePath(paramString1, null, paramString2);
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str = getMiniFolderPath(4, paramString1);
    Object localObject = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new File((String)localObject, paramString3);
    try
    {
      if (paramString2.getCanonicalPath().startsWith(getCurAppSdcardDir(paramString1)))
      {
        paramString1 = paramString2.getAbsolutePath();
        return paramString1;
      }
      return null;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppFileManager", 1, "getUsrPath error", paramString1);
    }
    return null;
  }
  
  private String getRandomFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append(System.nanoTime());
    return MD5.toMD5(localStringBuilder.toString());
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
    try
    {
      String str = new URL(paramString).getPath();
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppFileManager", "getSuffixByPath error", localThrowable);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".");
      if (i != -1)
      {
        i += 1;
        if (i < paramString.length()) {
          return paramString.substring(i);
        }
      }
    }
    return "";
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
    String str = getMiniFolderPath(0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_del_");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.rename(str, (String)localObject);
    this.mTmpFileNeed2DeleteAsync.add(localObject);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniAppGlobal.getMiniCacheFilePath());
    localStringBuilder.append(MD5.toMD5(paramString));
    paramString = localStringBuilder.toString();
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
    //   0: new 178	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: iconst_0
    //   11: istore_3
    //   12: new 178	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: iconst_0
    //   18: invokespecial 162	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   21: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 299	java/io/File:getPath	()Ljava/lang/String;
    //   27: astore 5
    //   29: aload 4
    //   31: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   34: invokevirtual 299	java/io/File:getPath	()Ljava/lang/String;
    //   37: aload 5
    //   39: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +41 -> 83
    //   45: new 90	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc_w 480
    //   59: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: aload_1
    //   66: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 52
    //   72: iconst_1
    //   73: aload 4
    //   75: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_1
    //   82: areturn
    //   83: new 178	java/io/File
    //   86: dup
    //   87: aload_0
    //   88: aload 4
    //   90: invokestatic 482	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getFileSuffix	(Ljava/io/File;)Ljava/lang/String;
    //   93: invokevirtual 485	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 9
    //   101: sipush 8192
    //   104: newarray byte
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 5
    //   111: aconst_null
    //   112: astore 8
    //   114: new 487	java/io/BufferedInputStream
    //   117: dup
    //   118: new 489	java/io/FileInputStream
    //   121: dup
    //   122: aload 4
    //   124: invokespecial 492	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   127: invokespecial 495	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   130: astore 4
    //   132: new 497	java/io/BufferedOutputStream
    //   135: dup
    //   136: new 499	java/io/FileOutputStream
    //   139: dup
    //   140: aload 9
    //   142: invokespecial 500	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   145: invokespecial 503	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   148: astore_1
    //   149: aload_1
    //   150: astore 6
    //   152: aload 4
    //   154: astore 5
    //   156: aload 4
    //   158: aload 7
    //   160: invokevirtual 509	java/io/InputStream:read	([B)I
    //   163: istore_2
    //   164: iload_2
    //   165: iconst_m1
    //   166: if_icmple +21 -> 187
    //   169: aload_1
    //   170: astore 6
    //   172: aload 4
    //   174: astore 5
    //   176: aload_1
    //   177: aload 7
    //   179: iconst_0
    //   180: iload_2
    //   181: invokevirtual 515	java/io/OutputStream:write	([BII)V
    //   184: goto -35 -> 149
    //   187: aload_1
    //   188: astore 6
    //   190: aload 4
    //   192: astore 5
    //   194: aload_1
    //   195: invokevirtual 518	java/io/OutputStream:flush	()V
    //   198: aload_1
    //   199: invokevirtual 521	java/io/OutputStream:close	()V
    //   202: aload 4
    //   204: invokevirtual 522	java/io/InputStream:close	()V
    //   207: iconst_1
    //   208: istore_2
    //   209: goto +76 -> 285
    //   212: astore 7
    //   214: goto +28 -> 242
    //   217: astore_1
    //   218: goto +91 -> 309
    //   221: astore 7
    //   223: aconst_null
    //   224: astore_1
    //   225: goto +17 -> 242
    //   228: astore_1
    //   229: aconst_null
    //   230: astore 4
    //   232: goto +77 -> 309
    //   235: astore 7
    //   237: aconst_null
    //   238: astore_1
    //   239: aload_1
    //   240: astore 4
    //   242: aload_1
    //   243: astore 6
    //   245: aload 4
    //   247: astore 5
    //   249: ldc 52
    //   251: ldc_w 524
    //   254: aload 7
    //   256: invokestatic 529	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   259: pop
    //   260: aload_1
    //   261: ifnull +10 -> 271
    //   264: aload_1
    //   265: invokevirtual 521	java/io/OutputStream:close	()V
    //   268: goto +3 -> 271
    //   271: iload_3
    //   272: istore_2
    //   273: aload 4
    //   275: ifnull +10 -> 285
    //   278: aload 4
    //   280: invokevirtual 522	java/io/InputStream:close	()V
    //   283: iload_3
    //   284: istore_2
    //   285: aload 8
    //   287: astore_1
    //   288: iload_2
    //   289: ifeq +9 -> 298
    //   292: aload 9
    //   294: invokevirtual 389	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   297: astore_1
    //   298: aload_1
    //   299: areturn
    //   300: astore_1
    //   301: aload 5
    //   303: astore 4
    //   305: aload 6
    //   307: astore 5
    //   309: aload 5
    //   311: ifnull +11 -> 322
    //   314: aload 5
    //   316: invokevirtual 521	java/io/OutputStream:close	()V
    //   319: goto +3 -> 322
    //   322: aload 4
    //   324: ifnull +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 522	java/io/InputStream:close	()V
    //   332: goto +5 -> 337
    //   335: aload_1
    //   336: athrow
    //   337: goto -2 -> 335
    //   340: astore_1
    //   341: goto -139 -> 202
    //   344: astore_1
    //   345: goto -138 -> 207
    //   348: astore_1
    //   349: goto -78 -> 271
    //   352: astore_1
    //   353: iload_3
    //   354: istore_2
    //   355: goto -70 -> 285
    //   358: astore 5
    //   360: goto -38 -> 322
    //   363: astore 4
    //   365: goto -33 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	MiniAppFileManager
    //   0	368	1	paramString	String
    //   163	192	2	i	int
    //   11	343	3	j	int
    //   8	320	4	localObject1	Object
    //   363	1	4	localIOException1	IOException
    //   27	288	5	localObject2	Object
    //   358	1	5	localIOException2	IOException
    //   150	156	6	str	String
    //   106	72	7	arrayOfByte	byte[]
    //   212	1	7	localIOException3	IOException
    //   221	1	7	localIOException4	IOException
    //   235	20	7	localIOException5	IOException
    //   112	174	8	localObject3	Object
    //   99	194	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   156	164	212	java/io/IOException
    //   176	184	212	java/io/IOException
    //   194	198	212	java/io/IOException
    //   132	149	217	finally
    //   132	149	221	java/io/IOException
    //   114	132	228	finally
    //   114	132	235	java/io/IOException
    //   156	164	300	finally
    //   176	184	300	finally
    //   194	198	300	finally
    //   249	260	300	finally
    //   198	202	340	java/io/IOException
    //   202	207	344	java/io/IOException
    //   264	268	348	java/io/IOException
    //   278	283	352	java/io/IOException
    //   314	319	358	java/io/IOException
    //   327	332	363	java/io/IOException
  }
  
  public void deleteTmpFileNeed2DeleteAsync()
  {
    ??? = this.mTmpFileNeed2DeleteAsync;
    if ((??? != null) && (???.size() > 0))
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
      if (!paramString.toLowerCase().startsWith("http://"))
      {
        if (paramString.toLowerCase().startsWith("https://")) {
          return paramString;
        }
        if (this.curWxFileToLocalMap != null)
        {
          str = (String)this.curWxFileToLocalMap.get(paramString);
          if (!TextUtils.isEmpty(str)) {
            return str;
          }
        }
        String str = paramString;
        if (!paramString.startsWith(MiniAppGlobal.STR_WXFILE)) {
          if (paramString.startsWith("wxfile://"))
          {
            str = paramString.replace("wxfile://", MiniAppGlobal.STR_WXFILE);
          }
          else
          {
            str = paramString;
            if (paramString.startsWith("qqfile://")) {
              str = paramString.replace("qqfile://", MiniAppGlobal.STR_WXFILE);
            }
          }
        }
        if (str.startsWith(WXFILE_PREFIX_TMP))
        {
          paramString = str.replace(WXFILE_PREFIX_TMP, "");
          paramString = new File(getMiniFolderPath(0), paramString);
          if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
            return paramString.getAbsolutePath();
          }
        }
        else if (str.startsWith(WXFILE_PREFIX_STORE))
        {
          paramString = str.replace(WXFILE_PREFIX_STORE, "");
          paramString = new File(getMiniFolderPath(1), paramString);
          if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
            return paramString.getAbsolutePath();
          }
        }
        else if (str.startsWith(WXFILE_PREFIX_USR))
        {
          paramString = str.replace(WXFILE_PREFIX_USR, "");
          paramString = new File(getMiniFolderPath(2), paramString);
          if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
            return paramString.getAbsolutePath();
          }
        }
        else if (str.startsWith(WXFILE_PREFIX_PRE_CACHE))
        {
          paramString = str.replace(WXFILE_PREFIX_PRE_CACHE, "");
          paramString = new File(getMiniFolderPath(4), paramString);
          if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))) {
            return paramString.getAbsolutePath();
          }
        }
        else
        {
          paramString = new File(this.apkgInfo.getFilePath(str));
          if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath())))
          {
            paramString = this.apkgInfo.getFilePath(str);
            return paramString;
          }
        }
        return "";
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppFileManager", 1, "getAbsolutePath error.", paramString);
    }
    return "";
  }
  
  public String getRootFileDir()
  {
    return MINI_FILE_ROOT_PATH;
  }
  
  public File[] getSaveFileList()
  {
    Object localObject = new File(getMiniFolderPath(1));
    try
    {
      if (((File)localObject).getCanonicalPath().startsWith(getCurAppSdcardDir()))
      {
        localObject = ((File)localObject).listFiles();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppFileManager", 1, "getSaveFileList error", localThrowable);
    }
    return null;
  }
  
  public String getSaveStorePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (new File(getAbsolutePath(paramString)).exists())
    {
      paramString = getFileName(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      return new File(getMiniFolderPath(1), paramString).getAbsolutePath();
    }
    return null;
  }
  
  public String getTmpPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getRandomFileName());
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new File(getMiniFolderPath(0));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return new File((File)localObject, paramString).getAbsolutePath();
  }
  
  public String getTmpPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = "";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getRandomFileName());
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    paramString2 = new File(getMiniFolderPath(0, paramString1), paramString2);
    try
    {
      if (paramString2.getCanonicalPath().toLowerCase().startsWith(getCurAppSdcardDir(paramString1).toLowerCase()))
      {
        paramString1 = paramString2.getAbsolutePath();
        return paramString1;
      }
      return null;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppFileManager", 1, "getTmpPath error", paramString1);
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
    if (i >= 0)
    {
      if (paramString1.length() - 1 < i) {
        return "";
      }
      return getInstance().getTmpPath(paramString2, paramString1.substring(i + 1));
    }
    return "";
  }
  
  public String getUsrPath(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(WXFILE_PREFIX_USR)))
    {
      paramString = paramString.replace(WXFILE_PREFIX_USR, "");
      paramString = new File(getMiniFolderPath(2), paramString);
      try
      {
        if (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))
        {
          paramString = paramString.getAbsolutePath();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("MiniAppFileManager", 1, "getUsrPath error", paramString);
      }
    }
    return null;
  }
  
  public String getWxFilePath(String paramString)
  {
    for (Object localObject1 = "store";; localObject1 = "tmp")
    {
      try
      {
        Object localObject2 = new File(paramString);
        String str = ((File)localObject2).getParentFile().getAbsolutePath();
        if ((!getMiniFolderPath(0).equals(str)) && (!getMiniFolderPath(1).equals(str)))
        {
          if (str.startsWith(getMiniFolderPath(2)))
          {
            paramString = getMiniFolderPath(2);
            paramString = ((File)localObject2).getAbsolutePath().replace(paramString, "");
            localObject1 = new StringBuilder(WXFILE_PREFIX_USR);
            ((StringBuilder)localObject1).append(paramString);
            return ((StringBuilder)localObject1).toString();
          }
          if (str.startsWith(getMiniFolderPath(4)))
          {
            paramString = getMiniFolderPath(4);
            paramString = ((File)localObject2).getAbsolutePath().replace(paramString, "");
            localObject1 = new StringBuilder(WXFILE_PREFIX_PRE_CACHE);
            ((StringBuilder)localObject1).append(paramString);
            return ((StringBuilder)localObject1).toString();
          }
          if (new File(paramString).exists()) {
            return getWxFilePathByExistLocalPath(paramString);
          }
        }
        else
        {
          if (!((File)localObject2).getParentFile().getName().equals("store")) {
            continue;
          }
          paramString = new File(paramString).getName();
          localObject2 = new StringBuffer(MiniAppGlobal.STR_WXFILE);
          ((StringBuffer)localObject2).append((String)localObject1);
          ((StringBuffer)localObject2).append("_");
          ((StringBuffer)localObject2).append(paramString);
          paramString = ((StringBuffer)localObject2).toString();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      return "";
    }
  }
  
  public String getWxFilePathByExistLocalPath(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = "";
    if (bool) {
      return "";
    }
    Object localObject2 = getSuffixByPath(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(".");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuffer(MiniAppGlobal.STR_WXFILE);
    ((StringBuffer)localObject2).append("tmp");
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(getRandomFileName());
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject1 = ((StringBuffer)localObject2).toString();
    this.curWxFileToLocalMap.put(localObject1, paramString);
    return localObject1;
  }
  
  public String getWxFileTmpPath(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0)
    {
      if (paramString.length() - 1 < i) {
        return "";
      }
      return getTmpPath(paramString.substring(i + 1));
    }
    return "";
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
    } else {
      deleteTmpFolder();
    }
    this.currentAppSdcardPath = null;
    this.currentAppSdcardPath = getCurAppSdcardDir();
    initFileSize();
  }
  
  public boolean isFolderCanWrite(int paramInt, long paramLong)
  {
    long l3 = System.currentTimeMillis();
    Object localObject = this.apkgInfo;
    if ((localObject != null) && (((ApkgBaseInfo)localObject).appConfig != null) && (this.apkgInfo.appConfig.config != null)) {
      if (paramLong > 0L)
      {
        if (paramInt == 1) {
          localObject = this.storeFolderSize;
        } else {
          localObject = this.usrFolderSize;
        }
        long l4 = ((AtomicLong)localObject).get();
        long l1;
        if (this.apkgInfo.isEngineTypeMiniGame()) {
          l1 = 52428800L;
        } else {
          l1 = 10485760L;
        }
        long l2 = l1;
        if (paramInt == 2)
        {
          l2 = l1;
          if (this.apkgInfo.appConfig.config.usrFileSizeLimit > 0L) {
            l2 = this.apkgInfo.appConfig.config.usrFileSizeLimit;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isFolderCanWrite usrFileSizeLimit : ");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(" size used : ");
        ((StringBuilder)localObject).append(l4);
        QLog.d("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
        if (l4 + paramLong > l2)
        {
          if (this.apkgInfo.isEngineTypeMiniGame()) {
            MiniGameStorageExceedManager.showStorageExceedDialog(this.activityWeakReference, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.apkgInfo.appConfig.config);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isFolderCanWrite [minigame timecost:");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l3);
          ((StringBuilder)localObject).append("ms ]");
          QLog.i("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    for (;;)
    {
      return false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFolderCanWrite [minigame timecost:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l3);
      ((StringBuilder)localObject).append("ms ]");
      QLog.i("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
      return true;
      QLog.w("[mini] ", 1, "check isFolderCanWrite on null apkgInfo or  null apkgInfo.appConfig or null apkgInfo.appConfig.config");
    }
  }
  
  public boolean isPackageRelativePath(String paramString)
  {
    try
    {
      paramString = new File(this.apkgInfo.getFilePath(paramString));
      if (paramString.exists())
      {
        boolean bool = paramString.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath());
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public String savePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith(WXFILE_PREFIX_STORE)) {
      return paramString;
    }
    Object localObject = getAbsolutePath(paramString);
    if (new File((String)localObject).exists())
    {
      paramString = getFileName(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (FileUtils.copyFile((String)localObject, new File(getMiniFolderPath(1), paramString).getAbsolutePath()))
      {
        localObject = new StringBuffer(MiniAppGlobal.STR_WXFILE);
        ((StringBuffer)localObject).append("store");
        ((StringBuffer)localObject).append("_");
        ((StringBuffer)localObject).append(paramString);
        return ((StringBuffer)localObject).toString();
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
    Object localObject;
    long l;
    if (paramInt == 1)
    {
      CountDownLatch localCountDownLatch = this.initStoreCountDown;
      if (localCountDownLatch != null) {
        try
        {
          localCountDownLatch.await();
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
      if (this.storeUpdateCount.incrementAndGet() % 100 == 0)
      {
        paramLong = FileUtils.getFileOrFolderSize(getMiniFolderPath(1));
        this.storeFolderSize.set(paramLong);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateFolderSize fileType=store realSize=");
        ((StringBuilder)localObject).append(paramLong);
        QLog.i("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      l = this.storeFolderSize.addAndGet(paramLong);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFolderSize fileType=store delta=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" size=");
      ((StringBuilder)localObject).append(l);
      QLog.i("MiniAppFileManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt == 2)
    {
      localObject = this.initUsrCountDown;
      if (localObject != null) {
        try
        {
          ((CountDownLatch)localObject).await();
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
      }
      if (this.usrUpdateCount.incrementAndGet() % 100 == 0)
      {
        paramLong = FileUtils.getFileOrFolderSize(getMiniFolderPath(2));
        this.usrFolderSize.set(paramLong);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFolderSize fileType=usr realSize=");
        localStringBuilder.append(paramLong);
        QLog.i("MiniAppFileManager", 1, localStringBuilder.toString());
        return;
      }
      l = this.usrFolderSize.addAndGet(paramLong);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFolderSize fileType=usr delta=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" size=");
      localStringBuilder.append(l);
      QLog.i("MiniAppFileManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */