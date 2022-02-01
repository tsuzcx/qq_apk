package com.tencent.mobileqq.vas;

import android.text.TextUtils;

public class IndividuationConfigInfo
{
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.max(paramString1.length, paramString2.length);
    int k = 0;
    label42:
    if (k < m) {
      if (k >= paramString1.length) {
        break label142;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString1[k]);
        if (k >= paramString2.length) {
          break label137;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(paramString2[k]);
          if (k == m - 1) {
            break label123;
          }
          if (j > i)
          {
            return true;
            localException1 = localException1;
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
        }
      }
      if (j < i) {
        break;
      }
      label123:
      do
      {
        k += 1;
        break label42;
        break;
        if (j >= i) {
          return true;
        }
      } while (j >= i);
      return false;
      label137:
      int j = 0;
      continue;
      label142:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationConfigInfo
 * JD-Core Version:    0.7.0.1
 */