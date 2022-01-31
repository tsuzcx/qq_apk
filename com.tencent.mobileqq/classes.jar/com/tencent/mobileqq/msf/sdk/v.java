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

public class v
  extends AbstractQueue
  implements Serializable
{
  private static final long d = -387911632671998426L;
  transient v.d a;
  transient v.d b;
  final ReentrantLock c = new ReentrantLock();
  private transient int e;
  private final int f;
  private final Condition g = this.c.newCondition();
  private final Condition h = this.c.newCondition();
  
  public v()
  {
    this(2147483647);
  }
  
  public v(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.f = paramInt;
  }
  
  public v(Collection paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    for (;;)
    {
      Object localObject;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject = paramCollection.next();
        if (localObject == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (!c(new v.d(localObject))) {
        throw new IllegalStateException("Deque full");
      }
    }
    localReentrantLock.unlock();
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
      for (v.d locald = this.a; locald != null; locald = locald.c) {
        paramObjectOutputStream.writeObject(locald.a);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private boolean b(v.d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    v.d locald = this.a;
    paramd.c = locald;
    this.a = paramd;
    if (this.b == null) {
      this.b = paramd;
    }
    for (;;)
    {
      this.e += 1;
      this.g.signal();
      return true;
      locald.b = paramd;
    }
  }
  
  private boolean c(v.d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    v.d locald = this.b;
    paramd.b = locald;
    this.b = paramd;
    if (this.a == null) {
      this.a = paramd;
    }
    for (;;)
    {
      this.e += 1;
      this.g.signal();
      return true;
      locald.c = paramd;
    }
  }
  
  private Object o()
  {
    v.d locald1 = this.a;
    if (locald1 == null) {
      return null;
    }
    v.d locald2 = locald1.c;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.c = locald1;
    this.a = locald2;
    if (locald2 == null) {
      this.b = null;
    }
    for (;;)
    {
      this.e -= 1;
      this.h.signal();
      return localObject;
      locald2.b = null;
    }
  }
  
  private Object p()
  {
    v.d locald1 = this.b;
    if (locald1 == null) {
      return null;
    }
    v.d locald2 = locald1.b;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.b = locald1;
    this.b = locald2;
    if (locald2 == null) {
      this.a = null;
    }
    for (;;)
    {
      this.e -= 1;
      this.h.signal();
      return localObject;
      locald2.c = null;
    }
  }
  
  public int a(Collection paramCollection)
  {
    return a(paramCollection, 2147483647);
  }
  
  public int a(Collection paramCollection, int paramInt)
  {
    int i = 0;
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
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
  
  public Object a()
  {
    Object localObject = c();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  /* Error */
  public Object a(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 155	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 158	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   17: aload_0
    //   18: invokespecial 143	com/tencent/mobileqq/msf/sdk/v:o	()Ljava/lang/Object;
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_3
    //   26: ifnonnull +12 -> 38
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +14 -> 46
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: aload 4
    //   45: areturn
    //   46: aload_0
    //   47: getfield 41	com/tencent/mobileqq/msf/sdk/v:g	Ljava/util/concurrent/locks/Condition;
    //   50: lload_1
    //   51: invokeinterface 161 3 0
    //   56: lstore_1
    //   57: goto -40 -> 17
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	v
    //   0	68	1	paramLong	long
    //   0	68	3	paramTimeUnit	TimeUnit
    //   23	21	4	localTimeUnit	TimeUnit
    //   10	52	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   17	22	60	finally
    //   46	57	60	finally
  }
  
  void a(v.d paramd)
  {
    v.d locald1 = paramd.b;
    v.d locald2 = paramd.c;
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
    if (!c(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  /* Error */
  public boolean a(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 70	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 71	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 76	com/tencent/mobileqq/msf/sdk/v$d
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 79	com/tencent/mobileqq/msf/sdk/v$d:<init>	(Ljava/lang/Object;)V
    //   20: astore_1
    //   21: aload 4
    //   23: lload_2
    //   24: invokevirtual 155	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 158	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 169	com/tencent/mobileqq/msf/sdk/v:b	(Lcom/tencent/mobileqq/msf/sdk/v$d;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +34 -> 82
    //   51: lload_2
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +14 -> 68
    //   57: iconst_0
    //   58: istore 5
    //   60: aload 4
    //   62: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: iload 5
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 43	com/tencent/mobileqq/msf/sdk/v:h	Ljava/util/concurrent/locks/Condition;
    //   72: lload_2
    //   73: invokeinterface 161 3 0
    //   78: lstore_2
    //   79: goto -40 -> 39
    //   82: iconst_1
    //   83: istore 5
    //   85: goto -25 -> 60
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	v
    //   0	96	1	paramObject	Object
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   44	40	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	46	88	finally
    //   68	79	88	finally
  }
  
  public boolean add(Object paramObject)
  {
    b(paramObject);
    return true;
  }
  
  public Object b()
  {
    Object localObject = d();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  /* Error */
  public Object b(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 155	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 158	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   17: aload_0
    //   18: invokespecial 164	com/tencent/mobileqq/msf/sdk/v:p	()Ljava/lang/Object;
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_3
    //   26: ifnonnull +12 -> 38
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +14 -> 46
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: aload 4
    //   45: areturn
    //   46: aload_0
    //   47: getfield 41	com/tencent/mobileqq/msf/sdk/v:g	Ljava/util/concurrent/locks/Condition;
    //   50: lload_1
    //   51: invokeinterface 161 3 0
    //   56: lstore_1
    //   57: goto -40 -> 17
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	v
    //   0	68	1	paramLong	long
    //   0	68	3	paramTimeUnit	TimeUnit
    //   23	21	4	localTimeUnit	TimeUnit
    //   10	52	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   17	22	60	finally
    //   46	57	60	finally
  }
  
  public void b(Object paramObject)
  {
    if (!d(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  /* Error */
  public boolean b(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 70	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 71	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 76	com/tencent/mobileqq/msf/sdk/v$d
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 79	com/tencent/mobileqq/msf/sdk/v$d:<init>	(Ljava/lang/Object;)V
    //   20: astore_1
    //   21: aload 4
    //   23: lload_2
    //   24: invokevirtual 155	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 158	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 82	com/tencent/mobileqq/msf/sdk/v:c	(Lcom/tencent/mobileqq/msf/sdk/v$d;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +34 -> 82
    //   51: lload_2
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +14 -> 68
    //   57: iconst_0
    //   58: istore 5
    //   60: aload 4
    //   62: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: iload 5
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 43	com/tencent/mobileqq/msf/sdk/v:h	Ljava/util/concurrent/locks/Condition;
    //   72: lload_2
    //   73: invokeinterface 161 3 0
    //   78: lstore_2
    //   79: goto -40 -> 39
    //   82: iconst_1
    //   83: istore 5
    //   85: goto -25 -> 60
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	v
    //   0	96	1	paramObject	Object
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   44	40	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	46	88	finally
    //   68	79	88	finally
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
    if (paramObject == null) {
      throw new NullPointerException();
    }
    v.d locald = new v.d(paramObject);
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
      v.d locald;
      for (Object localObject1 = this.a; localObject1 != null; localObject1 = locald)
      {
        ((v.d)localObject1).a = null;
        locald = ((v.d)localObject1).c;
        ((v.d)localObject1).b = null;
        ((v.d)localObject1).c = null;
      }
      this.b = null;
      this.a = null;
      this.e = 0;
      this.h.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 99	com/tencent/mobileqq/msf/sdk/v:a	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +19 -> 48
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   38: invokevirtual 189	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +12 -> 55
    //   46: iconst_1
    //   47: istore_2
    //   48: aload 5
    //   50: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: iload_2
    //   54: ireturn
    //   55: aload 4
    //   57: getfield 122	com/tencent/mobileqq/msf/sdk/v$d:c	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   60: astore 4
    //   62: goto -37 -> 25
    //   65: astore_1
    //   66: aload 5
    //   68: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	v
    //   0	73	1	paramObject	Object
    //   26	28	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	38	4	locald	v.d
    //   12	55	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	65	finally
    //   32	42	65	finally
    //   55	62	65	finally
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
    if (paramObject == null) {
      throw new NullPointerException();
    }
    v.d locald = new v.d(paramObject);
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
  
  public Object e()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject1 = o();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public void e(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    v.d locald = new v.d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      if (!b(locald)) {
        this.h.await();
      }
      return;
    }
    finally
    {
      paramObject.unlock();
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
      for (;;)
      {
        Object localObject1 = p();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public void f(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    v.d locald = new v.d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      if (!c(locald)) {
        this.h.await();
      }
      return;
    }
    finally
    {
      paramObject.unlock();
    }
  }
  
  public Object g()
  {
    Object localObject = i();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  /* Error */
  public boolean g(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 99	com/tencent/mobileqq/msf/sdk/v:a	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   38: invokevirtual 189	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +18 -> 59
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 200	com/tencent/mobileqq/msf/sdk/v:a	(Lcom/tencent/mobileqq/msf/sdk/v$d;)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   57: iload_2
    //   58: ireturn
    //   59: aload 4
    //   61: getfield 122	com/tencent/mobileqq/msf/sdk/v$d:c	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   64: astore 4
    //   66: goto -41 -> 25
    //   69: astore_1
    //   70: aload 5
    //   72: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	v
    //   0	77	1	paramObject	Object
    //   26	32	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	42	4	locald	v.d
    //   12	59	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	69	finally
    //   32	50	69	finally
    //   59	66	69	finally
  }
  
  public Object h()
  {
    Object localObject = j();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  /* Error */
  public boolean h(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 101	com/tencent/mobileqq/msf/sdk/v:b	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   38: invokevirtual 189	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +18 -> 59
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 200	com/tencent/mobileqq/msf/sdk/v:a	(Lcom/tencent/mobileqq/msf/sdk/v$d;)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   57: iload_2
    //   58: ireturn
    //   59: aload 4
    //   61: getfield 128	com/tencent/mobileqq/msf/sdk/v$d:b	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   64: astore 4
    //   66: goto -41 -> 25
    //   69: astore_1
    //   70: aload 5
    //   72: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	v
    //   0	77	1	paramObject	Object
    //   26	32	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	42	4	locald	v.d
    //   12	59	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	69	finally
    //   32	50	69	finally
    //   59	66	69	finally
  }
  
  /* Error */
  public Object i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 99	com/tencent/mobileqq/msf/sdk/v:a	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 99	com/tencent/mobileqq/msf/sdk/v:a	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   30: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	v
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public void i(Object paramObject)
  {
    f(paramObject);
  }
  
  public Iterator iterator()
  {
    return new v.c(this, null);
  }
  
  /* Error */
  public Object j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 101	com/tencent/mobileqq/msf/sdk/v:b	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 101	com/tencent/mobileqq/msf/sdk/v:b	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   30: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	v
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
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
    return new v.b(this, null);
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
    Object[] arrayOfObject;
    try
    {
      arrayOfObject = new Object[this.e];
      int i = 0;
      v.d locald = this.a;
      while (locald != null)
      {
        arrayOfObject[i] = locald.a;
        locald = locald.c;
        i += 1;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return arrayOfObject;
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
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public java.lang.String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/msf/sdk/v:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 99	com/tencent/mobileqq/msf/sdk/v:a	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +13 -> 30
    //   20: ldc 255
    //   22: astore_1
    //   23: aload 4
    //   25: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   28: aload_1
    //   29: areturn
    //   30: new 257	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   37: astore 5
    //   39: aload 5
    //   41: bipush 91
    //   43: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: getfield 117	com/tencent/mobileqq/msf/sdk/v$d:a	Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload_0
    //   56: if_acmpne +7 -> 63
    //   59: ldc_w 264
    //   62: astore_2
    //   63: aload 5
    //   65: aload_2
    //   66: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: getfield 122	com/tencent/mobileqq/msf/sdk/v$d:c	Lcom/tencent/mobileqq/msf/sdk/v$d;
    //   74: astore_1
    //   75: aload_1
    //   76: ifnonnull +17 -> 93
    //   79: aload 5
    //   81: bipush 93
    //   83: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   86: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_1
    //   90: goto -67 -> 23
    //   93: aload 5
    //   95: bipush 44
    //   97: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   100: bipush 32
    //   102: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -59 -> 47
    //   109: astore_1
    //   110: aload 4
    //   112: invokevirtual 74	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	v
    //   15	75	1	localObject1	Object
    //   109	7	1	localObject2	Object
    //   53	13	2	localObject3	Object
    //   51	4	3	localObject4	Object
    //   4	107	4	localReentrantLock	ReentrantLock
    //   37	57	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	109	finally
    //   30	47	109	finally
    //   47	52	109	finally
    //   63	75	109	finally
    //   79	90	109	finally
    //   93	106	109	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.v
 * JD-Core Version:    0.7.0.1
 */