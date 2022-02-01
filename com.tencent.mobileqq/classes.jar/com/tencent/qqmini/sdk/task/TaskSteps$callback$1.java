package com.tencent.qqmini.sdk.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/sdk/task/TaskSteps$callback$1", "Lcom/tencent/qqmini/sdk/task/BaseTask$Callback;", "onTaskBegin", "", "task", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "onTaskEnd", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public final class TaskSteps$callback$1
  implements BaseTask.Callback
{
  public void onTaskBegin(@NotNull BaseTask paramBaseTask)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTask, "task");
  }
  
  public void onTaskEnd(@NotNull BaseTask paramBaseTask)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTask, "task");
    TaskSteps.access$onStepDone(this.this$0, paramBaseTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskSteps.callback.1
 * JD-Core Version:    0.7.0.1
 */