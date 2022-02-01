package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/PoolThread;", "target", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, k=3, mv={1, 1, 16})
final class ThreadPoolDispatcher$executor$1
  implements ThreadFactory
{
  ThreadPoolDispatcher$executor$1(ThreadPoolDispatcher paramThreadPoolDispatcher) {}
  
  @NotNull
  public final PoolThread newThread(Runnable paramRunnable)
  {
    ThreadPoolDispatcher localThreadPoolDispatcher = this.this$0;
    Object localObject;
    if (ThreadPoolDispatcher.access$getNThreads$p(localThreadPoolDispatcher) == 1)
    {
      localObject = ThreadPoolDispatcher.access$getName$p(this.this$0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ThreadPoolDispatcher.access$getName$p(this.this$0));
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(ThreadPoolDispatcher.access$getThreadNo$p(this.this$0).incrementAndGet());
      localObject = ((StringBuilder)localObject).toString();
    }
    return new PoolThread(localThreadPoolDispatcher, paramRunnable, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadPoolDispatcher.executor.1
 * JD-Core Version:    0.7.0.1
 */