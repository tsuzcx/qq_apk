package com.tencent.mobileqq.mini.tfs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/tfs/TaskStaticsVisualizer;", "", "visitor", "Lcom/tencent/mobileqq/mini/tfs/TaskStaticsVisualizer$TaskVisitor;", "(Lcom/tencent/mobileqq/mini/tfs/TaskStaticsVisualizer$TaskVisitor;)V", "visitRootTask", "", "root", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "visitTasks", "tasks", "", "Companion", "TaskVisitor", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TaskStaticsVisualizer
{
  public static final TaskStaticsVisualizer.Companion Companion = new TaskStaticsVisualizer.Companion(null);
  private final TaskStaticsVisualizer.TaskVisitor visitor;
  
  public TaskStaticsVisualizer(@NotNull TaskStaticsVisualizer.TaskVisitor paramTaskVisitor)
  {
    this.visitor = paramTaskVisitor;
  }
  
  @JvmStatic
  @NotNull
  public static final String visualizeToString(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    return Companion.visualizeToString(paramTaskExecutionStatics);
  }
  
  @JvmStatic
  @NotNull
  public static final String visualizeToString(@NotNull List<TaskExecutionStatics> paramList)
  {
    return Companion.visualizeToString(paramList);
  }
  
  public final void visitRootTask(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "root");
    this.visitor.beginTask(paramTaskExecutionStatics);
    int i;
    if (!((Collection)paramTaskExecutionStatics.getSubSteps()).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      this.visitor.beginDependencies();
      paramTaskExecutionStatics = ((Iterable)paramTaskExecutionStatics.getSubSteps()).iterator();
      for (;;)
      {
        if (paramTaskExecutionStatics.hasNext())
        {
          visitRootTask((TaskExecutionStatics)paramTaskExecutionStatics.next());
          continue;
          i = 0;
          break;
        }
      }
      this.visitor.endDependencies();
    }
    this.visitor.endTask();
  }
  
  public final void visitTasks(@NotNull List<TaskExecutionStatics> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tasks");
    Iterator localIterator = ((Iterable)paramList).iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((TaskExecutionStatics)localIterator.next()).getTotalRunDurationMs()) {}
    visitRootTask(new TaskExecutionStatics("root", 0L, l, TaskExecutionStatics.Status.SUCCESS, "", paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskStaticsVisualizer
 * JD-Core Version:    0.7.0.1
 */