package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import org.json.JSONObject;

public class NetworkJsPlugin$NetInfoHandler
  implements INetEventHandler
{
  public NetworkJsPlugin$NetInfoHandler(NetworkJsPlugin paramNetworkJsPlugin) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = NetworkJsPlugin.access$000(this.this$0);
      localJSONObject.put("networkType", str);
      if ("none".equals(str)) {
        localJSONObject.put("isConnected", false);
      }
      for (;;)
      {
        NetworkJsPlugin.access$100(this.this$0, localJSONObject);
        return;
        localJSONObject.put("isConnected", true);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NetworkJsPlugin.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */