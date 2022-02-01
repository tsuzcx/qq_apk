package org.extra.tools;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.reflect.Method;

public class ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private ScreenBroadcastReceiver.ScreenStateListener listener;
  
  ScreenBroadcastReceiver(ScreenBroadcastReceiver.ScreenStateListener paramScreenStateListener)
  {
    this.listener = paramScreenStateListener;
  }
  
  private Context getApplicationContext()
  {
    try
    {
      Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      return localContext;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext)) {
      this.listener.onScreenOn();
    }
    while (!"android.intent.action.SCREEN_OFF".equals(paramContext)) {
      return;
    }
    this.listener.onScreenOff();
  }
  
  public void register()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    try
    {
      Context localContext = getApplicationContext();
      if (localContext != null) {
        localContext.registerReceiver(this, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void unregister()
  {
    try
    {
      Context localContext = getApplicationContext();
      if (localContext != null) {
        localContext.unregisterReceiver(this);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.extra.tools.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */