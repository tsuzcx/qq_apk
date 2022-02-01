package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import androidx.annotation.NonNull;
import com.tencent.qqcamerakit.common.QLog;
import java.util.concurrent.Semaphore;

class Camera2Control$1
  extends CameraDevice.StateCallback
{
  Camera2Control$1(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]openCamera2 onDisconnected!" });
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.c != null) {
      this.b.c.a(1, 3, "onDisconnected", new Object[0]);
    }
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onError, error:");
    localStringBuilder.append(paramInt);
    QLog.a("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.c != null)
    {
      paramCameraDevice = this.b.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError ");
      localStringBuilder.append(paramInt);
      paramCameraDevice.a(1, 3, localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onOpen, cost:");
    localStringBuilder.append(System.currentTimeMillis() - this.a);
    QLog.d("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    Camera2Control.a(this.b, paramCameraDevice);
    Camera2Control.a(this.b, true);
    Camera2Control.b(this.b, false);
    Camera2Control.a(this.b).release();
    if (this.b.c != null) {
      this.b.c.a(1, 0, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.1
 * JD-Core Version:    0.7.0.1
 */