package kotlin.coroutines;

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
    if (Intrinsics.areEqual(paramElement.getKey(), paramKey))
    {
      paramKey = paramElement;
      if (paramElement == null) {
        throw new TypeCastException("null cannot be cast to non-null type E");
      }
    }
    else
    {
      paramKey = null;
    }
    return paramKey;
  }
  
  @NotNull
  public static CoroutineContext minusKey(CoroutineContext.Element paramElement, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if (Intrinsics.areEqual(paramElement.getKey(), paramKey)) {
      return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)paramElement;
  }
  
  @NotNull
  public static CoroutineContext plus(CoroutineContext.Element paramElement, @NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.DefaultImpls.plus((CoroutineContext)paramElement, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.CoroutineContext.Element.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */