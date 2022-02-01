package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "", "getMode", "()I", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class Task
  implements Runnable
{
  @JvmField
  public long submissionTime;
  @JvmField
  @NotNull
  public TaskContext taskContext;
  
  public Task()
  {
    this(0L, (TaskContext)NonBlockingContext.INSTANCE);
  }
  
  public Task(long paramLong, @NotNull TaskContext paramTaskContext)
  {
    this.submissionTime = paramLong;
    this.taskContext = paramTaskContext;
  }
  
  public final int getMode()
  {
    return this.taskContext.getTaskMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.Task
 * JD-Core Version:    0.7.0.1
 */