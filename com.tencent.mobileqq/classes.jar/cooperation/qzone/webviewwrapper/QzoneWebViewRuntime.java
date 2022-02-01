package cooperation.qzone.webviewwrapper;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class QzoneWebViewRuntime
  extends AppInterface
{
  private EntityManagerFactory emFactory;
  
  public QzoneWebViewRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
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
    if (paramString == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.emFactory == null)
      {
        paramString = QQEntityManagerFactoryProxy.a(paramString, super.getEntityManagerFactory());
        paramString.verifyAuthentication();
        this.emFactory = paramString;
      }
      return this.emFactory;
    }
    finally {}
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
    if (localAppRuntime != null) {
      return localAppRuntime.isLogin();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QzoneWebViewPluginManager.getInstance().initApp(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewRuntime
 * JD-Core Version:    0.7.0.1
 */