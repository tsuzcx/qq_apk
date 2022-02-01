package com.tencent.qqlive.module.videoreport.lazy;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.IThreadTaskInterceptor;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LazyInitObserver
  implements IThreadTaskInterceptor
{
  private static final long DEFAULT_DELAY_TIME = 0L;
  private boolean mCanProceed;
  private boolean mHasInitialized;
  private boolean mHasNotified;
  private final List<Runnable> mPendingTasks = new ArrayList();
  
  public static LazyInitObserver getInstance()
  {
    return LazyInitObserver.InstanceHolder.sInstance;
  }
  
  private boolean hasInitialized()
  {
    return this.mHasInitialized;
  }
  
  private void markInitialized()
  {
    this.mHasInitialized = true;
  }
  
  private void markToProceed(long paramLong)
  {
    if (this.mHasNotified) {
      return;
    }
    this.mHasNotified = true;
    Log.d("LazyInitSequence", "mark and post to proceed: delay " + paramLong);
    proceedPendingTasksDelay(paramLong);
  }
  
  private void proceedPendingTasks()
  {
    try
    {
      Iterator localIterator = this.mPendingTasks.iterator();
      while (localIterator.hasNext()) {
        ThreadUtils.runOnUiThread((Runnable)localIterator.next());
      }
      this.mPendingTasks.clear();
    }
    finally {}
  }
  
  private void proceedPendingTasksDelay(long paramLong)
  {
    ThreadUtils.getMainHandler().postDelayed(new LazyInitObserver.1(this), paramLong);
  }
  
  private void registerFirstDraw()
  {
    switch (VideoReportInner.getInstance().getConfiguration().getLazyInitType())
    {
    default: 
      return;
    }
    markToProceed(0L);
  }
  
  private void waitToWarn()
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return;
    }
    LazyInitObserver.2 local2 = new LazyInitObserver.2(this);
    ThreadUtils.getMainHandler().postDelayed(local2, 5000L);
  }
  
  public void markToProceed()
  {
    markToProceed(0L);
  }
  
  public boolean mayProceedOnMain(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    for (;;)
    {
      try
      {
        bool = this.mCanProceed;
        return bool;
      }
      finally {}
      if (!this.mCanProceed)
      {
        this.mPendingTasks.remove(paramRunnable);
        this.mPendingTasks.add(paramRunnable);
      }
      boolean bool = this.mCanProceed;
    }
  }
  
  public void onInitialized()
  {
    if (hasInitialized()) {
      return;
    }
    registerFirstDraw();
    markInitialized();
    waitToWarn();
  }
  
  public boolean removePendingTask(Runnable paramRunnable)
  {
    return this.mPendingTasks.remove(paramRunnable);
  }
  
  public boolean shouldInterceptTask(Runnable paramRunnable)
  {
    return !mayProceedOnMain(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver
 * JD-Core Version:    0.7.0.1
 */