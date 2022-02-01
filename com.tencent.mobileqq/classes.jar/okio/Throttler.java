package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, k=1, mv={1, 1, 16})
public final class Throttler
{
  private long allocatedUntil;
  private long bytesPerSecond;
  private long maxByteCount;
  private long waitByteCount;
  
  public Throttler()
  {
    this(System.nanoTime());
  }
  
  public Throttler(long paramLong)
  {
    this.allocatedUntil = paramLong;
    this.waitByteCount = 8192L;
    this.maxByteCount = 262144L;
  }
  
  private final long bytesToNanos(long paramLong)
  {
    return paramLong * 1000000000L / this.bytesPerSecond;
  }
  
  private final long nanosToBytes(long paramLong)
  {
    return paramLong * this.bytesPerSecond / 1000000000L;
  }
  
  private final void waitNanos(long paramLong)
  {
    long l = paramLong / 1000000L;
    ((Object)this).wait(l, (int)(paramLong - 1000000L * l));
  }
  
  public final long byteCountOrWaitNanos$okio(long paramLong1, long paramLong2)
  {
    if (this.bytesPerSecond == 0L) {
      return paramLong2;
    }
    long l1 = Math.max(this.allocatedUntil - paramLong1, 0L);
    long l2 = this.maxByteCount - nanosToBytes(l1);
    if (l2 >= paramLong2)
    {
      this.allocatedUntil = (paramLong1 + l1 + bytesToNanos(paramLong2));
      return paramLong2;
    }
    long l3 = this.waitByteCount;
    if (l2 >= l3)
    {
      this.allocatedUntil = (paramLong1 + bytesToNanos(this.maxByteCount));
      return l2;
    }
    paramLong2 = Math.min(l3, paramLong2);
    l1 += bytesToNanos(paramLong2 - this.maxByteCount);
    if (l1 == 0L)
    {
      this.allocatedUntil = (paramLong1 + bytesToNanos(this.maxByteCount));
      return paramLong2;
    }
    return -l1;
  }
  
  @JvmOverloads
  public final void bytesPerSecond(long paramLong)
  {
    bytesPerSecond$default(this, paramLong, 0L, 0L, 6, null);
  }
  
  @JvmOverloads
  public final void bytesPerSecond(long paramLong1, long paramLong2)
  {
    bytesPerSecond$default(this, paramLong1, paramLong2, 0L, 4, null);
  }
  
  @JvmOverloads
  public final void bytesPerSecond(long paramLong1, long paramLong2, long paramLong3)
  {
    int j = 1;
    int i;
    if (paramLong1 >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong2 > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramLong3 >= paramLong2) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0) {}
      }
    }
    try
    {
      this.bytesPerSecond = paramLong1;
      this.waitByteCount = paramLong2;
      this.maxByteCount = paramLong3;
      ((Object)this).notifyAll();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  @NotNull
  public final Sink sink(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return (Sink)new Throttler.sink.1(this, paramSink, paramSink);
  }
  
  @NotNull
  public final Source source(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return (Source)new Throttler.source.1(this, paramSource, paramSource);
  }
  
  public final long take$okio(long paramLong)
  {
    int i;
    if (paramLong > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      try
      {
        for (;;)
        {
          long l = byteCountOrWaitNanos$okio(System.nanoTime(), paramLong);
          if (l >= 0L) {
            return l;
          }
          l = -l;
          waitNanos(l);
        }
        localThrowable = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      }
      finally {}
    }
    Throwable localThrowable;
    for (;;)
    {
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Throttler
 * JD-Core Version:    0.7.0.1
 */