package com.tencent.mobileqq.minigame.ui;

import bkyr;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.api.QQMiniGameDataFileSystem;
import com.tencent.mobileqq.minigame.api.QQMiniGamePackage;
import com.tencent.mobileqq.minigame.debug.QQDebugWebSocket;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.mobileqq.triton.view.GameView.Companion;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GameActivity$35
  implements Runnable
{
  GameActivity$35(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$4902(this.this$0, System.currentTimeMillis());
    QLog.e("[minigame] GameActivity", 1, "start launchGame, execJS");
    GameActivity.access$100(this.this$0).recordInitialMemory();
    MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, this.this$0.mGameAppConfig);
    GameActivity.access$2900(this.this$0, 1);
    MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1007, "1");
    HashMap localHashMap = new HashMap();
    localHashMap.put(GameRuntimeLoader.class, GameActivity.access$000(this.this$0));
    TritonPlatform localTritonPlatform = GameActivity.access$000(this.this$0).getGamePlatform();
    if (localTritonPlatform != null)
    {
      QQMiniGamePackage localQQMiniGamePackage = GameActivity.access$5000(this.this$0);
      QQMiniGameDataFileSystem localQQMiniGameDataFileSystem = new QQMiniGameDataFileSystem();
      GameView localGameView = GameView.Companion.from(GameActivity.access$5100(this.this$0));
      QQDebugWebSocket localQQDebugWebSocket = GameActivity.access$5200(this.this$0);
      if (bkyr.b()) {}
      for (JankTraceLevel localJankTraceLevel = JankTraceLevel.BRIEF;; localJankTraceLevel = JankTraceLevel.NONE)
      {
        localTritonPlatform.launchGame(new GameLaunchParam(localQQMiniGamePackage, localQQMiniGameDataFileSystem, localGameView, localQQDebugWebSocket, localJankTraceLevel, localHashMap), new GameActivity.35.1(this));
        return;
      }
    }
    QLog.e("[minigame] GameActivity", 1, "launchGame execJS fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.35
 * JD-Core Version:    0.7.0.1
 */