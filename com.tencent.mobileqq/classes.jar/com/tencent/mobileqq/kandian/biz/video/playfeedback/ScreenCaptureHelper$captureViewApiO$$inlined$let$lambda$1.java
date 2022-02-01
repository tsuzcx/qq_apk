package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.graphics.Bitmap;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "copyResult", "", "onPixelCopyFinished", "com/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$captureViewApiO$1$1"}, k=3, mv={1, 1, 16})
final class ScreenCaptureHelper$captureViewApiO$$inlined$let$lambda$1
  implements PixelCopy.OnPixelCopyFinishedListener
{
  ScreenCaptureHelper$captureViewApiO$$inlined$let$lambda$1(Bitmap paramBitmap, ScreenCaptureHelper paramScreenCaptureHelper, View paramView, float paramFloat, ScreenCaptureHelper.CaptureViewCallback paramCaptureViewCallback) {}
  
  public final void onPixelCopyFinished(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.b;
      Bitmap localBitmap = this.a;
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
      ScreenCaptureHelper.a((ScreenCaptureHelper)localObject, localBitmap, this.e);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("captureViewApiO failed, copyResult:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ScreenCaptureHelper", 1, ((StringBuilder)localObject).toString());
    localObject = this.e;
    if (localObject != null) {
      ((ScreenCaptureHelper.CaptureViewCallback)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.captureViewApiO..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */