package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams;
import com.tencent.qqcamerakit.common.QLog;

class Camera2Control$6
  extends CameraCaptureSession.CaptureCallback
{
  Camera2Control$6(Camera2Control paramCamera2Control) {}
  
  private void a(CaptureResult paramCaptureResult, CaptureRequest paramCaptureRequest)
  {
    paramCaptureRequest = paramCaptureRequest.getTag();
    if ((paramCaptureRequest instanceof FocusOperator.CameraFocusParams))
    {
      paramCaptureRequest = (FocusOperator.CameraFocusParams)paramCaptureRequest;
      if (!paramCaptureRequest.j)
      {
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2] mAfCaptureCallback:");
        localStringBuilder.append(paramCaptureResult);
        QLog.a("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
        if (paramCaptureResult == null) {
          return;
        }
        if ((4 == paramCaptureResult.intValue()) || (5 == paramCaptureResult.intValue())) {
          a(true, paramCaptureRequest);
        }
        return;
      }
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] mAfCaptureCallback handled!" });
    Camera2Control.e(this.a, false);
  }
  
  private void a(boolean paramBoolean, FocusOperator.CameraFocusParams paramCameraFocusParams)
  {
    Camera2Control.e(this.a, false);
    Camera2Control.c(this.a).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try
    {
      if (QLog.a())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2] mAfCaptureCallback run, success:");
        localStringBuilder.append(paramBoolean);
        QLog.d("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      Camera2Control.c(this.a).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      Camera2Control.j(this.a).setRepeatingRequest(Camera2Control.c(this.a).build(), null, null);
      if ((paramCameraFocusParams.g != null) && (!paramCameraFocusParams.j))
      {
        paramCameraFocusParams.j = true;
        paramCameraFocusParams.g.onAutoFocusCallback(paramBoolean);
        return;
      }
    }
    catch (Exception paramCameraFocusParams)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] mAfCaptureCallback e:");
      localStringBuilder.append(paramCameraFocusParams);
      QLog.a("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    }
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult, paramCaptureRequest);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    paramCameraCaptureSession = new StringBuilder();
    paramCameraCaptureSession.append("[Camera2] mAfCaptureCallback failure reason:");
    paramCameraCaptureSession.append(paramCaptureFailure.getReason());
    QLog.a("Camera2Control", 1, new Object[] { paramCameraCaptureSession.toString() });
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if ((paramCameraCaptureSession instanceof FocusOperator.CameraFocusParams))
    {
      paramCameraCaptureSession = (FocusOperator.CameraFocusParams)paramCameraCaptureSession;
      if (!paramCameraCaptureSession.j)
      {
        a(false, paramCameraCaptureSession);
        return;
      }
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] mAfCaptureCallback handled!" });
    Camera2Control.e(this.a, false);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult, paramCaptureRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.6
 * JD-Core Version:    0.7.0.1
 */