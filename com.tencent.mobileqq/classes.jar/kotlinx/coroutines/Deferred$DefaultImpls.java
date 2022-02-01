package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class Deferred$DefaultImpls
{
  public static <T, R> R fold(Deferred<? extends T> paramDeferred, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return Job.DefaultImpls.fold((Job)paramDeferred, paramR, paramFunction2);
  }
  
  @Nullable
  public static <T, E extends CoroutineContext.Element> E get(Deferred<? extends T> paramDeferred, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return Job.DefaultImpls.get((Job)paramDeferred, paramKey);
  }
  
  @NotNull
  public static <T> CoroutineContext minusKey(Deferred<? extends T> paramDeferred, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return Job.DefaultImpls.minusKey((Job)paramDeferred, paramKey);
  }
  
  @NotNull
  public static <T> CoroutineContext plus(Deferred<? extends T> paramDeferred, @NotNull CoroutineContext paramCoroutineContext)
  {
    return Job.DefaultImpls.plus((Job)paramDeferred, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public static <T> Job plus(Deferred<? extends T> paramDeferred, @NotNull Job paramJob)
  {
    return Job.DefaultImpls.plus((Job)paramDeferred, paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Deferred.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */