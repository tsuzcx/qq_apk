package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "seedInitialized", "", "next", "", "bits", "nextBoolean", "nextBytes", "", "bytes", "", "nextDouble", "", "nextFloat", "", "nextInt", "bound", "nextLong", "", "setSeed", "seed", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class KotlinRandom
  extends java.util.Random
{
  @NotNull
  private final Random impl;
  private boolean seedInitialized;
  
  public KotlinRandom(@NotNull Random paramRandom)
  {
    this.impl = paramRandom;
  }
  
  @NotNull
  public final Random getImpl()
  {
    return this.impl;
  }
  
  protected int next(int paramInt)
  {
    return this.impl.nextBits(paramInt);
  }
  
  public boolean nextBoolean()
  {
    return this.impl.nextBoolean();
  }
  
  public void nextBytes(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "bytes");
    this.impl.nextBytes(paramArrayOfByte);
  }
  
  public double nextDouble()
  {
    return this.impl.nextDouble();
  }
  
  public float nextFloat()
  {
    return this.impl.nextFloat();
  }
  
  public int nextInt()
  {
    return this.impl.nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return this.impl.nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return this.impl.nextLong();
  }
  
  public void setSeed(long paramLong)
  {
    if (!this.seedInitialized)
    {
      this.seedInitialized = true;
      return;
    }
    throw ((Throwable)new UnsupportedOperationException("Setting seed is not supported."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.random.KotlinRandom
 * JD-Core Version:    0.7.0.1
 */