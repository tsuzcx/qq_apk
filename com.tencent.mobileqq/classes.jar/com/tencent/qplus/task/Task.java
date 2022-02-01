package com.tencent.qplus.task;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qplus.swingworker.ScheduleLinkedBlockingQueue;
import com.tencent.qplus.swingworker.SchedulingRule;
import com.tencent.qplus.swingworker.ThreadPoolExecutor;
import com.tencent.qplus.swingworker.WorkerUtilities;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class Task<ReturnResult, InterParam>
  extends AbstractTask<ReturnResult, InterParam>
  implements SchedulingRule
{
  private static TaskMonitor taskMonitor;
  private static TaskService taskService;
  private AbstractTask.BlockingScope blockScope;
  private String group;
  private Object sources;
  
  public Task(Context paramContext)
  {
    this(paramContext, AbstractTask.BlockingScope.NONE, null);
  }
  
  public Task(Context paramContext, Resources paramResources)
  {
    super(paramContext, paramResources);
  }
  
  public Task(Context paramContext, AbstractTask.BlockingScope paramBlockingScope, Object paramObject)
  {
    super(paramContext);
    this.blockScope = paramBlockingScope;
    this.sources = paramObject;
  }
  
  public Task(Context paramContext, AbstractTask.BlockingScope paramBlockingScope, Object paramObject, int paramInt)
  {
    super(paramContext);
    setDescription(paramContext.getResources().getString(paramInt));
    this.blockScope = paramBlockingScope;
    this.sources = paramObject;
  }
  
  public Task(Context paramContext, AbstractTask.BlockingScope paramBlockingScope, Object paramObject, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setTitle(paramContext.getResources().getString(paramInt1));
    setDescription(paramContext.getResources().getString(paramInt2));
    this.blockScope = paramBlockingScope;
    this.sources = paramObject;
  }
  
  private AbstractTask.InputBlocker createInputBlocker()
  {
    return null;
  }
  
  public static TaskService getService()
  {
    try
    {
      if (taskService == null)
      {
        localObject1 = new ScheduleLinkedBlockingQueue();
        Object localObject3 = new Task.2();
        localObject3 = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, (BlockingQueue)localObject1, (ThreadFactory)localObject3);
        ((ScheduleLinkedBlockingQueue)localObject1).setExecutor((ThreadPoolExecutor)localObject3);
        taskService = new TaskService("default", (ExecutorService)localObject3);
        taskMonitor = new TaskMonitor(taskService);
      }
      Object localObject1 = taskService;
      return localObject1;
    }
    finally {}
  }
  
  public static TaskMonitor getTaskMonitor()
  {
    try
    {
      if (taskService == null) {
        getService();
      }
      TaskMonitor localTaskMonitor = taskMonitor;
      return localTaskMonitor;
    }
    finally {}
  }
  
  public void execute()
  {
    if (!isCancelled())
    {
      if (getInputBlocker() == null) {
        setInputBlocker(createInputBlocker());
      }
      getService().execute(this);
    }
  }
  
  public void execute(long paramLong)
  {
    if (paramLong <= 0L)
    {
      execute();
      return;
    }
    WorkerUtilities.invokeInLooper(new Task.1(this), paramLong);
  }
  
  public String getGroup()
  {
    return this.group;
  }
  
  public boolean isConflicting(SchedulingRule paramSchedulingRule)
  {
    if (((paramSchedulingRule instanceof Task)) && (this.group != null) && (((Task)paramSchedulingRule).group != null) && (!isCancelled()) && (!((Task)paramSchedulingRule).isCancelled())) {
      return this.group == ((Task)paramSchedulingRule).group;
    }
    return false;
  }
  
  public void setGroup(String paramString)
  {
    this.group = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.Task
 * JD-Core Version:    0.7.0.1
 */