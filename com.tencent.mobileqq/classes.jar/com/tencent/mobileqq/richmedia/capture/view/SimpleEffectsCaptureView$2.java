package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

class SimpleEffectsCaptureView$2
  implements Runnable
{
  SimpleEffectsCaptureView$2(SimpleEffectsCaptureView paramSimpleEffectsCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.j)
    {
      this.this$0.a.surfaceCreate(this.this$0.n, this.this$0.o, this.this$0.getWidth(), this.this$0.getHeight());
      this.this$0.a.surfaceChange(this.this$0.n, this.this$0.o, this.this$0.getWidth(), this.this$0.getHeight());
      this.this$0.a.getBusinessOperation().setEffectMute(SimpleEffectsCaptureView.b(this.this$0));
      this.this$0.j = true;
      if (SimpleEffectsCaptureView.a(this.this$0) != 0) {
        this.this$0.setBeauty(SimpleEffectsCaptureView.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView.2
 * JD-Core Version:    0.7.0.1
 */