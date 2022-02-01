package com.tencent.mobileqq.leba;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Leba$6
  implements Handler.Callback
{
  Leba$6(Leba paramLeba) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callback handleMessage,what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("LebaFrame", 4, localStringBuilder.toString());
    }
    if ((this.a.a != null) && ("0".equals(this.a.a.getAccount()))) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 11340002)
    {
      if (i == 11340005) {
        Leba.a(this.a);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaFrame", 2, "handler refresh leba config");
      }
      this.a.j();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.6
 * JD-Core Version:    0.7.0.1
 */