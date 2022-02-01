package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.instrumentation.j;
import com.tencent.qapmsdk.impl.instrumentation.k;

public class g
{
  protected ThreadLocal<j> a = new ThreadLocal();
  protected ThreadLocal<k<j>> b = new ThreadLocal();
  protected j c;
  
  public void a()
  {
    this.a.remove();
    if (this.b.get() != null) {
      ((k)this.b.get()).pop();
    }
    b();
  }
  
  public void a(j paramj, Boolean paramBoolean)
  {
    if (paramj == null) {
      return;
    }
    if (e() != null)
    {
      this.b.set(e());
      if ((e().isEmpty()) || (e().peek() != paramj)) {
        e().push(paramj);
      }
      this.a.set(paramj);
      if (paramBoolean.booleanValue()) {
        this.c = paramj;
      }
    }
  }
  
  public void b()
  {
    if ((this.b.get() != null) && (!((k)this.b.get()).isEmpty()))
    {
      j localj = (j)((k)this.b.get()).peek();
      this.a.set(localj);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.c = localj;
      }
    }
    else
    {
      this.a.set(null);
    }
  }
  
  public j c()
  {
    return (j)this.a.get();
  }
  
  public void d()
  {
    this.a.remove();
    if (this.b.get() != null) {
      ((k)this.b.get()).clear();
    }
  }
  
  protected k<j> e()
  {
    k localk2 = (k)this.b.get();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = new k();
    }
    return localk1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.g
 * JD-Core Version:    0.7.0.1
 */