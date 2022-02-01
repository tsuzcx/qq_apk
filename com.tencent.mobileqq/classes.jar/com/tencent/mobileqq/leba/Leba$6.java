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
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaFrame", 4, "callback handleMessage,what = " + paramMessage.what);
    }
    if ((this.a.a != null) && ("0".equals(this.a.a.getAccount()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("LebaFrame", 2, "handler refresh leba config");
      }
      this.a.g();
      continue;
      Leba.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.6
 * JD-Core Version:    0.7.0.1
 */