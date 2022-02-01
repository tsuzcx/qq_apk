package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/NonBlockingContext;", "Lkotlinx/coroutines/scheduling/TaskContext;", "()V", "taskMode", "", "getTaskMode", "()I", "afterTask", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class NonBlockingContext
  implements TaskContext
{
  public static final NonBlockingContext INSTANCE = new NonBlockingContext();
  private static final int taskMode = 0;
  
  public void afterTask() {}
  
  public int getTaskMode()
  {
    return taskMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.NonBlockingContext
 * JD-Core Version:    0.7.0.1
 */