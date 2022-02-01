package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource
  implements Source
{
  private int bufferBytesHeldByInflater;
  private boolean closed;
  private final Inflater inflater;
  private final BufferedSource source;
  
  InflaterSource(BufferedSource paramBufferedSource, Inflater paramInflater)
  {
    if (paramBufferedSource != null)
    {
      if (paramInflater != null)
      {
        this.source = paramBufferedSource;
        this.inflater = paramInflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public InflaterSource(Source paramSource, Inflater paramInflater)
  {
    this(Okio.buffer(paramSource), paramInflater);
  }
  
  private void releaseInflatedBytes()
  {
    int i = this.bufferBytesHeldByInflater;
    if (i == 0) {
      return;
    }
    i -= this.inflater.getRemaining();
    this.bufferBytesHeldByInflater -= i;
    this.source.skip(i);
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.inflater.end();
    this.closed = true;
    this.source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong >= 0L) {
      if (!this.closed) {
        if (paramLong == 0L) {
          return 0L;
        }
      }
    }
    for (;;)
    {
      boolean bool = refill();
      label144:
      do
      {
        try
        {
          Segment localSegment = paramBuffer.writableSegment(1);
          int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
          i = this.inflater.inflate(localSegment.data, localSegment.limit, i);
          if (i > 0)
          {
            localSegment.limit += i;
            paramLong = paramBuffer.size;
            long l = i;
            paramBuffer.size = (paramLong + l);
            return l;
          }
          if (!this.inflater.finished())
          {
            if (!this.inflater.needsDictionary()) {
              continue;
            }
            break label144;
            throw new EOFException("source exhausted prematurely");
          }
          releaseInflatedBytes();
          if (localSegment.pos == localSegment.limit)
          {
            paramBuffer.head = localSegment.pop();
            SegmentPool.recycle(localSegment);
          }
          return -1L;
        }
        catch (DataFormatException paramBuffer)
        {
          throw new IOException(paramBuffer);
        }
        throw new IllegalStateException("closed");
        paramBuffer = new StringBuilder();
        paramBuffer.append("byteCount < 0: ");
        paramBuffer.append(paramLong);
        paramBuffer = new IllegalArgumentException(paramBuffer.toString());
        for (;;)
        {
          throw paramBuffer;
        }
      } while (bool);
    }
  }
  
  public final boolean refill()
  {
    if (!this.inflater.needsInput()) {
      return false;
    }
    releaseInflatedBytes();
    if (this.inflater.getRemaining() == 0)
    {
      if (this.source.exhausted()) {
        return true;
      }
      Segment localSegment = this.source.buffer().head;
      this.bufferBytesHeldByInflater = (localSegment.limit - localSegment.pos);
      this.inflater.setInput(localSegment.data, localSegment.pos, this.bufferBytesHeldByInflater);
      return false;
    }
    throw new IllegalStateException("?");
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.InflaterSource
 * JD-Core Version:    0.7.0.1
 */