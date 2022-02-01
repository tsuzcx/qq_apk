package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class EventLoopImplBase$DelayedResumeTask
  extends EventLoopImplBase.DelayedTask
{
  private final CancellableContinuation<Unit> cont;
  
  public EventLoopImplBase$DelayedResumeTask(long paramLong, CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    super(???);
    Object localObject;
    this.cont = localObject;
  }
  
  public void run()
  {
    this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(this.cont.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplBase.DelayedResumeTask
 * JD-Core Version:    0.7.0.1
 */