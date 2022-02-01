package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class CameraCaptureView$13
  extends OrientationEventListener
{
  CameraCaptureView$13(CameraCaptureView paramCameraCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.Q = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.V = 90;
    }
    if ((paramInt <= 315) && (paramInt >= 45))
    {
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.V = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.V = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.V = 0;
      }
    }
    else {
      this.a.V = 90;
    }
    if (this.a.U)
    {
      CameraCaptureView localCameraCaptureView = this.a;
      localCameraCaptureView.P = localCameraCaptureView.V;
    }
    com.tencent.mobileqq.richmedia.capture.util.ReportUtil.c = this.a.P;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.13
 * JD-Core Version:    0.7.0.1
 */