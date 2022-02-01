package com.tencent.mobileqq.kandian.base.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.image.imageloader.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunningJob
  implements Runnable
{
  public static final String a;
  ImageRequest b;
  ImageManager c;
  IBitmapCache d;
  DiskCache e;
  Handler f = new Handler(Looper.getMainLooper());
  HttpDownloader g;
  Set<WeakReference<IBitmapCallback>> h = new HashSet();
  long i;
  int j = 0;
  File k;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(RunningJob.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public RunningJob(ImageManager paramImageManager, ImageRequest paramImageRequest)
  {
    this.c = paramImageManager;
    this.b = paramImageRequest;
    this.d = paramImageManager.mBitmapCache;
    this.e = new DiskCache(URLDrawableHelper.diskCachePath);
    this.i = System.currentTimeMillis();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int n = 1;
    int m = 1;
    int i2 = n;
    if (paramInt1 != 0)
    {
      i2 = n;
      if (paramInt2 != 0)
      {
        i2 = n;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          n = Math.min(paramOptions.outHeight, 2048);
          int i1 = Math.min(paramOptions.outWidth, 2048);
          for (;;)
          {
            i2 = m;
            if (n <= paramInt2) {
              break;
            }
            i2 = m;
            if (i1 <= paramInt1) {
              break;
            }
            int i3 = Math.round(n / paramInt2);
            i2 = Math.round(i1 / paramInt1);
            if (i3 <= i2) {
              i3 = i2;
            }
            i2 = m;
            if (i3 < 2) {
              break;
            }
            i1 >>= 1;
            n >>= 1;
            m <<= 1;
          }
        }
      }
    }
    return i2;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.b.g == 1) {
      localBitmap = ImageUtil.c(paramBitmap, this.b.b, this.b.c);
    }
    return localBitmap;
  }
  
  @Nullable
  private Bitmap a(boolean paramBoolean)
  {
    Bitmap localBitmap2 = null;
    Object localObject1 = null;
    Bitmap localBitmap1 = null;
    Object localObject3 = localObject1;
    if (paramBoolean)
    {
      localObject3 = localObject1;
      if (this.k != null)
      {
        localObject3 = localObject1;
        if (this.b != null)
        {
          localObject3 = localObject1;
          if (Build.VERSION.SDK_INT >= 19)
          {
            localObject3 = localBitmap1;
            Object localObject2;
            try
            {
              Object localObject4 = RIJImageTypeOptHelper.a.b(this.k.getPath());
              localObject3 = localBitmap1;
              localObject1 = localBitmap2;
              if (((BitmapFactory.Options)localObject4).outWidth != -1)
              {
                localObject3 = localBitmap1;
                localObject1 = localBitmap2;
                if (((BitmapFactory.Options)localObject4).outHeight != -1)
                {
                  localObject3 = localBitmap1;
                  int n = a((BitmapFactory.Options)localObject4, this.b.b, this.b.c);
                  localObject3 = localBitmap1;
                  int m = ((BitmapFactory.Options)localObject4).outWidth / n;
                  localObject3 = localBitmap1;
                  n = ((BitmapFactory.Options)localObject4).outHeight / n;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).outWidth = m;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).outHeight = n;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).inSampleSize = 1;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).inMutable = true;
                  localObject3 = localBitmap1;
                  localBitmap2 = this.d.getReusableBitmap((BitmapFactory.Options)localObject4);
                  if (localBitmap2 != null)
                  {
                    localObject3 = localBitmap1;
                    localObject1 = a;
                    localObject3 = localBitmap1;
                    localObject4 = new StringBuilder();
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append("origin bitmap: ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(localBitmap2.getWidth());
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(localBitmap2.getHeight());
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" after: ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(m);
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(n);
                    localObject3 = localBitmap1;
                    QLog.d((String)localObject1, 2, ((StringBuilder)localObject4).toString());
                    localObject3 = localBitmap1;
                    localBitmap2.reconfigure(m, n, Bitmap.Config.ARGB_8888);
                  }
                  localObject3 = localBitmap1;
                  localBitmap1 = RIJImageTypeOptHelper.a.a(this.k.getPath(), m, n, localBitmap2);
                  localObject1 = localBitmap1;
                  if (localBitmap2 != null)
                  {
                    localObject1 = localBitmap1;
                    if (localBitmap1 != localBitmap2)
                    {
                      localObject3 = localBitmap1;
                      QLog.d(a, 2, "reuse failed");
                      localObject1 = localBitmap1;
                    }
                  }
                }
              }
            }
            catch (Error localError)
            {
              QLog.d(a, 1, localError.getMessage());
              localObject2 = localObject3;
            }
            localObject3 = localObject2;
            if (localObject2 == null)
            {
              QLog.d(a, 1, "sharpP bitmap is null");
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    return localObject3;
  }
  
  private Rect a(BitmapFactory.Options paramOptions)
  {
    int m = Math.min(paramOptions.outWidth, 2048);
    int n = Math.min(paramOptions.outHeight, 2048);
    int i1 = (paramOptions.outWidth - m) / 2;
    int i2 = (paramOptions.outHeight - n) / 2;
    return new Rect(i1, i2, m + i1, n + i2);
  }
  
  private File a(DownloadParams paramDownloadParams, StringBuilder paramStringBuilder)
  {
    return this.g.loadImageFile(paramDownloadParams, new RunningJob.1(this, paramStringBuilder));
  }
  
  private void a(long paramLong)
  {
    ImageRequest localImageRequest = this.b;
    if (localImageRequest != null) {
      localImageRequest.l = paramLong;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ImageRequest)localObject).m = paramLong2;
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[decode success](");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(") total(");
      localStringBuilder.append(paramLong1 - this.i);
      localStringBuilder.append(")");
      localStringBuilder.append(this.b);
      localStringBuilder.append("; size =");
      localStringBuilder.append(paramBitmap.getByteCount());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramBitmap);
      return;
    }
    g(new RuntimeException("bitmap null"));
  }
  
  private void a(CloseableBitmap paramCloseableBitmap)
  {
    if (this.b.d)
    {
      RIJImageOptReport.a(6, this.b);
      RIJImageOptReport.a(this.b, false, "cancelled");
      paramCloseableBitmap.a();
      return;
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((IBitmapCallback)localWeakReference.get()).a(this.b, paramCloseableBitmap.d());
      }
    }
    paramCloseableBitmap.a();
  }
  
  private void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        QLog.d(a, 1, paramInputStream.getMessage());
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (f(paramThrowable))
      {
        a(paramThrowable, -3);
        return;
      }
      if (e(paramThrowable))
      {
        d(paramThrowable);
        return;
      }
      if (c(paramThrowable))
      {
        b(paramThrowable);
        return;
      }
      g(paramThrowable);
      return;
    }
    catch (Exception paramThrowable)
    {
      g(paramThrowable);
    }
  }
  
  private void a(Throwable paramThrowable, int paramInt)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[job fail] failCode:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(paramThrowable);
    ((StringBuilder)localObject2).append(" retryCount:");
    ((StringBuilder)localObject2).append(this.j);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.b.q == -2) {
      this.b.q = paramInt;
    }
    this.c.removeJob(this.b);
    if (this.b.d)
    {
      RIJImageOptReport.a(6, this.b);
      RIJImageOptReport.a(this.b, false, "cancelled");
      return;
    }
    if (this.b.u == ImageRequest.v)
    {
      localObject2 = this.b;
      if (paramThrowable != null) {
        localObject1 = paramThrowable.getMessage();
      } else {
        localObject1 = "";
      }
      RIJImageOptReport.a((ImageRequest)localObject2, false, (String)localObject1);
    }
    if (k())
    {
      h(paramThrowable);
      return;
    }
    localObject1 = this.h.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null) {
        this.f.post(new RunningJob.4(this, (WeakReference)localObject2, paramThrowable));
      }
    }
  }
  
  /* Error */
  private void a(URL paramURL)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 401	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   5: invokestatic 407	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/Object;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   8: ldc_w 409
    //   11: invokevirtual 412	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 414	java/util/HashMap
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +116 -> 135
    //   22: aload_2
    //   23: invokevirtual 418	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   26: invokeinterface 311 1 0
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 317 1 0
    //   38: ifeq +97 -> 135
    //   41: aload_2
    //   42: invokeinterface 321 1 0
    //   47: checkcast 420	java/util/Map$Entry
    //   50: invokeinterface 423 1 0
    //   55: checkcast 414	java/util/HashMap
    //   58: astore_3
    //   59: aload_3
    //   60: aload_1
    //   61: invokevirtual 428	java/net/URL:getHost	()Ljava/lang/String;
    //   64: invokevirtual 432	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   67: ifeq -35 -> 32
    //   70: aload_3
    //   71: aload_1
    //   72: invokevirtual 428	java/net/URL:getHost	()Ljava/lang/String;
    //   75: invokevirtual 436	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: getstatic 53	com/tencent/mobileqq/kandian/base/image/RunningJob:a	Ljava/lang/String;
    //   82: iconst_2
    //   83: ldc_w 438
    //   86: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: goto -57 -> 32
    //   92: astore_1
    //   93: goto +45 -> 138
    //   96: astore_1
    //   97: getstatic 53	com/tencent/mobileqq/kandian/base/image/RunningJob:a	Ljava/lang/String;
    //   100: astore_2
    //   101: new 33	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   108: astore_3
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 379	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: ldc_w 440
    //   122: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_2
    //   127: iconst_1
    //   128: aload_3
    //   129: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: aload_0
    //   139: monitorexit
    //   140: goto +5 -> 145
    //   143: aload_1
    //   144: athrow
    //   145: goto -2 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	RunningJob
    //   0	148	1	paramURL	URL
    //   17	110	2	localObject1	Object
    //   58	71	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	92	finally
    //   22	32	92	finally
    //   32	89	92	finally
    //   97	135	92	finally
    //   2	18	96	java/lang/Throwable
    //   22	32	96	java/lang/Throwable
    //   32	89	96	java/lang/Throwable
  }
  
  private static void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("showUseTime", Long.toString(paramLong));
    String str2 = "1";
    String str1;
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    localHashMap.put("cached", str1);
    if (paramBoolean2) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("success", str1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Bitmap localBitmap = d();
    long l = System.currentTimeMillis();
    paramLong1 = l - paramLong1;
    a(localBitmap, l, paramLong1);
    int n = 0;
    boolean bool;
    if (localBitmap != null) {
      bool = true;
    } else {
      bool = false;
    }
    int m = n;
    if (bool)
    {
      m = n;
      if (localBitmap != null) {
        m = localBitmap.getByteCount();
      }
    }
    a(paramBoolean, paramLong2 + paramLong1, m, bool);
    a(localBitmap, bool);
  }
  
  @TargetApi(11)
  private BitmapFactory.Options b(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    for (;;)
    {
      try
      {
        if (this.d.getTempBufferSize() > 0)
        {
          arrayOfByte1 = this.d.removeTempBuffer(0);
          byte[] arrayOfByte2 = arrayOfByte1;
          if (arrayOfByte1 == null)
          {
            arrayOfByte1 = new byte[16384];
            arrayOfByte2 = arrayOfByte1;
            if (QLog.isColorLevel())
            {
              Utils.a(a, "allocate temp storage");
              arrayOfByte2 = arrayOfByte1;
            }
          }
          localOptions.inTempStorage = arrayOfByte2;
          localOptions.inJustDecodeBounds = true;
          try
          {
            BitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, localOptions);
            if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1))
            {
              localOptions.inJustDecodeBounds = false;
              localOptions.inDither = true;
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
              if (Build.VERSION.SDK_INT >= 11) {
                localOptions.inMutable = true;
              }
              localOptions.inSampleSize = a(localOptions, this.b.b, this.b.c);
              return localOptions;
            }
            throw new IllegalArgumentException("decode bounds fail");
          }
          catch (Exception paramInputStream)
          {
            this.d.addTempBuffer(localOptions.inTempStorage);
            throw paramInputStream;
          }
          catch (OutOfMemoryError paramInputStream)
          {
            this.d.addTempBuffer(localOptions.inTempStorage);
            throw paramInputStream;
          }
        }
        byte[] arrayOfByte1 = null;
      }
      finally {}
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.c.removeJob(this.b);
    paramBitmap = new CloseableBitmap(a(paramBitmap), this.d.getReleaser());
    this.d.cacheBitmap(this.b, paramBitmap);
    if (this.b.d)
    {
      RIJImageOptReport.a(6, this.b);
      RIJImageOptReport.a(this.b, false, "cancelled");
      paramBitmap.a();
      return;
    }
    RIJImageOptReport.a(5, this.b);
    if (RIJImageOptConfig.INSTANCE.isRenderFirst())
    {
      this.f.postAtFrontOfQueue(new RunningJob.2(this, paramBitmap));
      return;
    }
    this.f.post(new RunningJob.3(this, paramBitmap));
  }
  
  private void b(Throwable paramThrowable)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" retryCount:");
    localStringBuilder.append(this.j);
    QLog.d(str, 1, localStringBuilder.toString());
    int m = this.j;
    if (m == 0)
    {
      this.j = (m + 1);
      paramThrowable = this.k;
      if (paramThrowable != null) {
        paramThrowable.delete();
      }
      run();
      return;
    }
    a(paramThrowable, -3);
  }
  
  private boolean c()
  {
    for (;;)
    {
      try
      {
        if (j()) {
          return true;
        }
        this.g = new PublicAccountHttpDownloaderImpl().getHttpDownloader();
        Object localObject = i();
        boolean bool = this.g.hasDiskFile((DownloadParams)localObject);
        l1 = System.currentTimeMillis();
        this.k = a((DownloadParams)localObject, new StringBuilder());
        g();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        a(l3);
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[download success](");
        localStringBuilder.append(l3);
        localStringBuilder.append(")");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" fileSize:");
        if (this.k == null) {
          break label211;
        }
        l1 = this.k.length();
        localStringBuilder.append(l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        f();
        if (e()) {
          return true;
        }
        a(bool, l2, l3);
      }
      catch (Throwable localThrowable)
      {
        a(localThrowable);
      }
      return false;
      label211:
      long l1 = 0L;
    }
  }
  
  private boolean c(Throwable paramThrowable)
  {
    return (paramThrowable.getMessage() != null) && ((((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage().contains("decode fail"))) || (((paramThrowable instanceof IOException)) && (paramThrowable.getMessage().contains("write 0 length file or null File"))));
  }
  
  /* Error */
  private Bitmap d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   10: instanceof 632
    //   13: ifeq +111 -> 124
    //   16: new 634	java/io/ByteArrayInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   24: checkcast 632	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   27: invokevirtual 638	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getBytes	()[B
    //   30: invokespecial 640	java/io/ByteArrayInputStream:<init>	([B)V
    //   33: astore 4
    //   35: new 634	java/io/ByteArrayInputStream
    //   38: dup
    //   39: aload_0
    //   40: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   43: checkcast 632	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   46: invokevirtual 638	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getBytes	()[B
    //   49: invokespecial 640	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   58: checkcast 632	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   61: invokevirtual 643	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getLength	()J
    //   64: lstore_1
    //   65: iconst_0
    //   66: istore_3
    //   67: goto +128 -> 195
    //   70: astore 8
    //   72: aload 4
    //   74: astore 6
    //   76: aload 5
    //   78: astore 7
    //   80: aload 8
    //   82: astore 4
    //   84: aload 6
    //   86: astore 5
    //   88: aload 7
    //   90: astore 6
    //   92: goto +269 -> 361
    //   95: astore 6
    //   97: goto +208 -> 305
    //   100: astore 7
    //   102: aconst_null
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 7
    //   111: astore 4
    //   113: goto +248 -> 361
    //   116: astore 6
    //   118: aconst_null
    //   119: astore 5
    //   121: goto +184 -> 305
    //   124: new 645	java/io/FileInputStream
    //   127: dup
    //   128: aload_0
    //   129: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   132: invokespecial 646	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore 4
    //   137: new 645	java/io/FileInputStream
    //   140: dup
    //   141: aload_0
    //   142: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   145: invokespecial 646	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: aload 4
    //   152: astore 8
    //   154: aload 5
    //   156: astore 6
    //   158: aload 4
    //   160: astore 9
    //   162: aload 5
    //   164: astore 7
    //   166: aload_0
    //   167: getfield 146	com/tencent/mobileqq/kandian/base/image/RunningJob:k	Ljava/io/File;
    //   170: invokevirtual 612	java/io/File:length	()J
    //   173: lstore_1
    //   174: aload 4
    //   176: astore 8
    //   178: aload 5
    //   180: astore 6
    //   182: aload 4
    //   184: astore 9
    //   186: aload 5
    //   188: astore 7
    //   190: aload_0
    //   191: invokevirtual 648	com/tencent/mobileqq/kandian/base/image/RunningJob:b	()Z
    //   194: istore_3
    //   195: aload 4
    //   197: astore 8
    //   199: aload 5
    //   201: astore 6
    //   203: aload 4
    //   205: astore 9
    //   207: aload 5
    //   209: astore 7
    //   211: aload_0
    //   212: aload 4
    //   214: aload 5
    //   216: lload_1
    //   217: iload_3
    //   218: invokevirtual 651	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;Ljava/io/InputStream;JZ)Landroid/graphics/Bitmap;
    //   221: astore 10
    //   223: aload_0
    //   224: aload 4
    //   226: invokespecial 653	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   229: aload_0
    //   230: aload 5
    //   232: invokespecial 653	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   235: aload 10
    //   237: areturn
    //   238: astore 4
    //   240: aload 8
    //   242: astore 5
    //   244: goto +117 -> 361
    //   247: astore 6
    //   249: aload 9
    //   251: astore 4
    //   253: aload 7
    //   255: astore 5
    //   257: goto +48 -> 305
    //   260: astore 6
    //   262: aload 4
    //   264: astore 5
    //   266: aload 6
    //   268: astore 4
    //   270: aconst_null
    //   271: astore 6
    //   273: goto +88 -> 361
    //   276: astore 6
    //   278: aconst_null
    //   279: astore 5
    //   281: goto +24 -> 305
    //   284: astore 4
    //   286: aconst_null
    //   287: astore 6
    //   289: goto +72 -> 361
    //   292: astore 7
    //   294: aconst_null
    //   295: astore 5
    //   297: aload 6
    //   299: astore 4
    //   301: aload 7
    //   303: astore 6
    //   305: new 33	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   312: astore 7
    //   314: aload 7
    //   316: ldc_w 655
    //   319: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 7
    //   325: aload 6
    //   327: invokevirtual 656	java/lang/Exception:toString	()Ljava/lang/String;
    //   330: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: new 274	java/lang/RuntimeException
    //   337: dup
    //   338: aload 7
    //   340: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokespecial 279	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   346: athrow
    //   347: astore 7
    //   349: aload 5
    //   351: astore 6
    //   353: aload 4
    //   355: astore 5
    //   357: aload 7
    //   359: astore 4
    //   361: aload_0
    //   362: aload 5
    //   364: invokespecial 653	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   367: aload_0
    //   368: aload 6
    //   370: invokespecial 653	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   373: aload 4
    //   375: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	RunningJob
    //   64	153	1	l	long
    //   66	152	3	bool	boolean
    //   33	192	4	localObject1	Object
    //   238	1	4	localObject2	Object
    //   251	18	4	localObject3	Object
    //   284	1	4	localObject4	Object
    //   299	75	4	localObject5	Object
    //   1	362	5	localObject6	Object
    //   4	87	6	localObject7	Object
    //   95	1	6	localException1	Exception
    //   103	1	6	localObject8	Object
    //   116	1	6	localException2	Exception
    //   156	46	6	localObject9	Object
    //   247	1	6	localException3	Exception
    //   260	7	6	localObject10	Object
    //   271	1	6	localObject11	Object
    //   276	1	6	localException4	Exception
    //   287	82	6	localObject12	Object
    //   78	11	7	localObject13	Object
    //   100	10	7	localObject14	Object
    //   164	90	7	localObject15	Object
    //   292	10	7	localException5	Exception
    //   312	27	7	localStringBuilder	StringBuilder
    //   347	11	7	localObject16	Object
    //   70	11	8	localObject17	Object
    //   152	89	8	localObject18	Object
    //   160	90	9	localObject19	Object
    //   221	15	10	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   54	65	70	finally
    //   54	65	95	java/lang/Exception
    //   35	54	100	finally
    //   35	54	116	java/lang/Exception
    //   166	174	238	finally
    //   190	195	238	finally
    //   211	223	238	finally
    //   166	174	247	java/lang/Exception
    //   190	195	247	java/lang/Exception
    //   211	223	247	java/lang/Exception
    //   137	150	260	finally
    //   137	150	276	java/lang/Exception
    //   6	35	284	finally
    //   124	137	284	finally
    //   6	35	292	java/lang/Exception
    //   124	137	292	java/lang/Exception
    //   305	347	347	finally
  }
  
  private void d(Throwable paramThrowable)
  {
    RIJImageOptReport.a(6, this.b);
    RIJImageOptReport.a(this.b, false, paramThrowable.getMessage());
  }
  
  private boolean e()
  {
    if ((this.b.e) && (this.h.isEmpty()))
    {
      this.c.removeJob(this.b);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preload request]");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" no callback, give up decode");
      QLog.d(str, 2, localStringBuilder.toString());
      ImageManager.get().removeExecuteJob(this.b);
      return true;
    }
    return false;
  }
  
  private boolean e(Throwable paramThrowable)
  {
    return (((paramThrowable instanceof RuntimeException)) || ((paramThrowable instanceof IOException))) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("cancel"));
  }
  
  private void f()
  {
    if (!this.b.d) {
      return;
    }
    throw new RuntimeException("cancel");
  }
  
  private boolean f(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"));
  }
  
  private void g()
  {
    if (this.k != null) {
      return;
    }
    throw new IOException("downloader fail");
  }
  
  private void g(Throwable paramThrowable)
  {
    a(paramThrowable, -1);
  }
  
  private void h()
  {
    if (this.b.p == 0) {
      RIJImageOptReport.b(2, this.b);
    }
  }
  
  private void h(Throwable paramThrowable)
  {
    Object localObject = this.b;
    ((ImageRequest)localObject).u += 1;
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("try count: ");
    localStringBuilder.append(this.b.u);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (((paramThrowable != null) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"))) || (this.b.q == 400))
    {
      paramThrowable = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("before convert: ");
      ((StringBuilder)localObject).append(this.b.a);
      QLog.d(paramThrowable, 1, ((StringBuilder)localObject).toString());
      try
      {
        this.b.a = new URL(RIJImageTypeOptHelper.a.b(this.b.a.toString(), this.b.w));
      }
      catch (Exception paramThrowable)
      {
        QLog.d(a, 1, paramThrowable.getMessage());
      }
      paramThrowable = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("after convert: ");
      ((StringBuilder)localObject).append(this.b.a);
      QLog.d(paramThrowable, 1, ((StringBuilder)localObject).toString());
    }
    if ((this.b.u == ImageRequest.v) && (RIJImageOptConfig.INSTANCE.isRollbackToDomainConnect()))
    {
      paramThrowable = this.b;
      paramThrowable.x = false;
      paramThrowable.y = false;
      a(paramThrowable.a);
    }
    ThreadManager.getUIHandler().post(new RunningJob.5(this));
  }
  
  @NotNull
  private DownloadParams i()
  {
    RIJImageDownloadParams localRIJImageDownloadParams = new RIJImageDownloadParams();
    localRIJImageDownloadParams.url = this.b.a;
    localRIJImageDownloadParams.urlStr = this.b.a.toString();
    localRIJImageDownloadParams.retryCount = this.b.u;
    localRIJImageDownloadParams.a = this.b.x;
    localRIJImageDownloadParams.b = this.b.y;
    return localRIJImageDownloadParams;
  }
  
  private boolean j()
  {
    if (this.b.d)
    {
      RIJImageOptReport.a(6, this.b);
      ImageManager.get().removeExecuteJob(this.b);
      return true;
    }
    return false;
  }
  
  private boolean k()
  {
    return this.b.u < ImageRequest.v;
  }
  
  public Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    if (Utils.a()) {
      return b(paramInputStream1, paramInputStream2, paramLong);
    }
    return c(paramInputStream1, paramInputStream2, paramLong);
  }
  
  protected Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong, boolean paramBoolean)
  {
    Bitmap localBitmap2 = a(paramBoolean);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = a(paramInputStream1, paramInputStream2, paramLong);
    }
    return localBitmap1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cancel request]");
      localStringBuilder.append(this.b);
      Utils.a((String)localObject, localStringBuilder.toString());
    }
    this.b.d = true;
    Object localObject = this.g;
    if (localObject != null) {
      ((HttpDownloader)localObject).cancel();
    }
  }
  
  public void a(IBitmapCallback paramIBitmapCallback)
  {
    if (paramIBitmapCallback != null) {}
    try
    {
      this.h.add(new WeakReference(paramIBitmapCallback));
    }
    finally {}
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 770	com/tencent/mobileqq/kandian/base/image/RunningJob:b	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_2
    //   6: invokestatic 507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +65 -> 74
    //   12: getstatic 53	com/tencent/mobileqq/kandian/base/image/RunningJob:a	Ljava/lang/String;
    //   15: astore 6
    //   17: new 33	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc_w 772
    //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: aload_0
    //   38: getfield 80	com/tencent/mobileqq/kandian/base/image/RunningJob:b	Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;
    //   41: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 7
    //   47: ldc_w 774
    //   50: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: aload_2
    //   57: getfield 169	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   60: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 6
    //   66: aload 7
    //   68: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 514	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   78: aload_2
    //   79: invokeinterface 179 2 0
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +15 -> 103
    //   91: aload_2
    //   92: aload 6
    //   94: putfield 778	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   97: iconst_1
    //   98: istore 5
    //   100: goto +6 -> 106
    //   103: iconst_0
    //   104: istore 5
    //   106: new 523	java/io/BufferedInputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 525	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore_1
    //   115: aload_2
    //   116: invokestatic 781	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   119: ifeq +21 -> 140
    //   122: aload_1
    //   123: iconst_0
    //   124: invokestatic 787	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   127: aload_0
    //   128: aload_2
    //   129: invokespecial 789	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   132: aload_2
    //   133: invokevirtual 793	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   136: astore_1
    //   137: goto +10 -> 147
    //   140: aload_1
    //   141: aconst_null
    //   142: aload_2
    //   143: invokestatic 531	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   151: aload_2
    //   152: getfield 518	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   155: invokeinterface 546 2 0
    //   160: iload 5
    //   162: ifeq +23 -> 185
    //   165: aload 6
    //   167: aload_1
    //   168: if_acmpne +5 -> 173
    //   171: aload_1
    //   172: areturn
    //   173: aload_1
    //   174: invokevirtual 796	android/graphics/Bitmap:recycle	()V
    //   177: new 798	java/lang/IllegalStateException
    //   180: dup
    //   181: invokespecial 799	java/lang/IllegalStateException:<init>	()V
    //   184: athrow
    //   185: aload_1
    //   186: areturn
    //   187: astore_1
    //   188: goto +9 -> 197
    //   191: astore_1
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_1
    //   196: athrow
    //   197: aload_0
    //   198: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   201: aload_2
    //   202: getfield 518	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   205: invokeinterface 546 2 0
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	RunningJob
    //   0	212	1	paramInputStream1	InputStream
    //   0	212	2	paramInputStream2	InputStream
    //   0	212	3	paramLong	long
    //   98	63	5	m	int
    //   15	151	6	localObject	Object
    //   24	43	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   106	137	187	finally
    //   140	147	187	finally
    //   192	194	187	finally
    //   195	197	187	finally
    //   106	137	191	java/lang/RuntimeException
    //   140	147	191	java/lang/RuntimeException
    //   106	137	194	java/lang/OutOfMemoryError
    //   140	147	194	java/lang/OutOfMemoryError
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (AVSoUtils.g())
        {
          bool1 = bool2;
          if (RIJImageOptConfig.INSTANCE.useSharpP())
          {
            RIJImageTypeOptHelper localRIJImageTypeOptHelper = RIJImageTypeOptHelper.a;
            if (this.b.a == null) {
              break label97;
            }
            String str1 = this.b.a.toString();
            bool1 = bool2;
            if (localRIJImageTypeOptHelper.d(str1))
            {
              boolean bool3 = SharpPUtil.isSharpPFile(this.k);
              bool1 = bool2;
              if (bool3) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      catch (Throwable localThrowable)
      {
        QLog.d(a, 1, localThrowable.getMessage());
        return false;
      }
      label97:
      String str2 = "";
    }
  }
  
  /* Error */
  public Bitmap c(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 770	com/tencent/mobileqq/kandian/base/image/RunningJob:b	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore 12
    //   7: aload 12
    //   9: getstatic 818	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   12: putfield 821	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   15: lload_3
    //   16: l2i
    //   17: istore 5
    //   19: aconst_null
    //   20: astore 10
    //   22: aconst_null
    //   23: astore_2
    //   24: aconst_null
    //   25: astore 7
    //   27: aconst_null
    //   28: astore 9
    //   30: aconst_null
    //   31: astore 8
    //   33: aconst_null
    //   34: astore 11
    //   36: new 523	java/io/BufferedInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 525	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore 6
    //   46: aload 11
    //   48: astore 7
    //   50: aload 10
    //   52: astore 8
    //   54: aload 6
    //   56: astore_2
    //   57: aload 9
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   64: invokeinterface 825 1 0
    //   69: iload 5
    //   71: invokevirtual 829	com/tencent/mobileqq/kandian/base/image/BytePool:a	(I)[B
    //   74: astore 9
    //   76: aload 9
    //   78: astore 7
    //   80: aload 9
    //   82: astore 8
    //   84: aload 6
    //   86: astore_2
    //   87: aload 9
    //   89: astore_1
    //   90: aload 6
    //   92: aload 9
    //   94: iconst_0
    //   95: iload 5
    //   97: invokevirtual 833	java/io/InputStream:read	([BII)I
    //   100: pop
    //   101: aload 9
    //   103: astore 7
    //   105: aload 9
    //   107: astore 8
    //   109: aload 6
    //   111: astore_2
    //   112: aload 9
    //   114: astore_1
    //   115: aload 12
    //   117: invokestatic 781	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   120: ifeq +42 -> 162
    //   123: aload 9
    //   125: astore 7
    //   127: aload 9
    //   129: astore 8
    //   131: aload 6
    //   133: astore_2
    //   134: aload 9
    //   136: astore_1
    //   137: aload 9
    //   139: iconst_0
    //   140: iload 5
    //   142: iconst_0
    //   143: invokestatic 836	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   146: aload_0
    //   147: aload 12
    //   149: invokespecial 789	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   152: aload 12
    //   154: invokevirtual 793	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   157: astore 10
    //   159: goto +29 -> 188
    //   162: aload 9
    //   164: astore 7
    //   166: aload 9
    //   168: astore 8
    //   170: aload 6
    //   172: astore_2
    //   173: aload 9
    //   175: astore_1
    //   176: aload 9
    //   178: iconst_0
    //   179: iload 5
    //   181: aload 12
    //   183: invokestatic 840	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: astore 10
    //   188: aload 9
    //   190: astore 7
    //   192: aload 9
    //   194: astore 8
    //   196: aload 6
    //   198: astore_2
    //   199: aload 9
    //   201: astore_1
    //   202: getstatic 818	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   205: ifeq +22 -> 227
    //   208: aload 9
    //   210: astore 7
    //   212: aload 9
    //   214: astore 8
    //   216: aload 6
    //   218: astore_2
    //   219: aload 9
    //   221: astore_1
    //   222: aload 10
    //   224: invokestatic 843	com/tencent/mobileqq/kandian/base/image/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   227: aload 9
    //   229: ifnull +17 -> 246
    //   232: aload_0
    //   233: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   236: invokeinterface 825 1 0
    //   241: aload 9
    //   243: invokevirtual 845	com/tencent/mobileqq/kandian/base/image/BytePool:a	([B)V
    //   246: aload_0
    //   247: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   250: aload 12
    //   252: getfield 518	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   255: invokeinterface 546 2 0
    //   260: aload 6
    //   262: invokevirtual 342	java/io/InputStream:close	()V
    //   265: aload 10
    //   267: areturn
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 848	java/io/IOException:printStackTrace	()V
    //   273: aload 10
    //   275: areturn
    //   276: astore_1
    //   277: aload 6
    //   279: astore_2
    //   280: aload_1
    //   281: astore 6
    //   283: aload 7
    //   285: astore_1
    //   286: goto +36 -> 322
    //   289: astore_1
    //   290: aload 6
    //   292: astore_2
    //   293: aload_1
    //   294: astore 6
    //   296: aload 8
    //   298: astore_1
    //   299: goto +26 -> 325
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_2
    //   305: aload 8
    //   307: astore 6
    //   309: goto +27 -> 336
    //   312: astore 6
    //   314: aconst_null
    //   315: astore 7
    //   317: aload_2
    //   318: astore_1
    //   319: aload 7
    //   321: astore_2
    //   322: aload 6
    //   324: athrow
    //   325: aload 6
    //   327: athrow
    //   328: astore 7
    //   330: aload_1
    //   331: astore 6
    //   333: aload 7
    //   335: astore_1
    //   336: aload 6
    //   338: ifnull +17 -> 355
    //   341: aload_0
    //   342: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   345: invokeinterface 825 1 0
    //   350: aload 6
    //   352: invokevirtual 845	com/tencent/mobileqq/kandian/base/image/BytePool:a	([B)V
    //   355: aload_0
    //   356: getfield 87	com/tencent/mobileqq/kandian/base/image/RunningJob:d	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   359: aload 12
    //   361: getfield 518	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   364: invokeinterface 546 2 0
    //   369: aload_2
    //   370: ifnull +15 -> 385
    //   373: aload_2
    //   374: invokevirtual 342	java/io/InputStream:close	()V
    //   377: goto +8 -> 385
    //   380: astore_2
    //   381: aload_2
    //   382: invokevirtual 848	java/io/IOException:printStackTrace	()V
    //   385: aload_1
    //   386: athrow
    //   387: astore 6
    //   389: aconst_null
    //   390: astore_2
    //   391: aload 7
    //   393: astore_1
    //   394: goto -69 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	RunningJob
    //   0	397	1	paramInputStream1	InputStream
    //   0	397	2	paramInputStream2	InputStream
    //   0	397	3	paramLong	long
    //   17	163	5	m	int
    //   44	264	6	localObject1	Object
    //   312	14	6	localException	Exception
    //   331	20	6	localInputStream	InputStream
    //   387	1	6	localOutOfMemoryError	OutOfMemoryError
    //   25	295	7	localObject2	Object
    //   328	64	7	localObject3	Object
    //   31	275	8	localObject4	Object
    //   28	214	9	arrayOfByte	byte[]
    //   20	254	10	localBitmap	Bitmap
    //   34	13	11	localObject5	Object
    //   5	355	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   260	265	268	java/io/IOException
    //   60	76	276	java/lang/Exception
    //   90	101	276	java/lang/Exception
    //   115	123	276	java/lang/Exception
    //   137	159	276	java/lang/Exception
    //   176	188	276	java/lang/Exception
    //   202	208	276	java/lang/Exception
    //   222	227	276	java/lang/Exception
    //   60	76	289	java/lang/OutOfMemoryError
    //   90	101	289	java/lang/OutOfMemoryError
    //   115	123	289	java/lang/OutOfMemoryError
    //   137	159	289	java/lang/OutOfMemoryError
    //   176	188	289	java/lang/OutOfMemoryError
    //   202	208	289	java/lang/OutOfMemoryError
    //   222	227	289	java/lang/OutOfMemoryError
    //   36	46	302	finally
    //   36	46	312	java/lang/Exception
    //   60	76	328	finally
    //   90	101	328	finally
    //   115	123	328	finally
    //   137	159	328	finally
    //   176	188	328	finally
    //   202	208	328	finally
    //   222	227	328	finally
    //   322	325	328	finally
    //   325	328	328	finally
    //   373	377	380	java/io/IOException
    //   36	46	387	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public void run()
  {
    RIJImageOptReport.a(4, this.b);
    ImageManager.get().putExecuteJob(this.b);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[start request](");
    localStringBuilder.append(System.currentTimeMillis() - this.i);
    localStringBuilder.append(")");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" createTs:");
    localStringBuilder.append(this.i);
    QLog.d(str, 2, localStringBuilder.toString());
    if (c()) {
      return;
    }
    ImageManager.get().removeExecuteJob(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob
 * JD-Core Version:    0.7.0.1
 */