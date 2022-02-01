package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "buildContinuationByInvokeCall", "Lkotlin/coroutines/experimental/Continuation;", "", "T", "completion", "block", "Lkotlin/Function0;", "buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnchecked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/coroutines/experimental/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsJvmKt
{
  private static final <T> Continuation<Unit> buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> paramContinuation, Function0<? extends Object> paramFunction0)
  {
    paramFunction0 = new IntrinsicsKt__IntrinsicsJvmKt.buildContinuationByInvokeCall.continuation.1(paramContinuation, paramFunction0);
    return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction0);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> Continuation<Unit> createCoroutineUnchecked(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutineUnchecked");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    if (!(paramFunction1 instanceof CoroutineImpl))
    {
      paramFunction1 = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked..inlined.buildContinuationByInvokeCall.IntrinsicsKt__IntrinsicsJvmKt.1(paramContinuation, paramFunction1, paramContinuation);
      return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction1);
    }
    paramFunction1 = ((CoroutineImpl)paramFunction1).create(paramContinuation);
    if (paramFunction1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }
    return ((CoroutineImpl)paramFunction1).getFacade();
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <R, T> Continuation<Unit> createCoroutineUnchecked(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutineUnchecked");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    if (!(paramFunction2 instanceof CoroutineImpl))
    {
      paramFunction2 = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked..inlined.buildContinuationByInvokeCall.IntrinsicsKt__IntrinsicsJvmKt.2(paramContinuation, paramFunction2, paramR, paramContinuation);
      return CoroutineIntrinsics.interceptContinuationIfNeeded(paramContinuation.getContext(), (Continuation)paramFunction2);
    }
    paramFunction2 = ((CoroutineImpl)paramFunction2).create(paramR, paramContinuation);
    if (paramFunction2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }
    return ((CoroutineImpl)paramFunction2).getFacade();
  }
  
  @NotNull
  public static final Object getCOROUTINE_SUSPENDED()
  {
    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> Object startCoroutineUninterceptedOrReturn(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    if (paramFunction1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }
    return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(paramContinuation);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <R, T> Object startCoroutineUninterceptedOrReturn(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    if (paramFunction2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }
    return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt
 * JD-Core Version:    0.7.0.1
 */