package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class JobNode<J extends Job>
  extends CompletionHandlerBase
  implements DisposableHandle, Incomplete
{
  @JvmField
  @NotNull
  public final J job;
  
  public JobNode(@NotNull J paramJ)
  {
    this.job = paramJ;
  }
  
  public void dispose()
  {
    Job localJob = this.job;
    if (localJob != null)
    {
      ((JobSupport)localJob).removeNode$kotlinx_coroutines_core(this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
  }
  
  @Nullable
  public NodeList getList()
  {
    return null;
  }
  
  public boolean isActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobNode
 * JD-Core Version:    0.7.0.1
 */