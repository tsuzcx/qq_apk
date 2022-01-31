package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$10
  implements GameActivityStatusWatcher.OnWatcherActionListener
{
  GameActivity$10(GameActivity paramGameActivity) {}
  
  public void onHomePressed()
  {
    QLog.e("[minigame] GameActivity", 1, "home pressed!");
    this.this$0.notifyGameStop();
  }
  
  public void onRecentTaskPressed()
  {
    QLog.e("[minigame] GameActivity", 1, "rencent task to front!");
    this.this$0.notifyGameStop();
  }
  
  public void onScreenOff()
  {
    QLog.e("[minigame] GameActivity", 1, "screen off");
    this.this$0.notifyGameStop();
  }
  
  public void onShowMonitorView(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
    if (paramBoolean) {}
    for (String str = "show";; str = "hide")
    {
      QLog.d("[minigame] GameActivity", 1, str + " monitor view!");
      if (GameActivity.access$1300(this.this$0) != paramBoolean) {
        GameActivity.access$1302(this.this$0, this.this$0.clickMonitorPanel());
      }
      if (GameActivity.access$1400(this.this$0) == null) {
        GameActivity.access$1500(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.10
 * JD-Core Version:    0.7.0.1
 */