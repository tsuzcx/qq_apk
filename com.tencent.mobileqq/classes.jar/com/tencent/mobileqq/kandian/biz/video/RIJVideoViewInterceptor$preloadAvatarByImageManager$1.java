package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/RIJVideoViewInterceptor$preloadAvatarByImageManager$1", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$preloadAvatarByImageManager$1
  implements IBitmapCallback
{
  RIJVideoViewInterceptor$preloadAvatarByImageManager$1(String paramString) {}
  
  public void a(@NotNull ImageRequest paramImageRequest, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "request");
  }
  
  public void a(@Nullable ImageRequest paramImageRequest, @Nullable ICloseableBitmap paramICloseableBitmap)
  {
    if (QLog.isColorLevel())
    {
      paramImageRequest = new StringBuilder();
      paramImageRequest.append("preloadAvatarByImageManager ImageManager onSuccess, url:");
      paramImageRequest.append(this.a);
      QLog.d("RIJVideoViewInterceptor", 2, paramImageRequest.toString());
    }
  }
  
  public void a(@NotNull ImageRequest paramImageRequest, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "request");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager ImageManager onFail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor.preloadAvatarByImageManager.1
 * JD-Core Version:    0.7.0.1
 */