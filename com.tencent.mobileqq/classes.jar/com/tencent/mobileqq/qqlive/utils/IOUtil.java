package com.tencent.mobileqq.qqlive.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class IOUtil
{
  public static int a(InputStream paramInputStream, boolean paramBoolean)
  {
    return (int)a(paramInputStream, 2, paramBoolean);
  }
  
  public static long a(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(paramInt);
      }
      int j = 0;
      int i = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (i <= 0) {
        return -1L;
      }
      if (paramBoolean) {
        paramInt = j;
      } else {
        paramInt = i - 1;
      }
      j = -1;
      if (!paramBoolean) {
        i = -1;
      }
      if (paramBoolean) {
        j = 1;
      }
      long l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | arrayOfByte[paramInt] & 0xFF;
        paramInt += j;
      }
      return l;
    }
    paramInputStream = new IllegalArgumentException("length must between 1 and 8.");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt) {
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j > 0) {
          i += j;
        }
      }
      finally {}
    }
    return arrayOfByte;
  }
  
  public static byte[] b(InputStream paramInputStream, boolean paramBoolean)
  {
    int i = a(paramInputStream, paramBoolean);
    if (i <= 0) {
      return null;
    }
    return a(paramInputStream, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.IOUtil
 * JD-Core Version:    0.7.0.1
 */