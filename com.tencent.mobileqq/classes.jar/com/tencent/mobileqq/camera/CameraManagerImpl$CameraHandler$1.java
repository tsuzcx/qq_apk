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
      CameraManagerImpl.a(this.e.a).takePicture(this.a, this.b, this.c, this.d);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e(CameraManagerImpl.CameraHandler.a(this.e), 2, "take picture failed.");
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraHandler.1
 * JD-Core Version:    0.7.0.1
 */