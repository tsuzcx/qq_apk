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
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private String jdField_a_of_type_JavaLangString;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver;
  
  private BusinessObserver b(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
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
  
  private SubAccountObserver b(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
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
  
  public BusinessObserver a(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = b(paramQBaseActivity, paramILoginSmsPageView);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  }
  
  public SubAccountObserver a(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    if (this.jdField_a_of_type_MqqObserverSubAccountObserver == null) {
      this.jdField_a_of_type_MqqObserverSubAccountObserver = b(paramQBaseActivity, paramILoginSmsPageView);
    }
    return this.jdField_a_of_type_MqqObserverSubAccountObserver;
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_JavaLangString = paramQBaseActivity.getIntent().getStringExtra("fromWhere");
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
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" mainAccount=");
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" ret=");
      ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.jdField_b_of_type_Int);
      QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject2).toString());
      if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OnGetSubaccountStViaSMSVerifyLogin  errMsg = ");
        ((StringBuilder)localObject2).append(paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getMessage());
        QLog.d("SubAccountSmsLoginImpl", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("logintime", 2, "login end.......");
    }
    int i = paramSubSmsLoginErrorInfo.jdField_b_of_type_Int;
    Object localObject2 = null;
    if (i == 0)
    {
      if ((paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString != null) && (paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString != null) && (paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString.equals(paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString)))
      {
        ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).closePhoneNumActivity((AppRuntime)localObject1);
        paramILoginSmsPageView.a();
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131719319), 0);
        paramQBaseActivity.finish();
        return;
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_FailCode", "12001");
      ((HashMap)localObject2).put("fail_step", "loginsucc");
      ((HashMap)localObject2).put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((AppRuntime)localObject1).getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, (HashMap)localObject2, "");
      SharedPreUtils.a(((AppRuntime)localObject1).getApplication().getApplicationContext(), paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, true);
      ((AppRuntime)localObject1).getSubAccountKey(((AppRuntime)localObject1).getAccount(), paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, a(paramQBaseActivity, paramILoginSmsPageView));
      paramQBaseActivity = (ISubAccountService)((AppRuntime)localObject1).getRuntimeService(ISubAccountService.class, null);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.updateServerError(paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, 0, "");
      }
    }
    else
    {
      paramILoginSmsPageView.a();
      if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == -20160326)
      {
        paramQBaseActivity.finish();
        return;
      }
      if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 2008)
      {
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131692995), 0);
        paramQBaseActivity.finish();
        return;
      }
      Object localObject3;
      if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg != null)
      {
        localObject3 = paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getMessage();
        localObject1 = localObject3;
        if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getType() == 1)
        {
          localObject2 = paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getOtherinfo();
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
        if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 40)
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
        paramILoginSmsPageView.putExtra("loginalias", paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString);
        paramILoginSmsPageView.putExtra("loginret", paramSubSmsLoginErrorInfo.jdField_b_of_type_Int);
        RouteUtils.a(paramQBaseActivity, paramILoginSmsPageView, "/base/notification");
        return;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131718220), 1);
      } else {
        paramILoginSmsPageView.a((String)localObject1, 0);
      }
      if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 155) {
        paramQBaseActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl
 * JD-Core Version:    0.7.0.1
 */