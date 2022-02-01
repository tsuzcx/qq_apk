package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthDevVerifyProxy
  implements IAuthDevVerifyApi
{
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  private static ArrayList<Class<? extends IAuthDevVerifyApi>> b = new ArrayList();
  protected final List<IAuthDevVerifyApi> a = new ArrayList();
  
  static
  {
    b.add(DevLockSmsImpl.class);
    b.add(FaceSmsVerifyImpl.class);
    b.add(DefaultSmsImpl.class);
  }
  
  public AuthDevVerifyProxy()
  {
    QLog.d("AuthDevVerifyProxy", 1, new Object[] { "sAuthApiList size : ", Integer.valueOf(b.size()) });
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (IAuthDevVerifyApi)((Class)localObject).newInstance();
        this.a.add(localObject);
      }
      catch (Exception localException)
      {
        QLog.e("AuthDevVerifyProxy", 1, "IAuthDevVerifyApi newInstance", localException);
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAuthDevVerifyApi)localIterator.next()).a();
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAuthDevVerifyApi)localIterator.next()).a(paramQBaseActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAuthDevVerifyApi)localIterator.next()).a(paramQBaseActivity, paramICommonSmsView);
    }
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthDevVerifyApi)localIterator.next()).a(paramQBaseActivity, paramICommonSmsView, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAuthDevVerifyApi)localIterator.next()).b();
    }
  }
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthDevVerifyApi)localIterator.next()).b(paramQBaseActivity, paramICommonSmsView)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthDevVerifyApi)localIterator.next()).c(paramQBaseActivity, paramICommonSmsView)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.AuthDevVerifyProxy
 * JD-Core Version:    0.7.0.1
 */