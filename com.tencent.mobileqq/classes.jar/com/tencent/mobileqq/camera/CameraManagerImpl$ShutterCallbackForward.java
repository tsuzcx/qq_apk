package com.tencent.mobileqq.camera;

import android.hardware.Camera.ShutterCallback;
import android.os.Handler;

class CameraManagerImpl$ShutterCallbackForward
  implements Camera.ShutterCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  private final CameraManager.CameraShutterCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraShutterCallback;
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward
 * JD-Core Version:    0.7.0.1
 */