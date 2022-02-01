package com.tencent.qqlive.tvkplayer.vinfo.ckey;

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
    if (i < k) {}
    for (int j = i;; j = i)
    {
      byte[] arrayOfByte = base64DecodeChars;
      i = j + 1;
      int n = arrayOfByte[paramString[j]];
      if ((i >= k) || (n != -1))
      {
        j = i;
        if (n == -1) {}
        label64:
        int m;
        do
        {
          return localStringBuffer.toString().getBytes("iso8859-1");
          do
          {
            j = i;
            arrayOfByte = base64DecodeChars;
            i = j + 1;
            m = arrayOfByte[paramString[j]];
          } while ((i < k) && (m == -1));
        } while (m == -1);
        localStringBuffer.append((char)(n << 2 | (m & 0x30) >>> 4));
        for (j = i;; j = i)
        {
          i = j + 1;
          j = paramString[j];
          if (j == 61) {
            return localStringBuffer.toString().getBytes("iso8859-1");
          }
          n = base64DecodeChars[j];
          if ((i >= k) || (n != -1))
          {
            if (n == -1) {
              break label64;
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
              if ((i >= k) || (j != -1))
              {
                if (j == -1) {
                  break label64;
                }
                localStringBuffer.append((char)(j | (n & 0x3) << 6));
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int n;
      int k;
      if (i < j)
      {
        n = i + 1;
        k = paramArrayOfByte[i] & 0xFF;
        if (n != j) {
          break label80;
        }
        localStringBuffer.append(base64EncodeChars[(k >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((k & 0x3) << 4)]);
        localStringBuffer.append("==");
      }
      for (;;)
      {
        return localStringBuffer.toString();
        label80:
        m = n + 1;
        n = paramArrayOfByte[n] & 0xFF;
        if (m != j) {
          break;
        }
        localStringBuffer.append(base64EncodeChars[(k >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
        localStringBuffer.append(base64EncodeChars[((n & 0xF) << 2)]);
        localStringBuffer.append("=");
      }
      i = m + 1;
      int m = paramArrayOfByte[m] & 0xFF;
      localStringBuffer.append(base64EncodeChars[(k >>> 2)]);
      localStringBuffer.append(base64EncodeChars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
      localStringBuffer.append(base64EncodeChars[((n & 0xF) << 2 | (m & 0xC0) >>> 6)]);
      localStringBuffer.append(base64EncodeChars[(m & 0x3F)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.Base64Utils
 * JD-Core Version:    0.7.0.1
 */