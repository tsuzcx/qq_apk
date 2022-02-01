package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SubAccountProxy
  implements ISubAccountSmsLogin
{
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  private static ArrayList<Class<? extends ISubAccountSmsLogin>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ISubAccountSmsLogin jdField_a_of_type_ComTencentMobileqqLoginregisterISubAccountSmsLogin;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(SubAccountSmsLoginImpl.class);
  }
  
  public SubAccountProxy()
  {
    QLog.d("SubAccountProxy", 1, new Object[] { "sClassList size : ", Integer.valueOf(jdField_a_of_type_JavaUtilArrayList.size()) });
    Class localClass = (Class)jdField_a_of_type_JavaUtilArrayList.get(0);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterISubAccountSmsLogin = ((ISubAccountSmsLogin)localClass.newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SubAccountProxy", 1, "ISubAccountSmsLogin newInstance", localException);
    }
  }
  
  public BusinessObserver a(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterISubAccountSmsLogin.a(paramQBaseActivity, paramILoginSmsPageView);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterISubAccountSmsLogin.a(paramQBaseActivity);
  }
  
  public void a(QBaseActivity paramQBaseActivity, SubSmsLoginErrorInfo paramSubSmsLoginErrorInfo, ILoginSmsPageView paramILoginSmsPageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterISubAccountSmsLogin.a(paramQBaseActivity, paramSubSmsLoginErrorInfo, paramILoginSmsPageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubAccountProxy
 * JD-Core Version:    0.7.0.1
 */