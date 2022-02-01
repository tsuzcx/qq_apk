package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class NativeFeatureJsPlugin$JSContextImpl
  implements NativePlugin.JSContext
{
  private int callbackId;
  private String eventName;
  private JsRuntime jsRuntime;
  
  public NativeFeatureJsPlugin$JSContextImpl(JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    this.jsRuntime = paramJsRuntime;
    this.eventName = paramString;
    this.callbackId = paramInt;
  }
  
  public void callJs(String paramString, JSONObject paramJSONObject)
  {
    JsRuntime localJsRuntime;
    String str;
    if (this.jsRuntime != null)
    {
      localJsRuntime = this.jsRuntime;
      str = "custom_event_" + paramString;
      if (paramJSONObject != null) {
        break label51;
      }
    }
    label51:
    for (paramString = "";; paramString = paramJSONObject.toString())
    {
      localJsRuntime.evaluateSubcribeJS(str, paramString, 0);
      return;
    }
  }
  
  public void evaluateCallback(boolean paramBoolean, JSONObject paramJSONObject, String paramString)
  {
    JsRuntime localJsRuntime;
    int i;
    if (this.jsRuntime != null)
    {
      localJsRuntime = this.jsRuntime;
      i = this.callbackId;
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (paramJSONObject = ApiUtil.wrapCallbackOk(this.eventName, paramJSONObject).toString();; paramJSONObject = ApiUtil.wrapCallbackFail(this.eventName, paramJSONObject, paramString).toString())
    {
      localJsRuntime.evaluateCallbackJs(i, paramJSONObject);
      return;
    }
  }
  
  public Activity getActivity()
  {
    Object localObject = this.jsRuntime;
    if ((localObject instanceof ServiceWebview))
    {
      localObject = ((ServiceWebview)localObject).appBrandEventInterface;
      if ((localObject != null) && ((localObject instanceof AppBrandRuntime))) {
        return ((AppBrandRuntime)localObject).activity;
      }
      QLog.e("NativeFeatureJsPlugin", 1, "appBrandServiceEventInterface is null");
    }
    for (;;)
    {
      return null;
      if ((localObject instanceof ServiceOriginalWebview))
      {
        localObject = ((ServiceOriginalWebview)localObject).appBrandEventInterface;
        if ((localObject != null) && ((localObject instanceof AppBrandRuntime))) {
          return ((AppBrandRuntime)localObject).activity;
        }
        QLog.e("NativeFeatureJsPlugin", 1, "appBrandServiceEventInterface is null");
      }
      else
      {
        QLog.e("NativeFeatureJsPlugin", 1, "runtime is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativeFeatureJsPlugin.JSContextImpl
 * JD-Core Version:    0.7.0.1
 */