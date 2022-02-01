package com.tencent.mobileqq.qcircle.api.hybird;

import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.smtt.sdk.WebSettings;

class QCircleHybirdFragment$1
  extends WebKernelCallBackProxy
{
  QCircleHybirdFragment$1(QCircleHybirdFragment paramQCircleHybirdFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D = false;
    this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.f = true;
    this.a.getUIStyleHandler().b = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getDefaultThemeColor(false);
    QCircleHybirdFragment.a(this.a);
    super.onDataInit(paramBundle);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    if (this.a.getActivity().getRequestedOrientation() != 1) {
      this.a.getActivity().setRequestedOrientation(1);
    }
    this.a.getWebView().setVerticalScrollBarEnabled(false);
    this.a.getWebView().setHorizontalScrollBarEnabled(false);
    this.a.getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    paramBundle = this.a.getWebView().getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getWebView().getSettings().getUserAgentString());
    localStringBuilder.append(" QQ_APP_Subscribe");
    paramBundle.setUserAgentString(localStringBuilder.toString());
    if (NetworkUtil.isNetworkAvailable(this.a.getActivity())) {
      this.a.getWebView().getSettings().setCacheMode(2);
    }
    if ((this.a.getUIStyleHandler() != null) && (this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)) {
      this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(false);
    }
    QCircleHybirdFragment.a(this.a).setMask(false);
    if (this.a.getActivity() != null)
    {
      paramBundle = this.a;
      QCircleHybirdFragment.a(paramBundle, new QCircleHybirdFragment.QCircleHybirdBroadcastReceiver(paramBundle));
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      this.a.getActivity().registerReceiver(QCircleHybirdFragment.a(this.a), paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment.1
 * JD-Core Version:    0.7.0.1
 */