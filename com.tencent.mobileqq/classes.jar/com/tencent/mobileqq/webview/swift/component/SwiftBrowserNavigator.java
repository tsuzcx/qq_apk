package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;

public class SwiftBrowserNavigator
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = Uri.parse(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("_wwv");
        bool1 = bool2;
        if (paramString == null) {}
      }
    }
    try
    {
      long l = Long.parseLong(paramString.trim());
      bool1 = bool2;
      if (0L != (0x800 & l)) {
        bool1 = true;
      }
    }
    catch (NumberFormatException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
    return bool1;
    return false;
  }
  
  public boolean a(Intent paramIntent)
  {
    Object localObject = this.a.a();
    String str1 = paramIntent.getStringExtra("url");
    if ((!TextUtils.isEmpty(str1)) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(str1)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser((Activity)localObject)) && (!(localObject instanceof ReadInJoyArticleDetailActivity)) && (!(localObject instanceof PublicAccountAdvertisementActivity)))
    {
      localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putAll(paramIntent.getExtras());
      QRoute.startUri((URIRequest)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserNavigator", 1, "shouldNavigate to  PublicAccountBrowser, url: " + Util.b(str1, new String[0]));
      }
      return false;
    }
    if ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQZoneWithReadInJoyUrl(str1)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser((Activity)localObject)) && (!(localObject instanceof ReadInJoyArticleDetailActivity)) && (!(localObject instanceof PublicAccountAdvertisementActivity)))
    {
      localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putAll(paramIntent.getExtras());
      QRoute.startUri((URIRequest)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserNavigator", 1, "shouldNavigate to  PublicAccountBrowser, url: " + Util.b(str1, new String[0]));
      }
      return false;
    }
    if ((!TextUtils.isEmpty(str1)) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl(str1)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser((Activity)localObject)) && (!(localObject instanceof ReadInJoyArticleDetailActivity)) && (!(localObject instanceof PublicAccountAdvertisementActivity)))
    {
      localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putAll(paramIntent.getExtras());
      QRoute.startUri((URIRequest)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserNavigator", 1, "KanDian URL shouldNavigate to  PublicAccountBrowser, url: " + Util.b(str1, new String[0]));
      }
      return false;
    }
    if (WeatherWebPageHelperKt.a(str1)) {
      try
      {
        if (!paramIntent.getBooleanExtra("is_to_ark", false))
        {
          String str2 = WeatherWebPageHelperKt.a(str1);
          if (!TextUtils.isEmpty(str2))
          {
            WeatherWebPageHelperKt.a((Context)localObject, str2);
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.i("SwiftBrowserNavigator", 1, "weather", localException);
      }
    }
    if ((!TextUtils.isEmpty(str1)) && (localObject.getClass() != SingleTaskQQBrowser.class) && (a(str1)))
    {
      if (AuthorizeConfig.a().d("aio_authorize_config", str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserNavigator", 1, "WebViewSwitchAio canSwitchAIO  url " + str1);
        }
        paramIntent = new Intent(paramIntent);
        paramIntent.setComponent(new ComponentName((Context)localObject, SingleTaskQQBrowser.class));
        paramIntent.setFlags(402653184);
        ((Activity)localObject).startActivity(paramIntent);
        return false;
      }
      QLog.e("SwiftBrowserNavigator", 1, "WebViewSwitchAio want to switchToAIO, but don't have command right. url : " + str1);
    }
    return true;
  }
  
  public boolean b(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator
 * JD-Core Version:    0.7.0.1
 */