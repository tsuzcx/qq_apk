package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$7
  implements Runnable
{
  MapViewJsPlugin$7(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.val$jsonParams);
      int i = localJSONObject1.optInt("mapId", 0);
      JSONObject localJSONObject2 = new JSONObject();
      Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
      if (localObject != null)
      {
        localObject = ((WebviewContainer)localObject).getMapContext(i);
        if (localObject == null) {
          return;
        }
        if ((localJSONObject1.has("longitude")) || (localJSONObject1.has("latitude"))) {
          ((MapContext)localObject).moveToLocation(localJSONObject1);
        }
        for (;;)
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject2, this.val$callbackId);
          return;
          ((MapContext)localObject).moveToCurrentLocation();
        }
      }
      QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[mini] MapViewJsPlugin", 2, localJSONException, new Object[0]);
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */