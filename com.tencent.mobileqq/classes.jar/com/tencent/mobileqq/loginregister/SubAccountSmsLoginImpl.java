package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class SubAccountSmsLoginImpl
  implements ISubAccountSmsLogin
{
  private SubAccountObserver a;
  private BusinessObserver b;
  private String c;
  
  private SubAccountObserver c(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (paramQBaseActivity == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "doCreateObserver, activity is null");
      return null;
    }
    AppRuntime localAppRuntime = paramQBaseActivity.getAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "doCreateObserver, appRuntime is null");
      return null;
    }
    return new SubAccountSmsLoginImpl.1(this, localAppRuntime, paramILoginSmsPageView, paramQBaseActivity);
  }
  
  private BusinessObserver d(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (paramQBaseActivity == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "createBindSubAccountObserver, activity is null");
      return null;
    }
    AppRuntime localAppRuntime = paramQBaseActivity.getAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "createBindSubAccountObserver, appRuntime is null");
      return null;
    }
    return new SubAccountSmsLoginImpl.2(this, paramILoginSmsPageView, paramQBaseActivity, localAppRuntime);
  }
  
  public BusinessObserver a(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (this.b == null) {
      this.b = d(paramQBaseActivity, paramILoginSmsPageView);
    }
    return this.b;
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.c = paramQBaseActivity.getIntent().getStringExtra("fromWhere");
  }
  
  public void a(QBaseActivity paramQBaseActivity, SubSmsLoginErrorInfo paramSubSmsLoginErrorInfo, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (paramSubSmsLoginErrorInfo == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, info is null");
      return;
    }
    if (paramQBaseActivity == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, activity is null");
      return;
    }
    Object localObject1 = paramQBaseActivity.getAppRuntime();
    if (localObject1 == null)
    {
      QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, appRuntime is null");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OnGetSubaccountStViaSMSVerifyLogin  userAccount = ");
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.b);
      ((StringBuilder)localObject2).append(" mainAccount=");
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.a);
      ((StringBuilder)localObject2).append(" ret=");
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.f);
      QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject2).toString());
      if (paramSubSmsLoginErrorInfo.g != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OnGetSubaccountStViaSMSVerifyLogin  errMsg = ");
        ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.g.getMessage());
        QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("logintime", 2, "login end.......");
    }
    int i = paramSubSmsLoginErrorInfo.f;
    Object localObject2 = null;
    if (i == 0)
    {
      if ((paramSubSmsLoginErrorInfo.a != null) && (paramSubSmsLoginErrorInfo.b != null) && (paramSubSmsLoginErrorInfo.a.equals(paramSubSmsLoginErrorInfo.b)))
      {
        ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closePhoneNumActivity((AppRuntime)localObject1);
        paramILoginSmsPageView.b();
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131916871), 0);
        paramQBaseActivity.finish();
        return;
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_FailCode", "12001");
      ((HashMap)localObject2).put("fail_step", "loginsucc");
      ((HashMap)localObject2).put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((AppRuntime)localObject1).getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, (HashMap)localObject2, "");
      SharedPreUtils.a(((AppRuntime)localObject1).getApplication().getApplicationContext(), paramSubSmsLoginErrorInfo.b, true);
      ((AppRuntime)localObject1).getSubAccountKey(((AppRuntime)localObject1).getAccount(), paramSubSmsLoginErrorInfo.b, b(paramQBaseActivity, paramILoginSmsPageView));
      paramQBaseActivity = (ISubAccountService)((AppRuntime)localObject1).getRuntimeService(ISubAccountService.class, null);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.updateServerError(paramSubSmsLoginErrorInfo.b, 0, "");
      }
    }
    else
    {
      paramILoginSmsPageView.b();
      if (paramSubSmsLoginErrorInfo.f == -20160326)
      {
        paramQBaseActivity.finish();
        return;
      }
      if (paramSubSmsLoginErrorInfo.f == 2008)
      {
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131890109), 0);
        paramQBaseActivity.finish();
        return;
      }
      Object localObject3;
      if (paramSubSmsLoginErrorInfo.g != null)
      {
        localObject3 = paramSubSmsLoginErrorInfo.g.getMessage();
        localObject1 = localObject3;
        if (paramSubSmsLoginErrorInfo.g.getType() == 1)
        {
          localObject2 = paramSubSmsLoginErrorInfo.g.getOtherinfo();
          localObject1 = localObject3;
        }
      }
      else
      {
        localObject1 = null;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramILoginSmsPageView = new Intent();
        paramILoginSmsPageView.putExtra("type", 8);
        if (paramSubSmsLoginErrorInfo.f == 40)
        {
          paramILoginSmsPageView.putExtra("msg", (String)localObject1);
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append((String)localObject2);
          paramILoginSmsPageView.putExtra("msg", ((StringBuilder)localObject3).toString());
        }
        paramILoginSmsPageView.putExtra("loginalias", paramSubSmsLoginErrorInfo.b);
        paramILoginSmsPageView.putExtra("loginret", paramSubSmsLoginErrorInfo.f);
        RouteUtils.a(paramQBaseActivity, paramILoginSmsPageView, "/base/notification");
        return;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131915702), 1);
      } else {
        paramILoginSmsPageView.a((String)localObject1, 0);
      }
      if (paramSubSmsLoginErrorInfo.f == 155) {
        paramQBaseActivity.finish();
      }
    }
  }
  
  public SubAccountObserver b(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (this.a == null) {
      this.a = c(paramQBaseActivity, paramILoginSmsPageView);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl
 * JD-Core Version:    0.7.0.1
 */