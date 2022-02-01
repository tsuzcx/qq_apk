package com.tencent.mobileqq.identification;

import android.hardware.Camera;
import com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraProxyCallBack;

class IdentificationCamera$1
  implements CameraProxy.CameraProxyCallBack
{
  IdentificationCamera$1(IdentificationCamera paramIdentificationCamera, OutPreviewCallback paramOutPreviewCallback) {}
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    OutPreviewCallback localOutPreviewCallback = this.a;
    if (localOutPreviewCallback != null) {
      localOutPreviewCallback.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    CameraControl.a().a(true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationCamera.1
 * JD-Core Version:    0.7.0.1
 */