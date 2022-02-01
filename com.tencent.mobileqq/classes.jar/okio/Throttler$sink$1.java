package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Throttler$sink$1", "Lokio/ForwardingSink;", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class Throttler$sink$1
  extends ForwardingSink
{
  Throttler$sink$1(Sink paramSink1, Sink paramSink2)
  {
    super(localSink);
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    for (;;)
    {
      if (paramLong <= 0L) {
        break label56;
      }
      try
      {
        long l = this.this$0.take$okio(paramLong);
        super.write(paramBuffer, l);
        paramLong -= l;
      }
      catch (InterruptedException paramBuffer)
      {
        label37:
        break label37;
      }
    }
    Thread.currentThread().interrupt();
    throw ((Throwable)new InterruptedIOException("interrupted"));
    label56:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Throttler.sink.1
 * JD-Core Version:    0.7.0.1
 */