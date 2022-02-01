package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import org.jetbrains.annotations.NotNull;

class GameActivity$30
  implements GetTraceInfoCallback
{
  GameActivity$30(GameActivity paramGameActivity, boolean paramBoolean) {}
  
  public void onGetTraceInfo(@NotNull TraceStatistics paramTraceStatistics)
  {
    MiniGameBeaconReport.reportJankTraceRecords(paramTraceStatistics, this.this$0.mGameAppConfig.config.appId, false, this.val$isFirstFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.30
 * JD-Core Version:    0.7.0.1
 */