package com.tencent.qapmsdk.dns.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class NetworkReceiver
  extends BroadcastReceiver
{
  private static NetworkReceiver a = new NetworkReceiver();
  
  public static void a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(a, localIntentFilter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */