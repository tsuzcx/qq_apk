package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class EffectsCameraCaptureView$8
  implements Runnable
{
  EffectsCameraCaptureView$8(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.getBusinessOperation().handleDanceFilterEvent();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.8
 * JD-Core Version:    0.7.0.1
 */