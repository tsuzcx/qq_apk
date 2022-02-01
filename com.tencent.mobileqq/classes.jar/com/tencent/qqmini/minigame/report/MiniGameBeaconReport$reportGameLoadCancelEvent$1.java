package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGameBeaconReport$reportGameLoadCancelEvent$1
  implements Runnable
{
  MiniGameBeaconReport$reportGameLoadCancelEvent$1(TaskExecutionStatics paramTaskExecutionStatics, String paramString, GameLaunchStatistic paramGameLaunchStatistic, int paramInt, GameStopType paramGameStopType) {}
  
  public final void run()
  {
    Object localObject = new MiniGameBeaconReport.ParamVisitorWithStatus();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localObject).visitRootTask(this.a);
    localObject = MapsKt.toMutableMap(((MiniGameBeaconReport.ParamVisitorWithStatus)localObject).a());
    ((Map)localObject).put("appid", this.b);
    ((Map)localObject).put("is_debug", String.valueOf(false));
    ((Map)localObject).put("cc_state", MiniGameBeaconReport.access$getCodeCacheUsingState(MiniGameBeaconReport.INSTANCE, this.c));
    ((Map)localObject).put("process_state", String.valueOf(this.d));
    ((Map)localObject).put("stop_type", String.valueOf(this.e.getReportValue()));
    MiniGameBeaconReport.report("game_load_cancel", (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.reportGameLoadCancelEvent.1
 * JD-Core Version:    0.7.0.1
 */