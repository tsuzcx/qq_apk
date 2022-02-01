package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ResumeUndispatchedRunnable
  implements Runnable
{
  private final CancellableContinuation<Unit> continuation;
  private final CoroutineDispatcher dispatcher;
  
  public ResumeUndispatchedRunnable(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    this.dispatcher = paramCoroutineDispatcher;
    this.continuation = paramCancellableContinuation;
  }
  
  public void run()
  {
    this.continuation.resumeUndispatched(this.dispatcher, Unit.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ResumeUndispatchedRunnable
 * JD-Core Version:    0.7.0.1
 */