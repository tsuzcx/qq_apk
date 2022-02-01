package com.tencent.xweb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.xwalk.core.Log;

class p$b
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"com.tencent.xweb.update".equals(paramIntent.getAction())) {
      return;
    }
    paramContext = paramIntent.getStringExtra("stage");
    if ("start".equals(paramContext))
    {
      Log.i("updateReicever", "start update");
      p.b();
      return;
    }
    int i;
    if ("updating".equals(paramContext))
    {
      i = paramIntent.getIntExtra("extra_data", 0);
      paramContext = new StringBuilder();
      paramContext.append("update progress = ");
      paramContext.append(i);
      Log.i("updateReicever", paramContext.toString());
      p.a(i);
      return;
    }
    if ("finished".equals(paramContext))
    {
      i = paramIntent.getIntExtra("extra_data", 0);
      paramContext = new StringBuilder();
      paramContext.append("update finished code = ");
      paramContext.append(i);
      Log.i("updateReicever", paramContext.toString());
      p.b(i);
      return;
    }
    if ("cfg_update".equals(paramContext))
    {
      Log.i("updateReicever", "cfg_update");
      p.c();
      return;
    }
    if ("plugin_update".equals(paramContext))
    {
      Log.i("updateReicever", "plugin_update");
      p.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.p.b
 * JD-Core Version:    0.7.0.1
 */