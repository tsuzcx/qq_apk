package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class Job$DefaultImpls
{
  public static <R> R fold(Job paramJob, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)paramJob, paramR, paramFunction2);
  }
  
  @Nullable
  public static <E extends CoroutineContext.Element> E get(Job paramJob, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)paramJob, paramKey);
  }
  
  @NotNull
  public static CoroutineContext minusKey(Job paramJob, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)paramJob, paramKey);
  }
  
  @NotNull
  public static CoroutineContext plus(Job paramJob, @NotNull CoroutineContext paramCoroutineContext)
  {
    return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)paramJob, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public static Job plus(Job paramJob1, @NotNull Job paramJob2)
  {
    return paramJob2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Job.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */