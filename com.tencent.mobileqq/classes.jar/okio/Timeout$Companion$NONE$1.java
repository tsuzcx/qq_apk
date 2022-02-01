package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "deadlineNanoTime", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "okio"}, k=1, mv={1, 1, 16})
public final class Timeout$Companion$NONE$1
  extends Timeout
{
  @NotNull
  public Timeout deadlineNanoTime(long paramLong)
  {
    return (Timeout)this;
  }
  
  public void throwIfReached() {}
  
  @NotNull
  public Timeout timeout(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (Timeout)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Timeout.Companion.NONE.1
 * JD-Core Version:    0.7.0.1
 */