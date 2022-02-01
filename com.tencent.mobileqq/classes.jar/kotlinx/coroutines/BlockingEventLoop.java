package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class BlockingEventLoop
  extends EventLoopImplBase
{
  @NotNull
  private final Thread thread;
  
  public BlockingEventLoop(@NotNull Thread paramThread)
  {
    this.thread = paramThread;
  }
  
  @NotNull
  protected Thread getThread()
  {
    return this.thread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.BlockingEventLoop
 * JD-Core Version:    0.7.0.1
 */