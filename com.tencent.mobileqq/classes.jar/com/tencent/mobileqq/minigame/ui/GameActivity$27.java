package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$27
  implements ITTEngine.IListener
{
  GameActivity$27(GameActivity paramGameActivity, long paramLong) {}
  
  public void onExit()
  {
    GameActivity.access$4900(this.this$0);
  }
  
  public void onFirstRender()
  {
    if (GameActivity.access$3600(this.this$0) == 2)
    {
      QLog.e("[minigame][timecost] ", 1, "onFirstRender() repeat call! something wrong!");
      return;
    }
    GameActivity.access$3700(this.this$0, 2);
    Object localObject = GameActivity.access$1300(this.this$0).getReportManager();
    ((GameReportManager)localObject).setAppConfig(this.this$0.mGameAppConfig);
    ((GameReportManager)localObject).onFirstFrame();
    long l1 = 0L;
    if (GameActivity.access$3800(this.this$0) > 0L) {
      l1 = System.currentTimeMillis() - GameActivity.access$3800(this.this$0);
    }
    MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 636, null, null, null, 0, "1", l1, null);
    MiniAppStartState.updateState(this.this$0.mGameAppConfig.config.appId, true);
    localObject = GameActivity.access$3900(this.this$0);
    if (GameActivity.access$4000(this.this$0))
    {
      GameActivity.access$4002(this.this$0, false);
      QLog.i("[minigame][start] ", 1, "game[" + this.this$0.mGameAppConfig.config.appId + "][" + this.this$0.mGameAppConfig.config.name + "] 冷启动，首帧出现!");
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1022, "1");
    }
    for (;;)
    {
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 21, "1");
      MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "show", "first_frame");
      MiniAppReportManager2.reportPageView("2launch", "first_frame", null, this.this$0.mGameAppConfig);
      GameActivity.access$4102(this.this$0, System.currentTimeMillis());
      GameActivity.access$4202(this.this$0, true);
      MiniGdtReporter.report(this.this$0.mGameAppConfig, 0);
      GameActivity.access$4302(this.this$0, System.currentTimeMillis());
      l1 = GameActivity.access$4300(this.this$0);
      long l2 = this.val$begin;
      long l3 = GameActivity.access$4300(this.this$0) - GameActivity.access$3400(this.this$0);
      long l4 = GameActivity.access$4300(this.this$0) - GameActivity.access$4400(this.this$0);
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1042, null, (String)localObject, null, 0, "1", l4, null);
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1043, null, (String)localObject, null, GameActivity.access$3500(this.this$0), "1", l3, null);
      AdFrequencyLimit.setOnStartTime(GameActivity.access$4300(this.this$0));
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onFirstFrameAppear] (首帧出现) cost time ", Long.valueOf(l1 - l2), "(from create surfaceView), ", Long.valueOf(l3), "(from onCreate) ", Long.valueOf(l4), " ms(from gameLaunched)" });
      this.this$0.runOnUiThread(new GameActivity.27.1(this));
      GameActivity.access$4700(this.this$0);
      return;
      QLog.i("[minigame][start] ", 1, "game[" + this.this$0.mGameAppConfig.config.appId + "][" + this.this$0.mGameAppConfig.config.name + "] 热启动,二次启动游戏!");
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1023, "1");
      JsApiUpdateManager.checkForUpdate(this.this$0.mGameAppConfig, GameActivity.access$1300(this.this$0).getJsPluginEngine());
    }
  }
  
  public void onGameLaunched(int paramInt, long paramLong)
  {
    this.this$0.notifyGameOnShow();
    Object localObject = this.this$0;
    int i;
    MiniAppConfig localMiniAppConfig;
    if (paramInt >= 0)
    {
      i = 0;
      GameActivity.access$3502((GameActivity)localObject, i);
      GameActivity.access$4402(this.this$0, System.currentTimeMillis());
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[launchGame] execJS success, cost time ", Long.valueOf(paramLong), ", ", Long.valueOf(GameActivity.access$4400(this.this$0) - GameActivity.access$3400(this.this$0)), "ms (from onCreate), ", Long.valueOf(GameActivity.access$4400(this.this$0) - GameActivity.access$4800(this.this$0)), "ms (from onResume), launchResult", Integer.valueOf(paramInt) });
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1040, null, GameActivity.access$3900(this.this$0), null, GameActivity.access$3500(this.this$0), "1", paramLong, null);
      MiniAppReportManager2.reportPageView("2load_end", this.this$0.getLaunchResult(), null, this.this$0.mGameAppConfig);
      if (GameActivity.access$3500(this.this$0) < 0) {
        break label256;
      }
      localMiniAppConfig = this.this$0.mGameAppConfig;
      if (!GameActivity.access$4000(this.this$0)) {
        break label248;
      }
    }
    label248:
    for (localObject = "1";; localObject = "0")
    {
      MiniReportManager.addCostTimeEventAttachInfo(localMiniAppConfig, 1008, (String)localObject);
      MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1008, "1");
      return;
      i = paramInt;
      break;
    }
    label256:
    MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "show_fail", "load_pkg_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.this$0.mGameAppConfig);
    MiniGdtReporter.report(this.this$0.mGameAppConfig, 512);
    MiniCacheFreeManager.freeCacheDialog(this.this$0, this.this$0.getCurrentAccountUin(), this.this$0.mGameAppConfig.config, GameWnsUtils.getGameLaunchFailContent());
  }
  
  public void onInitFinish()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.val$begin;
    MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1039, null, String.valueOf(GameActivity.access$3300(this.this$0)), null, 0, "1", l2, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[create surfaceView] cost time ", Long.valueOf(l2), "(from create SurfaceView), " + (l1 - GameActivity.access$3400(this.this$0)) + "(from onCreate), include steps[create surfaceView, inject jssdk]" });
    GameActivity.access$3502(this.this$0, 0);
    this.this$0.startLoadGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.27
 * JD-Core Version:    0.7.0.1
 */