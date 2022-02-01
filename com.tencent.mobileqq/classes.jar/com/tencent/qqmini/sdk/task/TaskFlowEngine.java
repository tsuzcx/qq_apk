package com.tencent.qqmini.sdk.task;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine
  implements Handler.Callback, BaseTask.Callback
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final int STATUS_DONE = 5;
  public static final int STATUS_INIT = 1;
  public static final int STATUS_PAUSE = 3;
  public static final int STATUS_RUNNING = 2;
  public static final int STATUS_SLEEP = 4;
  public static final String TAG = "TaskFlow";
  protected List<BaseTask> mAllTasks = new ArrayList();
  private final List<TaskFlowEngine.DependFlow> mFlows = new ArrayList();
  private int mStatus = 1;
  protected TaskThreadPool mTaskThreadPool;
  protected BaseTask[] mTasks;
  
  public TaskFlowEngine()
  {
    for (;;)
    {
      try
      {
        i = DeviceInfoUtil.getNumberOfCPUCores();
        if (DeviceInfoUtil.getPerfLevel() == 3) {
          i = WnsConfig.getConfig("qqminiapp", "mini_app_low_level_device_thread_count", 2);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create thread pool, poolSize=");
        int j = i + 1;
        localStringBuilder.append(j);
        QMLog.w("TaskFlow", localStringBuilder.toString());
        if (i > 0)
        {
          i = j;
          this.mTaskThreadPool = new TaskThreadPool("TaskFlowEngine", 2, i);
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("TaskFlow", "create thread pool error!", localException);
        return;
      }
      int i = 2;
    }
  }
  
  private void initCallback(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    paramBaseTask.setCallback(this);
    if (!this.mAllTasks.contains(paramBaseTask)) {
      this.mAllTasks.add(paramBaseTask);
    }
    paramBaseTask = paramBaseTask.getDependTasks();
    if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
    {
      paramBaseTask = paramBaseTask.iterator();
      while (paramBaseTask.hasNext()) {
        initCallback((BaseTask)paramBaseTask.next());
      }
    }
  }
  
  public boolean checkAllTaskIsDone()
  {
    BaseTask[] arrayOfBaseTask = this.mTasks;
    if (arrayOfBaseTask == null) {
      return false;
    }
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfBaseTask[i].isDone()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected void executeTask(BaseTask arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.getDependTasks();
    if ((localList != null) && (localList.size() > 0))
    {
      int j = 0;
      Object localObject2 = this.mFlows.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((TaskFlowEngine.DependFlow)((Iterator)localObject2).next()).mTask != ???);
      int i = 1;
      if (i == 0)
      {
        localObject2 = new TaskFlowEngine.DependFlow(this, ???, localList);
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
        }
      }
      ??? = localObject1.iterator();
      while (???.hasNext()) {
        executeTask((BaseTask)???.next());
      }
      return;
    }
    ???.run();
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(BaseTask[] paramArrayOfBaseTask)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfBaseTask;
    paramArrayOfBaseTask = this.mTasks;
    if (paramArrayOfBaseTask == null) {
      return;
    }
    int j = paramArrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      initCallback(paramArrayOfBaseTask[i]);
      i += 1;
    }
  }
  
  public boolean isPause()
  {
    return this.mStatus == 3;
  }
  
  public boolean isRunning()
  {
    return this.mStatus == 2;
  }
  
  public void onTaskBegin(BaseTask paramBaseTask) {}
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (isPause()) {
      return;
    }
    if (paramBaseTask.isSucceed()) {
      this.mTaskThreadPool.addExecuteTask(new TaskFlowEngine.3(this, paramBaseTask));
    }
  }
  
  public void onTaskEnd(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    if (checkAllTaskIsDone()) {
      setStatus(5);
    }
    if (isPause()) {
      return;
    }
    onTaskDone(paramBaseTask);
  }
  
  public void pause()
  {
    QMLog.i("TaskFlow", "pause");
    setStatus(3);
  }
  
  protected void resetTaskAndDepends(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    paramBaseTask.reset();
    Iterator localIterator = this.mAllTasks.iterator();
    while (localIterator.hasNext())
    {
      BaseTask localBaseTask = (BaseTask)localIterator.next();
      if (localBaseTask.isDependTo(paramBaseTask)) {
        localBaseTask.reset();
      }
    }
  }
  
  public void resume()
  {
    QMLog.i("TaskFlow", "resume");
    BaseTask[] arrayOfBaseTask = this.mTasks;
    if (arrayOfBaseTask != null)
    {
      if (arrayOfBaseTask.length <= 0) {
        return;
      }
      setStatus(2);
      this.mTaskThreadPool.addExecuteTask(new TaskFlowEngine.2(this));
    }
  }
  
  public void setStatus(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStatus ");
      localStringBuilder.append(paramInt);
      QMLog.i("TaskFlow", localStringBuilder.toString());
      this.mStatus = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void start()
  {
    BaseTask[] arrayOfBaseTask = this.mTasks;
    if (arrayOfBaseTask != null)
    {
      if (arrayOfBaseTask.length <= 0) {
        return;
      }
      setStatus(2);
      this.mTaskThreadPool.addExecuteTask(new TaskFlowEngine.1(this));
    }
  }
  
  protected void updateFlow(BaseTask paramBaseTask)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        TaskFlowEngine.DependFlow localDependFlow = (TaskFlowEngine.DependFlow)localIterator.next();
        if (localDependFlow.isDepend(paramBaseTask)) {
          localDependFlow.onDependCompleted();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramBaseTask;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine
 * JD-Core Version:    0.7.0.1
 */