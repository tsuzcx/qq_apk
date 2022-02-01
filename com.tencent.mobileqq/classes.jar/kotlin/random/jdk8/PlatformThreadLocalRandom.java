package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/jdk8/PlatformThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextDouble", "", "until", "nextInt", "", "from", "nextLong", "", "kotlin-stdlib-jdk8"}, k=1, mv={1, 1, 16})
public final class PlatformThreadLocalRandom
  extends AbstractPlatformRandom
{
  @NotNull
  public Random getImpl()
  {
    ThreadLocalRandom localThreadLocalRandom = ThreadLocalRandom.current();
    Intrinsics.checkExpressionValueIsNotNull(localThreadLocalRandom, "ThreadLocalRandom.current()");
    return (Random)localThreadLocalRandom;
  }
  
  public double nextDouble(double paramDouble)
  {
    return ThreadLocalRandom.current().nextDouble(paramDouble);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    return ThreadLocalRandom.current().nextInt(paramInt1, paramInt2);
  }
  
  public long nextLong(long paramLong)
  {
    return ThreadLocalRandom.current().nextLong(paramLong);
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    return ThreadLocalRandom.current().nextLong(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.random.jdk8.PlatformThreadLocalRandom
 * JD-Core Version:    0.7.0.1
 */