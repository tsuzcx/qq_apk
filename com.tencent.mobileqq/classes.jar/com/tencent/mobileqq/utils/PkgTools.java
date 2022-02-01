package com.tencent.mobileqq.utils;

public class PkgTools
{
  public static void DWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    copyData(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PkgTools
 * JD-Core Version:    0.7.0.1
 */