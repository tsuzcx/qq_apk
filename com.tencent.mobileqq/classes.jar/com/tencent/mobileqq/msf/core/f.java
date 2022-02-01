package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;

public class f
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String[] arrayOfString = paramString.split(":");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    int n;
    for (int j = -1; i < arrayOfString.length; j = n)
    {
      String str = arrayOfString[i];
      paramString = str.toCharArray();
      int m = 0;
      n = 0;
      while ((m < paramString.length - 1) && (paramString[m] == '0'))
      {
        n += 1;
        m += 1;
      }
      paramString = str;
      if (n > 0) {
        paramString = str.substring(n);
      }
      if (k == 0)
      {
        if ("0".equals(paramString))
        {
          m = k;
          n = j;
          if (j == -1)
          {
            localStringBuilder.append(":");
            n = i;
            m = k;
          }
        }
        else
        {
          localStringBuilder.append(paramString);
          if (i < arrayOfString.length - 1) {
            localStringBuilder.append(":");
          }
          m = k;
          n = j;
          if (j != -1)
          {
            m = 1;
            n = j;
          }
        }
      }
      else
      {
        localStringBuilder.append(paramString);
        m = k;
        n = j;
        if (i < arrayOfString.length - 1)
        {
          localStringBuilder.append(":");
          n = j;
          m = k;
        }
      }
      i += 1;
      k = m;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.f
 * JD-Core Version:    0.7.0.1
 */