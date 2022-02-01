package com.tencent.mobileqq.webview.swift.component.navigate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.webview.swift.INavigationProcess;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountNavigationItem
  implements INavigationProcess
{
  public boolean a(Intent paramIntent, Activity paramActivity, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(paramString)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(paramActivity)) && (!((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).isReadInJoyArticleDetailActivity(paramActivity)) && (!(paramActivity instanceof PublicAccountAdvertisementActivity)))
    {
      paramActivity = new ActivityURIRequest(paramActivity, "/pubaccount/browser");
      paramActivity.extra().putAll(paramIntent.getExtras());
      QRoute.startUri(paramActivity, null);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("shouldNavigate to  PublicAccountBrowser, url: ");
        paramIntent.append(Util.b(paramString, new String[0]));
        QLog.d("PublicAccountNavigationItem", 1, paramIntent.toString());
      }
      return true;
    }
    if ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQZoneWithReadInJoyUrl(paramString)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(paramActivity)) && (!((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).isReadInJoyArticleDetailActivity(paramActivity)) && (!(paramActivity instanceof PublicAccountAdvertisementActivity)))
    {
      paramActivity = new ActivityURIRequest(paramActivity, "/pubaccount/browser");
      paramActivity.extra().putAll(paramIntent.getExtras());
      QRoute.startUri(paramActivity, null);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("shouldNavigate to  PublicAccountBrowser, url: ");
        paramIntent.append(Util.b(paramString, new String[0]));
        QLog.d("PublicAccountNavigationItem", 1, paramIntent.toString());
      }
      return true;
    }
    if ((!TextUtils.isEmpty(paramString)) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl(paramString)) && (!((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(paramActivity)) && (!((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).isReadInJoyArticleDetailActivity(paramActivity)) && (!(paramActivity instanceof PublicAccountAdvertisementActivity)))
    {
      paramActivity = new ActivityURIRequest(paramActivity, "/pubaccount/browser");
      paramActivity.extra().putAll(paramIntent.getExtras());
      QRoute.startUri(paramActivity, null);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("KanDian URL shouldNavigate to  PublicAccountBrowser, url: ");
        paramIntent.append(Util.b(paramString, new String[0]));
        QLog.d("PublicAccountNavigationItem", 1, paramIntent.toString());
      }
      return true;
    }
    return false;
  }
  
  public boolean b(Intent paramIntent, Activity paramActivity, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.navigate.PublicAccountNavigationItem
 * JD-Core Version:    0.7.0.1
 */