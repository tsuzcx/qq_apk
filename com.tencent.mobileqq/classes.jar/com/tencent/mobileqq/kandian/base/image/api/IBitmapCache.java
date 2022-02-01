package com.tencent.mobileqq.kandian.base.image.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.kandian.base.image.BytePool;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.Releaser;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addTempBuffer", "", "byteArray", "", "cacheBitmap", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "state", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "clean", "getBitmap", "getBytePool", "Lcom/tencent/mobileqq/kandian/base/image/BytePool;", "getCloseableBitmapFromCache", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/CloseableBitmap;", "key", "", "getReleaser", "Lcom/tencent/mobileqq/kandian/base/image/Releaser;", "Landroid/graphics/Bitmap;", "getReusableBitmap", "options", "Landroid/graphics/BitmapFactory$Options;", "getTempBufferSize", "", "putImageToCache", "bitmap", "removeTempBuffer", "index", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBitmapCache
  extends QRouteApi
{
  public abstract void addTempBuffer(@Nullable byte[] paramArrayOfByte);
  
  public abstract void cacheBitmap(@Nullable ImageRequest paramImageRequest, @Nullable ICloseableBitmap paramICloseableBitmap);
  
  public abstract void clean();
  
  @Nullable
  public abstract ICloseableBitmap getBitmap(@Nullable ImageRequest paramImageRequest);
  
  @Nullable
  public abstract BytePool getBytePool();
  
  @Nullable
  public abstract CloseableBitmap getCloseableBitmapFromCache(@Nullable String paramString);
  
  @Nullable
  public abstract Releaser<Bitmap> getReleaser();
  
  @Nullable
  public abstract Bitmap getReusableBitmap(@Nullable BitmapFactory.Options paramOptions);
  
  public abstract int getTempBufferSize();
  
  public abstract void putImageToCache(@Nullable String paramString, @Nullable ICloseableBitmap paramICloseableBitmap);
  
  @Nullable
  public abstract byte[] removeTempBuffer(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
 * JD-Core Version:    0.7.0.1
 */