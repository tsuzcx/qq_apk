package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String a = "QCircleHybirdFragment";
  private QCircleHybirdFragment.QCircleHybirdBroadcastReceiver b;
  
  private void c()
  {
    Object localObject1;
    Resources localResources;
    int j;
    int i;
    if (getWebView() != null)
    {
      localObject1 = getUIStyleHandler();
      localResources = getResources();
      boolean bool = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
      j = 2131167018;
      if (bool) {
        i = 2131167018;
      } else {
        i = 2131167017;
      }
      ((SwiftBrowserUIStyleHandler)localObject1).E = localResources.getColor(i);
      getUIStyleHandler().D.setBackgroundColor(getUIStyleHandler().E);
      if (getWebView().getX5WebViewExtension() == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = getWebView().getView();
        localResources = getResources();
        if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
          break label296;
        }
        i = 2131167018;
        ((View)localObject1).setBackgroundColor(localResources.getColor(i));
        localObject1 = getWebView();
        localResources = getResources();
        if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
          break label302;
        }
        i = 2131167018;
        ((CustomWebView)localObject1).setBackgroundColor(localResources.getColor(i));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = getWebView();
      localResources = getResources();
      if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
        i = 2131167018;
      } else {
        i = 2131167017;
      }
      ((CustomWebView)localObject2).setBackgroundColor(localResources.getColor(i));
      if (this.contentView != null)
      {
        localObject2 = this.contentView;
        localResources = getResources();
        if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
          i = j;
        } else {
          i = 2131167017;
        }
        ((WebBrowserViewContainer)localObject2).setBackgroundColor(localResources.getColor(i));
      }
      return;
      label296:
      i = 2131167017;
      continue;
      label302:
      i = 2131167017;
    }
  }
  
  private void d()
  {
    VideoReport.addToDetectionWhitelist(getHostActivity());
    VideoReport.setPageId(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).getQCircleDaTongBasePageId());
    VideoReport.setPageParams(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).buildPageParams(a));
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister  subPage: ");
    localStringBuilder.append(a);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_tag_follow_state");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
    a(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_clear_message_red_poiont");
    localIntent.putExtra("createTime", paramInt);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_auth_info");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("status", paramInt2);
    localIntent.putExtra("tagName", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    Activity localActivity = getHostActivity();
    if (localActivity == null)
    {
      QLog.w(a, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity should not be null.");
      return;
    }
    if (localActivity.isFinishing())
    {
      QLog.w(a, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity is finishing state, not send broadcast.");
      return;
    }
    localActivity.sendBroadcast(paramIntent);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("nick", paramString2);
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("isDoubly", paramInt2);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_refresh_feed_list");
    localIntent.putExtra("pageType", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void doOnBackEvent()
  {
    super.doOnBackEvent();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QCircleHybirdFragment.1(this, this.webViewSurface);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getQBaseActivity() != null) && (this.b != null)) {
      getQBaseActivity().unregisterReceiver(this.b);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */