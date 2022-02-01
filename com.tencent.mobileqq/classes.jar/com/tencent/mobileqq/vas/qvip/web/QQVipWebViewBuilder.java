package com.tencent.mobileqq.vas.qvip.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QQVipWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public QQVipWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
  }
  
  public void a()
  {
    super.doOnDestroy();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    paramArrayList.add(new WadlWebViewJsPlugin());
    paramArrayList.add(new QQGameWebViewJsPlugin());
    paramArrayList.add(new QWalletPayJsPlugin());
    paramArrayList.add(new PayJsPlugin());
    paramArrayList.add(new QWalletCommonJsPlugin());
    paramArrayList.add(new QWalletBluetoothJsPlugin());
    paramArrayList.add(new QQApiPlugin());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new DataApiPlugin());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
    paramArrayList.add(new QWalletCommonHbJsPlugin());
    paramArrayList.add(new QWalletMixJsPlugin());
    paramArrayList.add(new SSOWebviewPlugin());
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
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onWebViewReady()
  {
    super.onWebViewReady();
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.web.QQVipWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */