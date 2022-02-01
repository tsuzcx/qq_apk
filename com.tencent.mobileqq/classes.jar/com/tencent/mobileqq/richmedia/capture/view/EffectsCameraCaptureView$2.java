package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class EffectsCameraCaptureView$2
  implements Runnable
{
  EffectsCameraCaptureView$2(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.j)
    {
      long l1 = System.currentTimeMillis();
      this.this$0.a.getBusinessOperation().setDanceEventHandler(EffectsCameraCaptureView.a(this.this$0));
      this.this$0.a.surfaceCreate(this.this$0.n, this.this$0.o, this.this$0.getWidth(), this.this$0.getHeight());
      this.this$0.a.surfaceChange(this.this$0.n, this.this$0.o, this.this$0.getWidth(), this.this$0.getHeight());
      this.this$0.a.getBusinessOperation().setEffectMute(EffectsCameraCaptureView.b(this.this$0));
      this.this$0.j = true;
      if (EffectsCameraCaptureView.a(this.this$0) != null) {
        this.this$0.setFaceEffect(EffectsCameraCaptureView.a(this.this$0));
      }
      if (EffectsCameraCaptureView.a(this.this$0) != 0) {
        this.this$0.setBeauty(EffectsCameraCaptureView.a(this.this$0));
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, new Object[] { "onFirstFrameShownInternal initQQFilterManger(GPU):", Long.valueOf(l2 - l1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.2
 * JD-Core Version:    0.7.0.1
 */