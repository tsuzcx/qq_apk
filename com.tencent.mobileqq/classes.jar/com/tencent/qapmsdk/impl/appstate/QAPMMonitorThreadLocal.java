package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.QAPMUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceStack;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CONTEXT;
import java.util.Vector;

public class QAPMMonitorThreadLocal
  extends MonitorThreadLocal
{
  private static final int METHOD_LIST_MAX = 20;
  private static volatile QAPMMonitorThreadLocal instance;
  protected ThreadLocal<Vector<QAPMUnit>> finishedMethodThreadLocal = new ThreadLocal();
  
  private Vector<QAPMUnit> getFinishMethods()
  {
    Vector localVector2 = (Vector)this.finishedMethodThreadLocal.get();
    Vector localVector1 = localVector2;
    if (localVector2 == null) {
      localVector1 = new Vector();
    }
    return localVector1;
  }
  
  public static QAPMMonitorThreadLocal getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QAPMMonitorThreadLocal();
      }
      return instance;
    }
    finally {}
  }
  
  public void clear()
  {
    if (this.finishedMethodThreadLocal.get() != null) {
      ((Vector)this.finishedMethodThreadLocal.get()).clear();
    }
    super.clear();
  }
  
  public ThreadLocal<Vector<QAPMUnit>> getFinishedMethodThreadLocal()
  {
    return this.finishedMethodThreadLocal;
  }
  
  public void pop(boolean paramBoolean)
  {
    if (getFinishMethods() != null)
    {
      if ((this.finishedMethodThreadLocal.get() == null) || (((Vector)this.finishedMethodThreadLocal.get()).size() < 20)) {
        this.finishedMethodThreadLocal.set(getFinishMethods());
      }
      if ((getTraceStack() != null) && (!getTraceStack().isEmpty()))
      {
        if (paramBoolean) {
          ((QAPMUnit)getTraceStack().peek()).complete();
        }
        getFinishMethods().add(getTraceStack().peek());
      }
    }
    super.pop();
  }
  
  public void push(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new QAPMTraceUnit(paramString1, paramString2, paramLong, paramLong, TraceType.CONTEXT.APP.getValue());
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      super.push(paramString1, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal
 * JD-Core Version:    0.7.0.1
 */