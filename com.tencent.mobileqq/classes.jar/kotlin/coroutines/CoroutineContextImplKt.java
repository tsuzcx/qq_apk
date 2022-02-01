package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class CoroutineContextImplKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <E extends CoroutineContext.Element> E getPolymorphicElement(@NotNull CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramElement, "$this$getPolymorphicElement");
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    boolean bool = paramKey instanceof AbstractCoroutineContextKey;
    Object localObject = null;
    if (bool)
    {
      AbstractCoroutineContextKey localAbstractCoroutineContextKey = (AbstractCoroutineContextKey)paramKey;
      paramKey = localObject;
      if (localAbstractCoroutineContextKey.isSubKey$kotlin_stdlib(paramElement.getKey()))
      {
        paramKey = localAbstractCoroutineContextKey.tryCast$kotlin_stdlib(paramElement);
        if (!(paramKey instanceof CoroutineContext.Element)) {
          return null;
        }
      }
      return paramKey;
    }
    if (paramElement.getKey() == paramKey) {
      return paramElement;
    }
    return null;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final CoroutineContext minusPolymorphicKey(@NotNull CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramElement, "$this$minusPolymorphicKey");
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if ((paramKey instanceof AbstractCoroutineContextKey))
    {
      localObject = (AbstractCoroutineContextKey)paramKey;
      paramKey = paramElement;
      if (((AbstractCoroutineContextKey)localObject).isSubKey$kotlin_stdlib(paramElement.getKey()))
      {
        paramKey = paramElement;
        if (((AbstractCoroutineContextKey)localObject).tryCast$kotlin_stdlib(paramElement) != null) {
          paramKey = EmptyCoroutineContext.INSTANCE;
        }
      }
      return (CoroutineContext)paramKey;
    }
    Object localObject = paramElement;
    if (paramElement.getKey() == paramKey) {
      localObject = EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.CoroutineContextImplKt
 * JD-Core Version:    0.7.0.1
 */