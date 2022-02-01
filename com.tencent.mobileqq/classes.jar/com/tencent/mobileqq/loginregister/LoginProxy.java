package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LoginProxy
  implements ILoginAction, ILoginResult
{
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  private static ArrayList<Class<? extends ILoginAction>> a = new ArrayList();
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  private static ArrayList<Class<? extends ILoginResult>> b;
  private List<ILoginAction> c = new ArrayList();
  private List<ILoginResult> d = new ArrayList();
  
  static
  {
    a.add(QCircleLoginAction.class);
    a.add(AlbumLoginAction.class);
    a.add(QZoneLoginAction.class);
    a.add(NotifyLoginAction.class);
    a.add(OpenSdkLoginAction.class);
    a.add(CheckAuthLoginAction.class);
    a.add(UpdateLoginAction.class);
    a.add(MessageLoginAction.class);
    a.add(KandianLoginAction.class);
    a.add(AlphaLoginAction.class);
    b = new ArrayList();
    b.add(AccountLoginResult.class);
    b.add(MiniLoginResult.class);
    b.add(JumpLoginResult.class);
    b.add(InitLoginResult.class);
    b.add(PatternLockResult.class);
    b.add(MessageLoginResult.class);
    b.add(DefaultLogoutResult.class);
  }
  
  public LoginProxy()
  {
    QLog.d("LoginProxy", 1, new Object[] { "sLoginActionClasses size : ", Integer.valueOf(a.size()) });
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Class)localIterator.next();
      try
      {
        localObject1 = (ILoginAction)((Class)localObject1).newInstance();
        this.c.add(localObject1);
      }
      catch (Exception localException1)
      {
        QLog.e("LoginProxy", 1, "ILoginAction newInstance", localException1);
      }
    }
    QLog.d("LoginProxy", 1, new Object[] { "sLoginResultClasses size : ", Integer.valueOf(b.size()) });
    localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Class)localIterator.next();
      try
      {
        localObject2 = (ILoginResult)((Class)localObject2).newInstance();
        this.d.add(localObject2);
      }
      catch (Exception localException2)
      {
        QLog.e("LoginProxy", 1, "ILoginResult newInstance", localException2);
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a();
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramActivity, paramBundle);
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((ILoginResult)localIterator.next()).a(paramActivity, paramString);
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((ILoginResult)localIterator.next()).a(paramActivity, paramAppRuntime);
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((ILoginResult)localIterator.next()).a(paramActivity, paramAppRuntime, paramString);
    }
  }
  
  public void a(Context paramContext)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramContext);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramQBaseActivity, paramInt);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramQBaseActivity, paramBundle);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramQBaseActivity, paramString, paramBoolean);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime, LoginErrorInfo paramLoginErrorInfo)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramQBaseActivity, paramAppRuntime, paramLoginErrorInfo);
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ILoginAction)localIterator.next()).a(paramString);
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    Iterator localIterator = this.d.iterator();
    boolean bool = true;
    while (localIterator.hasNext()) {
      bool &= ((ILoginResult)localIterator.next()).a(paramAppRuntime, paramActivity, paramString);
    }
    return bool;
  }
  
  public boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((ILoginAction)localIterator.next()).a(paramAppRuntime, paramClass, paramLong);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.LoginProxy
 * JD-Core Version:    0.7.0.1
 */