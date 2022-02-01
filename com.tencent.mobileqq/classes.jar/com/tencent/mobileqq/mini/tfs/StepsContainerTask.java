package com.tencent.mobileqq.mini.tfs;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/tfs/StepsContainerTask;", "Lcom/tencent/mobileqq/mini/tfs/BaseTask;", "context", "Landroid/content/Context;", "subSteps", "", "(Landroid/content/Context;Ljava/util/List;)V", "steps", "Lcom/tencent/mobileqq/mini/tfs/TaskSteps;", "getSteps", "()Lcom/tencent/mobileqq/mini/tfs/TaskSteps;", "execute", "", "getSubTaskExecutionStatics", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "getTotalRunDurationMs", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class StepsContainerTask
  extends BaseTask
{
  @NotNull
  private final TaskSteps steps;
  
  public StepsContainerTask(@NotNull Context paramContext, @NotNull List<? extends BaseTask> paramList)
  {
    super(paramContext);
    this.steps = new TaskSteps((BaseTask)this, paramList);
  }
  
  protected void execute()
  {
    this.steps.start();
  }
  
  @NotNull
  protected final TaskSteps getSteps()
  {
    return this.steps;
  }
  
  @NotNull
  protected List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps.getStepExecutionStatics();
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.StepsContainerTask
 * JD-Core Version:    0.7.0.1
 */