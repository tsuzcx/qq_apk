package com.tencent.mobileqq.mini.tfs;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import java.util.concurrent.ExecutorService;

public abstract class AsyncTask
  extends BaseTask
{
  public AsyncTask(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  public final void execute()
  {
    ThreadPools.getComputationThreadPool().execute(new AsyncTask.1(this));
  }
  
  public abstract void executeAsync();
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.AsyncTask
 * JD-Core Version:    0.7.0.1
 */