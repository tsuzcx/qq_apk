package com.tencent.qidian.util;

public class LoginUtils
{
  public static int a(String paramString)
  {
    int j = 0;
    int i;
    try
    {
      paramString = paramString.split("\\.");
      i = 0;
      for (;;)
      {
        k = i;
        try
        {
          if (j >= paramString.length) {
            return k;
          }
          long l1 = i;
          long l2 = 3 - j;
          long l3 = Long.parseLong(paramString[j]);
          i = (int)(l1 + (0xA ^ l2 * l3));
          j += 1;
        }
        catch (Exception paramString) {}
      }
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    int k = i;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.util.LoginUtils
 * JD-Core Version:    0.7.0.1
 */