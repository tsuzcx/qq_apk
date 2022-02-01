package com.tencent.mobileqq.camera;

import android.hardware.Camera.ShutterCallback;
import android.os.Handler;

class CameraManagerImpl$ShutterCallbackForward
  implements Camera.ShutterCallback
{
  private final Handler a;
  private final CameraManager.CameraShutterCallback b;
  private final CameraManager.CameraProxy c;
  
  public void onShutter()
  {
    this.a.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward
 * JD-Core Version:    0.7.0.1
 */