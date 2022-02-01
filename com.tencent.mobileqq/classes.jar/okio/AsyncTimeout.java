package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout
  extends Timeout
{
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  @Nullable
  static AsyncTimeout head;
  private boolean inQueue;
  @Nullable
  private AsyncTimeout next;
  private long timeoutAt;
  
  @Nullable
  static AsyncTimeout awaitTimeout()
  {
    Object localObject1 = head.next;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      l1 = System.nanoTime();
      AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
      localObject1 = localObject2;
      if (head.next == null)
      {
        localObject1 = localObject2;
        if (System.nanoTime() - l1 >= IDLE_TIMEOUT_NANOS) {
          localObject1 = head;
        }
      }
      return localObject1;
    }
    long l1 = ((AsyncTimeout)localObject1).remainingNanos(System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      AsyncTimeout.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    head.next = ((AsyncTimeout)localObject1).next;
    ((AsyncTimeout)localObject1).next = null;
    return localObject1;
  }
  
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    try
    {
      for (AsyncTimeout localAsyncTimeout = head; localAsyncTimeout != null; localAsyncTimeout = localAsyncTimeout.next) {
        if (localAsyncTimeout.next == paramAsyncTimeout)
        {
          localAsyncTimeout.next = paramAsyncTimeout.next;
          paramAsyncTimeout.next = null;
          return false;
        }
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramAsyncTimeout;
    }
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
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
      }
      else if (paramLong != 0L)
      {
        paramAsyncTimeout.timeoutAt = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label174;
        }
        paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      }
      paramLong = paramAsyncTimeout.remainingNanos(l);
      for (AsyncTimeout localAsyncTimeout = head; (localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l)); localAsyncTimeout = localAsyncTimeout.next) {}
      paramAsyncTimeout.next = localAsyncTimeout.next;
      localAsyncTimeout.next = paramAsyncTimeout;
      if (localAsyncTimeout == head) {
        AsyncTimeout.class.notify();
      }
      return;
      label174:
      throw new AssertionError();
    }
    finally {}
    for (;;)
    {
      throw paramAsyncTimeout;
    }
  }
  
  public final void enter()
  {
    if (!this.inQueue)
    {
      long l = timeoutNanos();
      boolean bool = hasDeadline();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.inQueue = true;
      scheduleTimeout(this, l, bool);
      return;
    }
    throw new IllegalStateException("Unbalanced enter/exit");
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
    if (exit())
    {
      if (!paramBoolean) {
        return;
      }
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
  
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.7.0.1
 */