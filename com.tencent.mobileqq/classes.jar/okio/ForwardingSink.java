package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "(Lokio/Sink;)V", "()Lokio/Sink;", "close", "", "-deprecated_delegate", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public abstract class ForwardingSink
  implements Sink
{
  @NotNull
  private final Sink delegate;
  
  public ForwardingSink(@NotNull Sink paramSink)
  {
    this.delegate = paramSink;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="delegate", imports={}))
  @JvmName(name="-deprecated_delegate")
  @NotNull
  public final Sink -deprecated_delegate()
  {
    return this.delegate;
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  @JvmName(name="delegate")
  @NotNull
  public final Sink delegate()
  {
    return this.delegate;
  }
  
  public void flush()
  {
    this.delegate.flush();
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('(');
    localStringBuilder.append(this.delegate);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.ForwardingSink
 * JD-Core Version:    0.7.0.1
 */