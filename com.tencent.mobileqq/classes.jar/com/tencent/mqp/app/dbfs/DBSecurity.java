package com.tencent.mqp.app.dbfs;

import java.security.SecureRandom;

public class DBSecurity
{
  private byte[] a;
  
  private static byte[] a()
  {
    return new SecureRandom().generateSeed(8);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(a(a(paramArrayOfByte1, true), a(paramArrayOfByte2, false)), false);
  }
  
  private static byte[] a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt.length << 2;
    int i;
    if (paramBoolean)
    {
      int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
      i = k;
      if (k > j) {
        return null;
      }
    }
    else
    {
      i = j;
    }
    byte[] arrayOfByte = new byte[i];
    j = 0;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramArrayOfInt[(j >>> 2)] >>> ((j & 0x3) << 3) & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte.length & 0x3) == 0) {
      i = paramArrayOfByte.length >>> 2;
    } else {
      i = (paramArrayOfByte.length >>> 2) + 1;
    }
    int[] arrayOfInt;
    if (paramBoolean)
    {
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    else
    {
      arrayOfInt = new int[i];
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = i >>> 2;
      arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 < 1) {
      return paramArrayOfInt1;
    }
    int[] arrayOfInt = paramArrayOfInt2;
    if (paramArrayOfInt2.length < 4)
    {
      arrayOfInt = new int[4];
      System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
    }
    int i = paramArrayOfInt1[i1];
    int j = paramArrayOfInt1[0];
    j = 52 / (i1 + 1) + 6;
    int m;
    for (int k = 0; j > 0; k = m)
    {
      m = k - 1640531527;
      int i2 = m >>> 2 & 0x3;
      int n = 0;
      k = i;
      for (i = n; i < i1; i = n)
      {
        n = i + 1;
        int i3 = paramArrayOfInt1[n];
        int i4 = paramArrayOfInt1[i];
        k = ((k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4) ^ (i3 ^ m) + (k ^ arrayOfInt[(i & 0x3 ^ i2)])) + i4;
        paramArrayOfInt1[i] = k;
      }
      n = paramArrayOfInt1[0];
      i = paramArrayOfInt1[i1] + ((k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4) ^ (n ^ m) + (arrayOfInt[(i2 ^ i & 0x3)] ^ k));
      paramArrayOfInt1[i1] = i;
      j -= 1;
    }
    return paramArrayOfInt1;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a();
    byte[] arrayOfByte2 = this.a;
    if (arrayOfByte2 != null) {
      try
      {
        arrayOfByte2 = a(paramArrayOfByte, a(arrayOfByte2, arrayOfByte1));
        byte[] arrayOfByte4 = new byte[arrayOfByte2.length + 8];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, arrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte4, arrayOfByte2.length, 8);
        return arrayOfByte4;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    byte[] arrayOfByte3 = new byte[paramArrayOfByte.length + 8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, paramArrayOfByte.length, 8);
    return arrayOfByte3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBSecurity
 * JD-Core Version:    0.7.0.1
 */