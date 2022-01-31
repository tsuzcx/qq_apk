package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qphone.base.util.QLog;

class GameActivity$32
  implements Runnable
{
  GameActivity$32(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$3802(this.this$0, System.currentTimeMillis());
    QLog.e("[minigame] GameActivity", 1, "start launchGame, execJS");
    GameActivity.access$000(this.this$0).recordInitialMemory();
    MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, this.this$0.mGameAppConfig);
    GameActivity.access$3700(this.this$0, 1);
    MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1007, "1");
    IGameLauncher localIGameLauncher = GameActivity.access$1300(this.this$0).getGameEngine().getGameLauncher();
    if (localIGameLauncher != null)
    {
      localIGameLauncher.launchGame();
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "launchGame execJS fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.32
 * JD-Core Version:    0.7.0.1
 */