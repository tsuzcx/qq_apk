package com.tencent.mobileqq.ecshop.temp.api.impl;

import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopWebViewPluginTempApi;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopWebViewPluginTempApiImpl;", "Lcom/tencent/mobileqq/ecshop/temp/api/IEcshopWebViewPluginTempApi;", "()V", "getDataApiPlugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "getMediaApiPlugin", "getPayJsPlugin", "getQQApiPlugin", "getQWalletBluetoothJsPlugin", "getQWalletCommonHbJsPlugin", "getQWalletCommonJsPlugin", "getQWalletMixJsPlugin", "getQWalletPayJsPlugin", "getSensorAPIJavaScript", "getUiApiPlugin", "getVasCommonJsPlugin", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class EcshopWebViewPluginTempApiImpl
  implements IEcshopWebViewPluginTempApi
{
  @NotNull
  public WebViewPlugin getDataApiPlugin()
  {
    return (WebViewPlugin)new DataApiPlugin();
  }
  
  @NotNull
  public WebViewPlugin getMediaApiPlugin()
  {
    return (WebViewPlugin)new MediaApiPlugin();
  }
  
  @NotNull
  public WebViewPlugin getPayJsPlugin()
  {
    return (WebViewPlugin)new PayJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQQApiPlugin()
  {
    return (WebViewPlugin)new QQApiPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQWalletBluetoothJsPlugin()
  {
    return (WebViewPlugin)new QWalletBluetoothJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQWalletCommonHbJsPlugin()
  {
    return (WebViewPlugin)new QWalletCommonHbJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQWalletCommonJsPlugin()
  {
    return (WebViewPlugin)new QWalletCommonJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQWalletMixJsPlugin()
  {
    return (WebViewPlugin)new QWalletMixJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getQWalletPayJsPlugin()
  {
    return (WebViewPlugin)new QWalletPayJsPlugin();
  }
  
  @NotNull
  public WebViewPlugin getSensorAPIJavaScript()
  {
    return (WebViewPlugin)new SensorAPIJavaScript();
  }
  
  @NotNull
  public WebViewPlugin getUiApiPlugin()
  {
    return (WebViewPlugin)new UiApiPlugin();
  }
  
  @NotNull
  public WebViewPlugin getVasCommonJsPlugin()
  {
    return (WebViewPlugin)new VasCommonJsPlugin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.impl.EcshopWebViewPluginTempApiImpl
 * JD-Core Version:    0.7.0.1
 */