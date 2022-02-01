package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$8
  implements Runnable
{
  CameraCaptureView$8(CameraCaptureView paramCameraCaptureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (!this.this$0.H.containsKey(CameraCaptureView.CaptureParam.l)) {
      this.this$0.H.put(CameraCaptureView.CaptureParam.l, new RenderBuffer(this.a, this.b, 33984));
    }
    if (!this.this$0.H.containsKey(CameraCaptureView.CaptureParam.m)) {
      this.this$0.H.put(CameraCaptureView.CaptureParam.m, new RenderBuffer(this.this$0.g, this.this$0.h, 33984));
    }
    if (!this.this$0.H.containsKey(CameraCaptureView.CaptureParam.n)) {
      this.this$0.H.put(CameraCaptureView.CaptureParam.n, new RenderBuffer(this.c, this.d, 33984));
    }
    if (!this.this$0.H.containsKey(CameraCaptureView.CaptureParam.o)) {
      this.this$0.H.put(CameraCaptureView.CaptureParam.o, new RenderBuffer(this.this$0.i, this.this$0.j, 33984));
    }
    this.this$0.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.8
 * JD-Core Version:    0.7.0.1
 */