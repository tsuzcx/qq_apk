package com.tencent.mobileqq.msf.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class w
  extends AbstractQueue
  implements Serializable
{
  private static final long d = -387911632671998426L;
  transient w.d a;
  transient w.d b;
  final ReentrantLock c = new ReentrantLock();
  private transient int e;
  private final int f;
  private final Condition g = this.c.newCondition();
  private final Condition h = this.c.newCondition();
  
  public w()
  {
    this(2147483647);
  }
  
  public w(int paramInt)
  {
    if (paramInt > 0)
    {
      this.f = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public w(Collection paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (localObject != null)
        {
          if (!c(new w.d(localObject))) {
            throw new IllegalStateException("Deque full");
          }
        }
        else {
          throw new NullPointerException();
        }
      }
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.e = 0;
    this.a = null;
    this.b = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (w.d locald = this.a; locald != null; locald = locald.c) {
        paramObjectOutputStream.writeObject(locald.a);
      }
      paramObjectOutputStream.writeObject(null);
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObjectOutputStream;
    }
  }
  
  private boolean b(w.d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    w.d locald = this.a;
    paramd.c = locald;
    this.a = paramd;
    if (this.b == null) {
      this.b = paramd;
    } else {
      locald.b = paramd;
    }
    this.e += 1;
    this.g.signal();
    return true;
  }
  
  private boolean c(w.d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    w.d locald = this.b;
    paramd.b = locald;
    this.b = paramd;
    if (this.a == null) {
      this.a = paramd;
    } else {
      locald.c = paramd;
    }
    this.e += 1;
    this.g.signal();
    return true;
  }
  
  private Object o()
  {
    w.d locald1 = this.a;
    if (locald1 == null) {
      return null;
    }
    w.d locald2 = locald1.c;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.c = locald1;
    this.a = locald2;
    if (locald2 == null) {
      this.b = null;
    } else {
      locald2.b = null;
    }
    this.e -= 1;
    this.h.signal();
    return localObject;
  }
  
  private Object p()
  {
    w.d locald1 = this.b;
    if (locald1 == null) {
      return null;
    }
    w.d locald2 = locald1.b;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.b = locald1;
    this.b = locald2;
    if (locald2 == null) {
      this.a = null;
    } else {
      locald2.c = null;
    }
    this.e -= 1;
    this.h.signal();
    return localObject;
  }
  
  public int a(Collection paramCollection)
  {
    return a(paramCollection, 2147483647);
  }
  
  public int a(Collection paramCollection, int paramInt)
  {
    if (paramCollection != null)
    {
      if (paramCollection != this)
      {
        int i = 0;
        if (paramInt <= 0) {
          return 0;
        }
        ReentrantLock localReentrantLock = this.c;
        localReentrantLock.lock();
        try
        {
          int j = Math.min(paramInt, this.e);
          paramInt = i;
          while (paramInt < j)
          {
            paramCollection.add(this.a.a);
            o();
            paramInt += 1;
          }
          return j;
        }
        finally
        {
          localReentrantLock.unlock();
        }
      }
      throw new IllegalArgumentException();
    }
    paramCollection = new NullPointerException();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  public Object a()
  {
    Object localObject = c();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public Object a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = o();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          return null;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      paramTimeUnit.unlock();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void a(w.d paramd)
  {
    w.d locald1 = paramd.b;
    w.d locald2 = paramd.c;
    if (locald1 == null)
    {
      o();
      return;
    }
    if (locald2 == null)
    {
      p();
      return;
    }
    locald1.c = locald2;
    locald2.b = locald1;
    paramd.a = null;
    this.e -= 1;
    this.h.signal();
  }
  
  public void a(Object paramObject)
  {
    if (c(paramObject)) {
      return;
    }
    throw new IllegalStateException("Deque full");
  }
  
  public boolean a(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramObject != null)
    {
      paramObject = new w.d(paramObject);
      paramLong = paramTimeUnit.toNanos(paramLong);
      paramTimeUnit = this.c;
      paramTimeUnit.lockInterruptibly();
      try
      {
        for (;;)
        {
          boolean bool = b(paramObject);
          if (bool) {
            break;
          }
          if (paramLong <= 0L) {
            return false;
          }
          paramLong = this.h.awaitNanos(paramLong);
        }
        return true;
      }
      finally
      {
        paramTimeUnit.unlock();
      }
    }
    paramObject = new NullPointerException();
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public boolean add(Object paramObject)
  {
    b(paramObject);
    return true;
  }
  
  public Object b()
  {
    Object localObject = d();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public Object b(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = p();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          return null;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      paramTimeUnit.unlock();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(Object paramObject)
  {
    if (d(paramObject)) {
      return;
    }
    throw new IllegalStateException("Deque full");
  }
  
  public boolean b(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramObject != null)
    {
      paramObject = new w.d(paramObject);
      paramLong = paramTimeUnit.toNanos(paramLong);
      paramTimeUnit = this.c;
      paramTimeUnit.lockInterruptibly();
      try
      {
        for (;;)
        {
          boolean bool = c(paramObject);
          if (bool) {
            break;
          }
          if (paramLong <= 0L) {
            return false;
          }
          paramLong = this.h.awaitNanos(paramLong);
        }
        return true;
      }
      finally
      {
        paramTimeUnit.unlock();
      }
    }
    paramObject = new NullPointerException();
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object c()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = o();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object c(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit);
  }
  
  public boolean c(Object paramObject)
  {
    if (paramObject != null)
    {
      w.d locald = new w.d(paramObject);
      paramObject = this.c;
      paramObject.lock();
      try
      {
        boolean bool = b(locald);
        return bool;
      }
      finally
      {
        paramObject.unlock();
      }
    }
    throw new NullPointerException();
  }
  
  public boolean c(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramObject, paramLong, paramTimeUnit);
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      w.d locald;
      for (Object localObject1 = this.a; localObject1 != null; localObject1 = locald)
      {
        ((w.d)localObject1).a = null;
        locald = ((w.d)localObject1).c;
        ((w.d)localObject1).b = null;
        ((w.d)localObject1).c = null;
      }
      this.b = null;
      this.a = null;
      this.e = 0;
      this.h.signalAll();
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (w.d locald = this.a; locald != null; locald = locald.c)
      {
        boolean bool = paramObject.equals(locald.a);
        if (bool)
        {
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object d()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = p();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean d(Object paramObject)
  {
    if (paramObject != null)
    {
      w.d locald = new w.d(paramObject);
      paramObject = this.c;
      paramObject.lock();
      try
      {
        boolean bool = c(locald);
        return bool;
      }
      finally
      {
        paramObject.unlock();
      }
    }
    throw new NullPointerException();
  }
  
  public Object e()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = o();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
      localReentrantLock.unlock();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void e(Object paramObject)
  {
    if (paramObject != null)
    {
      w.d locald = new w.d(paramObject);
      paramObject = this.c;
      paramObject.lock();
      try
      {
        while (!b(locald)) {
          this.h.await();
        }
        return;
      }
      finally
      {
        paramObject.unlock();
      }
    }
    paramObject = new NullPointerException();
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object element()
  {
    return g();
  }
  
  public Object f()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = p();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
      localReentrantLock.unlock();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void f(Object paramObject)
  {
    if (paramObject != null)
    {
      w.d locald = new w.d(paramObject);
      paramObject = this.c;
      paramObject.lock();
      try
      {
        while (!c(locald)) {
          this.h.await();
        }
        return;
      }
      finally
      {
        paramObject.unlock();
      }
    }
    paramObject = new NullPointerException();
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object g()
  {
    Object localObject = i();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public boolean g(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (w.d locald = this.a; locald != null; locald = locald.c) {
        if (paramObject.equals(locald.a))
        {
          a(locald);
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object h()
  {
    Object localObject = j();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public boolean h(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (w.d locald = this.b; locald != null; locald = locald.b) {
        if (paramObject.equals(locald.a))
        {
          a(locald);
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public Object i()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      if (this.a == null) {
        localObject1 = null;
      } else {
        localObject1 = this.a.a;
      }
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public void i(Object paramObject)
  {
    f(paramObject);
  }
  
  public Iterator iterator()
  {
    return new w.c(this, null);
  }
  
  public Object j()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      if (this.b == null) {
        localObject1 = null;
      } else {
        localObject1 = this.b.a;
      }
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public void j(Object paramObject)
  {
    a(paramObject);
  }
  
  public Object k()
  {
    return e();
  }
  
  public int l()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.f;
      int j = this.e;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object m()
  {
    return a();
  }
  
  public Iterator n()
  {
    return new w.b(this, null);
  }
  
  public boolean offer(Object paramObject)
  {
    return d(paramObject);
  }
  
  public Object peek()
  {
    return i();
  }
  
  public Object poll()
  {
    return c();
  }
  
  public Object remove()
  {
    return a();
  }
  
  public boolean remove(Object paramObject)
  {
    return g(paramObject);
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.e];
      int i = 0;
      w.d locald = this.a;
      while (locald != null)
      {
        arrayOfObject[i] = locald.a;
        locald = locald.c;
        i += 1;
      }
      localReentrantLock.unlock();
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object[] arrayOfObject = paramArrayOfObject;
    try
    {
      if (paramArrayOfObject.length < this.e) {
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), this.e);
      }
      int i = 0;
      paramArrayOfObject = this.a;
      while (paramArrayOfObject != null)
      {
        arrayOfObject[i] = paramArrayOfObject.a;
        paramArrayOfObject = paramArrayOfObject.c;
        i += 1;
      }
      if (arrayOfObject.length > i) {
        arrayOfObject[i] = null;
      }
      localReentrantLock.unlock();
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramArrayOfObject;
    }
  }
  
  public String toString()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null)
      {
        localReentrantLock.unlock();
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      for (;;)
      {
        Object localObject4 = ((w.d)localObject1).a;
        Object localObject3 = localObject4;
        if (localObject4 == this) {
          localObject3 = "(this Collection)";
        }
        localStringBuilder.append(localObject3);
        localObject1 = ((w.d)localObject1).c;
        if (localObject1 == null)
        {
          localStringBuilder.append(']');
          localObject1 = localStringBuilder.toString();
          localReentrantLock.unlock();
          return localObject1;
        }
        localStringBuilder.append(',');
        localStringBuilder.append(' ');
      }
      throw localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.w
 * JD-Core Version:    0.7.0.1
 */