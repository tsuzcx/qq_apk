package com.tencent.mobileqq.ecshop.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/temp/api/IEcshopWebViewPluginTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDataApiPlugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "getMediaApiPlugin", "getPayJsPlugin", "getQQApiPlugin", "getQWalletBluetoothJsPlugin", "getQWalletCommonHbJsPlugin", "getQWalletCommonJsPlugin", "getQWalletMixJsPlugin", "getQWalletPayJsPlugin", "getSensorAPIJavaScript", "getUiApiPlugin", "getVasCommonJsPlugin", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopWebViewPluginTempApi
  extends QRouteApi
{
  @NotNull
  public abstract WebViewPlugin getDataApiPlugin();
  
  @NotNull
  public abstract WebViewPlugin getMediaApiPlugin();
  
  @NotNull
  public abstract WebViewPlugin getPayJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQQApiPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQWalletBluetoothJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQWalletCommonHbJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQWalletCommonJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQWalletMixJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getQWalletPayJsPlugin();
  
  @NotNull
  public abstract WebViewPlugin getSensorAPIJavaScript();
  
  @NotNull
  public abstract WebViewPlugin getUiApiPlugin();
  
  @NotNull
  public abstract WebViewPlugin getVasCommonJsPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.IEcshopWebViewPluginTempApi
 * JD-Core Version:    0.7.0.1
 */