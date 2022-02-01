package shark;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/RandomAccessSource$asStreamingSource$1", "Lokio/Source;", "position", "", "getPosition", "()J", "setPosition", "(J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "kotlin.jvm.PlatformType", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class RandomAccessSource$asStreamingSource$1
  implements Source
{
  private long b;
  
  public void close()
  {
    this.b = -1L;
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    long l = this.b;
    if (l != -1L)
    {
      paramLong = this.a.a(paramBuffer, l, paramLong);
      if (paramLong == 0L) {
        return -1L;
      }
      this.b += paramLong;
      return paramLong;
    }
    throw ((Throwable)new IOException("Source closed"));
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.RandomAccessSource.asStreamingSource.1
 * JD-Core Version:    0.7.0.1
 */