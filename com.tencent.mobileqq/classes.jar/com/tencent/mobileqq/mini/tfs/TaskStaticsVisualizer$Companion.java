package com.tencent.mobileqq.mini.tfs;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/tfs/TaskStaticsVisualizer$Companion;", "", "()V", "visualizeToString", "", "task", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "tasks", "", "ToStringVisitor", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TaskStaticsVisualizer$Companion
{
  @JvmStatic
  @NotNull
  public final String visualizeToString(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "task");
    TaskStaticsVisualizer.Companion.ToStringVisitor localToStringVisitor = new TaskStaticsVisualizer.Companion.ToStringVisitor();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localToStringVisitor).visitRootTask(paramTaskExecutionStatics);
    return localToStringVisitor.build();
  }
  
  @JvmStatic
  @NotNull
  public final String visualizeToString(@NotNull List<TaskExecutionStatics> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tasks");
    if (paramList.size() == 1) {
      return ((Companion)this).visualizeToString((TaskExecutionStatics)paramList.get(0));
    }
    TaskStaticsVisualizer.Companion.ToStringVisitor localToStringVisitor = new TaskStaticsVisualizer.Companion.ToStringVisitor();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localToStringVisitor).visitTasks(paramList);
    return localToStringVisitor.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskStaticsVisualizer.Companion
 * JD-Core Version:    0.7.0.1
 */