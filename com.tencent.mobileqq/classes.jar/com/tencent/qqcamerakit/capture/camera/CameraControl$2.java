package com.tencent.qqcamerakit.capture.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.common.QLog;

class CameraControl$2
  implements Camera.AutoFocusCallback
{
  CameraControl$2(CameraControl paramCameraControl, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.a()) {
      QLog.c(CameraControl.a, 2, new Object[] { "Request Focus onAutoFocus, ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CameraAutoFocusCallBack.onAutoFocusCallback(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl.2
 * JD-Core Version:    0.7.0.1
 */