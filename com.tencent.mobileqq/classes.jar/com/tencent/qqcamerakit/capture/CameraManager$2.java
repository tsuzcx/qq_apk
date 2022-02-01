package com.tencent.qqcamerakit.capture;

import com.tencent.qqcamerakit.common.QLog;

class CameraManager$2
  implements CameraProxy.CameraAutoFocusCallBack
{
  CameraManager$2(CameraManager paramCameraManager, CameraSize paramCameraSize, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback) {}
  
  public void onAutoFocusCallback(boolean paramBoolean)
  {
    if (QLog.a()) {
      QLog.d("CameraProxy", 2, new Object[] { "onAutoFocusCallback requestFocus when capture, ", Boolean.valueOf(paramBoolean) });
    }
    CameraManager.a(this.e, this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraManager.2
 * JD-Core Version:    0.7.0.1
 */