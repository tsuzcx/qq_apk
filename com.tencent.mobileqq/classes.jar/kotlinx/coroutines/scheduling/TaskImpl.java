package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class TaskImpl
  extends Task
{
  @JvmField
  @NotNull
  public final Runnable block;
  
  public TaskImpl(@NotNull Runnable paramRunnable, long paramLong, @NotNull TaskContext paramTaskContext)
  {
    super(paramLong, paramTaskContext);
    this.block = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      this.block.run();
      return;
    }
    finally
    {
      this.taskContext.afterTask();
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task[");
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this.block));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this.block));
    localStringBuilder.append(", ");
    localStringBuilder.append(this.submissionTime);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.taskContext);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.TaskImpl
 * JD-Core Version:    0.7.0.1
 */