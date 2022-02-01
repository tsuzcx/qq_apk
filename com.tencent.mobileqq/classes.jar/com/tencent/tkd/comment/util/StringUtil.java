package com.tencent.tkd.comment.util;

public class StringUtil
{
  public static String safeGetString(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnsupportedOperationException paramArrayOfByte) {}
    return "";
  }
  
  public static String safeString(String paramString)
  {
    return safeString(paramString, null);
  }
  
  public static String safeString(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1;
    }
    if (paramString2 != null) {
      return paramString2;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */