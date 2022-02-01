package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;

class CameraManagerImpl$PictureCallbackForward
  implements Camera.PictureCallback
{
  private final Handler a;
  private final CameraManager.CameraPictureCallback b;
  private final CameraManager.CameraProxy c;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward
 * JD-Core Version:    0.7.0.1
 */