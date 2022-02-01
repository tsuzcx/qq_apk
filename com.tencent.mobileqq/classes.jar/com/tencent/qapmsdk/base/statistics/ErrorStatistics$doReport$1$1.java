package com.tencent.qapmsdk.base.statistics;

import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qapmsdk/base/statistics/ErrorStatistics$doReport$1$1", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "successCode", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ErrorStatistics$doReport$1$1
  implements IReporter.ReportResultCallback
{
  public void onFailure(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Logger.INSTANCE.e(new String[] { "QAPM_base_ErrorStatistics", "report lost data may be error" });
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_base_ErrorStatistics", "lost data send success, delete database" });
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).getDbHandler();
      if (localObject != null) {
        ((DBHandler)localObject).delete("error_statistics", "p_id=?", new String[] { String.valueOf(BaseInfo.userMeta.appId) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.statistics.ErrorStatistics.doReport.1.1
 * JD-Core Version:    0.7.0.1
 */