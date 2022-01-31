package com.tencent.qqmini.sdk.core.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import betc;
import org.json.JSONObject;

class NetworkJsPlugin$ConnectionChangeReceiver
  extends BroadcastReceiver
{
  NetworkJsPlugin$ConnectionChangeReceiver(NetworkJsPlugin paramNetworkJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = new JSONObject();
      paramIntent = NetworkJsPlugin.access$000(this.this$0);
      paramContext.put("networkType", paramIntent);
      if ("none".equals(paramIntent)) {
        paramContext.put("isConnected", false);
      }
      for (;;)
      {
        NetworkJsPlugin.access$100(this.this$0, paramContext);
        return;
        paramContext.put("isConnected", true);
      }
      return;
    }
    catch (Exception paramContext)
    {
      betc.d("NetworkJsPlugin", "fail on network change", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NetworkJsPlugin.ConnectionChangeReceiver
 * JD-Core Version:    0.7.0.1
 */