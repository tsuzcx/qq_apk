package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.kandian.base.image.BytePool;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.Releaser;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.imageloader.BitmapCache;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/impl/BitmapCacheImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;", "()V", "addTempBuffer", "", "byteArray", "", "cacheBitmap", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "state", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "clean", "getBitmap", "getBytePool", "Lcom/tencent/mobileqq/kandian/base/image/BytePool;", "getCloseableBitmapFromCache", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/CloseableBitmap;", "key", "", "getReleaser", "Lcom/tencent/mobileqq/kandian/base/image/Releaser;", "Landroid/graphics/Bitmap;", "getReusableBitmap", "options", "Landroid/graphics/BitmapFactory$Options;", "getTempBufferSize", "", "putImageToCache", "bitmap", "removeTempBuffer", "index", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BitmapCacheImpl
  implements IBitmapCache
{
  public void addTempBuffer(@Nullable byte[] paramArrayOfByte)
  {
    this.$$delegate_0.addTempBuffer(paramArrayOfByte);
  }
  
  public void cacheBitmap(@Nullable ImageRequest paramImageRequest, @Nullable ICloseableBitmap paramICloseableBitmap)
  {
    this.$$delegate_0.cacheBitmap(paramImageRequest, paramICloseableBitmap);
  }
  
  public void clean()
  {
    this.$$delegate_0.clean();
  }
  
  @Nullable
  public ICloseableBitmap getBitmap(@Nullable ImageRequest paramImageRequest)
  {
    return this.$$delegate_0.getBitmap(paramImageRequest);
  }
  
  @Nullable
  public BytePool getBytePool()
  {
    return this.$$delegate_0.getBytePool();
  }
  
  @Nullable
  public CloseableBitmap getCloseableBitmapFromCache(@Nullable String paramString)
  {
    return this.$$delegate_0.getCloseableBitmapFromCache(paramString);
  }
  
  @Nullable
  public Releaser<Bitmap> getReleaser()
  {
    return this.$$delegate_0.getReleaser();
  }
  
  @Nullable
  public Bitmap getReusableBitmap(@Nullable BitmapFactory.Options paramOptions)
  {
    return this.$$delegate_0.getReusableBitmap(paramOptions);
  }
  
  public int getTempBufferSize()
  {
    return this.$$delegate_0.getTempBufferSize();
  }
  
  public void putImageToCache(@Nullable String paramString, @Nullable ICloseableBitmap paramICloseableBitmap)
  {
    this.$$delegate_0.putImageToCache(paramString, paramICloseableBitmap);
  }
  
  @Nullable
  public byte[] removeTempBuffer(int paramInt)
  {
    return this.$$delegate_0.removeTempBuffer(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.BitmapCacheImpl
 * JD-Core Version:    0.7.0.1
 */