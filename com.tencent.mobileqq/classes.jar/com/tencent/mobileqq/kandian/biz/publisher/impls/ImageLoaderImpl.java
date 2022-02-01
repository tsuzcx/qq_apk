package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.widget.ImageView;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  public static final ImageLoaderImpl.Companion a;
  private final int jdField_a_of_type_Int = (int)(Runtime.getRuntime().maxMemory() / 1024);
  private final DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private final ImageLoaderImpl.lruCache.1 jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsImageLoaderImpl$lruCache$1 = new ImageLoaderImpl.lruCache.1(this, this.jdField_a_of_type_Int / 8);
  private final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final int b;
  private final int c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsImageLoaderImpl$Companion = new ImageLoaderImpl.Companion(null);
  }
  
  public ImageLoaderImpl()
  {
    this.jdField_b_of_type_Int = 52428800;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(a((Context)localBaseApplication, "bitmap"), 1, 1, this.jdField_b_of_type_Int);
    this.c = Runtime.getRuntime().availableProcessors();
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(this.c, this.c * 2, 60L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingDeque(50));
  }
  
  private final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int k = 1;
    int i = k;
    if (paramInt3 > 0)
    {
      if (paramInt2 > 0) {
        break label25;
      }
      i = k;
    }
    label25:
    do
    {
      return i;
      if (paramInt1 > paramInt4) {
        break;
      }
      i = k;
    } while (paramInt2 <= paramInt3);
    paramInt2 /= 2;
    k = paramInt1 / 2;
    paramInt1 = j;
    for (;;)
    {
      if (paramInt2 / paramInt1 < paramInt4)
      {
        i = paramInt1;
        if (k / paramInt1 < paramInt3) {
          break;
        }
      }
      paramInt1 *= 2;
    }
  }
  
  private final int a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (localOptions.outMimeType == null) {
      return -1;
    }
    return a(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2);
  }
  
  private final Bitmap a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime();
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ImageLoaderImpl", 1, "MediaMetadataRetriever.setDataSource. path=" + paramString + ", e=" + localException);
      return null;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  private final Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(paramString, paramInt1, paramInt2);
    if (localOptions.inSampleSize == -1)
    {
      paramString = a(paramString);
      if (paramString != null) {
        localOptions.inSampleSize = a(paramString.getWidth(), paramString.getHeight(), paramInt1, paramInt2);
      }
    }
    for (paramString = Bitmap.createScaledBitmap(paramString, paramString.getWidth() / localOptions.inSampleSize, paramString.getHeight() / localOptions.inSampleSize, true);; paramString = BitmapFactory.decodeFile(paramString, localOptions))
    {
      return paramString;
      return null;
      localOptions.inJustDecodeBounds = false;
    }
  }
  
  private final File a(Context paramContext, String paramString)
  {
    if ((Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable()))
    {
      paramContext = paramContext.getExternalCacheDir();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.externalCacheDir");
      paramContext = paramContext.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.externalCacheDir.path");
    }
    for (;;)
    {
      return new File(paramContext + File.separator + paramString);
      paramContext = paramContext.getCacheDir();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.cacheDir");
      paramContext = paramContext.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.cacheDir.path");
    }
  }
  
  private final void a(String paramString, Bitmap paramBitmap)
  {
    paramString = (Runnable)new ImageLoaderImpl.saveBitmapToDiskCache.runnable.1(this, paramString, paramBitmap);
    paramBitmap = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue();
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "threadPool.queue");
    if (!((Collection)paramBitmap).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().remainingCapacity() > 10)) {}
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().add(paramString);
        return;
      }
      catch (Exception paramString) {}
    }
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramString);
    return;
  }
  
  private final void a(String paramString, ImageView paramImageView, IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageLoaderOption.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = paramImageLoaderOption.jdField_b_of_type_Int;
    localURLDrawableOptions.mGifRoundCorner = paramImageLoaderOption.c;
    localURLDrawableOptions.mUseMemoryCache = true;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private final void a(String paramString1, String paramString2, ImageView paramImageView, IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    paramString1 = (Runnable)new ImageLoaderImpl.loadImageFromFile.runnable.1(this, paramImageLoaderOption, paramImageView, paramString1, paramString2);
    paramString2 = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "threadPool.queue");
    int i;
    if (!((Collection)paramString2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      try
      {
        paramString2 = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue();
        if (paramString2 != null) {
          break label105;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
      }
      catch (Exception paramString2)
      {
        paramString2 = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue();
        if (paramString2 != null) {
          break label114;
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
      i = 0;
      continue;
      label105:
      ((LinkedBlockingDeque)paramString2).addFirst(paramString1);
      return;
      label114:
      ((LinkedBlockingDeque)paramString2).removeLast();
      paramString2 = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue();
      if (paramString2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable!>");
      }
      ((LinkedBlockingDeque)paramString2).addFirst(paramString1);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramString1);
  }
  
  private final Bitmap b(String paramString)
  {
    paramString = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.get(paramString);
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
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramImageView.setImageDrawable(paramImageLoaderOption.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    if ((StringsKt.startsWith$default(paramString, "https://", false, 2, null)) || (StringsKt.startsWith$default(paramString, "http://", false, 2, null)))
    {
      a(paramString, paramImageView, paramImageLoaderOption);
      return;
    }
    if (!new File(paramString).exists())
    {
      paramImageView.setImageDrawable(paramImageLoaderOption.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramContext = MD5.a(paramString);
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsImageLoaderImpl$lruCache$1.get(paramContext);
    if (localBitmap == null)
    {
      paramImageView.setTag(paramContext);
      paramImageView.setImageDrawable(paramImageLoaderOption.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "key");
      a(paramContext, paramString, paramImageView, paramImageLoaderOption);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl
 * JD-Core Version:    0.7.0.1
 */