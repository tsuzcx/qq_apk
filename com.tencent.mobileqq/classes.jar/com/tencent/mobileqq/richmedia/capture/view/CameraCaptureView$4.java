package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qphone.base.util.QLog;

class CameraCaptureView$4
  implements CameraProxy.CameraAutoFocusCallBack
{
  CameraCaptureView$4(CameraCaptureView paramCameraCaptureView) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAutoFocusCallback single tap focus " + paramBoolean1 + ", camera2:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      CameraCaptureView.a(this.a, true);
      return;
    }
    CameraCaptureView.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.4
 * JD-Core Version:    0.7.0.1
 */