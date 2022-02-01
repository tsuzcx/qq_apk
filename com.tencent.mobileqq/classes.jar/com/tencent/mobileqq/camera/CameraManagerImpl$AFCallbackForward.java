package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;

class CameraManagerImpl$AFCallbackForward
  implements Camera.AutoFocusCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraAFCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward
 * JD-Core Version:    0.7.0.1
 */