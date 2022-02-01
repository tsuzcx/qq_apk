package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LevenshteinUtils
{
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(paramInt1, Math.min(paramInt2, paramInt3));
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt, Set<Character> paramSet)
  {
    while (paramInt < paramArrayOfChar.length)
    {
      if (!paramSet.contains(Character.valueOf(paramArrayOfChar[paramInt]))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramArrayOfChar.length;
  }
  
  private static void a(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt1)
    {
      paramList.add(Integer.valueOf(paramInt2));
      i += 1;
    }
  }
  
  private static void a(List<Integer> paramList, char[] paramArrayOfChar1, char[] paramArrayOfChar2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 -= paramInt1;
    paramInt4 -= paramInt3;
    int j = Math.max(paramInt2, paramInt4);
    if (paramInt2 == paramInt4)
    {
      a(paramList, j, 0);
      return;
    }
    int k = paramInt2 + 1;
    int m = paramInt4 + 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { k, m });
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      arrayOfInt[paramInt2][0] = paramInt2;
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      arrayOfInt[0][paramInt2] = paramInt2;
      paramInt2 += 1;
    }
    paramInt2 = 1;
    int i;
    while (paramInt2 < k)
    {
      paramInt4 = 1;
      while (paramInt4 < m)
      {
        int n = paramInt2 - 1;
        i = paramArrayOfChar1[(n + paramInt1)];
        int i1 = paramInt4 - 1;
        if (i == paramArrayOfChar2[(i1 + paramInt3)]) {
          i = 0;
        } else {
          i = 1;
        }
        arrayOfInt[paramInt2][paramInt4] = a(arrayOfInt[n][paramInt4] + 1, arrayOfInt[paramInt2][i1] + 1, arrayOfInt[n][i1] + i);
        paramInt4 += 1;
      }
      paramInt2 += 1;
    }
    paramArrayOfChar1 = new ArrayList(j * 2);
    paramInt1 = k - 1;
    paramInt2 = m - 1;
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      paramInt1 = paramArrayOfChar1.size() - 1;
      while (paramInt1 >= 0)
      {
        paramList.add(paramArrayOfChar1.get(paramInt1));
        paramInt1 -= 1;
      }
      return;
    }
    if (paramInt1 == 0) {
      paramArrayOfChar1.add(Integer.valueOf(1));
    }
    for (;;)
    {
      label335:
      paramInt2 -= 1;
      break;
      if (paramInt2 == 0) {
        paramArrayOfChar1.add(Integer.valueOf(2));
      }
      for (;;)
      {
        paramInt1 -= 1;
        break;
        paramArrayOfChar2 = arrayOfInt[paramInt1];
        i = paramInt2 - 1;
        paramInt3 = paramArrayOfChar2[i];
        j = paramInt1 - 1;
        paramInt4 = arrayOfInt[j][paramInt2];
        i = arrayOfInt[j][i];
        if ((paramInt3 < paramInt4) && (paramInt3 < i))
        {
          paramArrayOfChar1.add(Integer.valueOf(1));
          break label335;
        }
        if (paramInt4 >= i) {
          break label458;
        }
        paramArrayOfChar1.add(Integer.valueOf(2));
      }
      label458:
      paramArrayOfChar1.add(Integer.valueOf(0));
      paramInt1 -= 1;
    }
  }
  
  public static int[] a(char[] paramArrayOfChar1, char[] paramArrayOfChar2, Set<Character> paramSet)
  {
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    int i = 0;
    int k;
    label145:
    boolean bool1;
    boolean bool2;
    for (int j = 0;; j = k)
    {
      if (i == paramArrayOfChar1.length) {
        k = 1;
      } else {
        k = 0;
      }
      if (j == paramArrayOfChar2.length) {
        m = 1;
      } else {
        m = 0;
      }
      if ((k == 0) || (m == 0)) {
        if (k != 0)
        {
          a(localArrayList, paramArrayOfChar2.length - j, 1);
        }
        else
        {
          if (m == 0) {
            break label145;
          }
          a(localArrayList, paramArrayOfChar1.length - i, 2);
        }
      }
      paramArrayOfChar1 = new int[localArrayList.size()];
      i = n;
      while (i < localArrayList.size())
      {
        paramArrayOfChar1[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      return paramArrayOfChar1;
      bool1 = paramSet.contains(Character.valueOf(paramArrayOfChar1[i]));
      bool2 = paramSet.contains(Character.valueOf(paramArrayOfChar2[j]));
      if ((!bool1) || (!bool2)) {
        break;
      }
      int m = a(paramArrayOfChar1, i + 1, paramSet);
      k = a(paramArrayOfChar2, j + 1, paramSet);
      a(localArrayList, paramArrayOfChar1, paramArrayOfChar2, i, m, j, k);
      i = m;
    }
    if (bool1) {
      localArrayList.add(Integer.valueOf(1));
    }
    for (;;)
    {
      j += 1;
      break;
      if (bool2)
      {
        localArrayList.add(Integer.valueOf(2));
        i += 1;
        break;
      }
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.LevenshteinUtils
 * JD-Core Version:    0.7.0.1
 */