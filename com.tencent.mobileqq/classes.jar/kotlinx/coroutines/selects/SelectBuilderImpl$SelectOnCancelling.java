package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "job", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/Job;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectBuilderImpl$SelectOnCancelling
  extends JobCancellingNode<Job>
{
  public SelectBuilderImpl$SelectOnCancelling(Job paramJob)
  {
    super(localJob);
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (this.this$0.trySelect()) {
      this.this$0.resumeSelectWithException((Throwable)this.job.getCancellationException());
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectOnCancelling[");
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl.SelectOnCancelling
 * JD-Core Version:    0.7.0.1
 */