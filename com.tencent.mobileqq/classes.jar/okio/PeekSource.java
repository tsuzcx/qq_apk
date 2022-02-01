package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public final class PeekSource
  implements Source
{
  private final Buffer buffer;
  private boolean closed;
  private int expectedPos;
  private Segment expectedSegment;
  private long pos;
  private final BufferedSource upstream;
  
  public PeekSource(@NotNull BufferedSource paramBufferedSource)
  {
    this.upstream = paramBufferedSource;
    this.buffer = this.upstream.getBuffer();
    this.expectedSegment = this.buffer.head;
    paramBufferedSource = this.buffer.head;
    int i;
    if (paramBufferedSource != null) {
      i = paramBufferedSource.pos;
    } else {
      i = -1;
    }
    this.expectedPos = i;
  }
  
  public void close()
  {
    this.closed = true;
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int j = 0;
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((this.closed ^ true))
      {
        Segment localSegment = this.expectedSegment;
        if (localSegment != null)
        {
          i = j;
          if (localSegment == this.buffer.head)
          {
            int k = this.expectedPos;
            localSegment = this.buffer.head;
            if (localSegment == null) {
              Intrinsics.throwNpe();
            }
            i = j;
            if (k != localSegment.pos) {}
          }
        }
        else
        {
          i = 1;
        }
        if (i != 0)
        {
          if (paramLong == 0L) {
            return 0L;
          }
          if (!this.upstream.request(this.pos + 1L)) {
            return -1L;
          }
          if ((this.expectedSegment == null) && (this.buffer.head != null))
          {
            this.expectedSegment = this.buffer.head;
            localSegment = this.buffer.head;
            if (localSegment == null) {
              Intrinsics.throwNpe();
            }
            this.expectedPos = localSegment.pos;
          }
          paramLong = Math.min(paramLong, this.buffer.size() - this.pos);
          this.buffer.copyTo(paramBuffer, this.pos, paramLong);
          this.pos += paramLong;
          return paramLong;
        }
        throw ((Throwable)new IllegalStateException("Peek source is invalid because upstream source was used".toString()));
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.upstream.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.PeekSource
 * JD-Core Version:    0.7.0.1
 */