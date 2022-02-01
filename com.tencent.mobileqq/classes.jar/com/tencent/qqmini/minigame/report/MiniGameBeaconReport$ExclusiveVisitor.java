package com.tencent.qqmini.minigame.report;

import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "()V", "excludedTaskNames", "", "", "skipLevel", "", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getStack", "()Ljava/util/List;", "beginDependencies", "", "beginTask", "statics", "endDependencies", "popTask", "block", "Lkotlin/Function1;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
abstract class MiniGameBeaconReport$ExclusiveVisitor
  implements TaskStaticsVisualizer.TaskVisitor
{
  private final Set<String> excludedTaskNames = SetsKt.setOf(new String[] { "GetInstalledEngine", "DownloadPlugin" });
  private int skipLevel;
  @NotNull
  private final List<TaskExecutionStatics> stack = (List)new ArrayList();
  
  public void beginDependencies() {}
  
  public void beginTask(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
    if ((this.skipLevel == 0) && (!this.excludedTaskNames.contains(paramTaskExecutionStatics.getName())))
    {
      this.stack.add(paramTaskExecutionStatics);
      return;
    }
    this.skipLevel += 1;
  }
  
  public void endDependencies() {}
  
  @NotNull
  protected final List<TaskExecutionStatics> getStack()
  {
    return this.stack;
  }
  
  protected final void popTask(@NotNull Function1<? super TaskExecutionStatics, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    if (access$getSkipLevel$p(this) != 0)
    {
      access$setSkipLevel$p(this, access$getSkipLevel$p(this) - 1);
      return;
    }
    paramFunction1.invoke(access$getStack$p(this).get(CollectionsKt.getLastIndex(access$getStack$p(this))));
    access$getStack$p(this).remove(CollectionsKt.getLastIndex(access$getStack$p(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.ExclusiveVisitor
 * JD-Core Version:    0.7.0.1
 */