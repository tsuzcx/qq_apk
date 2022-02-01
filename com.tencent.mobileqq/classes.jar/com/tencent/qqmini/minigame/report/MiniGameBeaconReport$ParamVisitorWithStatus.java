package com.tencent.qqmini.minigame.report;

import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamVisitorWithStatus;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
final class MiniGameBeaconReport$ParamVisitorWithStatus
  extends MiniGameBeaconReport.ExclusiveVisitor
{
  private final Map<String, String> a = (Map)new LinkedHashMap();
  
  @NotNull
  public final Map<String, String> a()
  {
    return this.a;
  }
  
  public void endTask()
  {
    MiniGameBeaconReport.ExclusiveVisitor localExclusiveVisitor = (MiniGameBeaconReport.ExclusiveVisitor)this;
    if (MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) != 0)
    {
      MiniGameBeaconReport.ExclusiveVisitor.access$setSkipLevel$p(localExclusiveVisitor, MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) - 1);
      return;
    }
    TaskExecutionStatics localTaskExecutionStatics = (TaskExecutionStatics)MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).get(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
    String str = MiniGameBeaconReport.access$getTaskName(MiniGameBeaconReport.INSTANCE, getStack());
    if ((((Collection)localTaskExecutionStatics.getSubSteps()).isEmpty() ^ true)) {
      this.a.put(str, String.valueOf(localTaskExecutionStatics.getTotalRunDurationMs()));
    }
    Map localMap = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_self");
    localMap.put(localStringBuilder.toString(), String.valueOf(localTaskExecutionStatics.getRunDurationMs()));
    localMap = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_stat");
    localMap.put(localStringBuilder.toString(), localTaskExecutionStatics.getStatus().name());
    MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.ParamVisitorWithStatus
 * JD-Core Version:    0.7.0.1
 */