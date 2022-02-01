package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport;", "", "()V", "BEACON_MAX_EVENT_NAME_LENGTH", "", "JANK_TRACE_TOP_RECORDS_COUNT", "TAG", "", "getCodeCacheUsingState", "gameLaunchStatistic", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "getTaskName", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "report", "", "eventCode", "params", "", "reportGameLaunchJsEventCost", "appid", "recordMap", "", "reportGameLoadCancelEvent", "statics", "stopType", "Lcom/tencent/qqmini/minigame/report/GameStopType;", "processState", "reportJankTraceRecords", "statistics", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "isSdk", "", "isFirstFrame", "reportLaunchStatics", "reportPreloadTime", "startTime", "receiveTime", "tritonInitTime", "ExclusiveVisitor", "ParamConfigVisitor", "ParamVisitor", "ParamVisitorWithStatus", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGameBeaconReport
{
  private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
  public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
  private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
  private static final String TAG = "MiniGameBeaconReport";
  
  private final String getCodeCacheUsingState(GameLaunchStatistic paramGameLaunchStatistic)
  {
    if (paramGameLaunchStatistic == null) {
      return "0";
    }
    Object localObject = TuplesKt.to("/game_preload/QGame.js", Integer.valueOf(1));
    int i = 0;
    localObject = MapsKt.mapOf(new Pair[] { localObject, TuplesKt.to("/game_preload/QGameOpenDataContext.js", Integer.valueOf(2)), TuplesKt.to("/game/game.js", Integer.valueOf(4)), TuplesKt.to("/game/subContext.js", Integer.valueOf(8)) });
    paramGameLaunchStatistic = CollectionsKt.union((Iterable)paramGameLaunchStatistic.getEngineInitStatistic().getEngineScriptLoadStatics(), (Iterable)paramGameLaunchStatistic.getGameScriptLoadStatics()).iterator();
    while (paramGameLaunchStatistic.hasNext())
    {
      ScriptLoadStatistic localScriptLoadStatistic = (ScriptLoadStatistic)paramGameLaunchStatistic.next();
      Integer localInteger = (Integer)((Map)localObject).get(localScriptLoadStatistic.getScriptName());
      if ((localInteger != null) && (localScriptLoadStatistic.getLoadResult() == ScriptLoadResult.SUCCESS_WITH_CACHE)) {
        i = localInteger.intValue() | i;
      }
    }
    paramGameLaunchStatistic = Integer.toBinaryString(i);
    Intrinsics.checkExpressionValueIsNotNull(paramGameLaunchStatistic, "Integer.toBinaryString(flagResult)");
    return paramGameLaunchStatistic;
  }
  
  private final String getTaskName(List<TaskExecutionStatics> paramList)
  {
    paramList = CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"_", null, null, 0, null, (Function1)MiniGameBeaconReport.getTaskName.name.1.INSTANCE, 30, null);
    if (Intrinsics.areEqual(paramList, "root"))
    {
      paramList = "total";
    }
    else
    {
      if (paramList == null) {
        break label110;
      }
      paramList = paramList.substring(5);
      Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.String).substring(startIndex)");
    }
    if (paramList.length() > 59)
    {
      int i = paramList.length();
      int j = paramList.length();
      if (paramList != null)
      {
        paramList = paramList.substring(i - 59, j);
        Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return paramList;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramList;
    label110:
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
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
  public static final void reportGameLoadCancelEvent(@NotNull String paramString, @NotNull TaskExecutionStatics paramTaskExecutionStatics, @Nullable GameLaunchStatistic paramGameLaunchStatistic, @NotNull GameStopType paramGameStopType, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
    Intrinsics.checkParameterIsNotNull(paramGameStopType, "stopType");
    ThreadManager.executeOnNetworkIOThreadPool((Runnable)new MiniGameBeaconReport.reportGameLoadCancelEvent.1(paramTaskExecutionStatics, paramString, paramGameLaunchStatistic, paramInt, paramGameStopType));
  }
  
  @JvmStatic
  public static final void reportJankTraceRecords(@NotNull TraceStatistics paramTraceStatistics, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramTraceStatistics, "statistics");
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    ThreadManager.executeOnNetworkIOThreadPool((Runnable)new MiniGameBeaconReport.reportJankTraceRecords.1(paramTraceStatistics, paramBoolean1, paramString, paramBoolean2));
  }
  
  @JvmStatic
  public static final void reportLaunchStatics(@NotNull String paramString, @NotNull TaskExecutionStatics paramTaskExecutionStatics, @Nullable GameLaunchStatistic paramGameLaunchStatistic, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
    MiniGameBeaconReport.ParamVisitor localParamVisitor = new MiniGameBeaconReport.ParamVisitor();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localParamVisitor).visitRootTask(paramTaskExecutionStatics);
    paramTaskExecutionStatics = MapsKt.toMutableMap(localParamVisitor.getParam());
    paramTaskExecutionStatics.put("is_sdk", String.valueOf(paramBoolean));
    paramTaskExecutionStatics.put("appid", paramString);
    paramTaskExecutionStatics.put("is_debug", String.valueOf(false));
    paramTaskExecutionStatics.put("cc_state", INSTANCE.getCodeCacheUsingState(paramGameLaunchStatistic));
    paramTaskExecutionStatics.put("process_state", String.valueOf(paramInt));
    paramString = new StringBuilder();
    paramString.append("launch_scene=");
    paramString.append(paramInt);
    QMLog.d("MiniGameBeaconReport", paramString.toString());
    report("game_launch", paramTaskExecutionStatics);
  }
  
  @JvmStatic
  public static final void reportPreloadTime(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = paramLong2 - paramLong1;
    paramLong2 = paramLong3 - paramLong2;
    if ((paramLong1 > 0L) && (paramLong2 > 0L))
    {
      report("game_preload", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("process_time", String.valueOf(paramLong1)), TuplesKt.to("triton_time", String.valueOf(paramLong2)), TuplesKt.to("is_debug", String.valueOf(false)) }));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportPreloadTime] processTime=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" engineTime=");
    localStringBuilder.append(paramLong2);
    QMLog.e("MiniGameBeaconReport", localStringBuilder.toString());
  }
  
  public final void reportGameLaunchJsEventCost(@NotNull String paramString, @NotNull Map<String, Long> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    Intrinsics.checkParameterIsNotNull(paramMap, "recordMap");
    ThreadManager.executeOnNetworkIOThreadPool((Runnable)new MiniGameBeaconReport.reportGameLaunchJsEventCost.1(paramMap, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport
 * JD-Core Version:    0.7.0.1
 */