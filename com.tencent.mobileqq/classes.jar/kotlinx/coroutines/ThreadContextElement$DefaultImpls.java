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
public final class ThreadContextElement$DefaultImpls
{
  public static <S, R> R fold(ThreadContextElement<S> paramThreadContextElement, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)paramThreadContextElement, paramR, paramFunction2);
  }
  
  @Nullable
  public static <S, E extends CoroutineContext.Element> E get(ThreadContextElement<S> paramThreadContextElement, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)paramThreadContextElement, paramKey);
  }
  
  @NotNull
  public static <S> CoroutineContext minusKey(ThreadContextElement<S> paramThreadContextElement, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)paramThreadContextElement, paramKey);
  }
  
  @NotNull
  public static <S> CoroutineContext plus(ThreadContextElement<S> paramThreadContextElement, @NotNull CoroutineContext paramCoroutineContext)
  {
    return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramThreadContextElement, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadContextElement.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */