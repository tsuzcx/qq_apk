package com.tencent.mobileqq.kandian.biz.detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$6
  extends WebKernelCallBackProxy
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$6(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    if ((TextUtils.equals("netTimeConsumingReport", paramString)) && (paramBundle != null) && (paramBundle.containsKey("firstbyte")))
    {
      String str1 = paramBundle.getString("firstword");
      try
      {
        if (!TextUtils.isEmpty(str1)) {
          this.a.h = Long.parseLong(str1);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str2 = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handlerMiscCallback] e = ");
        localStringBuilder.append(localNumberFormatException);
        QLog.e(str2, 1, localStringBuilder.toString());
      }
    }
    return super.handlerMiscCallback(paramString, paramBundle);
  }
  
  public boolean interceptStartLoadUrl()
  {
    this.a.e = System.currentTimeMillis();
    ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment localReadInJoyArticleDetailFragment = this.a;
    if (!ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(localReadInJoyArticleDetailFragment, ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.f(localReadInJoyArticleDetailFragment))) {
      super.interceptStartLoadUrl();
    }
    return true;
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    super.onInitTitleBar(paramBundle);
    this.a.a(paramBundle);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    super.onInitUIContent(paramBundle);
    ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.e(this.a);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView, paramString, this.webViewKernelCallBack);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.a(paramWebView, paramString, paramBitmap, this.webViewKernelCallBack);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    this.a.a(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.a.a(paramBundle, paramTouchWebView, this.webViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.6
 * JD-Core Version:    0.7.0.1
 */