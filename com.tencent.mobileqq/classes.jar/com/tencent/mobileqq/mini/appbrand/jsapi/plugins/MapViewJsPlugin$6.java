package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$6
  implements Runnable
{
  MapViewJsPlugin$6(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(this.val$jsonParams).optInt("mapId", 0);
        Object localObject1 = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
        if (localObject1 != null)
        {
          localObject1 = ((WebviewContainer)localObject1).getMapContext(i);
          if (localObject1 == null) {
            break label252;
          }
          localObject1 = ((MapContext)localObject1).getCenterLocation();
          if (localObject1 != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("latitude", ((LatLng)localObject1).getLatitude());
            localJSONObject.put("longitude", ((LatLng)localObject1).getLongitude());
            QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "callbackJsEventOK:" + localJSONObject.toString());
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject, this.val$callbackId);
          }
        }
        else
        {
          QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
          break label252;
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
      label252:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */