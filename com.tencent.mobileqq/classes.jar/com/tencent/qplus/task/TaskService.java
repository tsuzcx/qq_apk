package com.tencent.qplus.task;

import com.tencent.qplus.swingworker.ThreadPoolExecutor;
import com.tencent.qplus.swingworker.WorkerUtilities;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskService
  extends AbstractBean
{
  private final ExecutorService executorService;
  private final String name;
  private final PropertyChangeListener taskPCL;
  private final List<AbstractTask> tasks;
  
  public TaskService(String paramString)
  {
    this(paramString, new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue()));
  }
  
  public TaskService(String paramString, ExecutorService paramExecutorService)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null name");
    }
    if (paramExecutorService == null) {
      throw new IllegalArgumentException("null executorService");
    }
    this.name = paramString;
    this.executorService = paramExecutorService;
    this.tasks = new ArrayList();
    this.taskPCL = new TaskService.TaskPCL(this, null);
  }
  
  private List<AbstractTask> copyTasksList()
  {
    synchronized (this.tasks)
    {
      if (this.tasks.isEmpty())
      {
        localObject1 = Collections.emptyList();
        return localObject1;
      }
      Object localObject1 = new ArrayList(this.tasks);
      return localObject1;
    }
  }
  
  private void maybeBlockTask(AbstractTask paramAbstractTask)
  {
    paramAbstractTask = paramAbstractTask.getInputBlocker();
    if (paramAbstractTask == null) {}
    while (paramAbstractTask.getScope() == AbstractTask.BlockingScope.NONE) {
      return;
    }
    if (WorkerUtilities.isUIThread())
    {
      paramAbstractTask.block();
      return;
    }
    WorkerUtilities.invokeInLooper(new TaskService.1(this, paramAbstractTask));
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.executorService.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(AbstractTask paramAbstractTask)
  {
    if (paramAbstractTask == null) {
      throw new IllegalArgumentException("null task");
    }
    if ((!paramAbstractTask.isPending()) || (paramAbstractTask.getTaskService() != null)) {
      throw new IllegalArgumentException("task has already been executed");
    }
    paramAbstractTask.setTaskService(this);
    synchronized (this.tasks)
    {
      List localList2 = copyTasksList();
      this.tasks.add(paramAbstractTask);
      List localList3 = copyTasksList();
      paramAbstractTask.addPropertyChangeListener(this.taskPCL);
      firePropertyChange("tasks", localList2, localList3);
      maybeBlockTask(paramAbstractTask);
      this.executorService.execute(paramAbstractTask);
      return;
    }
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public List<AbstractTask> getTasks()
  {
    return copyTasksList();
  }
  
  public final boolean isShutdown()
  {
    return this.executorService.isShutdown();
  }
  
  public final boolean isTerminated()
  {
    return this.executorService.isTerminated();
  }
  
  public final void shutdown()
  {
    this.executorService.shutdown();
  }
  
  public final List<Runnable> shutdownNow()
  {
    return this.executorService.shutdownNow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.task.TaskService
 * JD-Core Version:    0.7.0.1
 */