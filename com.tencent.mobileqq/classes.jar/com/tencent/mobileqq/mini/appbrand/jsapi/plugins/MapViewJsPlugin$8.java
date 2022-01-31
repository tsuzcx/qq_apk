package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$8
  implements Runnable
{
  MapViewJsPlugin$8(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(this.val$jsonParams).optInt("mapId", 0);
        Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
        if (localObject != null)
        {
          localObject = ((WebviewContainer)localObject).getMapContext(i);
          if (localObject == null) {
            break label201;
          }
          f = ((MapContext)localObject).getScale();
          if (f != 0.0F)
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("scale", f);
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, (JSONObject)localObject, this.val$callbackId);
          }
        }
        else
        {
          QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
          break label201;
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
      label201:
      float f = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */