package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class EffectsCameraCaptureView$5
  implements Runnable
{
  EffectsCameraCaptureView$5(EffectsCameraCaptureView paramEffectsCameraCaptureView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.getBusinessOperation().setUpCosmeticsAlpha(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.5
 * JD-Core Version:    0.7.0.1
 */