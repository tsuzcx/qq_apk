package com.tencent.mobileqq.qqguildsdk.search.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.Collections;
import java.util.List;

public class SearchUtils
{
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 < 0) {
      return -9223372036854775808L;
    }
    if (paramBoolean2) {
      return ISearchable.g;
    }
    if (paramInt2 == paramInt3) {
      return ISearchable.e;
    }
    if (paramInt1 == 0) {
      return ISearchable.f;
    }
    if (!paramBoolean1) {
      return ISearchable.g;
    }
    return -9223372036854775808L;
  }
  
  private static long a(String paramString, ChnToSpell.ChnSpelling paramChnSpelling, boolean paramBoolean)
  {
    paramString = a(paramChnSpelling, paramString);
    return a(paramString[0], paramString[1], paramChnSpelling.c.size(), false, paramBoolean);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramLong, paramBoolean, false, false);
  }
  
  private static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return -9223372036854775808L;
      }
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.toLowerCase();
      long l = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
      if (l != -9223372036854775808L) {
        return l + ISearchable.c + paramLong;
      }
      if (paramBoolean1)
      {
        ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString2, 1);
        if ((true ^ paramString2.equals(localChnSpelling.b)))
        {
          l = a(paramString1, localChnSpelling, paramBoolean3);
          if (l != -9223372036854775808L) {
            return l + ISearchable.d + paramLong;
          }
          l = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
          if (l != -9223372036854775808L) {
            return l + ISearchable.d + paramLong;
          }
        }
      }
    }
    return -9223372036854775808L;
  }
  
  private static long a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString2.indexOf(paramString1), paramString1.length(), paramString2.length(), paramBoolean1, paramBoolean2);
  }
  
  public static boolean a(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    if (paramString1.contains(paramString2)) {
      return true;
    }
    ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString1, 2);
    int i = localChnSpelling.b.indexOf(paramString2);
    if (Collections.binarySearch(localChnSpelling.c, Integer.valueOf(i)) >= 0) {
      return true;
    }
    paramString1 = ChnToSpell.a(paramString1, 1);
    i = paramString1.b.indexOf(paramString2);
    return Collections.binarySearch(paramString1.c, Integer.valueOf(i)) >= 0;
  }
  
  private static int[] a(ChnToSpell.ChnSpelling paramChnSpelling, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    int j = paramChnSpelling.b.indexOf(paramString);
    if (j < 0) {
      return arrayOfInt;
    }
    int i = 0;
    while (i < paramChnSpelling.c.size())
    {
      if (j == ((Integer)paramChnSpelling.c.get(i)).intValue())
      {
        arrayOfInt[0] = i;
        k = i + 1;
        while ((k < paramChnSpelling.c.size()) && (paramString.length() + j > ((Integer)paramChnSpelling.c.get(k)).intValue())) {
          k += 1;
        }
        arrayOfInt[1] = (k - i);
        return arrayOfInt;
      }
      int m = i;
      int k = j;
      if (j < ((Integer)paramChnSpelling.c.get(i)).intValue())
      {
        k = paramChnSpelling.b.indexOf(paramString, ((Integer)paramChnSpelling.c.get(i)).intValue());
        if (k < 0) {
          return arrayOfInt;
        }
        m = i - 1;
      }
      i = m + 1;
      j = k;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.util.SearchUtils
 * JD-Core Version:    0.7.0.1
 */