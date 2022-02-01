package cooperation.qzone.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ResDownloadManger
{
  public static final int ALBUM_CROSSOVER_LOADING_BG_RESZIP = 4;
  public static final int ALBUM_CROSSOVER_LOADING_FIRST_BG_RESZIP = 7;
  public static final int BUFFER_SIZE_DECODE_BOUND = 8192;
  public static final String CRASH_TAG = "crash";
  public static final int QZONE_ADS_RES = 9;
  public static final int QZONE_FEED_RESZIP = 5;
  public static final int QZONE_OPEN_CAMERA_ANIM_RES = 10;
  public static final int QZONE_PHOTO_CATEGORY_EMPTY_PAGE_BG = 11;
  public static final int QZONE_PLUS_PUBLISH_VIDEO_GUIDE_ANIM_RES = 6;
  public static final int QZONE_POPUPWINDOW_NIGHT_MODE_ZIP = 13;
  public static final int QZONE_POPUPWINDOW_ZIP = 8;
  public static final int QZONE_RECENT_PHOTO_CALENDAR = 12;
  private static String[] RESURL = { "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v1.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_themeAlbum.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_plus_publish_video_anim_guide_resource.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_first_page_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_default.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_ads_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_list_slide_out_video_capture_anim.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_photo_category_empty_bgs.zip", "https://d3g.qq.com/sngapp/app/update/20181210212921_4631/qzone_recent_photo_calendar.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_night_mode.zip" };
  private static String ResPath;
  public static final String TAG = "ResDownloadManger";
  public static final int THEME_ALBUM_RESZIP = 1;
  public static final int YELLOW_DIAMOND_RESZIP = 0;
  private static String ZipPath;
  private static ResDownloadManger mInstance;
  private Context context = MobileQQ.getContext();
  private Downloader.DownloadListener mDownloadListener = new ResDownloadManger.2(this);
  private QzonePreDownloadManager mImageDownloader = null;
  private LruCache<String, Bitmap> mMemoryCache;
  private final MultiHashMap<String, ResEntry> mPendingRequests = new MultiHashMap();
  
  private ResDownloadManger()
  {
    ZipPath = getStorePath("qzonereszip");
    ResPath = getStorePath("qzoneres");
    this.mMemoryCache = new LruCache((int)(MemoryManager.d() / 8L));
  }
  
  private boolean addPendingRequest(String paramString, ResEntry paramResEntry)
  {
    for (;;)
    {
      synchronized (this.mPendingRequests)
      {
        int i = this.mPendingRequests.sizeOf(paramString);
        this.mPendingRequests.add(paramString, paramResEntry);
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private Collection<ResEntry> collectPendingRequest(String paramString, boolean paramBoolean)
  {
    return collectPendingRequest(paramString, paramBoolean, null);
  }
  
  private Collection<ResEntry> collectPendingRequest(String paramString, boolean paramBoolean, Collection<ResEntry> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramBoolean) {}
    try
    {
      for (paramString = this.mPendingRequests.remove(paramString);; paramString = this.mPendingRequests.get(paramString))
      {
        paramString = (HashSet)paramString;
        break;
      }
      if (paramCollection != null)
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static void createAndClearFile(File paramFile)
  {
    if (!paramFile.exists())
    {
      paramFile.mkdir();
      return;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return;
      }
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (!localObject.isDirectory()) {
          localObject.delete();
        }
        i += 1;
      }
    }
    paramFile.mkdir();
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 253	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: new 257	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_2
    //   18: sipush 8192
    //   21: invokespecial 260	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 266	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: invokevirtual 271	java/io/InputStream:close	()V
    //   36: aload_0
    //   37: areturn
    //   38: astore_1
    //   39: goto +16 -> 55
    //   42: astore_1
    //   43: goto +35 -> 78
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_0
    //   49: goto +61 -> 110
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +73 -> 133
    //   63: aload_2
    //   64: astore_0
    //   65: ldc 37
    //   67: iconst_2
    //   68: ldc_w 278
    //   71: aload_1
    //   72: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto +58 -> 133
    //   78: aload_2
    //   79: astore_0
    //   80: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +15 -> 98
    //   86: aload_2
    //   87: astore_0
    //   88: ldc 37
    //   90: iconst_2
    //   91: ldc_w 278
    //   94: aload_1
    //   95: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: ifnull +8 -> 107
    //   102: aload_3
    //   103: astore_0
    //   104: goto -72 -> 32
    //   107: aconst_null
    //   108: areturn
    //   109: astore_1
    //   110: aload_0
    //   111: ifnull +7 -> 118
    //   114: aload_0
    //   115: invokevirtual 271	java/io/InputStream:close	()V
    //   118: goto +5 -> 123
    //   121: aload_1
    //   122: athrow
    //   123: goto -2 -> 121
    //   126: astore_1
    //   127: aload_0
    //   128: areturn
    //   129: astore_0
    //   130: goto -12 -> 118
    //   133: aload_2
    //   134: ifnull -27 -> 107
    //   137: aload_3
    //   138: astore_0
    //   139: goto -107 -> 32
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: goto -67 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramString	String
    //   0	148	1	paramOptions	BitmapFactory.Options
    //   10	135	2	localFileInputStream	java.io.FileInputStream
    //   1	137	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	30	38	java/lang/Exception
    //   13	30	42	java/lang/OutOfMemoryError
    //   2	11	46	finally
    //   2	11	52	java/lang/Exception
    //   13	30	109	finally
    //   57	63	109	finally
    //   65	75	109	finally
    //   80	86	109	finally
    //   88	98	109	finally
    //   32	36	126	java/io/IOException
    //   114	118	129	java/io/IOException
    //   2	11	142	java/lang/OutOfMemoryError
  }
  
  private ResEntry generateEntry(String paramString1, int paramInt, String paramString2, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    ResEntry localResEntry = ResEntry.obtain(paramInt, paramString2);
    localResEntry.mUrl = paramString1;
    localResEntry.mResLoadListener = new WeakReference(paramResLoadListener);
    localResEntry.type = paramInt;
    localResEntry.fileName = paramString2;
    return localResEntry;
  }
  
  private QzonePreDownloadManager getDownloader()
  {
    try
    {
      if (this.mImageDownloader != null)
      {
        localQzonePreDownloadManager = this.mImageDownloader;
        return localQzonePreDownloadManager;
      }
      this.mImageDownloader = QzonePreDownloadManager.getInstance();
      QzonePreDownloadManager localQzonePreDownloadManager = this.mImageDownloader;
      return localQzonePreDownloadManager;
    }
    finally {}
  }
  
  private static File getFile(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ResPath);
      localStringBuilder.append(paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length() - 4));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".png");
      return new File(localStringBuilder.toString());
    }
    return null;
  }
  
  public static int getQzoneSkinFeedDropMenuResId()
  {
    if (QQTheme.isNowThemeIsNightForQzone()) {
      return 13;
    }
    return 8;
  }
  
  private static String getStorePath(String paramString)
  {
    String str = MobileQQ.getContext().getCacheDir().getAbsolutePath();
    Object localObject = paramString;
    if (!paramString.startsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (!((String)localObject).endsWith(File.separator))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(File.separator);
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString);
    paramString = new File(((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    localObject = paramString.getAbsolutePath();
    paramString = (String)localObject;
    if (!((String)localObject).endsWith(File.separator))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(File.separator);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static String getZipPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ZipPath);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static ResDownloadManger getmInstance()
  {
    if (mInstance == null) {
      try
      {
        mInstance = new ResDownloadManger();
      }
      finally {}
    }
    return mInstance;
  }
  
  private static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static void setResUrl(int paramInt, String paramString)
  {
    RESURL[paramInt] = paramString;
  }
  
  private void starDownLoad(ResEntry paramResEntry)
  {
    if (URLUtil.isNetworkUrl(paramResEntry.mUrl))
    {
      String str = getZipPath(paramResEntry.mUrl);
      getDownloader().download(paramResEntry.mUrl, str, true, this.mDownloadListener);
    }
  }
  
  private static void unzipFile(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ResPath);
    ((StringBuilder)localObject).append(paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4));
    localObject = ((StringBuilder)localObject).toString();
    createAndClearFile(new File((String)localObject));
    ZipUtils.unZipFolder(paramString, (String)localObject);
  }
  
  public Drawable getDrawable(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    paramString = getResBitmap(paramInt, paramString, paramResLoadListener);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.getDensityDpi());
      return paramString;
    }
    return null;
  }
  
  public Drawable getDrawableAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    paramString = getResBitmapAsync(paramInt, paramString, paramResLoadListener, null);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.getDensityDpi());
      return paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebanew", 4, "qzonepouwindow:下载资源失败");
    }
    return null;
  }
  
  public Drawable getDrawableAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    paramString = getResBitmapAsync(paramInt, paramString, paramResLoadListener, paramOptions);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.getDensityDpi());
      return paramString;
    }
    return null;
  }
  
  public Drawable getDrawableByBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap.setDensity(320);
      paramBitmap = new BitmapDrawable(paramBitmap);
      paramBitmap.setTargetDensity((int)ViewUtils.getDensityDpi());
      return paramBitmap;
    }
    return null;
  }
  
  /* Error */
  public Bitmap getResBitmap(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 143	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/util/LruCache;
    //   13: astore 4
    //   15: new 321	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   22: astore 5
    //   24: aload 5
    //   26: iload_1
    //   27: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: ldc_w 451
    //   36: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: aload_2
    //   43: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: aload 5
    //   51: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 452	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 414	android/graphics/Bitmap
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +6 -> 70
    //   67: aload 4
    //   69: areturn
    //   70: getstatic 90	cooperation/qzone/util/ResDownloadManger:RESURL	[Ljava/lang/String;
    //   73: iload_1
    //   74: aaload
    //   75: astore 7
    //   77: aload 7
    //   79: aload_2
    //   80: invokestatic 150	cooperation/qzone/util/ResDownloadManger:getFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   83: astore 6
    //   85: aload 6
    //   87: invokestatic 155	cooperation/qzone/util/ResDownloadManger:isFileValid	(Ljava/io/File;)Z
    //   90: ifeq +207 -> 297
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 143	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/util/LruCache;
    //   99: astore 5
    //   101: new 321	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   108: astore 8
    //   110: aload 8
    //   112: iload_1
    //   113: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 8
    //   119: ldc_w 451
    //   122: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 8
    //   128: aload_2
    //   129: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: aload 8
    //   137: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokevirtual 452	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast 414	android/graphics/Bitmap
    //   146: astore 5
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload_0
    //   154: monitorexit
    //   155: aload 5
    //   157: areturn
    //   158: ldc 37
    //   160: iconst_1
    //   161: ldc_w 454
    //   164: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload 6
    //   169: invokevirtual 365	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   172: aconst_null
    //   173: invokestatic 459	cooperation/qzone/util/ResDownloadManger:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   176: astore 4
    //   178: goto +52 -> 230
    //   181: astore 6
    //   183: aload 5
    //   185: astore 4
    //   187: goto +18 -> 205
    //   190: astore 6
    //   192: aload 5
    //   194: astore 4
    //   196: goto +23 -> 219
    //   199: astore_2
    //   200: goto +93 -> 293
    //   203: astore 6
    //   205: ldc 15
    //   207: iconst_1
    //   208: aload 6
    //   210: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   213: invokestatic 462	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: goto +14 -> 230
    //   219: ldc 15
    //   221: iconst_1
    //   222: aload 6
    //   224: invokevirtual 463	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   227: invokestatic 462	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_0
    //   231: monitorexit
    //   232: aload 4
    //   234: astore 5
    //   236: aload 4
    //   238: ifnull +72 -> 310
    //   241: aload_0
    //   242: getfield 143	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/util/LruCache;
    //   245: astore_3
    //   246: new 321	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   253: astore 5
    //   255: aload 5
    //   257: iload_1
    //   258: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 5
    //   264: ldc_w 451
    //   267: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 5
    //   273: aload_2
    //   274: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_3
    //   279: aload 5
    //   281: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aload 4
    //   286: invokevirtual 467	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: aload 4
    //   292: areturn
    //   293: aload_0
    //   294: monitorexit
    //   295: aload_2
    //   296: athrow
    //   297: ldc 37
    //   299: iconst_1
    //   300: ldc_w 469
    //   303: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 4
    //   308: astore 5
    //   310: aload_0
    //   311: aload 7
    //   313: iload_1
    //   314: aload_2
    //   315: aload_3
    //   316: invokespecial 163	cooperation/qzone/util/ResDownloadManger:generateEntry	(Ljava/lang/String;ILjava/lang/String;Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;)Lcooperation/qzone/util/ResEntry;
    //   319: astore_2
    //   320: aload_0
    //   321: aload 7
    //   323: aload_2
    //   324: invokespecial 169	cooperation/qzone/util/ResDownloadManger:addPendingRequest	(Ljava/lang/String;Lcooperation/qzone/util/ResEntry;)Z
    //   327: ifeq +8 -> 335
    //   330: aload_0
    //   331: aload_2
    //   332: invokespecial 175	cooperation/qzone/util/ResDownloadManger:starDownLoad	(Lcooperation/qzone/util/ResEntry;)V
    //   335: aload 5
    //   337: areturn
    //   338: astore 6
    //   340: goto -121 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	ResDownloadManger
    //   0	343	1	paramInt	int
    //   0	343	2	paramString	String
    //   0	343	3	paramResLoadListener	ResDownloadManger.ResLoadListener
    //   13	294	4	localObject1	Object
    //   22	314	5	localObject2	Object
    //   83	85	6	localFile	File
    //   181	1	6	localException1	java.lang.Exception
    //   190	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   203	20	6	localException2	java.lang.Exception
    //   338	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   75	247	7	str	String
    //   108	28	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   158	178	181	java/lang/Exception
    //   158	178	190	java/lang/OutOfMemoryError
    //   95	148	199	finally
    //   153	155	199	finally
    //   158	178	199	finally
    //   205	216	199	finally
    //   219	230	199	finally
    //   230	232	199	finally
    //   293	295	199	finally
    //   95	148	203	java/lang/Exception
    //   95	148	338	java/lang/OutOfMemoryError
  }
  
  public Bitmap getResBitmapAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.mMemoryCache;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    localObject = (Bitmap)((LruCache)localObject).get(localStringBuilder.toString());
    if (localObject != null) {
      return localObject;
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ResDownloadManger.1(this, paramInt, paramString, paramResLoadListener, paramOptions));
    return localObject;
  }
  
  public boolean isFileDownload(int paramInt)
  {
    Object localObject = RESURL[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ResPath);
    localStringBuilder.append(((String)localObject).substring(((String)localObject).lastIndexOf("/"), ((String)localObject).length() - 4));
    localStringBuilder.append(File.separator);
    localObject = new File(localStringBuilder.toString());
    return (((File)localObject).isDirectory()) && (((File)localObject).list() != null) && (((File)localObject).list().length > 0);
  }
  
  public void removeCache(int paramInt, ArrayList<String> paramArrayList)
  {
    if ((this.mMemoryCache != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        LruCache localLruCache = this.mMemoryCache;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" ");
        localStringBuilder.append(str);
        localLruCache.remove(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger
 * JD-Core Version:    0.7.0.1
 */