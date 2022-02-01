package cooperation.qzone.cache;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import mqq.app.MobileQQ;

public class CacheManager
{
  public static final int AUDIO_EXTERNAL_CAPACITY = 104857600;
  public static final String AUDIO_FILE_CACHE_NAME = "audio";
  public static final int AUDIO_INTERNAL_CAPACITY = 41943040;
  public static final int AVATAR_EXTERNAL_CAPACITY = 52428800;
  public static final String AVATAR_FILE_CACHE_NAME = "avatar";
  public static final int AVATAR_INTERNAL_CAPACITY = 20971520;
  public static final String DEHAZE_PIC = "dehaze_pic";
  public static final String GIFT_FULLSCREEN_PATH = "gift_fullscreen";
  public static final String GIFT_PASSIVE_PRAISE_PATH = "passive_praise";
  public static final String HEAD_DROP_OPERATION = "head_drop_operaion";
  public static final int IMAGE_EXTERNAL_CAPACITY = 104857600;
  public static final String IMAGE_FILE_CACHE_NAME = "batch_image";
  public static final int IMAGE_INTERNAL_CAPACITY = 62914560;
  private static final int MEGABYTES = 1048576;
  private static final String NO_SDCARD_TIPS = "无SD Card";
  public static final int PERSONALISE_FONT_EXTERNAL_CAPACITY = 104857600;
  public static final int PERSONALISE_FONT_INTERNAL_CAPACITY = 41943040;
  public static final String PERSONALISE_FONT_PATH = "personalise_font";
  public static final String PERSONALITY_CANVAS_CACHE_NAME = "personality_canvas";
  public static final int PERSONALITY_CANVAS_FILE_EXTERNAL_CAPACITY = 2097152;
  public static final int PERSONALITY_CANVAS_FILE_INTERNAL_CAPACITY = 1048576;
  public static final String PLUS_DECORATE_DIR = "plus_decorate";
  public static final String PLUS_OPERATION = "plus_operation";
  public static final String QZONE_WIDGETAI_NAME = "qzone_widgetai";
  public static final int QZONE_WIDGETAI_NAME_EXTERNAL_CAPACITY = 104857600;
  public static final int QZONE_WIDGETAI_NAME_INTERNAL_CAPACITY = 20971520;
  public static final String RAPID_COMMENT_PATH = "rapid_comment";
  public static final String REACT_CACHE_NAME = "react";
  public static final String SMART_BEAUTIFY_RESOURCE_PATH = "smart_beautify";
  public static final String SURPRISE_RESOURCE_PATH = "surprise";
  public static final String TAG = "CacheManager";
  private static final String VERSION = "qua";
  public static final String VIDEO_FILE_CACHE_NAME = "video";
  public static final String VIDEO_PLAY_CACHE_DIR = "video_cache";
  private static final long VIDEO_STORAGE_LOW_BOUND = 5242880L;
  private static HashMap<String, Integer> VersionMap;
  public static final int WEBVIEW_OFFLINE_EXTERNAL_CAPACITY = 104857600;
  public static final String WEBVIEW_OFFLINE_FILE_CACHE_NAME = "offline";
  public static final int WEBVIEW_OFFLINE_INTERNAL_CAPACITY = 20971520;
  public static final int ZIP_CACHE_INTERNAL_CAPACITY = 20971520;
  public static final String ZIP_CACHE_NAME = "zip_cache";
  public static final int ZIP_CACHE__EXTERNAL_CAPACITY = 104857600;
  private static HashMap<String, Boolean> isStorageReallyCanwriteMap;
  private static volatile boolean mHasLoadSDCardName;
  private static HashMap<String, String> mSDCardName2PathMap;
  private static long maxAvailableSize = 0L;
  private static String maxAvailableSizePath;
  private static final HashMap<String, FileCacheService> sFileCacheService = new HashMap();
  private static FileStorageHandler sStorageHandler = null;
  private static Object storageHandlerLock = new Object();
  private static String storeRootPath = null;
  
  static
  {
    mSDCardName2PathMap = new HashMap();
    isStorageReallyCanwriteMap = new HashMap();
    mHasLoadSDCardName = false;
    maxAvailableSizePath = "";
  }
  
  private static final String calcCapUnit(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
      localStringBuilder.append(countToUnit(paramInt));
      return localStringBuilder.toString();
    }
    return calcCapUnit(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static final String calcCapUnit(long paramLong)
  {
    return calcCapUnit(0, (float)paramLong);
  }
  
  public static void checkAndCleanStorage()
  {
    getAudioFileCacheService();
    getAvatarFileCacheService();
    getWebviewOfflineFileCacheService();
    getPersonaliseFontCacheService();
    getBatchImageDownloadCacheService();
    getStorageHandler().onCheckAndCleanStorage();
  }
  
  public static void clearFileCache(Context paramContext)
  {
    paramContext = QZoneFilePath.CACHE_DIR_IMAGE;
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    FileUtil.c(QZoneFilePath.CACHE_DIR_IMAGE_SR);
    paramContext = QZoneFilePath.CACHE_DIR_VIDEO;
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    FileUtil.c(QZoneFilePath.CACHE_DIR_VIDEO_PLAY);
    paramContext = QZoneFilePath.CACHE_DIR_FILE;
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = QZoneFilePath.CACHE_DIR_FEEDS;
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = getStoreRootPath();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = getInternalCacheDir();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
  }
  
  private static void clearSP(long paramLong)
  {
    String str1 = LocalMultiProcConfig.getString("qua", "");
    String str2 = QUA.getQUA3();
    if (!str1.equals(str2))
    {
      LocalMultiProcConfig.putString4Uin("getMapLastGetTime", "", paramLong);
      LocalMultiProcConfig.putString("qua", str2);
    }
  }
  
  private static String countToUnit(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  public static FileCacheService getAudioFileCacheService()
  {
    return getFileCacheService("audio", 104857600, 41943040);
  }
  
  public static String getAudioGiftSavePath(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = String.valueOf(System.currentTimeMillis());
    }
    paramString = getAudioFileCacheService();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audio_gift_");
    localStringBuilder.append(paramContext);
    paramContext = paramString.getFile(localStringBuilder.toString(), true);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String getAudioShuoshuoSavePath(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = String.valueOf(System.currentTimeMillis());
    }
    paramString = getAudioFileCacheService();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    paramContext = paramString.getFile(localStringBuilder.toString(), true);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileCacheService getAvatarFileCacheService()
  {
    return getFileCacheService("avatar", 52428800, 20971520);
  }
  
  public static FileCacheService getBatchImageDownloadCacheService()
  {
    return getFileCacheService("batch_image", 104857600, 62914560);
  }
  
  public static String getCacheDir(String paramString)
  {
    String str = getStoreRootPath();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static String getCacheDir(String paramString, int paramInt)
  {
    return getCacheDir(paramString);
  }
  
  public static String getCameraPhotoSavePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
    localStringBuilder.append(UUID.randomUUID().toString());
    localStringBuilder.append(".jpg");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String getDehazeDir()
  {
    return getCacheDir("dehaze_pic");
  }
  
  public static FileCacheService getFileCacheService(String paramString, int paramInt1, int paramInt2)
  {
    AssertUtil.assertTrue(TextUtils.isEmpty(paramString) ^ true);
    synchronized (sFileCacheService)
    {
      FileCacheService localFileCacheService2 = (FileCacheService)sFileCacheService.get(paramString);
      FileCacheService localFileCacheService1 = localFileCacheService2;
      if (localFileCacheService2 == null)
      {
        localFileCacheService1 = new FileCacheService(paramString, 1, paramInt1, paramInt2);
        localFileCacheService1.setStorageHandler(getStorageHandler());
        sFileCacheService.put(paramString, localFileCacheService1);
      }
      return localFileCacheService1;
    }
  }
  
  public static String getGifFullScreenDir()
  {
    return getCacheDir("gift_fullscreen");
  }
  
  public static String getHeadDropOperation()
  {
    return getCacheDir("head_drop_operaion");
  }
  
  public static String getImageFilePath(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = getUrlKey(paramString);
    if (!TextUtils.isEmpty(str)) {
      paramString = str;
    }
    int i = paramString.hashCode();
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = QZoneFilePath.CACHE_DIR_IMAGE;
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(paramContext.getCacheDir().getAbsolutePath());
      paramString.append(File.separator);
      paramString.append("qzone");
      paramString.append(File.separator);
      paramString.append("image");
      paramContext = paramString.toString();
    }
    if (paramContext == null) {
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append(File.separator);
    paramString.append(String.valueOf(i));
    return paramString.toString();
  }
  
  public static String getInternalCacheDir()
  {
    File localFile = MobileQQ.getContext().getCacheDir();
    if (localFile != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("qzone");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getInternalCacheDir(String paramString)
  {
    String str = getInternalCacheDir();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static String getMoodListIconDir()
  {
    return getCacheDir("moodlistIcons");
  }
  
  /* Error */
  private static int getOldVer(String paramString)
  {
    // Byte code:
    //   0: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   3: ifnonnull +13 -> 16
    //   6: new 125	java/util/HashMap
    //   9: dup
    //   10: invokespecial 128	java/util/HashMap:<init>	()V
    //   13: putstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   16: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   19: aload_0
    //   20: invokevirtual 384	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 447	java/lang/Integer
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +9 -> 39
    //   33: aload 5
    //   35: invokevirtual 450	java/lang/Integer:intValue	()I
    //   38: ireturn
    //   39: invokestatic 244	cooperation/qzone/cache/CacheManager:getStoreRootPath	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_0
    //   45: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +17 -> 65
    //   51: new 316	java/io/File
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 5
    //   62: goto +50 -> 112
    //   65: new 157	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   72: astore 6
    //   74: aload 6
    //   76: aload 5
    //   78: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: getstatic 331	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: aload_0
    //   94: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 316	java/io/File
    //   101: dup
    //   102: aload 6
    //   104: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: astore 5
    //   112: iconst_0
    //   113: istore_2
    //   114: iconst_0
    //   115: istore_3
    //   116: iconst_0
    //   117: istore 4
    //   119: iload_3
    //   120: istore_1
    //   121: aload 5
    //   123: invokevirtual 347	java/io/File:exists	()Z
    //   126: ifeq +284 -> 410
    //   129: iload_3
    //   130: istore_1
    //   131: aload 5
    //   133: invokevirtual 453	java/io/File:isDirectory	()Z
    //   136: ifeq +274 -> 410
    //   139: new 316	java/io/File
    //   142: dup
    //   143: aload 5
    //   145: ldc_w 455
    //   148: invokespecial 458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   151: astore 6
    //   153: iload_3
    //   154: istore_1
    //   155: aload 6
    //   157: invokevirtual 347	java/io/File:exists	()Z
    //   160: ifeq +250 -> 410
    //   163: iload_3
    //   164: istore_1
    //   165: aload 6
    //   167: invokevirtual 338	java/io/File:isFile	()Z
    //   170: ifeq +240 -> 410
    //   173: aconst_null
    //   174: astore 8
    //   176: aconst_null
    //   177: astore 9
    //   179: aconst_null
    //   180: astore 10
    //   182: aconst_null
    //   183: astore 5
    //   185: new 460	java/io/BufferedReader
    //   188: dup
    //   189: new 462	java/io/InputStreamReader
    //   192: dup
    //   193: new 464	java/io/FileInputStream
    //   196: dup
    //   197: aload 6
    //   199: invokespecial 466	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   202: invokespecial 469	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   205: invokespecial 472	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   208: astore 6
    //   210: aload 6
    //   212: invokevirtual 475	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   215: astore 5
    //   217: iload 4
    //   219: istore_1
    //   220: aload 5
    //   222: ifnull +9 -> 231
    //   225: aload 5
    //   227: invokestatic 478	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_1
    //   231: iload_1
    //   232: istore_2
    //   233: aload 6
    //   235: invokevirtual 481	java/io/BufferedReader:close	()V
    //   238: goto +172 -> 410
    //   241: astore 5
    //   243: aload 5
    //   245: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   248: iload_2
    //   249: istore_1
    //   250: goto +160 -> 410
    //   253: astore_0
    //   254: aload 6
    //   256: astore 5
    //   258: goto +130 -> 388
    //   261: astore 5
    //   263: aload 5
    //   265: astore 7
    //   267: goto +31 -> 298
    //   270: astore 5
    //   272: aload 5
    //   274: astore 7
    //   276: goto +54 -> 330
    //   279: astore 5
    //   281: aload 5
    //   283: astore 7
    //   285: goto +77 -> 362
    //   288: astore_0
    //   289: goto +99 -> 388
    //   292: astore 7
    //   294: aload 8
    //   296: astore 6
    //   298: aload 6
    //   300: astore 5
    //   302: aload 7
    //   304: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   307: iload_3
    //   308: istore_1
    //   309: aload 6
    //   311: ifnull +99 -> 410
    //   314: aload 6
    //   316: invokevirtual 481	java/io/BufferedReader:close	()V
    //   319: iload_3
    //   320: istore_1
    //   321: goto +89 -> 410
    //   324: astore 7
    //   326: aload 9
    //   328: astore 6
    //   330: aload 6
    //   332: astore 5
    //   334: aload 7
    //   336: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   339: iload_3
    //   340: istore_1
    //   341: aload 6
    //   343: ifnull +67 -> 410
    //   346: aload 6
    //   348: invokevirtual 481	java/io/BufferedReader:close	()V
    //   351: iload_3
    //   352: istore_1
    //   353: goto +57 -> 410
    //   356: astore 7
    //   358: aload 10
    //   360: astore 6
    //   362: aload 6
    //   364: astore 5
    //   366: aload 7
    //   368: invokevirtual 486	java/io/FileNotFoundException:printStackTrace	()V
    //   371: iload_3
    //   372: istore_1
    //   373: aload 6
    //   375: ifnull +35 -> 410
    //   378: aload 6
    //   380: invokevirtual 481	java/io/BufferedReader:close	()V
    //   383: iload_3
    //   384: istore_1
    //   385: goto +25 -> 410
    //   388: aload 5
    //   390: ifnull +18 -> 408
    //   393: aload 5
    //   395: invokevirtual 481	java/io/BufferedReader:close	()V
    //   398: goto +10 -> 408
    //   401: astore 5
    //   403: aload 5
    //   405: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   408: aload_0
    //   409: athrow
    //   410: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   413: aload_0
    //   414: iload_1
    //   415: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   421: pop
    //   422: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +55 -> 480
    //   428: new 157	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   435: astore 5
    //   437: aload 5
    //   439: ldc_w 496
    //   442: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 5
    //   448: aload_0
    //   449: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 5
    //   455: ldc_w 498
    //   458: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 5
    //   464: iload_1
    //   465: invokevirtual 501	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: ldc 80
    //   471: iconst_2
    //   472: aload 5
    //   474: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 505	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: iload_1
    //   481: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramString	String
    //   120	361	1	i	int
    //   113	136	2	j	int
    //   115	269	3	k	int
    //   117	101	4	m	int
    //   26	200	5	localObject1	Object
    //   241	3	5	localIOException1	java.io.IOException
    //   256	1	5	localObject2	Object
    //   261	3	5	localException1	Exception
    //   270	3	5	localIOException2	java.io.IOException
    //   279	3	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   300	94	5	localObject3	Object
    //   401	3	5	localIOException3	java.io.IOException
    //   435	38	5	localStringBuilder	StringBuilder
    //   72	307	6	localObject4	Object
    //   265	19	7	localObject5	Object
    //   292	11	7	localException2	Exception
    //   324	11	7	localIOException4	java.io.IOException
    //   356	11	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   174	121	8	localObject6	Object
    //   177	150	9	localObject7	Object
    //   180	179	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   233	238	241	java/io/IOException
    //   314	319	241	java/io/IOException
    //   346	351	241	java/io/IOException
    //   378	383	241	java/io/IOException
    //   210	217	253	finally
    //   225	231	253	finally
    //   210	217	261	java/lang/Exception
    //   225	231	261	java/lang/Exception
    //   210	217	270	java/io/IOException
    //   225	231	270	java/io/IOException
    //   210	217	279	java/io/FileNotFoundException
    //   225	231	279	java/io/FileNotFoundException
    //   185	210	288	finally
    //   302	307	288	finally
    //   334	339	288	finally
    //   366	371	288	finally
    //   185	210	292	java/lang/Exception
    //   185	210	324	java/io/IOException
    //   185	210	356	java/io/FileNotFoundException
    //   393	398	401	java/io/IOException
  }
  
  public static FileCacheService getPersonaliseFontCacheService()
  {
    return getFileCacheService("personalise_font", 104857600, 41943040);
  }
  
  public static final String getPersonaliseFontDir()
  {
    return getPersonaliseFontCacheService().getDir();
  }
  
  public static FileCacheService getPersonalityWidgetCacheService()
  {
    return getFileCacheService("personality_canvas", 2097152, 1048576);
  }
  
  public static String getPlusDecorateDir()
  {
    return getCacheDir("plus_decorate");
  }
  
  public static String getPlusOperationDir()
  {
    return getCacheDir("plus_operation");
  }
  
  public static String getPraiseDir()
  {
    return getCacheDir("passive_praise");
  }
  
  public static FileCacheService getQzoneWidgetAICacheService()
  {
    return getFileCacheService("qzone_widgetai", 104857600, 20971520);
  }
  
  public static String getRapidCommentDir()
  {
    return getCacheDir("rapid_comment");
  }
  
  public static String getReactCacheDir()
  {
    return getCacheDir("react");
  }
  
  public static final long getSDCardCapability()
  {
    if (!isExternalAvailable()) {
      return -1L;
    }
    Object localObject = getStoreRootPath();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static final String getSDCardCapabilityForDisplay()
  {
    long l = getSDCardCapability();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static final long getSDCardRemain()
  {
    if (!isExternalAvailable()) {
      return -1L;
    }
    Object localObject = getStoreRootPath();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static final String getSDCardRemainForDisplay()
  {
    long l = getSDCardRemain();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static String getSmartBeautifyResourceDir()
  {
    return getCacheDir("smart_beautify");
  }
  
  public static FileStorageHandler getStorageHandler()
  {
    synchronized (storageHandlerLock)
    {
      if (sStorageHandler == null) {
        sStorageHandler = new FileStorageHandler(new CacheManager.1());
      }
      return sStorageHandler;
    }
  }
  
  public static String getStoreRootPath()
  {
    if (storeRootPath == null) {
      try
      {
        if (storeRootPath == null) {
          resetStorePath(false);
        }
      }
      finally {}
    }
    return storeRootPath;
  }
  
  public static String getSurpriseResourceDir()
  {
    return getCacheDir("surprise");
  }
  
  public static String getUrlKey(String paramString)
  {
    String str = paramString;
    if (isNetworkUrl(paramString))
    {
      int k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      int i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      str = paramString.substring(k + 1, i);
    }
    return str;
  }
  
  public static String getVideoFileCacheDir()
  {
    return getCacheDir("video");
  }
  
  public static String getVideoPlayCacheDir()
  {
    Object localObject1 = QZoneFilePath.ROOT_QZONE_PATH;
    if (localObject1 != null)
    {
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).isFile()) {
        FileUtils.delete((File)localObject2);
      }
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("video_cache");
    localObject1 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject1).isFile()) {
      FileUtils.delete((File)localObject1);
    }
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    return ((File)localObject1).getAbsolutePath();
  }
  
  public static FileCacheService getWebviewOfflineFileCacheService()
  {
    return getFileCacheService("offline", 104857600, 20971520);
  }
  
  public static FileCacheService getZipCacheService()
  {
    return getFileCacheService("zip_cache", 104857600, 20971520);
  }
  
  public static void initiate(long paramLong)
  {
    clearSP(paramLong);
  }
  
  public static boolean isExternalAvailable()
  {
    return SDCardMountMonitorReceiver.getInstance().isSDCardMount();
  }
  
  public static boolean isInternal(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("https://"))
    {
      if (paramString.startsWith("https://")) {
        return true;
      }
      return URLUtil.isNetworkUrl(paramString);
    }
    return true;
  }
  
  /* Error */
  public static boolean isStorageReallyCanwrite(String paramString)
  {
    // Byte code:
    //   0: getstatic 139	cooperation/qzone/cache/CacheManager:isStorageReallyCanwriteMap	Ljava/util/HashMap;
    //   3: aload_0
    //   4: invokevirtual 384	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 614	java/lang/Boolean
    //   10: astore 5
    //   12: aload 5
    //   14: ifnull +9 -> 23
    //   17: aload 5
    //   19: invokevirtual 617	java/lang/Boolean:booleanValue	()Z
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: invokestatic 623	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 626	java/lang/Thread:getId	()J
    //   31: lstore_3
    //   32: new 157	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 5
    //   50: ldc_w 628
    //   53: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: lload_3
    //   60: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: new 316	java/io/File
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 347	java/io/File:exists	()Z
    //   83: ifeq +22 -> 105
    //   86: iload_2
    //   87: istore_1
    //   88: aload 5
    //   90: invokevirtual 630	java/io/File:delete	()Z
    //   93: ifeq +18 -> 111
    //   96: aload 5
    //   98: invokevirtual 633	java/io/File:createNewFile	()Z
    //   101: istore_1
    //   102: goto +9 -> 111
    //   105: aload 5
    //   107: invokevirtual 633	java/io/File:createNewFile	()Z
    //   110: istore_1
    //   111: aload 5
    //   113: invokevirtual 630	java/io/File:delete	()Z
    //   116: pop
    //   117: goto +24 -> 141
    //   120: astore_0
    //   121: goto +34 -> 155
    //   124: astore 6
    //   126: ldc 80
    //   128: iconst_1
    //   129: ldc 143
    //   131: aload 6
    //   133: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: iload_2
    //   137: istore_1
    //   138: goto -27 -> 111
    //   141: getstatic 139	cooperation/qzone/cache/CacheManager:isStorageReallyCanwriteMap	Ljava/util/HashMap;
    //   144: aload_0
    //   145: iload_1
    //   146: invokestatic 636	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: iload_1
    //   154: ireturn
    //   155: aload 5
    //   157: invokevirtual 630	java/io/File:delete	()Z
    //   160: pop
    //   161: goto +5 -> 166
    //   164: aload_0
    //   165: athrow
    //   166: goto -2 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   87	67	1	bool1	boolean
    //   24	113	2	bool2	boolean
    //   31	29	3	l	long
    //   10	146	5	localObject	Object
    //   124	8	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	86	120	finally
    //   88	102	120	finally
    //   105	111	120	finally
    //   126	136	120	finally
    //   78	86	124	java/lang/Throwable
    //   88	102	124	java/lang/Throwable
    //   105	111	124	java/lang/Throwable
  }
  
  private static boolean isStorageSizeLow(String paramString)
  {
    for (;;)
    {
      try
      {
        StatFs localStatFs = new StatFs(paramString);
        long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
        if (l < 5242880L)
        {
          bool = true;
          if (bool)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("low storage: totalSize=");
            localStringBuilder.append(localStatFs.getBlockCount() * localStatFs.getBlockSize());
            localStringBuilder.append(", availableSize=");
            localStringBuilder.append(l);
            localStringBuilder.append(", external=");
            localStringBuilder.append(paramString);
            QLog.w("CacheManager", 1, localStringBuilder.toString());
          }
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CacheManager", 1, "", paramString);
        return true;
      }
      boolean bool = false;
    }
  }
  
  public static void onStorageMountChange()
  {
    isStorageReallyCanwriteMap.clear();
    mHasLoadSDCardName = false;
    resetStorePath(false);
  }
  
  static void resetStorePath(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      storeRootPath = getInternalCacheDir();
      break label19;
      storeRootPath = QZoneFilePath.ROOT_QZONE_PATH;
      label19:
      File localFile = new File(storeRootPath);
      if ((!localFile.exists()) && (!localFile.mkdirs()) && (QLog.isColorLevel())) {
        QLog.w("CacheManager", 2, "Unable to create external cache directory");
      }
      if (localFile.exists())
      {
        localFile = new File(storeRootPath, ".nomedia");
        if (!localFile.exists())
        {
          localFile.createNewFile();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
  }
  
  /* Error */
  private static void saveOldVer(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 244	cooperation/qzone/cache/CacheManager:getStoreRootPath	()Ljava/lang/String;
    //   3: astore_2
    //   4: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   7: ifnonnull +13 -> 20
    //   10: new 125	java/util/HashMap
    //   13: dup
    //   14: invokespecial 128	java/util/HashMap:<init>	()V
    //   17: putstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   20: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   23: aload_0
    //   24: iload_1
    //   25: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: pop
    //   32: aload_0
    //   33: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +15 -> 51
    //   39: new 316	java/io/File
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: goto +43 -> 91
    //   51: new 157	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: getstatic 331	java/io/File:separator	Ljava/lang/String;
    //   69: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: aload_0
    //   75: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: new 316	java/io/File
    //   82: dup
    //   83: aload_3
    //   84: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 347	java/io/File:exists	()Z
    //   95: ifeq +291 -> 386
    //   98: aload_2
    //   99: invokevirtual 453	java/io/File:isDirectory	()Z
    //   102: ifeq +284 -> 386
    //   105: new 316	java/io/File
    //   108: dup
    //   109: aload_2
    //   110: ldc_w 455
    //   113: invokespecial 458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 347	java/io/File:exists	()Z
    //   121: ifeq +7 -> 128
    //   124: aload_3
    //   125: invokestatic 344	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   128: aload_3
    //   129: invokevirtual 633	java/io/File:createNewFile	()Z
    //   132: pop
    //   133: goto +8 -> 141
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   141: aload_3
    //   142: invokevirtual 347	java/io/File:exists	()Z
    //   145: ifeq +189 -> 334
    //   148: aload_3
    //   149: invokevirtual 338	java/io/File:isFile	()Z
    //   152: ifeq +182 -> 334
    //   155: aconst_null
    //   156: astore 4
    //   158: aconst_null
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 6
    //   164: aconst_null
    //   165: astore_2
    //   166: new 660	java/io/BufferedWriter
    //   169: dup
    //   170: new 662	java/io/OutputStreamWriter
    //   173: dup
    //   174: new 664	java/io/FileOutputStream
    //   177: dup
    //   178: aload_3
    //   179: invokespecial 665	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   182: invokespecial 668	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   185: invokespecial 671	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   188: astore_3
    //   189: aload_3
    //   190: iload_1
    //   191: invokestatic 423	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 674	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: invokevirtual 677	java/io/BufferedWriter:newLine	()V
    //   201: aload_3
    //   202: invokevirtual 680	java/io/BufferedWriter:flush	()V
    //   205: aload_3
    //   206: invokevirtual 681	java/io/BufferedWriter:close	()V
    //   209: goto +125 -> 334
    //   212: astore_0
    //   213: aload_3
    //   214: astore_2
    //   215: goto +101 -> 316
    //   218: astore 4
    //   220: goto +24 -> 244
    //   223: astore 4
    //   225: goto +42 -> 267
    //   228: astore 4
    //   230: goto +60 -> 290
    //   233: astore_0
    //   234: goto +82 -> 316
    //   237: astore_2
    //   238: aload 4
    //   240: astore_3
    //   241: aload_2
    //   242: astore 4
    //   244: aload_3
    //   245: astore_2
    //   246: aload 4
    //   248: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   251: aload_3
    //   252: ifnull +82 -> 334
    //   255: aload_3
    //   256: invokevirtual 681	java/io/BufferedWriter:close	()V
    //   259: goto +75 -> 334
    //   262: astore 4
    //   264: aload 5
    //   266: astore_3
    //   267: aload_3
    //   268: astore_2
    //   269: aload 4
    //   271: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   274: aload_3
    //   275: ifnull +59 -> 334
    //   278: aload_3
    //   279: invokevirtual 681	java/io/BufferedWriter:close	()V
    //   282: goto +52 -> 334
    //   285: astore 4
    //   287: aload 6
    //   289: astore_3
    //   290: aload_3
    //   291: astore_2
    //   292: aload 4
    //   294: invokevirtual 486	java/io/FileNotFoundException:printStackTrace	()V
    //   297: aload_3
    //   298: ifnull +36 -> 334
    //   301: aload_3
    //   302: invokevirtual 681	java/io/BufferedWriter:close	()V
    //   305: goto +29 -> 334
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   313: goto +21 -> 334
    //   316: aload_2
    //   317: ifnull +15 -> 332
    //   320: aload_2
    //   321: invokevirtual 681	java/io/BufferedWriter:close	()V
    //   324: goto +8 -> 332
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 484	java/io/IOException:printStackTrace	()V
    //   332: aload_0
    //   333: athrow
    //   334: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +49 -> 386
    //   340: new 157	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   347: astore_2
    //   348: aload_2
    //   349: ldc_w 683
    //   352: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_2
    //   357: aload_0
    //   358: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_2
    //   363: ldc_w 498
    //   366: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_2
    //   371: iload_1
    //   372: invokevirtual 501	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 80
    //   378: iconst_2
    //   379: aload_2
    //   380: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 505	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramString	String
    //   0	387	1	paramInt	int
    //   3	107	2	localObject1	Object
    //   136	2	2	localIOException1	java.io.IOException
    //   165	50	2	localObject2	Object
    //   237	5	2	localException1	Exception
    //   245	47	2	localObject3	Object
    //   308	13	2	localIOException2	java.io.IOException
    //   327	2	2	localIOException3	java.io.IOException
    //   347	33	2	localStringBuilder	StringBuilder
    //   58	244	3	localObject4	Object
    //   156	1	4	localObject5	Object
    //   218	1	4	localException2	Exception
    //   223	1	4	localIOException4	java.io.IOException
    //   228	11	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   242	5	4	localException3	Exception
    //   262	8	4	localIOException5	java.io.IOException
    //   285	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   159	106	5	localObject6	Object
    //   162	126	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   128	133	136	java/io/IOException
    //   189	205	212	finally
    //   189	205	218	java/lang/Exception
    //   189	205	223	java/io/IOException
    //   189	205	228	java/io/FileNotFoundException
    //   166	189	233	finally
    //   246	251	233	finally
    //   269	274	233	finally
    //   292	297	233	finally
    //   166	189	237	java/lang/Exception
    //   166	189	262	java/io/IOException
    //   166	189	285	java/io/FileNotFoundException
    //   205	209	308	java/io/IOException
    //   255	259	308	java/io/IOException
    //   278	282	308	java/io/IOException
    //   301	305	308	java/io/IOException
    //   320	324	327	java/io/IOException
  }
  
  /* Error */
  private static void updateStorage(String paramString)
  {
    // Byte code:
    //   0: new 316	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 347	java/io/File:exists	()Z
    //   13: ifeq +249 -> 262
    //   16: new 460	java/io/BufferedReader
    //   19: dup
    //   20: new 686	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 687	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 472	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 475	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +143 -> 183
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 689
    //   49: invokevirtual 604	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 691
    //   61: invokevirtual 695	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_3
    //   68: arraylength
    //   69: iconst_3
    //   70: if_icmplt -38 -> 32
    //   73: aload_3
    //   74: iconst_2
    //   75: aaload
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_1
    //   79: aaload
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: new 316	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 347	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 137	cooperation/qzone/cache/CacheManager:mSDCardName2PathMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_1
    //   109: astore_0
    //   110: invokestatic 698	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   113: ifeq -81 -> 32
    //   116: aload_1
    //   117: astore_0
    //   118: new 157	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   125: astore 4
    //   127: aload_1
    //   128: astore_0
    //   129: aload 4
    //   131: ldc_w 700
    //   134: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: astore_0
    //   140: aload 4
    //   142: aload_3
    //   143: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: astore_0
    //   149: aload 4
    //   151: ldc_w 702
    //   154: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: astore_0
    //   160: aload 4
    //   162: aload_2
    //   163: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: astore_0
    //   169: ldc 80
    //   171: iconst_4
    //   172: aload 4
    //   174: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: goto -148 -> 32
    //   183: aload_1
    //   184: astore_0
    //   185: aload_1
    //   186: invokevirtual 481	java/io/BufferedReader:close	()V
    //   189: aload_1
    //   190: invokevirtual 481	java/io/BufferedReader:close	()V
    //   193: return
    //   194: astore_2
    //   195: goto +12 -> 207
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: goto +38 -> 239
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: astore_0
    //   209: ldc 80
    //   211: iconst_1
    //   212: ldc 143
    //   214: aload_2
    //   215: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload_1
    //   219: ifnull +43 -> 262
    //   222: aload_1
    //   223: invokevirtual 481	java/io/BufferedReader:close	()V
    //   226: return
    //   227: astore_0
    //   228: ldc 80
    //   230: iconst_1
    //   231: ldc 143
    //   233: aload_0
    //   234: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: return
    //   238: astore_1
    //   239: aload_0
    //   240: ifnull +20 -> 260
    //   243: aload_0
    //   244: invokevirtual 481	java/io/BufferedReader:close	()V
    //   247: goto +13 -> 260
    //   250: astore_0
    //   251: ldc 80
    //   253: iconst_1
    //   254: ldc 143
    //   256: aload_0
    //   257: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_1
    //   261: athrow
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	String
    //   31	159	1	localBufferedReader	java.io.BufferedReader
    //   198	1	1	localObject1	Object
    //   206	17	1	localObject2	Object
    //   238	23	1	localObject3	Object
    //   38	125	2	str	String
    //   194	1	2	localException1	Exception
    //   204	11	2	localException2	Exception
    //   64	79	3	localObject4	Object
    //   125	48	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	39	194	java/lang/Exception
    //   45	55	194	java/lang/Exception
    //   57	65	194	java/lang/Exception
    //   67	73	194	java/lang/Exception
    //   83	97	194	java/lang/Exception
    //   99	108	194	java/lang/Exception
    //   110	116	194	java/lang/Exception
    //   118	127	194	java/lang/Exception
    //   129	138	194	java/lang/Exception
    //   140	147	194	java/lang/Exception
    //   149	158	194	java/lang/Exception
    //   160	167	194	java/lang/Exception
    //   169	180	194	java/lang/Exception
    //   185	189	194	java/lang/Exception
    //   16	32	198	finally
    //   16	32	204	java/lang/Exception
    //   189	193	227	java/io/IOException
    //   222	226	227	java/io/IOException
    //   34	39	238	finally
    //   45	55	238	finally
    //   57	65	238	finally
    //   67	73	238	finally
    //   83	97	238	finally
    //   99	108	238	finally
    //   110	116	238	finally
    //   118	127	238	finally
    //   129	138	238	finally
    //   140	147	238	finally
    //   149	158	238	finally
    //   160	167	238	finally
    //   169	180	238	finally
    //   185	189	238	finally
    //   209	218	238	finally
    //   243	247	250	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */