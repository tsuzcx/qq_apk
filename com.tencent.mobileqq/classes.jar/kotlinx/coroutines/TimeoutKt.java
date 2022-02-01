package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-TT;>;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function2<-Lkotlinx.coroutines.CoroutineScope;-Lkotlin.coroutines.Continuation<-TT;>;+Ljava.lang.Object;>;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class TimeoutKt
{
  @NotNull
  public static final TimeoutCancellationException TimeoutCancellationException(long paramLong, @NotNull Job paramJob)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Timed out waiting for ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ms");
    return new TimeoutCancellationException(localStringBuilder.toString(), paramJob);
  }
  
  private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> paramTimeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    CoroutineContext localCoroutineContext = paramTimeoutCoroutine.uCont.getContext();
    JobKt.disposeOnCompletion((Job)paramTimeoutCoroutine, DelayKt.getDelay(localCoroutineContext).invokeOnTimeout(paramTimeoutCoroutine.time, (Runnable)paramTimeoutCoroutine));
    return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout((ScopeCoroutine)paramTimeoutCoroutine, paramTimeoutCoroutine, paramFunction2);
  }
  
  @Nullable
  public static final <T> Object withTimeout(long paramLong, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    if (paramLong > 0L)
    {
      paramFunction2 = setupTimeout(new TimeoutCoroutine(paramLong, paramContinuation), paramFunction2);
      if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      return paramFunction2;
    }
    throw ((Throwable)new TimeoutCancellationException("Timed out immediately"));
  }
  
  @Nullable
  public static final <T> Object withTimeoutOrNull(long paramLong, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    if ((paramContinuation instanceof TimeoutKt.withTimeoutOrNull.1))
    {
      localObject1 = (TimeoutKt.withTimeoutOrNull.1)paramContinuation;
      if ((((TimeoutKt.withTimeoutOrNull.1)localObject1).label & 0x80000000) != 0)
      {
        ((TimeoutKt.withTimeoutOrNull.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super T>)localObject1;
        break label52;
      }
    }
    paramContinuation = new TimeoutKt.withTimeoutOrNull.1(paramContinuation);
    label52:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFunction2 = (Ref.ObjectRef)paramContinuation.L$1;
        localObject2 = (Function2)paramContinuation.L$0;
        paramLong = paramContinuation.J$0;
        try
        {
          ResultKt.throwOnFailure(localObject1);
          return localObject1;
        }
        catch (TimeoutCancellationException paramContinuation) {}
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      if (paramLong <= 0L) {
        return null;
      }
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = ((TimeoutCoroutine)null);
      try
      {
        paramContinuation.J$0 = paramLong;
        paramContinuation.L$0 = paramFunction2;
        paramContinuation.L$1 = localObject1;
        paramContinuation.label = 1;
        TimeoutCoroutine localTimeoutCoroutine = new TimeoutCoroutine(paramLong, (Continuation)paramContinuation);
        ((Ref.ObjectRef)localObject1).element = localTimeoutCoroutine;
        paramFunction2 = setupTimeout(localTimeoutCoroutine, paramFunction2);
        if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
          DebugProbesKt.probeCoroutineSuspended((Continuation)paramContinuation);
        }
        if (paramFunction2 == localObject2) {
          return localObject2;
        }
        return paramFunction2;
      }
      catch (TimeoutCancellationException paramContinuation)
      {
        paramFunction2 = (Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object>)localObject1;
      }
    }
    if (paramContinuation.coroutine == (TimeoutCoroutine)paramFunction2.element) {
      return null;
    }
    throw ((Throwable)paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeoutKt
 * JD-Core Version:    0.7.0.1
 */