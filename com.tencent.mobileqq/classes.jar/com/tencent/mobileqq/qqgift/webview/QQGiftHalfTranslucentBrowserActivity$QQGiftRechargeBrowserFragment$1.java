package com.tencent.mobileqq.qqgift.webview;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;

class QQGiftHalfTranslucentBrowserActivity$QQGiftRechargeBrowserFragment$1
  extends WebKernelCallBackProxy
{
  QQGiftHalfTranslucentBrowserActivity$QQGiftRechargeBrowserFragment$1(QQGiftHalfTranslucentBrowserActivity.QQGiftRechargeBrowserFragment paramQQGiftRechargeBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.a.b(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.a.a(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedError errorCode:");
    paramWebView.append(paramInt);
    paramWebView.append(", description:");
    paramWebView.append(paramString1);
    paramWebView.append(", failingUrl:");
    paramWebView.append(paramString2);
    QLog.e("WebLog_WebViewFragment", 1, paramWebView.toString());
    paramWebView = this.a.getActivity();
    if ((paramWebView instanceof QQGiftHalfTranslucentBrowserActivity))
    {
      paramWebView = ((QQGiftHalfTranslucentBrowserActivity)paramWebView).a();
      if (paramWebView != null)
      {
        paramWebView.setVisibility(0);
        ((TextView)paramWebView.findViewById(2131448425)).setText("充值面板拉取失败\n请重进直播间后尝试");
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslError);
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedSslError errorCode:");
    paramWebView.append(paramSslError);
    QLog.e("WebLog_WebViewFragment", 1, paramWebView.toString());
    paramWebView = this.a.getActivity();
    if ((paramWebView instanceof QQGiftHalfTranslucentBrowserActivity))
    {
      paramWebView = ((QQGiftHalfTranslucentBrowserActivity)paramWebView).a();
      if (paramWebView != null)
      {
        paramWebView.setVisibility(0);
        ((TextView)paramWebView.findViewById(2131448425)).setText("充值面板拉取失败\n请重进直播间后尝试");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity.QQGiftRechargeBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */