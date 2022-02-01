package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.mobileqq.app.QBaseActivity;
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
  private static final String jdField_a_of_type_JavaLangString = "QCircleHybirdFragment";
  private QCircleHybirdFragment.QCircleHybirdBroadcastReceiver jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver;
  
  private void a()
  {
    Object localObject1;
    Resources localResources;
    int j;
    int i;
    if (getWebView() != null)
    {
      localObject1 = getUIStyleHandler();
      localResources = getResources();
      boolean bool = SubscribeUtils.a();
      j = 2131166281;
      if (bool) {
        i = 2131166281;
      } else {
        i = 2131166280;
      }
      ((SwiftBrowserUIStyleHandler)localObject1).a = localResources.getColor(i);
      getUIStyleHandler().c.setBackgroundColor(getUIStyleHandler().a);
      if (getWebView().getX5WebViewExtension() == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = getWebView().getView();
        localResources = getResources();
        if (!SubscribeUtils.a()) {
          break label246;
        }
        i = 2131166281;
        ((View)localObject1).setBackgroundColor(localResources.getColor(i));
        localObject1 = getWebView();
        localResources = getResources();
        if (!SubscribeUtils.a()) {
          break label252;
        }
        i = 2131166281;
        ((CustomWebView)localObject1).setBackgroundColor(localResources.getColor(i));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = getWebView();
      localResources = getResources();
      if (SubscribeUtils.a()) {
        i = 2131166281;
      } else {
        i = 2131166280;
      }
      ((CustomWebView)localObject2).setBackgroundColor(localResources.getColor(i));
      if (this.contentView != null)
      {
        localObject2 = this.contentView;
        localResources = getResources();
        if (SubscribeUtils.a()) {
          i = j;
        } else {
          i = 2131166280;
        }
        ((WebBrowserViewContainer)localObject2).setBackgroundColor(localResources.getColor(i));
      }
      return;
      label246:
      i = 2131166280;
      continue;
      label252:
      i = 2131166280;
    }
  }
  
  private void b()
  {
    VideoReport.addToDetectionWhitelist(getHostActivity());
    VideoReport.setPageId(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).getQCircleDaTongBasePageId());
    VideoReport.setPageParams(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).buildPageParams(jdField_a_of_type_JavaLangString));
    String str = jdField_a_of_type_JavaLangString;
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister  subPage: ");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    RFLog.i(str, i, localStringBuilder.toString());
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity should not be null.");
      return;
    }
    if (localActivity.isFinishing())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity is finishing state, not send broadcast.");
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
  
  public void a(String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.setAction("action_update_native_tag_follow_state");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(paramString);
    }
    a(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
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
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getQBaseActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver != null)) {
      getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */