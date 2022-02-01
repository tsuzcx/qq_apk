package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;

public abstract class AsyncTask
  extends BaseTask
{
  public AsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, 2, paramBaseRuntimeLoader);
  }
  
  public void execute()
  {
    if (!isMainThread())
    {
      executeAsync();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AsyncTask.1(this));
  }
  
  public abstract void executeAsync();
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.AsyncTask
 * JD-Core Version:    0.7.0.1
 */