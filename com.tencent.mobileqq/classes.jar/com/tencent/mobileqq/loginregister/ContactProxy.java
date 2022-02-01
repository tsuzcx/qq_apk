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
  private static ArrayList<Class<? extends IContactInterface>> b = new ArrayList();
  protected IContactInterface a;
  
  static
  {
    b.add(ContactImpl.class);
  }
  
  public ContactProxy()
  {
    QLog.d("ContactProxy", 1, new Object[] { "sLoginActionClasses size : ", Integer.valueOf(b.size()) });
    try
    {
      this.a = ((IContactInterface)((Class)b.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ContactProxy", 1, "IContactInterface newInstance", localException);
    }
  }
  
  public BusinessObserver a(IRegisterView paramIRegisterView)
  {
    return this.a.a(paramIRegisterView);
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    this.a.a(paramQBaseActivity, paramIntent);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.a.a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    this.a.a(paramAppRuntime, paramString);
  }
  
  public void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    this.a.a(paramAppRuntime, paramArrayOfByte, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactProxy
 * JD-Core Version:    0.7.0.1
 */