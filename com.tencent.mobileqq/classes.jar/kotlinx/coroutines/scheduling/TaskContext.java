package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/TaskContext;", "", "taskMode", "", "getTaskMode", "()I", "afterTask", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface TaskContext
{
  public abstract void afterTask();
  
  public abstract int getTaskMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.TaskContext
 * JD-Core Version:    0.7.0.1
 */