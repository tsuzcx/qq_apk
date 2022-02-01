package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobCancellingNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/JobNode;", "job", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class JobCancellingNode<J extends Job>
  extends JobNode<J>
{
  public JobCancellingNode(@NotNull J paramJ)
  {
    super(paramJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobCancellingNode
 * JD-Core Version:    0.7.0.1
 */