package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class EffectsCameraCaptureView$4
  implements Runnable
{
  EffectsCameraCaptureView$4(EffectsCameraCaptureView paramEffectsCameraCaptureView, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.j) && (this.this$0.k)) {
      this.this$0.a.getBusinessOperation().updateSharpFace(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.4
 * JD-Core Version:    0.7.0.1
 */