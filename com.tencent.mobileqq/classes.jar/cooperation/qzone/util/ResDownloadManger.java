package cooperation.qzone.util;

import amkv;
import amkw;
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
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  private static ResDownloadManger jdField_a_of_type_CooperationQzoneUtilResDownloadManger;
  private static String jdField_a_of_type_JavaLangString;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v1.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_themeAlbum.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_loading_bg.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_plus_publish_video_anim_guide_resource.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_first_page_loading_bg.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzonePopwindow.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_ads_res.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_list_slide_out_video_capture_anim.zip", "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_photo_category_empty_bgs.zip" };
  private static String b;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new amkw(this);
  private QzonePreDownloadManager jdField_a_of_type_CooperationQzoneQzonePreDownloadManager;
  private final MultiHashMap jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  
  private ResDownloadManger()
  {
    jdField_a_of_type_JavaLangString = c("qzonereszip");
    b = c("qzoneres");
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache((int)(MemoryManager.a() / 8L));
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 103	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: new 108	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_2
    //   18: sipush 8192
    //   21: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 117	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: ifnull +9 -> 42
    //   36: aload_2
    //   37: invokevirtual 122	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_0
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +14 -> 66
    //   55: aload_2
    //   56: astore_0
    //   57: ldc 130
    //   59: iconst_2
    //   60: ldc 132
    //   62: aload_1
    //   63: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload_3
    //   67: astore_0
    //   68: aload_2
    //   69: ifnull -27 -> 42
    //   72: aload_2
    //   73: invokevirtual 122	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_0
    //   86: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +14 -> 103
    //   92: aload_2
    //   93: astore_0
    //   94: ldc 130
    //   96: iconst_2
    //   97: ldc 132
    //   99: aload_1
    //   100: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_3
    //   104: astore_0
    //   105: aload_2
    //   106: ifnull -64 -> 42
    //   109: aload_2
    //   110: invokevirtual 122	java/io/InputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 122	java/io/InputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: aload_1
    //   133: areturn
    //   134: astore_0
    //   135: goto -6 -> 129
    //   138: astore_1
    //   139: goto -18 -> 121
    //   142: astore_1
    //   143: goto -59 -> 84
    //   146: astore_1
    //   147: goto -100 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   0	150	1	paramOptions	BitmapFactory.Options
    //   10	100	2	localFileInputStream	java.io.FileInputStream
    //   1	103	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	java/lang/OutOfMemoryError
    //   72	76	78	java/io/IOException
    //   2	11	81	java/lang/Exception
    //   109	113	115	java/io/IOException
    //   2	11	118	finally
    //   36	40	131	java/io/IOException
    //   125	129	134	java/io/IOException
    //   13	30	138	finally
    //   49	55	138	finally
    //   57	66	138	finally
    //   86	92	138	finally
    //   94	103	138	finally
    //   13	30	142	java/lang/Exception
    //   13	30	146	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private QzonePreDownloadManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 140	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 144	cooperation/qzone/QzonePreDownloadManager:a	()Lcooperation/qzone/QzonePreDownloadManager;
    //   22: putfield 140	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   25: aload_0
    //   26: getfield 140	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
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
  
  public static ResDownloadManger a()
  {
    if (jdField_a_of_type_CooperationQzoneUtilResDownloadManger == null) {}
    try
    {
      jdField_a_of_type_CooperationQzoneUtilResDownloadManger = new ResDownloadManger();
      return jdField_a_of_type_CooperationQzoneUtilResDownloadManger;
    }
    finally {}
  }
  
  private ResEntry a(String paramString1, int paramInt, String paramString2, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    ResEntry localResEntry = ResEntry.a(paramInt, paramString2);
    localResEntry.b = paramString1;
    localResEntry.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramResLoadListener);
    localResEntry.jdField_a_of_type_Int = paramInt;
    localResEntry.d = paramString2;
    return localResEntry;
  }
  
  private Collection a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  private Collection a(String paramString, boolean paramBoolean, Collection paramCollection)
  {
    MultiHashMap localMultiHashMap = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.remove(paramString); paramCollection != null; paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.get(paramString))
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
  
  public static void a(int paramInt, String paramString)
  {
    jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
  }
  
  private void a(ResEntry paramResEntry)
  {
    if (URLUtil.isNetworkUrl(paramResEntry.b))
    {
      String str = b(paramResEntry.b);
      a().a(paramResEntry.b, str, true, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    }
  }
  
  private static void a(File paramFile)
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
  
  private boolean a(String paramString, ResEntry paramResEntry)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap)
      {
        int i = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.sizeOf(paramString);
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(paramString, paramResEntry);
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return new File(b + paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length() - 4) + File.separator + paramString2 + ".png");
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    return jdField_a_of_type_JavaLangString + paramString;
  }
  
  private static void b(String paramString)
  {
    String str = b + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
    a(new File(str));
    ZipUtils.a(paramString, str);
  }
  
  private static boolean b(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  private static String c(String paramString)
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
  
  /* Error */
  public Bitmap a(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_2
    //   4: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 6
    //   12: areturn
    //   13: aload_0
    //   14: getfield 94	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   17: new 262	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 327
    //   31: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 328	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 330	android/graphics/Bitmap
    //   47: astore 4
    //   49: aload 4
    //   51: astore 6
    //   53: aload 4
    //   55: ifnonnull -45 -> 10
    //   58: getstatic 44	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   61: iload_1
    //   62: aaload
    //   63: astore 7
    //   65: aload 7
    //   67: aload_2
    //   68: invokestatic 175	cooperation/qzone/util/ResDownloadManger:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   71: astore 8
    //   73: aload 4
    //   75: astore 5
    //   77: aload 8
    //   79: invokestatic 245	cooperation/qzone/util/ResDownloadManger:b	(Ljava/io/File;)Z
    //   82: ifeq +169 -> 251
    //   85: aload_0
    //   86: monitorenter
    //   87: aload 4
    //   89: astore 5
    //   91: aload_0
    //   92: getfield 94	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   95: new 262	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   102: iload_1
    //   103: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 327
    //   109: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_2
    //   113: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokevirtual 328	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 330	android/graphics/Bitmap
    //   125: astore 6
    //   127: aload 6
    //   129: ifnull +13 -> 142
    //   132: aload_0
    //   133: monitorexit
    //   134: aload 6
    //   136: areturn
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    //   142: aload 6
    //   144: astore 5
    //   146: aload 6
    //   148: astore 4
    //   150: aload 8
    //   152: invokevirtual 312	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: aconst_null
    //   156: invokestatic 332	cooperation/qzone/util/ResDownloadManger:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   159: astore 6
    //   161: aload 6
    //   163: astore 4
    //   165: aload_0
    //   166: monitorexit
    //   167: aload 4
    //   169: astore 5
    //   171: aload 4
    //   173: ifnull +78 -> 251
    //   176: aload_0
    //   177: getfield 94	cooperation/qzone/util/ResDownloadManger:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   180: new 262	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   187: iload_1
    //   188: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc_w 327
    //   194: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: aload 4
    //   206: invokevirtual 336	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload 4
    //   212: areturn
    //   213: astore 4
    //   215: ldc_w 338
    //   218: iconst_1
    //   219: aload 4
    //   221: invokevirtual 339	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   224: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 5
    //   229: astore 4
    //   231: goto -66 -> 165
    //   234: astore 5
    //   236: ldc_w 338
    //   239: iconst_1
    //   240: aload 5
    //   242: invokevirtual 343	java/lang/Exception:toString	()Ljava/lang/String;
    //   245: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto -83 -> 165
    //   251: aload_0
    //   252: aload 7
    //   254: iload_1
    //   255: aload_2
    //   256: aload_3
    //   257: invokespecial 152	cooperation/qzone/util/ResDownloadManger:a	(Ljava/lang/String;ILjava/lang/String;Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;)Lcooperation/qzone/util/ResEntry;
    //   260: astore_2
    //   261: aload 5
    //   263: astore 6
    //   265: aload_0
    //   266: aload 7
    //   268: aload_2
    //   269: invokespecial 242	cooperation/qzone/util/ResDownloadManger:a	(Ljava/lang/String;Lcooperation/qzone/util/ResEntry;)Z
    //   272: ifeq -262 -> 10
    //   275: aload_0
    //   276: aload_2
    //   277: invokespecial 207	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResEntry;)V
    //   280: aload 5
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	ResDownloadManger
    //   0	283	1	paramInt	int
    //   0	283	2	paramString	String
    //   0	283	3	paramResLoadListener	ResDownloadManger.ResLoadListener
    //   47	164	4	localObject1	Object
    //   213	7	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   229	1	4	localObject2	Object
    //   75	153	5	localObject3	Object
    //   234	47	5	localException	java.lang.Exception
    //   1	263	6	localObject4	Object
    //   63	204	7	str	String
    //   71	80	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   91	127	137	finally
    //   132	134	137	finally
    //   138	140	137	finally
    //   150	161	137	finally
    //   165	167	137	finally
    //   215	227	137	finally
    //   236	248	137	finally
    //   91	127	213	java/lang/OutOfMemoryError
    //   150	161	213	java/lang/OutOfMemoryError
    //   91	127	234	java/lang/Exception
    //   150	161	234	java/lang/Exception
  }
  
  public Bitmap a(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramInt + " " + paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new amkv(this, paramInt, paramString, paramResLoadListener, paramOptions));
    return localBitmap;
  }
  
  public Drawable a(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    paramString = a(paramInt, paramString, paramResLoadListener);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.c());
      return paramString;
    }
    return null;
  }
  
  public Drawable a(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions)
  {
    paramString = a(paramInt, paramString, paramResLoadListener, paramOptions);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)ViewUtils.c());
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramInt + " " + str);
      }
    }
  }
  
  public Drawable b(int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener)
  {
    Object localObject = null;
    paramString = a(paramInt, paramString, paramResLoadListener, null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger
 * JD-Core Version:    0.7.0.1
 */