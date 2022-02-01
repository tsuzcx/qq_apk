package com.tencent.qqcamerakit.preview;

import android.graphics.SurfaceTexture;
import com.tencent.qqcamerakit.common.QLog;

class CameraCaptureView$2
  implements Runnable
{
  CameraCaptureView$2(CameraCaptureView paramCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      synchronized (CameraCaptureView.a(this.this$0))
      {
        this.a.updateTexImage();
        this.this$0.requestRender();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.a("CameraCaptureView", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.CameraCaptureView.2
 * JD-Core Version:    0.7.0.1
 */