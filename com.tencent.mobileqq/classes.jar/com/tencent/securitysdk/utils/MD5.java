package com.tencent.securitysdk.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5
{
  public static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(String paramString)
  {
    return a(a(paramString));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16))
    {
      char[] arrayOfChar1 = new char[32];
      int i = 0;
      int j = 0;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        char[] arrayOfChar2 = a;
        arrayOfChar1[j] = arrayOfChar2[(k >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar1[m] = arrayOfChar2[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return "";
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      try
      {
        paramString = paramString.getBytes("UTF-8");
        return localMessageDigest.digest(paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securitysdk.utils.MD5
 * JD-Core Version:    0.7.0.1
 */