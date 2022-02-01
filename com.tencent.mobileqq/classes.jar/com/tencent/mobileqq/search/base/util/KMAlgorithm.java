package com.tencent.mobileqq.search.base.util;

import java.util.Arrays;

public class KMAlgorithm
{
  static boolean a(int paramInt, long[][] paramArrayOfLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2, long[] paramArrayOfLong3)
  {
    paramArrayOfBoolean1[paramInt] = true;
    int i = 0;
    while (i < paramArrayOfLong2.length)
    {
      if ((paramArrayOfBoolean2[i] == 0) && (paramArrayOfLong[paramInt][i] > 0L))
      {
        long l = paramArrayOfLong1[paramInt] + paramArrayOfLong2[i] - paramArrayOfLong[paramInt][i];
        if (l == 0L)
        {
          paramArrayOfBoolean2[i] = true;
          int j = paramArrayOfInt2[i];
          if ((j == -1) || (a(j, paramArrayOfLong, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfBoolean1, paramArrayOfBoolean2, paramArrayOfLong3)))
          {
            paramArrayOfInt2[i] = paramInt;
            paramArrayOfInt1[paramInt] = i;
            return true;
          }
        }
        else if (l < paramArrayOfLong3[i])
        {
          paramArrayOfLong3[i] = l;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public static int[] a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int k = paramInt1;
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[paramInt2];
    long[] arrayOfLong3 = new long[paramInt2];
    int[] arrayOfInt2 = new int[k];
    int[] arrayOfInt1 = new int[paramInt2];
    Arrays.fill(arrayOfLong1, -9223372036854775808L);
    long l1 = 0L;
    Arrays.fill(arrayOfLong2, 0L);
    int i = 0;
    int j;
    while (i < k)
    {
      j = 0;
      while (j < paramInt2)
      {
        if ((paramArrayOfLong[i][j] > 0L) && (paramArrayOfLong[i][j] > arrayOfLong1[i])) {
          arrayOfLong1[i] = paramArrayOfLong[i][j];
        }
        j += 1;
      }
      i += 1;
    }
    Arrays.fill(arrayOfInt2, -1);
    Arrays.fill(arrayOfInt1, -1);
    i = 0;
    for (;;)
    {
      j = paramInt1;
      if (i >= j) {
        break;
      }
      Object localObject1 = new boolean[j];
      Object localObject2 = new boolean[paramInt2];
      long l2 = 9223372036854775807L;
      Arrays.fill(arrayOfLong3, 9223372036854775807L);
      Arrays.fill((boolean[])localObject1, false);
      Arrays.fill((boolean[])localObject2, false);
      for (;;)
      {
        Object localObject3 = localObject1;
        if (a(i, paramArrayOfLong, arrayOfLong1, arrayOfLong2, arrayOfInt2, arrayOfInt1, localObject3, (boolean[])localObject2, arrayOfLong3)) {
          break;
        }
        long l3 = l2;
        j = 0;
        localObject1 = localObject2;
        while (j < paramInt2)
        {
          long l4;
          if (localObject1[j] != 0)
          {
            l4 = l3;
          }
          else
          {
            l4 = l3;
            if (arrayOfLong3[j] < l3) {
              l4 = arrayOfLong3[j];
            }
          }
          j += 1;
          l3 = l4;
        }
        localObject2 = localObject1;
        if ((l3 == l2) || (l3 == l1)) {
          break;
        }
        j = 0;
        localObject1 = localObject3;
        while (j <= i)
        {
          if (localObject1[j] != 0) {
            arrayOfLong1[j] -= l3;
          }
          j += 1;
        }
        j = 0;
        while (j < paramInt2)
        {
          if (localObject2[j] != 0) {
            arrayOfLong2[j] += l3;
          } else {
            arrayOfLong3[j] -= l3;
          }
          j += 1;
        }
        Arrays.fill((boolean[])localObject1, false);
        Arrays.fill((boolean[])localObject2, false);
      }
      i += 1;
    }
    return arrayOfInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.KMAlgorithm
 * JD-Core Version:    0.7.0.1
 */