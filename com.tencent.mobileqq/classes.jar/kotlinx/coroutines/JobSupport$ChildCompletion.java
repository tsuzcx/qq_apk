package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class JobSupport$ChildCompletion
  extends JobNode<Job>
{
  private final ChildHandleNode child;
  private final JobSupport parent;
  private final Object proposedUpdate;
  private final JobSupport.Finishing state;
  
  public JobSupport$ChildCompletion(@NotNull JobSupport paramJobSupport, @NotNull JobSupport.Finishing paramFinishing, @NotNull ChildHandleNode paramChildHandleNode, @Nullable Object paramObject)
  {
    super((Job)paramChildHandleNode.childJob);
    this.parent = paramJobSupport;
    this.state = paramFinishing;
    this.child = paramChildHandleNode;
    this.proposedUpdate = paramObject;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    JobSupport.access$continueCompleting(this.parent, this.state, this.child, this.proposedUpdate);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildCompletion[");
    localStringBuilder.append(this.child);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.proposedUpdate);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupport.ChildCompletion
 * JD-Core Version:    0.7.0.1
 */