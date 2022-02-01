package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

class QQVoiceWebViewBuilder$InnerAbsWebView
  extends AbsWebView
{
  private boolean b = false;
  
  public QQVoiceWebViewBuilder$InnerAbsWebView(QQVoiceWebViewBuilder paramQQVoiceWebViewBuilder, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
  }
  
  void a(QQVoiceWebView paramQQVoiceWebView)
  {
    this.mWebview = paramQQVoiceWebView;
    super.buildBaseWebView(null);
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (this.b) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.a.addJavaScript(localArrayList);
    paramArrayList.addAll(localArrayList);
    this.b = true;
  }
  
  public void onCreate()
  {
    super.doOnCreate(new Intent());
  }
  
  public void onDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.onPageFinished((QQVoiceWebView)paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.onPageStarted((QQVoiceWebView)paramWebView, paramString);
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.onReceivedError((QQVoiceWebView)paramWebView, paramString2, paramInt, paramString1);
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.QQVoiceWebViewBuilder.InnerAbsWebView
 * JD-Core Version:    0.7.0.1
 */