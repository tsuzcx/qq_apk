package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/PoolThread;", "Ljava/lang/Thread;", "dispatcher", "Lkotlinx/coroutines/ThreadPoolDispatcher;", "target", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "name", "", "(Lkotlinx/coroutines/ThreadPoolDispatcher;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class PoolThread
  extends Thread
{
  @JvmField
  @NotNull
  public final ThreadPoolDispatcher dispatcher;
  
  public PoolThread(@NotNull ThreadPoolDispatcher paramThreadPoolDispatcher, @NotNull Runnable paramRunnable, @NotNull String paramString)
  {
    super(paramRunnable, paramString);
    this.dispatcher = paramThreadPoolDispatcher;
    setDaemon(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.PoolThread
 * JD-Core Version:    0.7.0.1
 */