package com.tencent.mobileqq.troopreward;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class OrientationAdapterImageView$1
  extends Handler
{
  OrientationAdapterImageView$1(OrientationAdapterImageView paramOrientationAdapterImageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.d != null) {
      this.a.invalidate();
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("handleMessage:");
      paramMessage.append(this.a.a);
      paramMessage.append(",");
      paramMessage.append(this.a.d);
      QLog.d("OrientationAdapterImageView", 2, paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopreward.OrientationAdapterImageView.1
 * JD-Core Version:    0.7.0.1
 */