package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;

public class Base64
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
    Base64.b localb = new Base64.b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localb.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localb.b == localb.a.length) {
        return localb.a;
      }
      paramArrayOfByte = new byte[localb.b];
      System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Base64.c localc = new Base64.c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = localc.d;
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
    if (localc.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        k = (paramInt2 - 1) / 57;
        if (localc.f) {
          i = j;
        } else {
          i = 1;
        }
        i = paramInt3 + (k + 1) * i;
      }
    }
    localc.a = new byte[i];
    localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!a) && (localc.b != i)) {
      throw new AssertionError();
    }
    return localc.a;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.Base64
 * JD-Core Version:    0.7.0.1
 */