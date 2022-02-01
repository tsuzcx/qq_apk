package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class QIdentifierCaptureView$3
  extends OrientationEventListener
{
  QIdentifierCaptureView$3(QIdentifierCaptureView paramQIdentifierCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.j = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.k = 90;
    }
    if ((paramInt <= 315) && (paramInt >= 45))
    {
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.k = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.k = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.k = 0;
      }
    }
    else {
      this.a.k = 90;
    }
    if (this.a.b)
    {
      QIdentifierCaptureView localQIdentifierCaptureView = this.a;
      localQIdentifierCaptureView.i = localQIdentifierCaptureView.k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.3
 * JD-Core Version:    0.7.0.1
 */