package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class EventLoopImplBase$DelayedRunnableTask
  extends EventLoopImplBase.DelayedTask
{
  private final Runnable block;
  
  public EventLoopImplBase$DelayedRunnableTask(long paramLong, @NotNull Runnable paramRunnable)
  {
    super(paramLong);
    this.block = paramRunnable;
  }
  
  public void run()
  {
    this.block.run();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(this.block.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplBase.DelayedRunnableTask
 * JD-Core Version:    0.7.0.1
 */