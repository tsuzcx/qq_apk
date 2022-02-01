package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"}, k=1, mv={1, 1, 16})
final class LimitingDispatcher
  extends ExecutorCoroutineDispatcher
  implements Executor, TaskContext
{
  private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
  @NotNull
  private final ExperimentalCoroutineDispatcher dispatcher;
  private volatile int inFlightTasks;
  private final int parallelism;
  private final ConcurrentLinkedQueue<Runnable> queue;
  private final int taskMode;
  
  public LimitingDispatcher(@NotNull ExperimentalCoroutineDispatcher paramExperimentalCoroutineDispatcher, int paramInt1, int paramInt2)
  {
    this.dispatcher = paramExperimentalCoroutineDispatcher;
    this.parallelism = paramInt1;
    this.taskMode = paramInt2;
    this.queue = new ConcurrentLinkedQueue();
    this.inFlightTasks = 0;
  }
  
  private final void dispatch(Runnable paramRunnable, boolean paramBoolean)
  {
    do
    {
      if (inFlightTasks$FU.incrementAndGet(this) <= this.parallelism)
      {
        this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(paramRunnable, (TaskContext)this, paramBoolean);
        return;
      }
      this.queue.add(paramRunnable);
      if (inFlightTasks$FU.decrementAndGet(this) >= this.parallelism) {
        return;
      }
      paramRunnable = (Runnable)this.queue.poll();
    } while (paramRunnable != null);
  }
  
  public void afterTask()
  {
    Runnable localRunnable = (Runnable)this.queue.poll();
    if (localRunnable != null)
    {
      this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(localRunnable, (TaskContext)this, true);
      return;
    }
    inFlightTasks$FU.decrementAndGet(this);
    localRunnable = (Runnable)this.queue.poll();
    if (localRunnable != null) {
      dispatch(localRunnable, true);
    }
  }
  
  public void close()
  {
    throw ((Throwable)new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString()));
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    dispatch(paramRunnable, false);
  }
  
  public void dispatchYield(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    dispatch(paramRunnable, true);
  }
  
  public void execute(@NotNull Runnable paramRunnable)
  {
    dispatch(paramRunnable, false);
  }
  
  @NotNull
  public final ExperimentalCoroutineDispatcher getDispatcher()
  {
    return this.dispatcher;
  }
  
  @NotNull
  public Executor getExecutor()
  {
    return (Executor)this;
  }
  
  public final int getParallelism()
  {
    return this.parallelism;
  }
  
  public int getTaskMode()
  {
    return this.taskMode;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[dispatcher = ");
    localStringBuilder.append(this.dispatcher);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.LimitingDispatcher
 * JD-Core Version:    0.7.0.1
 */