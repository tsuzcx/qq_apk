package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.TBSOneCallback;

public final class b<T>
  extends TBSOneCallback<T>
{
  T a;
  int b = 0;
  String c;
  private boolean d;
  
  private void a()
  {
    try
    {
      this.d = true;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/tbs/one/impl/b:d	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +8 -> 16
    //   11: aload_0
    //   12: lload_1
    //   13: invokevirtual 34	java/lang/Object:wait	(J)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore 4
    //   21: aload_0
    //   22: bipush 103
    //   24: putfield 20	com/tencent/tbs/one/impl/b:b	I
    //   27: aload_0
    //   28: ldc 36
    //   30: putfield 38	com/tencent/tbs/one/impl/b:c	Ljava/lang/String;
    //   33: goto -17 -> 16
    //   36: astore 4
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	b
    //   0	43	1	paramLong	long
    //   6	2	3	bool	boolean
    //   19	1	4	localInterruptedException	java.lang.InterruptedException
    //   36	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	19	java/lang/InterruptedException
    //   2	7	36	finally
    //   11	16	36	finally
    //   21	33	36	finally
  }
  
  public final void onCompleted(T paramT)
  {
    this.a = paramT;
    a();
  }
  
  public final void onError(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    a();
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b
 * JD-Core Version:    0.7.0.1
 */