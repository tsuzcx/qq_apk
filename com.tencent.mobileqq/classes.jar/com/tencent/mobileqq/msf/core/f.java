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
    int j = -1;
    int m;
    int n;
    if (i < arrayOfString.length)
    {
      paramString = arrayOfString[i];
      char[] arrayOfChar = paramString.toCharArray();
      m = 0;
      n = 0;
      while ((m < arrayOfChar.length - 1) && (arrayOfChar[m] == '0'))
      {
        n += 1;
        m += 1;
      }
      if (n <= 0) {
        break label243;
      }
      paramString = paramString.substring(n);
    }
    label243:
    for (;;)
    {
      if (k == 0) {
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
      }
      for (;;)
      {
        i += 1;
        k = m;
        j = n;
        break;
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
          continue;
          localStringBuilder.append(paramString);
          m = k;
          n = j;
          if (i < arrayOfString.length - 1)
          {
            localStringBuilder.append(":");
            m = k;
            n = j;
          }
        }
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.f
 * JD-Core Version:    0.7.0.1
 */