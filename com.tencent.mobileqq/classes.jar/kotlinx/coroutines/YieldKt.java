package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletion", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class YieldKt
{
  public static final void checkCompletion(@NotNull CoroutineContext paramCoroutineContext)
  {
    paramCoroutineContext = (Job)paramCoroutineContext.get((CoroutineContext.Key)Job.Key);
    if (paramCoroutineContext != null)
    {
      if (paramCoroutineContext.isActive()) {
        return;
      }
      throw ((Throwable)paramCoroutineContext.getCancellationException());
    }
  }
  
  @Nullable
  public static final Object yield(@NotNull Continuation<? super Unit> paramContinuation)
  {
    CoroutineContext localCoroutineContext = paramContinuation.getContext();
    checkCompletion(localCoroutineContext);
    Object localObject2 = IntrinsicsKt.intercepted(paramContinuation);
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof DispatchedContinuation)) {
      localObject1 = null;
    }
    localObject1 = (DispatchedContinuation)localObject1;
    if (localObject1 != null)
    {
      if (((DispatchedContinuation)localObject1).dispatcher.isDispatchNeeded(localCoroutineContext))
      {
        ((DispatchedContinuation)localObject1).dispatchYield$kotlinx_coroutines_core(localCoroutineContext, Unit.INSTANCE);
      }
      else
      {
        localObject2 = new YieldContext();
        ((DispatchedContinuation)localObject1).dispatchYield$kotlinx_coroutines_core(localCoroutineContext.plus((CoroutineContext)localObject2), Unit.INSTANCE);
        if (((YieldContext)localObject2).dispatcherWasUnconfined)
        {
          if (DispatchedContinuationKt.yieldUndispatched((DispatchedContinuation)localObject1))
          {
            localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            break label122;
          }
          localObject1 = Unit.INSTANCE;
          break label122;
        }
      }
      localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    else
    {
      localObject1 = Unit.INSTANCE;
    }
    label122:
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return localObject1;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.YieldKt
 * JD-Core Version:    0.7.0.1
 */