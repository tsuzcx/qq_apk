package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.HandlerThread;
import java.io.IOException;

@TargetApi(9)
public class CameraManagerImpl
  implements CameraManager
{
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private Camera jdField_a_of_type_AndroidHardwareCamera = null;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private CameraManagerImpl.CameraHandler jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl$CameraHandler = null;
  private IOException jdField_a_of_type_JavaIoIOException;
  private boolean jdField_a_of_type_Boolean;
  private Camera.Parameters b = null;
  
  CameraManagerImpl()
  {
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl$CameraHandler == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("CameraThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl$CameraHandler = new CameraManagerImpl.CameraHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl
 * JD-Core Version:    0.7.0.1
 */