package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment;

import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class LiteLiveWebViewFragment$4
  extends WebKernelCallBackProxy
{
  LiteLiveWebViewFragment$4(LiteLiveWebViewFragment paramLiteLiveWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    paramWebView = new StringBuilder();
    paramWebView.append("shouldOverrideUrlLoading: url = ");
    paramWebView.append(paramString);
    QLog.d("LiteLiveWebViewFragment", 1, paramWebView.toString());
    return LiteLiveWebViewFragment.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment.4
 * JD-Core Version:    0.7.0.1
 */