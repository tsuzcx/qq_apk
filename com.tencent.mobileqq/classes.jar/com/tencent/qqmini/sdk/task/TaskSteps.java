package com.tencent.qqmini.sdk.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskSteps;", "", "containerTask", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "subTasks", "", "(Lcom/tencent/qqmini/sdk/task/BaseTask;Ljava/util/List;)V", "currentStep", "getCurrentStep", "()Lcom/tencent/qqmini/sdk/task/BaseTask;", "currentStepIndex", "", "currentStepOrNull", "getCurrentStepOrNull", "isExecuting", "", "()Z", "executeNextStep", "", "getStepExecutionStatics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "onStepDone", "task", "start", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public final class TaskSteps
{
  private final BaseTask containerTask;
  private int currentStepIndex;
  private final List<BaseTask> subTasks;
  
  public TaskSteps(@NotNull BaseTask paramBaseTask, @NotNull List<? extends BaseTask> paramList)
  {
    this.containerTask = paramBaseTask;
    this.subTasks = paramList;
    this.currentStepIndex = -1;
    paramBaseTask = new TaskSteps.callback.1(this);
    paramList = ((Iterable)this.subTasks).iterator();
    while (paramList.hasNext()) {
      ((BaseTask)paramList.next()).setCallback((BaseTask.Callback)paramBaseTask);
    }
  }
  
  private final void executeNextStep()
  {
    this.currentStepIndex += 1;
    if (this.currentStepIndex >= this.subTasks.size())
    {
      this.containerTask.onTaskSucceed();
      return;
    }
    getCurrentStep().run();
  }
  
  private final void onStepDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask.isSucceed())
    {
      executeNextStep();
      return;
    }
    this.currentStepIndex = -1;
    this.containerTask.onTaskFailed(paramBaseTask.retCode, paramBaseTask.msg);
  }
  
  @NotNull
  public final BaseTask getCurrentStep()
  {
    return (BaseTask)this.subTasks.get(this.currentStepIndex);
  }
  
  @Nullable
  public final BaseTask getCurrentStepOrNull()
  {
    int i = ((Collection)this.subTasks).size();
    int j = this.currentStepIndex;
    if ((j >= 0) && (i > j)) {
      return (BaseTask)this.subTasks.get(j);
    }
    return null;
  }
  
  @NotNull
  public final List<TaskExecutionStatics> getStepExecutionStatics()
  {
    Object localObject = (Iterable)this.subTasks;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((BaseTask)((Iterator)localObject).next()).getExecutionStatics());
    }
    return (List)localCollection;
  }
  
  public final boolean isExecuting()
  {
    int i = ((Collection)this.subTasks).size();
    int j = this.currentStepIndex;
    return (j >= 0) && (i > j);
  }
  
  public final void start()
  {
    if (this.currentStepIndex == -1)
    {
      executeNextStep();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("already executing ");
    localStringBuilder.append(getCurrentStep());
    localStringBuilder.append('!');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskSteps
 * JD-Core Version:    0.7.0.1
 */