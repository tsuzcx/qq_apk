package com.tencent.rmonitor.base.reporter.batch;

import android.os.Handler;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.table.ReportDataTable;
import com.tencent.rmonitor.base.db.table.ReportDataTable.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.IReportCache;
import com.tencent.rmonitor.base.reporter.IReporter;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/batch/ReportCacheImpl;", "Lcom/tencent/rmonitor/base/reporter/IReportCache;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "getHandler", "()Landroid/os/Handler;", "cacheReportData", "", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "getCollectDataDelay", "", "getReportErrorStatisticsDelay", "reportCacheData", "reporter", "Lcom/tencent/rmonitor/base/reporter/IReporter;", "updateCacheDataStatus", "dbId", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ReportCacheImpl
  implements IReportCache
{
  @NotNull
  private final Handler a;
  
  public ReportCacheImpl(@NotNull Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private final long a()
  {
    return 300000L;
  }
  
  private final long b()
  {
    return 60000L;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).a();
        if (localObject != null) {
          ((DBHandler)localObject).a(ReportDataTable.b.a(), paramInt, DBDataStatus.SENT.getValue());
        }
      }
    }
  }
  
  public void a(@NotNull IReporter paramIReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramIReporter, "reporter");
    paramIReporter = new CollectRecordDataRunnable(this.a, paramIReporter);
    this.a.postDelayed((Runnable)paramIReporter, a());
    this.a.postDelayed((Runnable)ReportCacheImpl.reportCacheData.1.a, b());
    this.a.postDelayed((Runnable)ReportCacheImpl.reportCacheData.2.a, 1000L);
    Logger.b.d(new String[] { "RMonitor_base_ReporterMachine", "reportCacheData" });
  }
  
  public void a(@NotNull ReportData paramReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramReportData, "reportData");
    this.a.post((Runnable)new StoreRecordDataRunnable(paramReportData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl
 * JD-Core Version:    0.7.0.1
 */