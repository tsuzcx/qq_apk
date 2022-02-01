package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DelayKt
{
  @Nullable
  public static final Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (paramLong <= 0L) {
      return Unit.INSTANCE;
    }
    Object localObject = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localObject;
    getDelay(localCancellableContinuation.getContext()).scheduleResumeAfterDelay(paramLong, localCancellableContinuation);
    localObject = ((CancellableContinuationImpl)localObject).getResult();
    if (localObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject;
  }
  
  @NotNull
  public static final Delay getDelay(@NotNull CoroutineContext paramCoroutineContext)
  {
    CoroutineContext.Element localElement = paramCoroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key);
    paramCoroutineContext = localElement;
    if (!(localElement instanceof Delay)) {
      paramCoroutineContext = null;
    }
    paramCoroutineContext = (Delay)paramCoroutineContext;
    if (paramCoroutineContext != null) {
      return paramCoroutineContext;
    }
    return DefaultExecutorKt.getDefaultDelay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DelayKt
 * JD-Core Version:    0.7.0.1
 */