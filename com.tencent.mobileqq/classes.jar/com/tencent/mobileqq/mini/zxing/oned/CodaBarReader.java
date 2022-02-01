package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class CodaBarReader
  extends OneDReader
{
  static final char[] ALPHABET = "0123456789-$:/.+ABCD".toCharArray();
  private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
  static final int[] CHARACTER_ENCODINGS = { 3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14 };
  private static final float MAX_ACCEPTABLE = 2.0F;
  private static final int MIN_CHARACTER_LENGTH = 3;
  private static final float PADDING = 1.5F;
  private static final char[] STARTEND_ENCODING = { 65, 66, 67, 68 };
  private int counterLength = 0;
  private int[] counters = new int[80];
  private final StringBuilder decodeRowResult = new StringBuilder(20);
  
  static boolean arrayContains(char[] paramArrayOfChar, char paramChar)
  {
    if (paramArrayOfChar != null)
    {
      int j = paramArrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfChar[i] == paramChar) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void counterAppend(int paramInt)
  {
    int[] arrayOfInt1 = this.counters;
    int i = this.counterLength;
    arrayOfInt1[i] = paramInt;
    this.counterLength = (i + 1);
    paramInt = this.counterLength;
    if (paramInt >= arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[paramInt * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt);
      this.counters = arrayOfInt2;
    }
  }
  
  private int findStartPattern()
  {
    int i = 1;
    while (i < this.counterLength)
    {
      int j = toNarrowWidePattern(i);
      if ((j != -1) && (arrayContains(STARTEND_ENCODING, ALPHABET[j])))
      {
        j = i;
        int k = 0;
        while (j < i + 7)
        {
          k += this.counters[j];
          j += 1;
        }
        if ((i == 1) || (this.counters[(i - 1)] >= k / 2)) {
          return i;
        }
      }
      i += 2;
    }
    NotFoundException localNotFoundException = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw localNotFoundException;
    }
  }
  
  private void setCounters(BitArray paramBitArray)
  {
    int i = 0;
    this.counterLength = 0;
    int j = paramBitArray.getNextUnset(0);
    int k = paramBitArray.getSize();
    if (j < k)
    {
      int m = 1;
      while (j < k)
      {
        if (paramBitArray.get(j) != m)
        {
          i += 1;
        }
        else
        {
          counterAppend(i);
          m ^= 0x1;
          i = 1;
        }
        j += 1;
      }
      counterAppend(i);
      return;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  private int toNarrowWidePattern(int paramInt)
  {
    int i5 = paramInt + 7;
    if (i5 >= this.counterLength) {
      return -1;
    }
    int[] arrayOfInt = this.counters;
    int i4 = 2147483647;
    int i2 = 0;
    int j = paramInt;
    int m = 2147483647;
    int n;
    for (int i = 0; j < i5; i = i1)
    {
      n = arrayOfInt[j];
      k = m;
      if (n < m) {
        k = n;
      }
      i1 = i;
      if (n > i) {
        i1 = n;
      }
      j += 2;
      m = k;
    }
    int i3 = (m + i) / 2;
    i = paramInt + 1;
    j = 0;
    m = i4;
    while (i < i5)
    {
      n = arrayOfInt[i];
      k = m;
      if (n < m) {
        k = n;
      }
      i1 = j;
      if (n > j) {
        i1 = n;
      }
      i += 2;
      m = k;
      j = i1;
    }
    int i1 = (m + j) / 2;
    j = 0;
    int k = 128;
    for (i = 0;; i = m)
    {
      m = i2;
      if (j >= 7) {
        break;
      }
      if ((j & 0x1) == 0) {
        n = i3;
      } else {
        n = i1;
      }
      k >>= 1;
      m = i;
      if (arrayOfInt[(paramInt + j)] > n) {
        m = i | k;
      }
      j += 1;
    }
    for (;;)
    {
      arrayOfInt = CHARACTER_ENCODINGS;
      if (m >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[m] == i) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private void validatePattern(int paramInt)
  {
    int[] arrayOfInt1 = new int[4];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 0;
    int[] tmp19_15 = tmp15_11;
    tmp19_15[3] = 0;
    tmp19_15;
    int[] arrayOfInt2 = new int[4];
    int[] tmp31_29 = arrayOfInt2;
    tmp31_29[0] = 0;
    int[] tmp35_31 = tmp31_29;
    tmp35_31[1] = 0;
    int[] tmp39_35 = tmp35_31;
    tmp39_35[2] = 0;
    int[] tmp43_39 = tmp39_35;
    tmp43_39[3] = 0;
    tmp43_39;
    int i1 = this.decodeRowResult.length() - 1;
    int n = 0;
    int j = paramInt;
    int i = 0;
    for (;;)
    {
      int m = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i)];
      int k = 6;
      while (k >= 0)
      {
        int i2 = (k & 0x1) + (m & 0x1) * 2;
        arrayOfInt1[i2] += this.counters[(j + k)];
        arrayOfInt2[i2] += 1;
        m >>= 1;
        k -= 1;
      }
      if (i >= i1)
      {
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        k = 0;
        for (;;)
        {
          i = n;
          j = paramInt;
          if (k >= 2) {
            break;
          }
          arrayOfFloat2[k] = 0.0F;
          i = k + 2;
          arrayOfFloat2[i] = ((arrayOfInt1[k] / arrayOfInt2[k] + arrayOfInt1[i] / arrayOfInt2[i]) / 2.0F);
          arrayOfFloat1[k] = arrayOfFloat2[i];
          arrayOfFloat1[i] = ((arrayOfInt1[i] * 2.0F + 1.5F) / arrayOfInt2[i]);
          k += 1;
        }
        for (;;)
        {
          k = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i)];
          paramInt = 6;
          while (paramInt >= 0)
          {
            m = (paramInt & 0x1) + (k & 0x1) * 2;
            float f = this.counters[(j + paramInt)];
            if ((f >= arrayOfFloat2[m]) && (f <= arrayOfFloat1[m]))
            {
              k >>= 1;
              paramInt -= 1;
            }
            else
            {
              throw NotFoundException.getNotFoundInstance();
            }
          }
          if (i >= i1) {
            return;
          }
          j += 8;
          i += 1;
        }
      }
      j += 8;
      i += 1;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    Arrays.fill(this.counters, 0);
    setCounters(paramBitArray);
    int j = findStartPattern();
    this.decodeRowResult.setLength(0);
    int i = j;
    int m;
    do
    {
      k = toNarrowWidePattern(i);
      if (k == -1) {
        break label487;
      }
      this.decodeRowResult.append((char)k);
      m = i + 8;
      if ((this.decodeRowResult.length() > 1) && (arrayContains(STARTEND_ENCODING, ALPHABET[k]))) {
        break;
      }
      i = m;
    } while (m < this.counterLength);
    paramBitArray = this.counters;
    int n = m - 1;
    int i1 = paramBitArray[n];
    i = -8;
    int k = 0;
    while (i < -1)
    {
      k += this.counters[(m + i)];
      i += 1;
    }
    if ((m < this.counterLength) && (i1 < k / 2)) {
      throw NotFoundException.getNotFoundInstance();
    }
    validatePattern(j);
    i = 0;
    while (i < this.decodeRowResult.length())
    {
      paramBitArray = this.decodeRowResult;
      paramBitArray.setCharAt(i, ALPHABET[paramBitArray.charAt(i)]);
      i += 1;
    }
    char c = this.decodeRowResult.charAt(0);
    if (arrayContains(STARTEND_ENCODING, c))
    {
      paramBitArray = this.decodeRowResult;
      c = paramBitArray.charAt(paramBitArray.length() - 1);
      if (arrayContains(STARTEND_ENCODING, c))
      {
        if (this.decodeRowResult.length() > 3)
        {
          if ((paramMap == null) || (!paramMap.containsKey(DecodeHintType.RETURN_CODABAR_START_END)))
          {
            paramBitArray = this.decodeRowResult;
            paramBitArray.deleteCharAt(paramBitArray.length() - 1);
            this.decodeRowResult.deleteCharAt(0);
          }
          k = 0;
          i = 0;
          while (k < j)
          {
            i += this.counters[k];
            k += 1;
          }
          float f1 = i;
          while (j < n)
          {
            i += this.counters[j];
            j += 1;
          }
          float f2 = i;
          paramBitArray = this.decodeRowResult.toString();
          float f3 = paramInt;
          paramMap = new ResultPoint(f1, f3);
          ResultPoint localResultPoint = new ResultPoint(f2, f3);
          BarcodeFormat localBarcodeFormat = BarcodeFormat.CODABAR;
          return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localResultPoint }, localBarcodeFormat);
        }
        throw NotFoundException.getNotFoundInstance();
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
    label487:
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.CodaBarReader
 * JD-Core Version:    0.7.0.1
 */