package com.tencent.tbs.one.impl.a;

import java.util.ArrayList;

public abstract class a<T>
{
  public boolean a;
  private final Object b = new Object();
  private ArrayList<l<T>> c = new ArrayList();
  private boolean d;
  private boolean e;
  private int f;
  private T g;
  private int h;
  private String i;
  private Throwable j;
  
  public abstract void a();
  
  public final void a(int paramInt)
  {
    int k = 0;
    synchronized (this.b)
    {
      if (paramInt - this.f > 2)
      {
        int m = this.f;
        this.f = paramInt;
        l[] arrayOfl = (l[])this.c.toArray(new l[0]);
        int n = arrayOfl.length;
        while (k < n)
        {
          arrayOfl[k].a(m, paramInt);
          k += 1;
        }
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    int k = 0;
    synchronized (this.b)
    {
      this.d = false;
      this.f = 0;
      this.h = paramInt;
      this.i = paramString;
      this.j = paramThrowable;
      l[] arrayOfl = (l[])this.c.toArray(new l[0]);
      this.c.clear();
      int m = arrayOfl.length;
      while (k < m)
      {
        arrayOfl[k].a(paramInt, paramString, paramThrowable);
        k += 1;
      }
      return;
    }
  }
  
  public final void a(l<T> paraml)
  {
    synchronized (this.b)
    {
      if (this.e)
      {
        if (paraml != null)
        {
          paraml.a(0, 100);
          paraml.a(this.g);
        }
        return;
      }
      if (this.h != 0)
      {
        if (paraml != null) {
          paraml.a(this.h, this.i, this.j);
        }
        return;
      }
    }
    if (paraml != null)
    {
      paraml.a(0, this.f);
      this.c.add(paraml);
    }
    if (this.d) {
      return;
    }
    this.d = true;
    a();
  }
  
  public void a(T paramT)
  {
    int k = 0;
    synchronized (this.b)
    {
      this.d = false;
      this.e = true;
      int m = this.f;
      this.f = 100;
      this.g = paramT;
      l[] arrayOfl = (l[])this.c.toArray(new l[0]);
      this.c.clear();
      int n = arrayOfl.length;
      while (k < n)
      {
        l locall = arrayOfl[k];
        locall.a(m, 100);
        locall.a(paramT);
        k += 1;
      }
      return;
    }
  }
  
  public void b()
  {
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.a
 * JD-Core Version:    0.7.0.1
 */