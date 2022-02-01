package com.tencent.mobileqq.qqgift.webview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;

public class QQGiftCookieManager
{
  private static QQGiftCookieManager a = new QQGiftCookieManager();
  
  public static QQGiftCookieManager a()
  {
    return a;
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
  
  public void a(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext);
    paramContext = CookieManager.getInstance();
    paramContext.setAcceptCookie(true);
    String str = a("qlive.qq.com", 2).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(";Domain=");
    localStringBuilder.append(str);
    localStringBuilder.append(";Path=/;");
    str = localStringBuilder.toString();
    paramContext.setCookie("qlive.qq.com", String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "p_skey", paramString, str }));
    paramContext.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  public String b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGiftCookieManager", 2, "getPsKey");
    }
    Object localObject1 = MobileQQ.sMobileQQ;
    String str = null;
    Object localObject3 = ((MobileQQ)localObject1).waitAppRuntime(null);
    localObject1 = (TicketManager)((AppRuntime)localObject3).getManager(2);
    Object localObject2 = ((AppRuntime)localObject3).getCurrentAccountUin();
    localObject3 = new QQGiftCookieManager.1(this, (AppRuntime)localObject3);
    localObject1 = ((TicketManager)localObject1).getPskey((String)localObject2, 16L, new String[] { "qlive.qq.com" }, (WtTicketPromise)localObject3);
    if (localObject1 != null)
    {
      str = ((Ticket)localObject1).getPSkey("qlive.qq.com");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPsKey pskey:");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", isPskeyExpired:");
      ((StringBuilder)localObject2).append(Ticket.isPskeyExpired(((Long)((Ticket)localObject1)._pskey_expire.get("qlive.qq.com")).longValue()));
      QLog.d("QQGiftCookieManager", 1, ((StringBuilder)localObject2).toString());
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftCookieManager
 * JD-Core Version:    0.7.0.1
 */