package com.tencent.mobileqq.richmedia.capture.view;

import android.os.Process;
import axnb;
import axnc;
import com.tencent.qphone.base.util.QLog;

class EffectsCameraCaptureView$1
  implements Runnable
{
  EffectsCameraCaptureView$1(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    Process.setThreadPriority(Process.getThreadPriority(Process.myTid()) + 1);
    long l1 = System.currentTimeMillis();
    this.this$0.y();
    long l2 = System.currentTimeMillis();
    if (EffectsCameraCaptureView.a(this.this$0) != null) {
      EffectsCameraCaptureView.a(this.this$0).a_(EffectsCameraCaptureView.a(this.this$0));
    }
    if (EffectsCameraCaptureView.a(this.this$0) != null) {
      EffectsCameraCaptureView.a(this.this$0).a(EffectsCameraCaptureView.a(this.this$0));
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, new Object[] { "onFirstFrameShownInternal soLoaded:", Boolean.valueOf(EffectsCameraCaptureView.a(this.this$0)), "  initQQFilterManger:", Long.valueOf(l2 - l1), "  BeautAndSharp:", Long.valueOf(l3 - l2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.1
 * JD-Core Version:    0.7.0.1
 */