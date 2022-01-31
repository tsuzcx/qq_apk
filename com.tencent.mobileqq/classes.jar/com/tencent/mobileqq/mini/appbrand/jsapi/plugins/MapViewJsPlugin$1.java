package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$1
  implements Runnable
{
  MapViewJsPlugin$1(MapViewJsPlugin paramMapViewJsPlugin, JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.val$jsonParams);
        int i = localJSONObject1.optInt("mapId");
        int j = localJSONObject1.optInt("parentId");
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("containerId", i);
        String str = this.this$0.jsPluginEngine.appBrandRuntime.appId;
        ((WebviewContainer)localObject).insertMap(i, j, localJSONObject1.optString("subKey"), str);
        localObject = ((WebviewContainer)localObject).getMapContext(i);
        if (localObject != null)
        {
          ((MapContext)localObject).updateMap(localJSONObject1);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject2, this.val$callbackId);
          return;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[mini] MapViewJsPlugin", 1, this.val$eventName + " error.", localJSONException);
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */