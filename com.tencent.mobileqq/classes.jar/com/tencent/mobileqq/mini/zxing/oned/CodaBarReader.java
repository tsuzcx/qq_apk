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
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramArrayOfChar != null)
    {
      j = paramArrayOfChar.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfChar[i] == paramChar) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void counterAppend(int paramInt)
  {
    this.counters[this.counterLength] = paramInt;
    this.counterLength += 1;
    if (this.counterLength >= this.counters.length)
    {
      int[] arrayOfInt = new int[this.counterLength * 2];
      System.arraycopy(this.counters, 0, arrayOfInt, 0, this.counterLength);
      this.counters = arrayOfInt;
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
        int k = 0;
        j = i;
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
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void setCounters(BitArray paramBitArray)
  {
    this.counterLength = 0;
    int j = paramBitArray.getNextUnset(0);
    int k = paramBitArray.getSize();
    if (j >= k) {
      throw NotFoundException.getNotFoundInstance();
    }
    int m = 1;
    int i = 0;
    while (j < k) {
      if (paramBitArray.get(j) != m)
      {
        i += 1;
        j += 1;
      }
      else
      {
        counterAppend(i);
        if (m == 0) {}
        for (m = 1;; m = 0)
        {
          i = 1;
          break;
        }
      }
    }
    counterAppend(i);
  }
  
  private int toNarrowWidePattern(int paramInt)
  {
    int i2 = 2147483647;
    int i3 = paramInt + 7;
    if (i3 >= this.counterLength)
    {
      j = -1;
      return j;
    }
    int[] arrayOfInt = this.counters;
    int j = paramInt;
    int m = 2147483647;
    int i = 0;
    label37:
    int n;
    int k;
    if (j < i3)
    {
      n = arrayOfInt[j];
      k = m;
      if (n < m) {
        k = n;
      }
      if (n <= i) {
        break label254;
      }
      i = n;
    }
    label102:
    label246:
    label248:
    label251:
    label254:
    for (;;)
    {
      j += 2;
      m = k;
      break label37;
      int i1 = (m + i) / 2;
      j = paramInt + 1;
      i = 0;
      m = i2;
      if (j < i3)
      {
        n = arrayOfInt[j];
        k = m;
        if (n < m) {
          k = n;
        }
        if (n <= i) {
          break label251;
        }
        i = n;
      }
      for (;;)
      {
        j += 2;
        m = k;
        break label102;
        n = (m + i) / 2;
        j = 0;
        i = 0;
        k = 128;
        if (j < 7) {
          if ((j & 0x1) == 0)
          {
            m = i1;
            k >>= 1;
            if (arrayOfInt[(paramInt + j)] <= m) {
              break label248;
            }
            i |= k;
          }
        }
        for (;;)
        {
          j += 1;
          break label166;
          m = n;
          break label182;
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= CHARACTER_ENCODINGS.length) {
              break label246;
            }
            j = paramInt;
            if (CHARACTER_ENCODINGS[paramInt] == i) {
              break;
            }
            paramInt += 1;
          }
          return -1;
        }
      }
    }
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
    int n = this.decodeRowResult.length() - 1;
    int i = 0;
    int j = paramInt;
    int m;
    int k;
    int i1;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    for (;;)
    {
      m = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i)];
      k = 6;
      while (k >= 0)
      {
        i1 = (k & 0x1) + (m & 0x1) * 2;
        arrayOfInt1[i1] += this.counters[(j + k)];
        arrayOfInt2[i1] += 1;
        m >>= 1;
        k -= 1;
      }
      if (i >= n)
      {
        arrayOfFloat1 = new float[4];
        arrayOfFloat2 = new float[4];
        i = 0;
        while (i < 2)
        {
          arrayOfFloat2[i] = 0.0F;
          arrayOfFloat2[(i + 2)] = ((arrayOfInt1[i] / arrayOfInt2[i] + arrayOfInt1[(i + 2)] / arrayOfInt2[(i + 2)]) / 2.0F);
          arrayOfFloat1[i] = arrayOfFloat2[(i + 2)];
          arrayOfFloat1[(i + 2)] = ((arrayOfInt1[(i + 2)] * 2.0F + 1.5F) / arrayOfInt2[(i + 2)]);
          i += 1;
        }
      }
      j += 8;
      i += 1;
    }
    j = 0;
    i = paramInt;
    paramInt = j;
    for (;;)
    {
      k = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(paramInt)];
      j = 6;
      while (j >= 0)
      {
        m = (j & 0x1) + (k & 0x1) * 2;
        i1 = this.counters[(i + j)];
        if ((i1 < arrayOfFloat2[m]) || (i1 > arrayOfFloat1[m])) {
          throw NotFoundException.getNotFoundInstance();
        }
        k >>= 1;
        j -= 1;
      }
      if (paramInt >= n) {
        return;
      }
      i += 8;
      paramInt += 1;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    Arrays.fill(this.counters, 0);
    setCounters(paramBitArray);
    int j = findStartPattern();
    this.decodeRowResult.setLength(0);
    int i = j;
    int k = toNarrowWidePattern(i);
    if (k == -1) {
      throw NotFoundException.getNotFoundInstance();
    }
    this.decodeRowResult.append((char)k);
    int m = i + 8;
    if ((this.decodeRowResult.length() > 1) && (arrayContains(STARTEND_ENCODING, ALPHABET[k]))) {}
    int n;
    for (;;)
    {
      n = this.counters[(m - 1)];
      i = -8;
      k = 0;
      while (i < -1)
      {
        k += this.counters[(m + i)];
        i += 1;
      }
      i = m;
      if (m < this.counterLength) {
        break;
      }
    }
    if ((m < this.counterLength) && (n < k / 2)) {
      throw NotFoundException.getNotFoundInstance();
    }
    validatePattern(j);
    i = 0;
    while (i < this.decodeRowResult.length())
    {
      this.decodeRowResult.setCharAt(i, ALPHABET[this.decodeRowResult.charAt(i)]);
      i += 1;
    }
    char c = this.decodeRowResult.charAt(0);
    if (!arrayContains(STARTEND_ENCODING, c)) {
      throw NotFoundException.getNotFoundInstance();
    }
    c = this.decodeRowResult.charAt(this.decodeRowResult.length() - 1);
    if (!arrayContains(STARTEND_ENCODING, c)) {
      throw NotFoundException.getNotFoundInstance();
    }
    if (this.decodeRowResult.length() <= 3) {
      throw NotFoundException.getNotFoundInstance();
    }
    if ((paramMap == null) || (!paramMap.containsKey(DecodeHintType.RETURN_CODABAR_START_END)))
    {
      this.decodeRowResult.deleteCharAt(this.decodeRowResult.length() - 1);
      this.decodeRowResult.deleteCharAt(0);
    }
    k = 0;
    for (i = 0; k < j; i = n + i)
    {
      n = this.counters[k];
      k += 1;
    }
    float f1 = i;
    while (j < m - 1)
    {
      i += this.counters[j];
      j += 1;
    }
    float f2 = i;
    paramBitArray = this.decodeRowResult.toString();
    paramMap = new ResultPoint(f1, paramInt);
    ResultPoint localResultPoint = new ResultPoint(f2, paramInt);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.CODABAR;
    return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localResultPoint }, localBarcodeFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.CodaBarReader
 * JD-Core Version:    0.7.0.1
 */