package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class AbstractPlatformRandom
  extends Random
{
  @NotNull
  public abstract java.util.Random getImpl();
  
  public int nextBits(int paramInt)
  {
    return RandomKt.takeUpperBits(getImpl().nextInt(), paramInt);
  }
  
  public boolean nextBoolean()
  {
    return getImpl().nextBoolean();
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    getImpl().nextBytes(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public double nextDouble()
  {
    return getImpl().nextDouble();
  }
  
  public float nextFloat()
  {
    return getImpl().nextFloat();
  }
  
  public int nextInt()
  {
    return getImpl().nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return getImpl().nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return getImpl().nextLong();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.random.AbstractPlatformRandom
 * JD-Core Version:    0.7.0.1
 */