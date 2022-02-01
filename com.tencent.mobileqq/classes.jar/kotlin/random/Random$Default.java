package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Random$Default
  extends Random
{
  public int nextBits(int paramInt)
  {
    return Random.access$getDefaultRandom$cp().nextBits(paramInt);
  }
  
  public boolean nextBoolean()
  {
    return Random.access$getDefaultRandom$cp().nextBoolean();
  }
  
  @NotNull
  public byte[] nextBytes(int paramInt)
  {
    return Random.access$getDefaultRandom$cp().nextBytes(paramInt);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public double nextDouble()
  {
    return Random.access$getDefaultRandom$cp().nextDouble();
  }
  
  public double nextDouble(double paramDouble)
  {
    return Random.access$getDefaultRandom$cp().nextDouble(paramDouble);
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    return Random.access$getDefaultRandom$cp().nextDouble(paramDouble1, paramDouble2);
  }
  
  public float nextFloat()
  {
    return Random.access$getDefaultRandom$cp().nextFloat();
  }
  
  public int nextInt()
  {
    return Random.access$getDefaultRandom$cp().nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return Random.access$getDefaultRandom$cp().nextInt(paramInt);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    return Random.access$getDefaultRandom$cp().nextInt(paramInt1, paramInt2);
  }
  
  public long nextLong()
  {
    return Random.access$getDefaultRandom$cp().nextLong();
  }
  
  public long nextLong(long paramLong)
  {
    return Random.access$getDefaultRandom$cp().nextLong(paramLong);
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    return Random.access$getDefaultRandom$cp().nextLong(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.random.Random.Default
 * JD-Core Version:    0.7.0.1
 */