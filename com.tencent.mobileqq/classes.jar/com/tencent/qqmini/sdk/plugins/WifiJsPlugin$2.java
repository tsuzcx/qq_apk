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
      localObject = this.this$0;
      WifiJsPlugin.access$102((WifiJsPlugin)localObject, (WifiManager)WifiJsPlugin.access$200((WifiJsPlugin)localObject).getApplicationContext().getSystemService("wifi"));
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("errCode", 0);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      this.val$req.ok((JSONObject)localObject);
      WifiJsPlugin.access$300(this.this$0);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("errCode", 12010);
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    this.val$req.fail((JSONObject)localObject, ":ACCESS_FINE_LOCATION denied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.WifiJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */