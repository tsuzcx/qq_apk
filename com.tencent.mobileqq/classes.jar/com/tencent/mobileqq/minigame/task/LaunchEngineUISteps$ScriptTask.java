package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/mobileqq/mini/tfs/BaseTask;", "(Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps;)V", "scriptDurationMs", "", "steps", "", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "getSteps", "()Ljava/util/List;", "setSteps", "(Ljava/util/List;)V", "wallDurationMs", "execute", "", "getRunDurationMs", "getSubTaskExecutionStatics", "getTotalRunDurationMs", "onTaskSucceed", "timeMs", "list", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
class LaunchEngineUISteps$ScriptTask
  extends BaseTask
{
  private long scriptDurationMs;
  @NotNull
  private List<TaskExecutionStatics> steps = CollectionsKt.emptyList();
  private long wallDurationMs;
  
  public LaunchEngineUISteps$ScriptTask()
  {
    super(LaunchEngineUISteps.access$getMContext$p(localLaunchEngineUISteps));
  }
  
  public void execute() {}
  
  public long getRunDurationMs()
  {
    return this.scriptDurationMs;
  }
  
  @NotNull
  protected final List<TaskExecutionStatics> getSteps()
  {
    return this.steps;
  }
  
  @NotNull
  public List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps;
  }
  
  public long getTotalRunDurationMs()
  {
    return this.wallDurationMs;
  }
  
  public final void onTaskSucceed(long paramLong, @NotNull List<ScriptLoadStatistic> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.wallDurationMs = paramLong;
    super.onTaskSucceed();
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      ScriptLoadStatistic localScriptLoadStatistic = (ScriptLoadStatistic)localIterator.next();
      this.scriptDurationMs += localScriptLoadStatistic.getCompileTimeMs() + localScriptLoadStatistic.getExecuteTimeMs();
      String str = localScriptLoadStatistic.getScriptName();
      paramLong = localScriptLoadStatistic.getCompileTimeMs();
      long l = localScriptLoadStatistic.getExecuteTimeMs();
      if (localScriptLoadStatistic.getLoadResult() == ScriptLoadResult.SUCCESS_WITH_CACHE) {}
      for (paramList = "cc";; paramList = "")
      {
        localCollection.add(new TaskExecutionStatics(str, 0L, paramLong + l, null, paramList, CollectionsKt.listOf(new TaskExecutionStatics[] { new TaskExecutionStatics("compile", localScriptLoadStatistic.getCompileTimeMs(), 0L, null, null, null, 60, null), new TaskExecutionStatics("execute", localScriptLoadStatistic.getExecuteTimeMs(), 0L, null, null, null, 60, null) }), 8, null));
        break;
      }
    }
    this.steps = ((List)localCollection);
  }
  
  protected final void setSteps(@NotNull List<TaskExecutionStatics> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.steps = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.LaunchEngineUISteps.ScriptTask
 * JD-Core Version:    0.7.0.1
 */