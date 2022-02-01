package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.widget.ImageView;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tkd.topicsdk.common.MD5;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ImageLoaderImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "()V", "DISK_CACHE_SIZE", "", "coreThread", "diskCache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "kotlin.jvm.PlatformType", "lruCache", "com/tencent/mobileqq/kandian/biz/publisher/impls/ImageLoaderImpl$lruCache$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ImageLoaderImpl$lruCache$1;", "maxMemory", "threadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "calculate", "realWidth", "realHeight", "reqWidth", "reqHeight", "calculateInSampleSize", "path", "", "decodeSampledBitmapFromFile", "Landroid/graphics/Bitmap;", "getBitmapToDiskCache", "key", "getDiskCacheDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "uniqueName", "getVideoThumb", "load", "", "imageView", "Landroid/widget/ImageView;", "option", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader$ImageLoaderOption;", "loadImageFromFile", "loadImageFromNetwork", "options", "saveBitmapToDiskCache", "bitmap", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageLoaderImpl
  implements IImageLoader
{
  public static final ImageLoaderImpl.Companion a = new ImageLoaderImpl.Companion(null);
  private final int b = (int)(Runtime.getRuntime().maxMemory() / 1024);
  private final int c = 52428800;
  private final ImageLoaderImpl.lruCache.1 d = new ImageLoaderImpl.lruCache.1(this, this.b / 8);
  private final DiskLruCache e;
  private final int f;
  private final ThreadPoolExecutor g;
  
  public ImageLoaderImpl()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    this.e = DiskLruCache.open(a((Context)localBaseApplication, "bitmap"), 1, 1, this.c);
    this.f = Runtime.getRuntime().availableProcessors();
    int i = this.f;
    this.g = new ThreadPoolExecutor(i, i * 2, 60L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingDeque(50));
  }
  
  private final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    int j = 1;
    if (paramInt3 > 0)
    {
      if (paramInt2 <= 0) {
        return 1;
      }
      int k;
      if ((paramInt1 > paramInt4) || (paramInt2 > paramInt3))
      {
        paramInt2 /= 2;
        k = paramInt1 / 2;
        paramInt1 = j;
      }
      for (;;)
      {
        if (paramInt2 / paramInt1 < paramInt4)
        {
          i = paramInt1;
          if (k / paramInt1 < paramInt3) {
            return i;
          }
        }
        paramInt1 *= 2;
      }
    }
    return 1;
  }
  
  /* Error */
  private final Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 171	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 172	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokevirtual 176	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: invokevirtual 180	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: invokevirtual 183	android/media/MediaMetadataRetriever:release	()V
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: goto +59 -> 86
    //   30: astore_2
    //   31: new 185	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: ldc 188
    //   44: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: aload_1
    //   51: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: ldc 194
    //   59: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: aload_2
    //   66: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 199
    //   72: iconst_1
    //   73: aload 4
    //   75: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aconst_null
    //   82: astore_1
    //   83: goto -63 -> 20
    //   86: aload_3
    //   87: invokevirtual 183	android/media/MediaMetadataRetriever:release	()V
    //   90: goto +5 -> 95
    //   93: aload_1
    //   94: athrow
    //   95: goto -2 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	ImageLoaderImpl
    //   0	98	1	paramString	String
    //   17	2	2	localBitmap	Bitmap
    //   30	36	2	localException	Exception
    //   7	80	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   38	36	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	18	26	finally
    //   31	81	26	finally
    //   8	18	30	java/lang/Exception
  }
  
  private final Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = b(paramString, paramInt1, paramInt2);
    if (localOptions.inSampleSize == -1)
    {
      paramString = a(paramString);
      if (paramString != null)
      {
        localOptions.inSampleSize = a(paramString.getWidth(), paramString.getHeight(), paramInt1, paramInt2);
        return Bitmap.createScaledBitmap(paramString, paramString.getWidth() / localOptions.inSampleSize, paramString.getHeight() / localOptions.inSampleSize, true);
      }
      return null;
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  private final File a(Context paramContext, String paramString)
  {
    if ((!Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) && (Environment.isExternalStorageRemovable()))
    {
      paramContext = paramContext.getCacheDir();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.cacheDir");
      paramContext = paramContext.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.cacheDir.path");
    }
    else
    {
      paramContext = paramContext.getExternalCacheDir();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.externalCacheDir");
      paramContext = paramContext.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.externalCacheDir.path");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString());
  }
  
  private final void a(String paramString, Bitmap paramBitmap)
  {
    paramString = (Runnable)new ImageLoaderImpl.saveBitmapToDiskCache.runnable.1(this, paramString, paramBitmap);
    paramBitmap = this.g.getQueue();
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "threadPool.queue");
    if ((!(((Collection)paramBitmap).isEmpty() ^ true)) || (this.g.getQueue().remainingCapacity() > 10)) {}
    try
    {
      this.g.getQueue().add(paramString);
      return;
    }
    catch (Exception paramString) {}
    this.g.execute(paramString);
    return;
  }
  
  private final void a(String paramString, ImageView paramImageView, IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageLoaderOption.a;
    localURLDrawableOptions.mRequestHeight = paramImageLoaderOption.b;
    localURLDrawableOptions.mGifRoundCorner = paramImageLoaderOption.c;
    localURLDrawableOptions.mUseMemoryCache = true;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private final void a(String paramString1, String paramString2, ImageView paramImageView, IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    paramString1 = (Runnable)new ImageLoaderImpl.loadImageFromFile.runnable.1(this, paramImageLoaderOption, paramImageView, paramString1, paramString2);
    paramString2 = this.g.getQueue();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "threadPool.queue");
    if ((((Collection)paramString2).isEmpty() ^ true)) {}
    try
    {
      paramString2 = this.g.getQueue();
      if (paramString2 != null)
      {
        ((LinkedBlockingDeque)paramString2).addFirst(paramString1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
    }
    catch (Exception paramString2)
    {
      label78:
      break label78;
    }
    paramString2 = this.g.getQueue();
    if (paramString2 != null)
    {
      ((LinkedBlockingDeque)paramString2).removeLast();
      paramString2 = this.g.getQueue();
      if (paramString2 != null)
      {
        ((LinkedBlockingDeque)paramString2).addFirst(paramString1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
    this.g.execute(paramString1);
  }
  
  private final int b(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (localOptions.outMimeType == null) {
      return -1;
    }
    return a(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2);
  }
  
  private final Bitmap b(String paramString)
  {
    paramString = this.e.get(paramString);
    if (paramString != null) {
      return BitmapFactory.decodeStream(paramString.getInputStream(0));
    }
    return null;
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString, @Nullable ImageView paramImageView, @NotNull IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramImageLoaderOption, "option");
    if (paramImageView == null) {
      return;
    }
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramImageView.setImageDrawable(paramImageLoaderOption.e);
      return;
    }
    if ((!StringsKt.startsWith$default(paramString, "https://", false, 2, null)) && (!StringsKt.startsWith$default(paramString, "http://", false, 2, null)))
    {
      if (!new File(paramString).exists())
      {
        paramImageView.setImageDrawable(paramImageLoaderOption.e);
        return;
      }
      paramContext = MD5.a(paramString);
      Bitmap localBitmap = (Bitmap)this.d.get(paramContext);
      if (localBitmap == null)
      {
        paramImageView.setTag(paramContext);
        paramImageView.setImageDrawable(paramImageLoaderOption.d);
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "key");
        a(paramContext, paramString, paramImageView, paramImageLoaderOption);
        return;
      }
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    a(paramString, paramImageView, paramImageLoaderOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl
 * JD-Core Version:    0.7.0.1
 */