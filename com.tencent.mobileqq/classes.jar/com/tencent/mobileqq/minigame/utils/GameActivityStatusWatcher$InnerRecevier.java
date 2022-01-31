package com.tencent.mobileqq.minigame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class GameActivityStatusWatcher$InnerRecevier
  extends BroadcastReceiver
{
  final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
  final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
  final String SYSTEM_DIALOG_REASON_KEY = "reason";
  final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
  
  GameActivityStatusWatcher$InnerRecevier(GameActivityStatusWatcher paramGameActivityStatusWatcher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if ("action.qq.miniapp.show.monitorview".equals(paramContext))
      {
        boolean bool = paramIntent.getBooleanExtra("show", true);
        GameActivityStatusWatcher.access$000(this.this$0).onShowMonitorView(bool);
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramIntent = paramIntent.getStringExtra("reason");
        if ((paramIntent != null) && (GameActivityStatusWatcher.access$000(this.this$0) != null))
        {
          if (!paramIntent.equals("homekey")) {
            break label113;
          }
          GameActivityStatusWatcher.access$000(this.this$0).onHomePressed();
        }
      }
      while ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        GameActivityStatusWatcher.access$000(this.this$0).onScreenOff();
        return;
        label113:
        if (paramIntent.equals("recentapps")) {
          GameActivityStatusWatcher.access$000(this.this$0).onRecentTaskPressed();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher.InnerRecevier
 * JD-Core Version:    0.7.0.1
 */