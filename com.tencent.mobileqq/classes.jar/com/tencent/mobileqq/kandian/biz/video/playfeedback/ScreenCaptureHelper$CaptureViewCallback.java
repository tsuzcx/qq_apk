package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ScreenCaptureHelper$CaptureViewCallback
{
  public abstract void a();
  
  public abstract void a(@NotNull Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.CaptureViewCallback
 * JD-Core Version:    0.7.0.1
 */