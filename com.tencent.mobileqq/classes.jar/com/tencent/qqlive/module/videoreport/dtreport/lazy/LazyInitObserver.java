package com.tencent.qqlive.module.videoreport.dtreport.lazy;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
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
  private static final long DRAW_DELAY_TIME = 50L;
  private static final long PRE_DRAW_DELAY_TIME = 70L;
  private boolean mCanProceed;
  private boolean mHasNotified;
  private boolean mIsFirstActivityIn;
  private final List<Runnable> mPendingTasks = new ArrayList();
  
  public static LazyInitObserver getInstance()
  {
    return LazyInitObserver.InstanceHolder.sInstance;
  }
  
  private boolean isFirstActivityIn()
  {
    return this.mIsFirstActivityIn;
  }
  
  private void markFirstActivityIn()
  {
    this.mIsFirstActivityIn = true;
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
    ThreadUtils.getMainHandler().postDelayed(new LazyInitObserver.4(this), paramLong);
  }
  
  private void registerFirstDraw(Activity paramActivity)
  {
    switch (VideoReportInner.getInstance().getConfiguration().getLazyInitType())
    {
    default: 
      return;
    case 0: 
      markToProceed(0L);
      return;
    }
    registerSystemFirstDraw(paramActivity);
  }
  
  private void registerSystemFirstDraw(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new LazyInitObserver.1(this, paramActivity));
      return;
    }
    paramActivity.getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener(new LazyInitObserver.2(this, paramActivity));
  }
  
  @RequiresApi(api=16)
  private void removeDrawListener(Activity paramActivity, ViewTreeObserver.OnDrawListener paramOnDrawListener)
  {
    if (paramActivity == null) {
      return;
    }
    ThreadUtils.getMainHandler().post(new LazyInitObserver.3(this, paramActivity, paramOnDrawListener));
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
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((paramActivity == null) || (isFirstActivityIn())) {
      return;
    }
    registerFirstDraw(paramActivity);
    markFirstActivityIn();
  }
  
  public boolean shouldInterceptTask(Runnable paramRunnable)
  {
    return !mayProceedOnMain(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitObserver
 * JD-Core Version:    0.7.0.1
 */