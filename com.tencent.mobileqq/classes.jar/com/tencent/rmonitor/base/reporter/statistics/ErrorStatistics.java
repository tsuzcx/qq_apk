package com.tencent.rmonitor.base.reporter.statistics;

import com.tencent.rmonitor.base.db.BaseTable;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.table.StatisticsTable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.json.JsonDispose;
import com.tencent.rmonitor.common.json.JsonDispose.Companion;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/statistics/ErrorStatistics;", "", "()V", "TAG", "", "addLost", "", "plugin", "", "returnCode", "errorCode", "category", "doReport", "getLostData", "Lorg/json/JSONObject;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ErrorStatistics
{
  public static final ErrorStatistics a = new ErrorStatistics();
  
  private final JSONObject b()
  {
    Object localObject1 = new StatisticsTable(BaseInfo.userMeta.appId);
    Object localObject2 = BaseInfo.dbHelper;
    Object localObject3 = null;
    if (localObject2 != null)
    {
      localObject2 = ((DBHelper)localObject2).a();
      if (localObject2 != null)
      {
        localObject1 = ((DBHandler)localObject2).b((BaseTable)localObject1, (Function0)ErrorStatistics.getLostData.params.1.INSTANCE);
        break label53;
      }
    }
    localObject1 = null;
    label53:
    localObject2 = localObject1;
    if (!(localObject1 instanceof JSONObject)) {
      localObject2 = null;
    }
    localObject2 = (JSONObject)localObject2;
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (((JSONObject)localObject2).has("parts")) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public final void a()
  {
    JSONObject localJSONObject = b();
    if (localJSONObject != null)
    {
      localJSONObject.put("plugin", 146);
      ReportData localReportData = new ReportData(0, "Error", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      localReportData.setParams(JsonDispose.a.a(BaseInfo.pubJson, localJSONObject));
      ReporterMachine.a.a(localReportData, (IReporter.ReportCallback)new ErrorStatistics.doReport.1.1());
    }
  }
  
  public final void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "returnCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "errorCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "category");
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" report may be error, plugin : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", returnCode : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errorCode : ");
    localStringBuilder.append(paramString2);
    localLogger.w(new String[] { "RMonitor_base_ErrorStatistics", localStringBuilder.toString() });
    paramString1 = new StatisticsTable(BaseInfo.userMeta.appId, paramInt, paramString1, paramString2, paramString3, TimeUtil.b());
    paramString2 = BaseInfo.dbHelper;
    if (paramString2 != null)
    {
      paramString2 = paramString2.a();
      if (paramString2 != null) {
        paramString2.a((BaseTable)paramString1, (Function0)ErrorStatistics.addLost.1.INSTANCE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.statistics.ErrorStatistics
 * JD-Core Version:    0.7.0.1
 */