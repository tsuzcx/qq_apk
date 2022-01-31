package com.tencent.upload.e;

import java.io.PrintStream;

public class c
{
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    System.out.println(paramString);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      paramString = str;
      if (str.length() == 1) {
        paramString = '0' + str;
      }
      System.out.print(paramString.toUpperCase() + " ");
      i += 1;
    }
    System.out.println("");
  }
  
  public static byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length + 25];
    try
    {
      byte[] arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 4;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 1);
      d locald = new d(paramInt1, paramInt2, paramArrayOfByte.length + 25);
      System.arraycopy(locald.a(), 0, arrayOfByte1, 1, locald.a().length);
      paramInt1 = locald.a().length + 1;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, paramInt1, paramArrayOfByte.length);
      paramInt2 = paramArrayOfByte.length;
      arrayOfByte2[0] = 5;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt1 + paramInt2, 1);
      return arrayOfByte1;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return arrayOfByte1;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = null;
    if (!d(paramArrayOfByte)) {
      return null;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      byte[] arrayOfByte3 = new byte[d.a];
      arrayOfByte1 = arrayOfByte2;
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte3, 0, d.a);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = new byte[d.a(arrayOfByte3).i - 25];
      arrayOfByte1 = arrayOfByte2;
      System.arraycopy(paramArrayOfByte, d.a + 1, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return arrayOfByte1;
  }
  
  public static d b(byte[] paramArrayOfByte)
  {
    if (!d(paramArrayOfByte)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[d.a];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, d.a);
      paramArrayOfByte = d.a(arrayOfByte);
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 1);
    if (e(arrayOfByte) != 4)
    {
      System.out.println("0x04 error !!!");
      return -1;
    }
    try
    {
      arrayOfByte = new byte[d.a];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, d.a);
      paramArrayOfByte = d.a(arrayOfByte);
      return paramArrayOfByte.i;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public static boolean d(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 1);
    if (e(arrayOfByte) != 4)
    {
      System.out.println("decode error !");
      return false;
    }
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 1, arrayOfByte, 0, 1);
    if (e(arrayOfByte) != 5)
    {
      System.out.println("decode error !");
      return false;
    }
    return true;
  }
  
  public static int e(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while ((i < paramArrayOfByte.length) && (i < 4))
    {
      j += (paramArrayOfByte[i] << i * 8);
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.c
 * JD-Core Version:    0.7.0.1
 */