package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class Delay$DefaultImpls
{
  @Nullable
  public static Object delay(Delay paramDelay, long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (paramLong <= 0L) {
      return Unit.INSTANCE;
    }
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    paramDelay.scheduleResumeAfterDelay(paramLong, (CancellableContinuation)localCancellableContinuationImpl);
    paramDelay = localCancellableContinuationImpl.getResult();
    if (paramDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramDelay;
  }
  
  @NotNull
  public static DisposableHandle invokeOnTimeout(Delay paramDelay, long paramLong, @NotNull Runnable paramRunnable)
  {
    return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(paramLong, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Delay.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */