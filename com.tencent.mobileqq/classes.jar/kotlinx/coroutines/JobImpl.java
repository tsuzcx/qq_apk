package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class JobImpl
  extends JobSupport
  implements CompletableJob
{
  private final boolean handlesException;
  
  public JobImpl(@Nullable Job paramJob)
  {
    super(true);
    initParentJobInternal$kotlinx_coroutines_core(paramJob);
    this.handlesException = handlesException();
  }
  
  private final boolean handlesException()
  {
    ChildHandle localChildHandle = getParentHandle$kotlinx_coroutines_core();
    Object localObject = localChildHandle;
    if (!(localChildHandle instanceof ChildHandleNode)) {
      localObject = null;
    }
    localObject = (ChildHandleNode)localObject;
    if (localObject != null)
    {
      localObject = (JobSupport)((ChildHandleNode)localObject).job;
      if (localObject != null) {
        do
        {
          if (((JobSupport)localObject).getHandlesException$kotlinx_coroutines_core()) {
            return true;
          }
          localChildHandle = ((JobSupport)localObject).getParentHandle$kotlinx_coroutines_core();
          localObject = localChildHandle;
          if (!(localChildHandle instanceof ChildHandleNode)) {
            localObject = null;
          }
          localObject = (ChildHandleNode)localObject;
          if (localObject == null) {
            break;
          }
          localObject = (JobSupport)((ChildHandleNode)localObject).job;
        } while (localObject != null);
      }
    }
    return false;
  }
  
  public boolean complete()
  {
    return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
  }
  
  public boolean completeExceptionally(@NotNull Throwable paramThrowable)
  {
    return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(paramThrowable, false, 2, null));
  }
  
  public boolean getHandlesException$kotlinx_coroutines_core()
  {
    return this.handlesException;
  }
  
  public boolean getOnCancelComplete$kotlinx_coroutines_core()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobImpl
 * JD-Core Version:    0.7.0.1
 */