package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$2
  implements Runnable
{
  MapViewJsPlugin$2(MapViewJsPlugin paramMapViewJsPlugin, JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((AbsAppBrandPage)localObject1).getCurrentWebviewContainer(); localObject1 != null; localObject2 = null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
        localObject1 = ((WebviewContainer)localObject1).getMapContext(localJSONObject.optInt("mapId"));
        if (localObject1 != null)
        {
          ((MapContext)localObject1).updateMap(localJSONObject);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
          return;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[mini] MapViewJsPlugin", 1, this.val$eventName + " error.", localJSONException);
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */