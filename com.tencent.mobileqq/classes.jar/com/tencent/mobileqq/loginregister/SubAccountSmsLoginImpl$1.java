package com.tencent.mobileqq.loginregister;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.observer.SubAccountObserver;

class SubAccountSmsLoginImpl$1
  extends SubAccountObserver
{
  SubAccountSmsLoginImpl$1(SubAccountSmsLoginImpl paramSubAccountSmsLoginImpl, AppRuntime paramAppRuntime, ILoginSmsPageView paramILoginSmsPageView, QBaseActivity paramQBaseActivity) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountSmsLoginImpl", 2, "onGetKeyBack: mainAccount=" + paramString1 + " subAccount=" + paramString2);
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a();
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onGetKeyBack:subLogin ...has Failed key  =  null");
      }
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterILoginSmsPageView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719626), 0);
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "onGetKeyBack: key not null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountSmsLoginImpl", 2, "subaccount onGetKeyBack goto bind");
      }
      paramString1 = (SubAccountProtocManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_SUB_ACNT);
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, SubAccountSmsLoginImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountSmsLoginImpl));
      }
    } while (!QLog.isColorLevel());
    QLog.d("SubAccountSmsLoginImpl", 2, "onGetKeyBack: success .........");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountSmsLoginImpl.1
 * JD-Core Version:    0.7.0.1
 */