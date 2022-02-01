package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class CoroutineContext$Element$DefaultImpls
{
  public static <R> R fold(CoroutineContext.Element paramElement, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return paramFunction2.invoke(paramR, paramElement);
  }
  
  @Nullable
  public static <E extends CoroutineContext.Element> E get(CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if (paramElement.getKey() == paramKey)
    {
      if (paramElement != null) {
        return paramElement;
      }
      throw new TypeCastException("null cannot be cast to non-null type E");
    }
    return null;
  }
  
  @NotNull
  public static CoroutineContext minusKey(CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    Object localObject = paramElement;
    if (paramElement.getKey() == paramKey) {
      localObject = EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)localObject;
  }
  
  @NotNull
  public static CoroutineContext plus(CoroutineContext.Element paramElement, @NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.DefaultImpls.plus((CoroutineContext)paramElement, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.experimental.CoroutineContext.Element.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */