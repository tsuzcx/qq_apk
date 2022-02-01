package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, k=1, mv={1, 1, 16})
public abstract class ForwardingSource
  implements Source
{
  @NotNull
  private final Source delegate;
  
  public ForwardingSource(@NotNull Source paramSource)
  {
    this.delegate = paramSource;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="delegate", imports={}))
  @JvmName(name="-deprecated_delegate")
  @NotNull
  public final Source -deprecated_delegate()
  {
    return this.delegate;
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  @JvmName(name="delegate")
  @NotNull
  public final Source delegate()
  {
    return this.delegate;
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    return this.delegate.read(paramBuffer, paramLong);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.ForwardingSource
 * JD-Core Version:    0.7.0.1
 */