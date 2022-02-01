package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.graphics.Bitmap;
import android.support.v4.util.AsyncLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/ImageLoaderImpl$lruCache$1", "Landroid/support/v4/util/AsyncLruCache;", "", "Landroid/graphics/Bitmap;", "sizeOf", "", "key", "bitmap", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageLoaderImpl$lruCache$1
  extends AsyncLruCache<String, Bitmap>
{
  ImageLoaderImpl$lruCache$1(int paramInt)
  {
    super(i);
  }
  
  protected int a(@Nullable String paramString, @NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    return paramBitmap.getByteCount() / 1024;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl.lruCache.1
 * JD-Core Version:    0.7.0.1
 */