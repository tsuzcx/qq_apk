package com.tencent.mobileqq.troop.utils;

public class HummerParser
{
  public static long a(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 4)
    {
      l += ((paramArrayOfByte[i] & 0xFF) << (3 - i) * 8);
      i += 1;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HummerParser
 * JD-Core Version:    0.7.0.1
 */