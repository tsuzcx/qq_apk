package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ParamVisitor;", "Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class MiniGameBeaconReport$ParamVisitor
  extends MiniGameBeaconReport.ExclusiveVisitor
{
  private final Map<String, String> map = (Map)new LinkedHashMap();
  
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
    if (!((Collection)localTaskExecutionStatics.getSubSteps()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.map.put(str, String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getTotalRunDurationMs()));
      }
      this.map.put(str + "_self", String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getRunDurationMs()));
      MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
      return;
    }
  }
  
  @NotNull
  public final Map<String, String> getParam()
  {
    return this.map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.MiniGameBeaconReport.ParamVisitor
 * JD-Core Version:    0.7.0.1
 */