package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt
{
  @SinceKotlin(version="1.3")
  private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> paramContinuation, Function1<? super Continuation<? super T>, ? extends Object> paramFunction1)
  {
    CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineFromSuspendFunction.1(paramFunction1, paramContinuation, paramContinuation);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
    if (paramContinuation != null) {
      return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineFromSuspendFunction.2(paramFunction1, paramContinuation, localCoroutineContext, paramContinuation, localCoroutineContext);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$createCoroutineUnintercepted");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if ((paramFunction1 instanceof BaseContinuationImpl)) {
      return ((BaseContinuationImpl)paramFunction1).create(paramContinuation);
    }
    CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted..inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.1(paramContinuation, paramContinuation, paramFunction1);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
    if (paramContinuation != null) {
      return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted..inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.2(paramContinuation, localCoroutineContext, paramContinuation, localCoroutineContext, paramFunction1);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$createCoroutineUnintercepted");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if ((paramFunction2 instanceof BaseContinuationImpl)) {
      return ((BaseContinuationImpl)paramFunction2).create(paramR, paramContinuation);
    }
    CoroutineContext localCoroutineContext = paramContinuation.getContext();
    if (localCoroutineContext == EmptyCoroutineContext.INSTANCE)
    {
      if (paramContinuation != null) {
        return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted..inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.3(paramContinuation, paramContinuation, paramFunction2, paramR);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
    if (paramContinuation != null) {
      return (Continuation)new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted..inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.4(paramContinuation, localCoroutineContext, paramContinuation, localCoroutineContext, paramFunction2, paramR);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Continuation<T> intercepted(@NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$intercepted");
    if (!(paramContinuation instanceof ContinuationImpl)) {
      localObject1 = null;
    } else {
      localObject1 = paramContinuation;
    }
    Object localObject2 = (ContinuationImpl)localObject1;
    Object localObject1 = paramContinuation;
    if (localObject2 != null)
    {
      localObject2 = ((ContinuationImpl)localObject2).intercepted();
      localObject1 = paramContinuation;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Object startCoroutineUninterceptedOrReturn(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, Continuation<? super T> paramContinuation)
  {
    if (paramFunction1 != null) {
      return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T> Object startCoroutineUninterceptedOrReturn(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, Continuation<? super T> paramContinuation)
  {
    if (paramFunction2 != null) {
      return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, paramContinuation);
    }
    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt
 * JD-Core Version:    0.7.0.1
 */