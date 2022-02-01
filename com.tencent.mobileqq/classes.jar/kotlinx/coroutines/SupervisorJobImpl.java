package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/SupervisorJobImpl;", "Lkotlinx/coroutines/JobImpl;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SupervisorJobImpl
  extends JobImpl
{
  public SupervisorJobImpl(@Nullable Job paramJob)
  {
    super(paramJob);
  }
  
  public boolean childCancelled(@NotNull Throwable paramThrowable)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.SupervisorJobImpl
 * JD-Core Version:    0.7.0.1
 */