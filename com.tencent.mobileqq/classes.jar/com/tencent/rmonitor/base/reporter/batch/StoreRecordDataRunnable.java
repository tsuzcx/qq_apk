package com.tencent.rmonitor.base.reporter.batch;

import android.content.Context;
import com.tencent.rmonitor.base.db.BaseTable;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.table.ReportDataTable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.AppInfo.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/batch/StoreRecordDataRunnable;", "Ljava/lang/Runnable;", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "(Lcom/tencent/rmonitor/base/reporter/data/ReportData;)V", "run", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class StoreRecordDataRunnable
  implements Runnable
{
  private final ReportData a;
  
  public StoreRecordDataRunnable(@NotNull ReportData paramReportData)
  {
    this.a = paramReportData;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).a();
      if (localObject != null)
      {
        String str1 = BaseInfo.userMeta.appId;
        String str2 = AppInfo.a.a((Context)BaseInfo.app);
        String str3 = BaseInfo.userMeta.version;
        String str4 = this.a.getUin();
        String str5 = this.a.getParams().toString();
        Intrinsics.checkExpressionValueIsNotNull(str5, "reportData.params.toString()");
        ((DBHandler)localObject).a((BaseTable)new ReportDataTable(str1, str2, str3, str4, str5, this.a.isRealTime(), l), (Function0)StoreRecordDataRunnable.run.1.INSTANCE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.StoreRecordDataRunnable
 * JD-Core Version:    0.7.0.1
 */