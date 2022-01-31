package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader
  extends OneDReader
{
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
  static final int ASTERISK_ENCODING = 148;
  static final int[] CHARACTER_ENCODINGS = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42 };
  private final int[] counters;
  private final StringBuilder decodeRowResult;
  private final boolean extendedMode;
  private final boolean usingCheckDigit;
  
  public Code39Reader()
  {
    this(false);
  }
  
  public Code39Reader(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }
  
  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.usingCheckDigit = paramBoolean1;
    this.extendedMode = paramBoolean2;
    this.decodeRowResult = new StringBuilder(20);
    this.counters = new int[9];
  }
  
  private static String decodeExtended(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramCharSequence.charAt(i);
      int k;
      if ((c == '+') || (c == '$') || (c == '%') || (c == '/'))
      {
        k = paramCharSequence.charAt(i + 1);
        switch (c)
        {
        default: 
          c = '\000';
          label114:
          localStringBuilder.append(c);
          i += 1;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((k >= 65) && (k <= 90))
        {
          c = (char)(k + 32);
          break label114;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 90))
        {
          c = (char)(k - 64);
          break label114;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 69))
        {
          c = (char)(k - 38);
          break label114;
        }
        if ((k >= 70) && (k <= 74))
        {
          c = (char)(k - 11);
          break label114;
        }
        if ((k >= 75) && (k <= 79))
        {
          c = (char)(k + 16);
          break label114;
        }
        if ((k >= 80) && (k <= 84))
        {
          c = (char)(k + 43);
          break label114;
        }
        if (k == 85)
        {
          c = '\000';
          break label114;
        }
        if (k == 86)
        {
          c = '@';
          break label114;
        }
        if (k == 87)
        {
          c = '`';
          break label114;
        }
        if ((k == 88) || (k == 89) || (k == 90))
        {
          c = '';
          break label114;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 79))
        {
          c = (char)(k - 32);
          break label114;
        }
        if (k == 90)
        {
          c = ':';
          break label114;
        }
        throw FormatException.getFormatInstance();
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static int[] findAsteriskPattern(BitArray paramBitArray, int[] paramArrayOfInt)
  {
    int n = paramBitArray.getSize();
    int i = paramBitArray.getNextSet(0);
    int i1 = paramArrayOfInt.length;
    int k = i;
    int i2 = 0;
    int j = 0;
    if (k < n)
    {
      int m;
      if (paramBitArray.get(k) != i2)
      {
        paramArrayOfInt[j] += 1;
        m = j;
        j = i;
      }
      for (;;)
      {
        k += 1;
        i = j;
        j = m;
        break;
        if (j == i1 - 1)
        {
          if ((toNarrowWidePattern(paramArrayOfInt) == 148) && (paramBitArray.isRange(Math.max(0, i - (k - i) / 2), i, false))) {
            return new int[] { i, k };
          }
          m = i + (paramArrayOfInt[0] + paramArrayOfInt[1]);
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, j - 1);
          paramArrayOfInt[(j - 1)] = 0;
          paramArrayOfInt[j] = 0;
          i = j - 1;
          j = m;
        }
        for (;;)
        {
          paramArrayOfInt[i] = 1;
          if (i2 != 0) {
            break label190;
          }
          i2 = 1;
          m = i;
          break;
          m = j + 1;
          j = i;
          i = m;
        }
        label190:
        i2 = 0;
        m = i;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static char patternToChar(int paramInt)
  {
    int i = 0;
    while (i < CHARACTER_ENCODINGS.length)
    {
      if (CHARACTER_ENCODINGS[i] == paramInt) {
        return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i);
      }
      i += 1;
    }
    if (paramInt == 148) {
      return '*';
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int toNarrowWidePattern(int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt.length;
    int i;
    for (int j = 0;; j = i)
    {
      i = 2147483647;
      int i1 = paramArrayOfInt.length;
      int k = 0;
      while (k < i1)
      {
        n = paramArrayOfInt[k];
        m = i;
        if (n < i)
        {
          m = i;
          if (n > j) {
            m = n;
          }
        }
        k += 1;
        i = m;
      }
      int n = 0;
      j = 0;
      int m = 0;
      int i2;
      for (k = 0; n < i4; k = i1)
      {
        int i5 = paramArrayOfInt[n];
        int i3 = j;
        i2 = m;
        i1 = k;
        if (i5 > i)
        {
          i3 = j | 1 << i4 - 1 - n;
          i1 = k + 1;
          i2 = m + i5;
        }
        n += 1;
        j = i3;
        m = i2;
      }
      if (k == 3)
      {
        n = k;
        k = 0;
        for (;;)
        {
          i1 = j;
          if (k < i4)
          {
            i1 = j;
            if (n > 0)
            {
              i2 = paramArrayOfInt[k];
              i1 = n;
              if (i2 <= i) {
                break label204;
              }
              i1 = n - 1;
              if (i2 * 2 < m) {
                break label204;
              }
              i1 = -1;
            }
          }
          return i1;
          label204:
          k += 1;
          n = i1;
        }
      }
      if (k <= 3) {
        return -1;
      }
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    Object localObject1 = this.counters;
    Arrays.fill((int[])localObject1, 0);
    Object localObject2 = this.decodeRowResult;
    ((StringBuilder)localObject2).setLength(0);
    paramMap = findAsteriskPattern(paramBitArray, (int[])localObject1);
    int i = paramBitArray.getNextSet(paramMap[1]);
    int n = paramBitArray.getSize();
    for (;;)
    {
      recordPattern(paramBitArray, i, (int[])localObject1);
      int j = toNarrowWidePattern((int[])localObject1);
      if (j < 0) {
        throw NotFoundException.getNotFoundInstance();
      }
      char c = patternToChar(j);
      ((StringBuilder)localObject2).append(c);
      int m = localObject1.length;
      j = 0;
      int k = i;
      while (j < m)
      {
        k += localObject1[j];
        j += 1;
      }
      m = paramBitArray.getNextSet(k);
      if (c == '*')
      {
        ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 1);
        j = 0;
        int i1 = localObject1.length;
        k = 0;
        while (k < i1)
        {
          j += localObject1[k];
          k += 1;
        }
        if ((m != n) && ((m - i - j) * 2 < j)) {
          throw NotFoundException.getNotFoundInstance();
        }
        if (this.usingCheckDigit)
        {
          n = ((StringBuilder)localObject2).length() - 1;
          m = 0;
          k = 0;
          while (k < n)
          {
            m += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.decodeRowResult.charAt(k));
            k += 1;
          }
          if (((StringBuilder)localObject2).charAt(n) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(m % 43)) {
            throw ChecksumException.getChecksumInstance();
          }
          ((StringBuilder)localObject2).setLength(n);
        }
        if (((StringBuilder)localObject2).length() == 0) {
          throw NotFoundException.getNotFoundInstance();
        }
        if (this.extendedMode) {}
        for (paramBitArray = decodeExtended((CharSequence)localObject2);; paramBitArray = ((StringBuilder)localObject2).toString())
        {
          float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
          float f2 = i;
          float f3 = j / 2.0F;
          paramMap = new ResultPoint(f1, paramInt);
          localObject1 = new ResultPoint(f2 + f3, paramInt);
          localObject2 = BarcodeFormat.CODE_39;
          return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
        }
      }
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code39Reader
 * JD-Core Version:    0.7.0.1
 */