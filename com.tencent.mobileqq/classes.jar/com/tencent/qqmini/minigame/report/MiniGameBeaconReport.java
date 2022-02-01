package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport;", "", "()V", "BEACON_MAX_EVENT_NAME_LENGTH", "", "JANK_TRACE_TOP_RECORDS_COUNT", "getTaskName", "", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "report", "", "eventCode", "params", "", "reportJankTraceRecords", "statistics", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "appid", "isSdk", "", "isFirstFrame", "reportLaunchStatics", "statics", "ExclusiveVisitor", "ParamConfigVisitor", "ParamVisitor", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGameBeaconReport
{
  private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
  public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
  private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
  
  private final String getTaskName(List<TaskExecutionStatics> paramList)
  {
    paramList = CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"_", null, null, 0, null, (Function1)MiniGameBeaconReport.getTaskName.name.1.INSTANCE, 30, null);
    if (Intrinsics.areEqual(paramList, "root")) {
      paramList = "total";
    }
    int i;
    int j;
    for (;;)
    {
      localObject = paramList;
      if (paramList.length() <= 59) {
        break label127;
      }
      i = paramList.length();
      j = paramList.length();
      if (paramList != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      i = "root_".length();
      if (paramList == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramList = paramList.substring(i);
      Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.String).substring(startIndex)");
    }
    Object localObject = paramList.substring(i - 59, j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label127:
    return localObject;
  }
  
  @JvmStatic
  public static final void report(@NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null) {
      localChannelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, paramString, paramMap);
    }
  }
  
  @JvmStatic
  public static final void reportJankTraceRecords(@NotNull TraceStatistics paramTraceStatistics, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramTraceStatistics, "statistics");
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    ThreadManager.executeOnNetworkIOThreadPool((Runnable)new MiniGameBeaconReport.reportJankTraceRecords.1(paramTraceStatistics, paramBoolean1, paramString, paramBoolean2));
  }
  
  @JvmStatic
  public static final void reportLaunchStatics(@NotNull TaskExecutionStatics paramTaskExecutionStatics, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    MiniGameBeaconReport.ParamVisitor localParamVisitor = new MiniGameBeaconReport.ParamVisitor();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localParamVisitor).visitRootTask(paramTaskExecutionStatics);
    paramTaskExecutionStatics = MapsKt.toMutableMap(localParamVisitor.getParam());
    paramTaskExecutionStatics.put("is_sdk", String.valueOf(paramBoolean));
    paramTaskExecutionStatics.put("appid", paramString);
    paramTaskExecutionStatics.put("is_debug", String.valueOf(false));
    report("game_launch", paramTaskExecutionStatics);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport
 * JD-Core Version:    0.7.0.1
 */