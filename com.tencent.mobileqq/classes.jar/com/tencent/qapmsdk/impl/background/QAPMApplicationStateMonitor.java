package com.tencent.qapmsdk.impl.background;

import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QAPMApplicationStateMonitor
  implements Runnable
{
  public static final int ALTERNATEPERIOD = 30000;
  public static final int DELAY_AND_PERIOD = 5;
  private static final Object firstLock = new Object();
  private static QAPMApplicationStateMonitor instance;
  private static final Object secondLock = new Object();
  private final int SnoozeTimenterval;
  private long activitySurviveCount = 0L;
  private boolean applicationNotInSnooze = true;
  private long backgroundTime = 0L;
  
  private QAPMApplicationStateMonitor()
  {
    this(5, 5, TimeUnit.SECONDS, 30000);
  }
  
  QAPMApplicationStateMonitor(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, int paramInt3)
  {
    this.SnoozeTimenterval = paramInt3;
    new ScheduledThreadPoolExecutor(1, new QAPMApplicationStateMonitor.1(this)).scheduleAtFixedRate(this, paramInt1, paramInt2, paramTimeUnit);
  }
  
  public static QAPMApplicationStateMonitor getInstance()
  {
    if (instance == null) {
      instance = new QAPMApplicationStateMonitor();
    }
    return instance;
  }
  
  /* Error */
  private long getSnoozeTime()
  {
    // Byte code:
    //   0: getstatic 29	com/tencent/qapmsdk/impl/background/QAPMApplicationStateMonitor:firstLock	Ljava/lang/Object;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: getstatic 31	com/tencent/qapmsdk/impl/background/QAPMApplicationStateMonitor:secondLock	Ljava/lang/Object;
    //   11: astore 6
    //   13: aload 6
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 43	com/tencent/qapmsdk/impl/background/QAPMApplicationStateMonitor:backgroundTime	J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifne +11 -> 33
    //   25: aload 6
    //   27: monitorexit
    //   28: aload 5
    //   30: monitorexit
    //   31: lconst_0
    //   32: lreturn
    //   33: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   36: lstore_1
    //   37: aload_0
    //   38: getfield 43	com/tencent/qapmsdk/impl/background/QAPMApplicationStateMonitor:backgroundTime	J
    //   41: lstore_3
    //   42: aload 6
    //   44: monitorexit
    //   45: aload 5
    //   47: monitorexit
    //   48: lload_1
    //   49: lload_3
    //   50: lsub
    //   51: lreturn
    //   52: astore 6
    //   54: aload 5
    //   56: monitorexit
    //   57: aload 6
    //   59: athrow
    //   60: astore 7
    //   62: aload 6
    //   64: monitorexit
    //   65: aload 7
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	QAPMApplicationStateMonitor
    //   36	13	1	l1	long
    //   41	9	3	l2	long
    //   3	52	5	localObject1	Object
    //   52	11	6	localObject3	Object
    //   60	6	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	16	52	finally
    //   28	31	52	finally
    //   45	48	52	finally
    //   54	57	52	finally
    //   65	68	52	finally
    //   16	28	60	finally
    //   33	45	60	finally
    //   62	65	60	finally
  }
  
  public void activityStarted(String arg1)
  {
    QAPMAppInstrumentation.activityStartBeginIns(???);
    synchronized (firstLock)
    {
      synchronized (secondLock)
      {
        this.activitySurviveCount += 1L;
        if (this.activitySurviveCount == 1L) {
          this.backgroundTime = 0L;
        }
        if (!this.applicationNotInSnooze)
        {
          QAPMAppInstrumentation.appStateTimeInfo.hasSnooze = true;
          this.applicationNotInSnooze = true;
        }
        return;
      }
    }
  }
  
  public void activityStopped(String arg1)
  {
    synchronized (firstLock)
    {
      synchronized (secondLock)
      {
        this.activitySurviveCount -= 1L;
        if (this.activitySurviveCount == 0L)
        {
          com.tencent.qapmsdk.impl.appstate.AppStateTimeInfo.lastBackgroundTime = System.currentTimeMillis();
          QAPMAppInstrumentation.isAppInBackground = true;
          this.backgroundTime = System.currentTimeMillis();
        }
        return;
      }
    }
  }
  
  public void run()
  {
    synchronized (firstLock)
    {
      if ((getSnoozeTime() >= this.SnoozeTimenterval) && (this.applicationNotInSnooze)) {
        this.applicationNotInSnooze = false;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.background.QAPMApplicationStateMonitor
 * JD-Core Version:    0.7.0.1
 */