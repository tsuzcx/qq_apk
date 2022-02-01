package com.tencent.qqcamerakit.capture;

class CameraManager$1
  implements CameraProxy.CameraAutoFocusCallBack
{
  CameraManager$1(CameraManager paramCameraManager, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack) {}
  
  public void onAutoFocusCallback(boolean paramBoolean)
  {
    this.a.onAutoFocusCallback(paramBoolean);
    if (!paramBoolean) {
      CameraManager.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraManager.1
 * JD-Core Version:    0.7.0.1
 */