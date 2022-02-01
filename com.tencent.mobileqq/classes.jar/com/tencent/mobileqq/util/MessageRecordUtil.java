package com.tencent.mobileqq.util;

public class MessageRecordUtil
{
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "0|0";
    }
    return paramString.charAt(0) + "|" + paramString.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.MessageRecordUtil
 * JD-Core Version:    0.7.0.1
 */