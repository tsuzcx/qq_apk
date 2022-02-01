package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;

class CameraManagerImpl$PictureCallbackForward
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraPictureCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPictureCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward
 * JD-Core Version:    0.7.0.1
 */