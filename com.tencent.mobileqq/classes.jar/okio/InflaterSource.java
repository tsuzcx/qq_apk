package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public final class InflaterSource
  implements Source
{
  private int bufferBytesHeldByInflater;
  private boolean closed;
  private final Inflater inflater;
  private final BufferedSource source;
  
  public InflaterSource(@NotNull BufferedSource paramBufferedSource, @NotNull Inflater paramInflater)
  {
    this.source = paramBufferedSource;
    this.inflater = paramInflater;
  }
  
  public InflaterSource(@NotNull Source paramSource, @NotNull Inflater paramInflater)
  {
    this(Okio.buffer(paramSource), paramInflater);
  }
  
  private final void releaseInflatedBytes()
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
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      if ((this.closed ^ true)) {
        if (paramLong == 0L) {
          return 0L;
        }
      }
    }
    for (;;)
    {
      boolean bool = refill();
      label169:
      do
      {
        try
        {
          Segment localSegment = paramBuffer.writableSegment$okio(1);
          i = (int)Math.min(paramLong, 8192 - localSegment.limit);
          i = this.inflater.inflate(localSegment.data, localSegment.limit, i);
          if (i > 0)
          {
            localSegment.limit += i;
            paramLong = paramBuffer.size();
            long l = i;
            paramBuffer.setSize$okio(paramLong + l);
            return l;
          }
          if (!this.inflater.finished())
          {
            if (!this.inflater.needsDictionary()) {
              continue;
            }
            break label169;
            throw ((Throwable)new EOFException("source exhausted prematurely"));
          }
          releaseInflatedBytes();
          if (localSegment.pos == localSegment.limit)
          {
            paramBuffer.head = localSegment.pop();
            SegmentPool.INSTANCE.recycle(localSegment);
          }
          return -1L;
        }
        catch (DataFormatException paramBuffer)
        {
          throw ((Throwable)new IOException((Throwable)paramBuffer));
        }
        throw ((Throwable)new IllegalStateException("closed".toString()));
        paramBuffer = new StringBuilder();
        paramBuffer.append("byteCount < 0: ");
        paramBuffer.append(paramLong);
        paramBuffer = (Throwable)new IllegalArgumentException(paramBuffer.toString().toString());
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
    int i;
    if (this.inflater.getRemaining() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.source.exhausted()) {
        return true;
      }
      Segment localSegment = this.source.getBuffer().head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      this.bufferBytesHeldByInflater = (localSegment.limit - localSegment.pos);
      this.inflater.setInput(localSegment.data, localSegment.pos, this.bufferBytesHeldByInflater);
      return false;
    }
    throw ((Throwable)new IllegalStateException("?".toString()));
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.InflaterSource
 * JD-Core Version:    0.7.0.1
 */