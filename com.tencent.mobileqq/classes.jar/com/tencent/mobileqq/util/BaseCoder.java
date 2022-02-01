package com.tencent.mobileqq.util;

public class BaseCoder
{
  public static BaseCoder a;
  private static char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static byte[] c = new byte[256];
  
  protected BaseCoder()
  {
    b();
  }
  
  public static BaseCoder a()
  {
    if (a == null) {
      try
      {
        a = new BaseCoder();
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    return a(paramString.getBytes()).toString();
  }
  
  public StringBuffer a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    char c1;
    for (;;)
    {
      int m = paramArrayOfByte.length;
      localObject = "ic";
      if (k >= m) {
        break;
      }
      i = i << 8 | paramArrayOfByte[k] & 0xFF;
      j += 8;
      while (j > 5)
      {
        localObject = b;
        j -= 6;
        c1 = localObject[(i >> j)];
        if (c1 == 'i') {
          localObject = "ia";
        } else if (c1 == '+') {
          localObject = "ib";
        } else if (c1 == '/') {
          localObject = "ic";
        } else {
          localObject = Character.valueOf(c1);
        }
        localStringBuffer.append(localObject);
        i &= (1 << j) - 1;
      }
      k += 1;
    }
    if (j > 0)
    {
      c1 = b[(i << 6 - j)];
      if (c1 == 'i') {
        paramArrayOfByte = "ia";
      } else if (c1 == '+') {
        paramArrayOfByte = "ib";
      } else if (c1 == '/') {
        paramArrayOfByte = (byte[])localObject;
      } else {
        paramArrayOfByte = Character.valueOf(c1);
      }
      localStringBuffer.append(paramArrayOfByte);
    }
    return localStringBuffer;
  }
  
  protected void b()
  {
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = b;
      if (i >= arrayOfChar.length) {
        break;
      }
      c[arrayOfChar[i]] = ((byte)i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.BaseCoder
 * JD-Core Version:    0.7.0.1
 */