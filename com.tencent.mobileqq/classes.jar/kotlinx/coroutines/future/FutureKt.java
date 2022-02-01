package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/Deferred;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "kotlinx-coroutines-jdk8"}, k=2, mv={1, 1, 13})
public final class FutureKt
{
  @NotNull
  public static final <T> CompletableFuture<T> asCompletableFuture(@NotNull Deferred<? extends T> paramDeferred)
  {
    Intrinsics.checkParameterIsNotNull(paramDeferred, "receiver$0");
    CompletableFuture localCompletableFuture = new CompletableFuture();
    localCompletableFuture.whenComplete((BiConsumer)new FutureKt.asCompletableFuture.1(paramDeferred));
    paramDeferred.invokeOnCompletion((Function1)new FutureKt.asCompletableFuture.2(paramDeferred, localCompletableFuture));
    return localCompletableFuture;
  }
  
  @NotNull
  public static final <T> Deferred<T> asDeferred(@NotNull CompletionStage<T> paramCompletionStage)
  {
    Intrinsics.checkParameterIsNotNull(paramCompletionStage, "receiver$0");
    boolean bool = paramCompletionStage instanceof Future;
    if ((bool) && (((Future)paramCompletionStage).isDone()))
    {
      try
      {
        paramCompletionStage = CompletableDeferredKt.CompletableDeferred(((Future)paramCompletionStage).get());
      }
      catch (Throwable paramCompletionStage)
      {
        if (!(paramCompletionStage instanceof ExecutionException)) {
          localObject1 = null;
        } else {
          localObject1 = paramCompletionStage;
        }
        Object localObject2 = (ExecutionException)localObject1;
        localObject1 = paramCompletionStage;
        if (localObject2 != null)
        {
          localObject2 = ((ExecutionException)localObject2).getCause();
          localObject1 = paramCompletionStage;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
        paramCompletionStage = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        paramCompletionStage.cancel((Throwable)localObject1);
      }
      return (Deferred)paramCompletionStage;
    }
    Object localObject1 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    paramCompletionStage.whenComplete((BiConsumer)new FutureKt.asDeferred.2((CompletableDeferred)localObject1));
    if (bool) {
      JobKt.cancelFutureOnCompletion((Job)localObject1, (Future)paramCompletionStage);
    }
    return (Deferred)localObject1;
  }
  
  @Nullable
  public static final <T> Object await(@NotNull CompletionStage<T> paramCompletionStage, @NotNull Continuation<? super T> paramContinuation)
  {
    if (((paramCompletionStage instanceof Future)) && (((Future)paramCompletionStage).isDone())) {
      try
      {
        paramCompletionStage = ((Future)paramCompletionStage).get();
        return paramCompletionStage;
      }
      catch (ExecutionException paramContinuation)
      {
        paramCompletionStage = paramContinuation.getCause();
        if (paramCompletionStage == null) {
          paramCompletionStage = (Throwable)paramContinuation;
        }
        throw paramCompletionStage;
      }
    }
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    localCancellableContinuationImpl.initCancellability();
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    ContinuationConsumer localContinuationConsumer = new ContinuationConsumer((Continuation)localCancellableContinuation);
    paramCompletionStage.whenComplete((BiConsumer)localContinuationConsumer);
    localCancellableContinuation.invokeOnCancellation((Function1)new FutureKt.await..inlined.suspendCancellableCoroutine.lambda.1(localContinuationConsumer, paramCompletionStage));
    paramCompletionStage = localCancellableContinuationImpl.getResult();
    if (paramCompletionStage == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramCompletionStage;
  }
  
  @NotNull
  public static final <T> CompletableFuture<T> future(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineStart paramCoroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineScope, "receiver$0");
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramCoroutineStart, "start");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    if ((paramCoroutineStart.isLazy() ^ true))
    {
      paramCoroutineContext = CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext);
      paramCoroutineScope = new CompletableFuture();
      paramCoroutineContext = new CompletableFutureCoroutine(paramCoroutineContext, paramCoroutineScope);
      paramCoroutineScope.whenComplete((BiConsumer)paramCoroutineContext);
      paramCoroutineContext.start(paramCoroutineStart, paramCoroutineContext, paramFunction2);
      return paramCoroutineScope;
    }
    paramCoroutineScope = new StringBuilder();
    paramCoroutineScope.append(paramCoroutineStart);
    paramCoroutineScope.append(" start is not supported");
    throw ((Throwable)new IllegalArgumentException(paramCoroutineScope.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.FutureKt
 * JD-Core Version:    0.7.0.1
 */