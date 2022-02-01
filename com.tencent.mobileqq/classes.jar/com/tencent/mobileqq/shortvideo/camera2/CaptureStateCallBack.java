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
  private int jdField_a_of_type_Int = 0;
  private Camera2Control jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  
  public CaptureStateCallBack(Camera2Control paramCamera2Control)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control = paramCamera2Control;
  }
  
  private void a(CaptureResult paramCaptureResult)
  {
    int i = this.jdField_a_of_type_Int;
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
        paramCaptureResult = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
        if (paramCaptureResult != null) {
          paramCaptureResult.d();
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
          paramCaptureResult = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
          if (paramCaptureResult != null) {
            paramCaptureResult.d();
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 4;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Camera2]process aeState:");
          ((StringBuilder)localObject).append(paramCaptureResult);
          Camera2Utils.a(1, ((StringBuilder)localObject).toString());
          paramCaptureResult = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
          if (paramCaptureResult != null) {
            paramCaptureResult.d();
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.CaptureStateCallBack
 * JD-Core Version:    0.7.0.1
 */