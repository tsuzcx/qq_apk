package com.tencent.trackrecordlib.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.trackrecordlib.core.c;

class f$a
  extends BroadcastReceiver
{
  final String a = "reason";
  final String b = "recentapps";
  final String c = "homekey";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        if (paramContext.equals("homekey"))
        {
          c.a().d();
          return;
        }
        paramContext.equals("recentapps");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.f.a
 * JD-Core Version:    0.7.0.1
 */