package com.tencent.oskplayer.util;

public class Base16
{
  public static final byte[] DEC_TAB = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  public static final char[] ENC_TAB = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static void decode(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramString.length() / 2;
    int i = 0;
    while (i < j * 2)
    {
      byte[] arrayOfByte = DEC_TAB;
      int k = i + 1;
      int m = arrayOfByte[paramString.charAt(i)];
      arrayOfByte = DEC_TAB;
      i = k + 1;
      paramArrayOfByte[paramInt] = ((byte)(m << 4 | arrayOfByte[paramString.charAt(k)]));
      paramInt += 1;
    }
  }
  
  public static byte[] decode(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    decode(paramString, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      localStringBuilder.append(ENC_TAB[((paramArrayOfByte[i] & 0xF0) >> 4)]);
      localStringBuilder.append(ENC_TAB[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.Base16
 * JD-Core Version:    0.7.0.1
 */