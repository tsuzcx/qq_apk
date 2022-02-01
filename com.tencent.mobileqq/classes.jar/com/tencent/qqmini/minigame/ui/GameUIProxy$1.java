package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GameUIProxy$1
  implements GameActivityStatusWatcher.OnWatcherActionListener
{
  GameUIProxy$1(GameUIProxy paramGameUIProxy) {}
  
  public void onHomePressed()
  {
    QMLog.e("minisdk-start_UIProxy", "home pressed!");
    AppStateEvent.obtain(2053).notifyRuntime(this.this$0.getRuntime());
  }
  
  public void onRecentTaskPressed()
  {
    QMLog.e("minisdk-start_UIProxy", "rencent task to front!");
    AppStateEvent.obtain(2053).notifyRuntime(this.this$0.getRuntime());
  }
  
  public void onScreenOff()
  {
    QMLog.e("minisdk-start_UIProxy", "screen off");
    AppStateEvent.obtain(2053).notifyRuntime(this.this$0.getRuntime());
  }
  
  public void onShowMonitorView(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.1
 * JD-Core Version:    0.7.0.1
 */