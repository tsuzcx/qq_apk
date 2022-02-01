package com.tencent.mobileqq.util;

public class MessageRecordUtil
{
  public static String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.charAt(0));
      localStringBuilder.append("|");
      localStringBuilder.append(paramString.length());
      return localStringBuilder.toString();
    }
    return "0|0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.MessageRecordUtil
 * JD-Core Version:    0.7.0.1
 */