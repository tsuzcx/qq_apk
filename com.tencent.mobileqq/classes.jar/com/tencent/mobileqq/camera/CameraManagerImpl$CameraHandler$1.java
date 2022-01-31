package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import aoas;
import aoav;
import com.tencent.qphone.base.util.QLog;

public class CameraManagerImpl$CameraHandler$1
  implements Runnable
{
  public void run()
  {
    try
    {
      aoas.a(this.jdField_a_of_type_Aoav.a).takePicture(this.jdField_a_of_type_AndroidHardwareCamera$ShutterCallback, this.jdField_a_of_type_AndroidHardwareCamera$PictureCallback, this.b, this.c);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e(aoav.a(this.jdField_a_of_type_Aoav), 2, "take picture failed.");
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraHandler.1
 * JD-Core Version:    0.7.0.1
 */