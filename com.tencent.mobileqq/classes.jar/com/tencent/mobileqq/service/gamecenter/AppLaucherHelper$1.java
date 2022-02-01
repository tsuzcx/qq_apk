package com.tencent.mobileqq.service.gamecenter;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class AppLaucherHelper$1
  extends Handler
{
  AppLaucherHelper$1(AppLaucherHelper paramAppLaucherHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
    {
      AppLaucherHelper.a = false;
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper.1
 * JD-Core Version:    0.7.0.1
 */