package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class LiteLiveSdkWebViewRuntime
  extends AppInterface
{
  private EntityManagerFactory a;
  
  public LiteLiveSdkWebViewRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public String getAccount()
  {
    return getCurrentAccountUin();
  }
  
  public BaseApplication getApp()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public MobileQQ getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public String getCurrentAccountUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    paramString = getAccount();
    if (paramString != null) {
      try
      {
        if (this.a == null)
        {
          paramString = QQEntityManagerFactoryProxy.a(paramString, super.getEntityManagerFactory());
          paramString.verifyAuthentication();
          this.a = paramString;
        }
        return this.a;
      }
      finally {}
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public Manager getManager(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getManager(paramInt);
    }
    return null;
  }
  
  public boolean isLogin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return (localAppRuntime != null) && (localAppRuntime.isLogin());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LiteLiveSdkWebViewPluginManager.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewRuntime
 * JD-Core Version:    0.7.0.1
 */