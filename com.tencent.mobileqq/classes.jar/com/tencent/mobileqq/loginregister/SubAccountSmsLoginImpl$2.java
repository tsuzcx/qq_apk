package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SubAccountSmsLoginImpl$2
  extends SubAccountBindObserver
{
  SubAccountSmsLoginImpl$2(SubAccountSmsLoginImpl paramSubAccountSmsLoginImpl, ILoginSmsPageView paramILoginSmsPageView, QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime) {}
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a();
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719586), 2);
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      SubAccountAssistantForward.b(this.jdField_a_of_type_MqqAppAppRuntime);
      SubAccountAssistantForward.a(this.jdField_a_of_type_MqqAppAppRuntime);
      SubAccountAssistantForward.c(this.jdField_a_of_type_MqqAppAppRuntime);
      SubAccountAssistantForward.d(this.jdField_a_of_type_MqqAppAppRuntime);
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    for (;;)
    {
      if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel())) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + "...errorType = " + paramSubAccountBackProtocData.jdField_a_of_type_Int);
      }
      return;
      if (paramSubAccountBackProtocData != null) {
        switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719577), 0);
          break;
        case 1002: 
          SubAccountControll.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
          break;
        case 1003: 
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719578), 0);
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719579);
          }
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl.2
 * JD-Core Version:    0.7.0.1
 */