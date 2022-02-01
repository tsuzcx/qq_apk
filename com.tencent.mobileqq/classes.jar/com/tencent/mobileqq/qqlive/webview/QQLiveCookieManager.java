package com.tencent.mobileqq.qqlive.webview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.utils.LoginCacheManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQLiveCookieManager
{
  private static QQLiveCookieManager b = new QQLiveCookieManager();
  LoginCacheManager a;
  
  public static QQLiveCookieManager a()
  {
    return b;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      if (paramString.startsWith("*.")) {
        return paramString.substring(1);
      }
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString.isHierarchical())
        {
          paramString = paramString.getHost();
          if (paramString != null)
          {
            paramString = paramString.split("\\.");
            if (paramString.length > 0)
            {
              paramInt = Math.max(0, paramString.length - (paramInt + 1));
              StringBuilder localStringBuilder = new StringBuilder(256);
              localStringBuilder.append(paramString[paramInt]);
              paramInt += 1;
              while (paramInt < paramString.length)
              {
                localStringBuilder.append('.');
                localStringBuilder.append(paramString[paramInt]);
                paramInt += 1;
              }
              paramString = localStringBuilder.toString();
              return paramString;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public static List<String> a(String paramString1, LoginInfo paramLoginInfo, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramString1, paramLoginInfo, paramString2));
    localArrayList.addAll(b(paramString1, paramLoginInfo, "https://ilive.qq.com/"));
    localArrayList.addAll(b(paramString1, paramLoginInfo, "https://qlive.qq.com/"));
    localArrayList.addAll(b(paramString1, paramLoginInfo, "*.qlive.qq.com"));
    return localArrayList;
  }
  
  public static List<String> b(String paramString1, LoginInfo paramLoginInfo, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString2 = a(paramString2, 2).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(";Domain=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(";Path=/;");
    paramString2 = localStringBuilder.toString();
    if (!TextUtils.isEmpty(paramLoginInfo.a2))
    {
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qq_live_app_id", paramString1, paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_type", Integer.valueOf(paramLoginInfo.clientType), paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_uin", Long.valueOf(paramLoginInfo.uid), paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(paramLoginInfo.tinyid), paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", paramLoginInfo.a2, paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uid_type", Integer.valueOf(paramLoginInfo.loginType), paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramLoginInfo.accessToken, paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramLoginInfo.openId, paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), paramString2 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), paramString2 }));
    }
    return localArrayList;
  }
  
  private void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      CookieSyncManager.createInstance(paramContext);
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramContext = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramContext = ((IQQLiveDataStore)QRoute.api(IQQLiveDataStore.class)).getAppId();
      }
      if ((this.a == null) && (localAppRuntime != null)) {
        this.a = new LoginCacheManager(localAppRuntime, paramContext, localAppRuntime.getCurrentUin());
      }
      paramContext = b(paramContext, this.a.a(), paramString2).iterator();
      while (paramContext.hasNext()) {
        localCookieManager.setCookie(paramString2, (String)paramContext.next());
      }
      localCookieManager.removeExpiredCookie();
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("plant throw exception:");
      paramString1.append(paramContext.getMessage());
      QLog.e("QQLiveCookieManager", 1, paramString1.toString());
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    b(paramContext, paramString, "https://ilive.qq.com/");
    b(paramContext, paramString, "https://qlive.qq.com/");
    b(paramContext, paramString, "*.qlive.qq.com");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2);
    a(paramContext, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.webview.QQLiveCookieManager
 * JD-Core Version:    0.7.0.1
 */