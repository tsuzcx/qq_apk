package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChildHandleNode
  extends JobCancellingNode<JobSupport>
  implements ChildHandle
{
  @JvmField
  @NotNull
  public final ChildJob childJob;
  
  public ChildHandleNode(@NotNull JobSupport paramJobSupport, @NotNull ChildJob paramChildJob)
  {
    super((Job)paramJobSupport);
    this.childJob = paramChildJob;
  }
  
  public boolean childCancelled(@NotNull Throwable paramThrowable)
  {
    return ((JobSupport)this.job).childCancelled(paramThrowable);
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    this.childJob.parentCancelled((ParentJob)this.job);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildHandle[");
    localStringBuilder.append(this.childJob);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ChildHandleNode
 * JD-Core Version:    0.7.0.1
 */