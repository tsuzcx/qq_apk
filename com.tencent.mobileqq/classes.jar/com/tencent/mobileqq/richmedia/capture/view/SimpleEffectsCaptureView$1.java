package com.tencent.mobileqq.richmedia.capture.view;

import avte;
import avwh;
import com.tencent.qphone.base.util.QLog;

class SimpleEffectsCaptureView$1
  implements Runnable
{
  SimpleEffectsCaptureView$1(SimpleEffectsCaptureView paramSimpleEffectsCaptureView) {}
  
  public void run()
  {
    SimpleEffectsCaptureView.a(this.this$0, avte.b());
    if (SimpleEffectsCaptureView.a(this.this$0) != null) {
      SimpleEffectsCaptureView.a(this.this$0).a(SimpleEffectsCaptureView.a(this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onFirstFrameShownInternal soLoaded=" + SimpleEffectsCaptureView.a(this.this$0));
    }
    this.this$0.y();
    if (SimpleEffectsCaptureView.a(this.this$0) != null) {
      SimpleEffectsCaptureView.a(this.this$0).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView.1
 * JD-Core Version:    0.7.0.1
 */