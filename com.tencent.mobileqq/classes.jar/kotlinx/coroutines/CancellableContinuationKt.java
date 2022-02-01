package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendAtomicCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "holdCancellability", "", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendAtomicCancellableCoroutineReusable", "suspendCancellableCoroutine", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CancellableContinuationKt
{
  @InternalCoroutinesApi
  public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> paramCancellableContinuation, @NotNull DisposableHandle paramDisposableHandle)
  {
    paramCancellableContinuation.invokeOnCancellation((Function1)new DisposeOnCancel(paramDisposableHandle));
  }
  
  @NotNull
  public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    if (!(paramContinuation instanceof DispatchedContinuation)) {
      return new CancellableContinuationImpl(paramContinuation, 0);
    }
    CancellableContinuationImpl localCancellableContinuationImpl = ((DispatchedContinuation)paramContinuation).claimReusableCancellableContinuation();
    if (localCancellableContinuationImpl != null)
    {
      if (!localCancellableContinuationImpl.resetState$kotlinx_coroutines_core()) {
        localCancellableContinuationImpl = null;
      }
      if (localCancellableContinuationImpl != null) {
        return localCancellableContinuationImpl;
      }
    }
    return new CancellableContinuationImpl(paramContinuation, 0);
  }
  
  public static final void removeOnCancellation(@NotNull CancellableContinuation<?> paramCancellableContinuation, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    paramCancellableContinuation.invokeOnCancellation((Function1)new RemoveOnCancel(paramLockFreeLinkedListNode));
  }
  
  @InternalCoroutinesApi
  @Nullable
  public static final <T> Object suspendAtomicCancellableCoroutine(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 0);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @Deprecated(message="holdCancellability parameter is deprecated and is no longer used", replaceWith=@ReplaceWith(expression="suspendAtomicCancellableCoroutine(block)", imports={}))
  @InternalCoroutinesApi
  @Nullable
  public static final <T> Object suspendAtomicCancellableCoroutine(boolean paramBoolean, @NotNull Function1<? super CancellableContinuation<? super T>, Unit> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 0);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @InternalCoroutinesApi
  @Nullable
  private static final Object suspendAtomicCancellableCoroutine$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 0);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
  
  @Deprecated(message="holdCancellability parameter is deprecated and is no longer used", replaceWith=@ReplaceWith(expression="suspendAtomicCancellableCoroutine(block)", imports={}))
  @InternalCoroutinesApi
  @Nullable
  private static final Object suspendAtomicCancellableCoroutine$$forInline(boolean paramBoolean, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 0);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
  
  @Nullable
  public static final <T> Object suspendAtomicCancellableCoroutineReusable(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(paramContinuation));
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @Nullable
  private static final Object suspendAtomicCancellableCoroutineReusable$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    CancellableContinuationImpl localCancellableContinuationImpl = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(paramContinuation));
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
  
  @Nullable
  public static final <T> Object suspendCancellableCoroutine(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @Nullable
  private static final Object suspendCancellableCoroutine$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    paramFunction1.invoke(localCancellableContinuationImpl);
    paramFunction1 = localCancellableContinuationImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancellableContinuationKt
 * JD-Core Version:    0.7.0.1
 */