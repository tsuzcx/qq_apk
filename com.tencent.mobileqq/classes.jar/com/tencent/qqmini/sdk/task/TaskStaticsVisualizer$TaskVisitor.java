package com.tencent.qqmini.sdk.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "", "beginDependencies", "", "beginTask", "statics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "endDependencies", "endTask", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public abstract interface TaskStaticsVisualizer$TaskVisitor
{
  public abstract void beginDependencies();
  
  public abstract void beginTask(@NotNull TaskExecutionStatics paramTaskExecutionStatics);
  
  public abstract void endDependencies();
  
  public abstract void endTask();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
 * JD-Core Version:    0.7.0.1
 */