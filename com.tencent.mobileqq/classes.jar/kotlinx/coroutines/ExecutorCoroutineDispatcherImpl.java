package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ExecutorCoroutineDispatcherImpl
  extends ExecutorCoroutineDispatcherBase
{
  @NotNull
  private final Executor executor;
  
  public ExecutorCoroutineDispatcherImpl(@NotNull Executor paramExecutor)
  {
    this.executor = paramExecutor;
    initFutureCancellation$kotlinx_coroutines_core();
  }
  
  @NotNull
  public Executor getExecutor()
  {
    return this.executor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExecutorCoroutineDispatcherImpl
 * JD-Core Version:    0.7.0.1
 */