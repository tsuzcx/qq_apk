package com.tencent.mobileqq.shortvideo.camera2;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.support.annotation.NonNull;
import java.util.concurrent.Semaphore;

class Camera2Control$1
  extends CameraDevice.StateCallback
{
  Camera2Control$1(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    Camera2Utils.a(2, "[Camera2]openCamera2 onDisconnected!");
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.b != null) {
      this.b.b.a(-105);
    }
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onError, error:");
    localStringBuilder.append(paramInt);
    Camera2Utils.a(2, localStringBuilder.toString());
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.b != null) {
      this.b.b.a(-102);
    }
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onOpen, cost:");
    localStringBuilder.append(System.currentTimeMillis() - this.a);
    Camera2Utils.a(1, localStringBuilder.toString());
    Camera2Control.a(this.b, paramCameraDevice);
    Camera2Control.a(this.b, true);
    Camera2Control.b(this.b, false);
    Camera2Control.a(this.b).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.1
 * JD-Core Version:    0.7.0.1
 */