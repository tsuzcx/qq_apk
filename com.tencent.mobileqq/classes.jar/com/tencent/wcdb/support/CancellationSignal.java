package com.tencent.wcdb.support;

public final class CancellationSignal
{
  private boolean a;
  private CancellationSignal.OnCancelListener b;
  private ICancellationSignal c;
  private boolean d;
  
  private void d()
  {
    while (this.d) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        label14:
        break label14;
      }
    }
  }
  
  public void a(CancellationSignal.OnCancelListener paramOnCancelListener)
  {
    try
    {
      d();
      if (this.b == paramOnCancelListener) {
        return;
      }
      this.b = paramOnCancelListener;
      if ((this.a) && (paramOnCancelListener != null))
      {
        paramOnCancelListener.c();
        return;
      }
      return;
    }
    finally {}
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
  
  public void b()
  {
    if (!a()) {
      return;
    }
    throw new OperationCanceledException();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/wcdb/support/CancellationSignal:a	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 30	com/tencent/wcdb/support/CancellationSignal:a	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 20	com/tencent/wcdb/support/CancellationSignal:d	Z
    //   22: aload_0
    //   23: getfield 28	com/tencent/wcdb/support/CancellationSignal:b	Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 44	com/tencent/wcdb/support/CancellationSignal:c	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull +16 -> 51
    //   38: aload_1
    //   39: invokeinterface 34 1 0
    //   44: goto +7 -> 51
    //   47: astore_1
    //   48: goto +16 -> 64
    //   51: aload_2
    //   52: ifnull +32 -> 84
    //   55: aload_2
    //   56: invokeinterface 48 1 0
    //   61: goto +23 -> 84
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 20	com/tencent/wcdb/support/CancellationSignal:d	Z
    //   71: aload_0
    //   72: invokevirtual 51	java/lang/Object:notifyAll	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 20	com/tencent/wcdb/support/CancellationSignal:d	Z
    //   91: aload_0
    //   92: invokevirtual 51	java/lang/Object:notifyAll	()V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -25 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	CancellationSignal
    //   26	13	1	localOnCancelListener	CancellationSignal.OnCancelListener
    //   47	31	1	localObject1	Object
    //   79	4	1	localObject2	Object
    //   98	4	1	localObject3	Object
    //   103	4	1	localObject4	Object
    //   108	1	1	localRemoteException	android.os.RemoteException
    //   31	25	2	localICancellationSignal	ICancellationSignal
    // Exception table:
    //   from	to	target	type
    //   38	44	47	finally
    //   55	61	47	finally
    //   66	77	79	finally
    //   80	82	79	finally
    //   86	97	98	finally
    //   99	101	98	finally
    //   2	11	103	finally
    //   12	34	103	finally
    //   104	106	103	finally
    //   55	61	108	android/os/RemoteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.CancellationSignal
 * JD-Core Version:    0.7.0.1
 */