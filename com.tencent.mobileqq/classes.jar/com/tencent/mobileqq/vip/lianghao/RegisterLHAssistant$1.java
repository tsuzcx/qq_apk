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
    switch (paramMessage.what)
    {
    default: 
    case 104: 
      do
      {
        return;
        paramMessage = (String)paramMessage.obj;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount != null) && (!TextUtils.isEmpty(paramMessage)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.a(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(RegisterLHAssistant.jdField_a_of_type_JavaLangString, 2, "captcha sig is empty");
      return;
    }
    RegisterLHAssistant.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.1
 * JD-Core Version:    0.7.0.1
 */