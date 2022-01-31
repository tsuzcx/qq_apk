package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class WifiJsPlugin$3
  implements WifiJsPlugin.LocationPermissionListener
{
  WifiJsPlugin$3(WifiJsPlugin paramWifiJsPlugin, Context paramContext, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onExecute(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WifiJsPlugin.access$102(this.this$0, (WifiManager)this.val$context.getApplicationContext().getSystemService("wifi"));
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 0);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject, this.val$callbackId);
        WifiJsPlugin.access$200(this.this$0);
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", 12010);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, localJSONObject, ":ACCESS_FINE_LOCATION denied", this.val$callbackId);
      return;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.WifiJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */