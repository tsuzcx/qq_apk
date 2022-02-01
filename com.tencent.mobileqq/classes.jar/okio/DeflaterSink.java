package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;
  
  public DeflaterSink(@NotNull BufferedSink paramBufferedSink, @NotNull Deflater paramDeflater)
  {
    this.sink = paramBufferedSink;
    this.deflater = paramDeflater;
  }
  
  public DeflaterSink(@NotNull Sink paramSink, @NotNull Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private final void deflate(boolean paramBoolean)
  {
    Buffer localBuffer = this.sink.getBuffer();
    Segment localSegment;
    do
    {
      for (;;)
      {
        localSegment = localBuffer.writableSegment$okio(1);
        int i;
        if (paramBoolean) {
          i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit, 2);
        } else {
          i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit);
        }
        if (i <= 0) {
          break;
        }
        localSegment.limit += i;
        localBuffer.setSize$okio(localBuffer.size() + i);
        this.sink.emitCompleteSegments();
      }
    } while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      finishDeflate$okio();
    }
    catch (Throwable localThrowable2) {}
    Object localObject1;
    try
    {
      this.deflater.end();
      localObject1 = localThrowable2;
    }
    catch (Throwable localThrowable3)
    {
      localObject1 = localThrowable2;
      if (localThrowable2 == null) {
        localObject1 = localThrowable3;
      }
    }
    Object localObject2;
    try
    {
      this.sink.close();
      localObject2 = localObject1;
    }
    catch (Throwable localThrowable4)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localThrowable4;
      }
    }
    this.closed = true;
    if (localObject2 == null) {
      return;
    }
    throw localObject2;
  }
  
  public final void finishDeflate$okio()
  {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush()
  {
    deflate(true);
    this.sink.flush();
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeflaterSink(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      long l1 = paramBuffer.size();
      long l2 = i;
      paramBuffer.setSize$okio(l1 - l2);
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      paramLong -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.DeflaterSink
 * JD-Core Version:    0.7.0.1
 */