package com.tencent.mobileqq.werewolves;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class WerewolvesHandler$6
  extends BroadcastReceiver
{
  WerewolvesHandler$6(WerewolvesHandler paramWerewolvesHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    paramContext = paramIntent.getLongArrayExtra("uinList");
    boolean bool = paramIntent.getBooleanExtra("isSpeaking", false);
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        long l2 = paramContext[i];
        this.a.notifyUI(2, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.6
 * JD-Core Version:    0.7.0.1
 */