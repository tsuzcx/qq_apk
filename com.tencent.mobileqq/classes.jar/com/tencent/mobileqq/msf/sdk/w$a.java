package com.tencent.mobileqq.msf.sdk;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

abstract class w$a
  implements Iterator
{
  w.d a;
  Object b;
  private w.d d;
  
  w$a(w paramw)
  {
    ReentrantLock localReentrantLock = paramw.c;
    localReentrantLock.lock();
    try
    {
      this.a = a();
      if (this.a == null) {
        paramw = null;
      } else {
        paramw = this.a.a;
      }
      this.b = paramw;
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private w.d b(w.d paramd)
  {
    for (;;)
    {
      w.d locald = a(paramd);
      if (locald == null) {
        return null;
      }
      if (locald.a != null) {
        return locald;
      }
      if (locald == paramd) {
        return a();
      }
      paramd = locald;
    }
  }
  
  abstract w.d a();
  
  abstract w.d a(w.d paramd);
  
  void b()
  {
    ReentrantLock localReentrantLock = this.c.c;
    localReentrantLock.lock();
    try
    {
      this.a = b(this.a);
      Object localObject1;
      if (this.a == null) {
        localObject1 = null;
      } else {
        localObject1 = this.a.a;
      }
      this.b = localObject1;
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean hasNext()
  {
    return this.a != null;
  }
  
  public Object next()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      this.d = ((w.d)localObject);
      localObject = this.b;
      b();
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    w.d locald = this.d;
    if (locald != null)
    {
      this.d = null;
      ReentrantLock localReentrantLock = this.c.c;
      localReentrantLock.lock();
      try
      {
        if (locald.a != null) {
          this.c.a(locald);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.w.a
 * JD-Core Version:    0.7.0.1
 */