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
    int i;
    int[] arrayOfInt;
    if ((paramArrayOfByte.length & 0x3) == 0)
    {
      i = paramArrayOfByte.length >>> 2;
      if (!paramBoolean) {
        break label85;
      }
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    for (;;)
    {
      int j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        int k = i >>> 2;
        arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
        i += 1;
      }
      i = (paramArrayOfByte.length >>> 2) + 1;
      break;
      label85:
      arrayOfInt = new int[i];
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[i1];
      int j = paramArrayOfInt1[0];
      j = 52 / (i1 + 1);
      int k = 0;
      j += 6;
      while (j > 0)
      {
        int m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = paramArrayOfInt1[(i + 1)];
          i3 = paramArrayOfInt1[i];
          k = ((k ^ arrayOfInt[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          paramArrayOfInt1[i] = k;
          i += 1;
        }
        n = paramArrayOfInt1[0];
        int i3 = paramArrayOfInt1[i1];
        i = ((arrayOfInt[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfInt1[i1] = i;
        j -= 1;
        k = m;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a();
    if (this.a != null) {
      try
      {
        byte[] arrayOfByte2 = a(paramArrayOfByte, a(this.a, arrayOfByte1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBSecurity
 * JD-Core Version:    0.7.0.1
 */