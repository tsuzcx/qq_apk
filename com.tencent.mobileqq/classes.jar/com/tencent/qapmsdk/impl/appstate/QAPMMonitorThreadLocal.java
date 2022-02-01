package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.instrumentation.i;
import com.tencent.qapmsdk.impl.instrumentation.j;
import com.tencent.qapmsdk.impl.instrumentation.k.b;
import java.util.Vector;

public class QAPMMonitorThreadLocal
  extends f
{
  private static volatile QAPMMonitorThreadLocal e;
  protected ThreadLocal<Vector<i>> d = new ThreadLocal();
  
  private Vector<i> g()
  {
    Vector localVector2 = (Vector)this.d.get();
    Vector localVector1 = localVector2;
    if (localVector2 == null) {
      localVector1 = new Vector();
    }
    return localVector1;
  }
  
  public static QAPMMonitorThreadLocal getInstance()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new QAPMMonitorThreadLocal();
      }
      return e;
    }
    finally {}
  }
  
  public void d()
  {
    if (this.d.get() != null) {
      ((Vector)this.d.get()).clear();
    }
    super.d();
  }
  
  public ThreadLocal<Vector<i>> f()
  {
    return this.d;
  }
  
  public void pop(boolean paramBoolean)
  {
    if (g() != null)
    {
      if ((this.d.get() == null) || (((Vector)this.d.get()).size() < 20)) {
        this.d.set(g());
      }
      if ((e() != null) && (!e().isEmpty()))
      {
        if (paramBoolean) {
          ((i)e().peek()).a();
        }
        g().add(e().peek());
      }
    }
    super.a();
  }
  
  public void push(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new com.tencent.qapmsdk.impl.instrumentation.f(paramString1, paramString2, paramLong, paramLong, k.b.b.a());
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(paramString1, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal
 * JD-Core Version:    0.7.0.1
 */