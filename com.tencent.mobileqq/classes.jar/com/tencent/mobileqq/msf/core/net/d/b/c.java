package com.tencent.mobileqq.msf.core.net.d.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static final String a = "Dispatcher";
  private final Object b = new Object();
  private final ArrayDeque c = new ArrayDeque();
  private final ArrayDeque d = new ArrayDeque();
  private final List e = new ArrayList();
  
  private d a(com.tencent.mobileqq.msf.core.d paramd)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.a(paramd)) {
        return locald;
      }
    }
    return null;
  }
  
  private void a()
  {
    Object localObject2 = new ArrayList();
    synchronized (this.b)
    {
      Iterator localIterator = this.c.iterator();
      e locale;
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        localIterator.remove();
        ((List)localObject2).add(locale);
        this.d.add(locale);
      }
      ((List)localObject2).size();
      localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        com.tencent.mobileqq.msf.core.d locald = locale.a();
        localObject2 = a(locald);
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = new d(locald);
        }
        this.e.add(???);
        if (!((d)???).a(locale)) {
          synchronized (this.b)
          {
            this.c.add(locale);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject4;
    }
  }
  
  public void a(e parame)
  {
    synchronized (this.b)
    {
      this.c.add(parame);
      a();
      return;
    }
  }
  
  public void b(e parame)
  {
    synchronized (this.b)
    {
      this.d.remove(parame);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.c
 * JD-Core Version:    0.7.0.1
 */