package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Looper;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.b.a;
import com.tencent.qapmsdk.impl.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QAPMTraceEngine
  extends a
{
  private static final String TAG = "QAPM_Impl_QAPMTraceEngine";
  private static List<b> metricEventListeners = new CopyOnWriteArrayList();
  
  public static void enterMethod(g paramg, String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      if (!shouldInvokeMethod(paramString)) {
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        notifyObserverEnterMethod(new g(paramString, getSegmentType(paramArrayList).a()));
        return;
      }
    }
    catch (Throwable paramg)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "error happend in enterMethod:", paramg);
      return;
    }
    notifyObserverAsyncEnterMethod(new g(paramString, getSegmentType(paramArrayList).a()));
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
  
  public static List<b> getMetricEventListeners()
  {
    return metricEventListeners;
  }
  
  public static l.a getSegmentType(List<String> paramList)
  {
    l.a locala = l.a.a;
    Object localObject = locala;
    if (paramList != null)
    {
      localObject = locala;
      if (paramList.size() == 3)
      {
        String str = (String)paramList.get(2);
        paramList = locala;
        if (str.equalsIgnoreCase(c.e.a())) {
          paramList = l.a.e;
        }
        if (str.equalsIgnoreCase(c.f.a())) {
          paramList = l.a.c;
        }
        if (str.equalsIgnoreCase(c.g.a())) {
          paramList = l.a.b;
        }
        if (str.equalsIgnoreCase("DATABASE")) {
          paramList = l.a.d;
        }
        localObject = paramList;
        if (str.equalsIgnoreCase(c.i.a())) {
          localObject = l.a.f;
        }
      }
    }
    return localObject;
  }
  
  public static void notifyObserverAsyncEnterMethod(g paramg)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(paramg);
    }
  }
  
  public static void notifyObserverEnterMethod(g paramg)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramg);
    }
  }
  
  public static void notifyObserverExitMethod()
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).c();
    }
  }
  
  public static void notifyObserverExitMethodCustom(String paramString)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramString);
    }
  }
  
  public static void registerListener(b paramb)
  {
    if (paramb == null) {}
    while (metricEventListeners.contains(paramb)) {
      return;
    }
    metricEventListeners.add(paramb);
  }
  
  public static void removeListener(b paramb)
  {
    if (paramb == null) {
      return;
    }
    metricEventListeners.remove(paramb);
  }
  
  private static boolean shouldInvokeMethod(String paramString)
  {
    return (paramString != null) && (!paramString.endsWith("#onCreate"));
  }
  
  public static void startTracing(String paramString)
  {
    QAPMAppInstrumentation.activityCreateBeginIns(paramString);
  }
  
  public static void startTracingInFragment(String paramString)
  {
    QAPMFragmentSession.fragmentOnCreateBegin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTraceEngine
 * JD-Core Version:    0.7.0.1
 */