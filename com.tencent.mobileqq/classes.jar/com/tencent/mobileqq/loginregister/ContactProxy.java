package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class ContactProxy
  implements IContactInterface
{
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  private static ArrayList<Class<? extends IContactInterface>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private IContactInterface jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(ContactImpl.class);
  }
  
  public ContactProxy()
  {
    QLog.d("ContactProxy", 1, new Object[] { "sLoginActionClasses size : ", Integer.valueOf(jdField_a_of_type_JavaUtilArrayList.size()) });
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface = ((IContactInterface)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ContactProxy", 1, "IContactInterface newInstance", localException);
    }
  }
  
  public BusinessObserver a(IRegisterView paramIRegisterView)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(paramIRegisterView);
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(paramQBaseActivity, paramIntent);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(paramAppRuntime, paramString);
  }
  
  public void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(paramAppRuntime, paramArrayOfByte, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactProxy
 * JD-Core Version:    0.7.0.1
 */