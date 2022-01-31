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
  
  /* Error */
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   6: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnonnull +17 -> 30
    //   16: ldc 2
    //   18: invokevirtual 36	java/lang/Object:wait	()V
    //   21: aconst_null
    //   22: astore 4
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload 4
    //   29: areturn
    //   30: aload 4
    //   32: invokestatic 42	java/lang/System:nanoTime	()J
    //   35: invokespecial 46	okio/AsyncTimeout:remainingNanos	(J)J
    //   38: lstore_0
    //   39: lload_0
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle +29 -> 71
    //   45: lload_0
    //   46: ldc2_w 47
    //   49: ldiv
    //   50: lstore_2
    //   51: ldc 2
    //   53: lload_2
    //   54: lload_0
    //   55: lload_2
    //   56: ldc2_w 47
    //   59: lmul
    //   60: lsub
    //   61: l2i
    //   62: invokevirtual 51	java/lang/Object:wait	(JI)V
    //   65: aconst_null
    //   66: astore 4
    //   68: goto -44 -> 24
    //   71: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   74: aload 4
    //   76: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   79: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   82: aload 4
    //   84: aconst_null
    //   85: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   88: goto -64 -> 24
    //   91: astore 4
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload 4
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	17	0	l1	long
    //   50	6	2	l2	long
    //   9	74	4	localAsyncTimeout	AsyncTimeout
    //   91	6	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	91	finally
    //   16	21	91	finally
    //   30	39	91	finally
    //   45	65	91	finally
    //   71	88	91	finally
  }
  
  /* Error */
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
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
    //   19: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   22: aload_0
    //   23: if_acmpne +21 -> 44
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   31: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   39: iconst_0
    //   40: istore_1
    //   41: goto -28 -> 13
    //   44: aload_2
    //   45: getfield 31	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
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
          new Watchdog().start();
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
    throws IOException
  {
    if (!exit()) {
      return paramIOException;
    }
    return newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean)
    throws IOException
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
  
  public final Sink sink(final Sink paramSink)
  {
    new Sink()
    {
      public void close()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public void flush()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.flush();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return "AsyncTimeout.sink(" + paramSink + ")";
      }
      
      public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramSink.write(paramAnonymousBuffer, paramAnonymousLong);
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException paramAnonymousBuffer)
        {
          throw AsyncTimeout.this.exit(paramAnonymousBuffer);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    new Source()
    {
      public void close()
        throws IOException
      {
        try
        {
          paramSource.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramAnonymousLong = paramSource.read(paramAnonymousBuffer, paramAnonymousLong);
          AsyncTimeout.this.exit(true);
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousBuffer)
        {
          throw AsyncTimeout.this.exit(paramAnonymousBuffer);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return "AsyncTimeout.source(" + paramSource + ")";
      }
    };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog
    extends Thread
  {
    public Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
          if (localAsyncTimeout != null) {
            localAsyncTimeout.timedOut();
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.7.0.1
 */