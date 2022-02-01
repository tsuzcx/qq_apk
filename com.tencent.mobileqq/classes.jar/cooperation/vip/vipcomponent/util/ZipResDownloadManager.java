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
  public static final ArrayList<String> a = new ArrayList();
  private static ZipResDownloadManager d;
  private static String f;
  private static String g;
  private QzonePreDownloadManager b = null;
  private Context c = BaseApplicationImpl.getContext();
  private final MultiHashMap<String, ZipResEntry> e = new MultiHashMap();
  private LruCache<String, Bitmap> h;
  private Downloader.DownloadListener i = new ZipResDownloadManager.3(this);
  
  static
  {
    a.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone_vip_icon/qzone_yellow_icon_v8.zip");
    a.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip");
    a.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip");
  }
  
  public ZipResDownloadManager()
  {
    f = k("qzonereszip");
    g = k("qzoneres");
    this.h = new LruCache((int)(MemoryManager.d() / 8L));
  }
  
  public static ZipResDownloadManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new ZipResDownloadManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private Collection<ZipResEntry> a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  private Collection<ZipResEntry> a(String paramString, boolean paramBoolean, Collection<ZipResEntry> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.e;
    if (paramBoolean) {}
    try
    {
      for (paramString = this.e.remove(paramString);; paramString = this.e.get(paramString))
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
      String str = g(paramZipResEntry.b);
      b().download(paramZipResEntry.b, str, true, this.i);
    }
  }
  
  private boolean a(String paramString, ZipResEntry paramZipResEntry)
  {
    for (;;)
    {
      synchronized (this.e)
      {
        int j = this.e.sizeOf(paramString);
        this.e.add(paramString, paramZipResEntry);
        if (j == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private QzonePreDownloadManager b()
  {
    try
    {
      if (this.b != null)
      {
        localQzonePreDownloadManager = this.b;
        return localQzonePreDownloadManager;
      }
      this.b = QzonePreDownloadManager.getInstance();
      QzonePreDownloadManager localQzonePreDownloadManager = this.b;
      return localQzonePreDownloadManager;
    }
    finally {}
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder;
      if (a.contains(paramString1))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(g);
        localStringBuilder.append(VipUtils.c(paramString1));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".png");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(g);
        localStringBuilder.append(VipUtils.d(paramString1));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".png");
        paramString1 = localStringBuilder.toString();
      }
      return new File(paramString1);
    }
    return null;
  }
  
  private static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  private ZipResEntry d(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    return ZipResEntry.a(paramString1, paramInt, paramString2, new WeakReference(paramZipResLoadListener));
  }
  
  private static boolean d(File paramFile)
  {
    return (paramFile != null) && (paramFile.isDirectory());
  }
  
  private static void e(File paramFile)
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
      int k = paramFile.length;
      int j = 0;
      while (j < k)
      {
        Object localObject = paramFile[j];
        if (!localObject.isDirectory()) {
          localObject.delete();
        }
        j += 1;
      }
    }
    paramFile.mkdir();
  }
  
  private static String g(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith("zip")) {
        return paramString;
      }
      if (a.contains(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(VipUtils.c(paramString));
        ((StringBuilder)localObject).append(".zip");
        paramString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(VipUtils.d(paramString));
        ((StringBuilder)localObject).append(".zip");
        paramString = ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private static File h(String paramString)
  {
    StringBuilder localStringBuilder;
    if (a.contains(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append(VipUtils.c(paramString));
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append(VipUtils.d(paramString));
      paramString = localStringBuilder.toString();
    }
    return new File(paramString);
  }
  
  private static void i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(j(paramString));
      e(localFile);
      FileUtils.unzip(new File(paramString), localFile);
    }
  }
  
  private static String j(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4));
    return localStringBuilder.toString();
  }
  
  private static String k(String paramString)
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
    //   1: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 93	cooperation/vip/vipcomponent/util/ZipResDownloadManager:h	Landroid/support/v4/util/LruCache;
    //   13: astore 5
    //   15: new 184	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: aload_1
    //   27: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: ldc_w 303
    //   36: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: aload_3
    //   43: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload 6
    //   51: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 304	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 306	android/graphics/Bitmap
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +6 -> 70
    //   67: aload 5
    //   69: areturn
    //   70: aload_1
    //   71: aload_3
    //   72: invokestatic 105	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   75: astore 7
    //   77: aload 5
    //   79: astore 6
    //   81: aload 7
    //   83: invokestatic 211	cooperation/vip/vipcomponent/util/ZipResDownloadManager:c	(Ljava/io/File;)Z
    //   86: ifeq +200 -> 286
    //   89: aload_0
    //   90: monitorenter
    //   91: aload_0
    //   92: getfield 93	cooperation/vip/vipcomponent/util/ZipResDownloadManager:h	Landroid/support/v4/util/LruCache;
    //   95: astore 6
    //   97: new 184	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   104: astore 8
    //   106: aload 8
    //   108: aload_1
    //   109: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 8
    //   115: ldc_w 303
    //   118: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 8
    //   124: aload_3
    //   125: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 6
    //   131: aload 8
    //   133: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 304	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 306	android/graphics/Bitmap
    //   142: astore 6
    //   144: aload 6
    //   146: ifnull +8 -> 154
    //   149: aload_0
    //   150: monitorexit
    //   151: aload 6
    //   153: areturn
    //   154: aload 7
    //   156: invokevirtual 290	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: aconst_null
    //   160: invokestatic 309	cooperation/vip/vipcomponent/VipUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
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
    //   192: ldc_w 311
    //   195: aload 7
    //   197: invokevirtual 312	java/lang/Exception:toString	()Ljava/lang/String;
    //   200: invokestatic 317	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto +14 -> 217
    //   206: ldc_w 311
    //   209: aload 7
    //   211: invokevirtual 318	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   214: invokestatic 317	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: monitorexit
    //   219: aload 5
    //   221: astore 6
    //   223: aload 5
    //   225: ifnull +61 -> 286
    //   228: aload_0
    //   229: getfield 93	cooperation/vip/vipcomponent/util/ZipResDownloadManager:h	Landroid/support/v4/util/LruCache;
    //   232: astore 4
    //   234: new 184	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   241: astore 6
    //   243: aload 6
    //   245: aload_1
    //   246: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 6
    //   252: ldc_w 303
    //   255: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 6
    //   261: aload_3
    //   262: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: aload 6
    //   270: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload 5
    //   275: invokevirtual 322	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   292: invokespecial 102	cooperation/vip/vipcomponent/util/ZipResDownloadManager:d	(Ljava/lang/String;ILjava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResLoadListener;)Lcooperation/vip/vipcomponent/util/ZipResEntry;
    //   295: astore_3
    //   296: aload_0
    //   297: aload_1
    //   298: aload_3
    //   299: invokespecial 160	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResEntry;)Z
    //   302: ifeq +8 -> 310
    //   305: aload_0
    //   306: aload_3
    //   307: invokespecial 135	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResEntry;)V
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
  
  public Drawable a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, ZipResLoadListener paramZipResLoadListener)
  {
    if ((paramBoolean) && (!a.contains(paramString1))) {
      a.add(paramString1);
    }
    paramString1 = b(paramString1, paramInt, paramString2, paramZipResLoadListener);
    if (paramString1 != null)
    {
      paramString1.setDensity(320);
      paramString1 = new BitmapDrawable(paramString1);
      paramString1.setTargetDensity((int)ViewUtils.getDensityDpi());
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
    String str = j(g(paramString));
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.listFiles().length != 0)) {
      return str;
    }
    paramZipResLoadListener = d(paramString, 999, str, paramZipResLoadListener);
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
  
  public Bitmap b(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    Object localObject = this.h;
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
  
  public boolean b(String paramString)
  {
    StringBuilder localStringBuilder;
    if (a.contains(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append(VipUtils.c(paramString));
      localStringBuilder.append(File.separator);
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append(VipUtils.d(paramString));
      localStringBuilder.append(File.separator);
      paramString = localStringBuilder.toString();
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory()) && (paramString.list() != null))
      {
        int j = paramString.list().length;
        if (j > 0) {
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
  
  public Drawable c(String paramString1, int paramInt, String paramString2, ZipResLoadListener paramZipResLoadListener)
  {
    return a(paramString1, paramInt, paramString2, false, paramZipResLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager
 * JD-Core Version:    0.7.0.1
 */