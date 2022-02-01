package com.tencent.rmonitor.natmem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;

public class NatMemReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.tencent.rmonitor.natmem.USAGE_DUMP".equals(paramContext)) && (PluginController.b.a()))
    {
      NatMemMonitor.getInstance().d();
      return;
    }
    if (("com.tencent.rmonitor.natmem.LEAK_DUMP".equals(paramContext)) && (PluginController.b.a())) {
      NatMemMonitor.getInstance().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemReceiver
 * JD-Core Version:    0.7.0.1
 */