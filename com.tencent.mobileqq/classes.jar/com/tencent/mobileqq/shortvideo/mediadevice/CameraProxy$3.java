package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class CameraProxy$3
  implements Camera.AutoFocusCallback
{
  CameraProxy$3(CameraProxy paramCameraProxy, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraAutoFocusCallBack.onAutoFocusCallback(paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */