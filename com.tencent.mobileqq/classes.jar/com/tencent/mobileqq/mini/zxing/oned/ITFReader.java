package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader
  extends OneDReader
{
  private static final int[] DEFAULT_ALLOWED_LENGTHS = { 6, 8, 10, 12, 14 };
  private static final int[][] END_PATTERN_REVERSED;
  private static final float MAX_AVG_VARIANCE = 0.38F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.5F;
  private static final int N = 1;
  private static final int[][] PATTERNS;
  private static final int[] START_PATTERN = { 1, 1, 1, 1 };
  private static final int W = 3;
  private static final int w = 2;
  private int narrowLineWidth = -1;
  
  static
  {
    END_PATTERN_REVERSED = new int[][] { { 1, 1, 2 }, { 1, 1, 3 } };
    int[] arrayOfInt1 = { 1, 1, 2, 2, 1 };
    int[] arrayOfInt2 = { 3, 1, 1, 3, 1 };
    PATTERNS = new int[][] { arrayOfInt1, { 2, 1, 1, 1, 2 }, { 1, 2, 1, 1, 2 }, { 2, 2, 1, 1, 1 }, { 1, 1, 2, 1, 2 }, { 2, 1, 2, 1, 1 }, { 1, 2, 2, 1, 1 }, { 1, 1, 1, 2, 2 }, { 2, 1, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, arrayOfInt2, { 1, 3, 1, 3, 1 } };
  }
  
  private static int decodeDigit(int[] paramArrayOfInt)
  {
    int k = PATTERNS.length;
    int i = 0;
    int j = -1;
    float f2;
    for (float f1 = 0.38F; i < k; f1 = f2)
    {
      float f3 = patternMatchVariance(paramArrayOfInt, PATTERNS[i], 0.5F);
      if (f3 < f1)
      {
        j = i;
        f2 = f3;
      }
      else
      {
        f2 = f1;
        if (f3 == f1)
        {
          j = -1;
          f2 = f1;
        }
      }
      i += 1;
    }
    if (j >= 0) {
      return j % 10;
    }
    paramArrayOfInt = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  private int[] decodeEnd(BitArray paramBitArray)
  {
    paramBitArray.reverse();
    try
    {
      i = skipWhiteSpace(paramBitArray);
    }
    finally
    {
      int i;
      int[] arrayOfInt;
      label23:
      paramBitArray.reverse();
    }
    try
    {
      arrayOfInt = findGuardPattern(paramBitArray, i, END_PATTERN_REVERSED[0]);
    }
    catch (NotFoundException localNotFoundException)
    {
      break label23;
    }
    arrayOfInt = findGuardPattern(paramBitArray, i, END_PATTERN_REVERSED[1]);
    validateQuietZone(paramBitArray, arrayOfInt[0]);
    i = arrayOfInt[0];
    arrayOfInt[0] = (paramBitArray.getSize() - arrayOfInt[1]);
    arrayOfInt[1] = (paramBitArray.getSize() - i);
    paramBitArray.reverse();
    return arrayOfInt;
  }
  
  private static void decodeMiddle(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    if (paramInt1 < paramInt2)
    {
      recordPattern(paramBitArray, paramInt1, arrayOfInt1);
      int k = 0;
      int i = 0;
      while (i < 5)
      {
        j = i * 2;
        arrayOfInt2[i] = arrayOfInt1[j];
        arrayOfInt3[i] = arrayOfInt1[(j + 1)];
        i += 1;
      }
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt2) + 48));
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt3) + 48));
      int m = arrayOfInt1.length;
      int j = paramInt1;
      i = k;
      for (;;)
      {
        paramInt1 = j;
        if (i >= m) {
          break;
        }
        j += arrayOfInt1[i];
        i += 1;
      }
    }
  }
  
  private int[] decodeStart(BitArray paramBitArray)
  {
    int[] arrayOfInt = findGuardPattern(paramBitArray, skipWhiteSpace(paramBitArray), START_PATTERN);
    this.narrowLineWidth = ((arrayOfInt[1] - arrayOfInt[0]) / 4);
    validateQuietZone(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int m = paramArrayOfInt.length;
    int[] arrayOfInt = new int[m];
    int n = paramBitArray.getSize();
    int i = paramInt;
    int i1 = 0;
    int k = 0;
    int j = paramInt;
    paramInt = i;
    i = k;
    while (j < n)
    {
      if (paramBitArray.get(j) != i1)
      {
        arrayOfInt[i] += 1;
        k = paramInt;
      }
      else
      {
        if (i == m - 1)
        {
          if (patternMatchVariance(arrayOfInt, paramArrayOfInt, 0.5F) < 0.38F) {
            return new int[] { paramInt, j };
          }
          k = paramInt + (arrayOfInt[0] + arrayOfInt[1]);
          paramInt = i - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, paramInt);
          arrayOfInt[paramInt] = 0;
          arrayOfInt[i] = 0;
          paramInt = i - 1;
          i = k;
        }
        else
        {
          k = i + 1;
          i = paramInt;
          paramInt = k;
        }
        arrayOfInt[paramInt] = 1;
        i1 ^= 0x1;
        k = i;
        i = paramInt;
      }
      j += 1;
      paramInt = k;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  private static int skipWhiteSpace(BitArray paramBitArray)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    if (j != i) {
      return j;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void validateQuietZone(BitArray paramBitArray, int paramInt)
  {
    int i = this.narrowLineWidth * 10;
    if (i >= paramInt) {
      i = paramInt;
    }
    paramInt -= 1;
    while ((i > 0) && (paramInt >= 0) && (!paramBitArray.get(paramInt)))
    {
      i -= 1;
      paramInt -= 1;
    }
    if (i == 0) {
      return;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt = decodeStart(paramBitArray);
    Object localObject1 = decodeEnd(paramBitArray);
    Object localObject2 = new StringBuilder(20);
    decodeMiddle(paramBitArray, arrayOfInt[1], localObject1[0], (StringBuilder)localObject2);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramMap != null) {
      paramBitArray = (int[])paramMap.get(DecodeHintType.ALLOWED_LENGTHS);
    } else {
      paramBitArray = null;
    }
    paramMap = paramBitArray;
    if (paramBitArray == null) {
      paramMap = DEFAULT_ALLOWED_LENGTHS;
    }
    int n = ((String)localObject2).length();
    int i1 = paramMap.length;
    int i = 0;
    for (int j = 0; i < i1; j = k)
    {
      int m = paramMap[i];
      if (n == m)
      {
        i = 1;
        break label155;
      }
      k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
    }
    i = 0;
    label155:
    int k = i;
    if (i == 0)
    {
      k = i;
      if (n > j) {
        k = 1;
      }
    }
    if (k != 0)
    {
      float f1 = arrayOfInt[1];
      float f2 = paramInt;
      paramBitArray = new ResultPoint(f1, f2);
      paramMap = new ResultPoint(localObject1[0], f2);
      localObject1 = BarcodeFormat.ITF;
      return new Result((String)localObject2, null, new ResultPoint[] { paramBitArray, paramMap }, (BarcodeFormat)localObject1);
    }
    paramBitArray = FormatException.getFormatInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.ITFReader
 * JD-Core Version:    0.7.0.1
 */