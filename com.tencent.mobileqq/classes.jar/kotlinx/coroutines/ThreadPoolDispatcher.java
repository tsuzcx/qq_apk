package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "nThreads", "", "name", "", "(ILjava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "threadNo", "Ljava/util/concurrent/atomic/AtomicInteger;", "close", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ThreadPoolDispatcher
  extends ExecutorCoroutineDispatcherBase
{
  @NotNull
  private final Executor executor;
  private final int nThreads;
  private final String name;
  private final AtomicInteger threadNo;
  
  public ThreadPoolDispatcher(int paramInt, @NotNull String paramString)
  {
    this.nThreads = paramInt;
    this.name = paramString;
    this.threadNo = new AtomicInteger();
    this.executor = ((Executor)Executors.newScheduledThreadPool(this.nThreads, (ThreadFactory)new ThreadPoolDispatcher.executor.1(this)));
    initFutureCancellation$kotlinx_coroutines_core();
  }
  
  public void close()
  {
    Executor localExecutor = getExecutor();
    if (localExecutor != null)
    {
      ((ExecutorService)localExecutor).shutdown();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
  }
  
  @NotNull
  public Executor getExecutor()
  {
    return this.executor;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThreadPoolDispatcher[");
    localStringBuilder.append(this.nThreads);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.name);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadPoolDispatcher
 * JD-Core Version:    0.7.0.1
 */