package com.tencent.tmassistantbase.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  protected static NetworkMonitorReceiver a = null;
  protected static Handler c;
  protected boolean b = false;
  ArrayList<a> d = new ArrayList();
  
  public static NetworkMonitorReceiver a()
  {
    try
    {
      if (a == null) {
        a = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = a;
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    if ((!this.d.contains(parama)) && (parama != null)) {
      this.d.add(parama);
    }
  }
  
  public void b()
  {
    r.c("NetworkMonitorReceiver", "registerReceiver enter");
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      r.c("NetworkMonitorReceiver", "registerReceiver context = null");
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.b = true;
      r.c("NetworkMonitorReceiver", "registerReceiver isRegisterReceiver = true");
      r.c("NetworkMonitorReceiver", "registerReceiver exit");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.b = false;
        r.c("NetworkMonitorReceiver", "registerReceiver isRegisterReceiver = false");
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void b(a parama)
  {
    if (parama != null) {
      this.d.remove(parama);
    }
  }
  
  public void c()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      Context localContext = GlobalUtil.getInstance().getContext();
      if (localContext != null) {
        try
        {
          if (this.b)
          {
            localContext.unregisterReceiver(this);
            this.b = false;
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void d()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.onNetworkChanged();
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    r.c("NetworkMonitorReceiver", "network changed!");
    if (c == null) {
      c = new b(this);
    }
    c.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    c.sendMessageDelayed(paramContext, 3500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */