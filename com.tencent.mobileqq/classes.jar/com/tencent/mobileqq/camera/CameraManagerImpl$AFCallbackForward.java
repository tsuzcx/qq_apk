package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;

class CameraManagerImpl$AFCallbackForward
  implements Camera.AutoFocusCallback
{
  private final Handler a;
  private final CameraManager.CameraProxy b;
  private final CameraManager.CameraAFCallback c;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.a.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward
 * JD-Core Version:    0.7.0.1
 */