package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String jdField_a_of_type_JavaLangString = QCircleHybirdFragment.class.getSimpleName();
  private QCircleHybirdFragment.QCircleHybirdBroadcastReceiver jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver;
  
  private void a()
  {
    int j = 2131166270;
    Object localObject;
    Resources localResources;
    if (getWebView() != null)
    {
      localObject = this.mUIStyleHandler;
      localResources = getResources();
      if (!SubscribeUtils.a()) {
        break label167;
      }
      i = 2131166270;
      ((SwiftBrowserUIStyleHandler)localObject).jdField_a_of_type_Int = localResources.getColor(i);
      this.mUIStyleHandler.c.setBackgroundColor(this.mUIStyleHandler.jdField_a_of_type_Int);
      if (getWebView().getX5WebViewExtension() == null) {
        break label193;
      }
    }
    try
    {
      localObject = getWebView().getView();
      localResources = getResources();
      if (!SubscribeUtils.a()) {
        break label173;
      }
      i = 2131166270;
      label90:
      ((View)localObject).setBackgroundColor(localResources.getColor(i));
      localObject = getWebView();
      localResources = getResources();
      if (!SubscribeUtils.a()) {
        break label179;
      }
      i = 2131166270;
      label120:
      ((CustomWebView)localObject).setBackgroundColor(localResources.getColor(i));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (this.contentView != null)
    {
      localObject = this.contentView;
      localResources = getResources();
      if (!SubscribeUtils.a()) {
        break label232;
      }
    }
    label167:
    label173:
    label179:
    label193:
    label232:
    for (int i = j;; i = 2131166269)
    {
      ((WebBrowserViewContainer)localObject).setBackgroundColor(localResources.getColor(i));
      return;
      i = 2131166269;
      break;
      i = 2131166269;
      break label90;
      i = 2131166269;
      break label120;
      CustomWebView localCustomWebView = getWebView();
      localResources = getResources();
      if (SubscribeUtils.a()) {}
      for (i = 2131166270;; i = 2131166269)
      {
        localCustomWebView.setBackgroundColor(localResources.getColor(i));
        break;
      }
    }
  }
  
  private void b()
  {
    VideoReport.addToDetectionWhitelist(getHostActivity());
    VideoReport.setPageId(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).getQCircleDaTongConstantPageId());
    VideoReport.setPageParams(getView(), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).buildPageParams(jdField_a_of_type_JavaLangString));
    RFLog.i(jdField_a_of_type_JavaLangString, RFLog.USR, "reportDaTongRegister  subPage: " + jdField_a_of_type_JavaLangString);
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
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
    if (NetworkUtil.g(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)) {
      this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(false);
    }
    this.webView.setMask(false);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver = new QCircleHybirdFragment.QCircleHybirdBroadcastReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver, paramBundle);
    }
    return i;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.D = false;
    this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.f = true;
    this.mUIStyleHandler.b = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getDefaultThemeColor(false);
    b();
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  public void doOnBackEvent()
  {
    super.doOnBackEvent();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHybirdQCircleHybirdFragment$QCircleHybirdBroadcastReceiver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */