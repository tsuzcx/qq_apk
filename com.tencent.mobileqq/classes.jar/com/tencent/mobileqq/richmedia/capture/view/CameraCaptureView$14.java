package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class CameraCaptureView$14
  implements Runnable
{
  CameraCaptureView$14(CameraCaptureView paramCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      synchronized (this.this$0.a)
      {
        this.a.updateTexImage();
        this.this$0.requestRender();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CameraCaptureView", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.14
 * JD-Core Version:    0.7.0.1
 */