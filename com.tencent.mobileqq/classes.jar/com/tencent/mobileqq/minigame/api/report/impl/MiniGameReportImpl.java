package com.tencent.mobileqq.minigame.api.report.impl;

import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.minigame.report.MiniGameLebaReporter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/report/impl/MiniGameReportImpl;", "Lcom/tencent/mobileqq/minigame/api/report/IMiniGameReport;", "()V", "clickReportMiniGameFromLeba", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "exposeReportMiniGameFromLeba", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGameReportImpl
  implements IMiniGameReport
{
  public void clickReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    MiniGameLebaReporter.INSTANCE.reportFromLeba(paramAppInfo, true);
  }
  
  public void exposeReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    MiniGameLebaReporter.INSTANCE.reportFromLeba(paramAppInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.report.impl.MiniGameReportImpl
 * JD-Core Version:    0.7.0.1
 */