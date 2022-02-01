package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor.DefaultImpls;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.coroutines.experimental.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationInterceptorMigration;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "(Lkotlin/coroutines/ContinuationInterceptor;)V", "getInterceptor", "()Lkotlin/coroutines/ContinuationInterceptor;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalContinuationInterceptorMigration
  implements kotlin.coroutines.experimental.ContinuationInterceptor
{
  @NotNull
  private final kotlin.coroutines.ContinuationInterceptor interceptor;
  
  public ExperimentalContinuationInterceptorMigration(@NotNull kotlin.coroutines.ContinuationInterceptor paramContinuationInterceptor)
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
  public final kotlin.coroutines.ContinuationInterceptor getInterceptor()
  {
    return this.interceptor;
  }
  
  @NotNull
  public CoroutineContext.Key<?> getKey()
  {
    return (CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key;
  }
  
  @NotNull
  public <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return CoroutinesMigrationKt.toExperimentalContinuation(this.interceptor.interceptContinuation(CoroutinesMigrationKt.toContinuation(paramContinuation)));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalContinuationInterceptorMigration
 * JD-Core Version:    0.7.0.1
 */