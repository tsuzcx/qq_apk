package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.instrumentation.i;
import com.tencent.qapmsdk.impl.instrumentation.j;

public class f
{
  protected ThreadLocal<i> a = new ThreadLocal();
  protected ThreadLocal<j<i>> b = new ThreadLocal();
  protected i c;
  
  public void a()
  {
    this.a.remove();
    if (this.b.get() != null) {
      ((j)this.b.get()).pop();
    }
    b();
  }
  
  public void a(i parami, Boolean paramBoolean)
  {
    if (parami == null) {}
    do
    {
      do
      {
        return;
      } while (e() == null);
      this.b.set(e());
      if ((e().isEmpty()) || (e().peek() != parami)) {
        e().push(parami);
      }
      this.a.set(parami);
    } while (!paramBoolean.booleanValue());
    this.c = parami;
  }
  
  public void b()
  {
    if ((this.b.get() == null) || (((j)this.b.get()).isEmpty())) {
      this.a.set(null);
    }
    i locali;
    do
    {
      return;
      locali = (i)((j)this.b.get()).peek();
      this.a.set(locali);
    } while (Looper.myLooper() != Looper.getMainLooper());
    this.c = locali;
  }
  
  public i c()
  {
    return (i)this.a.get();
  }
  
  public void d()
  {
    this.a.remove();
    if (this.b.get() != null) {
      ((j)this.b.get()).clear();
    }
  }
  
  protected j<i> e()
  {
    j localj2 = (j)this.b.get();
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    return localj1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.f
 * JD-Core Version:    0.7.0.1
 */