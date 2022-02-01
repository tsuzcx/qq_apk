package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.qphone.base.util.QLog;

class CameraProxy$Camera2Handler$1
  implements Camera.AutoFocusCallback
{
  CameraProxy$Camera2Handler$1(CameraProxy.Camera2Handler paramCamera2Handler) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.Camera2Handler.1
 * JD-Core Version:    0.7.0.1
 */