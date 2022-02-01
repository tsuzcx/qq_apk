package com.tencent.qqmini.minigame;

import android.os.Handler;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;

class GameRuntime$1
  implements Runnable
{
  GameRuntime$1(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    if ((GameRuntime.access$000(this.this$0) != null) && (GameRuntime.access$000(this.this$0).getState() != EngineState.DESTROYED))
    {
      float f = GameRuntime.access$000(this.this$0).getStatisticsManager().getCurrentFPS();
      if (GameRuntime.access$100(this.this$0) != null) {
        GameRuntime.access$100(this.this$0).updateMonitorFPSText(f);
      }
    }
    ThreadPools.getMainThreadHandler().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.1
 * JD-Core Version:    0.7.0.1
 */