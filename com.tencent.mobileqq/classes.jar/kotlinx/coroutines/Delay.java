package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract interface Delay
{
  @Nullable
  public abstract Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation);
  
  @NotNull
  public abstract DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable);
  
  public abstract void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Delay
 * JD-Core Version:    0.7.0.1
 */