package com.tencent.mobileqq.qqlive.verified;

import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.utils.LoginCacheManager;
import com.tencent.mobileqq.qqlive.webview.QQLiveCookieManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.cookie.IBrowserCookieInjector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQLiveBrowserCookieInjector
  implements IBrowserCookieInjector
{
  private LoginCacheManager a;
  
  public List<String> a(String paramString)
  {
    if ("https://qlive.qq.com/".equals(paramString))
    {
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      String str = ((IQQLiveDataStore)QRoute.api(IQQLiveDataStore.class)).getAppId();
      if (this.a == null) {
        this.a = new LoginCacheManager((AppRuntime)localObject, str, ((AppRuntime)localObject).getCurrentUin());
      }
      localObject = this.a.a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[collectBusinessCookies] loginInfo:");
        localStringBuilder.append(localObject);
        QLog.d("QQLiveBrowserCookieInjector", 4, localStringBuilder.toString());
      }
      return QQLiveCookieManager.a(str, (LoginInfo)localObject, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.QQLiveBrowserCookieInjector
 * JD-Core Version:    0.7.0.1
 */