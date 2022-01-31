package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AsyncTimeout
  extends Timeout
{
  private static AsyncTimeout head;
  private boolean inQueue;
  private AsyncTimeout next;
  private long timeoutAt;
  
  static AsyncTimeout awaitTimeout()
  {
    AsyncTimeout localAsyncTimeout1 = null;
    for (;;)
    {
      AsyncTimeout localAsyncTimeout2;
      try
      {
        localAsyncTimeout2 = head.next;
        if (localAsyncTimeout2 == null)
        {
          AsyncTimeout.class.wait();
          return localAsyncTimeout1;
        }
        long l1 = localAsyncTimeout2.remainingNanos(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          AsyncTimeout.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        head.next = localAsyncTimeout2.next;
      }
      finally {}
      localAsyncTimeout2.next = null;
      Object localObject2 = localAsyncTimeout2;
    }
  }
  
  /* Error */
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +10 -> 18
    //   11: iconst_1
    //   12: istore_1
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_2
    //   19: getfield 22	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   22: aload_0
    //   23: if_acmpne +21 -> 44
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 22	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   31: putfield 22	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 22	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   39: iconst_0
    //   40: istore_1
    //   41: goto -28 -> 13
    //   44: aload_2
    //   45: getfield 22	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   48: astore_2
    //   49: goto -42 -> 7
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramAsyncTimeout	AsyncTimeout
    //   12	29	1	bool	boolean
    //   6	43	2	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   18	39	52	finally
    //   44	49	52	finally
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (head == null)
        {
          head = new AsyncTimeout();
          new AsyncTimeout.Watchdog().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
          paramLong = paramAsyncTimeout.remainingNanos(l);
          localAsyncTimeout = head;
          if ((localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l))) {
            break label175;
          }
          paramAsyncTimeout.next = localAsyncTimeout.next;
          localAsyncTimeout.next = paramAsyncTimeout;
          if (localAsyncTimeout == head) {
            AsyncTimeout.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramAsyncTimeout.timeoutAt = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      continue;
      label167:
      throw new AssertionError();
      label175:
      AsyncTimeout localAsyncTimeout = localAsyncTimeout.next;
    }
  }
  
  public final void enter()
  {
    if (this.inQueue) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.inQueue = true;
    scheduleTimeout(this, l, bool);
  }
  
  final IOException exit(IOException paramIOException)
  {
    if (!exit()) {
      return paramIOException;
    }
    return newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean)
  {
    if ((exit()) && (paramBoolean)) {
      throw newTimeoutException(null);
    }
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final Sink sink(Sink paramSink)
  {
    return new AsyncTimeout.1(this, paramSink);
  }
  
  public final Source source(Source paramSource)
  {
    return new AsyncTimeout.2(this, paramSource);
  }
  
  protected void timedOut() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.7.0.1
 */