package com.tencent.mobileqq.kandian.biz.comment.helper;

public class StringUtil
{
  public static String a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while ((i < j) && (paramString.charAt(i) <= ' ')) {
      i += 1;
    }
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i, j);
    }
    return str;
  }
  
  public static String b(String paramString)
  {
    int i = paramString.length();
    while ((i > 0) && (paramString.charAt(i - 1) <= ' ')) {
      i -= 1;
    }
    String str = paramString;
    if (i < paramString.length()) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.StringUtil
 * JD-Core Version:    0.7.0.1
 */