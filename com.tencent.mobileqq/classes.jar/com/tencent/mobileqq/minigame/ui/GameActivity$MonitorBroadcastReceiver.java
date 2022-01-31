package com.tencent.mobileqq.minigame.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GameActivity$MonitorBroadcastReceiver
  extends BroadcastReceiver
{
  GameActivity$MonitorBroadcastReceiver(GameActivity paramGameActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
    {
      bool = paramIntent.getBooleanExtra("show", true);
      paramIntent = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
      if (!bool) {
        break label114;
      }
    }
    label114:
    for (paramContext = "show";; paramContext = "hide")
    {
      QLog.d("[minigame] GameActivity", 1, paramContext + " monitor view!");
      if (GameActivity.access$1400(this.this$0) != bool) {
        GameActivity.access$1402(this.this$0, this.this$0.clickMonitorPanel());
      }
      if (GameActivity.access$1500(this.this$0) == null) {
        GameActivity.access$1600(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */