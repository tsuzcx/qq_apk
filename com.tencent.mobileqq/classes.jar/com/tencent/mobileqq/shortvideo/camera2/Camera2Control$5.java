package com.tencent.mobileqq.shortvideo.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.FocusData;

class Camera2Control$5
  extends CameraCaptureSession.CaptureCallback
{
  Camera2Control$5(Camera2Control paramCamera2Control) {}
  
  private void a(CaptureResult paramCaptureResult, CaptureRequest paramCaptureRequest)
  {
    paramCaptureRequest = paramCaptureRequest.getTag();
    if ((paramCaptureRequest instanceof CameraProxy.FocusData))
    {
      paramCaptureRequest = (CameraProxy.FocusData)paramCaptureRequest;
      if (!paramCaptureRequest.f)
      {
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2] mAfCaptureCallback:");
        localStringBuilder.append(paramCaptureResult);
        Camera2Utils.a(1, localStringBuilder.toString());
        if (paramCaptureResult == null) {
          return;
        }
        if ((4 == paramCaptureResult.intValue()) || (5 == paramCaptureResult.intValue())) {
          a(true, paramCaptureRequest);
        }
        return;
      }
    }
    Camera2Utils.a(1, "[Camera2] mAfCaptureCallback handled!");
    Camera2Control.d(this.a, false);
  }
  
  private void a(boolean paramBoolean, CameraProxy.FocusData paramFocusData)
  {
    Camera2Control.d(this.a, false);
    Camera2Control.b(this.a).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2] mAfCaptureCallback run, success:");
      ((StringBuilder)localObject).append(paramBoolean);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      Camera2Control.b(this.a).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      CameraCaptureSession localCameraCaptureSession = Camera2Control.m(this.a);
      if (this.a.d) {
        localObject = Camera2Control.d(this.a).buildCaptureRequest(Camera2Control.b(this.a));
      } else {
        localObject = Camera2Control.b(this.a).build();
      }
      localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, null, null);
      if ((paramFocusData.e.b != null) && (!paramFocusData.f))
      {
        paramFocusData.f = true;
        paramFocusData.e.b.a(1, paramBoolean);
        return;
      }
    }
    catch (Exception paramFocusData)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2] mAfCaptureCallback e:");
      ((StringBuilder)localObject).append(paramFocusData);
      Camera2Utils.a(2, ((StringBuilder)localObject).toString());
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
    Camera2Utils.a(2, paramCameraCaptureSession.toString());
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if ((paramCameraCaptureSession instanceof CameraProxy.FocusData))
    {
      paramCameraCaptureSession = (CameraProxy.FocusData)paramCameraCaptureSession;
      if (!paramCameraCaptureSession.f)
      {
        a(false, paramCameraCaptureSession);
        return;
      }
    }
    Camera2Utils.a(1, "[Camera2] mAfCaptureCallback handled!");
    Camera2Control.d(this.a, false);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult, paramCaptureRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.5
 * JD-Core Version:    0.7.0.1
 */