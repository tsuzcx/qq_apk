package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/QQGameFrameReport;", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "appId", "", "(Ljava/lang/String;)V", "onFrameBegin", "", "frameTimeNanos", "", "firstFrame", "", "onFrameEnd", "frameDurationNanos", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQGameFrameReport
  implements FrameCallback
{
  private final String appId;
  
  public QQGameFrameReport(@NotNull String paramString)
  {
    this.appId = paramString;
  }
  
  public void onFrameBegin(long paramLong, boolean paramBoolean)
  {
    MiniProgramLpReportDC04902.reportGameStart(this.appId);
  }
  
  public void onFrameEnd(long paramLong1, long paramLong2)
  {
    MiniProgramLpReportDC04902.accumulateDrawFrameDuration(TimeUnit.NANOSECONDS.toMillis(paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.QQGameFrameReport
 * JD-Core Version:    0.7.0.1
 */