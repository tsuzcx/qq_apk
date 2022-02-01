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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateManager checkResult hasUpdate:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", currentAppInfo:");
    localStringBuilder.append(GameRuntime.access$400(this.this$0));
    QMLog.i("GameRuntime", localStringBuilder.toString());
    AppStateEvent.obtain(2054, Boolean.valueOf(paramBoolean)).notifyRuntime(this.this$0);
  }
  
  public void onDownloadResult(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateManager downloadResult success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", currentAppInfo:");
    localStringBuilder.append(GameRuntime.access$400(this.this$0));
    QMLog.i("GameRuntime", localStringBuilder.toString());
    AppStateEvent.obtain(2055, Boolean.valueOf(paramBoolean)).notifyRuntime(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.3
 * JD-Core Version:    0.7.0.1
 */