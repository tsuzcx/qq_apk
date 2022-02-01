package com.tencent.mobileqq.leba.business.mainbiz;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$1
  implements Handler.Callback
{
  LebaQzoneAndPluginPart$1(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    QLog.i("LebaBusinessPartImpl", 1, "callback handleMessage,what = " + paramMessage.what);
    QQAppInterface localQQAppInterface = this.a.a();
    if ((localQQAppInterface == null) || ("0".equals(localQQAppInterface.getCurrentAccountUin())))
    {
      QLog.i("LebaBusinessPartImpl", 1, "handleMessage app == null");
      return false;
    }
    switch (paramMessage.what)
    {
    case 1134009: 
    default: 
      return true;
    case 1134007: 
      this.a.q();
      return true;
    case 1134008: 
      this.a.a(paramMessage);
      return true;
    }
    this.a.r();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.1
 * JD-Core Version:    0.7.0.1
 */