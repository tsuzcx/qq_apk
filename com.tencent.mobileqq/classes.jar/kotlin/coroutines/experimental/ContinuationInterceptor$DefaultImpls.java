package kotlin.coroutines.experimental;

import kotlin.Metadata;
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
    return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)paramContinuationInterceptor, paramKey);
  }
  
  @NotNull
  public static CoroutineContext minusKey(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)paramContinuationInterceptor, paramKey);
  }
  
  @NotNull
  public static CoroutineContext plus(ContinuationInterceptor paramContinuationInterceptor, @NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramContinuationInterceptor, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.experimental.ContinuationInterceptor.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */