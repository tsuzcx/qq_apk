package com.tencent.qqmini.minigame.ui;

import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.jetbrains.annotations.NotNull;

class GameRuntimeStateObserver$6
  implements GetTraceInfoCallback
{
  GameRuntimeStateObserver$6(GameRuntimeStateObserver paramGameRuntimeStateObserver, boolean paramBoolean) {}
  
  public void onGetTraceInfo(@NotNull TraceStatistics paramTraceStatistics)
  {
    String str;
    if (GameRuntimeStateObserver.access$400(this.this$0) != null) {
      str = GameRuntimeStateObserver.access$400(this.this$0).appId;
    } else {
      str = "";
    }
    MiniGameBeaconReport.reportJankTraceRecords(paramTraceStatistics, str, true, this.val$isFirstFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.6
 * JD-Core Version:    0.7.0.1
 */