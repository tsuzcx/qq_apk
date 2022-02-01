package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ResumeOnCompletion
  extends JobNode<Job>
{
  private final Continuation<Unit> continuation;
  
  public ResumeOnCompletion(@NotNull Job paramJob, @NotNull Continuation<? super Unit> paramContinuation)
  {
    super(paramJob);
    this.continuation = paramContinuation;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    paramThrowable = this.continuation;
    Unit localUnit = Unit.INSTANCE;
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localUnit));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResumeOnCompletion[");
    localStringBuilder.append(this.continuation);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ResumeOnCompletion
 * JD-Core Version:    0.7.0.1
 */