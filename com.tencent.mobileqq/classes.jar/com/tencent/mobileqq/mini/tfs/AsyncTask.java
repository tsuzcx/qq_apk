package com.tencent.mobileqq.mini.tfs;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public abstract class AsyncTask
  extends BaseTask
{
  public AsyncTask(Context paramContext)
  {
    super(paramContext, 2);
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
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.AsyncTask
 * JD-Core Version:    0.7.0.1
 */