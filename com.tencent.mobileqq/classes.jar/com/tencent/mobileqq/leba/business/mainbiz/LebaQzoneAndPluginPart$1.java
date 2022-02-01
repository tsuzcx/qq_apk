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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callback handleMessage,what = ");
    ((StringBuilder)localObject).append(paramMessage.what);
    QLog.i("LebaBusinessPartImpl", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.a();
    if ((localObject != null) && (!"0".equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      switch (paramMessage.what)
      {
      case 1134009: 
      default: 
        return true;
      case 1134010: 
        this.a.r();
        return true;
      case 1134008: 
        this.a.a(paramMessage);
        return true;
      }
      this.a.q();
      return true;
    }
    QLog.i("LebaBusinessPartImpl", 1, "handleMessage app == null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.1
 * JD-Core Version:    0.7.0.1
 */