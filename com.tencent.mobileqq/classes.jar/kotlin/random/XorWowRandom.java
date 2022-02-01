package kotlin.random;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class XorWowRandom
  extends Random
{
  private int addend;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public XorWowRandom(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0, paramInt1 ^ 0xFFFFFFFF, paramInt1 << 10 ^ paramInt2 >>> 4);
  }
  
  public XorWowRandom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.w = paramInt4;
    this.v = paramInt5;
    this.addend = paramInt6;
    paramInt1 = this.x;
    paramInt3 = this.y;
    paramInt4 = this.z;
    paramInt5 = this.w;
    paramInt6 = this.v;
    paramInt2 = 0;
    if ((paramInt1 | paramInt3 | paramInt4 | paramInt5 | paramInt6) != 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < 64)
      {
        nextInt();
        paramInt1 += 1;
      }
      return;
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    for (;;)
    {
      throw localThrowable;
    }
  }
  
  public int nextBits(int paramInt)
  {
    return RandomKt.takeUpperBits(nextInt(), paramInt);
  }
  
  public int nextInt()
  {
    int i = this.x;
    i ^= i >>> 2;
    this.x = this.y;
    this.y = this.z;
    this.z = this.w;
    int j = this.v;
    this.w = j;
    i = i ^ i << 1 ^ j ^ j << 4;
    this.v = i;
    this.addend += 362437;
    return i + this.addend;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.random.XorWowRandom
 * JD-Core Version:    0.7.0.1
 */