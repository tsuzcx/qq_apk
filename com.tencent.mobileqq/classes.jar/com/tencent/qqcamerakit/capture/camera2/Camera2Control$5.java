package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import com.tencent.qqcamerakit.common.QLog;

class Camera2Control$5
  extends CameraCaptureSession.CaptureCallback
{
  Camera2Control$5(Camera2Control paramCamera2Control) {}
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    QLog.c("Camera2Control", 1, new Object[] { "[Camera2]captureStillPicture!" });
    Camera2Control.a(this.a, 0L);
    Camera2Control.d(this.a, false);
    Camera2Control.a(this.a).a(0);
    Camera2Control.b(this.a);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    QLog.c("Camera2Control", 1, new Object[] { "[Camera2]captureStillPicture failed!" });
    Camera2Control.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.5
 * JD-Core Version:    0.7.0.1
 */