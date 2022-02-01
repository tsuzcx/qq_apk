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
import java.io.IOException;
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
  
  private static void createNoMediaInMiniPath()
  {
    try
    {
      boolean bool = isNoMediaCreated;
      if (bool) {
        return;
      }
      File localFile1 = new File(MiniSDKConst.getMiniCacheFilePath(), ".nomedia");
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
        QMLog.e(TAG, "exception in create .nomedia of mini files", localIOException);
      }
      return;
    }
    finally {}
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
      localObject1 = this.mApkgBaseInfo;
      if ((localObject1 instanceof ApkgInfo))
      {
        localObject1 = ((ApkgInfo)localObject1).readApkgToStream(paramString);
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
    Object localObject = this.mApkgBaseInfo;
    if (localObject != null) {
      localObject = ((ApkgBaseInfo)localObject).appId;
    } else {
      localObject = null;
    }
    return getCurAppSdcardDir((String)localObject);
  }
  
  private static String getCurAppSdcardDir(String paramString)
  {
    String str;
    if (LoginManager.getInstance().getAccount() != null) {
      str = LoginManager.getInstance().getAccount();
    } else {
      str = "";
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)))
    {
      if ((str.equals(currentUin)) && (paramString.equals(currentAppId)) && (!TextUtils.isEmpty(currentAppSdcardDir))) {
        return currentAppSdcardDir;
      }
      currentAppId = paramString;
      currentUin = str;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(MiniSDKConst.getMiniCacheFilePath());
      ((StringBuilder)localObject).append(MD5Utils.toMD5(paramString));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MD5Utils.toMD5(str));
      currentAppSdcardDir = ((StringBuilder)localObject).toString();
      return currentAppSdcardDir;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurAppSdcardDir error. uin : ");
    localStringBuilder.append(str);
    localStringBuilder.append("; curMiniAppId : ");
    localStringBuilder.append(paramString);
    QMLog.e((String)localObject, localStringBuilder.toString());
    return MiniSDKConst.getMiniCacheFilePath();
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
    Object localObject = this.mApkgBaseInfo;
    if (localObject != null) {
      localObject = ((ApkgBaseInfo)localObject).appId;
    } else {
      localObject = null;
    }
    return getMiniFolderPath((String)localObject, paramInt);
  }
  
  private static String getMiniFolderPath(String paramString, int paramInt)
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
    return getPreCacheFilePath(null, paramString2);
  }
  
  public static String getPreCacheFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str = getMiniFolderPath(paramString1, 4);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append(str);
      paramString1.append(File.separator);
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(File.separator);
    paramString2.append(paramString3);
    return paramString2.toString();
  }
  
  private String getRandomFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append(System.nanoTime());
    return MD5Utils.toMD5(localStringBuilder.toString());
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
      QMLog.e(TAG, "getSuffixByPath error", localThrowable);
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
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppFileManager.2(this));
    this.initStoreCountDown = new CountDownLatch(1);
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppFileManager.3(this));
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
    FileUtils.delete(MiniSDKConst.getMiniCacheFilePath(), false);
    this.usrFolderSize.set(0L);
    this.storeFolderSize.set(0L);
    hasCheckUsrDir = false;
  }
  
  public void clearFileCache(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MiniSDKConst.getMiniCacheFilePath());
    localStringBuilder.append(MD5Utils.toMD5(paramString));
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
    //   0: new 144	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: iconst_0
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_3
    //   14: new 144	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: iconst_0
    //   20: invokespecial 128	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getMiniFolderPath	(I)Ljava/lang/String;
    //   23: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload 5
    //   30: invokevirtual 194	java/io/File:getParentFile	()Ljava/io/File;
    //   33: aload 6
    //   35: invokevirtual 494	java/io/File:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +5 -> 43
    //   41: aload_1
    //   42: areturn
    //   43: new 144	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: aload 5
    //   50: invokestatic 496	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getFileSuffix	(Ljava/io/File;)Ljava/lang/String;
    //   53: invokevirtual 499	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 10
    //   61: sipush 8192
    //   64: newarray byte
    //   66: astore 8
    //   68: aconst_null
    //   69: astore 6
    //   71: aconst_null
    //   72: astore 9
    //   74: new 501	java/io/BufferedInputStream
    //   77: dup
    //   78: new 503	java/io/FileInputStream
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 504	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore_1
    //   91: new 509	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 269	java/io/FileOutputStream
    //   98: dup
    //   99: aload 10
    //   101: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 512	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   107: astore 5
    //   109: aload 5
    //   111: astore 7
    //   113: aload_1
    //   114: astore 6
    //   116: aload_1
    //   117: aload 8
    //   119: invokevirtual 515	java/io/InputStream:read	([B)I
    //   122: istore 4
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmple +23 -> 150
    //   130: aload 5
    //   132: astore 7
    //   134: aload_1
    //   135: astore 6
    //   137: aload 5
    //   139: aload 8
    //   141: iconst_0
    //   142: iload 4
    //   144: invokevirtual 518	java/io/OutputStream:write	([BII)V
    //   147: goto -38 -> 109
    //   150: aload 5
    //   152: astore 7
    //   154: aload_1
    //   155: astore 6
    //   157: aload 5
    //   159: invokevirtual 521	java/io/OutputStream:flush	()V
    //   162: iconst_1
    //   163: istore_2
    //   164: aload 5
    //   166: invokevirtual 522	java/io/OutputStream:close	()V
    //   169: aload_1
    //   170: invokevirtual 523	java/io/InputStream:close	()V
    //   173: goto +77 -> 250
    //   176: astore 8
    //   178: goto +31 -> 209
    //   181: astore 5
    //   183: goto +91 -> 274
    //   186: astore 8
    //   188: aconst_null
    //   189: astore 5
    //   191: goto +18 -> 209
    //   194: astore 5
    //   196: aconst_null
    //   197: astore_1
    //   198: goto +76 -> 274
    //   201: astore 8
    //   203: aconst_null
    //   204: astore 5
    //   206: aload 5
    //   208: astore_1
    //   209: aload 5
    //   211: astore 7
    //   213: aload_1
    //   214: astore 6
    //   216: getstatic 95	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:TAG	Ljava/lang/String;
    //   219: ldc_w 525
    //   222: aload 8
    //   224: invokestatic 530	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   227: pop
    //   228: aload 5
    //   230: ifnull +11 -> 241
    //   233: aload 5
    //   235: invokevirtual 522	java/io/OutputStream:close	()V
    //   238: goto +3 -> 241
    //   241: aload_1
    //   242: ifnull +8 -> 250
    //   245: iload_3
    //   246: istore_2
    //   247: goto -78 -> 169
    //   250: aload 9
    //   252: astore_1
    //   253: iload_2
    //   254: ifeq +9 -> 263
    //   257: aload 10
    //   259: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   262: astore_1
    //   263: aload_1
    //   264: areturn
    //   265: astore 5
    //   267: aload 6
    //   269: astore_1
    //   270: aload 7
    //   272: astore 6
    //   274: aload 6
    //   276: ifnull +11 -> 287
    //   279: aload 6
    //   281: invokevirtual 522	java/io/OutputStream:close	()V
    //   284: goto +3 -> 287
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 523	java/io/InputStream:close	()V
    //   295: goto +6 -> 301
    //   298: aload 5
    //   300: athrow
    //   301: goto -3 -> 298
    //   304: astore 5
    //   306: goto -137 -> 169
    //   309: astore_1
    //   310: goto -60 -> 250
    //   313: astore 5
    //   315: goto -74 -> 241
    //   318: astore 6
    //   320: goto -33 -> 287
    //   323: astore_1
    //   324: goto -29 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	MiniAppFileManager
    //   0	327	1	paramString	String
    //   11	243	2	i	int
    //   13	233	3	j	int
    //   122	21	4	k	int
    //   8	157	5	localObject1	Object
    //   181	1	5	localObject2	Object
    //   189	1	5	localObject3	Object
    //   194	1	5	localObject4	Object
    //   204	30	5	localObject5	Object
    //   265	34	5	localObject6	Object
    //   304	1	5	localIOException1	IOException
    //   313	1	5	localIOException2	IOException
    //   26	254	6	localObject7	Object
    //   318	1	6	localIOException3	IOException
    //   111	160	7	localObject8	Object
    //   66	74	8	arrayOfByte	byte[]
    //   176	1	8	localIOException4	IOException
    //   186	1	8	localIOException5	IOException
    //   201	22	8	localIOException6	IOException
    //   72	179	9	localObject9	Object
    //   59	199	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   116	124	176	java/io/IOException
    //   137	147	176	java/io/IOException
    //   157	162	176	java/io/IOException
    //   91	109	181	finally
    //   91	109	186	java/io/IOException
    //   74	91	194	finally
    //   74	91	201	java/io/IOException
    //   116	124	265	finally
    //   137	147	265	finally
    //   157	162	265	finally
    //   216	228	265	finally
    //   164	169	304	java/io/IOException
    //   169	173	309	java/io/IOException
    //   233	238	313	java/io/IOException
    //   279	284	318	java/io/IOException
    //   291	295	323	java/io/IOException
  }
  
  public void deleteTmpFileNeed2DeleteAsync()
  {
    ArrayList localArrayList = this.mTmpFileNeed2DeleteAsync;
    if ((localArrayList != null) && (localArrayList.size() > 0))
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
      String str = paramString;
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
        str = paramString;
        if (!paramString.startsWith("wxfile://")) {
          if (paramString.startsWith("wxfile://"))
          {
            str = paramString.replace("wxfile://", "wxfile://");
          }
          else
          {
            str = paramString;
            if (paramString.startsWith("qqfile://")) {
              str = paramString.replace("qqfile://", "wxfile://");
            }
          }
        }
        str = getAbsoluteRealPath(str);
      }
      return str;
    }
    catch (Throwable paramString)
    {
      QMLog.e(TAG, "getAbsolutePath error.", paramString);
    }
    return "";
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
  
  public String getTmpPathByUrl(String paramString)
  {
    return getTmpPath(getSuffixByPath(paramString));
  }
  
  public String getTmpPathByWxFilePath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("wxfile://tmp_")) {
        return null;
      }
      paramString = paramString.replace("wxfile://tmp_", "");
      String str = getMiniFolderPath(this.mApkgBaseInfo.appId, 0);
      if (TextUtils.isEmpty(str))
      {
        QMLog.e(TAG, "getMiniFolderPath is empty.");
        return null;
      }
      paramString = new File(str, paramString);
      try
      {
        if (paramString.getCanonicalPath().startsWith(getCurAppSdcardDir()))
        {
          paramString = paramString.getAbsolutePath();
          return paramString;
        }
        return null;
      }
      catch (Throwable paramString)
      {
        QMLog.e(TAG, "getTmpPathFromWx error", paramString);
      }
    }
    return null;
  }
  
  public String getUsrPath(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("wxfile://usr")))
    {
      paramString = paramString.replace("wxfile://usr", "");
      paramString = new File(getMiniFolderPath(this.mApkgBaseInfo.appId, 2), paramString);
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
        QMLog.e(TAG, "getUsrPath error", paramString);
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
            localObject1 = new StringBuilder("wxfile://usr");
            ((StringBuilder)localObject1).append(paramString);
            return ((StringBuilder)localObject1).toString();
          }
          if (str.startsWith(getMiniFolderPath(4)))
          {
            paramString = getMiniFolderPath(4);
            paramString = ((File)localObject2).getAbsolutePath().replace(paramString, "");
            localObject1 = new StringBuilder("wxfile://precache");
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
          localObject2 = new StringBuffer("wxfile://");
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
    localObject2 = new StringBuffer("wxfile://");
    ((StringBuffer)localObject2).append("tmp");
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(getRandomFileName());
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject1 = ((StringBuffer)localObject2).toString();
    this.curWxFileToLocalMap.put(localObject1, paramString);
    return localObject1;
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
    } else {
      deleteTmpFolder();
    }
    this.currentAppSdcardPath = null;
    this.currentAppSdcardPath = getCurAppSdcardDir();
    initFileSize();
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
    if (paramInt == 1) {
      localObject = this.storeFolderSize;
    } else {
      localObject = this.usrFolderSize;
    }
    long l5 = ((AtomicLong)localObject).get();
    long l1;
    if (paramBoolean) {
      l1 = 52428800L;
    } else {
      l1 = 10485760L;
    }
    long l2 = l1;
    if (paramInt == 2)
    {
      long l3 = this.storageLimit;
      l2 = l1;
      if (l3 > 0L) {
        l2 = l3;
      }
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFolderCanWrite usrFileSizeLimit : ");
    localStringBuilder.append(l2);
    localStringBuilder.append(" size used : ");
    localStringBuilder.append(l5);
    QMLog.d((String)localObject, localStringBuilder.toString());
    if (l5 + paramLong > l2)
    {
      if (paramBoolean) {
        MiniGameStorageExceedManager.showStorageExceedDialog(new WeakReference(paramActivity), LoginManager.getInstance().getAccount(), paramMiniAppInfo);
      }
      paramMiniAppInfo = TAG;
      paramActivity = new StringBuilder();
      paramActivity.append("isFolderCanWrite [minigame timecost:");
      paramActivity.append(System.currentTimeMillis() - l4);
      paramActivity.append("ms ]");
      QMLog.i(paramMiniAppInfo, paramActivity.toString());
      return false;
    }
    paramMiniAppInfo = TAG;
    paramActivity = new StringBuilder();
    paramActivity.append("isFolderCanWrite [minigame timecost:");
    paramActivity.append(System.currentTimeMillis() - l4);
    paramActivity.append("ms ]");
    QMLog.i(paramMiniAppInfo, paramActivity.toString());
    return true;
  }
  
  public boolean isPackageRelativePath(String paramString)
  {
    try
    {
      paramString = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(paramString));
      if (paramString.exists())
      {
        boolean bool = paramString.getCanonicalPath().startsWith(new File(this.mApkgBaseInfo.getApkgFolderPath()).getCanonicalPath());
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
    if (paramString.startsWith("wxfile://store_")) {
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
        localObject = new StringBuffer("wxfile://");
        ((StringBuffer)localObject).append("store");
        ((StringBuffer)localObject).append("_");
        ((StringBuffer)localObject).append(paramString);
        return ((StringBuffer)localObject).toString();
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
    Object localObject;
    StringBuilder localStringBuilder;
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
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFolderSize fileType=store realSize=");
        localStringBuilder.append(paramLong);
        QMLog.i((String)localObject, localStringBuilder.toString());
        return;
      }
      l = this.storeFolderSize.addAndGet(paramLong);
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFolderSize fileType=store delta=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" size=");
      localStringBuilder.append(l);
      QMLog.i((String)localObject, localStringBuilder.toString());
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
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFolderSize fileType=usr realSize=");
        localStringBuilder.append(paramLong);
        QMLog.i(str, localStringBuilder.toString());
        return;
      }
      l = this.usrFolderSize.addAndGet(paramLong);
      String str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFolderSize fileType=usr delta=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" size=");
      localStringBuilder.append(l);
      QMLog.i(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.MiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */