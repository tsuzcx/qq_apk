package cooperation.vip.vipcomponent.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.VipUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ZipResDownloadManager
{
  private static ZipResDownloadManager jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager = null;
  private static String jdField_a_of_type_JavaLangString;
  public static final ArrayList<String> a;
  private static String b;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new ZipResDownloadManager.3(this);
  private QzonePreDownloadManager jdField_a_of_type_CooperationQzoneQzonePreDownloadManager = null;
  private final MultiHashMap<String, ZipResEntry> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone_vip_icon/qzone_yellow_icon_v8.zip");
    jdField_a_of_type_JavaUtilArrayList.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip");
    jdField_a_of_type_JavaUtilArrayList.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip");
  }
  
  public ZipResDownloadManager()
  {
    jdField_a_of_type_JavaLangString = e("qzonereszip");
    b = e("qzoneres");
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache((int)(MemoryManager.a() / 8L));
  }
  
  /* Error */
  private QzonePreDownloadManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 42	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 95	cooperation/qzone/QzonePreDownloadManager:getInstance	()Lcooperation/qzone/QzonePreDownloadManager;
    //   22: putfield 42	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   25: aload_0
    //   26: getfield 42	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_CooperationQzoneQzonePreDownloadManager	Lcooperation/qzone/QzonePreDownloadManager;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ZipResDownloadManager
    //   13	17	1	localQzonePreDownloadManager	QzonePreDownloadManager
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   18	30	33	finally
  }
  
  public static ZipResDownloadManager a()
  {
    if (jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager == null) {
        jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager = new ZipResDownloadManager();
      }
      return jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager;
    }
    finally {}
  }
  
  private ZipResEntry a(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    return ZipResEntry.a(paramString1, paramInt, paramString2, new WeakReference(paramZipResLoadListener));
  }
  
  private Collection<ZipResEntry> a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  private Collection<ZipResEntry> a(String paramString, boolean paramBoolean, Collection<ZipResEntry> paramCollection)
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
  
  private void a(ZipResEntry paramZipResEntry)
  {
    if (URLUtil.isNetworkUrl(paramZipResEntry.b))
    {
      String str = c(paramZipResEntry.b);
      a().download(paramZipResEntry.b, str, true, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
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
  
  private boolean a(String paramString, ZipResEntry paramZipResEntry)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap)
      {
        int i = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.sizeOf(paramString);
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(paramString, paramZipResEntry);
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static File b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {}
    for (paramString = b + VipUtils.a(paramString);; paramString = b + VipUtils.b(paramString)) {
      return new File(paramString);
    }
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {}
    for (paramString1 = b + VipUtils.a(paramString1) + File.separator + paramString2 + ".png";; paramString1 = b + VipUtils.b(paramString1) + File.separator + paramString2 + ".png") {
      return new File(paramString1);
    }
  }
  
  private static String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith("zip"))) {
      return paramString;
    }
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {}
    for (paramString = VipUtils.a(paramString) + ".zip";; paramString = VipUtils.b(paramString) + ".zip") {
      return jdField_a_of_type_JavaLangString + paramString;
    }
  }
  
  private static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(d(paramString));
      a(localFile);
      FileUtils.unzip(new File(paramString), localFile);
    }
  }
  
  private static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  private static String d(String paramString)
  {
    return b + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
  }
  
  private static boolean d(File paramFile)
  {
    return (paramFile != null) && (paramFile.isDirectory());
  }
  
  private static String e(String paramString)
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
  public Bitmap a(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 7
    //   12: areturn
    //   13: aload_0
    //   14: getfield 88	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   17: new 205	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   24: aload_1
    //   25: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 298
    //   31: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_3
    //   35: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 299	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 301	android/graphics/Bitmap
    //   47: astore 5
    //   49: aload 5
    //   51: astore 7
    //   53: aload 5
    //   55: ifnonnull -45 -> 10
    //   58: aload_1
    //   59: aload_3
    //   60: invokestatic 117	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   63: astore 8
    //   65: aload 5
    //   67: astore 6
    //   69: aload 8
    //   71: invokestatic 240	cooperation/vip/vipcomponent/util/ZipResDownloadManager:c	(Ljava/io/File;)Z
    //   74: ifeq +167 -> 241
    //   77: aload_0
    //   78: monitorenter
    //   79: aload 5
    //   81: astore 6
    //   83: aload_0
    //   84: getfield 88	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   87: new 205	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 298
    //   101: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokevirtual 299	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 301	android/graphics/Bitmap
    //   117: astore 7
    //   119: aload 7
    //   121: ifnull +13 -> 134
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 7
    //   128: areturn
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload 7
    //   136: astore 6
    //   138: aload 7
    //   140: astore 5
    //   142: aload 8
    //   144: invokevirtual 285	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: aconst_null
    //   148: invokestatic 304	cooperation/vip/vipcomponent/VipUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: astore 7
    //   153: aload 7
    //   155: astore 5
    //   157: aload_0
    //   158: monitorexit
    //   159: aload 5
    //   161: astore 6
    //   163: aload 5
    //   165: ifnull +76 -> 241
    //   168: aload_0
    //   169: getfield 88	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   172: new 205	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   179: aload_1
    //   180: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 298
    //   186: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_3
    //   190: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload 5
    //   198: invokevirtual 308	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload 5
    //   204: areturn
    //   205: astore 5
    //   207: ldc_w 310
    //   210: aload 5
    //   212: invokevirtual 311	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   215: invokestatic 316	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: astore 5
    //   222: goto -65 -> 157
    //   225: astore 6
    //   227: ldc_w 310
    //   230: aload 6
    //   232: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokestatic 316	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -81 -> 157
    //   241: aload_0
    //   242: aload_1
    //   243: iload_2
    //   244: aload_3
    //   245: aload 4
    //   247: invokespecial 101	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;ILjava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResLoadListener;)Lcooperation/vip/vipcomponent/util/ZipResEntry;
    //   250: astore_3
    //   251: aload 6
    //   253: astore 7
    //   255: aload_0
    //   256: aload_1
    //   257: aload_3
    //   258: invokespecial 189	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResEntry;)Z
    //   261: ifeq -251 -> 10
    //   264: aload_0
    //   265: aload_3
    //   266: invokespecial 152	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResEntry;)V
    //   269: aload 6
    //   271: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	ZipResDownloadManager
    //   0	272	1	paramString1	String
    //   0	272	2	paramInt	int
    //   0	272	3	paramString2	String
    //   0	272	4	paramZipResLoadListener	ZipResLoadListener
    //   47	156	5	localObject1	Object
    //   205	6	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   220	1	5	localObject2	Object
    //   67	152	6	localObject3	Object
    //   225	45	6	localException	Exception
    //   1	253	7	localObject4	Object
    //   63	80	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	119	129	finally
    //   124	126	129	finally
    //   130	132	129	finally
    //   142	153	129	finally
    //   157	159	129	finally
    //   207	218	129	finally
    //   227	238	129	finally
    //   83	119	205	java/lang/OutOfMemoryError
    //   142	153	205	java/lang/OutOfMemoryError
    //   83	119	225	java/lang/Exception
    //   142	153	225	java/lang/Exception
  }
  
  public Drawable a(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    return a(paramString1, paramInt, paramString2, false, paramZipResLoadListener);
  }
  
  public Drawable a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, ZipResLoadListener paramZipResLoadListener)
  {
    if ((paramBoolean) && (!jdField_a_of_type_JavaUtilArrayList.contains(paramString1))) {
      jdField_a_of_type_JavaUtilArrayList.add(paramString1);
    }
    paramString1 = b(paramString1, paramInt, paramString2, paramZipResLoadListener);
    if (paramString1 != null)
    {
      paramString1.setDensity(320);
      paramString1 = new BitmapDrawable(paramString1);
      paramString1.setTargetDensity((int)ViewUtils.c());
      return paramString1;
    }
    if (paramZipResLoadListener != null) {
      try
      {
        paramZipResLoadListener.mCount += 1;
      }
      finally {}
    }
    return null;
  }
  
  public String a(String paramString, ZipResLoadListener paramZipResLoadListener)
  {
    String str = d(c(paramString));
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.listFiles().length != 0)) {
      return str;
    }
    paramZipResLoadListener = a(paramString, 999, str, paramZipResLoadListener);
    if (a(paramString, paramZipResLoadListener)) {
      a(paramZipResLoadListener);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ZipResDownloadManager.1(this, paramString));
  }
  
  public boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      paramString = b + VipUtils.a(paramString) + File.separator;
    }
    try
    {
      for (;;)
      {
        paramString = new File(paramString);
        if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list() == null)) {
          break;
        }
        int i = paramString.list().length;
        if (i <= 0) {
          break;
        }
        return true;
        paramString = b + VipUtils.b(paramString) + File.separator;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QZLog.w("test", " file exception " + paramString.toString());
    }
    return false;
  }
  
  public Bitmap b(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1 + " " + paramString2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(new ZipResDownloadManager.2(this, paramString1, paramString2, paramZipResLoadListener, paramInt), 400L);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager
 * JD-Core Version:    0.7.0.1
 */