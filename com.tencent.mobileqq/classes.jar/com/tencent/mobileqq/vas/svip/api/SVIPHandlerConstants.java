package com.tencent.mobileqq.vas.svip.api;

public class SVIPHandlerConstants
{
  public static int a(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    long l = paramInt2;
    return paramInt1 | l << 32;
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants
 * JD-Core Version:    0.7.0.1
 */