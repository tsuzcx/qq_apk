package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ExecutorsKt
{
  @NotNull
  public static final Executor asExecutor(@NotNull CoroutineDispatcher paramCoroutineDispatcher)
  {
    if (!(paramCoroutineDispatcher instanceof ExecutorCoroutineDispatcher)) {
      localObject = null;
    } else {
      localObject = paramCoroutineDispatcher;
    }
    Object localObject = (ExecutorCoroutineDispatcher)localObject;
    if (localObject != null)
    {
      localObject = ((ExecutorCoroutineDispatcher)localObject).getExecutor();
      if (localObject != null) {
        return localObject;
      }
    }
    return (Executor)new DispatcherExecutor(paramCoroutineDispatcher);
  }
  
  @JvmName(name="from")
  @NotNull
  public static final CoroutineDispatcher from(@NotNull Executor paramExecutor)
  {
    if (!(paramExecutor instanceof DispatcherExecutor)) {
      localObject = null;
    } else {
      localObject = paramExecutor;
    }
    Object localObject = (DispatcherExecutor)localObject;
    if (localObject != null)
    {
      localObject = ((DispatcherExecutor)localObject).dispatcher;
      if (localObject != null) {
        return localObject;
      }
    }
    return (CoroutineDispatcher)new ExecutorCoroutineDispatcherImpl(paramExecutor);
  }
  
  @JvmName(name="from")
  @NotNull
  public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService paramExecutorService)
  {
    return (ExecutorCoroutineDispatcher)new ExecutorCoroutineDispatcherImpl((Executor)paramExecutorService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExecutorsKt
 * JD-Core Version:    0.7.0.1
 */