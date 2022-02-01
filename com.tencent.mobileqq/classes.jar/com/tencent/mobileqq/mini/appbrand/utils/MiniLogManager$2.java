package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import bhsr;

final class MiniLogManager$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (bhsr.a(paramContext)) {}
    do
    {
      return;
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        MiniLogManager.access$200().removeMessages(4);
        MiniLogManager.access$200().sendEmptyMessageDelayed(4, 60000L);
        return;
      }
    } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
    MiniLogManager.access$200().removeMessages(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.2
 * JD-Core Version:    0.7.0.1
 */