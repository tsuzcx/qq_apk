package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/ConstantMemoryMetricsDualSourceProvider$openRandomAccessSource$1", "Lshark/RandomAccessSource;", "close", "", "read", "", "sink", "Lokio/Buffer;", "position", "byteCount", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ConstantMemoryMetricsDualSourceProvider$openRandomAccessSource$1
  implements RandomAccessSource
{
  ConstantMemoryMetricsDualSourceProvider$openRandomAccessSource$1(RandomAccessSource paramRandomAccessSource) {}
  
  public long a(@NotNull Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    paramLong2 = this.b.a(paramBuffer, paramLong1, paramLong2);
    ConstantMemoryMetricsDualSourceProvider.a(this.a, paramLong1, paramLong2);
    return paramLong2;
  }
  
  public void close()
  {
    this.b.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ConstantMemoryMetricsDualSourceProvider.openRandomAccessSource.1
 * JD-Core Version:    0.7.0.1
 */