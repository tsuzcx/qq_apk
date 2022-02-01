package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "okio"}, k=1, mv={1, 1, 16})
public class ForwardingTimeout
  extends Timeout
{
  @NotNull
  private Timeout delegate;
  
  public ForwardingTimeout(@NotNull Timeout paramTimeout)
  {
    this.delegate = paramTimeout;
  }
  
  @NotNull
  public Timeout clearDeadline()
  {
    return this.delegate.clearDeadline();
  }
  
  @NotNull
  public Timeout clearTimeout()
  {
    return this.delegate.clearTimeout();
  }
  
  public long deadlineNanoTime()
  {
    return this.delegate.deadlineNanoTime();
  }
  
  @NotNull
  public Timeout deadlineNanoTime(long paramLong)
  {
    return this.delegate.deadlineNanoTime(paramLong);
  }
  
  @JvmName(name="delegate")
  @NotNull
  public final Timeout delegate()
  {
    return this.delegate;
  }
  
  public boolean hasDeadline()
  {
    return this.delegate.hasDeadline();
  }
  
  @NotNull
  public final ForwardingTimeout setDelegate(@NotNull Timeout paramTimeout)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeout, "delegate");
    this.delegate = paramTimeout;
    return this;
  }
  
  public void throwIfReached()
  {
    this.delegate.throwIfReached();
  }
  
  @NotNull
  public Timeout timeout(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return this.delegate.timeout(paramLong, paramTimeUnit);
  }
  
  public long timeoutNanos()
  {
    return this.delegate.timeoutNanos();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.ForwardingTimeout
 * JD-Core Version:    0.7.0.1
 */