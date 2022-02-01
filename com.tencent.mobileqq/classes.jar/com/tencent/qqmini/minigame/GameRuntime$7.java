package com.tencent.qqmini.minigame;

import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class GameRuntime$7
  implements Runnable
{
  GameRuntime$7(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    GameRuntime.access$100(this.this$0).recordInitialMemory();
    SDKMiniProgramLpReportDC04239.reportPageView(GameRuntime.access$400(this.this$0), "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, GameRuntime.access$400(this.this$0));
    MiniReportManager.reportEventType(GameRuntime.access$400(this.this$0), 1007, "1");
    GameRuntime.access$800(this.this$0).launchGame(GameRuntime.access$500(this.this$0), new GameRuntime.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.7
 * JD-Core Version:    0.7.0.1
 */