package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/GameSubpackageReport;", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "()V", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameSubpackageReport
  implements SubpackageLoadStatisticsCallback
{
  public static final GameSubpackageReport.Companion Companion = new GameSubpackageReport.Companion(null);
  private static final int MINI_GAME_LOAD_SUB_PKG = 1009;
  private static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
  private static final String TAG = "GameSubpackageReport";
  
  public void onSubpackageLoaded(@NotNull String paramString, @NotNull ScriptLoadStatistic paramScriptLoadStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramScriptLoadStatistic, "statistic");
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 1009, System.currentTimeMillis() - (paramScriptLoadStatistic.getReadTimeMs() + paramScriptLoadStatistic.getReadCodeCacheTimeMs() + paramScriptLoadStatistic.getCompileTimeMs() + paramScriptLoadStatistic.getExecuteTimeMs()), null, null, null, 0, "1", 0L, null, null, null, null, null);
    if (paramScriptLoadStatistic.getLoadResult().isSuccess())
    {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 1010, null, "1");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load subpackage failed ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramScriptLoadStatistic);
      QMLog.e("GameSubpackageReport", localStringBuilder.toString());
    }
    paramScriptLoadStatistic.getLoadResult();
    paramString = ScriptLoadResult.FAIL_COMPILE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.GameSubpackageReport
 * JD-Core Version:    0.7.0.1
 */