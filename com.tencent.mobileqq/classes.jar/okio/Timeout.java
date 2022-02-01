package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", "other", "block", "Lkotlin/Function0;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k=1, mv={1, 1, 16})
public class Timeout
{
  public static final Timeout.Companion Companion = new Timeout.Companion(null);
  @JvmField
  @NotNull
  public static final Timeout NONE = (Timeout)new Timeout.Companion.NONE.1();
  private long deadlineNanoTime;
  private boolean hasDeadline;
  private long timeoutNanos;
  
  @NotNull
  public Timeout clearDeadline()
  {
    this.hasDeadline = false;
    return this;
  }
  
  @NotNull
  public Timeout clearTimeout()
  {
    this.timeoutNanos = 0L;
    return this;
  }
  
  @NotNull
  public final Timeout deadline(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    int i;
    if (paramLong > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("duration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramTimeUnit.toString().toString()));
  }
  
  public long deadlineNanoTime()
  {
    if (this.hasDeadline) {
      return this.deadlineNanoTime;
    }
    throw ((Throwable)new IllegalStateException("No deadline".toString()));
  }
  
  @NotNull
  public Timeout deadlineNanoTime(long paramLong)
  {
    this.hasDeadline = true;
    this.deadlineNanoTime = paramLong;
    return this;
  }
  
  public boolean hasDeadline()
  {
    return this.hasDeadline;
  }
  
  public final void intersectWith(@NotNull Timeout paramTimeout, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeout, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    long l1 = timeoutNanos();
    timeout(Companion.minTimeout(paramTimeout.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
    if (hasDeadline())
    {
      long l2 = deadlineNanoTime();
      if (paramTimeout.hasDeadline()) {
        deadlineNanoTime(Math.min(deadlineNanoTime(), paramTimeout.deadlineNanoTime()));
      }
      try
      {
        paramFunction0.invoke();
        return;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        timeout(l1, TimeUnit.NANOSECONDS);
        if (paramTimeout.hasDeadline()) {
          deadlineNanoTime(l2);
        }
        InlineMarker.finallyEnd(1);
      }
    }
    if (paramTimeout.hasDeadline()) {
      deadlineNanoTime(paramTimeout.deadlineNanoTime());
    }
    try
    {
      paramFunction0.invoke();
      return;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      timeout(l1, TimeUnit.NANOSECONDS);
      if (paramTimeout.hasDeadline()) {
        clearDeadline();
      }
      InlineMarker.finallyEnd(1);
    }
  }
  
  public void throwIfReached()
  {
    if (!Thread.interrupted())
    {
      if (this.hasDeadline)
      {
        if (this.deadlineNanoTime - System.nanoTime() > 0L) {
          return;
        }
        throw ((Throwable)new InterruptedIOException("deadline reached"));
      }
      return;
    }
    Thread.currentThread().interrupt();
    throw ((Throwable)new InterruptedIOException("interrupted"));
  }
  
  @NotNull
  public Timeout timeout(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
      return this;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("timeout < 0: ");
    paramTimeUnit.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramTimeUnit.toString().toString()));
  }
  
  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }
  
  public final void waitUntilNotified(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "monitor");
    try
    {
      boolean bool = hasDeadline();
      l1 = timeoutNanos();
      l2 = 0L;
      if ((!bool) && (l1 == 0L))
      {
        paramObject.wait();
        return;
      }
      long l3 = System.nanoTime();
      if ((bool) && (l1 != 0L)) {
        l1 = Math.min(l1, deadlineNanoTime() - l3);
      } else if (bool) {
        l1 = deadlineNanoTime() - l3;
      }
      if (l1 <= 0L) {
        break label168;
      }
      l2 = l1 / 1000000L;
      Long.signum(l2);
      int i = (int)(l1 - 1000000L * l2);
      paramObject.wait(l2, i);
      l2 = System.nanoTime() - l3;
    }
    catch (InterruptedException paramObject)
    {
      long l1;
      long l2;
      do
      {
        break label145;
      } while (l2 >= l1);
    }
    throw ((Throwable)new InterruptedIOException("timeout"));
    label145:
    Thread.currentThread().interrupt();
    throw ((Throwable)new InterruptedIOException("interrupted"));
    label168:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Timeout
 * JD-Core Version:    0.7.0.1
 */