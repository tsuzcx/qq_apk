package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChildContinuation
  extends JobCancellingNode<Job>
{
  @JvmField
  @NotNull
  public final CancellableContinuationImpl<?> child;
  
  public ChildContinuation(@NotNull Job paramJob, @NotNull CancellableContinuationImpl<?> paramCancellableContinuationImpl)
  {
    super(paramJob);
    this.child = paramCancellableContinuationImpl;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    paramThrowable = this.child;
    paramThrowable.parentCancelled$kotlinx_coroutines_core(paramThrowable.getContinuationCancellationCause(this.job));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildContinuation[");
    localStringBuilder.append(this.child);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ChildContinuation
 * JD-Core Version:    0.7.0.1
 */