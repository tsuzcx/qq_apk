package com.tencent.mobileqq.qfix.a;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class b
{
  public static final int a = 32;
  public static final int b = 8192;
  
  public static final boolean a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0) {
        return false;
      }
      i += j;
    }
    return true;
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 8192);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.a.b
 * JD-Core Version:    0.7.0.1
 */