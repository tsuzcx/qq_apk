package com.tencent.qapmsdk.impl.background;

import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QAPMApplicationStateMonitor
  implements Runnable
{
  public static final int ALTER_NATE_PERIOD = 30000;
  public static final int DELAY_AND_PERIOD = 5;
  private static final Object FIRST_LOCK = new Object();
  private static final Object SECOND_LOCK = new Object();
  private static QAPMApplicationStateMonitor instance;
  private final int SNOOZE_TIME_INTERVAL;
  private long activitySurviveCount = 0L;
  private boolean applicationNotInSnooze = true;
  private long backgroundTime = 0L;
  
  private QAPMApplicationStateMonitor()
  {
    this(5, 5, TimeUnit.SECONDS, 30000);
  }
  
  QAPMApplicationStateMonitor(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, int paramInt3)
  {
    this.SNOOZE_TIME_INTERVAL = paramInt3;
    new ScheduledThreadPoolExecutor(1, new QAPMApplicationStateMonitor.1(this)).scheduleAtFixedRate(this, paramInt1, paramInt2, paramTimeUnit);
  }
  
  public static QAPMApplicationStateMonitor getInstance()
  {
    if (instance == null) {
      instance = new QAPMApplicationStateMonitor();
    }
    return instance;
  }
  
  private long getSnoozeTime()
  {
    synchronized (FIRST_LOCK)
    {
      synchronized (SECOND_LOCK)
      {
        if (this.backgroundTime == 0L) {
          return 0L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = this.backgroundTime;
        return l1 - l2;
      }
    }
  }
  
  public void activityStarted(String arg1)
  {
    QAPMAppInstrumentation.activityStartBeginIns(???);
    synchronized (FIRST_LOCK)
    {
      synchronized (SECOND_LOCK)
      {
        this.activitySurviveCount += 1L;
        if (this.activitySurviveCount == 1L) {
          this.backgroundTime = 0L;
        }
        if (!this.applicationNotInSnooze)
        {
          QAPMAppInstrumentation.appStateTimeInfo.c = true;
          this.applicationNotInSnooze = true;
        }
        return;
      }
    }
  }
  
  public void activityStopped(String arg1)
  {
    synchronized (FIRST_LOCK)
    {
      synchronized (SECOND_LOCK)
      {
        this.activitySurviveCount -= 1L;
        if (this.activitySurviveCount == 0L)
        {
          com.tencent.qapmsdk.impl.appstate.b.b = System.currentTimeMillis();
          QAPMAppInstrumentation.isAppInBackground = true;
          this.backgroundTime = System.currentTimeMillis();
        }
        return;
      }
    }
  }
  
  public void run()
  {
    synchronized (FIRST_LOCK)
    {
      if ((getSnoozeTime() >= this.SNOOZE_TIME_INTERVAL) && (this.applicationNotInSnooze)) {
        this.applicationNotInSnooze = false;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.background.QAPMApplicationStateMonitor
 * JD-Core Version:    0.7.0.1
 */