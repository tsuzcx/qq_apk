package com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Support;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CameraControl$1
  implements Camera.PictureCallback
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  CameraControl$1(CameraControl paramCameraControl, int paramInt1, long paramLong, File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, boolean paramBoolean, int paramInt2) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i(CameraControl.b, 2, "onJpegTaken");
    }
    NewFlowCameraReporter.a("inner pic taken");
    String str = null;
    try
    {
      paramCamera = paramCamera.getParameters().getPictureSize();
    }
    catch (Exception paramCamera)
    {
      paramCamera.printStackTrace();
      paramCamera = str;
    }
    if (paramCamera == null)
    {
      QLog.e(CameraControl.b, 1, "null picSize");
      return;
    }
    str = CameraControl.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPictureTaken] picSize(");
    localStringBuilder.append(paramCamera.width);
    localStringBuilder.append(",");
    localStringBuilder.append(paramCamera.height);
    localStringBuilder.append(") orientation=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i(str, 1, localStringBuilder.toString());
    if (paramArrayOfByte == null) {
      return;
    }
    Camera2Support.a(1, paramCamera.height * paramCamera.width, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraControl.1.1(this, paramArrayOfByte, paramCamera));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1
 * JD-Core Version:    0.7.0.1
 */