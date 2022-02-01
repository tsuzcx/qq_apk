package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

public class cookieUtils
{
  public static void setCookie(Context paramContext, String paramString)
  {
    Object localObject = SwiftBrowserCookieMonster.c(paramString).replace(" ", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (Build.VERSION.SDK_INT < 21) {
        CookieSyncManager.createInstance(paramContext);
      }
      paramContext = CookieManager.getInstance();
      paramContext.setAcceptCookie(true);
      paramContext.removeSessionCookie();
      paramContext.removeAllCookie();
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        paramContext.setCookie(Uri.parse(paramString).getHost(), str);
        i += 1;
      }
      CookieSyncManager.getInstance().sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.cookieUtils
 * JD-Core Version:    0.7.0.1
 */