package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class QIdentifierCaptureView$4
  implements Runnable
{
  QIdentifierCaptureView$4(QIdentifierCaptureView paramQIdentifierCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.a.containsKey(QIdentifierCaptureView.CaptureParam.b)) {
      this.this$0.a.put(QIdentifierCaptureView.CaptureParam.b, new RenderBuffer(this.this$0.f, this.this$0.g, 33984));
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.4
 * JD-Core Version:    0.7.0.1
 */