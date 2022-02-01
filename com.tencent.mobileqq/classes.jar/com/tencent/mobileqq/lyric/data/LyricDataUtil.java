package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import java.util.ArrayList;

public class LyricDataUtil
{
  public static void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList)
  {
    paramString = paramString.toCharArray();
    paramInt1 = 0;
    int i1 = 0;
    int i = 0;
    int k = -1;
    int n = 0;
    int i2 = paramInt2;
    paramInt2 = i;
    while (paramInt1 < paramString.length)
    {
      char c = paramString[paramInt1];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("");
      int i3 = paramInt2 + (int)paramPaint.measureText(localStringBuilder.toString());
      int j;
      int m;
      if (c == '\n')
      {
        paramArrayList.add(new String(paramString, i1, paramInt1 - i1));
        k = paramInt1 + 1;
        j = k;
        m = paramInt3;
        paramInt2 = 0;
        i = -1;
      }
      else if ((i3 > i2) && (paramInt1 > 0))
      {
        if ((c != ' ') && (c != '\t'))
        {
          if (k == -1)
          {
            j = paramInt1;
            if (paramInt1 > i1 + 1) {
              j = paramInt1 - 1;
            }
            paramArrayList.add(new String(paramString, i1, j - i1));
            i = j;
            paramInt2 = 0;
            paramInt1 = k;
          }
          else
          {
            paramInt2 = i3 - n;
            paramArrayList.add(new String(paramString, i1, k - i1));
            j = -1;
            k += 1;
            i = paramInt1;
            paramInt1 = j;
            j = k;
          }
        }
        else
        {
          paramArrayList.add(new String(paramString, i1, paramInt1 - i1));
          j = paramInt1 + 1;
          i = j;
          paramInt2 = 0;
          paramInt1 = -1;
        }
        m = paramInt3;
        k = i;
        i = paramInt1;
      }
      else if (c != ' ')
      {
        j = i1;
        paramInt2 = i3;
        m = i2;
        i = k;
        k = paramInt1;
        if (c != '\t') {}
      }
      else
      {
        i = paramInt1;
        n = i3;
        k = paramInt1;
        m = i2;
        paramInt2 = i3;
        j = i1;
      }
      paramInt1 = k + 1;
      i1 = j;
      i2 = m;
      k = i;
    }
    paramArrayList.add(new String(paramString, i1, paramString.length - i1));
  }
  
  public static String[] a(String paramString, Paint paramPaint, int paramInt1, int paramInt2)
  {
    return a(paramString, paramPaint, paramInt1, paramInt2, 99999);
  }
  
  public static String[] a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if ((int)paramPaint.measureText(paramString) <= paramInt1) {
        return new String[] { paramString };
      }
      ArrayList localArrayList = new ArrayList();
      char[] arrayOfChar = paramString.toCharArray();
      int i = paramInt1;
      int j = 0;
      int i1 = 32;
      int k = 0;
      paramInt1 = 0;
      while (paramInt1 < arrayOfChar.length)
      {
        int i4 = arrayOfChar[paramInt1];
        int i2;
        if ((i4 == 13) && (paramInt1 < arrayOfChar.length - 1) && (arrayOfChar[(paramInt1 + 1)] == '\n')) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        int i3;
        int n;
        int m;
        if ((i4 != 10) && (paramInt1 != arrayOfChar.length - 1))
        {
          i3 = j;
          n = k;
          m = i;
          i1 = paramInt1;
          if (i2 == 0) {}
        }
        else
        {
          if (paramInt1 == arrayOfChar.length - 1) {
            paramString = new String(arrayOfChar, k, paramInt1 + 1 - k);
          } else {
            paramString = new String(arrayOfChar, k, paramInt1 - k);
          }
          k = (int)paramPaint.measureText(paramString);
          if (k <= i) {
            localArrayList.add(paramString);
          } else {
            a(paramString, paramPaint, k, i, paramInt2, localArrayList);
          }
          i = paramInt1;
          if (i2 != 0) {
            i = paramInt1 + 1;
          }
          m = paramInt2;
          n = i + 1;
          i3 = j + 1;
          i1 = i;
        }
        paramInt1 = i1 + 1;
        i1 = i4;
        j = i3;
        k = n;
        i = m;
      }
      if ((j > 1) && ((i1 == 10) || (i1 == 10))) {
        localArrayList.add("");
      }
      paramInt1 = paramInt3;
      if (paramInt3 < 1) {
        paramInt1 = 1;
      }
      while (localArrayList.size() > paramInt1) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return new String[] { paramString };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.LyricDataUtil
 * JD-Core Version:    0.7.0.1
 */