package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class CoroutineExceptionHandler$DefaultImpls
{
  public static <R> R fold(CoroutineExceptionHandler paramCoroutineExceptionHandler, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)paramCoroutineExceptionHandler, paramR, paramFunction2);
  }
  
  @Nullable
  public static <E extends CoroutineContext.Element> E get(CoroutineExceptionHandler paramCoroutineExceptionHandler, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)paramCoroutineExceptionHandler, paramKey);
  }
  
  @NotNull
  public static CoroutineContext minusKey(CoroutineExceptionHandler paramCoroutineExceptionHandler, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)paramCoroutineExceptionHandler, paramKey);
  }
  
  @NotNull
  public static CoroutineContext plus(CoroutineExceptionHandler paramCoroutineExceptionHandler, @NotNull CoroutineContext paramCoroutineContext)
  {
    return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramCoroutineExceptionHandler, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */