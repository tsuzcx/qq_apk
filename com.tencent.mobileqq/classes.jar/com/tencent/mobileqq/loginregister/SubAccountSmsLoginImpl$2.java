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
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append(" subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.d);
        ((StringBuilder)localObject).append(" errType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.a);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.a.b();
    if (paramBoolean)
    {
      this.a.a(this.b.getString(2131916857), 2);
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubAccountBindActivity(this.c);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubAccountUgActivity(this.c);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closeSubLoginActivity(this.c);
      ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closePhoneNumActivity(this.c);
      localObject = new Intent(this.b, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject).setFlags(67108864);
      this.b.startActivity((Intent)localObject);
      this.b.finish();
    }
    else if (paramSubAccountBackProtocData != null)
    {
      switch (paramSubAccountBackProtocData.a)
      {
      default: 
        this.a.a(this.b.getString(2131916848), 0);
        break;
      case 1004: 
        String str = paramSubAccountBackProtocData.b;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.b.getString(2131916850);
        }
        this.a.a((String)localObject, 0);
        break;
      case 1003: 
        this.a.a(this.b.getString(2131916849), 0);
        break;
      case 1002: 
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).showMaxHintDialog(this.c, this.b);
      }
    }
    if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
      ((StringBuilder)localObject).append("...errorType = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.a);
      QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl.2
 * JD-Core Version:    0.7.0.1
 */