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
    if (paramBufferedSink == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.sink = paramBufferedSink;
    this.deflater = paramDeflater;
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
    label119:
    do
    {
      localSegment = localBuffer.writableSegment(1);
      if (paramBoolean) {}
      for (int i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit, 2);; i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit))
      {
        if (i <= 0) {
          break label119;
        }
        localSegment.limit += i;
        localBuffer.size += i;
        this.sink.emitCompleteSegments();
        break;
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
    if (this.closed) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      try
      {
        finishDeflate();
        try
        {
          label14:
          this.deflater.end();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label34:
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        try
        {
          this.sink.close();
          localObject3 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject2;
          if (localObject2 != null) {
            break label34;
          }
          localObject3 = localThrowable3;
          break label34;
        }
        this.closed = true;
        if (localObject3 == null) {
          continue;
        }
        Util.sneakyRethrow(localObject3);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        break label14;
      }
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
    return "DeflaterSink(" + this.sink + ")";
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
      paramBuffer.size -= i;
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      paramLong -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okio.DeflaterSink
 * JD-Core Version:    0.7.0.1
 */