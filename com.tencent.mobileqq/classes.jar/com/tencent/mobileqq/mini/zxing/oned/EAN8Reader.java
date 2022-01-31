package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

public final class EAN8Reader
  extends UPCEANReader
{
  private final int[] decodeMiddleCounters = new int[4];
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int m = paramBitArray.getSize();
    int i = paramArrayOfInt[1];
    int j = 0;
    int n;
    int k;
    while ((j < 4) && (i < m))
    {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, i, L_PATTERNS) + 48));
      n = arrayOfInt.length;
      k = 0;
      while (k < n)
      {
        i += arrayOfInt[k];
        k += 1;
      }
      j += 1;
    }
    i = findGuardPattern(paramBitArray, i, true, MIDDLE_PATTERN)[1];
    j = 0;
    while ((j < 4) && (i < m))
    {
      paramStringBuilder.append((char)(decodeDigit(paramBitArray, arrayOfInt, i, L_PATTERNS) + 48));
      n = arrayOfInt.length;
      k = 0;
      while (k < n)
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
    return BarcodeFormat.EAN_8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.EAN8Reader
 * JD-Core Version:    0.7.0.1
 */