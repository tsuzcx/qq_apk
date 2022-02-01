package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.e.a;
import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.j;
import com.tencent.qapmsdk.impl.instrumentation.k;
import com.tencent.qapmsdk.impl.instrumentation.l.b;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class QAPMMonitorThreadLocal
  extends g
{
  private static volatile QAPMMonitorThreadLocal e;
  protected ThreadLocal<Vector<j>> d = new ThreadLocal();
  
  private Vector<j> g()
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
  
  public ThreadLocal<Vector<j>> f()
  {
    return this.d;
  }
  
  public void pop(boolean paramBoolean)
  {
    j localj;
    if (g() != null)
    {
      if ((this.d.get() == null) || (((Vector)this.d.get()).size() < 20)) {
        this.d.set(g());
      }
      if ((e() != null) && (!e().isEmpty()))
      {
        if (paramBoolean) {
          ((j)e().peek()).a();
        }
        localj = (j)e().peek();
        if (localj == null) {
          return;
        }
        if ((b.e.get()) || (b.a.contains(localj.h)) || (b.b.contains(localj.h))) {
          break label148;
        }
        a.a().a(0L, localj);
      }
    }
    for (;;)
    {
      super.a();
      return;
      label148:
      if (("QAPM_APPLAUNCH".equals(localj.g)) && (!b.d())) {
        break;
      }
      g().add(localj);
    }
  }
  
  public void push(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new com.tencent.qapmsdk.impl.instrumentation.g(paramString1, paramString2, paramLong, paramLong, l.b.b.a());
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