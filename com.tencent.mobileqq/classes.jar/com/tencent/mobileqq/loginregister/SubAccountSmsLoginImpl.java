package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
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
    Object localObject1 = null;
    if (paramSubSmsLoginErrorInfo == null) {
      QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, info is null");
    }
    do
    {
      return;
      if (paramQBaseActivity == null)
      {
        QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, activity is null");
        return;
      }
      localObject2 = paramQBaseActivity.getAppRuntime();
      if (localObject2 == null)
      {
        QLog.e("SubAccountSmsLoginImpl", 1, "onSunAccountLoginFailed, appRuntime is null");
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SubAccountSmsLoginImpl", 2, "OnGetSubaccountStViaSMSVerifyLogin  userAccount = " + paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString + " mainAccount=" + paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString + " ret=" + paramSubSmsLoginErrorInfo.jdField_b_of_type_Int);
        if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg != null) {
          QLog.d("SubAccountSmsLoginImpl", 2, "OnGetSubaccountStViaSMSVerifyLogin  errMsg = " + paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getMessage());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("logintime", 2, "login end.......");
      }
      if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int != 0) {
        break;
      }
      if ((paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString != null) && (paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString != null) && (paramSubSmsLoginErrorInfo.jdField_a_of_type_JavaLangString.equals(paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString)))
      {
        SubAccountAssistantForward.d((AppRuntime)localObject2);
        paramILoginSmsPageView.a();
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131719600), 0);
        paramQBaseActivity.finish();
        return;
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", "12001");
      ((HashMap)localObject1).put("fail_step", "loginsucc");
      ((HashMap)localObject1).put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((AppRuntime)localObject2).getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, (HashMap)localObject1, "");
      SharedPreUtils.a(((AppRuntime)localObject2).getApplication().getApplicationContext(), paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, true);
      ((AppRuntime)localObject2).getSubAccountKey(((AppRuntime)localObject2).getAccount(), paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, a(paramQBaseActivity, paramILoginSmsPageView));
      paramQBaseActivity = (SubAccountManager)((AppRuntime)localObject2).getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    } while (paramQBaseActivity == null);
    paramQBaseActivity.a(paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString, 0, "");
    return;
    paramILoginSmsPageView.a();
    if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == -20160326)
    {
      paramQBaseActivity.finish();
      return;
    }
    if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 2008)
    {
      paramILoginSmsPageView.a(paramQBaseActivity.getString(2131693035), 0);
      paramQBaseActivity.finish();
      return;
    }
    String str;
    if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg != null)
    {
      str = paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getMessage();
      localObject2 = str;
      if (paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getType() == 1) {
        localObject1 = paramSubSmsLoginErrorInfo.jdField_a_of_type_OicqWlogin_sdkToolsErrMsg.getOtherinfo();
      }
    }
    for (Object localObject2 = str;; localObject2 = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramILoginSmsPageView = new Intent(paramQBaseActivity, NotificationActivity.class);
        paramILoginSmsPageView.putExtra("type", 8);
        if (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 40) {
          paramILoginSmsPageView.putExtra("msg", (String)localObject2);
        }
        for (;;)
        {
          paramILoginSmsPageView.putExtra("loginalias", paramSubSmsLoginErrorInfo.jdField_b_of_type_JavaLangString);
          paramILoginSmsPageView.putExtra("loginret", paramSubSmsLoginErrorInfo.jdField_b_of_type_Int);
          paramQBaseActivity.startActivity(paramILoginSmsPageView);
          return;
          paramILoginSmsPageView.putExtra("msg", (String)localObject2 + " " + (String)localObject1);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramILoginSmsPageView.a(paramQBaseActivity.getString(2131718552), 1);
      }
      while (paramSubSmsLoginErrorInfo.jdField_b_of_type_Int == 155)
      {
        paramQBaseActivity.finish();
        return;
        paramILoginSmsPageView.a((String)localObject2, 0);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl
 * JD-Core Version:    0.7.0.1
 */