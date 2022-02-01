package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k=3, mv={1, 1, 16})
final class CommonPool$shutdown$2
  implements Executor
{
  public static final 2 INSTANCE = new 2();
  
  public final void execute(Runnable paramRunnable)
  {
    throw ((Throwable)new RejectedExecutionException("CommonPool was shutdown"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CommonPool.shutdown.2
 * JD-Core Version:    0.7.0.1
 */