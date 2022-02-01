package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class QIdentifierCaptureView$6
  implements Runnable
{
  QIdentifierCaptureView$6(QIdentifierCaptureView paramQIdentifierCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
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
      QLog.e("QIdentifierCaptureView", 2, "onFrameAvailable eglHandlerThread init success : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.6
 * JD-Core Version:    0.7.0.1
 */