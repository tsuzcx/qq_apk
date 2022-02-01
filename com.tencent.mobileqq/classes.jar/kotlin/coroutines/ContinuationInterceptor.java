package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract interface ContinuationInterceptor
  extends CoroutineContext.Element
{
  public static final ContinuationInterceptor.Key Key = ContinuationInterceptor.Key.$$INSTANCE;
  
  @Nullable
  public abstract <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey);
  
  @NotNull
  public abstract <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation);
  
  @NotNull
  public abstract CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey);
  
  public abstract void releaseInterceptedContinuation(@NotNull Continuation<?> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.ContinuationInterceptor
 * JD-Core Version:    0.7.0.1
 */