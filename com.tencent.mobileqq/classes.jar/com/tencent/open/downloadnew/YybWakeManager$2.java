package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.open.base.LogUtility;

class YybWakeManager$2
  extends BroadcastReceiver
{
  YybWakeManager$2(YybWakeManager paramYybWakeManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    YybWakeManager.a(this.a).removeMessages(100);
    LogUtility.c("YybWakeManager", "BROADCAST_YYB_ALIVE_CALLBACK received, stop wake yyb");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybWakeManager.2
 * JD-Core Version:    0.7.0.1
 */