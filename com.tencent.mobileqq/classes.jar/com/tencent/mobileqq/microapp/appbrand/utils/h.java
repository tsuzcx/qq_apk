package com.tencent.mobileqq.microapp.appbrand.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import bbjw;

final class h
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (bbjw.a(paramContext)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.h
 * JD-Core Version:    0.7.0.1
 */