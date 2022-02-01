package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$8
  implements Runnable
{
  CameraCaptureView$8(CameraCaptureView paramCameraCaptureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (!this.this$0.a.containsKey(CameraCaptureView.CaptureParam.d)) {
      this.this$0.a.put(CameraCaptureView.CaptureParam.d, new RenderBuffer(this.a, this.b, 33984));
    }
    if (!this.this$0.a.containsKey(CameraCaptureView.CaptureParam.e)) {
      this.this$0.a.put(CameraCaptureView.CaptureParam.e, new RenderBuffer(this.this$0.f, this.this$0.g, 33984));
    }
    if (!this.this$0.a.containsKey(CameraCaptureView.CaptureParam.f)) {
      this.this$0.a.put(CameraCaptureView.CaptureParam.f, new RenderBuffer(this.c, this.d, 33984));
    }
    if (!this.this$0.a.containsKey(CameraCaptureView.CaptureParam.g)) {
      this.this$0.a.put(CameraCaptureView.CaptureParam.g, new RenderBuffer(this.this$0.h, this.this$0.i, 33984));
    }
    this.this$0.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.8
 * JD-Core Version:    0.7.0.1
 */