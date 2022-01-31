package com.tencent.mobileqq.mini.tfs;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseTask
  implements Handler.Callback
{
  public static final int STATUS_DONE = 3;
  public static final int STATUS_RUNNING = 2;
  public static final int STATUS_WAIT = 1;
  public static final int THREAD_TYPE_ASYNC = 2;
  public static final int THREAD_TYPE_MAIN = 3;
  public static final int THREAD_TYPE_SYNC = 1;
  private BaseTask.Callback mCallback;
  protected Context mContext;
  private List<BaseTask> mDependTask = new ArrayList();
  private boolean mIsSucc;
  private int mSatus = 1;
  private int mThreadType = 1;
  protected Handler mainHander = new Handler(Looper.getMainLooper());
  public String msg = "";
  public int retCode = -1;
  protected Handler workHander;
  
  public BaseTask(Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public BaseTask(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mThreadType = paramInt;
  }
  
  public BaseTask addDependTask(BaseTask paramBaseTask)
  {
    if (!this.mDependTask.contains(paramBaseTask)) {
      this.mDependTask.add(paramBaseTask);
    }
    return this;
  }
  
  public abstract void execute();
  
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
  
  public List<BaseTask> getDependTasks()
  {
    return this.mDependTask;
  }
  
  public int getStatus()
  {
    return this.mSatus;
  }
  
  public Handler getWorkHander()
  {
    if (this.workHander == null) {
      this.workHander = new Handler(Looper.getMainLooper(), this);
    }
    return this.workHander;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean isDependTo(BaseTask paramBaseTask)
  {
    if ((paramBaseTask == null) || (this.mDependTask == null) || (this.mDependTask.size() <= 0)) {
      return false;
    }
    if (this.mDependTask.contains(paramBaseTask)) {
      return true;
    }
    Iterator localIterator = this.mDependTask.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((BaseTask)localIterator.next()).isDependTo(paramBaseTask);
      if (bool) {
        return bool;
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
    onTaskFailed(-1, "");
  }
  
  public void onTaskFailed(int paramInt, String paramString)
  {
    QLog.i("miniapp-start", 1, "Task end: " + getClass().getSimpleName() + " retCode=" + paramInt + " msg=" + paramString);
    setStatus(3);
    this.mIsSucc = false;
    this.retCode = paramInt;
    this.msg = paramString;
    if (this.mCallback != null) {
      this.mCallback.onTaskDone(this);
    }
  }
  
  public void onTaskSucceed()
  {
    QLog.i("miniapp-start", 1, "Task end: " + getClass().getSimpleName() + " succ=" + true);
    setStatus(3);
    this.mIsSucc = true;
    if (this.mCallback != null) {
      this.mCallback.onTaskDone(this);
    }
  }
  
  public void reset()
  {
    this.mSatus = 1;
  }
  
  public void run()
  {
    if (this.mSatus == 2) {}
    do
    {
      return;
      if (this.mSatus != 3) {
        break;
      }
    } while (this.mCallback == null);
    this.mCallback.onTaskDone(this);
    return;
    setStatus(2);
    if (this.mCallback != null) {
      this.mCallback.onTaskBegin(this);
    }
    QLog.i("miniapp-start", 1, "Task begin: " + getClass().getSimpleName());
    try
    {
      execute();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start", 1, "task exception!", localThrowable);
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
  
  public void setWorkLooper(Looper paramLooper)
  {
    if (this.workHander == null) {
      this.workHander = new Handler(paramLooper, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.BaseTask
 * JD-Core Version:    0.7.0.1
 */