package com.tencent.mobileqq.microapp.apkg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public List f;
  
  public k a()
  {
    try
    {
      localk1 = (k)super.clone();
      try
      {
        localk1.f = new LinkedList();
        Iterator localIterator = this.f.iterator();
        for (;;)
        {
          Object localObject = localk1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (k.a)localIterator.next();
          localk1.f.add(((k.a)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        k localk2;
        k localk1 = null;
      }
    }
    localk2 = localk1;
    return localk2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.k
 * JD-Core Version:    0.7.0.1
 */