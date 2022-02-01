package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/impl/ImageManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IImageManager;", "()V", "cancelRequest", "", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "reason", "", "clean", "getBitmap", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "isLocalFileExist", "", "url", "Ljava/net/URL;", "loadImage", "uicallback", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCallback;", "pauseDownload", "resume", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageManagerImpl
  implements IImageManager
{
  public ImageManagerImpl()
  {
    ImageManager localImageManager = ImageManager.get();
    Intrinsics.checkExpressionValueIsNotNull(localImageManager, "ImageManager.get()");
    this.$$delegate_0 = localImageManager;
  }
  
  public void cancelRequest(@Nullable ImageRequest paramImageRequest, @Nullable String paramString)
  {
    this.$$delegate_0.cancelRequest(paramImageRequest, paramString);
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
  
  public boolean isLocalFileExist(@Nullable URL paramURL)
  {
    return this.$$delegate_0.isLocalFileExist(paramURL);
  }
  
  public void loadImage(@Nullable ImageRequest paramImageRequest, @Nullable IBitmapCallback paramIBitmapCallback)
  {
    this.$$delegate_0.loadImage(paramImageRequest, paramIBitmapCallback);
  }
  
  public void pauseDownload()
  {
    this.$$delegate_0.pauseDownload();
  }
  
  public void resume()
  {
    this.$$delegate_0.resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.ImageManagerImpl
 * JD-Core Version:    0.7.0.1
 */