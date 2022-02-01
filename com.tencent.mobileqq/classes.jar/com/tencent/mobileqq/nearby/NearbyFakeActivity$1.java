package com.tencent.mobileqq.nearby;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class NearbyFakeActivity$1
  extends Handler
{
  NearbyFakeActivity$1(NearbyFakeActivity paramNearbyFakeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFakeActivity", 2, "procPreload time out");
      }
      NearbyFakeActivity.a(this.a, 1);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivity.1
 * JD-Core Version:    0.7.0.1
 */