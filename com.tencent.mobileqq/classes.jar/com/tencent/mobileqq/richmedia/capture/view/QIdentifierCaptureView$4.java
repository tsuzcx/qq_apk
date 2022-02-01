package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class QIdentifierCaptureView$4
  implements Runnable
{
  QIdentifierCaptureView$4(QIdentifierCaptureView paramQIdentifierCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
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
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFrameAvailable eglHandlerThread init success : ");
      localStringBuilder.append(localException);
      QLog.e("QIdentifierCaptureView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.4
 * JD-Core Version:    0.7.0.1
 */