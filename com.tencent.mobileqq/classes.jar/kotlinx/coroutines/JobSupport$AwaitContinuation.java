package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class JobSupport$AwaitContinuation<T>
  extends CancellableContinuationImpl<T>
{
  private final JobSupport job;
  
  public JobSupport$AwaitContinuation(@NotNull Continuation<? super T> paramContinuation, @NotNull JobSupport paramJobSupport)
  {
    super(paramContinuation, 1);
    this.job = paramJobSupport;
  }
  
  @NotNull
  public Throwable getContinuationCancellationCause(@NotNull Job paramJob)
  {
    Object localObject = this.job.getState$kotlinx_coroutines_core();
    if ((localObject instanceof JobSupport.Finishing))
    {
      Throwable localThrowable = ((JobSupport.Finishing)localObject).getRootCause();
      if (localThrowable != null) {
        return localThrowable;
      }
    }
    if ((localObject instanceof CompletedExceptionally)) {
      return ((CompletedExceptionally)localObject).cause;
    }
    return (Throwable)paramJob.getCancellationException();
  }
  
  @NotNull
  protected String nameString()
  {
    return "AwaitContinuation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupport.AwaitContinuation
 * JD-Core Version:    0.7.0.1
 */