package com.tencent.mobileqq.triton.font;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
{
  private static int DEFAULT_BUFFER = 4096;
  private static int EOF = -1;
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return copyLarge(paramInputStream, paramOutputStream, new byte[DEFAULT_BUFFER]);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    int j;
    for (long l = 0L;; l += j)
    {
      int i = EOF;
      j = paramInputStream.read(paramArrayOfByte);
      if (i == j) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, j);
    }
    return l;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.IOUtils
 * JD-Core Version:    0.7.0.1
 */