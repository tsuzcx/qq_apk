package com.tencent.mobileqq.lyric.common;

import android.util.Log;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTaskManager
{
  private ScheduledThreadPoolExecutor a;
  private Map<String, TimerTaskManager.InternalTaskEntry> b = new HashMap();
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    if (this.a == null) {
      this.a = new TimerTaskManager.1(this, 1);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      TimerTaskManager.InternalTaskEntry localInternalTaskEntry = (TimerTaskManager.InternalTaskEntry)this.b.get(paramString);
      if (localInternalTaskEntry != null)
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", new Object[] { paramString }));
        if (TimerTaskManager.InternalTaskEntry.b(localInternalTaskEntry) != null) {
          TimerTaskManager.InternalTaskEntry.b(localInternalTaskEntry).cancel(true);
        }
        boolean bool = this.a.remove(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry));
        this.a.purge();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancel -> cancel TimerTask:");
        localStringBuilder.append(bool);
        localStringBuilder.append("\n");
        localStringBuilder.append(this.a.toString());
        Log.d("LyricTimerTaskManager", localStringBuilder.toString());
        TimerTaskManager.TimerTaskRunnable.a(TimerTaskManager.InternalTaskEntry.c(localInternalTaskEntry), false);
        TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry, null);
        this.b.remove(paramString);
      }
      else
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> not find task[%s].", new Object[] { paramString }));
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    try
    {
      Log.i("LyricTimerTaskManager", String.format("schedule begin [%s].", new Object[] { paramString }));
      if (paramString != null)
      {
        if ((paramLong1 >= 0L) && (paramLong2 > 0L))
        {
          if (paramTimerTaskRunnable != null)
          {
            a();
            if (this.b.containsKey(paramString))
            {
              Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", new Object[] { paramString }));
              a(paramString);
            }
            Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", new Object[] { paramString, Long.valueOf(paramLong2) }));
            paramTimerTaskRunnable = TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, paramLong2);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, paramString);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, this.a.scheduleWithFixedDelay(TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable), paramLong1, paramLong2, TimeUnit.MILLISECONDS));
            this.b.put(paramString, paramTimerTaskRunnable);
            Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", new Object[] { paramString }));
            return;
          }
          throw new IllegalArgumentException(HardCodeUtil.a(2131912285));
        }
        throw new IllegalArgumentException(HardCodeUtil.a(2131912284));
      }
      throw new IllegalArgumentException(HardCodeUtil.a(2131912286));
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */