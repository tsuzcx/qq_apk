package com.tencent.qqmini.minigame.report;

import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamConfigVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "config", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paramConfig", "", "getParamConfig", "()Ljava/lang/String;", "endTask", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
final class MiniGameBeaconReport$ParamConfigVisitor
  extends MiniGameBeaconReport.ExclusiveVisitor
{
  private final StringBuilder config = new StringBuilder();
  
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
    StringBuilder localStringBuilder = this.config;
    if ((((Collection)((TaskExecutionStatics)localObject).getSubSteps()).isEmpty() ^ true))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("game_launch 启动步骤 ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(' ');
      ((StringBuilder)localObject).append(((TaskExecutionStatics)CollectionsKt.last(getStack())).getName());
      ((StringBuilder)localObject).append("步骤总耗时 bigint");
      localStringBuilder.append(((StringBuilder)localObject).toString());
      localStringBuilder.append("\n");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("game_launch 启动步骤 ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_self ");
    ((StringBuilder)localObject).append(((TaskExecutionStatics)CollectionsKt.last(getStack())).getName());
    ((StringBuilder)localObject).append("步骤自身耗时 bigint");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append("\n");
    MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
  }
  
  @NotNull
  public final String getParamConfig()
  {
    String str = this.config.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "config.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.ParamConfigVisitor
 * JD-Core Version:    0.7.0.1
 */