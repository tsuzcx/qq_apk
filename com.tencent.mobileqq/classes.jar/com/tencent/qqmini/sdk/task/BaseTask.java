package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseTask
  implements Handler.Callback
{
  public static final int STATUS_DONE = 3;
  public static final int STATUS_RESET = 4;
  public static final int STATUS_RUNNING = 2;
  public static final int STATUS_WAIT = 1;
  private static final String TAG = "minisdk-start_BaseTask";
  public static final int THREAD_TYPE_ASYNC = 2;
  public static final int THREAD_TYPE_MAIN = 3;
  public static final int THREAD_TYPE_SYNC = 1;
  private BaseTask.Callback mCallback;
  protected String mClassTag = getClass().getSimpleName();
  protected Context mContext;
  private List<BaseTask> mDependTask = new ArrayList();
  protected String mDescStr;
  private boolean mIsCached = false;
  private boolean mIsSucc = false;
  protected long mRunDurationMs = 0L;
  private int mSatus = 1;
  private long mTaskStartTime = 0L;
  private int mThreadType = 1;
  private long mTotalRunDurationMs = -1L;
  protected Handler mainHander = new Handler(Looper.getMainLooper());
  public String msg = "";
  public int retCode = -1;
  private BaseRuntimeLoader runtimeLoader;
  
  public BaseTask(Context paramContext, int paramInt, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    this.mContext = paramContext;
    this.mThreadType = paramInt;
    this.runtimeLoader = paramBaseRuntimeLoader;
    paramContext = (ClassTag)getClass().getAnnotation(ClassTag.class);
    if (paramContext != null)
    {
      paramContext = paramContext.tag();
      if (!TextUtils.isEmpty(paramContext)) {
        this.mClassTag = paramContext;
      }
    }
  }
  
  public BaseTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    this(paramContext, 1, paramBaseRuntimeLoader);
  }
  
  private void doReset()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task Reset: ");
    localStringBuilder.append(getDescStr());
    QMLog.i("minisdk-start_BaseTask", localStringBuilder.toString());
    this.mSatus = 4;
    this.mIsSucc = false;
  }
  
  private String getDescStr()
  {
    if (TextUtils.isEmpty(this.mDescStr))
    {
      this.mDescStr = this.mClassTag;
      if (this.runtimeLoader != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mDescStr);
        localStringBuilder.append("{");
        localStringBuilder.append(this.runtimeLoader.getClass().getSimpleName());
        localStringBuilder.append("@");
        localStringBuilder.append(this.runtimeLoader.hashCode());
        localStringBuilder.append("}");
        this.mDescStr = localStringBuilder.toString();
      }
    }
    return this.mDescStr;
  }
  
  public BaseTask addDependTask(BaseTask paramBaseTask)
  {
    if (!this.mDependTask.contains(paramBaseTask)) {
      this.mDependTask.add(paramBaseTask);
    }
    return this;
  }
  
  protected abstract void execute();
  
  public List<BaseTask> getAllDependTask()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mDependTask.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.mDependTask.iterator();
    while (localIterator.hasNext())
    {
      BaseTask localBaseTask = (BaseTask)localIterator.next();
      List localList = localBaseTask.getAllDependTask();
      localArrayList.add(localBaseTask);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
    }
    return localArrayList;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public List<BaseTask> getDependTasks()
  {
    return this.mDependTask;
  }
  
  @NonNull
  public TaskExecutionStatics getExecutionStatics()
  {
    List localList = getSubTaskExecutionStatics();
    Object localObject2 = TaskExecutionStatics.Status.SUCCESS;
    int i = this.mSatus;
    Object localObject1;
    if (i == 1) {
      localObject1 = TaskExecutionStatics.Status.WAIT;
    }
    for (;;)
    {
      break;
      if (i == 2)
      {
        localObject1 = TaskExecutionStatics.Status.RUNNING;
      }
      else
      {
        localObject1 = localObject2;
        if (isDone()) {
          if (!isSucceed())
          {
            localObject1 = TaskExecutionStatics.Status.FAIL;
          }
          else
          {
            localObject1 = localObject2;
            if (this.mIsCached) {
              localObject1 = TaskExecutionStatics.Status.CACHED;
            }
          }
        }
      }
    }
    String str = getName();
    long l1 = getRunDurationMs();
    long l2 = getTotalRunDurationMs();
    localObject2 = this.msg;
    if (localObject2 == null) {
      localObject2 = "";
    }
    if (localList == null) {
      localList = Collections.emptyList();
    }
    return new TaskExecutionStatics(str, l1, l2, (TaskExecutionStatics.Status)localObject1, (String)localObject2, localList);
  }
  
  @NonNull
  public String getName()
  {
    String str = this.mClassTag;
    if (str != null) {
      return str;
    }
    return getClass().getSimpleName();
  }
  
  public long getRunDurationMs()
  {
    if (this.mSatus == 2) {
      return SystemClock.uptimeMillis() - this.mTaskStartTime;
    }
    return this.mRunDurationMs;
  }
  
  public BaseRuntimeLoader getRuntimeLoader()
  {
    return this.runtimeLoader;
  }
  
  public int getStatus()
  {
    return this.mSatus;
  }
  
  @Nullable
  protected List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    ArrayList localArrayList = new ArrayList(getDependTasks().size());
    Iterator localIterator = getDependTasks().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((BaseTask)localIterator.next()).getExecutionStatics());
    }
    return localArrayList;
  }
  
  public long getTotalRunDurationMs()
  {
    if (this.mTotalRunDurationMs == -1L)
    {
      this.mTotalRunDurationMs = this.mRunDurationMs;
      Object localObject = getSubTaskExecutionStatics();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TaskExecutionStatics localTaskExecutionStatics = (TaskExecutionStatics)((Iterator)localObject).next();
          if (localTaskExecutionStatics.getStatus() != TaskExecutionStatics.Status.CACHED) {
            this.mTotalRunDurationMs += localTaskExecutionStatics.getTotalRunDurationMs();
          }
        }
      }
    }
    return this.mTotalRunDurationMs;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean isDependTo(BaseTask paramBaseTask)
  {
    if (paramBaseTask != null)
    {
      Object localObject = this.mDependTask;
      if (localObject != null)
      {
        if (((List)localObject).size() <= 0) {
          return false;
        }
        if (this.mDependTask.contains(paramBaseTask)) {
          return true;
        }
        localObject = this.mDependTask.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((BaseTask)((Iterator)localObject).next()).isDependTo(paramBaseTask);
          if (bool) {
            return bool;
          }
        }
      }
    }
    return false;
  }
  
  public boolean isDone()
  {
    return this.mSatus == 3;
  }
  
  public boolean isSucceed()
  {
    return this.mIsSucc;
  }
  
  public void onTaskFailed()
  {
    this.mRunDurationMs = (SystemClock.uptimeMillis() - this.mTaskStartTime);
    onTaskFailed(-1, "");
  }
  
  public void onTaskFailed(int paramInt, String paramString)
  {
    this.mRunDurationMs = (SystemClock.uptimeMillis() - this.mTaskStartTime);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task end: ");
    localStringBuilder.append(getDescStr());
    localStringBuilder.append(" retCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    String str;
    if (getStatus() == 4) {
      str = " Reseted";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    QMLog.i("minisdk-start_BaseTask", localStringBuilder.toString());
    if (getStatus() == 4) {
      return;
    }
    setStatus(3);
    this.mIsSucc = false;
    this.retCode = paramInt;
    this.msg = paramString;
    paramString = this.mCallback;
    if (paramString != null) {
      paramString.onTaskEnd(this);
    }
  }
  
  protected final void onTaskStart()
  {
    this.mTaskStartTime = SystemClock.uptimeMillis();
  }
  
  public void onTaskSucceed()
  {
    this.mRunDurationMs = (SystemClock.uptimeMillis() - this.mTaskStartTime);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task end: ");
    localStringBuilder.append(getDescStr());
    localStringBuilder.append(" succ=");
    localStringBuilder.append(true);
    if (getStatus() == 4) {
      localObject = " Reseted";
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    QMLog.i("minisdk-start_BaseTask", localStringBuilder.toString());
    if (getStatus() == 4) {
      return;
    }
    setStatus(3);
    this.mIsSucc = true;
    Object localObject = this.mCallback;
    if (localObject != null) {
      ((BaseTask.Callback)localObject).onTaskEnd(this);
    }
  }
  
  public void onTaskSucceedWithCache()
  {
    this.mIsCached = true;
    onTaskSucceed();
  }
  
  public void reset()
  {
    if (getStatus() == 4) {
      return;
    }
    doReset();
  }
  
  public void run()
  {
    int i = this.mSatus;
    if (i == 2) {
      return;
    }
    if (i == 3)
    {
      this.mIsCached = true;
      localObject = this.mCallback;
      if (localObject != null) {
        ((BaseTask.Callback)localObject).onTaskEnd(this);
      }
      return;
    }
    setStatus(2);
    Object localObject = this.mCallback;
    if (localObject != null) {
      ((BaseTask.Callback)localObject).onTaskBegin(this);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Task begin: ");
    ((StringBuilder)localObject).append(getDescStr());
    QMLog.i("minisdk-start_BaseTask", ((StringBuilder)localObject).toString());
    try
    {
      onTaskStart();
      execute();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_BaseTask", "task exception!", localThrowable);
      onTaskFailed();
    }
  }
  
  public BaseTask setCallback(BaseTask.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    return this;
  }
  
  public void setStatus(int paramInt)
  {
    try
    {
      this.mSatus = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    return getDescStr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */