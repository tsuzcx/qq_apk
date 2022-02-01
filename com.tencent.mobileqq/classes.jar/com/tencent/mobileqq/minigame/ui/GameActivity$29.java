package com.tencent.mobileqq.minigame.ui;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics;

class GameActivity$29
  implements ITTEngine.OnGetTraceRecordCallback
{
  GameActivity$29(GameActivity paramGameActivity, boolean paramBoolean) {}
  
  public void onGetTraceRecord(@NonNull TraceStatistics paramTraceStatistics)
  {
    MiniGameBeaconReport.reportJankTraceRecords(paramTraceStatistics, this.this$0.mGameAppConfig.config.appId, false, this.val$isFirstFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.29
 * JD-Core Version:    0.7.0.1
 */