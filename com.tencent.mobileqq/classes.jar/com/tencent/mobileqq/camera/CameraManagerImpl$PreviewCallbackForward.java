package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;

class CameraManagerImpl$PreviewCallbackForward
  implements Camera.PreviewCallback
{
  private static long d;
  private final Handler a;
  private final CameraManager.CameraPreviewDataCallback b;
  private final CameraManager.CameraProxy c;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward
 * JD-Core Version:    0.7.0.1
 */