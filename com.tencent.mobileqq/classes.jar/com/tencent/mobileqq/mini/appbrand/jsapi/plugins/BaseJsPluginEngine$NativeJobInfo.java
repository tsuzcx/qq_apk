package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.Serializable;
import mqq.util.WeakReference;

class BaseJsPluginEngine$NativeJobInfo
  implements Serializable
{
  public int callbackId;
  public String eventName;
  public WeakReference<JsRuntime> jsRuntimeRef;
  public String jsonParams;
  
  public BaseJsPluginEngine$NativeJobInfo(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    this.eventName = paramString1;
    this.jsonParams = paramString2;
    this.jsRuntimeRef = new WeakReference(paramJsRuntime);
    this.callbackId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.NativeJobInfo
 * JD-Core Version:    0.7.0.1
 */