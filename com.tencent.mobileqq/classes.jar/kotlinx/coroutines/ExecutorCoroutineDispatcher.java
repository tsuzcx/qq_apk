package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class ExecutorCoroutineDispatcher
  extends CoroutineDispatcher
  implements Closeable
{
  public static final ExecutorCoroutineDispatcher.Key Key = new ExecutorCoroutineDispatcher.Key(null);
  
  public abstract void close();
  
  @NotNull
  public abstract Executor getExecutor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExecutorCoroutineDispatcher
 * JD-Core Version:    0.7.0.1
 */