package mqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Foreground
  implements Handler.Callback
{
  private static final int DELAY_BROADCAST = 100;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "ApplicationLife";
  private static List<Foreground.AppLifeCycleCallback> callbacks = new LinkedList();
  private static Context sContext;
  public static int sCountActivity;
  public static int sCountResume;
  private static Handler sHandler;
  private static String sProcessName;
  private static WeakReference<Activity> sTopActivity;
  
  public static Activity getTopActivity()
  {
    if (sTopActivity != null) {
      return (Activity)sTopActivity.get();
    }
    return null;
  }
  
  public static void init(Context paramContext, Looper paramLooper, String paramString)
  {
    if (sHandler == null) {
      try
      {
        if (sHandler == null)
        {
          sContext = paramContext;
          sProcessName = paramString;
          sHandler = new Handler(paramLooper, new Foreground());
        }
        return;
      }
      finally {}
    }
  }
  
  public static void onCreate(Activity paramActivity)
  {
    synchronized (callbacks)
    {
      Iterator localIterator = callbacks.iterator();
      if (localIterator.hasNext()) {
        ((Foreground.AppLifeCycleCallback)localIterator.next()).onActivityCreated(paramActivity);
      }
    }
  }
  
  public static void onDestroy(Activity paramActivity)
  {
    synchronized (callbacks)
    {
      Iterator localIterator = callbacks.iterator();
      if (localIterator.hasNext()) {
        ((Foreground.AppLifeCycleCallback)localIterator.next()).onActivityDestroyed(paramActivity);
      }
    }
  }
  
  public static void onPause(AppRuntime paramAppRuntime)
  {
    int i = sCountResume - 1;
    sCountResume = i;
    if ((i <= 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = true;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
      paramAppRuntime.onProcPause();
    }
  }
  
  public static void onResume(AppRuntime paramAppRuntime)
  {
    int i = sCountResume + 1;
    sCountResume = i;
    if ((i > 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = false;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
      paramAppRuntime.onProcResume();
    }
  }
  
  public static void onStart(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    sTopActivity = new WeakReference(paramActivity);
    sCountActivity += 1;
    if ((sCountActivity == 1) || (sCountActivity == 2))
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  public static void onStop(AppRuntime paramAppRuntime)
  {
    QLog.d("ApplicationLife", 1, new Object[] { "[process] onStop: invoked. ", " sCountActivity: ", Integer.valueOf(sCountActivity) });
    int i = sCountActivity - 1;
    sCountActivity = i;
    if (i == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
      QLog.d("ApplicationLife", 1, new Object[] { "[process] onStop: invoked. send MSG_BACK", " sCountActivity: ", Integer.valueOf(sCountActivity) });
    }
  }
  
  public static void registerLifeCycleCallback(Foreground.AppLifeCycleCallback paramAppLifeCycleCallback)
  {
    synchronized (callbacks)
    {
      if (!callbacks.contains(paramAppLifeCycleCallback)) {
        callbacks.add(paramAppLifeCycleCallback);
      }
      return;
    }
  }
  
  public static void setReady()
  {
    if (sCountActivity > 0)
    {
      l = SystemClock.uptimeMillis();
      localMessage = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), null);
      sHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    long l = SystemClock.uptimeMillis();
    Message localMessage = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), null);
    sHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public static void unregisterLifeCycleCallback(Foreground.AppLifeCycleCallback paramAppLifeCycleCallback)
  {
    synchronized (callbacks)
    {
      callbacks.remove(paramAppLifeCycleCallback);
      return;
    }
  }
  
  public static void updateRuntimeState(AppRuntime paramAppRuntime)
  {
    boolean bool2 = true;
    if (paramAppRuntime != null)
    {
      if (sCountResume <= 0)
      {
        bool1 = true;
        paramAppRuntime.isBackground_Pause = bool1;
        if (sCountActivity > 0) {
          break label91;
        }
      }
      label91:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAppRuntime.isBackground_Stop = bool1;
        Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
        while (localIterator.hasNext())
        {
          AppRuntime localAppRuntime = (AppRuntime)localIterator.next();
          localAppRuntime.isBackground_Pause = paramAppRuntime.isBackground_Pause;
          localAppRuntime.isBackground_Stop = paramAppRuntime.isBackground_Stop;
        }
        bool1 = false;
        break;
      }
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    AppRuntime localAppRuntime = (AppRuntime)???.obj;
    long l = ???.arg1 << 32 | ???.arg2 & 0xFFFFFFFF;
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, ???.what + ", " + sProcessName + ", " + l + ", " + sCountActivity + ", rt = " + localAppRuntime);
    }
    switch (???.what)
    {
    }
    do
    {
      return true;
      if (sCountActivity > 0)
      {
        if ((localAppRuntime != null) && (localAppRuntime.isBackground_Stop))
        {
          localAppRuntime.onRunningForeground();
          ??? = localAppRuntime.subRuntimeMap.values().iterator();
          while (???.hasNext()) {
            ((AppRuntime)???.next()).onRunningForeground();
          }
        }
        synchronized (callbacks)
        {
          Iterator localIterator2 = callbacks.iterator();
          if (localIterator2.hasNext()) {
            ((Foreground.AppLifeCycleCallback)localIterator2.next()).onRunningForeground();
          }
        }
        ??? = new Intent("com.tencent.process.starting");
        ???.putExtra("runningProcessName", sProcessName);
        ???.putExtra("runningtime", l);
        sContext.sendBroadcast(???);
        QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. send starting", " sProcessName: ", sProcessName });
      }
      QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. ", " sCountActivity: ", Integer.valueOf(sCountActivity) });
    } while (sCountActivity != 0);
    if (localObject1 != null)
    {
      localObject1.onRunningBackground();
      ??? = localObject1.subRuntimeMap.values().iterator();
      while (???.hasNext()) {
        ((AppRuntime)???.next()).onRunningBackground();
      }
    }
    synchronized (callbacks)
    {
      Iterator localIterator1 = callbacks.iterator();
      if (localIterator1.hasNext()) {
        ((Foreground.AppLifeCycleCallback)localIterator1.next()).onRunningBackground();
      }
    }
    try
    {
      ??? = new Intent("com.tencent.process.stopping");
      ???.putExtra("runningProcessName", sProcessName);
      ???.putExtra("runningtime", l);
      sContext.sendBroadcast(???);
      QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. send stopping", " sProcessName: ", sProcessName });
      return true;
    }
    catch (Exception ???) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.Foreground
 * JD-Core Version:    0.7.0.1
 */