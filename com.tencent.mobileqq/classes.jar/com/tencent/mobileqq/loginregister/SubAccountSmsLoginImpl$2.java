package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SubAccountSmsLoginImpl$2
  extends SubAccountBindObserver
{
  SubAccountSmsLoginImpl$2(SubAccountSmsLoginImpl paramSubAccountSmsLoginImpl, ILoginSmsPageView paramILoginSmsPageView, QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LoginVerifyCodeActivity.onBindSubAccount() isSucc=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      if (paramSubAccountBackProtocData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LoginVerifyCodeActivity.onBindSubAccount() mainAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        ((StringBuilder)localObject).append(" subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append(" errType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719305), 2);
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubAccountBindActivity(this.jdField_a_of_type_MqqAppAppRuntime);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubAccountUgActivity(this.jdField_a_of_type_MqqAppAppRuntime);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubLoginActivity(this.jdField_a_of_type_MqqAppAppRuntime);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closePhoneNumActivity(this.jdField_a_of_type_MqqAppAppRuntime);
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    else if (paramSubAccountBackProtocData != null)
    {
      switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719296), 0);
        break;
      case 1004: 
        String str = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719298);
        }
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a((String)localObject, 0);
        break;
      case 1003: 
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719297), 0);
        break;
      case 1002: 
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).showMaxHintDialog(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      }
    }
    if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("...errorType = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
      QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl.2
 * JD-Core Version:    0.7.0.1
 */