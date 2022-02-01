package com.tencent.qqmini.minigame.task;

import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$InitEngine;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "getName", "", "onTaskSucceed", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "effectivelyInitEngineTime", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
final class LaunchEngineUISteps$InitEngine
  extends LaunchEngineUISteps.ScriptTask
{
  public LaunchEngineUISteps$InitEngine()
  {
    super(localLaunchEngineUISteps);
  }
  
  @NotNull
  public String getName()
  {
    return "InitEngine";
  }
  
  public final void onTaskSucceed(@NotNull EngineInitStatistic paramEngineInitStatistic, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineInitStatistic, "statics");
    super.onTaskSucceed(paramLong, paramEngineInitStatistic.getEngineScriptLoadStatics());
    List localList = CollectionsKt.toMutableList((Collection)getSteps());
    localList.add(0, new TaskExecutionStatics("LoadSo", paramEngineInitStatistic.getLoadNativeLibraryTimeMs(), 0L, null, null, null, 60, null));
    localList.add(localList.size(), new TaskExecutionStatics("EGL", paramEngineInitStatistic.getCreateEGLContextTimeMs(), 0L, TaskExecutionStatics.Status.CACHED, null, null, 52, null));
    setSteps(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.LaunchEngineUISteps.InitEngine
 * JD-Core Version:    0.7.0.1
 */