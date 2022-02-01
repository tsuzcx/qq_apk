package shark;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ConstantMemoryMetricsDualSourceProvider;", "Lshark/DualSourceProvider;", "realSourceProvider", "(Lshark/DualSourceProvider;)V", "byteTravelRange", "", "getByteTravelRange", "()J", "lastRandomAccessPosition", "maxPosition", "minPosition", "<set-?>", "randomAccessByteReads", "getRandomAccessByteReads", "setRandomAccessByteReads$shark_hprof", "(J)V", "randomAccessByteTravel", "getRandomAccessByteTravel", "setRandomAccessByteTravel$shark_hprof", "randomAccessReadCount", "getRandomAccessReadCount", "setRandomAccessReadCount$shark_hprof", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "updateRandomAccessStatsOnRead", "", "position", "bytesRead", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ConstantMemoryMetricsDualSourceProvider
  implements DualSourceProvider
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  private final DualSourceProvider g;
  
  private final void a(long paramLong1, long paramLong2)
  {
    this.a += paramLong2;
    this.b += 1L;
    paramLong2 = this.d;
    if (paramLong2 != -1L)
    {
      this.c += Math.abs(paramLong1 - paramLong2);
      this.e = RangesKt.coerceAtMost(this.e, paramLong1);
      this.f = RangesKt.coerceAtLeast(this.f, paramLong1);
    }
    else
    {
      this.e = paramLong1;
      this.f = paramLong1;
    }
    this.d = paramLong1;
  }
  
  @NotNull
  public BufferedSource a()
  {
    return this.g.a();
  }
  
  @NotNull
  public RandomAccessSource b()
  {
    return (RandomAccessSource)new ConstantMemoryMetricsDualSourceProvider.openRandomAccessSource.1(this, this.g.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ConstantMemoryMetricsDualSourceProvider
 * JD-Core Version:    0.7.0.1
 */