package com.tencent.qqcamerakit.capture.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqcamerakit.capture.CameraHandler.TakePictureData;
import com.tencent.qqcamerakit.common.QLog;

class CameraControl$1
  implements Camera.PictureCallback
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  CameraControl$1(CameraControl paramCameraControl, CameraHandler.TakePictureData paramTakePictureData) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.a()) {
      QLog.c(CameraControl.a, 2, new Object[] { "onJpegTaken" });
    }
    Object localObject = null;
    try
    {
      paramCamera = paramCamera.getParameters().getPictureSize();
    }
    catch (Exception paramCamera)
    {
      QLog.a(CameraControl.a, 1, "getPictureSize exception, ", paramCamera);
      paramCamera = localObject;
    }
    if (paramCamera == null)
    {
      QLog.a(CameraControl.a, 1, new Object[] { "null picSize" });
      return;
    }
    QLog.c(CameraControl.a, 1, new Object[] { "[onPictureTaken] picSize(", Integer.valueOf(paramCamera.width), ", ", Integer.valueOf(paramCamera.height), "), orientation = ", Integer.valueOf(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler$TakePictureData.a) });
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraControl.1.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl.1
 * JD-Core Version:    0.7.0.1
 */