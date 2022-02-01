package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.os.Handler;

@TargetApi(16)
class CameraManagerImpl$AFMoveCallbackForward
  implements Camera.AutoFocusMoveCallback
{
  private final Handler a;
  private final CameraManager.CameraAFMoveCallback b;
  private final CameraManager.CameraProxy c;
  
  public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
  {
    this.a.post(new CameraManagerImpl.AFMoveCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.AFMoveCallbackForward
 * JD-Core Version:    0.7.0.1
 */