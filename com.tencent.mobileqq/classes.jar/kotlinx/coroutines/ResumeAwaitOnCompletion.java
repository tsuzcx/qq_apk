package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ResumeAwaitOnCompletion<T>
  extends JobNode<JobSupport>
{
  private final CancellableContinuationImpl<T> continuation;
  
  public ResumeAwaitOnCompletion(@NotNull JobSupport paramJobSupport, @NotNull CancellableContinuationImpl<? super T> paramCancellableContinuationImpl)
  {
    super((Job)paramJobSupport);
    this.continuation = paramCancellableContinuationImpl;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    Object localObject = ((JobSupport)this.job).getState$kotlinx_coroutines_core();
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (!(localObject instanceof Incomplete)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if ((localObject instanceof CompletedExceptionally))
    {
      paramThrowable = (Continuation)this.continuation;
      localObject = ((CompletedExceptionally)localObject).cause;
      localCompanion = Result.Companion;
      paramThrowable.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
      return;
    }
    paramThrowable = (Continuation)this.continuation;
    localObject = JobSupportKt.unboxState(localObject);
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localObject));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResumeAwaitOnCompletion[");
    localStringBuilder.append(this.continuation);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ResumeAwaitOnCompletion
 * JD-Core Version:    0.7.0.1
 */