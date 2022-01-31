package com.tencent.qapmsdk.dns.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class NetworkReceiver
  extends BroadcastReceiver
{
  private static NetworkReceiver sInstance = new NetworkReceiver();
  
  public static void register(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(sInstance, localIntentFilter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    NetworkHandler.notifyNetworkChanged(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */