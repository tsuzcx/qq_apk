package com.tencent.qqmini.minigame;

import com.tencent.qqmini.minigame.manager.JsApiUpdateManager.IUpdateListener;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GameRuntime$3
  implements JsApiUpdateManager.IUpdateListener
{
  GameRuntime$3(GameRuntime paramGameRuntime) {}
  
  public void onCheckResult(boolean paramBoolean)
  {
    QMLog.i("GameRuntime", "UpdateManager checkResult hasUpdate:" + paramBoolean + ", currentAppInfo:" + GameRuntime.access$300(this.this$0));
    AppStateEvent.obtain(2054, Boolean.valueOf(paramBoolean)).notifyRuntime(this.this$0);
  }
  
  public void onDownloadResult(boolean paramBoolean)
  {
    QMLog.i("GameRuntime", "UpdateManager downloadResult success:" + paramBoolean + ", currentAppInfo:" + GameRuntime.access$300(this.this$0));
    AppStateEvent.obtain(2055, Boolean.valueOf(paramBoolean)).notifyRuntime(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.3
 * JD-Core Version:    0.7.0.1
 */