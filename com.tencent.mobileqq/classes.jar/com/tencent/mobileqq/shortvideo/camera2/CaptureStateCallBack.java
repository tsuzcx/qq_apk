package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;

@TargetApi(21)
public class CaptureStateCallBack
  extends CameraCaptureSession.CaptureCallback
{
  private Camera2Control a;
  private int b = 0;
  
  public CaptureStateCallBack(Camera2Control paramCamera2Control)
  {
    this.a = paramCamera2Control;
  }
  
  private void a(CaptureResult paramCaptureResult)
  {
    int i = this.b;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      Object localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]process afState:");
      localStringBuilder.append(localObject);
      Camera2Utils.a(1, localStringBuilder.toString());
      if (localObject == null)
      {
        paramCaptureResult = this.a;
        if (paramCaptureResult != null) {
          paramCaptureResult.j();
        }
      }
      else if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()) || (((Integer)localObject).intValue() == 0) || (1 == ((Integer)localObject).intValue()) || (2 == ((Integer)localObject).intValue()))
      {
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult != null) && (paramCaptureResult.intValue() != 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Camera2]process preCapture aeState:");
          ((StringBuilder)localObject).append(paramCaptureResult);
          Camera2Utils.a(1, ((StringBuilder)localObject).toString());
          paramCaptureResult = this.a;
          if (paramCaptureResult != null) {
            paramCaptureResult.j();
          }
        }
        else
        {
          this.b = 4;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Camera2]process aeState:");
          ((StringBuilder)localObject).append(paramCaptureResult);
          Camera2Utils.a(1, ((StringBuilder)localObject).toString());
          paramCaptureResult = this.a;
          if (paramCaptureResult != null) {
            paramCaptureResult.j();
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.CaptureStateCallBack
 * JD-Core Version:    0.7.0.1
 */