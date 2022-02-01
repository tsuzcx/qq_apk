package com.tencent.mobileqq.ecshop.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopWebViewPluginTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class EcshopNewPageWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  private String a;
  
  public EcshopNewPageWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
    this.a = paramString;
  }
  
  public void a()
  {
    super.doOnResume();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onResume");
  }
  
  public void b()
  {
    super.doOnPause();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onPause");
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageWebViewBuilder", 2, "[bindJavaScript]");
    }
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQWalletPayJsPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getPayJsPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQWalletCommonJsPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQWalletBluetoothJsPlugin());
    paramArrayList.add(((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebViewPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQQApiPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getUiApiPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getSensorAPIJavaScript());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getDataApiPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getMediaApiPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getVasCommonJsPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQWalletCommonHbJsPlugin());
    paramArrayList.add(((IEcshopWebViewPluginTempApi)QRoute.api(IEcshopWebViewPluginTempApi.class)).getQWalletMixJsPlugin());
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
  
  public void c()
  {
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onDestroy");
    EcshopWebviewPool.a().a(this.mWebview, this.a);
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
  
  public void onWebViewReady()
  {
    super.onWebViewReady();
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopNewPageWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */