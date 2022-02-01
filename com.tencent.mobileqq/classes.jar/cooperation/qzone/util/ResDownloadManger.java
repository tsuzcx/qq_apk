package cooperation.qzone.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.theme.ThemeUtil;
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
  private static ResDownloadManger mInstance = null;
  private Context context = BaseApplicationImpl.getContext();
  private Downloader.DownloadListener mDownloadListener = new ResDownloadManger.2(this);
  private QzonePreDownloadManager mImageDownloader = null;
  private LruCache<String, Bitmap> mMemoryCache;
  private final MultiHashMap<String, ResEntry> mPendingRequests = new MultiHashMap();
  
  private ResDownloadManger()
  {
    ZipPath = getStorePath("qzonereszip");
    ResPath = getStorePath("qzoneres");
    this.mMemoryCache = new LruCache((int)(MemoryManager.a() / 8L));
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
      for (paramString = (HashSet)this.mPendingRequests.remove(paramString); paramCollection != null; paramString = (HashSet)this.mPendingRequests.get(paramString))
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
  }
  
  private static void createAndClearFile(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    for (;;)
    {
      return;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
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
    }
    paramFile.mkdir();
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 255	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 257	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: new 259	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_2
    //   18: sipush 8192
    //   21: invokespecial 262	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 268	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: ifnull +9 -> 42
    //   36: aload_2
    //   37: invokevirtual 273	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_0
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +15 -> 67
    //   55: aload_2
    //   56: astore_0
    //   57: ldc 37
    //   59: iconst_2
    //   60: ldc_w 280
    //   63: aload_1
    //   64: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   67: aload_3
    //   68: astore_0
    //   69: aload_2
    //   70: ifnull -28 -> 42
    //   73: aload_2
    //   74: invokevirtual 273	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_0
    //   87: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +15 -> 105
    //   93: aload_2
    //   94: astore_0
    //   95: ldc 37
    //   97: iconst_2
    //   98: ldc_w 280
    //   101: aload_1
    //   102: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_3
    //   106: astore_0
    //   107: aload_2
    //   108: ifnull -66 -> 42
    //   111: aload_2
    //   112: invokevirtual 273	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 273	java/io/InputStream:close	()V
    //   131: aload_1
    //   132: athrow
    //   133: astore_0
    //   134: aload_1
    //   135: areturn
    //   136: astore_0
    //   137: goto -6 -> 131
    //   140: astore_1
    //   141: goto -18 -> 123
    //   144: astore_1
    //   145: goto -60 -> 85
    //   148: astore_1
    //   149: goto -102 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   0	152	1	paramOptions	BitmapFactory.Options
    //   10	102	2	localFileInputStream	java.io.FileInputStream
    //   1	105	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	java/lang/OutOfMemoryError
    //   73	77	79	java/io/IOException
    //   2	11	82	java/lang/Exception
    //   111	115	117	java/io/IOException
    //   2	11	120	finally
    //   36	40	133	java/io/IOException
    //   127	131	136	java/io/IOException
    //   13	30	140	finally
    //   49	55	140	finally
    //   57	67	140	finally
    //   87	93	140	finally
    //   95	105	140	finally
    //   13	30	144	java/lang/Exception
    //   13	30	148	java/lang/OutOfMemoryError
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
  
  /* Error */
  private QzonePreDownloadManager getDownloader()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	cooperation/qzone/util/ResDownloadManger:mImageDownloader	Lcooperation/qzone/QzonePreDownloadManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 98	cooperation/qzone/util/ResDownloadManger:mImageDownloader	Lcooperation/qzone/QzonePreDownloadManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 315	cooperation/qzone/QzonePreDownloadManager:getInstance	()Lcooperation/qzone/QzonePreDownloadManager;
    //   22: putfield 98	cooperation/qzone/util/ResDownloadManger:mImageDownloader	Lcooperation/qzone/QzonePreDownloadManager;
    //   25: aload_0
    //   26: getfield 98	cooperation/qzone/util/ResDownloadManger:mImageDownloader	Lcooperation/qzone/QzonePreDownloadManager;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ResDownloadManger
    //   13	17	1	localQzonePreDownloadManager	QzonePreDownloadManager
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   18	30	33	finally
  }
  
  private static File getFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return new File(ResPath + paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length() - 4) + File.separator + paramString2 + ".png");
  }
  
  public static int getQzoneSkinFeedDropMenuResId()
  {
    if (ThemeUtil.isNowThemeIsNightForQzone()) {
      return 13;
    }
    return 8;
  }
  
  private static String getStorePath(String paramString)
  {
    String str2 = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath();
    String str1 = paramString;
    if (!paramString.startsWith(File.separator)) {
      str1 = File.separator + paramString;
    }
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    paramString = new File(str2 + paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    str1 = paramString.getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    return paramString;
  }
  
  private static String getZipPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    return ZipPath + paramString;
  }
  
  public static ResDownloadManger getmInstance()
  {
    if (mInstance == null) {}
    try
    {
      mInstance = new ResDownloadManger();
      return mInstance;
    }
    finally {}
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
    String str = ResPath + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
    createAndClearFile(new File(str));
    ZipUtils.unZipFolder(paramString, str);
  }
  
  public Drawable getDrawable(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    paramString = getResBitmap(paramInt, paramString, paramResLoadListener);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.c());
      return paramString;
    }
    return null;
  }
  
  public Drawable getDrawableAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    Object localObject = null;
    paramString = getResBitmapAsync(paramInt, paramString, paramResLoadListener, null);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.c());
    }
    do
    {
      return paramString;
      paramString = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebanew", 4, "qzonepouwindow:下载资源失败");
    return null;
  }
  
  public Drawable getDrawableAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    paramString = getResBitmapAsync(paramInt, paramString, paramResLoadListener, paramOptions);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.c());
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
      paramBitmap.setTargetDensity((int)ViewUtils.c());
      return paramBitmap;
    }
    return null;
  }
  
  /* Error */
  public Bitmap getResBitmap(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: invokestatic 321	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 5
    //   12: areturn
    //   13: aload_0
    //   14: getfield 145	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/support/v4/util/LruCache;
    //   17: new 323	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 452
    //   31: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 453	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 414	android/graphics/Bitmap
    //   47: astore 4
    //   49: aload 4
    //   51: astore 5
    //   53: aload 4
    //   55: ifnonnull -45 -> 10
    //   58: getstatic 92	cooperation/qzone/util/ResDownloadManger:RESURL	[Ljava/lang/String;
    //   61: iload_1
    //   62: aaload
    //   63: astore 7
    //   65: aload 7
    //   67: aload_2
    //   68: invokestatic 152	cooperation/qzone/util/ResDownloadManger:getFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   71: astore 8
    //   73: aload 8
    //   75: invokestatic 157	cooperation/qzone/util/ResDownloadManger:isFileValid	(Ljava/io/File;)Z
    //   78: ifeq +184 -> 262
    //   81: aload_0
    //   82: monitorenter
    //   83: aload 4
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 145	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/support/v4/util/LruCache;
    //   91: new 323	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   98: iload_1
    //   99: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 452
    //   105: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 453	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 414	android/graphics/Bitmap
    //   121: astore 6
    //   123: aload 6
    //   125: ifnull +13 -> 138
    //   128: aload_0
    //   129: monitorexit
    //   130: aload 6
    //   132: areturn
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: aload 6
    //   140: astore 5
    //   142: aload 6
    //   144: astore 4
    //   146: ldc 37
    //   148: iconst_1
    //   149: ldc_w 455
    //   152: invokestatic 458	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload 6
    //   157: astore 5
    //   159: aload 6
    //   161: astore 4
    //   163: aload 8
    //   165: invokevirtual 367	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: aconst_null
    //   169: invokestatic 460	cooperation/qzone/util/ResDownloadManger:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 6
    //   174: aload 6
    //   176: astore 4
    //   178: aload_0
    //   179: monitorexit
    //   180: aload 4
    //   182: astore 6
    //   184: aload 4
    //   186: ifnull +89 -> 275
    //   189: aload_0
    //   190: getfield 145	cooperation/qzone/util/ResDownloadManger:mMemoryCache	Landroid/support/v4/util/LruCache;
    //   193: new 323	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   200: iload_1
    //   201: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 452
    //   207: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 4
    //   219: invokevirtual 464	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: aload 4
    //   225: areturn
    //   226: astore 4
    //   228: ldc 15
    //   230: iconst_1
    //   231: aload 4
    //   233: invokevirtual 465	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   236: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 5
    //   241: astore 4
    //   243: goto -65 -> 178
    //   246: astore 5
    //   248: ldc 15
    //   250: iconst_1
    //   251: aload 5
    //   253: invokevirtual 468	java/lang/Exception:toString	()Ljava/lang/String;
    //   256: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -81 -> 178
    //   262: ldc 37
    //   264: iconst_1
    //   265: ldc_w 470
    //   268: invokestatic 458	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 4
    //   273: astore 6
    //   275: aload_0
    //   276: aload 7
    //   278: iload_1
    //   279: aload_2
    //   280: aload_3
    //   281: invokespecial 165	cooperation/qzone/util/ResDownloadManger:generateEntry	(Ljava/lang/String;ILjava/lang/String;Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;)Lcooperation/qzone/util/ResEntry;
    //   284: astore_2
    //   285: aload 6
    //   287: astore 5
    //   289: aload_0
    //   290: aload 7
    //   292: aload_2
    //   293: invokespecial 171	cooperation/qzone/util/ResDownloadManger:addPendingRequest	(Ljava/lang/String;Lcooperation/qzone/util/ResEntry;)Z
    //   296: ifeq -286 -> 10
    //   299: aload_0
    //   300: aload_2
    //   301: invokespecial 177	cooperation/qzone/util/ResDownloadManger:starDownLoad	(Lcooperation/qzone/util/ResEntry;)V
    //   304: aload 6
    //   306: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	ResDownloadManger
    //   0	307	1	paramInt	int
    //   0	307	2	paramString	String
    //   0	307	3	paramResLoadListener	ResDownloadManger.ResLoadListener
    //   47	177	4	localObject1	Object
    //   226	6	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   241	31	4	localObject2	Object
    //   1	239	5	localObject3	Object
    //   246	6	5	localException	java.lang.Exception
    //   287	1	5	localObject4	Object
    //   121	184	6	localObject5	Object
    //   63	228	7	str	String
    //   71	93	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	123	133	finally
    //   128	130	133	finally
    //   134	136	133	finally
    //   146	155	133	finally
    //   163	174	133	finally
    //   178	180	133	finally
    //   228	239	133	finally
    //   248	259	133	finally
    //   87	123	226	java/lang/OutOfMemoryError
    //   146	155	226	java/lang/OutOfMemoryError
    //   163	174	226	java/lang/OutOfMemoryError
    //   87	123	246	java/lang/Exception
    //   146	155	246	java/lang/Exception
    //   163	174	246	java/lang/Exception
  }
  
  public Bitmap getResBitmapAsync(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.mMemoryCache.get(paramInt + " " + paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ResDownloadManger.1(this, paramInt, paramString, paramResLoadListener, paramOptions));
    return localBitmap;
  }
  
  public boolean isFileDownload(int paramInt)
  {
    Object localObject = RESURL[paramInt];
    localObject = new File(ResPath + ((String)localObject).substring(((String)localObject).lastIndexOf("/"), ((String)localObject).length() - 4) + File.separator);
    return (localObject != null) && (((File)localObject).isDirectory()) && (((File)localObject).list() != null) && (((File)localObject).list().length > 0);
  }
  
  public void removeCache(int paramInt, ArrayList<String> paramArrayList)
  {
    if ((this.mMemoryCache != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.mMemoryCache.remove(paramInt + " " + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger
 * JD-Core Version:    0.7.0.1
 */