package com.tencent.qapmsdk.impl.instrumentation.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private boolean a = false;
  private ArrayList<d> b = new ArrayList();
  
  private boolean b()
  {
    try
    {
      boolean bool = a();
      if (!bool) {
        this.a = true;
      }
      return bool;
    }
    finally {}
  }
  
  private List<d> c()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList2 = new ArrayList(this.b);
      this.b.clear();
      return localArrayList2;
    }
  }
  
  public void a(c paramc)
  {
    if (!b())
    {
      Iterator localIterator = c().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(paramc);
      }
    }
  }
  
  public void a(d paramd)
  {
    synchronized (this.b)
    {
      this.b.add(paramd);
      return;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally {}
  }
  
  public void b(c paramc)
  {
    if (!b())
    {
      Iterator localIterator = c().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(paramc);
      }
    }
  }
  
  public void b(d paramd)
  {
    synchronized (this.b)
    {
      this.b.remove(paramd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.b.e
 * JD-Core Version:    0.7.0.1
 */