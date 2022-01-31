package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$24
  implements ITTEngine.IListener
{
  GameActivity$24(GameActivity paramGameActivity, long paramLong) {}
  
  public void onFirstRender()
  {
    if (GameActivity.access$2900(this.this$0) == 2)
    {
      QLog.e("[minigame][timecost] ", 1, "onFirstRender() repeat call! something wrong!");
      return;
    }
    GameActivity.access$3000(this.this$0, 2);
    GameReportManager.g().onFirstFrame();
    long l1 = 0L;
    if (GameActivity.access$3100(this.this$0) > 0L) {
      l1 = System.currentTimeMillis() - GameActivity.access$3100(this.this$0);
    }
    MiniReportManager.reportEventType(this.this$0.gameConfig, 636, null, null, null, 0, "1", l1, null);
    MiniAppStartState.updateState(this.this$0.gameConfig.config.appId, true);
    if (GameActivity.access$3200(this.this$0))
    {
      GameActivity.access$3202(this.this$0, false);
      QLog.i("[minigame][start] ", 1, "game[" + this.this$0.gameConfig.config.appId + "][" + this.this$0.gameConfig.config.name + "] 冷启动，首帧出现!");
      MiniReportManager.reportEventType(this.this$0.gameConfig, 1022, "1");
    }
    for (;;)
    {
      MiniReportManager.reportEventType(this.this$0.gameConfig, 21, "1");
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "show", "first_frame");
      MiniAppReportManager2.reportPageView("2launch", "first_frame", null, this.this$0.gameConfig);
      GameActivity.access$3302(this.this$0, System.currentTimeMillis());
      GameActivity.access$3402(this.this$0, true);
      MiniGdtReporter.report(GameInfoManager.g().getMiniAppConfig(), 0);
      GameActivity.access$3502(this.this$0, System.currentTimeMillis());
      l1 = GameActivity.access$3500(this.this$0);
      long l2 = this.val$begin;
      long l3 = GameActivity.access$3500(this.this$0) - GameActivity.access$2800(this.this$0);
      long l4 = GameActivity.access$3500(this.this$0) - GameActivity.access$3600(this.this$0);
      MiniReportManager.reportEventType(this.this$0.gameConfig, 1042, null, null, null, 0, "1", l4, null);
      MiniReportManager.reportEventType(this.this$0.gameConfig, 1043, null, null, null, 0, "1", l3, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onFirstFrameAppear] (首帧出现) cost time ", Long.valueOf(l1 - l2), "(from create surfaceView), ", Long.valueOf(l3), "(from onCreate) ", Long.valueOf(l4), " ms(from gameLaunched)" });
      this.this$0.runOnUiThread(new GameActivity.24.1(this));
      return;
      QLog.i("[minigame][start] ", 1, "game[" + this.this$0.gameConfig.config.appId + "][" + this.this$0.gameConfig.config.name + "] 热启动,二次启动游戏!");
      MiniReportManager.reportEventType(this.this$0.gameConfig, 1023, "1");
    }
  }
  
  public void onGameLaunched(long paramLong)
  {
    GameActivity.access$3602(this.this$0, System.currentTimeMillis());
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[launchGame] execJS success, cost time ", Long.valueOf(paramLong), ", ", Long.valueOf(GameActivity.access$3600(this.this$0) - GameActivity.access$2800(this.this$0)), "(from onCreate), ", Long.valueOf(GameActivity.access$3600(this.this$0) - GameActivity.access$3900(this.this$0)), "(from onResume)" });
    MiniReportManager.reportEventType(this.this$0.gameConfig, 1040, null, null, null, 0, "1", paramLong, null);
  }
  
  public void onInitFinish()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.val$begin;
    MiniReportManager.reportEventType(this.this$0.gameConfig, 1039, null, null, null, 0, "1", l2, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[create surfaceView] cost time ", Long.valueOf(l2), "(from create SurfaceView), " + (l1 - GameActivity.access$2800(this.this$0)) + "(from onCreate), include steps[create surfaceView, inject jssdk]" });
    this.this$0.startLoadGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.24
 * JD-Core Version:    0.7.0.1
 */