package com.tencent.raft.component;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class TxchPage$1
  extends WebViewClient
{
  TxchPage$1(TxchPage paramTxchPage) {}
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    super.shouldOverrideUrlLoading(paramWebView, paramString);
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.component.TxchPage.1
 * JD-Core Version:    0.7.0.1
 */