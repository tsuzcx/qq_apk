package com.tencent.tfm.metrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tfm.metrics.utils.ELog;
import java.util.ArrayList;
import java.util.List;

public final class NetworkStateReceiver
  extends BroadcastReceiver
{
  private static final List<NetworkStateReceiver.StateChangeListener> LISTENERS = new ArrayList();
  private static volatile boolean isStartReceive = false;
  private NetworkStateReceiver.NetworkUpdateHandler handler;
  
  public NetworkStateReceiver()
  {
    new NetworkStateReceiver.1(this, "tfm_metrics_network").start();
  }
  
  public static void registerListener(Context paramContext, NetworkStateReceiver.StateChangeListener paramStateChangeListener)
  {
    if (paramContext == null)
    {
      ELog.error("[net] context == null!", new Object[0]);
      return;
    }
    synchronized (LISTENERS)
    {
      LISTENERS.add(paramStateChangeListener);
      if (!isStartReceive)
      {
        paramStateChangeListener = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.registerReceiver(new NetworkStateReceiver(), paramStateChangeListener);
        isStartReceive = true;
      }
      return;
    }
  }
  
  public static void unregisterListener(NetworkStateReceiver.StateChangeListener paramStateChangeListener)
  {
    synchronized (LISTENERS)
    {
      LISTENERS.remove(paramStateChangeListener);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = this.handler;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.obtainMessage();
      paramIntent.obj = paramContext;
      this.handler.sendMessage(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.NetworkStateReceiver
 * JD-Core Version:    0.7.0.1
 */