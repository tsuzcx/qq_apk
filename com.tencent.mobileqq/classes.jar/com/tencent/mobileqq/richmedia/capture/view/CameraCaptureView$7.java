package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$7
  implements Runnable
{
  CameraCaptureView$7(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.H.containsKey(CameraCaptureView.CaptureParam.k)) {
      this.this$0.H.put(CameraCaptureView.CaptureParam.k, new RenderBuffer(this.this$0.o, this.this$0.p, 33984));
    }
    this.this$0.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.7
 * JD-Core Version:    0.7.0.1
 */