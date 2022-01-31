package com.tencent.tvkbeacon.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.tvkbeacon.core.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  extends BroadcastReceiver
  implements Runnable
{
  private static volatile d c;
  private static final List<d.a> d = new ArrayList();
  private Context a;
  private volatile boolean b = false;
  private volatile boolean e = false;
  
  public static d a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new d();
      }
      return c;
    }
    finally {}
  }
  
  public static void a(d.a parama)
  {
    synchronized (d)
    {
      d.remove(parama);
      return;
    }
  }
  
  public final void a(Context paramContext, d.a parama)
  {
    if (paramContext == null) {
      c.d("[net] Context is null!", new Object[0]);
    }
    for (;;)
    {
      return;
      synchronized (d)
      {
        d.add(parama);
        if (this.e) {
          continue;
        }
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.e = true;
        return;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext.getApplicationContext();
    if (!this.b) {
      b.a.d().a(this);
    }
  }
  
  public void run()
  {
    this.b = true;
    try
    {
      if (this.a == null)
      {
        c.d("[net] onReceive context is null!", new Object[0]);
        return;
      }
      localObject2 = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject2 != null) {
        break label60;
      }
      c.d("[net] onReceive ConnectivityManager is null!", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    this.b = false;
    return;
    label60:
    Object localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    Object localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if (localObject1 != null) {}
    for (localObject1 = ((NetworkInfo)localObject1).getState();; localObject1 = null)
    {
      if (localObject2 != null) {}
      for (localObject2 = ((NetworkInfo)localObject2).getState();; localObject2 = null)
      {
        if ((NetworkInfo.State.CONNECTED != localObject2) && (NetworkInfo.State.CONNECTED != localObject1)) {
          break label142;
        }
        localObject1 = d.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((d.a)((Iterator)localObject1).next()).a();
        }
        break;
      }
      label142:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.d
 * JD-Core Version:    0.7.0.1
 */