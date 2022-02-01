package com.tencent.mobileqq.camera;

import android.os.Handler;

class CameraManagerImpl$CameraOpenErrorCallbackForward
  implements CameraManager.CameraOpenErrorCallback
{
  private final Handler a;
  private final CameraManager.CameraOpenErrorCallback b;
  
  public void a(int paramInt)
  {
    this.a.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.1(this, paramInt));
  }
  
  public void a(CameraManager paramCameraManager)
  {
    this.a.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.3(this, paramCameraManager));
  }
  
  public void b(int paramInt)
  {
    this.a.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward
 * JD-Core Version:    0.7.0.1
 */