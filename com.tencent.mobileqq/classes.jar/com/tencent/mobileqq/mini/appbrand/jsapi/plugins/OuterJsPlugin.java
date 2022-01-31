package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.HashSet;
import java.util.Set;

public class OuterJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "[mini] OuterJsPlugin";
  private Set<String> eventMap = new HashSet();
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    return MiniAppController.getInstance().handleNativeRequest(this.jsPluginEngine.appBrandRuntime.activity, this.jsPluginEngine.appBrandRuntime.getApkgInfo(), paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OuterJsPlugin
 * JD-Core Version:    0.7.0.1
 */