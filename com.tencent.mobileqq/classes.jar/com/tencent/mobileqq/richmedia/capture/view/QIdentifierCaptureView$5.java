package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class QIdentifierCaptureView$5
  implements Runnable
{
  QIdentifierCaptureView$5(QIdentifierCaptureView paramQIdentifierCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFrameAvailable ： ");
      localStringBuilder.append(localException);
      QLog.e("QIdentifierCaptureView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.5
 * JD-Core Version:    0.7.0.1
 */