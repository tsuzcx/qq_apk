package com.tencent.qqmini.minigame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GamePage$MonitorBroadcastReceiver
  extends BroadcastReceiver
{
  GamePage$MonitorBroadcastReceiver(GamePage paramGamePage) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
    {
      paramContext = "show";
      boolean bool = paramIntent.getBooleanExtra("show", true);
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive action action.qq.miniapp.show.monitorview, ");
      if (!bool) {
        paramContext = "hide";
      }
      paramIntent.append(paramContext);
      paramIntent.append(" monitor view!");
      QMLog.d("GamePage", paramIntent.toString());
      if (GamePage.access$900(this.this$0) != bool) {
        this.this$0.toggleMonitorPanel();
      }
      if (GamePage.access$1000(this.this$0) != null)
      {
        paramContext = this.this$0;
        GamePage.access$1100(paramContext, GamePage.access$1000(paramContext));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */