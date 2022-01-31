package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", "T", "context", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ContinuationKt
{
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Continuation<T> Continuation(CoroutineContext paramCoroutineContext, Function1<? super Result<? extends T>, Unit> paramFunction1)
  {
    return (Continuation)new ContinuationKt.Continuation.1(paramCoroutineContext, paramFunction1);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Continuation<Unit> createCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction1, paramContinuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R, T> Continuation<Unit> createCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return (Continuation)new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, paramR, paramContinuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
  }
  
  private static final CoroutineContext getCoroutineContext()
  {
    throw ((Throwable)new NotImplementedError("Implemented as intrinsic"));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> void resume(@NotNull Continuation<? super T> paramContinuation, T paramT)
  {
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(paramT));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> void resumeWithException(@NotNull Continuation<? super T> paramContinuation, Throwable paramThrowable)
  {
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
  }
  
  @SinceKotlin(version="1.3")
  public static final <T> void startCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramFunction1 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction1, paramContinuation));
    paramContinuation = Unit.INSTANCE;
    Result.Companion localCompanion = Result.Companion;
    paramFunction1.resumeWith(Result.constructor-impl(paramContinuation));
  }
  
  @SinceKotlin(version="1.3")
  public static final <R, T> void startCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$startCoroutine");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramFunction2 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, paramR, paramContinuation));
    paramR = Unit.INSTANCE;
    paramContinuation = Result.Companion;
    paramFunction2.resumeWith(Result.constructor-impl(paramR));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> paramFunction1, Continuation<? super T> paramContinuation)
  {
    InlineMarker.mark(0);
    SafeContinuation localSafeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(paramContinuation));
    paramFunction1.invoke(localSafeContinuation);
    paramFunction1 = localSafeContinuation.getOrThrow();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.ContinuationKt
 * JD-Core Version:    0.7.0.1
 */