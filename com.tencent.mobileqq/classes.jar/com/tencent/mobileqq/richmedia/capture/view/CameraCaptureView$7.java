package com.tencent.mobileqq.richmedia.capture.view;

import avuj;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$7
  implements Runnable
{
  CameraCaptureView$7(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.a.containsKey(avuj.c)) {
      this.this$0.a.put(avuj.c, new RenderBuffer(this.this$0.n, this.this$0.o, 33984));
    }
    this.this$0.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.7
 * JD-Core Version:    0.7.0.1
 */