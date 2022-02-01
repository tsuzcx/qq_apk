package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Looper;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QAPMTraceEngine
  extends com.tencent.qapmsdk.impl.b.a
{
  private static final String TAG = "QAPM_Impl_QAPMTraceEngine";
  private static List<a> metricEventListeners = new CopyOnWriteArrayList();
  
  public static void enterMethod(f paramf, String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      if (!shouldInvokeMethod(paramString)) {
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        notifyObserverEnterMethod(new f(paramString, getSegmentType(paramArrayList).a()));
        return;
      }
    }
    catch (Throwable paramf)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "error happend in enterMethod:", paramf);
      return;
    }
    notifyObserverAsyncEnterMethod(new f(paramString, getSegmentType(paramArrayList).a()));
  }
  
  public static void enterMethod(String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      enterMethod(null, paramString, paramArrayList);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  enterMethod has an error :", paramString);
    }
  }
  
  public static void exitCustomApiMethod(String paramString)
  {
    try
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTraceEngine", "exitCustomApiMethod" });
      notifyObserverExitMethodCustom(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  exitCustomApiMethod has an error :", paramString);
    }
  }
  
  public static void exitMethod()
  {
    try
    {
      notifyObserverExitMethod();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  exitMethod has an error :", localThrowable);
    }
  }
  
  public static List<a> getMetricEventListeners()
  {
    return metricEventListeners;
  }
  
  public static k.a getSegmentType(List<String> paramList)
  {
    k.a locala = k.a.a;
    Object localObject = locala;
    if (paramList != null)
    {
      localObject = locala;
      if (paramList.size() == 3)
      {
        String str = (String)paramList.get(2);
        paramList = locala;
        if (str.equalsIgnoreCase(c.e.a())) {
          paramList = k.a.e;
        }
        if (str.equalsIgnoreCase(c.f.a())) {
          paramList = k.a.c;
        }
        if (str.equalsIgnoreCase(c.g.a())) {
          paramList = k.a.b;
        }
        if (str.equalsIgnoreCase("DATABASE")) {
          paramList = k.a.d;
        }
        localObject = paramList;
        if (str.equalsIgnoreCase(c.i.a())) {
          localObject = k.a.f;
        }
      }
    }
    return localObject;
  }
  
  public static void notifyObserverAsyncEnterMethod(f paramf)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramf);
    }
  }
  
  public static void notifyObserverEnterMethod(f paramf)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramf);
    }
  }
  
  public static void notifyObserverExitMethod()
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c();
    }
  }
  
  public static void notifyObserverExitMethodCustom(String paramString)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramString);
    }
  }
  
  public static void registerListener(a parama)
  {
    if (parama == null) {}
    while (metricEventListeners.contains(parama)) {
      return;
    }
    metricEventListeners.add(parama);
  }
  
  public static void removeListener(a parama)
  {
    if (parama == null) {
      return;
    }
    metricEventListeners.remove(parama);
  }
  
  private static boolean shouldInvokeMethod(String paramString)
  {
    return (paramString != null) && (!paramString.endsWith("#onCreate"));
  }
  
  public static void startTracing(String paramString)
  {
    QAPMAppInstrumentation.activityCreateBeginIns(paramString);
  }
  
  public static void startTracingInFragment(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTraceEngine
 * JD-Core Version:    0.7.0.1
 */