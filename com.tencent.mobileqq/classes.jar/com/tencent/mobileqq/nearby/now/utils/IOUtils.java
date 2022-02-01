package com.tencent.mobileqq.nearby.now.utils;

import java.io.InputStream;

public class IOUtils
{
  public static byte[] a(InputStream paramInputStream, int paramInt)
  {
    Object localObject;
    if (paramInt <= 0) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      int i = 0;
      byte[] arrayOfByte = new byte[paramInt];
      localObject = arrayOfByte;
      if (i >= paramInt) {
        continue;
      }
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        localObject = arrayOfByte;
        if (j <= 0) {
          continue;
        }
        i += j;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */