package com.tencent.qqmini.minigame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class GameActivityStatusWatcher$InnerRecevier
  extends BroadcastReceiver
{
  public static final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
  public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
  public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
  public static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
  
  GameActivityStatusWatcher$InnerRecevier(GameActivityStatusWatcher paramGameActivityStatusWatcher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if ("action.qq.miniapp.show.monitorview".equals(paramContext))
    {
      boolean bool = paramIntent.getBooleanExtra("show", true);
      GameActivityStatusWatcher.access$000(this.this$0).onShowMonitorView(bool);
    }
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
    {
      paramIntent = paramIntent.getStringExtra("reason");
      if ((paramIntent != null) && (GameActivityStatusWatcher.access$000(this.this$0) != null)) {
        if (paramIntent.equals("homekey")) {
          GameActivityStatusWatcher.access$000(this.this$0).onHomePressed();
        } else if (paramIntent.equals("recentapps")) {
          GameActivityStatusWatcher.access$000(this.this$0).onRecentTaskPressed();
        }
      }
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      GameActivityStatusWatcher.access$000(this.this$0).onScreenOff();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.InnerRecevier
 * JD-Core Version:    0.7.0.1
 */