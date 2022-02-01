package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext.Key;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"interceptContinuationIfNeeded", "Lkotlin/coroutines/experimental/Continuation;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "continuation", "normalizeContinuation", "kotlin-stdlib-coroutines"}, k=2, mv={1, 1, 16})
@JvmName(name="CoroutineIntrinsics")
public final class CoroutineIntrinsics
{
  @NotNull
  public static final <T> Continuation<T> interceptContinuationIfNeeded(@NotNull CoroutineContext paramCoroutineContext, @NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    Object localObject = (ContinuationInterceptor)paramCoroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key);
    paramCoroutineContext = paramContinuation;
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptor)localObject).interceptContinuation(paramContinuation);
      paramCoroutineContext = paramContinuation;
      if (localObject != null) {
        paramCoroutineContext = (CoroutineContext)localObject;
      }
    }
    return paramCoroutineContext;
  }
  
  @NotNull
  public static final <T> Continuation<T> normalizeContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    if (!(paramContinuation instanceof CoroutineImpl)) {}
    for (Object localObject1 = null;; localObject1 = paramContinuation)
    {
      Object localObject2 = (CoroutineImpl)localObject1;
      localObject1 = paramContinuation;
      if (localObject2 != null)
      {
        localObject2 = ((CoroutineImpl)localObject2).getFacade();
        localObject1 = paramContinuation;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics
 * JD-Core Version:    0.7.0.1
 */