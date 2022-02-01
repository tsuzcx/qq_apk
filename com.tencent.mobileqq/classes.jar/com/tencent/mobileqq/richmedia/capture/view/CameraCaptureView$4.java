package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qphone.base.util.QLog;

class CameraCaptureView$4
  implements CameraProxy.CameraAutoFocusCallBack
{
  CameraCaptureView$4(CameraCaptureView paramCameraCaptureView) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAutoFocusCallback single tap focus ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", camera2:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("CameraCaptureView", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      CameraCaptureView.a(this.a, true);
      return;
    }
    CameraCaptureView.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.4
 * JD-Core Version:    0.7.0.1
 */