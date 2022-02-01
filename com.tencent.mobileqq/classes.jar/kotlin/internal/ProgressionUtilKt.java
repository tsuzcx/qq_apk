package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ProgressionUtilKt
{
  private static final int differenceModulo(int paramInt1, int paramInt2, int paramInt3)
  {
    return mod(mod(paramInt1, paramInt3) - mod(paramInt2, paramInt3), paramInt3);
  }
  
  private static final long differenceModulo(long paramLong1, long paramLong2, long paramLong3)
  {
    return mod(mod(paramLong1, paramLong3) - mod(paramLong2, paramLong3), paramLong3);
  }
  
  @PublishedApi
  public static final int getProgressionLastElement(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt1 >= paramInt2) {
        return paramInt2;
      }
      return paramInt2 - differenceModulo(paramInt2, paramInt1, paramInt3);
    }
    if (paramInt3 < 0)
    {
      if (paramInt1 <= paramInt2) {
        return paramInt2;
      }
      return paramInt2 + differenceModulo(paramInt1, paramInt2, -paramInt3);
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  @PublishedApi
  public static final long getProgressionLastElement(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 > 0L)
    {
      if (paramLong1 >= paramLong2) {
        return paramLong2;
      }
      return paramLong2 - differenceModulo(paramLong2, paramLong1, paramLong3);
    }
    if (paramLong3 < 0L)
    {
      if (paramLong1 <= paramLong2) {
        return paramLong2;
      }
      return paramLong2 + differenceModulo(paramLong1, paramLong2, -paramLong3);
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  private static final int mod(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  private static final long mod(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.internal.ProgressionUtilKt
 * JD-Core Version:    0.7.0.1
 */