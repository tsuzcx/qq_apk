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
public final class CompletableDeferred$DefaultImpls
{
  public static <T, R> R fold(CompletableDeferred<T> paramCompletableDeferred, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return Deferred.DefaultImpls.fold((Deferred)paramCompletableDeferred, paramR, paramFunction2);
  }
  
  @Nullable
  public static <T, E extends CoroutineContext.Element> E get(CompletableDeferred<T> paramCompletableDeferred, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return Deferred.DefaultImpls.get((Deferred)paramCompletableDeferred, paramKey);
  }
  
  @NotNull
  public static <T> CoroutineContext minusKey(CompletableDeferred<T> paramCompletableDeferred, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return Deferred.DefaultImpls.minusKey((Deferred)paramCompletableDeferred, paramKey);
  }
  
  @NotNull
  public static <T> CoroutineContext plus(CompletableDeferred<T> paramCompletableDeferred, @NotNull CoroutineContext paramCoroutineContext)
  {
    return Deferred.DefaultImpls.plus((Deferred)paramCompletableDeferred, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public static <T> Job plus(CompletableDeferred<T> paramCompletableDeferred, @NotNull Job paramJob)
  {
    return Deferred.DefaultImpls.plus((Deferred)paramCompletableDeferred, paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletableDeferred.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */