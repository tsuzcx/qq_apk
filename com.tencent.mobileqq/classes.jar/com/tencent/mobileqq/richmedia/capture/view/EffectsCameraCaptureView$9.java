package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class EffectsCameraCaptureView$9
  implements Runnable
{
  EffectsCameraCaptureView$9(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.getBusinessOperation().setQmcfPoseFilter(null, null, null);
      this.this$0.a.getBusinessOperation().setFaceDanceFilter(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.9
 * JD-Core Version:    0.7.0.1
 */