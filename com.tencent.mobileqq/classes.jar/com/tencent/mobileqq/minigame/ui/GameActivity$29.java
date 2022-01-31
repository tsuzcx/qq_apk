package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qphone.base.util.QLog;

class GameActivity$29
  implements Runnable
{
  GameActivity$29(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$3102(this.this$0, System.currentTimeMillis());
    QLog.e("[minigame] GameActivity", 1, "start launchGame, execJS");
    GameActivity.access$000(this.this$0).recordInitialMemory();
    MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, this.this$0.gameConfig);
    GameActivity.access$3000(this.this$0, 1);
    MiniReportManager.reportEventType(this.this$0.gameConfig, 1007, "1");
    IGameLauncher localIGameLauncher = GameActivity.access$1200(this.this$0).getGameLauncher();
    if (localIGameLauncher != null)
    {
      int i = localIGameLauncher.launchGame();
      if (i == 0)
      {
        MiniReportManager.reportEventType(this.this$0.gameConfig, 1008, "1");
        return;
      }
      QLog.e("[minigame] GameActivity", 1, "launchGame " + i);
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "show_fail", "load_pkg_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.this$0.gameConfig);
      MiniGdtReporter.report(GameInfoManager.g().getMiniAppConfig(), 512);
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "launchGame execJS fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.29
 * JD-Core Version:    0.7.0.1
 */