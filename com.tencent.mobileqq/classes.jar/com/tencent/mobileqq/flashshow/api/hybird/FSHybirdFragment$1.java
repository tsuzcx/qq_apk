package com.tencent.mobileqq.flashshow.api.hybird;

import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.smtt.sdk.WebSettings;

class FSHybirdFragment$1
  extends WebKernelCallBackProxy
{
  FSHybirdFragment$1(FSHybirdFragment paramFSHybirdFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.a.getUIStyleHandler().f.O = false;
    this.a.getUIStyleHandler().f.m = true;
    this.a.getUIStyleHandler().F = this.a.getResources().getColor(2131167016);
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
    if ((this.a.getUIStyleHandler() != null) && (this.a.getUIStyleHandler().w != null)) {
      this.a.getUIStyleHandler().w.a(false);
    }
    FSHybirdFragment.a(this.a).setMask(false);
    if (this.a.getActivity() != null)
    {
      paramBundle = this.a;
      FSHybirdFragment.a(paramBundle, new FSHybirdFragment.FSHybirdBroadcastReceiver(paramBundle));
      paramBundle = new IntentFilter();
      this.a.getActivity().registerReceiver(FSHybirdFragment.b(this.a), paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSHybirdFragment.1
 * JD-Core Version:    0.7.0.1
 */