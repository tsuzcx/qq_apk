package com.tencent.mobileqq.qqgamepub.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QQGameWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  private static final String TAG = "QQGamePub_QQGameWebViewBuilder";
  
  public QQGameWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).bindQQGameWebViewBuilderJavaScript(paramArrayList);
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
  
  public void onWebViewReady()
  {
    super.onWebViewReady();
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */