package com.tencent.mobileqq.camera;

import abpe;
import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.HandlerThread;
import java.io.IOException;

@TargetApi(9)
public class CameraManagerImpl
  implements CameraManager
{
  private abpe jdField_a_of_type_Abpe;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private IOException jdField_a_of_type_JavaIoIOException;
  private boolean jdField_a_of_type_Boolean;
  private Camera.Parameters b;
  
  CameraManagerImpl()
  {
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Abpe == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("CameraThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Abpe = new abpe(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl
 * JD-Core Version:    0.7.0.1
 */