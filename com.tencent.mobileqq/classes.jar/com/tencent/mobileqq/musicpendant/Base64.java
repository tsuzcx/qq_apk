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
    byte[] arrayOfByte = b;
    arrayOfByte[43] = 62;
    arrayOfByte[47] = 63;
  }
  
  public static String a(String paramString)
  {
    String str = null;
    if (paramString != null) {}
    try
    {
      str = new String(a(paramString.getBytes("UTF-8")), "UTF-8");
      return str;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static boolean a(byte paramByte)
  {
    if (paramByte == 61) {
      return true;
    }
    if (paramByte >= 0)
    {
      if (paramByte >= 128) {
        return false;
      }
      return b[paramByte] != -1;
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = b(paramString);
    if (str.charAt(str.length() - 2) == '=') {
      paramString = new byte[(str.length() / 4 - 1) * 3 + 1];
    } else if (str.charAt(str.length() - 1) == '=') {
      paramString = new byte[(str.length() / 4 - 1) * 3 + 2];
    } else {
      paramString = new byte[str.length() / 4 * 3];
    }
    int j = 0;
    int i = 0;
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
    if (str.charAt(str.length() - 2) == '=')
    {
      i = b[str.charAt(str.length() - 4)];
      j = b[str.charAt(str.length() - 3)];
      paramString[(paramString.length - 1)] = ((byte)(j >> 4 | i << 2));
      return paramString;
    }
    if (str.charAt(str.length() - 1) == '=')
    {
      i = b[str.charAt(str.length() - 4)];
      j = b[str.charAt(str.length() - 3)];
      k = b[str.charAt(str.length() - 2)];
      paramString[(paramString.length - 2)] = ((byte)(i << 2 | j >> 4));
      paramString[(paramString.length - 1)] = ((byte)(k >> 2 | j << 4));
      return paramString;
    }
    i = b[str.charAt(str.length() - 4)];
    j = b[str.charAt(str.length() - 3)];
    int k = b[str.charAt(str.length() - 2)];
    int m = b[str.charAt(str.length() - 1)];
    paramString[(paramString.length - 3)] = ((byte)(i << 2 | j >> 4));
    paramString[(paramString.length - 2)] = ((byte)(j << 4 | k >> 2));
    paramString[(paramString.length - 1)] = ((byte)(m | k << 6));
    return paramString;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length % 3;
    byte[] arrayOfByte1;
    if (k == 0) {
      arrayOfByte1 = new byte[paramArrayOfByte.length * 4 / 3];
    } else {
      arrayOfByte1 = new byte[(paramArrayOfByte.length / 3 + 1) * 4];
    }
    int m = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    while (j < m - k)
    {
      int n = paramArrayOfByte[j] & 0xFF;
      int i1 = paramArrayOfByte[(j + 1)] & 0xFF;
      int i2 = paramArrayOfByte[(j + 2)] & 0xFF;
      byte[] arrayOfByte2 = a;
      arrayOfByte1[i] = arrayOfByte2[(n >>> 2 & 0x3F)];
      arrayOfByte1[(i + 1)] = arrayOfByte2[((n << 4 | i1 >>> 4) & 0x3F)];
      arrayOfByte1[(i + 2)] = arrayOfByte2[((i1 << 2 | i2 >>> 6) & 0x3F)];
      arrayOfByte1[(i + 3)] = arrayOfByte2[(i2 & 0x3F)];
      j += 3;
      i += 4;
    }
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2) {
          return arrayOfByte1;
        }
        i = paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF;
        j = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
        k = arrayOfByte1.length;
        paramArrayOfByte = a;
        arrayOfByte1[(k - 4)] = paramArrayOfByte[(i >>> 2 & 0x3F)];
        arrayOfByte1[(arrayOfByte1.length - 3)] = paramArrayOfByte[((i << 4 | j >>> 4) & 0x3F)];
        arrayOfByte1[(arrayOfByte1.length - 2)] = paramArrayOfByte[(j << 2 & 0x3F)];
        arrayOfByte1[(arrayOfByte1.length - 1)] = 61;
        return arrayOfByte1;
      }
      i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
      j = arrayOfByte1.length;
      paramArrayOfByte = a;
      arrayOfByte1[(j - 4)] = paramArrayOfByte[(i >>> 2 & 0x3F)];
      arrayOfByte1[(arrayOfByte1.length - 3)] = paramArrayOfByte[(i << 4 & 0x3F)];
      arrayOfByte1[(arrayOfByte1.length - 2)] = 61;
      arrayOfByte1[(arrayOfByte1.length - 1)] = 61;
    }
    return arrayOfByte1;
  }
  
  private static String b(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicpendant.Base64
 * JD-Core Version:    0.7.0.1
 */