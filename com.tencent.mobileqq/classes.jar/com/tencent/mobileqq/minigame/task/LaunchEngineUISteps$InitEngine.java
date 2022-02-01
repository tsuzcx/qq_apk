package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics.Status;
import com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps$InitEngine;", "Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps;)V", "getName", "", "onTaskSucceed", "", "statics", "Lcom/tencent/mobileqq/triton/sdk/statics/EngineInitStatistic;", "effectivelyInitEngineTime", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    List localList = paramEngineInitStatistic.engineScriptLoadStatics;
    Intrinsics.checkExpressionValueIsNotNull(localList, "statics.engineScriptLoadStatics");
    super.onTaskSucceed(paramLong, localList);
    localList = CollectionsKt.toMutableList((Collection)getSteps());
    localList.add(0, new TaskExecutionStatics("LoadSo", paramEngineInitStatistic.loadNativeLibraryTimeMs, 0L, null, null, null, 60, null));
    localList.add(localList.size(), new TaskExecutionStatics("EGL", paramEngineInitStatistic.createEGLContextTimeMs, 0L, TaskExecutionStatics.Status.CACHED, null, null, 52, null));
    setSteps(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.LaunchEngineUISteps.InitEngine
 * JD-Core Version:    0.7.0.1
 */