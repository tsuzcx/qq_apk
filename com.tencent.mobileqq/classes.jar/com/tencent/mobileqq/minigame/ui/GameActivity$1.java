package com.tencent.mobileqq.minigame.ui;

import android.os.Handler;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;

class GameActivity$1
  implements Runnable
{
  GameActivity$1(GameActivity paramGameActivity) {}
  
  public void onFPSChange(float paramFloat)
  {
    GameActivity.access$100(this.this$0).onGetFps(paramFloat);
    GameActivity.access$200(this.this$0).post(new GameActivity.1.1(this, paramFloat));
  }
  
  public void run()
  {
    TritonEngine localTritonEngine = GameActivity.access$000(this.this$0).getGameEngine();
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      onFPSChange(localTritonEngine.getStatisticsManager().getCurrentFPS());
    }
    ThreadPools.getMainThreadHandler().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.1
 * JD-Core Version:    0.7.0.1
 */