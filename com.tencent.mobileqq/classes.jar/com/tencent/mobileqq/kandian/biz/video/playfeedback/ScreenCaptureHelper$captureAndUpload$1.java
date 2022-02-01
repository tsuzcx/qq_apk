package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$captureAndUpload$1", "Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScreenCaptureHelper$captureAndUpload$1
  implements ScreenCaptureHelper.CaptureViewCallback
{
  ScreenCaptureHelper$captureAndUpload$1(IImageUploadListener paramIImageUploadListener) {}
  
  public void a()
  {
    IImageUploadListener localIImageUploadListener = this.b;
    if (localIImageUploadListener != null) {
      localIImageUploadListener.a(1, "");
    }
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    ScreenCaptureHelper.a(this.a, paramBitmap, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.captureAndUpload.1
 * JD-Core Version:    0.7.0.1
 */