package com.tencent.mobileqq.mini.tfs;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine
  implements Handler.Callback, BaseTask.Callback
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  private List<BaseTask> mAllTasks = new ArrayList();
  protected Handler mEngineHandler;
  private List<TaskFlowEngine.DependFlow> mFlows = new ArrayList();
  private BaseTask[] mTasks;
  
  public TaskFlowEngine()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("TaskFlow", 5);
      localObject1 = localHandlerThread;
      localObject3 = localHandlerThread;
      localHandlerThread.start();
      if ((localHandlerThread != null) && (localHandlerThread.isAlive()))
      {
        this.mEngineHandler = new Handler(localHandlerThread.getLooper(), this);
        return;
      }
      this.mEngineHandler = new Handler(Looper.getMainLooper(), this);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      QLog.e("TaskFlow", 1, "create thread error!", localException);
      if ((localObject1 != null) && (localObject1.isAlive()))
      {
        this.mEngineHandler = new Handler(localObject1.getLooper(), this);
        return;
      }
      this.mEngineHandler = new Handler(Looper.getMainLooper(), this);
      return;
    }
    finally
    {
      if (localObject3 == null) {
        break label175;
      }
    }
    if (localObject3.isAlive()) {}
    label175:
    for (this.mEngineHandler = new Handler(localObject3.getLooper(), this);; this.mEngineHandler = new Handler(Looper.getMainLooper(), this)) {
      throw localObject2;
    }
  }
  
  private void executeTask(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    List localList = paramBaseTask.getDependTasks();
    if ((localList == null) || (localList.size() <= 0))
    {
      paramBaseTask.run();
      return;
    }
    Iterator localIterator = this.mFlows.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((TaskFlowEngine.DependFlow)localIterator.next()).mTask != paramBaseTask);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramBaseTask = new TaskFlowEngine.DependFlow(this, paramBaseTask, localList);
        this.mFlows.add(paramBaseTask);
      }
      paramBaseTask = localList.iterator();
      while (paramBaseTask.hasNext()) {
        executeTask((BaseTask)paramBaseTask.next());
      }
      break;
    }
  }
  
  private void initCallback(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
      paramBaseTask.setCallback(this);
      paramBaseTask.setWorkLooper(this.mEngineHandler.getLooper());
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
  }
  
  public Looper getWorkThreadLooper()
  {
    return this.mEngineHandler.getLooper();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(BaseTask[] paramArrayOfBaseTask)
  {
    this.mFlows.clear();
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfBaseTask;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfBaseTask = this.mTasks;
      int j = paramArrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(BaseTask paramBaseTask) {}
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    while (!paramBaseTask.isSucceed()) {
      return;
    }
    this.mEngineHandler.post(new TaskFlowEngine.2(this, paramBaseTask));
  }
  
  public void resetTaskAndDepends(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
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
  }
  
  public void start()
  {
    if ((this.mTasks == null) || (this.mTasks.length <= 0)) {
      return;
    }
    this.mEngineHandler.post(new TaskFlowEngine.1(this));
  }
  
  protected void updateFlow(BaseTask paramBaseTask)
  {
    Iterator localIterator = this.mFlows.iterator();
    while (localIterator.hasNext())
    {
      TaskFlowEngine.DependFlow localDependFlow = (TaskFlowEngine.DependFlow)localIterator.next();
      if (localDependFlow.isDepend(paramBaseTask)) {
        localDependFlow.onDependCompleted();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskFlowEngine
 * JD-Core Version:    0.7.0.1
 */