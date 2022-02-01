package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ContinuationInterceptor$DefaultImpls
{
  public static <R> R fold(ContinuationInterceptor paramContinuationInterceptor, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)paramContinuationInterceptor, paramR, paramFunction2);
  }
  
  @Nullable
  public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    boolean bool = paramKey instanceof AbstractCoroutineContextKey;
    Object localObject = null;
    if (bool)
    {
      AbstractCoroutineContextKey localAbstractCoroutineContextKey = (AbstractCoroutineContextKey)paramKey;
      paramKey = localObject;
      if (localAbstractCoroutineContextKey.isSubKey$kotlin_stdlib(paramContinuationInterceptor.getKey()))
      {
        paramKey = localAbstractCoroutineContextKey.tryCast$kotlin_stdlib((CoroutineContext.Element)paramContinuationInterceptor);
        if (!(paramKey instanceof CoroutineContext.Element)) {
          return null;
        }
      }
      return paramKey;
    }
    if (ContinuationInterceptor.Key == paramKey)
    {
      if (paramContinuationInterceptor != null) {
        return (CoroutineContext.Element)paramContinuationInterceptor;
      }
      throw new TypeCastException("null cannot be cast to non-null type E");
    }
    return null;
  }
  
  @NotNull
  public static CoroutineContext minusKey(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if ((paramKey instanceof AbstractCoroutineContextKey))
    {
      AbstractCoroutineContextKey localAbstractCoroutineContextKey = (AbstractCoroutineContextKey)paramKey;
      paramKey = paramContinuationInterceptor;
      if (localAbstractCoroutineContextKey.isSubKey$kotlin_stdlib(paramContinuationInterceptor.getKey()))
      {
        paramKey = paramContinuationInterceptor;
        if (localAbstractCoroutineContextKey.tryCast$kotlin_stdlib((CoroutineContext.Element)paramContinuationInterceptor) != null) {
          paramKey = EmptyCoroutineContext.INSTANCE;
        }
      }
      return (CoroutineContext)paramKey;
    }
    if (ContinuationInterceptor.Key == paramKey) {
      paramContinuationInterceptor = EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)paramContinuationInterceptor;
  }
  
  @NotNull
  public static CoroutineContext plus(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramContinuationInterceptor, paramCoroutineContext);
  }
  
  public static void releaseInterceptedContinuation(ContinuationInterceptor paramContinuationInterceptor, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.ContinuationInterceptor.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */