package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import androidx.annotation.NonNull;
import com.tencent.qqcamerakit.common.QLog;
import java.util.concurrent.Semaphore;

class Camera2Control$2
  extends CameraCaptureSession.StateCallback
{
  Camera2Control$2(Camera2Control paramCamera2Control) {}
  
  public void onConfigureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]startPreview onConfigureFailed!" });
    Camera2Control.c(this.a, false);
    Camera2Control.a(this.a).release();
    if (this.a.a != null) {
      this.a.a.a(3, 42, "[Camera2]onConfigureFailed", new Object[0]);
    }
  }
  
  public void onConfigured(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    QLog.d("Camera2Control", 1, new Object[] { "[Camera2]startPreview onConfigured!" });
    Camera2Control.c(this.a, true);
    Camera2Control.a(this.a, paramCameraCaptureSession);
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
    Camera2Control.a(this.a).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Camera2Control.a(this.a));
    paramCameraCaptureSession = this.a;
    Camera2Control.a(paramCameraCaptureSession, Camera2Control.a(paramCameraCaptureSession).build());
    Camera2Control.a(this.a);
    Camera2Control.a(this.a).release();
    if (this.a.a != null) {
      this.a.a.a(3, 0, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.2
 * JD-Core Version:    0.7.0.1
 */