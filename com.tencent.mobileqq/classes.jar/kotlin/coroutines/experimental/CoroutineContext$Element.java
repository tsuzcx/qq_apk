package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/CoroutineContext$Element;", "Lkotlin/coroutines/experimental/CoroutineContext;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "minusKey", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
public abstract interface CoroutineContext$Element
  extends CoroutineContext
{
  public abstract <R> R fold(R paramR, @NotNull Function2<? super R, ? super Element, ? extends R> paramFunction2);
  
  @Nullable
  public abstract <E extends Element> E get(@NotNull CoroutineContext.Key<E> paramKey);
  
  @NotNull
  public abstract CoroutineContext.Key<?> getKey();
  
  @NotNull
  public abstract CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.CoroutineContext.Element
 * JD-Core Version:    0.7.0.1
 */