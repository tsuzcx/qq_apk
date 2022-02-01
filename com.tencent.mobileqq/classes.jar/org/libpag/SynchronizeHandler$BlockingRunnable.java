package org.libpag;

import android.os.Handler;
import android.os.SystemClock;

final class SynchronizeHandler$BlockingRunnable
  implements Runnable
{
  private boolean isTimeout = false;
  private boolean mDone;
  private final SynchronizeHandler.TimeoutRunnable mTask;
  
  public SynchronizeHandler$BlockingRunnable(SynchronizeHandler.TimeoutRunnable paramTimeoutRunnable)
  {
    this.mTask = paramTimeoutRunnable;
  }
  
  public boolean postAndWait(Handler paramHandler, long paramLong)
  {
    if (!paramHandler.post(this)) {
      return false;
    }
    if (paramLong > 0L) {}
    try
    {
      long l1 = SystemClock.uptimeMillis();
      long l2;
      if (!this.mDone)
      {
        l2 = l1 + paramLong - SystemClock.uptimeMillis();
        if (l2 <= 0L)
        {
          this.isTimeout = true;
          return false;
        }
      }
      for (;;)
      {
        try
        {
          wait(l2);
        }
        catch (InterruptedException paramHandler) {}
        boolean bool = this.mDone;
        if (!bool) {}
        try
        {
          wait();
        }
        catch (InterruptedException paramHandler) {}
      }
      return true;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramHandler;
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
    //   4: invokeinterface 50 1 0
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 39	org/libpag/SynchronizeHandler$BlockingRunnable:mDone	Z
    //   16: aload_0
    //   17: invokevirtual 53	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: getfield 20	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
    //   24: aload_0
    //   25: getfield 18	org/libpag/SynchronizeHandler$BlockingRunnable:isTimeout	Z
    //   28: invokeinterface 57 2 0
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 39	org/libpag/SynchronizeHandler$BlockingRunnable:mDone	Z
    //   49: aload_0
    //   50: invokevirtual 53	java/lang/Object:notifyAll	()V
    //   53: aload_0
    //   54: getfield 20	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
    //   57: aload_0
    //   58: getfield 18	org/libpag/SynchronizeHandler$BlockingRunnable:isTimeout	Z
    //   61: invokeinterface 57 2 0
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	BlockingRunnable
    //   36	4	1	localObject1	Object
    //   41	28	1	localObject2	Object
    //   70	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	35	36	finally
    //   37	39	36	finally
    //   0	9	41	finally
    //   44	68	70	finally
    //   71	73	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.SynchronizeHandler.BlockingRunnable
 * JD-Core Version:    0.7.0.1
 */