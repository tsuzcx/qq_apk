package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Throttler$source$1", "Lokio/ForwardingSource;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, k=1, mv={1, 1, 16})
public final class Throttler$source$1
  extends ForwardingSource
{
  Throttler$source$1(Source paramSource1, Source paramSource2)
  {
    super(localSource);
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    try
    {
      paramLong = super.read(paramBuffer, this.this$0.take$okio(paramLong));
      return paramLong;
    }
    catch (InterruptedException paramBuffer)
    {
      label22:
      break label22;
    }
    Thread.currentThread().interrupt();
    throw ((Throwable)new InterruptedIOException("interrupted"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Throttler.source.1
 * JD-Core Version:    0.7.0.1
 */