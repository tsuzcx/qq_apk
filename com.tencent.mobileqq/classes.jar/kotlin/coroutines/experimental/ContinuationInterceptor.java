package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "Key", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface ContinuationInterceptor
  extends CoroutineContext.Element
{
  public static final ContinuationInterceptor.Key Key = ContinuationInterceptor.Key.$$INSTANCE;
  
  @NotNull
  public abstract <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.ContinuationInterceptor
 * JD-Core Version:    0.7.0.1
 */