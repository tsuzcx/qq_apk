package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ScreenCaptureHelper$captureViewLowApi$1
  implements Runnable
{
  ScreenCaptureHelper$captureViewLowApi$1(ScreenCaptureHelper paramScreenCaptureHelper, View paramView, float paramFloat, ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback) {}
  
  public final void run()
  {
    Bitmap localBitmap = ScreenCaptureHelper.a(this.this$0, this.a, this.b);
    ThreadManager.getUIHandler().post((Runnable)new ScreenCaptureHelper.captureViewLowApi.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.captureViewLowApi.1
 * JD-Core Version:    0.7.0.1
 */