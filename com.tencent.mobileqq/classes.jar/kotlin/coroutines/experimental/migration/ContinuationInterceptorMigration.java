package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor.DefaultImpls;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ContinuationInterceptorMigration;", "Lkotlin/coroutines/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "(Lkotlin/coroutines/experimental/ContinuationInterceptor;)V", "getInterceptor", "()Lkotlin/coroutines/experimental/ContinuationInterceptor;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ContinuationInterceptorMigration
  implements kotlin.coroutines.ContinuationInterceptor
{
  @NotNull
  private final kotlin.coroutines.experimental.ContinuationInterceptor interceptor;
  
  public ContinuationInterceptorMigration(@NotNull kotlin.coroutines.experimental.ContinuationInterceptor paramContinuationInterceptor)
  {
    this.interceptor = paramContinuationInterceptor;
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return ContinuationInterceptor.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return ContinuationInterceptor.DefaultImpls.get(this, paramKey);
  }
  
  @NotNull
  public final kotlin.coroutines.experimental.ContinuationInterceptor getInterceptor()
  {
    return this.interceptor;
  }
  
  @NotNull
  public CoroutineContext.Key<?> getKey()
  {
    return (CoroutineContext.Key)kotlin.coroutines.ContinuationInterceptor.Key;
  }
  
  @NotNull
  public <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return CoroutinesMigrationKt.toContinuation(this.interceptor.interceptContinuation(CoroutinesMigrationKt.toExperimentalContinuation(paramContinuation)));
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return ContinuationInterceptor.DefaultImpls.minusKey(this, paramKey);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return ContinuationInterceptor.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  public void releaseInterceptedContinuation(@NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ContinuationInterceptorMigration
 * JD-Core Version:    0.7.0.1
 */