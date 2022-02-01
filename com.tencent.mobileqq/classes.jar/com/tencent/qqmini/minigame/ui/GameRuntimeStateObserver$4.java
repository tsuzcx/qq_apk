package com.tencent.qqmini.minigame.ui;

import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GameRuntimeStateObserver$4
  implements Runnable
{
  GameRuntimeStateObserver$4(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if (GameRuntimeStateObserver.access$200(this.this$0) != null) {
      Toast.makeText(GameRuntimeStateObserver.access$200(this.this$0), "小游戏基础引擎加载失败！", 0).show();
    }
    QMLog.e("GameRuntimeState", "小游戏基础引擎加载失败！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.4
 * JD-Core Version:    0.7.0.1
 */