package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.io.UnsupportedEncodingException;

public class Base64Utils
{
  private static byte[] base64DecodeChars = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  private static char[] base64EncodeChars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  
  public static byte[] decode(String paramString)
  {
    try
    {
      paramString = decodePrivate(paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[0];
  }
  
  private static byte[] decodePrivate(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes("US-ASCII");
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      byte[] arrayOfByte;
      int n;
      for (int j = i;; j = i)
      {
        arrayOfByte = base64DecodeChars;
        i = j + 1;
        n = arrayOfByte[paramString[j]];
        if ((i >= k) || (n != -1)) {
          break;
        }
      }
      j = i;
      if (n == -1) {
        break;
      }
      int m;
      for (;;)
      {
        arrayOfByte = base64DecodeChars;
        i = j + 1;
        m = arrayOfByte[paramString[j]];
        if ((i >= k) || (m != -1)) {
          break;
        }
        j = i;
      }
      if (m == -1) {
        break;
      }
      localStringBuffer.append((char)(n << 2 | (m & 0x30) >>> 4));
      for (j = i;; j = i)
      {
        i = j + 1;
        j = paramString[j];
        if (j == 61) {
          return localStringBuffer.toString().getBytes("iso8859-1");
        }
        n = base64DecodeChars[j];
        if ((i >= k) || (n != -1)) {
          break;
        }
      }
      if (n == -1) {
        break;
      }
      localStringBuffer.append((char)((m & 0xF) << 4 | (n & 0x3C) >>> 2));
      for (j = i;; j = i)
      {
        i = j + 1;
        j = paramString[j];
        if (j == 61) {
          return localStringBuffer.toString().getBytes("iso8859-1");
        }
        j = base64DecodeChars[j];
        if ((i >= k) || (j != -1)) {
          break;
        }
      }
      if (j == -1) {
        break;
      }
      localStringBuffer.append((char)(j | (n & 0x3) << 6));
    }
    return localStringBuffer.toString().getBytes("iso8859-1");
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int k;
    for (int i = 0; i < j; i = k + 1)
    {
      int m = i + 1;
      i = paramArrayOfByte[i] & 0xFF;
      if (m == j)
      {
        localStringBuffer.append(base64EncodeChars[(i >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((i & 0x3) << 4)]);
        localStringBuffer.append("==");
        break;
      }
      k = m + 1;
      m = paramArrayOfByte[m] & 0xFF;
      if (k == j)
      {
        localStringBuffer.append(base64EncodeChars[(i >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
        localStringBuffer.append(base64EncodeChars[((m & 0xF) << 2)]);
        localStringBuffer.append("=");
        break;
      }
      int n = paramArrayOfByte[k] & 0xFF;
      localStringBuffer.append(base64EncodeChars[(i >>> 2)]);
      localStringBuffer.append(base64EncodeChars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
      localStringBuffer.append(base64EncodeChars[((m & 0xF) << 2 | (n & 0xC0) >>> 6)]);
      localStringBuffer.append(base64EncodeChars[(n & 0x3F)]);
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.Base64Utils
 * JD-Core Version:    0.7.0.1
 */