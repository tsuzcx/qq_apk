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
  
  /* Error */
  w$a(w paramw)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 17	com/tencent/mobileqq/msf/sdk/w$a:c	Lcom/tencent/mobileqq/msf/sdk/w;
    //   5: aload_0
    //   6: invokespecial 20	java/lang/Object:<init>	()V
    //   9: aload_1
    //   10: getfield 25	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 33	com/tencent/mobileqq/msf/sdk/w$a:a	()Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   23: putfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   26: aload_0
    //   27: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   30: ifnonnull +15 -> 45
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 37	com/tencent/mobileqq/msf/sdk/w$a:b	Ljava/lang/Object;
    //   40: aload_2
    //   41: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   44: return
    //   45: aload_0
    //   46: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   49: getfield 44	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   52: astore_1
    //   53: goto -18 -> 35
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramw	w
    //   13	45	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   18	33	56	finally
    //   35	40	56	finally
    //   45	53	56	finally
  }
  
  private w.d b(w.d paramd)
  {
    for (;;)
    {
      w.d locald1 = a(paramd);
      w.d locald2;
      if (locald1 == null) {
        locald2 = null;
      }
      do
      {
        return locald2;
        locald2 = locald1;
      } while (locald1.a != null);
      if (locald1 == paramd) {
        return a();
      }
      paramd = locald1;
    }
  }
  
  abstract w.d a();
  
  abstract w.d a(w.d paramd);
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/msf/sdk/w$a:c	Lcom/tencent/mobileqq/msf/sdk/w;
    //   4: getfield 25	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   18: invokespecial 50	com/tencent/mobileqq/msf/sdk/w$a:b	(Lcom/tencent/mobileqq/msf/sdk/w$d;)Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   21: putfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   24: aload_0
    //   25: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   28: ifnonnull +15 -> 43
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 37	com/tencent/mobileqq/msf/sdk/w$a:b	Ljava/lang/Object;
    //   38: aload_2
    //   39: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: return
    //   43: aload_0
    //   44: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   47: getfield 44	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	a
    //   32	19	1	localObject1	Object
    //   54	6	1	localObject2	Object
    //   7	49	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   12	31	54	finally
    //   33	38	54	finally
    //   43	51	54	finally
  }
  
  public boolean hasNext()
  {
    return this.a != null;
  }
  
  public Object next()
  {
    if (this.a == null) {
      throw new NoSuchElementException();
    }
    this.d = this.a;
    Object localObject = this.b;
    b();
    return localObject;
  }
  
  public void remove()
  {
    w.d locald = this.d;
    if (locald == null) {
      throw new IllegalStateException();
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.w.a
 * JD-Core Version:    0.7.0.1
 */