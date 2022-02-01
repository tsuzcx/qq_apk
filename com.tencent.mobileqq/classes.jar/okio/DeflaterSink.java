package okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;
  
  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    if (paramBufferedSink != null)
    {
      if (paramDeflater != null)
      {
        this.sink = paramBufferedSink;
        this.deflater = paramDeflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void deflate(boolean paramBoolean)
  {
    Buffer localBuffer = this.sink.buffer();
    Segment localSegment;
    do
    {
      for (;;)
      {
        localSegment = localBuffer.writableSegment(1);
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
        localBuffer.size += i;
        this.sink.emitCompleteSegments();
      }
    } while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    Object localObject2 = null;
    try
    {
      finishDeflate();
    }
    catch (Throwable localThrowable1) {}
    Object localObject1;
    try
    {
      this.deflater.end();
      localObject1 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = localThrowable1;
      if (localThrowable1 == null) {
        localObject1 = localThrowable2;
      }
    }
    Object localObject3;
    try
    {
      this.sink.close();
      localObject3 = localObject1;
    }
    catch (Throwable localThrowable3)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = localThrowable3;
      }
    }
    this.closed = true;
    if (localObject3 != null) {
      Util.sneakyRethrow(localObject3);
    }
  }
  
  void finishDeflate()
  {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush()
  {
    deflate(true);
    this.sink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeflaterSink(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      long l1 = paramBuffer.size;
      long l2 = i;
      paramBuffer.size = (l1 - l2);
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      paramLong -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.DeflaterSink
 * JD-Core Version:    0.7.0.1
 */