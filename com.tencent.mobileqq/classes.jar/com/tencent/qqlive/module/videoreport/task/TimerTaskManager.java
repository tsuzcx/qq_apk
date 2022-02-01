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
      if (VideoReport.isDebugMode()) {
        throw new NullPointerException("runnable is null");
      }
      return "";
    }
    String str = "VR_TimerTask_ID_" + this.nextID.incrementAndGet();
    boolean bool;
    if (paramLong2 > 0L)
    {
      bool = true;
      paramRunnable = new TimerTaskManager.WatcherRunnable(this, paramRunnable, str, bool);
      if (!paramBoolean) {
        break label116;
      }
      paramRunnable = this.mHandlerExecutor.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
    }
    for (;;)
    {
      this.mWorkingGroup.put(str, paramRunnable);
      return str;
      bool = false;
      break;
      label116:
      if (paramLong2 > 0L) {
        paramRunnable = this.mThreadExecutor.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
      } else {
        paramRunnable = this.mThreadExecutor.schedule(paramRunnable, paramLong1, TimeUnit.MILLISECONDS);
      }
    }
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (Future)this.mWorkingGroup.remove(paramString);
    } while (paramString == null);
    if (!(paramString instanceof HandlerScheduledFuture)) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.cancel(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */