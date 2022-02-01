package com.tencent.oskplayer.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private static char[] hextable = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] + 256 & 0xFF;
      str = str + hextable[(j >> 4 & 0xF)] + hextable[(j & 0xF)];
      i += 1;
    }
    return str;
  }
  
  private static String digest(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1.getBytes(), 0, paramString1.length());
      return byteArrayToHex(paramString2.digest());
    }
    catch (NoSuchAlgorithmException paramString2)
    {
      PlayerUtils.log(5, "MD5", PlayerUtils.getPrintableStackTrace(paramString2));
    }
    return paramString1;
  }
  
  public static String md5(String paramString)
  {
    return digest(paramString, "MD5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.util.MD5
 * JD-Core Version:    0.7.0.1
 */