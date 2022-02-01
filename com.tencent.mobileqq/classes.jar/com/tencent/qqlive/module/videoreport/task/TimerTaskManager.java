package com.tencent.qqlive.module.videoreport.task;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.task.base.HandlerScheduledFuture;
import com.tencent.qqlive.module.videoreport.task.base.NamedThreadFactory;
import com.tencent.qqlive.module.videoreport.task.base.ScheduledHandlerExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTaskManager
{
  private static final String TAG = "VR_TimerTaskManager";
  private static final String mIDPrefix = "VR_TimerTask_ID_";
  private ScheduledExecutorService mHandlerExecutor = new ScheduledHandlerExecutorService(Looper.getMainLooper());
  private ScheduledExecutorService mThreadExecutor = new ScheduledThreadPoolExecutor(4, new NamedThreadFactory("VR_TimerTaskManager"), new ThreadPoolExecutor.AbortPolicy());
  private ConcurrentHashMap<String, Future<?>> mWorkingGroup = new ConcurrentHashMap();
  private AtomicInteger nextID = new AtomicInteger(0);
  
  private String addTimerTask(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramRunnable == null)
    {
      if (!VideoReport.isDebugMode()) {
        return "";
      }
      throw new NullPointerException("runnable is null");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VR_TimerTask_ID_");
    ((StringBuilder)localObject).append(this.nextID.incrementAndGet());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if (paramLong2 > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramRunnable = new TimerTaskManager.WatcherRunnable(this, paramRunnable, (String)localObject, bool);
    if (paramBoolean) {
      paramRunnable = this.mHandlerExecutor.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
    } else if (paramLong2 > 0L) {
      paramRunnable = this.mThreadExecutor.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
    } else {
      paramRunnable = this.mThreadExecutor.schedule(paramRunnable, paramLong1, TimeUnit.MILLISECONDS);
    }
    this.mWorkingGroup.put(localObject, paramRunnable);
    return localObject;
  }
  
  public static TimerTaskManager getInstance()
  {
    return TimerTaskManager.SingletonHolder.access$100();
  }
  
  public String addAsyncTimerTask(Runnable paramRunnable, long paramLong)
  {
    return addAsyncTimerTask(paramRunnable, paramLong, -1L);
  }
  
  public String addAsyncTimerTask(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    return addTimerTask(paramRunnable, paramLong1, paramLong2, false);
  }
  
  public String addUIThreadTimerTask(Runnable paramRunnable, long paramLong)
  {
    return addUIThreadTimerTask(paramRunnable, paramLong, -1L);
  }
  
  public String addUIThreadTimerTask(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    return addTimerTask(paramRunnable, paramLong1, paramLong2, true);
  }
  
  public void cancelTimerTask(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (Future)this.mWorkingGroup.remove(paramString);
    if (paramString != null)
    {
      boolean bool;
      if (!(paramString instanceof HandlerScheduledFuture)) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.cancel(bool);
    }
  }
  
  public boolean isTaskInQueue(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.mWorkingGroup.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */