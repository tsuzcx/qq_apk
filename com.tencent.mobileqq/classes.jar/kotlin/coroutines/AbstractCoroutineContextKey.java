package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalStdlibApi
@SinceKotlin(version="1.3")
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B>
  implements CoroutineContext.Key<E>
{
  private final Function1<CoroutineContext.Element, E> safeCast;
  private final CoroutineContext.Key<?> topmostKey;
  
  public AbstractCoroutineContextKey(@NotNull CoroutineContext.Key<B> paramKey, @NotNull Function1<? super CoroutineContext.Element, ? extends E> paramFunction1)
  {
    this.safeCast = paramFunction1;
    paramFunction1 = paramKey;
    if ((paramKey instanceof AbstractCoroutineContextKey)) {
      paramFunction1 = ((AbstractCoroutineContextKey)paramKey).topmostKey;
    }
    this.topmostKey = paramFunction1;
  }
  
  public final boolean isSubKey$kotlin_stdlib(@NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return (paramKey == (AbstractCoroutineContextKey)this) || (this.topmostKey == paramKey);
  }
  
  @Nullable
  public final E tryCast$kotlin_stdlib(@NotNull CoroutineContext.Element paramElement)
  {
    Intrinsics.checkParameterIsNotNull(paramElement, "element");
    return (CoroutineContext.Element)this.safeCast.invoke(paramElement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.AbstractCoroutineContextKey
 * JD-Core Version:    0.7.0.1
 */