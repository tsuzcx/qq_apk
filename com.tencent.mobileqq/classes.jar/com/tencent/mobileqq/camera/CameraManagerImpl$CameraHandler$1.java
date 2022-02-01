package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import com.tencent.qphone.base.util.QLog;

class CameraManagerImpl$CameraHandler$1
  implements Runnable
{
  public void run()
  {
    try
    {
      CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl$CameraHandler.a).takePicture(this.jdField_a_of_type_AndroidHardwareCamera$ShutterCallback, this.jdField_a_of_type_AndroidHardwareCamera$PictureCallback, this.b, this.c);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e(CameraManagerImpl.CameraHandler.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl$CameraHandler), 2, "take picture failed.");
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraHandler.1
 * JD-Core Version:    0.7.0.1
 */