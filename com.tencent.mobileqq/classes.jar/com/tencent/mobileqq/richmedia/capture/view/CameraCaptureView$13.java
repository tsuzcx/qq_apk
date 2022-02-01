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
    this.a.v = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.w = 90;
    }
    if ((paramInt > 315) || (paramInt < 45)) {
      this.a.w = 90;
    }
    for (;;)
    {
      if (this.a.g) {
        this.a.u = this.a.w;
      }
      com.tencent.mobileqq.richmedia.capture.util.ReportUtil.a = this.a.u;
      return;
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.w = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.w = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.w = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.13
 * JD-Core Version:    0.7.0.1
 */