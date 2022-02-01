package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import bidf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

class QQVoiceWebViewBuilder$InnerAbsWebView
  extends bidf
{
  private boolean jdField_a_of_type_Boolean;
  
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomWebviewQQVoiceWebViewBuilder.addJavaScript(localArrayList);
    paramArrayList.addAll(localArrayList);
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomWebviewQQVoiceWebViewBuilder.onPageFinished((QQVoiceWebView)paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomWebviewQQVoiceWebViewBuilder.onPageStarted((QQVoiceWebView)paramWebView, paramString);
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomWebviewQQVoiceWebViewBuilder.onReceivedError((QQVoiceWebView)paramWebView, paramString2, paramInt, paramString1);
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.QQVoiceWebViewBuilder.InnerAbsWebView
 * JD-Core Version:    0.7.0.1
 */