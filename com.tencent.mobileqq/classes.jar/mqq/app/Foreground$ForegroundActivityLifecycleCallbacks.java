package mqq.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class Foreground$ForegroundActivityLifecycleCallbacks
  implements QActivityLifecycleCallbacks
{
  private AtomicBoolean haveCallbackForeground;
  private final List<QActivityLifecycleCallbacks> mLifecycleCallbacks = new ArrayList();
  
  Foreground$ForegroundActivityLifecycleCallbacks()
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "cur proc: ", MobileQQ.processName });
    this.haveCallbackForeground = new AtomicBoolean(false);
  }
  
  void addActivityLifecycleCallbacks(QActivityLifecycleCallbacks paramQActivityLifecycleCallbacks)
  {
    if (paramQActivityLifecycleCallbacks == null) {
      return;
    }
    synchronized (this.mLifecycleCallbacks)
    {
      if (!this.mLifecycleCallbacks.contains(paramQActivityLifecycleCallbacks)) {
        this.mLifecycleCallbacks.add(paramQActivityLifecycleCallbacks);
      }
      return;
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityCreated cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$000(paramActivity);
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityCreated(paramActivity, paramBundle);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityDestroyed cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$500(paramActivity);
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityDestroyed(paramActivity);
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityPaused cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$300(MobileQQ.getMobileQQ().peekAppRuntime());
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityResumed cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$200(MobileQQ.getMobileQQ().peekAppRuntime());
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityResumed(paramActivity);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityStarted cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$100(MobileQQ.getMobileQQ().peekAppRuntime(), paramActivity);
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    QLog.d("ForegroundCallback", 2, new Object[] { "onActivityStopped cur activity: ", paramActivity.getClass().getName() });
    Foreground.access$400(MobileQQ.getMobileQQ().peekAppRuntime());
    synchronized (this.mLifecycleCallbacks)
    {
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStopped(paramActivity);
      }
    }
  }
  
  public void onProcessBackground()
  {
    synchronized (this.mLifecycleCallbacks)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForegroundCallback", 2, "onProcessBackground");
      }
      Iterator localIterator = this.mLifecycleCallbacks.iterator();
      if (localIterator.hasNext()) {
        ((QActivityLifecycleCallbacks)localIterator.next()).onProcessBackground();
      }
    }
    this.haveCallbackForeground.set(false);
  }
  
  public void onProcessForeground()
  {
    if (!this.haveCallbackForeground.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForegroundCallback", 2, "onProcessForeground");
      }
      synchronized (this.mLifecycleCallbacks)
      {
        Iterator localIterator = this.mLifecycleCallbacks.iterator();
        if (localIterator.hasNext()) {
          ((QActivityLifecycleCallbacks)localIterator.next()).onProcessForeground();
        }
      }
      this.haveCallbackForeground.set(true);
    }
  }
  
  /* Error */
  void removeActivityLifecycleCallbacks(QActivityLifecycleCallbacks paramQActivityLifecycleCallbacks)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 20	mqq/app/Foreground$ForegroundActivityLifecycleCallbacks:mLifecycleCallbacks	Ljava/util/List;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 20	mqq/app/Foreground$ForegroundActivityLifecycleCallbacks:mLifecycleCallbacks	Ljava/util/List;
    //   20: aload_1
    //   21: invokeinterface 168 2 0
    //   26: pop
    //   27: aload_2
    //   28: monitorexit
    //   29: goto -23 -> 6
    //   32: astore_1
    //   33: aload_2
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ForegroundActivityLifecycleCallbacks
    //   0	42	1	paramQActivityLifecycleCallbacks	QActivityLifecycleCallbacks
    // Exception table:
    //   from	to	target	type
    //   16	29	32	finally
    //   33	35	32	finally
    //   9	16	37	finally
    //   35	37	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.Foreground.ForegroundActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */