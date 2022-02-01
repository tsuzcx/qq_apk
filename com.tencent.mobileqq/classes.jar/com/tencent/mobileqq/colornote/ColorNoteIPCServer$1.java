package com.tencent.mobileqq.colornote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ColorNoteIPCServer$1
  extends BroadcastReceiver
{
  ColorNoteIPCServer$1(ColorNoteIPCServer paramColorNoteIPCServer) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {
          break label57;
        }
        this.a.a();
      }
    }
    label57:
    while ((!paramContext.equals("mqq.intent.action.LOGIN")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteIPCServer.1
 * JD-Core Version:    0.7.0.1
 */