package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/Thread;", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, k=3, mv={1, 1, 16})
final class CommonPool$createPlainPool$1
  implements ThreadFactory
{
  CommonPool$createPlainPool$1(AtomicInteger paramAtomicInteger) {}
  
  @NotNull
  public final Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonPool-worker-");
    localStringBuilder.append(this.$threadId.incrementAndGet());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CommonPool.createPlainPool.1
 * JD-Core Version:    0.7.0.1
 */