package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.FrameCallback;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/GameFrameReport;", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "appId", "", "(Ljava/lang/String;)V", "onFrameBegin", "", "frameTimeNanos", "", "firstFrame", "", "onFrameEnd", "frameDurationNanos", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameFrameReport
  implements FrameCallback
{
  private final String appId;
  
  public GameFrameReport(@NotNull String paramString)
  {
    this.appId = paramString;
  }
  
  public void onFrameBegin(long paramLong, boolean paramBoolean)
  {
    MiniProgramLpReportDC04902.reportGameStart(this.appId);
    MiniProgramLpReportDC04902.updateDisplayFrameTime(paramLong, paramBoolean);
  }
  
  public void onFrameEnd(long paramLong1, long paramLong2)
  {
    MiniProgramLpReportDC04902.accumulateDrawFrameDuration(TimeUnit.NANOSECONDS.toMillis(paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.GameFrameReport
 * JD-Core Version:    0.7.0.1
 */