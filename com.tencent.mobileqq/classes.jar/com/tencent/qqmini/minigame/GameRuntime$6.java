package com.tencent.qqmini.minigame;

import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.mobileqq.triton.sdk.game.GameLaunchParam.Builder;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class GameRuntime$6
  implements Runnable
{
  GameRuntime$6(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    GameRuntime.access$000(this.this$0).recordInitialMemory();
    SDKMiniProgramLpReportDC04239.reportPageView(GameRuntime.access$300(this.this$0), "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, GameRuntime.access$300(this.this$0));
    MiniReportManager.reportEventType(GameRuntime.access$300(this.this$0), 1007, "1");
    if (GameRuntime.access$400(this.this$0)) {
      GameRuntime.access$500(this.this$0).setJankTraceLevel(JankTraceLevel.BRIEF);
    }
    GameRuntime.access$500(this.this$0).getGameLauncher().launchGame(new GameLaunchParam.Builder().setGameInfo(GameRuntime.access$100(this.this$0).getGameInfo()).setGameLaunchCallback(new GameRuntime.6.1(this)).build());
    GameRuntime.access$500(this.this$0).setEngineListener(new GameRuntime.6.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.6
 * JD-Core Version:    0.7.0.1
 */