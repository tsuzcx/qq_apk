package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/BlackholeSink;", "Lokio/Sink;", "()V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
final class BlackholeSink
  implements Sink
{
  public void close() {}
  
  public void flush() {}
  
  @NotNull
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    paramBuffer.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.BlackholeSink
 * JD-Core Version:    0.7.0.1
 */