package com.tencent.mobileqq.shortvideo.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;

class Camera2Control$6
  extends CameraCaptureSession.CaptureCallback
{
  Camera2Control$6(Camera2Control paramCamera2Control) {}
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    Camera2Utils.a(1, "[Camera2]captureStillPicture completed!");
    Camera2Control.a(this.a, 0L);
    Camera2Control.e(this.a, false);
    Camera2Control.a(this.a).a(0);
    Camera2Control.b(this.a);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    Camera2Utils.a(1, "[Camera2]captureStillPicture failed!");
    Camera2Control.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.6
 * JD-Core Version:    0.7.0.1
 */