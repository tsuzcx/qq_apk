package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;

class CameraManagerImpl$PreviewCallbackForward
  implements Camera.PreviewCallback
{
  private static long jdField_a_of_type_Long = 0L;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraPreviewDataCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward
 * JD-Core Version:    0.7.0.1
 */