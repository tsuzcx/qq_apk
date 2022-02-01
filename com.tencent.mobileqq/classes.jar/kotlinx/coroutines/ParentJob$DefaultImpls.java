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
public final class ParentJob$DefaultImpls
{
  public static <R> R fold(ParentJob paramParentJob, R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return Job.DefaultImpls.fold((Job)paramParentJob, paramR, paramFunction2);
  }
  
  @Nullable
  public static <E extends CoroutineContext.Element> E get(ParentJob paramParentJob, @NotNull CoroutineContext.Key<E> paramKey)
  {
    return Job.DefaultImpls.get((Job)paramParentJob, paramKey);
  }
  
  @NotNull
  public static CoroutineContext minusKey(ParentJob paramParentJob, @NotNull CoroutineContext.Key<?> paramKey)
  {
    return Job.DefaultImpls.minusKey((Job)paramParentJob, paramKey);
  }
  
  @NotNull
  public static CoroutineContext plus(ParentJob paramParentJob, @NotNull CoroutineContext paramCoroutineContext)
  {
    return Job.DefaultImpls.plus((Job)paramParentJob, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public static Job plus(ParentJob paramParentJob, @NotNull Job paramJob)
  {
    return Job.DefaultImpls.plus((Job)paramParentJob, paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ParentJob.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */