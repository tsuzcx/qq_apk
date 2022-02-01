package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class QIdentifierCaptureView$2
  implements Runnable
{
  QIdentifierCaptureView$2(QIdentifierCaptureView paramQIdentifierCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.n.containsKey(CaptureParam.g)) {
      this.this$0.n.put(CaptureParam.g, new RenderBuffer(this.this$0.e, this.this$0.f, 33984));
    }
    QIdentifierCaptureView.a(this.this$0).a(this.this$0.f, this.this$0.e, this.this$0.getFocusSurfaceWidth(), this.this$0.getFocusSurfaceHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.2
 * JD-Core Version:    0.7.0.1
 */