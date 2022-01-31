package com.tencent.mobileqq.richmedia.capture.view;

import avuj;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$8
  implements Runnable
{
  CameraCaptureView$8(CameraCaptureView paramCameraCaptureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (!this.this$0.a.containsKey(avuj.d)) {
      this.this$0.a.put(avuj.d, new RenderBuffer(this.a, this.b, 33984));
    }
    if (!this.this$0.a.containsKey(avuj.e)) {
      this.this$0.a.put(avuj.e, new RenderBuffer(this.this$0.f, this.this$0.g, 33984));
    }
    if (!this.this$0.a.containsKey(avuj.f)) {
      this.this$0.a.put(avuj.f, new RenderBuffer(this.c, this.d, 33984));
    }
    if (!this.this$0.a.containsKey(avuj.g)) {
      this.this$0.a.put(avuj.g, new RenderBuffer(this.this$0.h, this.this$0.i, 33984));
    }
    this.this$0.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.8
 * JD-Core Version:    0.7.0.1
 */