package com.tencent.mobileqq.vip.lianghao;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class RegisterLHAssistant$1
  extends MqqHandler
{
  RegisterLHAssistant$1(RegisterLHAssistant paramRegisterLHAssistant) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 104)
    {
      if (i != 109) {
        return;
      }
      RegisterLHAssistant.a(this.a).finish();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    if ((this.a.e != null) && (!TextUtils.isEmpty(paramMessage)))
    {
      this.a.e.a(paramMessage);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(RegisterLHAssistant.a, 2, "captcha sig is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.1
 * JD-Core Version:    0.7.0.1
 */