package com.tencent.tkd.comment.util.io;

public class MemoryUtil
{
  public static int pow(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    while (i < paramInt2)
    {
      j *= paramInt1;
      i += 1;
    }
    return j;
  }
  
  public static int roundUpToPowerOfTwo(int paramInt)
  {
    paramInt -= 1;
    paramInt |= paramInt >>> 1;
    paramInt |= paramInt >>> 2;
    paramInt |= paramInt >>> 4;
    paramInt |= paramInt >>> 8;
    return (paramInt | paramInt >>> 16) + 1;
  }
  
  public static int roundUpToPowerOfTwoLog(int paramInt)
  {
    int j = 1;
    int i = 0;
    while (j < paramInt)
    {
      j <<= 1;
      i += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.util.io.MemoryUtil
 * JD-Core Version:    0.7.0.1
 */