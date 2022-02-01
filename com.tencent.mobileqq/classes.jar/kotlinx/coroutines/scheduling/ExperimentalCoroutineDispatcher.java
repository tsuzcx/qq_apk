package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public class ExperimentalCoroutineDispatcher
  extends ExecutorCoroutineDispatcher
{
  private final int corePoolSize;
  private CoroutineScheduler coroutineScheduler;
  private final long idleWorkerKeepAliveNs;
  private final int maxPoolSize;
  private final String schedulerName;
  
  public ExperimentalCoroutineDispatcher(int paramInt1, int paramInt2, long paramLong, @NotNull String paramString)
  {
    this.corePoolSize = paramInt1;
    this.maxPoolSize = paramInt2;
    this.idleWorkerKeepAliveNs = paramLong;
    this.schedulerName = paramString;
    this.coroutineScheduler = createScheduler();
  }
  
  public ExperimentalCoroutineDispatcher(int paramInt1, int paramInt2, @NotNull String paramString)
  {
    this(paramInt1, paramInt2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, paramString);
  }
  
  private final CoroutineScheduler createScheduler()
  {
    return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
  }
  
  @NotNull
  public final CoroutineDispatcher blocking(int paramInt)
  {
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (CoroutineDispatcher)new LimitingDispatcher(this, paramInt, 1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected positive parallelism level, but have ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public void close()
  {
    this.coroutineScheduler.close();
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    try
    {
      CoroutineScheduler.dispatch$default(this.coroutineScheduler, paramRunnable, null, false, 6, null);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      label14:
      break label14;
    }
    DefaultExecutor.INSTANCE.dispatch(paramCoroutineContext, paramRunnable);
  }
  
  public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable paramRunnable, @NotNull TaskContext paramTaskContext, boolean paramBoolean)
  {
    try
    {
      this.coroutineScheduler.dispatch(paramRunnable, paramTaskContext, paramBoolean);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      label11:
      break label11;
    }
    DefaultExecutor.INSTANCE.enqueue((Runnable)this.coroutineScheduler.createTask$kotlinx_coroutines_core(paramRunnable, paramTaskContext));
  }
  
  public void dispatchYield(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    try
    {
      CoroutineScheduler.dispatch$default(this.coroutineScheduler, paramRunnable, null, true, 2, null);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      label13:
      break label13;
    }
    DefaultExecutor.INSTANCE.dispatchYield(paramCoroutineContext, paramRunnable);
  }
  
  @NotNull
  public Executor getExecutor()
  {
    return (Executor)this.coroutineScheduler;
  }
  
  @NotNull
  public final CoroutineDispatcher limited(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt <= this.corePoolSize) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return (CoroutineDispatcher)new LimitingDispatcher(this, paramInt, 0);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected parallelism level lesser than core pool size (");
      localStringBuilder.append(this.corePoolSize);
      localStringBuilder.append("), but have ");
      localStringBuilder.append(paramInt);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected positive parallelism level, but have ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public final void restore$kotlinx_coroutines_core()
  {
    usePrivateScheduler$kotlinx_coroutines_core();
  }
  
  public final void shutdown$kotlinx_coroutines_core(long paramLong)
  {
    try
    {
      this.coroutineScheduler.shutdown(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[scheduler = ");
    localStringBuilder.append(this.coroutineScheduler);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void usePrivateScheduler$kotlinx_coroutines_core()
  {
    try
    {
      this.coroutineScheduler.shutdown(1000L);
      this.coroutineScheduler = createScheduler();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher
 * JD-Core Version:    0.7.0.1
 */