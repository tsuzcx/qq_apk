package com.tencent.qapmsdk.socket.c;

import java.io.EOFException;

public class c
{
  private int a;
  
  private int b(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = this.a;
    if (j - i != 0)
    {
      int n = paramArrayOfByte[i];
      int m = 1;
      int k;
      if ((n & 0x80) == 0)
      {
        i = n & 0x7F;
        j = 1;
        k = 0;
      }
      else if ((n & 0xE0) == 192)
      {
        i = n & 0x1F;
        j = 2;
        k = 128;
      }
      else if ((n & 0xF0) == 224)
      {
        i = n & 0xF;
        j = 3;
        k = 2048;
      }
      else
      {
        if ((n & 0xF8) != 240) {
          break label331;
        }
        i = n & 0x7;
        j = 4;
        k = 65536;
      }
      if (paramArrayOfByte.length - this.a >= j)
      {
        while (m < j)
        {
          n = this.a;
          int i1 = paramArrayOfByte[(n + m)];
          if ((i1 & 0xC0) == 128)
          {
            i = i1 & 0x3F | i << 6;
            m += 1;
          }
          else
          {
            this.a = (n + m);
            return 65533;
          }
        }
        this.a += j;
        if (i > 1114111) {
          return 65533;
        }
        if ((i >= 55296) && (i <= 57343)) {
          return 65533;
        }
        if (i < k) {
          return 65533;
        }
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(j);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramArrayOfByte.length - this.a);
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(Integer.toHexString(n));
      localStringBuilder.append(")");
      throw new EOFException(localStringBuilder.toString());
      label331:
      this.a = (i + 1);
      return 65533;
    }
    paramArrayOfByte = new EOFException();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      int j = paramArrayOfByte.length;
      int i = 64;
      if (j < 64) {
        i = paramArrayOfByte.length;
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      i = 0;
      while ((i < 16) && (arrayOfByte.length - this.a != 0))
      {
        j = b(arrayOfByte);
        if (Character.isISOControl(j))
        {
          boolean bool = Character.isWhitespace(j);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (EOFException paramArrayOfByte) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c.c
 * JD-Core Version:    0.7.0.1
 */