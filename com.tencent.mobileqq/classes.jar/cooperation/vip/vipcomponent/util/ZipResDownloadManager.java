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

public class ZipResDownloadManager
{
  private static ZipResDownloadManager jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager;
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
  
  private QzonePreDownloadManager a()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager != null)
      {
        localQzonePreDownloadManager = this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager;
        return localQzonePreDownloadManager;
      }
      this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager = QzonePreDownloadManager.getInstance();
      QzonePreDownloadManager localQzonePreDownloadManager = this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager;
      return localQzonePreDownloadManager;
    }
    finally {}
  }
  
  public static ZipResDownloadManager a()
  {
    if (jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager == null) {
          jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager = new ZipResDownloadManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationVipVipcomponentUtilZipResDownloadManager;
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
      for (paramString = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.remove(paramString);; paramString = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.get(paramString))
      {
        paramString = (Collection)paramString;
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
    StringBuilder localStringBuilder;
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(VipUtils.a(paramString));
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(VipUtils.b(paramString));
      paramString = localStringBuilder.toString();
    }
    return new File(paramString);
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder;
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramString1))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(VipUtils.a(paramString1));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".png");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(VipUtils.b(paramString1));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".png");
        paramString1 = localStringBuilder.toString();
      }
      return new File(paramString1);
    }
    return null;
  }
  
  private static String c(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith("zip")) {
        return paramString;
      }
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(VipUtils.a(paramString));
        ((StringBuilder)localObject).append(".zip");
        paramString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(VipUtils.b(paramString));
        ((StringBuilder)localObject).append(".zip");
        paramString = ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4));
    return localStringBuilder.toString();
  }
  
  private static boolean d(File paramFile)
  {
    return (paramFile != null) && (paramFile.isDirectory());
  }
  
  private static String e(String paramString)
  {
    String str = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath();
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
  
  /* Error */
  public Bitmap a(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 86	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   13: astore 5
    //   15: new 203	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: aload_1
    //   27: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: ldc_w 296
    //   36: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: aload_3
    //   43: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload 6
    //   51: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 297	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 299	android/graphics/Bitmap
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +6 -> 70
    //   67: aload 5
    //   69: areturn
    //   70: aload_1
    //   71: aload_3
    //   72: invokestatic 117	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   75: astore 7
    //   77: aload 5
    //   79: astore 6
    //   81: aload 7
    //   83: invokestatic 238	cooperation/vip/vipcomponent/util/ZipResDownloadManager:c	(Ljava/io/File;)Z
    //   86: ifeq +200 -> 286
    //   89: aload_0
    //   90: monitorenter
    //   91: aload_0
    //   92: getfield 86	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   95: astore 6
    //   97: new 203	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   104: astore 8
    //   106: aload 8
    //   108: aload_1
    //   109: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 8
    //   115: ldc_w 296
    //   118: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 8
    //   124: aload_3
    //   125: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 6
    //   131: aload 8
    //   133: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 297	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 299	android/graphics/Bitmap
    //   142: astore 6
    //   144: aload 6
    //   146: ifnull +8 -> 154
    //   149: aload_0
    //   150: monitorexit
    //   151: aload 6
    //   153: areturn
    //   154: aload 7
    //   156: invokevirtual 283	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: aconst_null
    //   160: invokestatic 302	cooperation/vip/vipcomponent/VipUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   163: astore 5
    //   165: goto +52 -> 217
    //   168: astore 7
    //   170: aload 6
    //   172: astore 5
    //   174: goto +18 -> 192
    //   177: astore 7
    //   179: aload 6
    //   181: astore 5
    //   183: goto +23 -> 206
    //   186: astore_1
    //   187: goto +95 -> 282
    //   190: astore 7
    //   192: ldc_w 304
    //   195: aload 7
    //   197: invokevirtual 305	java/lang/Exception:toString	()Ljava/lang/String;
    //   200: invokestatic 310	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto +14 -> 217
    //   206: ldc_w 304
    //   209: aload 7
    //   211: invokevirtual 311	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   214: invokestatic 310	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: monitorexit
    //   219: aload 5
    //   221: astore 6
    //   223: aload 5
    //   225: ifnull +61 -> 286
    //   228: aload_0
    //   229: getfield 86	cooperation/vip/vipcomponent/util/ZipResDownloadManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   232: astore 4
    //   234: new 203	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   241: astore 6
    //   243: aload 6
    //   245: aload_1
    //   246: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 6
    //   252: ldc_w 296
    //   255: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 6
    //   261: aload_3
    //   262: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: aload 6
    //   270: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload 5
    //   275: invokevirtual 315	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: aload 5
    //   281: areturn
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: aload_0
    //   287: aload_1
    //   288: iload_2
    //   289: aload_3
    //   290: aload 4
    //   292: invokespecial 101	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;ILjava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResLoadListener;)Lcooperation/vip/vipcomponent/util/ZipResEntry;
    //   295: astore_3
    //   296: aload_0
    //   297: aload_1
    //   298: aload_3
    //   299: invokespecial 187	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResEntry;)Z
    //   302: ifeq +8 -> 310
    //   305: aload_0
    //   306: aload_3
    //   307: invokespecial 150	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResEntry;)V
    //   310: aload 6
    //   312: areturn
    //   313: astore 7
    //   315: goto -109 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	ZipResDownloadManager
    //   0	318	1	paramString1	String
    //   0	318	2	paramInt	int
    //   0	318	3	paramString2	String
    //   0	318	4	paramZipResLoadListener	ZipResLoadListener
    //   13	267	5	localObject1	Object
    //   22	289	6	localObject2	Object
    //   75	80	7	localFile	File
    //   168	1	7	localException1	Exception
    //   177	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   190	20	7	localException2	Exception
    //   313	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   104	28	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   154	165	168	java/lang/Exception
    //   154	165	177	java/lang/OutOfMemoryError
    //   91	144	186	finally
    //   149	151	186	finally
    //   154	165	186	finally
    //   192	203	186	finally
    //   206	217	186	finally
    //   217	219	186	finally
    //   282	284	186	finally
    //   91	144	190	java/lang/Exception
    //   91	144	313	java/lang/OutOfMemoryError
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
    StringBuilder localStringBuilder;
    if (jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(VipUtils.a(paramString));
      localStringBuilder.append(File.separator);
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(VipUtils.b(paramString));
      localStringBuilder.append(File.separator);
      paramString = localStringBuilder.toString();
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory()) && (paramString.list() != null))
      {
        int i = paramString.list().length;
        if (i > 0) {
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" file exception ");
      localStringBuilder.append(paramString.toString());
      QZLog.w("test", localStringBuilder.toString());
    }
    return false;
  }
  
  public Bitmap b(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4UtilLruCache;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    localObject = (Bitmap)((LruCache)localObject).get(localStringBuilder.toString());
    if (localObject != null) {
      return localObject;
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(new ZipResDownloadManager.2(this, paramString1, paramString2, paramZipResLoadListener, paramInt), 400L);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager
 * JD-Core Version:    0.7.0.1
 */