package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k=1, mv={1, 1, 16})
final class InputStreamSource
  implements Source
{
  private final InputStream input;
  private final Timeout timeout;
  
  public InputStreamSource(@NotNull InputStream paramInputStream, @NotNull Timeout paramTimeout)
  {
    this.input = paramInputStream;
    this.timeout = paramTimeout;
  }
  
  public void close()
  {
    this.input.close();
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    if (paramLong == 0L) {
      return 0L;
    }
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      try
      {
        this.timeout.throwIfReached();
        Segment localSegment = paramBuffer.writableSegment$okio(1);
        i = (int)Math.min(paramLong, 8192 - localSegment.limit);
        i = this.input.read(localSegment.data, localSegment.limit, i);
        if (i == -1)
        {
          if (localSegment.pos != localSegment.limit) {
            break label226;
          }
          paramBuffer.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
          break label226;
        }
        localSegment.limit += i;
        paramLong = paramBuffer.size();
        long l = i;
        paramBuffer.setSize$okio(paramLong + l);
        return l;
      }
      catch (AssertionError paramBuffer)
      {
        if (Okio.isAndroidGetsocknameError(paramBuffer)) {
          throw ((Throwable)new IOException((Throwable)paramBuffer));
        }
        throw ((Throwable)paramBuffer);
      }
    }
    else
    {
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
    label226:
    return -1L;
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
    localStringBuilder.append("source(");
    localStringBuilder.append(this.input);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.InputStreamSource
 * JD-Core Version:    0.7.0.1
 */