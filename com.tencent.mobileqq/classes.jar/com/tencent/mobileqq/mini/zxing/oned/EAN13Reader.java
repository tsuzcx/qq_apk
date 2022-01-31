package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

public final class EAN13Reader
  extends UPCEANReader
{
  static final int[] FIRST_DIGIT_ENCODINGS = { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  private final int[] decodeMiddleCounters = new int[4];
  
  private static void determineFirstDigit(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < 10)
    {
      if (paramInt == FIRST_DIGIT_ENCODINGS[i])
      {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      }
      i += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = paramBitArray.getSize();
    int i = paramArrayOfInt[1];
    int j = 0;
    int m;
    for (int k = 0; (j < 6) && (i < n); k = m)
    {
      int i1 = decodeDigit(paramBitArray, arrayOfInt, i, L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      m = 0;
      while (m < i2)
      {
        i += arrayOfInt[m];
        m += 1;
      }
      m = k;
      if (i1 >= 10) {
        m = k | 1 << 5 - j;
      }
      j += 1;
    }
    determineFirstDigit(paramStringBuilder, k);
    i = findGuardPattern(paramBitArray, i, true, MIDDLE_PATTERN)[1];
    j = 0;
    while ((j < 6) && (i < n))
    {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, i, L_PATTERNS) + 48));
      m = arrayOfInt.length;
      k = 0;
      while (k < m)
      {
        i += arrayOfInt[k];
        k += 1;
      }
      j += 1;
    }
    return i;
  }
  
  BarcodeFormat getBarcodeFormat()
  {
    return BarcodeFormat.EAN_13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.EAN13Reader
 * JD-Core Version:    0.7.0.1
 */