package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/QQGameSubpackageReport;", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "()V", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class QQGameSubpackageReport
  implements SubpackageLoadStatisticsCallback
{
  public static final QQGameSubpackageReport.Companion Companion = new QQGameSubpackageReport.Companion(null);
  private static final int MINI_GAME_LOAD_SUB_PKG = 1009;
  private static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
  private static final String TAG = "GameSubpackageReport";
  
  public void onSubpackageLoaded(@NotNull String paramString, @NotNull ScriptLoadStatistic paramScriptLoadStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramScriptLoadStatistic, "statistic");
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1009, null, null, null, 0, "1", 0L, System.currentTimeMillis() - (paramScriptLoadStatistic.getReadTimeMs() + paramScriptLoadStatistic.getReadCodeCacheTimeMs() + paramScriptLoadStatistic.getCompileTimeMs() + paramScriptLoadStatistic.getExecuteTimeMs()), null, null, null, null, null);
    if (paramScriptLoadStatistic.getLoadResult().isSuccess()) {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1010, null, "1");
    }
    for (;;)
    {
      if (paramScriptLoadStatistic.getLoadResult() == ScriptLoadResult.FAIL_COMPILE) {}
      return;
      GameLog.getInstance().e("GameSubpackageReport", "load subpackage failed " + paramString + ' ' + paramScriptLoadStatistic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.QQGameSubpackageReport
 * JD-Core Version:    0.7.0.1
 */