package com.tencent.mobileqq.vas;

import android.text.TextUtils;

public class IndividuationConfigInfo
{
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      int m = Math.max(paramString1.length, paramString2.length);
      int i = 0;
      for (;;)
      {
        if ((i >= m) || (i < paramString1.length)) {}
        try
        {
          j = Integer.parseInt(paramString1[i]);
        }
        catch (Exception localException1)
        {
          int j;
          label63:
          break label63;
        }
        j = 0;
        if (i < paramString2.length) {}
        try
        {
          k = Integer.parseInt(paramString2[i]);
        }
        catch (Exception localException2)
        {
          int k;
          label82:
          break label82;
        }
        k = 0;
        if (i != m - 1)
        {
          if (k > j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        else
        {
          if (k >= j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationConfigInfo
 * JD-Core Version:    0.7.0.1
 */