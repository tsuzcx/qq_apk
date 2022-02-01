package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class QIdentifierCaptureView$7
  implements Runnable
{
  QIdentifierCaptureView$7(QIdentifierCaptureView paramQIdentifierCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      this.a.updateTexImage();
      this.this$0.requestRender();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QIdentifierCaptureView", 2, "onFrameAvailable ： " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.7
 * JD-Core Version:    0.7.0.1
 */