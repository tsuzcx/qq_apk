package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
      boolean bool = "none".equals(paramIntent);
      if (bool) {
        paramContext.put("isConnected", false);
      } else {
        paramContext.put("isConnected", true);
      }
      NetworkJsPlugin.access$100(this.this$0, paramContext);
      ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).notifyNetWorkStatusChange();
      return;
    }
    catch (Exception paramContext)
    {
      QMLog.e("NetworkJsPlugin", "fail on network change", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NetworkJsPlugin.ConnectionChangeReceiver
 * JD-Core Version:    0.7.0.1
 */