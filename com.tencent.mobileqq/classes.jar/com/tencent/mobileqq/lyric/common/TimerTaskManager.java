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
  private Map<String, TimerTaskManager.InternalTaskEntry> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor == null) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new TimerTaskManager.1(this, 1);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      TimerTaskManager.InternalTaskEntry localInternalTaskEntry = (TimerTaskManager.InternalTaskEntry)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localInternalTaskEntry != null)
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", new Object[] { paramString }));
        if (TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry) != null) {
          TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry).cancel(true);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry));
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.purge();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancel -> cancel TimerTask:");
        localStringBuilder.append(bool);
        localStringBuilder.append("\n");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.toString());
        Log.d("LyricTimerTaskManager", localStringBuilder.toString());
        TimerTaskManager.TimerTaskRunnable.a(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry), false);
        TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry, null);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
            {
              Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", new Object[] { paramString }));
              a(paramString);
            }
            Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", new Object[] { paramString, Long.valueOf(paramLong2) }));
            paramTimerTaskRunnable = TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, paramLong2);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, paramString);
            TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable, this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.scheduleWithFixedDelay(TimerTaskManager.InternalTaskEntry.a(paramTimerTaskRunnable), paramLong1, paramLong2, TimeUnit.MILLISECONDS));
            this.jdField_a_of_type_JavaUtilMap.put(paramString, paramTimerTaskRunnable);
            Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", new Object[] { paramString }));
            return;
          }
          throw new IllegalArgumentException(HardCodeUtil.a(2131714781));
        }
        throw new IllegalArgumentException(HardCodeUtil.a(2131714780));
      }
      throw new IllegalArgumentException(HardCodeUtil.a(2131714782));
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */