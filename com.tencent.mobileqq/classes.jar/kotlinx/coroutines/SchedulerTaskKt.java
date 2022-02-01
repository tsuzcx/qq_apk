package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "Lkotlinx/coroutines/SchedulerTaskContext;", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "taskContext$annotations", "(Lkotlinx/coroutines/scheduling/Task;)V", "getTaskContext", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/TaskContext;", "afterTask", "", "SchedulerTask", "SchedulerTaskContext", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SchedulerTaskKt
{
  public static final void afterTask(@NotNull TaskContext paramTaskContext)
  {
    paramTaskContext.afterTask();
  }
  
  @NotNull
  public static final TaskContext getTaskContext(@NotNull Task paramTask)
  {
    return paramTask.taskContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.SchedulerTaskKt
 * JD-Core Version:    0.7.0.1
 */