package com.tencent.qqlive.module.videoreport.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.annotation.MainThread;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class DelayedIdleHandler
{
  private static final String TAG = "DelayedIdleHandler";
  private MessageQueue.IdleHandler mIdleHandler = new DelayedIdleHandler.IdleHandler(this, null);
  private Map<DelayedIdleHandler.DelayedRunnable, Runnable> mRunnableMap = new LinkedHashMap();
  
  private void removeIdleHandlerIfNeed()
  {
    if (this.mRunnableMap.isEmpty()) {
      Looper.myQueue().removeIdleHandler(this.mIdleHandler);
    }
  }
  
  private Runnable removeTaskFromMap(Runnable paramRunnable)
  {
    return (Runnable)this.mRunnableMap.remove(paramRunnable);
  }
  
  @MainThread
  public void post(DelayedIdleHandler.DelayedRunnable paramDelayedRunnable, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("DelayedIdleHandler", "receive task to delay:" + paramLong);
    }
    Object localObject = (Runnable)this.mRunnableMap.get(paramDelayedRunnable);
    if (localObject != null)
    {
      ThreadUtils.removeOnUiThread((Runnable)localObject);
      ThreadUtils.runOnUiThreadDelay((Runnable)localObject, paramLong);
      return;
    }
    localObject = new DelayedIdleHandler.RunnableWrapper(this, paramDelayedRunnable);
    this.mRunnableMap.put(paramDelayedRunnable, localObject);
    ThreadUtils.runOnUiThreadDelay((Runnable)localObject, paramLong);
    Looper.myQueue().removeIdleHandler(this.mIdleHandler);
    Looper.myQueue().addIdleHandler(this.mIdleHandler);
  }
  
  @MainThread
  public void remove(DelayedIdleHandler.DelayedRunnable paramDelayedRunnable)
  {
    paramDelayedRunnable = removeTaskFromMap(paramDelayedRunnable);
    if (paramDelayedRunnable != null) {
      ThreadUtils.removeOnUiThread(paramDelayedRunnable);
    }
    removeIdleHandlerIfNeed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler
 * JD-Core Version:    0.7.0.1
 */