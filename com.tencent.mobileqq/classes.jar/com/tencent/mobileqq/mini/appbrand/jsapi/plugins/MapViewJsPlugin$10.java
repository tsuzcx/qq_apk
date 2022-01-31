package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$10
  implements Runnable
{
  MapViewJsPlugin$10(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.val$jsonParams);
        i = localJSONObject1.optInt("mapId", 0);
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
        if (localObject != null)
        {
          localObject = ((WebviewContainer)localObject).getMapContext(i);
          if (localObject == null) {
            break label199;
          }
          ((MapContext)localObject).includeMapPoints(localJSONObject1);
          i = 1;
          if (i != 0) {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject2, this.val$callbackId);
          }
        }
        else
        {
          QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
          break label199;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("[mini] MapViewJsPlugin", 2, localJSONException, new Object[0]);
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      label199:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */