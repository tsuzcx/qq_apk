package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class WifiJsPlugin$2
  implements WifiJsPlugin.LocationPermissionListener
{
  WifiJsPlugin$2(WifiJsPlugin paramWifiJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onExecute(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WifiJsPlugin.access$102(this.this$0, (WifiManager)WifiJsPlugin.access$200(this.this$0).getApplicationContext().getSystemService("wifi"));
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 0);
        this.val$req.ok(localJSONObject);
        WifiJsPlugin.access$300(this.this$0);
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
      this.val$req.fail(localJSONObject, ":ACCESS_FINE_LOCATION denied");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.WifiJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */