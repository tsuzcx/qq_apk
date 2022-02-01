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
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

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
    boolean bool3 = paramAbstractUploadTask.onVerifyUploadFile();
    Const.FileType localFileType = getTaskType(paramAbstractUploadTask);
    SessionPool localSessionPool = (SessionPool)this.mSessionPools.get(localFileType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSessionPool pool:");
    if (localSessionPool != null) {
      paramAbstractUploadTask = Integer.valueOf(localSessionPool.hashCode());
    } else {
      paramAbstractUploadTask = "null";
    }
    localStringBuilder.append(paramAbstractUploadTask);
    UploadLog.d("UploadTaskManager", localStringBuilder.toString());
    boolean bool2 = false;
    if (localSessionPool == null)
    {
      paramAbstractUploadTask = new SessionPool(localFileType);
      paramAbstractUploadTask.registerListener(this);
      paramAbstractUploadTask.init();
      this.mSessionPools.put(localFileType, paramAbstractUploadTask);
      return false;
    }
    paramAbstractUploadTask = new StringBuilder();
    paramAbstractUploadTask.append("ret:");
    paramAbstractUploadTask.append(bool3);
    paramAbstractUploadTask.append(" pool is ready:");
    paramAbstractUploadTask.append(localSessionPool.isReady());
    UploadLog.d("UploadTaskManager", paramAbstractUploadTask.toString());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (localSessionPool.isReady()) {
        bool1 = true;
      }
    }
    return bool1;
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
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      AbstractUploadTask localAbstractUploadTask;
      while (localIterator.hasNext())
      {
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
        if (localAbstractUploadTask.getFileType() == Const.FileType.Log) {
          this.mTaskList.remove(localAbstractUploadTask);
        }
      }
      synchronized (this.mRunningList)
      {
        localIterator = this.mRunningList.iterator();
        while (localIterator.hasNext())
        {
          localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
          if (localAbstractUploadTask.getFileType() == Const.FileType.Log) {
            localAbstractUploadTask.onError(Const.UploadRetCode.SERVER_DISCONNECT.getCode(), Const.UploadRetCode.SERVER_DISCONNECT.getDesc());
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void dumpAllTasksState()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("pending:");
    localStringBuilder1.append(this.mTaskList.size());
    Iterator localIterator = this.mTaskList.iterator();
    AbstractUploadTask localAbstractUploadTask;
    StringBuilder localStringBuilder2;
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" [");
      localStringBuilder2.append(localAbstractUploadTask.flowId);
      localStringBuilder2.append(" state:");
      localStringBuilder2.append(localAbstractUploadTask.getTaskState());
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    UploadLog.d("UploadTaskManager", localStringBuilder1.toString());
    localStringBuilder1.setLength(0);
    localStringBuilder1.append("running:");
    localStringBuilder1.append(this.mRunningList.size());
    localIterator = this.mRunningList.iterator();
    while (localIterator.hasNext())
    {
      localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" [");
      localStringBuilder2.append(localAbstractUploadTask.flowId);
      localStringBuilder2.append(" state:");
      localStringBuilder2.append(localAbstractUploadTask.getTaskState());
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    UploadLog.d("UploadTaskManager", localStringBuilder1.toString());
  }
  
  private AbstractUploadTask getTask()
  {
    int i = this.mTaskList.size();
    ??? = null;
    if (i <= 0) {
      return null;
    }
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      Object localObject1;
      do
      {
        localObject1 = ???;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbstractUploadTask)localIterator.next();
      } while (((AbstractUploadTask)localObject1).getTaskState() != TaskState.WAITING);
      this.mTaskList.remove(localObject1);
      if (localObject1 != null) {
        synchronized (this.mRunningList)
        {
          this.mRunningList.add(localObject1);
          ((AbstractUploadTask)localObject1).bindHandler(this.mHandler);
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getTask, move task from pending to running, taskId:");
      if (localAbstractUploadTask != null)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(localAbstractUploadTask.getTaskId());
        ((StringBuilder)???).append(" taskType:");
        ((StringBuilder)???).append(localAbstractUploadTask.getClass().getSimpleName());
        ??? = ((StringBuilder)???).toString();
      }
      else
      {
        ??? = "";
      }
      ((StringBuilder)???).append((String)???);
      UploadLog.d("UploadTaskManager", ((StringBuilder)???).toString());
      return localAbstractUploadTask;
    }
    for (;;)
    {
      throw localObject2;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("next --- Pending:");
    ((StringBuilder)localObject).append(this.mTaskList.size());
    ((StringBuilder)localObject).append(", Running:");
    ((StringBuilder)localObject).append(this.mRunningList.size());
    ((StringBuilder)localObject).append(", network:");
    ((StringBuilder)localObject).append(bool);
    UploadLog.i("UploadTaskManager", ((StringBuilder)localObject).toString());
    dumpAllTasksState();
    if (!bool) {
      return;
    }
    if (this.mRunningList.size() >= this.mMaxDispatchNum)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("channel is full now! mMaxDispatchNum:");
      ((StringBuilder)localObject).append(this.mMaxDispatchNum);
      ((StringBuilder)localObject).append(" thread pool:");
      ((StringBuilder)localObject).append(UploadThreadManager.getInstance().toString());
      UploadLog.d("UploadTaskManager", ((StringBuilder)localObject).toString());
      return;
    }
    localObject = getTask();
    if ((localObject != null) && (checkCondition((AbstractUploadTask)localObject)))
    {
      runTask((AbstractUploadTask)localObject);
      return;
    }
    if (localObject == null)
    {
      UploadLog.d("UploadTaskManager", "getTask return null!");
    }
    else
    {
      ((AbstractUploadTask)localObject).setState(TaskState.PAUSE);
      localObject = (SessionPool)this.mSessionPools.get(getTaskType((AbstractUploadTask)localObject));
      if ((localObject != null) && (!((SessionPool)localObject).isReady()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSessionPool: ");
        localStringBuilder.append(localObject.hashCode());
        localStringBuilder.append(" is not ready, reset it");
        UploadLog.d("UploadTaskManager", localStringBuilder.toString());
        ((SessionPool)localObject).reset();
      }
    }
    dumpAllTasksState();
    UploadLog.i("UploadTaskManager", "next end ---");
  }
  
  private void recovery(Const.FileType paramFileType)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recovery -- mRunningList:");
    ((StringBuilder)localObject).append(this.mRunningList.size());
    UploadLog.d("UploadTaskManager", ((StringBuilder)localObject).toString());
    if (this.mRunningList.size() > 0)
    {
      localObject = this.mRunningList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)((Iterator)localObject).next();
        if ((getTaskType(localAbstractUploadTask) == paramFileType) && ((localAbstractUploadTask.getTaskState() == TaskState.FAILED) || (localAbstractUploadTask.getTaskState() == TaskState.CONNECTING) || (localAbstractUploadTask.getTaskState() == TaskState.PAUSE)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("recovery taskId:");
          localStringBuilder.append(localAbstractUploadTask.getTaskId());
          localStringBuilder.append(" state:");
          localStringBuilder.append(localAbstractUploadTask.getTaskState());
          localStringBuilder.append(", path:");
          localStringBuilder.append(localAbstractUploadTask.getFilePath());
          UploadLog.d("UploadTaskManager", localStringBuilder.toString());
          localAbstractUploadTask.resetTask();
          runTask(localAbstractUploadTask);
        }
      }
    }
    next();
  }
  
  private void runTask(AbstractUploadTask paramAbstractUploadTask)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("runTask -- [");
    ((StringBuilder)localObject).append(paramAbstractUploadTask.getClass().getSimpleName());
    ((StringBuilder)localObject).append("], flowId:");
    ((StringBuilder)localObject).append(paramAbstractUploadTask.flowId);
    ((StringBuilder)localObject).append(", path:");
    ((StringBuilder)localObject).append(paramAbstractUploadTask.getFilePath());
    UploadLog.d("UploadTaskManager", ((StringBuilder)localObject).toString());
    CacheUtil.setCachedSessionId(paramAbstractUploadTask);
    localObject = this.mThreadPool.getExecutor();
    SessionPool localSessionPool = getSessionPool(paramAbstractUploadTask);
    if (localSessionPool != null) {
      localSessionPool.removeCloseTimer();
    }
    paramAbstractUploadTask.bindThreadPool((ThreadPoolExecutor)localObject);
    paramAbstractUploadTask.bindSessionPool(localSessionPool);
    paramAbstractUploadTask.setTaskId(paramAbstractUploadTask.flowId);
    paramAbstractUploadTask.start();
  }
  
  public void allIpFailed(SessionPool paramSessionPool)
  {
    if (paramSessionPool == null) {
      return;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allIpFailed getTaskType(task):");
      localStringBuilder.append(getTaskType(localAbstractUploadTask));
      localStringBuilder.append(" pool.getPoolType():");
      localStringBuilder.append(paramSessionPool.getPoolType());
      localStringBuilder.append(" task.getFileType():");
      localStringBuilder.append(localAbstractUploadTask.getFileType());
      UploadLog.d("UploadTaskManager", localStringBuilder.toString());
      if ((getTaskType(localAbstractUploadTask) == paramSessionPool.getPoolType()) || ((localAbstractUploadTask instanceof BatchControlTask))) {
        localAbstractUploadTask.onError(Const.UploadRetCode.ALL_IP_FAILED.getCode(), Const.UploadRetCode.ALL_IP_FAILED.getDesc());
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
    Object localObject = this.mTaskList;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (this.mRunningList != null)
      {
        localObject = ((LinkedBlockingQueue)localObject).iterator();
        AbstractUploadTask localAbstractUploadTask;
        while (((Iterator)localObject).hasNext())
        {
          localAbstractUploadTask = (AbstractUploadTask)((Iterator)localObject).next();
          if ((localAbstractUploadTask.getTaskState().getCode() != TaskState.CANCEL.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.FAILED.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.SUCCEED.getCode())) {
            i += 1;
          }
        }
        localObject = this.mRunningList.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localAbstractUploadTask = (AbstractUploadTask)((Iterator)localObject).next();
          if ((localAbstractUploadTask.getTaskState().getCode() != TaskState.CANCEL.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.FAILED.getCode()) && (localAbstractUploadTask.getTaskState().getCode() != TaskState.SUCCEED.getCode())) {
            i += 1;
          }
        }
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSessionPoolRestore type: ");
    localStringBuilder.append(paramFileType);
    UploadLog.w("UploadTaskManager", localStringBuilder.toString());
    this.mHandler.postDelayed(new UploadTaskManager.5(this, paramFileType), 500L);
  }
  
  public void onTaskFinished(BaseTask paramBaseTask, int paramInt, String arg3)
  {
    if ((paramBaseTask instanceof AbstractUploadTask))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("taskId:");
      localStringBuilder.append(paramBaseTask.getTaskId());
      localStringBuilder.append(" onTaskFinished state: ");
      localStringBuilder.append(paramBaseTask.getTaskState());
      localStringBuilder.append(" ret:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg:");
      localStringBuilder.append(???);
      UploadLog.d("UploadTaskManager", localStringBuilder.toString());
      if (paramBaseTask.getTaskState() == TaskState.SUCCEED) {
        synchronized (this.mRunningList)
        {
          this.mRunningList.remove(paramBaseTask);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove -- flowid:");
          localStringBuilder.append(((AbstractUploadTask)paramBaseTask).flowId);
          UploadLog.d("UploadTaskManager", localStringBuilder.toString());
          if (!checkEmpty()) {
            next();
          }
          return;
        }
      }
      if ((paramBaseTask.getTaskState() == TaskState.FAILED) || (paramBaseTask.getTaskState() == TaskState.CANCEL)) {
        synchronized (this.mRunningList)
        {
          this.mRunningList.remove(paramBaseTask);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove -- flowid:");
          localStringBuilder.append(((AbstractUploadTask)paramBaseTask).flowId);
          UploadLog.d("UploadTaskManager", localStringBuilder.toString());
          if ((paramBaseTask.getFileType() == Const.FileType.Log) && (paramInt == Const.UploadRetCode.SERVER_DISCONNECT.getCode()))
          {
            this.bStopAllLogTask = true;
            clearAllLogTask();
          }
        }
      }
    }
    if (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode())
    {
      ??? = new StringBuilder();
      ???.append("taskId:");
      ???.append(paramBaseTask.getTaskId());
      ???.append(" post next() delay 500ms");
      UploadLog.w("UploadTaskManager", ???.toString());
      this.mHandler.postAtTime(new UploadTaskManager.2(this), 500L);
      return;
    }
    next();
  }
  
  public void onTaskInfoChanged(BaseTask paramBaseTask) {}
  
  public void prepare(Const.FileType paramFileType)
  {
    if ((SessionPool)this.mSessionPools.get(paramFileType) == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepare pool == null need create new, type:");
      ((StringBuilder)localObject).append(paramFileType);
      UploadLog.d("UploadTaskManager", ((StringBuilder)localObject).toString());
      localObject = new SessionPool(paramFileType);
      ((SessionPool)localObject).registerListener(this);
      ((SessionPool)localObject).init();
      this.mSessionPools.put(paramFileType, localObject);
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
      return this.mHandler.post(new UploadTaskManager.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.UploadTaskManager
 * JD-Core Version:    0.7.0.1
 */