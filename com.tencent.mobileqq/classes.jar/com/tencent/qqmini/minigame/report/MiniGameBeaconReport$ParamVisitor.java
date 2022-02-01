package com.tencent.qqmini.minigame.report;

import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
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
    Object localObject = (TaskExecutionStatics)MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).get(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
    String str = MiniGameBeaconReport.access$getTaskName(MiniGameBeaconReport.INSTANCE, getStack());
    if ((((Collection)((TaskExecutionStatics)localObject).getSubSteps()).isEmpty() ^ true)) {
      this.map.put(str, String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getTotalRunDurationMs()));
    }
    localObject = this.map;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_self");
    ((Map)localObject).put(localStringBuilder.toString(), String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getRunDurationMs()));
    MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
  }
  
  @NotNull
  public final Map<String, String> getParam()
  {
    return this.map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.ParamVisitor
 * JD-Core Version:    0.7.0.1
 */