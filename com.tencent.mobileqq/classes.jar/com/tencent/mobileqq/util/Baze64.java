package com.tencent.mobileqq.util;

import java.io.UnsupportedEncodingException;

public class Baze64
{
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Baze64.Decoder localDecoder = new Baze64.Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localDecoder.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localDecoder.b == localDecoder.a.length) {
        return localDecoder.a;
      }
      paramArrayOfByte = new byte[localDecoder.b];
      System.arraycopy(localDecoder.a, 0, paramArrayOfByte, 0, localDecoder.b);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(c(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Baze64.Encoder localEncoder = new Baze64.Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = localEncoder.d;
    int j = 2;
    int k;
    if (bool)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      k = paramInt2 % 3;
      paramInt3 = i;
      if (k != 0) {
        if (k != 1)
        {
          if (k != 2) {
            paramInt3 = i;
          } else {
            paramInt3 = i + 3;
          }
        }
        else {
          paramInt3 = i + 2;
        }
      }
    }
    i = paramInt3;
    if (localEncoder.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        k = (paramInt2 - 1) / 57;
        if (localEncoder.f) {
          i = j;
        } else {
          i = 1;
        }
        i = paramInt3 + (k + 1) * i;
      }
    }
    localEncoder.a = new byte[i];
    localEncoder.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!a) && (localEncoder.b != i)) {
      throw new AssertionError();
    }
    return localEncoder.a;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.Baze64
 * JD-Core Version:    0.7.0.1
 */