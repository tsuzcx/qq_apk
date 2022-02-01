package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DispatchedContinuationKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CancellableKt
{
  private static final void runSafely(Continuation<?> paramContinuation, Function0<Unit> paramFunction0)
  {
    try
    {
      paramFunction0.invoke();
      return;
    }
    catch (Throwable paramFunction0)
    {
      Result.Companion localCompanion = Result.Companion;
      paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction0)));
    }
  }
  
  public static final void startCoroutineCancellable(@NotNull Continuation<? super Unit> paramContinuation, @NotNull Continuation<?> paramContinuation1)
  {
    try
    {
      paramContinuation = IntrinsicsKt.intercepted(paramContinuation);
      localCompanion = Result.Companion;
      DispatchedContinuationKt.resumeCancellableWith(paramContinuation, Result.constructor-impl(Unit.INSTANCE));
      return;
    }
    catch (Throwable paramContinuation)
    {
      Result.Companion localCompanion = Result.Companion;
      paramContinuation1.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramContinuation)));
    }
  }
  
  @InternalCoroutinesApi
  public static final <T> void startCoroutineCancellable(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    try
    {
      paramFunction1 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction1, paramContinuation));
      localCompanion = Result.Companion;
      DispatchedContinuationKt.resumeCancellableWith(paramFunction1, Result.constructor-impl(Unit.INSTANCE));
      return;
    }
    catch (Throwable paramFunction1)
    {
      Result.Companion localCompanion = Result.Companion;
      paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction1)));
    }
  }
  
  public static final <R, T> void startCoroutineCancellable(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    try
    {
      paramFunction2 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, paramR, paramContinuation));
      paramR = Result.Companion;
      DispatchedContinuationKt.resumeCancellableWith(paramFunction2, Result.constructor-impl(Unit.INSTANCE));
      return;
    }
    catch (Throwable paramFunction2)
    {
      paramR = Result.Companion;
      paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.intrinsics.CancellableKt
 * JD-Core Version:    0.7.0.1
 */