package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class EffectsCameraCaptureView$7
  implements Runnable
{
  EffectsCameraCaptureView$7(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    this.this$0.a.getBusinessOperation().stopEffectsAudio();
    this.this$0.f();
    this.this$0.a.getBusinessOperation().handleDanceGameAudioPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.7
 * JD-Core Version:    0.7.0.1
 */