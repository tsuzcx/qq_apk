package com.tencent.upload.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.network.session.SessionPool.PoolStateListener;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.task.BaseTask;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.TaskStateListener;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.BatchControlTask;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.PriorityThreadPoolExecutor;
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class UploadTaskManager
  implements SessionPool.PoolStateListener, TaskStateListener
{
  private static final String TAG = "UploadTaskManager";
  private boolean bStopAllLogTask;
  private long last;
  private Handler mHandler;
  private long mMaxDispatchNum = 1L;
  private LinkedBlockingQueue<AbstractUploadTask> mRunningList;
  private final Map<Const.FileType, SessionPool> mSessionPools;
  private LinkedBlockingQueue<AbstractUploadTask> mTaskList;
  private ThreadPool mThreadPool;
  
  public UploadTaskManager(ThreadPool paramThreadPool)
  {
    this.mThreadPool = paramThreadPool;
    this.mSessionPools = new HashMap();
    this.mTaskList = new LinkedBlockingQueue();
    this.mRunningList = new LinkedBlockingQueue();
    paramThreadPool = new HandlerThread("Dispatcher");
    paramThreadPool.start();
    this.mHandler = new Handler(paramThreadPool.getLooper());
  }
  
  public UploadTaskManager(ThreadPool paramThreadPool, int paramInt)
  {
    this(paramThreadPool);
    this.mMaxDispatchNum = paramInt;
  }
  
  private boolean checkCondition(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = paramAbstractUploadTask.onVerifyUploadFile();
    Const.FileType localFileType = getTaskType(paramAbstractUploadTask);
    SessionPool localSessionPool = (SessionPool)this.mSessionPools.get(localFileType);
    StringBuilder localStringBuilder = new StringBuilder().append("getSessionPool pool:");
    if (localSessionPool != null) {}
    for (paramAbstractUploadTask = Integer.valueOf(localSessionPool.hashCode());; paramAbstractUploadTask = "null")
    {
      UploadLog.d("UploadTaskManager", paramAbstractUploadTask);
      if (localSessionPool != null) {
        break;
      }
      paramAbstractUploadTask = new SessionPool(localFileType);
      paramAbstractUploadTask.registerListener(this);
      paramAbstractUploadTask.init();
      this.mSessionPools.put(localFileType, paramAbstractUploadTask);
      return false;
    }
    UploadLog.d("UploadTaskManager", "ret:" + bool + " pool is ready:" + localSessionPool.isReady());
    if ((bool) && (localSessionPool.isReady())) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean checkEmpty()
  {
    if ((this.mTaskList.size() == 0) && (this.mRunningList.size() == 0))
    {
      UploadLog.d("UploadTaskManager", "uploadTaskManager checkEmpty empty == true");
      Iterator localIterator = this.mSessionPools.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Const.FileType)localIterator.next();
        localObject = (SessionPool)this.mSessionPools.get(localObject);
        if (localObject != null) {
          ((SessionPool)localObject).setCloseTimer();
        }
      }
      return true;
    }
    return false;
  }
  
  private void cleanSessionPools()
  {
    Iterator localIterator = this.mSessionPools.keySet().iterator();
    while (localIterator.hasNext())
    {
      Const.FileType localFileType = (Const.FileType)localIterator.next();
      ((SessionPool)this.mSessionPools.get(localFileType)).cleanSessions();
    }
  }
  
  private void clearAllLogTask()
  {
    UploadLog.d("UploadTaskManager", "clearAllLogTask !");
    AbstractUploadTask localAbstractUploadTask;
    synchronized (this.mTaskList)
    {
      Iterator localIterator1 = this.mTaskList.iterator();
      while (localIterator1.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator1.next();
        if (localAbstractUploadTask.getFileType() == Const.FileType.Log) {
          this.mTaskList.remove(localAbstractUploadTask);
        }
      }
    }
    synchronized (this.mRunningList)
    {
      Iterator localIterator2 = this.mRunningList.iterator();
      while (localIterator2.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator2.next();
        if (localAbstractUploadTask.getFileType() == Const.FileType.Log) {
          localAbstractUploadTask.onError(Const.UploadRetCode.SERVER_DISCONNECT.getCode(), Const.UploadRetCode.SERVER_DISCONNECT.getDesc());
        }
      }
    }
  }
  
  private void dumpAllTasksState()
  {
    StringBuilder localStringBuilder = new StringBuilder("pending:").append(this.mTaskList.size());
    Iterator localIterator = this.mTaskList.iterator();
    AbstractUploadTask localAbstractUploadTask;
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder.append(" [" + localAbstractUploadTask.flowId + " state:" + localAbstractUploadTask.getTaskState() + "]");
    }
    UploadLog.d("UploadTaskManager", localStringBuilder.toString());
    localStringBuilder.setLength(0);
    localStringBuilder.append("running:").append(this.mRunningList.size());
    localIterator = this.mRunningList.iterator();
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder.append(" [" + localAbstractUploadTask.flowId + " state:" + localAbstractUploadTask.getTaskState() + "]");
    }
    UploadLog.d("UploadTaskManager", localStringBuilder.toString());
  }
  
  private AbstractUploadTask getTask()
  {
    ??? = null;
    if (this.mTaskList.size() <= 0) {
      return null;
    }
    Object localObject1;
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      do
      {
        localObject1 = ???;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbstractUploadTask)localIterator.next();
      } while (((AbstractUploadTask)localObject1).getTaskState() != TaskState.WAITING);
      this.mTaskList.remove(localObject1);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      synchronized (this.mRunningList)
      {
        this.mRunningList.add(localObject1);
        ((AbstractUploadTask)localObject1).bindHandler(this.mHandler);
        ??? = new StringBuilder().append("getTask, move task from pending to running, taskId:");
        if (localObject1 != null)
        {
          ??? = ((AbstractUploadTask)localObject1).getTaskId() + " taskType:" + localObject1.getClass().getSimpleName();
          UploadLog.d("UploadTaskManager", (String)???);
          return localObject1;
          localObject2 = finally;
          throw localObject2;
        }
      }
      ??? = "";
    }
  }
  
  public static Const.FileType getTaskType(AbstractUploadTask paramAbstractUploadTask)
  {
    return paramAbstractUploadTask.getUploadTaskType().serverRouteTable.supportFileType;
  }
  
  private boolean hasRemainTasks(Const.FileType paramFileType)
  {
    Iterator localIterator = this.mTaskList.iterator();
    while (localIterator.hasNext()) {
      if (getTaskType((AbstractUploadTask)localIterator.next()) == paramFileType) {
        return true;
      }
    }
    localIterator = this.mRunningList.iterator();
    while (localIterator.hasNext()) {
      if (getTaskType((AbstractUploadTask)localIterator.next()) == paramFileType) {
        return true;
      }
    }
    return false;
  }
  
  private void next()
  {
    boolean bool = UploadConfiguration.isNetworkAvailable();
    UploadLog.i("UploadTaskManager", "next --- Pending:" + this.mTaskList.size() + ", Running:" + this.mRunningList.size() + ", network:" + bool);
    dumpAllTasksState();
    if (!bool) {
      return;
    }
    if (this.mRunningList.size() >= this.mMaxDispatchNum)
    {
      UploadLog.d("UploadTaskManager", "channel is full now! mMaxDispatchNum:" + this.mMaxDispatchNum + " thread pool:" + UploadThreadManager.getInstance().toString());
      return;
    }
    Object localObject = getTask();
    if ((localObject != null) && (checkCondition((AbstractUploadTask)localObject)))
    {
      runTask((AbstractUploadTask)localObject);
      return;
    }
    if (localObject == null) {
      UploadLog.d("UploadTaskManager", "getTask return null!");
    }
    for (;;)
    {
      dumpAllTasksState();
      UploadLog.i("UploadTaskManager", "next end ---");
      return;
      ((AbstractUploadTask)localObject).setState(TaskState.PAUSE);
      localObject = (SessionPool)this.mSessionPools.get(getTaskType((AbstractUploadTask)localObject));
      if ((localObject != null) && (!((SessionPool)localObject).isReady()))
      {
        UploadLog.d("UploadTaskManager", "getSessionPool: " + localObject.hashCode() + " is not ready, reset it");
        ((SessionPool)localObject).reset();
      }
    }
  }
  
  private void recovery(Const.FileType paramFileType)
  {
    UploadLog.d("UploadTaskManager", "recovery -- mRunningList:" + this.mRunningList.size());
    if (this.mRunningList.size() > 0)
    {
      Iterator localIterator = this.mRunningList.iterator();
      while (localIterator.hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((getTaskType(localAbstractUploadTask) == paramFileType) && ((localAbstractUploadTask.getTaskState() == TaskState.FAILED) || (localAbstractUploadTask.getTaskState() == TaskState.CONNECTING) || (localAbstractUploadTask.getTaskState() == TaskState.PAUSE)))
        {
          UploadLog.d("UploadTaskManager", "recovery taskId:" + localAbstractUploadTask.getTaskId() + " state:" + localAbstractUploadTask.getTaskState() + ", path:" + localAbstractUploadTask.getFilePath());
          localAbstractUploadTask.resetTask();
          runTask(localAbstractUploadTask);
        }
      }
    }
    next();
  }
  
  private void runTask(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadTaskManager", "runTask -- [" + paramAbstractUploadTask.getClass().getSimpleName() + "], flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.getFilePath());
    CacheUtil.setCachedSessionId(paramAbstractUploadTask);
    PriorityThreadPoolExecutor localPriorityThreadPoolExecutor = this.mThreadPool.getExecutor();
    SessionPool localSessionPool = getSessionPool(paramAbstractUploadTask);
    if (localSessionPool != null) {
      localSessionPool.removeCloseTimer();
    }
    paramAbstractUploadTask.bindThreadPool(localPriorityThreadPoolExecutor);
    paramAbstractUploadTask.bindSessionPool(localSessionPool);
    paramAbstractUploadTask.setTaskId(paramAbstractUploadTask.flowId);
    paramAbstractUploadTask.start();
  }
  
  public void allIpFailed(SessionPool paramSessionPool)
  {
    if (paramSessionPool == null) {}
    for (;;)
    {
      return;
      if (paramSessionPool.getPoolType() == Const.FileType.Log)
      {
        this.bStopAllLogTask = true;
        clearAllLogTask();
        return;
      }
      Iterator localIterator = this.mRunningList.iterator();
      while (localIterator.hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        UploadLog.d("UploadTaskManager", "allIpFailed getTaskType(task):" + getTaskType(localAbstractUploadTask) + " pool.getPoolType():" + paramSessionPool.getPoolType() + " task.getFileType():" + localAbstractUploadTask.getFileType());
        if ((getTaskType(localAbstractUploadTask) == paramSessionPool.getPoolType()) || ((localAbstractUploadTask instanceof BatchControlTask))) {
          localAbstractUploadTask.onError(Const.UploadRetCode.ALL_IP_FAILED.getCode(), Const.UploadRetCode.ALL_IP_FAILED.getDesc());
        }
      }
    }
  }
  
  public void cancelAllTasks()
  {
    UploadLog.d("UploadTaskManager", "cancelAllTasks --- ");
    this.mHandler.post(new UploadTaskManager.4(this));
  }
  
  public void cancelTask(AbstractUploadTask paramAbstractUploadTask)
  {
    this.mHandler.post(new UploadTaskManager.3(this, paramAbstractUploadTask));
  }
  
  public void close()
  {
    UploadLog.d("UploadTaskManager", "uploadTaskManger is close... clear list !!!");
    this.mTaskList.clear();
    this.mRunningList.clear();
    cleanSessionPools();
  }
  
  public int getRemainTaskSize()
  {
    dumpAllTasksState();
    if ((this.mTaskList != null) && (this.mRunningList != null))
    {
      Iterator localIterator = this.mTaskList.iterator();
      int i = 0;
      AbstractUploadTask localAbstractUploadTask;
      while (localIterator.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((localAbstractUploadTask.getTaskState().getCode() != TaskState.CANCEL.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.FAILED.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.SUCCEED.getCode())) {
          i += 1;
        }
      }
      localIterator = this.mRunningList.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if ((localAbstractUploadTask.getTaskState().getCode() != TaskState.CANCEL.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.FAILED.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.SUCCEED.getCode())) {
          i += 1;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public SessionPool getSessionPool(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = getTaskType(paramAbstractUploadTask);
    return (SessionPool)this.mSessionPools.get(paramAbstractUploadTask);
  }
  
  public AbstractUploadTask getTask(int paramInt)
  {
    Iterator localIterator = new ArrayList(this.mTaskList).iterator();
    while (localIterator.hasNext())
    {
      AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      if (paramInt == localAbstractUploadTask.getTaskId()) {
        return localAbstractUploadTask;
      }
    }
    return null;
  }
  
  public void onSessionPoolError(SessionPool paramSessionPool, int paramInt)
  {
    UploadLog.d("UploadTaskManager", "no available sessions !");
    if (hasRemainTasks(paramSessionPool.getPoolType()))
    {
      UploadLog.d("UploadTaskManager", "hasRemainTask == true;");
      if (System.currentTimeMillis() - this.last > 1000L)
      {
        paramSessionPool.rebuildSessions();
        this.last = System.currentTimeMillis();
        UploadLog.d("UploadTaskManager", "rebuildSessions;");
      }
    }
  }
  
  public void onSessionPoolRestore(Const.FileType paramFileType)
  {
    UploadLog.w("UploadTaskManager", "onSessionPoolRestore type: " + paramFileType);
    this.mHandler.postDelayed(new UploadTaskManager.5(this, paramFileType), 500L);
  }
  
  public void onTaskFinished(BaseTask paramBaseTask, int paramInt, String arg3)
  {
    if ((paramBaseTask instanceof AbstractUploadTask))
    {
      UploadLog.d("UploadTaskManager", "taskId:" + paramBaseTask.getTaskId() + " onTaskFinished state: " + paramBaseTask.getTaskState() + " ret:" + paramInt + " msg:" + ???);
      if (paramBaseTask.getTaskState() == TaskState.SUCCEED) {
        synchronized (this.mRunningList)
        {
          this.mRunningList.remove(paramBaseTask);
          UploadLog.d("UploadTaskManager", "remove -- flowid:" + ((AbstractUploadTask)paramBaseTask).flowId);
          if (!checkEmpty()) {
            next();
          }
          return;
        }
      }
      if ((paramBaseTask.getTaskState() != TaskState.FAILED) && (paramBaseTask.getTaskState() != TaskState.CANCEL)) {}
    }
    synchronized (this.mRunningList)
    {
      this.mRunningList.remove(paramBaseTask);
      UploadLog.d("UploadTaskManager", "remove -- flowid:" + ((AbstractUploadTask)paramBaseTask).flowId);
      if ((paramBaseTask.getFileType() == Const.FileType.Log) && (paramInt == Const.UploadRetCode.SERVER_DISCONNECT.getCode()))
      {
        this.bStopAllLogTask = true;
        clearAllLogTask();
      }
      if (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode())
      {
        UploadLog.w("UploadTaskManager", "taskId:" + paramBaseTask.getTaskId() + " post next() delay 500ms");
        this.mHandler.postAtTime(new UploadTaskManager.2(this), 500L);
        return;
      }
    }
    next();
  }
  
  public void onTaskInfoChanged(BaseTask paramBaseTask) {}
  
  public void prepare(Const.FileType paramFileType)
  {
    if ((SessionPool)this.mSessionPools.get(paramFileType) == null)
    {
      UploadLog.d("UploadTaskManager", "prepare pool == null need create new, type:" + paramFileType);
      SessionPool localSessionPool = new SessionPool(paramFileType);
      localSessionPool.registerListener(this);
      localSessionPool.init();
      this.mSessionPools.put(paramFileType, localSessionPool);
    }
  }
  
  public void reset()
  {
    Iterator localIterator = this.mSessionPools.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Const.FileType)localIterator.next();
      localObject = (SessionPool)this.mSessionPools.get(localObject);
      if (localObject != null) {
        ((SessionPool)localObject).reset();
      }
    }
  }
  
  public boolean sendAsync(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    if ((this.bStopAllLogTask) && (paramAbstractUploadTask.getFileType() == Const.FileType.Log))
    {
      UploadLog.d("UploadTaskManager", "bStopAllLogTask now ! ");
      return false;
    }
    if (paramAbstractUploadTask.getTaskState() != TaskState.WAITING) {
      paramAbstractUploadTask.resetWaitState();
    }
    synchronized (this.mTaskList)
    {
      this.mTaskList.add(paramAbstractUploadTask);
      paramAbstractUploadTask.setTaskStateListener(this);
      if (!UploadConfiguration.isNetworkAvailable())
      {
        UploadLog.w("UploadTaskManager", "sendAsync network is not available");
        prepare(getTaskType(paramAbstractUploadTask));
        return false;
      }
    }
    return this.mHandler.post(new UploadTaskManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.upload.impl.UploadTaskManager
 * JD-Core Version:    0.7.0.1
 */