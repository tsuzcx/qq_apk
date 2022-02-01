package cooperation.qzone.cache;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
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
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + countToUnit(paramInt);
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
    paramContext = getAudioFileCacheService().getFile("audio_gift_" + paramContext, true);
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
    paramContext = getAudioFileCacheService().getFile(paramLong + "_" + paramContext, true);
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
    paramString = new File(str + File.separator + paramString);
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
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + UUID.randomUUID().toString() + ".jpg");
  }
  
  public static String getDehazeDir()
  {
    return getCacheDir("dehaze_pic");
  }
  
  public static FileCacheService getFileCacheService(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      AssertUtil.assertTrue(bool);
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
      bool = false;
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
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i = paramString.hashCode();
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        paramContext = QZoneFilePath.CACHE_DIR_IMAGE;
        if (paramContext != null) {
          break label98;
        }
      }
      label98:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i))
      {
        return paramContext;
        paramContext = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "image";
        break;
      }
      paramString = str;
    }
  }
  
  public static String getInternalCacheDir()
  {
    File localFile = BaseApplicationImpl.getContext().getCacheDir();
    if (localFile != null) {
      return localFile.getAbsolutePath() + File.separator + "qzone";
    }
    return null;
  }
  
  public static String getInternalCacheDir(String paramString)
  {
    String str = getInternalCacheDir();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
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
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +10 -> 38
    //   31: aload_3
    //   32: invokevirtual 450	java/lang/Integer:intValue	()I
    //   35: istore_2
    //   36: iload_2
    //   37: ireturn
    //   38: invokestatic 244	cooperation/qzone/cache/CacheManager:getStoreRootPath	()Ljava/lang/String;
    //   41: astore_3
    //   42: aload_0
    //   43: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +177 -> 223
    //   49: new 316	java/io/File
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 347	java/io/File:exists	()Z
    //   62: ifeq +357 -> 419
    //   65: aload_3
    //   66: invokevirtual 453	java/io/File:isDirectory	()Z
    //   69: ifeq +350 -> 419
    //   72: new 316	java/io/File
    //   75: dup
    //   76: aload_3
    //   77: ldc_w 455
    //   80: invokespecial 458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   83: astore_3
    //   84: aload_3
    //   85: invokevirtual 347	java/io/File:exists	()Z
    //   88: ifeq +331 -> 419
    //   91: aload_3
    //   92: invokevirtual 338	java/io/File:isFile	()Z
    //   95: ifeq +324 -> 419
    //   98: aconst_null
    //   99: astore 6
    //   101: aconst_null
    //   102: astore 4
    //   104: aconst_null
    //   105: astore 5
    //   107: new 460	java/io/BufferedReader
    //   110: dup
    //   111: new 462	java/io/InputStreamReader
    //   114: dup
    //   115: new 464	java/io/FileInputStream
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 466	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: invokespecial 469	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   126: invokespecial 472	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   129: astore_3
    //   130: aload_3
    //   131: astore 4
    //   133: aload_3
    //   134: invokevirtual 475	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +283 -> 424
    //   144: aload_3
    //   145: astore 4
    //   147: aload 5
    //   149: invokestatic 478	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: iload_2
    //   154: istore_1
    //   155: aload_3
    //   156: ifnull +9 -> 165
    //   159: aload_3
    //   160: invokevirtual 481	java/io/BufferedReader:close	()V
    //   163: iload_2
    //   164: istore_1
    //   165: getstatic 445	cooperation/qzone/cache/CacheManager:VersionMap	Ljava/util/HashMap;
    //   168: aload_0
    //   169: iload_1
    //   170: invokestatic 484	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: iload_1
    //   178: istore_2
    //   179: invokestatic 489	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -146 -> 36
    //   185: ldc 80
    //   187: iconst_2
    //   188: new 157	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 491
    //   198: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 493
    //   208: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload_1
    //   212: invokevirtual 496	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 500	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_1
    //   222: ireturn
    //   223: new 316	java/io/File
    //   226: dup
    //   227: new 157	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   234: aload_3
    //   235: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: getstatic 331	java/io/File:separator	Ljava/lang/String;
    //   241: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: astore_3
    //   255: goto -197 -> 58
    //   258: astore_3
    //   259: aload_3
    //   260: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   263: iload_2
    //   264: istore_1
    //   265: goto -100 -> 165
    //   268: astore 5
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: astore 4
    //   275: aload 5
    //   277: invokevirtual 504	java/io/FileNotFoundException:printStackTrace	()V
    //   280: aload_3
    //   281: ifnull +138 -> 419
    //   284: aload_3
    //   285: invokevirtual 481	java/io/BufferedReader:close	()V
    //   288: iconst_0
    //   289: istore_1
    //   290: goto -125 -> 165
    //   293: astore_3
    //   294: aload_3
    //   295: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   298: iconst_0
    //   299: istore_1
    //   300: goto -135 -> 165
    //   303: astore 4
    //   305: aload 5
    //   307: astore_3
    //   308: aload 4
    //   310: astore 5
    //   312: aload_3
    //   313: astore 4
    //   315: aload 5
    //   317: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   320: aload_3
    //   321: ifnull +98 -> 419
    //   324: aload_3
    //   325: invokevirtual 481	java/io/BufferedReader:close	()V
    //   328: iconst_0
    //   329: istore_1
    //   330: goto -165 -> 165
    //   333: astore_3
    //   334: aload_3
    //   335: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   338: iconst_0
    //   339: istore_1
    //   340: goto -175 -> 165
    //   343: astore 5
    //   345: aload 6
    //   347: astore_3
    //   348: aload_3
    //   349: astore 4
    //   351: aload 5
    //   353: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   356: aload_3
    //   357: ifnull +62 -> 419
    //   360: aload_3
    //   361: invokevirtual 481	java/io/BufferedReader:close	()V
    //   364: iconst_0
    //   365: istore_1
    //   366: goto -201 -> 165
    //   369: astore_3
    //   370: aload_3
    //   371: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   374: iconst_0
    //   375: istore_1
    //   376: goto -211 -> 165
    //   379: astore_0
    //   380: aload 4
    //   382: ifnull +8 -> 390
    //   385: aload 4
    //   387: invokevirtual 481	java/io/BufferedReader:close	()V
    //   390: aload_0
    //   391: athrow
    //   392: astore_3
    //   393: aload_3
    //   394: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   397: goto -7 -> 390
    //   400: astore_0
    //   401: goto -21 -> 380
    //   404: astore 5
    //   406: goto -58 -> 348
    //   409: astore 5
    //   411: goto -99 -> 312
    //   414: astore 5
    //   416: goto -144 -> 272
    //   419: iconst_0
    //   420: istore_1
    //   421: goto -256 -> 165
    //   424: iconst_0
    //   425: istore_2
    //   426: goto -273 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString	String
    //   154	267	1	i	int
    //   35	391	2	j	int
    //   26	229	3	localObject1	Object
    //   258	2	3	localIOException1	java.io.IOException
    //   271	14	3	localObject2	Object
    //   293	2	3	localIOException2	java.io.IOException
    //   307	18	3	localObject3	Object
    //   333	2	3	localIOException3	java.io.IOException
    //   347	14	3	localObject4	Object
    //   369	2	3	localIOException4	java.io.IOException
    //   392	2	3	localIOException5	java.io.IOException
    //   102	172	4	localObject5	Object
    //   303	6	4	localIOException6	java.io.IOException
    //   313	73	4	localObject6	Object
    //   105	43	5	str	String
    //   268	38	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   310	6	5	localIOException7	java.io.IOException
    //   343	9	5	localException1	Exception
    //   404	1	5	localException2	Exception
    //   409	1	5	localIOException8	java.io.IOException
    //   414	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   99	247	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   159	163	258	java/io/IOException
    //   107	130	268	java/io/FileNotFoundException
    //   284	288	293	java/io/IOException
    //   107	130	303	java/io/IOException
    //   324	328	333	java/io/IOException
    //   107	130	343	java/lang/Exception
    //   360	364	369	java/io/IOException
    //   107	130	379	finally
    //   315	320	379	finally
    //   351	356	379	finally
    //   385	390	392	java/io/IOException
    //   133	139	400	finally
    //   147	153	400	finally
    //   275	280	400	finally
    //   133	139	404	java/lang/Exception
    //   147	153	404	java/lang/Exception
    //   133	139	409	java/io/IOException
    //   147	153	409	java/io/IOException
    //   133	139	414	java/io/FileNotFoundException
    //   147	153	414	java/io/FileNotFoundException
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
    if (storeRootPath == null) {}
    try
    {
      if (storeRootPath == null) {
        resetStorePath(false);
      }
      return storeRootPath;
    }
    finally {}
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
    Object localObject = QZoneFilePath.ROOT_QZONE_PATH;
    if (localObject != null)
    {
      File localFile = new File((String)localObject);
      if (localFile.isFile()) {
        FileUtils.delete(localFile);
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    localObject = new File((String)localObject + File.separator + "video_cache");
    if (((File)localObject).isFile()) {
      FileUtils.delete((File)localObject);
    }
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
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
  
  public static boolean isExternalAvailableWithPermission(Context paramContext)
  {
    return (BaseApplicationImpl.isHasStoragePermission(paramContext)) && (SDCardMountMonitorReceiver.getInstance().isSDCardMount());
  }
  
  public static boolean isInternal(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (!URLUtil.isNetworkUrl(paramString));
    return true;
  }
  
  public static boolean isStorageReallyCanwrite(String paramString)
  {
    localObject = (Boolean)isStorageReallyCanwriteMap.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CacheManager", 1, "", localThrowable);
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      isStorageReallyCanwriteMap.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  private static boolean isStorageSizeLow(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < 5242880L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("CacheManager", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", external=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("CacheManager", 1, "", paramString);
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
    for (;;)
    {
      try
      {
        storeRootPath = getInternalCacheDir();
        File localFile = new File(storeRootPath);
        if ((!localFile.exists()) && (!localFile.mkdirs()) && (QLog.isColorLevel())) {
          QLog.w("CacheManager", 2, "Unable to create external cache directory");
        }
        if (!localFile.exists()) {
          return;
        }
        localFile = new File(storeRootPath, ".nomedia");
        if (localFile.exists()) {
          return;
        }
        localFile.createNewFile();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("CacheManager", 1, "", localException);
      }
      storeRootPath = QZoneFilePath.ROOT_QZONE_PATH;
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
    //   25: invokestatic 484	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: pop
    //   32: aload_0
    //   33: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +172 -> 208
    //   39: new 316	java/io/File
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 347	java/io/File:exists	()Z
    //   52: ifeq +155 -> 207
    //   55: aload_2
    //   56: invokevirtual 453	java/io/File:isDirectory	()Z
    //   59: ifeq +148 -> 207
    //   62: new 316	java/io/File
    //   65: dup
    //   66: aload_2
    //   67: ldc_w 455
    //   70: invokespecial 458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 347	java/io/File:exists	()Z
    //   78: ifeq +7 -> 85
    //   81: aload_3
    //   82: invokestatic 344	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   85: aload_3
    //   86: invokevirtual 638	java/io/File:createNewFile	()Z
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 347	java/io/File:exists	()Z
    //   94: ifeq +71 -> 165
    //   97: aload_3
    //   98: invokevirtual 338	java/io/File:isFile	()Z
    //   101: ifeq +64 -> 165
    //   104: aconst_null
    //   105: astore 5
    //   107: aconst_null
    //   108: astore_2
    //   109: aconst_null
    //   110: astore 4
    //   112: new 665	java/io/BufferedWriter
    //   115: dup
    //   116: new 667	java/io/OutputStreamWriter
    //   119: dup
    //   120: new 669	java/io/FileOutputStream
    //   123: dup
    //   124: aload_3
    //   125: invokespecial 670	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 673	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   131: invokespecial 676	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   134: astore_3
    //   135: aload_3
    //   136: astore_2
    //   137: aload_3
    //   138: iload_1
    //   139: invokestatic 423	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   142: invokevirtual 679	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   145: aload_3
    //   146: astore_2
    //   147: aload_3
    //   148: invokevirtual 682	java/io/BufferedWriter:newLine	()V
    //   151: aload_3
    //   152: astore_2
    //   153: aload_3
    //   154: invokevirtual 685	java/io/BufferedWriter:flush	()V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 686	java/io/BufferedWriter:close	()V
    //   165: invokestatic 489	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +39 -> 207
    //   171: ldc 80
    //   173: iconst_2
    //   174: new 157	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 688
    //   184: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 493
    //   194: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_1
    //   198: invokevirtual 496	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 500	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: return
    //   208: new 316	java/io/File
    //   211: dup
    //   212: new 157	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   219: aload_2
    //   220: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: getstatic 331	java/io/File:separator	Ljava/lang/String;
    //   226: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore_2
    //   240: goto -192 -> 48
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   248: goto -158 -> 90
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   256: goto -91 -> 165
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_3
    //   263: aload_3
    //   264: astore_2
    //   265: aload 4
    //   267: invokevirtual 504	java/io/FileNotFoundException:printStackTrace	()V
    //   270: aload_3
    //   271: ifnull -106 -> 165
    //   274: aload_3
    //   275: invokevirtual 686	java/io/BufferedWriter:close	()V
    //   278: goto -113 -> 165
    //   281: astore_2
    //   282: aload_2
    //   283: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   286: goto -121 -> 165
    //   289: astore_2
    //   290: aload 4
    //   292: astore_3
    //   293: aload_2
    //   294: astore 4
    //   296: aload_3
    //   297: astore_2
    //   298: aload 4
    //   300: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   303: aload_3
    //   304: ifnull -139 -> 165
    //   307: aload_3
    //   308: invokevirtual 686	java/io/BufferedWriter:close	()V
    //   311: goto -146 -> 165
    //   314: astore_2
    //   315: aload_2
    //   316: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   319: goto -154 -> 165
    //   322: astore 4
    //   324: aload 5
    //   326: astore_3
    //   327: aload_3
    //   328: astore_2
    //   329: aload 4
    //   331: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   334: aload_3
    //   335: ifnull -170 -> 165
    //   338: aload_3
    //   339: invokevirtual 686	java/io/BufferedWriter:close	()V
    //   342: goto -177 -> 165
    //   345: astore_2
    //   346: aload_2
    //   347: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   350: goto -185 -> 165
    //   353: astore_0
    //   354: aload_2
    //   355: ifnull +7 -> 362
    //   358: aload_2
    //   359: invokevirtual 686	java/io/BufferedWriter:close	()V
    //   362: aload_0
    //   363: athrow
    //   364: astore_2
    //   365: aload_2
    //   366: invokevirtual 503	java/io/IOException:printStackTrace	()V
    //   369: goto -7 -> 362
    //   372: astore_0
    //   373: goto -19 -> 354
    //   376: astore 4
    //   378: goto -51 -> 327
    //   381: astore 4
    //   383: goto -87 -> 296
    //   386: astore 4
    //   388: goto -125 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString	String
    //   0	391	1	paramInt	int
    //   3	237	2	localObject1	Object
    //   243	2	2	localIOException1	java.io.IOException
    //   251	2	2	localIOException2	java.io.IOException
    //   264	1	2	localObject2	Object
    //   281	2	2	localIOException3	java.io.IOException
    //   289	5	2	localIOException4	java.io.IOException
    //   297	1	2	localObject3	Object
    //   314	2	2	localIOException5	java.io.IOException
    //   328	1	2	localObject4	Object
    //   345	14	2	localIOException6	java.io.IOException
    //   364	2	2	localIOException7	java.io.IOException
    //   73	266	3	localObject5	Object
    //   110	1	4	localObject6	Object
    //   259	32	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   294	5	4	localIOException8	java.io.IOException
    //   322	8	4	localException1	Exception
    //   376	1	4	localException2	Exception
    //   381	1	4	localIOException9	java.io.IOException
    //   386	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   105	220	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   85	90	243	java/io/IOException
    //   161	165	251	java/io/IOException
    //   112	135	259	java/io/FileNotFoundException
    //   274	278	281	java/io/IOException
    //   112	135	289	java/io/IOException
    //   307	311	314	java/io/IOException
    //   112	135	322	java/lang/Exception
    //   338	342	345	java/io/IOException
    //   112	135	353	finally
    //   298	303	353	finally
    //   329	334	353	finally
    //   358	362	364	java/io/IOException
    //   137	145	372	finally
    //   147	151	372	finally
    //   153	157	372	finally
    //   265	270	372	finally
    //   137	145	376	java/lang/Exception
    //   147	151	376	java/lang/Exception
    //   153	157	376	java/lang/Exception
    //   137	145	381	java/io/IOException
    //   147	151	381	java/io/IOException
    //   153	157	381	java/io/IOException
    //   137	145	386	java/io/FileNotFoundException
    //   147	151	386	java/io/FileNotFoundException
    //   153	157	386	java/io/FileNotFoundException
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
    //   13: ifeq +164 -> 177
    //   16: new 460	java/io/BufferedReader
    //   19: dup
    //   20: new 691	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 692	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 472	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 475	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +138 -> 178
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 694
    //   49: invokevirtual 609	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 696
    //   61: invokevirtual 700	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   110: invokestatic 703	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   113: ifeq -81 -> 32
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 80
    //   120: iconst_4
    //   121: new 157	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 705
    //   131: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 707
    //   141: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 710	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -122 -> 32
    //   157: astore_2
    //   158: aload_1
    //   159: astore_0
    //   160: ldc 80
    //   162: iconst_1
    //   163: ldc 143
    //   165: aload_2
    //   166: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 481	java/io/BufferedReader:close	()V
    //   177: return
    //   178: aload_1
    //   179: astore_0
    //   180: aload_1
    //   181: invokevirtual 481	java/io/BufferedReader:close	()V
    //   184: aload_1
    //   185: ifnull -8 -> 177
    //   188: aload_1
    //   189: invokevirtual 481	java/io/BufferedReader:close	()V
    //   192: return
    //   193: astore_0
    //   194: ldc 80
    //   196: iconst_1
    //   197: ldc 143
    //   199: aload_0
    //   200: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: return
    //   204: astore_0
    //   205: ldc 80
    //   207: iconst_1
    //   208: ldc 143
    //   210: aload_0
    //   211: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: return
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_0
    //   219: ifnull +7 -> 226
    //   222: aload_0
    //   223: invokevirtual 481	java/io/BufferedReader:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_0
    //   229: ldc 80
    //   231: iconst_1
    //   232: ldc 143
    //   234: aload_0
    //   235: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -12 -> 226
    //   241: astore_1
    //   242: goto -24 -> 218
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -90 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramString	String
    //   31	158	1	localBufferedReader	java.io.BufferedReader
    //   215	12	1	localObject1	Object
    //   241	1	1	localObject2	Object
    //   247	1	1	localObject3	Object
    //   38	107	2	str	String
    //   157	9	2	localException1	Exception
    //   245	1	2	localException2	Exception
    //   64	71	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	157	java/lang/Exception
    //   45	55	157	java/lang/Exception
    //   57	65	157	java/lang/Exception
    //   67	73	157	java/lang/Exception
    //   83	97	157	java/lang/Exception
    //   99	108	157	java/lang/Exception
    //   110	116	157	java/lang/Exception
    //   118	154	157	java/lang/Exception
    //   180	184	157	java/lang/Exception
    //   188	192	193	java/io/IOException
    //   173	177	204	java/io/IOException
    //   16	32	215	finally
    //   222	226	228	java/io/IOException
    //   34	39	241	finally
    //   45	55	241	finally
    //   57	65	241	finally
    //   67	73	241	finally
    //   83	97	241	finally
    //   99	108	241	finally
    //   110	116	241	finally
    //   118	154	241	finally
    //   160	169	241	finally
    //   180	184	241	finally
    //   16	32	245	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */