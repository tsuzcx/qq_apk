package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
final class OutputStreamSink
  implements Sink
{
  private final OutputStream out;
  private final Timeout timeout;
  
  public OutputStreamSink(@NotNull OutputStream paramOutputStream, @NotNull Timeout paramTimeout)
  {
    this.out = paramOutputStream;
    this.timeout = paramTimeout;
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void flush()
  {
    this.out.flush();
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sink(");
    localStringBuilder.append(this.out);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    while (paramLong > 0L)
    {
      this.timeout.throwIfReached();
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.out.write(localSegment.data, localSegment.pos, i);
      localSegment.pos += i;
      long l2 = i;
      long l1 = paramLong - l2;
      paramBuffer.setSize$okio(paramBuffer.size() - l2);
      paramLong = l1;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        paramLong = l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.OutputStreamSink
 * JD-Core Version:    0.7.0.1
 */