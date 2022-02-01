package com.tencent.qqcamerakit.capture;

class CameraManager$1
  implements CameraProxy.CameraAutoFocusCallBack
{
  CameraManager$1(CameraManager paramCameraManager, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack) {}
  
  public void onAutoFocusCallback(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CameraAutoFocusCallBack.onAutoFocusCallback(paramBoolean);
    if (!paramBoolean) {
      CameraManager.a(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraManager.1
 * JD-Core Version:    0.7.0.1
 */