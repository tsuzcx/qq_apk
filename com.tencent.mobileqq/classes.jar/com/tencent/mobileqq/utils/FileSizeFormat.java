package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.FontSettingManager;

public class FileSizeFormat
{
  private static char[] a = new char[32];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  
  public static String a(long paramLong)
  {
    return a(paramLong, 160);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    double d = l;
    int i;
    if (l < 1048576L)
    {
      if (l < 1024L)
      {
        i = 66;
      }
      else
      {
        Double.isNaN(d);
        d /= 1024.0D;
        i = 75;
      }
    }
    else if (l < 1073741824L)
    {
      Double.isNaN(d);
      d /= 1048576.0D;
      i = 77;
    }
    else
    {
      Double.isNaN(d);
      d /= 1073741824.0D;
      i = 71;
    }
    int m = (int)(0.005D + d);
    if (m < 100)
    {
      if (m < 10) {
        j = 1;
      } else {
        j = 2;
      }
    }
    else if (m < 1000) {
      j = 3;
    } else if (m < 10000) {
      j = 4;
    } else {
      j = 5;
    }
    int k;
    if (i != 66)
    {
      if ((FontSettingManager.getFontLevel() > 18.0F) && (paramInt < 160))
      {
        k = j + 2;
      }
      else
      {
        m = (int)(d * 100.0D + 0.5D);
        k = j + 5;
      }
    }
    else {
      k = j + 1;
    }
    char[] arrayOfChar2 = a;
    char[] arrayOfChar1 = arrayOfChar2;
    if (k > arrayOfChar2.length) {
      arrayOfChar1 = new char[k];
    }
    int i1 = k - 1;
    arrayOfChar1[i1] = 'B';
    int j = i1;
    int n = m;
    if (i != 66) {
      if ((FontSettingManager.getFontLevel() > 18.0F) && (paramInt < 160))
      {
        j = i1 - 1;
        arrayOfChar1[j] = i;
        n = m;
      }
      else
      {
        paramInt = i1 - 1;
        arrayOfChar1[paramInt] = i;
        paramInt -= 1;
        arrayOfChar2 = b;
        arrayOfChar1[paramInt] = arrayOfChar2[(m % 10)];
        j = m / 10;
        paramInt -= 1;
        arrayOfChar1[paramInt] = arrayOfChar2[(j % 10)];
        n = j / 10;
        j = paramInt - 1;
        arrayOfChar1[j] = '.';
      }
    }
    do
    {
      j -= 1;
      arrayOfChar1[j] = b[(n % 10)];
      paramInt = n / 10;
      n = paramInt;
    } while (paramInt > 0);
    return new String(arrayOfChar1, 0, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileSizeFormat
 * JD-Core Version:    0.7.0.1
 */