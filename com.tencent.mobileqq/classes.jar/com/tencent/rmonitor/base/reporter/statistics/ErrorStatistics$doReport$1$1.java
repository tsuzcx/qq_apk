package com.tencent.rmonitor.base.reporter.statistics;

import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.table.StatisticsTable;
import com.tencent.rmonitor.base.db.table.StatisticsTable.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback.DefaultImpls;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/rmonitor/base/reporter/statistics/ErrorStatistics$doReport$1$1", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ErrorStatistics$doReport$1$1
  implements IReporter.ReportCallback
{
  public void a()
  {
    IReporter.ReportCallback.DefaultImpls.a(this);
  }
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Logger.b.e(new String[] { "RMonitor_base_ErrorStatistics", "report lost data may be error" });
  }
  
  public void t_(int paramInt)
  {
    Logger.b.i(new String[] { "RMonitor_base_ErrorStatistics", "lost data send success, delete database" });
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).a();
      if (localObject != null) {
        ((DBHandler)localObject).a(StatisticsTable.b.a(), "p_id=?", new String[] { BaseInfo.userMeta.appId });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.statistics.ErrorStatistics.doReport.1.1
 * JD-Core Version:    0.7.0.1
 */