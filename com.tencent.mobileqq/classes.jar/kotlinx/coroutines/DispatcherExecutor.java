package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DispatcherExecutor;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class DispatcherExecutor
  implements Executor
{
  @JvmField
  @NotNull
  public final CoroutineDispatcher dispatcher;
  
  public DispatcherExecutor(@NotNull CoroutineDispatcher paramCoroutineDispatcher)
  {
    this.dispatcher = paramCoroutineDispatcher;
  }
  
  public void execute(@NotNull Runnable paramRunnable)
  {
    this.dispatcher.dispatch((CoroutineContext)EmptyCoroutineContext.INSTANCE, paramRunnable);
  }
  
  @NotNull
  public String toString()
  {
    return this.dispatcher.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatcherExecutor
 * JD-Core Version:    0.7.0.1
 */