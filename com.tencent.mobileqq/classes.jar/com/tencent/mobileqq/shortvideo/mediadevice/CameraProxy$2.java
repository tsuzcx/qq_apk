package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2Listener;

class CameraProxy$2
  implements Camera2Control.Camera2Listener
{
  CameraProxy$2(CameraProxy paramCameraProxy, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      CameraProxy.CameraAutoFocusCallBack localCameraAutoFocusCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraAutoFocusCallBack;
      if (localCameraAutoFocusCallBack != null) {
        localCameraAutoFocusCallBack.a(paramBoolean, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.2
 * JD-Core Version:    0.7.0.1
 */