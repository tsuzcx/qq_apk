package com.tencent.mobileqq.musicpendant;

public class Base64
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = new byte[''];
  
  static
  {
    int i = 0;
    while (i < 128)
    {
      b[i] = -1;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      b[i] = ((byte)(i - 65));
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      b[i] = ((byte)(i - 97 + 26));
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      b[i] = ((byte)(i - 48 + 52));
      i += 1;
    }
    b[43] = 62;
    b[47] = 63;
  }
  
  private static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (a((byte)paramString.charAt(i))) {
        localStringBuffer.append(paramString.charAt(i));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static boolean a(byte paramByte)
  {
    if (paramByte == 61) {}
    do
    {
      return true;
      if ((paramByte < 0) || (paramByte >= 128)) {
        return false;
      }
    } while (b[paramByte] != -1);
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String str = a(paramString);
    if (str.charAt(str.length() - 2) == '=') {
      paramString = new byte[(str.length() / 4 - 1) * 3 + 1];
    }
    for (;;)
    {
      j = 0;
      while (j < str.length() - 4)
      {
        k = b[str.charAt(j)];
        m = b[str.charAt(j + 1)];
        int n = b[str.charAt(j + 2)];
        int i1 = b[str.charAt(j + 3)];
        paramString[i] = ((byte)(k << 2 | m >> 4));
        paramString[(i + 1)] = ((byte)(m << 4 | n >> 2));
        paramString[(i + 2)] = ((byte)(n << 6 | i1));
        j += 4;
        i += 3;
      }
      if (str.charAt(str.length() - 1) == '=') {
        paramString = new byte[(str.length() / 4 - 1) * 3 + 2];
      } else {
        paramString = new byte[str.length() / 4 * 3];
      }
    }
    if (str.charAt(str.length() - 2) == '=')
    {
      i = b[str.charAt(str.length() - 4)];
      j = b[str.charAt(str.length() - 3)];
      paramString[(paramString.length - 1)] = ((byte)(i << 2 | j >> 4));
      return paramString;
    }
    if (str.charAt(str.length() - 1) == '=')
    {
      i = b[str.charAt(str.length() - 4)];
      j = b[str.charAt(str.length() - 3)];
      k = b[str.charAt(str.length() - 2)];
      paramString[(paramString.length - 2)] = ((byte)(i << 2 | j >> 4));
      paramString[(paramString.length - 1)] = ((byte)(j << 4 | k >> 2));
      return paramString;
    }
    i = b[str.charAt(str.length() - 4)];
    int j = b[str.charAt(str.length() - 3)];
    int k = b[str.charAt(str.length() - 2)];
    int m = b[str.charAt(str.length() - 1)];
    paramString[(paramString.length - 3)] = ((byte)(i << 2 | j >> 4));
    paramString[(paramString.length - 2)] = ((byte)(j << 4 | k >> 2));
    paramString[(paramString.length - 1)] = ((byte)(k << 6 | m));
    return paramString;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte = b(paramArrayOfByte);
    if (arrayOfByte[(arrayOfByte.length - 2)] == 61) {
      paramArrayOfByte = new byte[(arrayOfByte.length / 4 - 1) * 3 + 1];
    }
    for (;;)
    {
      j = 0;
      while (j < arrayOfByte.length - 4)
      {
        k = b[arrayOfByte[j]];
        m = b[arrayOfByte[(j + 1)]];
        int n = b[arrayOfByte[(j + 2)]];
        int i1 = b[arrayOfByte[(j + 3)]];
        paramArrayOfByte[i] = ((byte)(k << 2 | m >> 4));
        paramArrayOfByte[(i + 1)] = ((byte)(m << 4 | n >> 2));
        paramArrayOfByte[(i + 2)] = ((byte)(n << 6 | i1));
        j += 4;
        i += 3;
      }
      if (arrayOfByte[(arrayOfByte.length - 1)] == 61) {
        paramArrayOfByte = new byte[(arrayOfByte.length / 4 - 1) * 3 + 2];
      } else {
        paramArrayOfByte = new byte[arrayOfByte.length / 4 * 3];
      }
    }
    if (arrayOfByte[(arrayOfByte.length - 2)] == 61)
    {
      i = b[arrayOfByte[(arrayOfByte.length - 4)]];
      j = b[arrayOfByte[(arrayOfByte.length - 3)]];
      paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)(i << 2 | j >> 4));
      return paramArrayOfByte;
    }
    if (arrayOfByte[(arrayOfByte.length - 1)] == 61)
    {
      i = b[arrayOfByte[(arrayOfByte.length - 4)]];
      j = b[arrayOfByte[(arrayOfByte.length - 3)]];
      k = b[arrayOfByte[(arrayOfByte.length - 2)]];
      paramArrayOfByte[(paramArrayOfByte.length - 2)] = ((byte)(i << 2 | j >> 4));
      paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)(j << 4 | k >> 2));
      return paramArrayOfByte;
    }
    i = b[arrayOfByte[(arrayOfByte.length - 4)]];
    int j = b[arrayOfByte[(arrayOfByte.length - 3)]];
    int k = b[arrayOfByte[(arrayOfByte.length - 2)]];
    int m = b[arrayOfByte[(arrayOfByte.length - 1)]];
    paramArrayOfByte[(paramArrayOfByte.length - 3)] = ((byte)(i << 2 | j >> 4));
    paramArrayOfByte[(paramArrayOfByte.length - 2)] = ((byte)(j << 4 | k >> 2));
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)(k << 6 | m));
    return paramArrayOfByte;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfByte.length; j = k)
    {
      k = j;
      if (a(paramArrayOfByte[i]))
      {
        arrayOfByte[j] = paramArrayOfByte[i];
        k = j + 1;
      }
      i += 1;
    }
    paramArrayOfByte = new byte[j];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, j);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.musicpendant.Base64
 * JD-Core Version:    0.7.0.1
 */