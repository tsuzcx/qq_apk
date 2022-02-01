package shark;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/ByteArraySourceProvider$openRandomAccessSource$1", "Lshark/RandomAccessSource;", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "position", "byteCount", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ByteArraySourceProvider$openRandomAccessSource$1
  implements RandomAccessSource
{
  private boolean b;
  
  public long a(@NotNull Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    if (!this.b)
    {
      paramLong2 = RangesKt.coerceAtMost(paramLong2, ByteArraySourceProvider.a(this.a).length - paramLong1);
      paramBuffer.write(ByteArraySourceProvider.a(this.a), (int)paramLong1, (int)paramLong2);
      return paramLong2;
    }
    throw ((Throwable)new IOException("Source closed"));
  }
  
  public void close()
  {
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ByteArraySourceProvider.openRandomAccessSource.1
 * JD-Core Version:    0.7.0.1
 */