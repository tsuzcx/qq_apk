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
    int[] arrayOfInt1 = { 2, 2, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 1, 2, 1, 2 };
    int[] arrayOfInt3 = { 1, 1, 3, 3, 1 };
    int[] arrayOfInt4 = { 1, 3, 3, 1, 1 };
    PATTERNS = new int[][] { { 1, 1, 2, 2, 1 }, { 2, 1, 1, 1, 2 }, { 1, 2, 1, 1, 2 }, arrayOfInt1, arrayOfInt2, { 2, 1, 2, 1, 1 }, { 1, 2, 2, 1, 1 }, { 1, 1, 1, 2, 2 }, { 2, 1, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, arrayOfInt3, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, arrayOfInt4, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  }
  
  private static int decodeDigit(int[] paramArrayOfInt)
  {
    float f1 = 0.38F;
    int k = PATTERNS.length;
    int i = 0;
    int j = -1;
    float f2;
    if (i < k)
    {
      f2 = patternMatchVariance(paramArrayOfInt, PATTERNS[i], 0.5F);
      if (f2 < f1)
      {
        j = i;
        f1 = f2;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (f2 == f1)
      {
        j = -1;
        continue;
        if (j >= 0) {
          return j % 10;
        }
        throw NotFoundException.getNotFoundInstance();
      }
    }
  }
  
  /* Error */
  private int[] decodeEnd(BitArray paramBitArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 59	com/tencent/mobileqq/mini/zxing/common/BitArray:reverse	()V
    //   4: aload_1
    //   5: invokestatic 63	com/tencent/mobileqq/mini/zxing/oned/ITFReader:skipWhiteSpace	(Lcom/tencent/mobileqq/mini/zxing/common/BitArray;)I
    //   8: istore_2
    //   9: aload_1
    //   10: iload_2
    //   11: getstatic 32	com/tencent/mobileqq/mini/zxing/oned/ITFReader:END_PATTERN_REVERSED	[[I
    //   14: iconst_0
    //   15: aaload
    //   16: invokestatic 67	com/tencent/mobileqq/mini/zxing/oned/ITFReader:findGuardPattern	(Lcom/tencent/mobileqq/mini/zxing/common/BitArray;I[I)[I
    //   19: astore_3
    //   20: aload_0
    //   21: aload_1
    //   22: aload_3
    //   23: iconst_0
    //   24: iaload
    //   25: invokespecial 71	com/tencent/mobileqq/mini/zxing/oned/ITFReader:validateQuietZone	(Lcom/tencent/mobileqq/mini/zxing/common/BitArray;I)V
    //   28: aload_3
    //   29: iconst_0
    //   30: iaload
    //   31: istore_2
    //   32: aload_3
    //   33: iconst_0
    //   34: aload_1
    //   35: invokevirtual 75	com/tencent/mobileqq/mini/zxing/common/BitArray:getSize	()I
    //   38: aload_3
    //   39: iconst_1
    //   40: iaload
    //   41: isub
    //   42: iastore
    //   43: aload_3
    //   44: iconst_1
    //   45: aload_1
    //   46: invokevirtual 75	com/tencent/mobileqq/mini/zxing/common/BitArray:getSize	()I
    //   49: iload_2
    //   50: isub
    //   51: iastore
    //   52: aload_1
    //   53: invokevirtual 59	com/tencent/mobileqq/mini/zxing/common/BitArray:reverse	()V
    //   56: aload_3
    //   57: areturn
    //   58: astore_3
    //   59: aload_1
    //   60: iload_2
    //   61: getstatic 32	com/tencent/mobileqq/mini/zxing/oned/ITFReader:END_PATTERN_REVERSED	[[I
    //   64: iconst_1
    //   65: aaload
    //   66: invokestatic 67	com/tencent/mobileqq/mini/zxing/oned/ITFReader:findGuardPattern	(Lcom/tencent/mobileqq/mini/zxing/common/BitArray;I[I)[I
    //   69: astore_3
    //   70: goto -50 -> 20
    //   73: astore_3
    //   74: aload_1
    //   75: invokevirtual 59	com/tencent/mobileqq/mini/zxing/common/BitArray:reverse	()V
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ITFReader
    //   0	80	1	paramBitArray	BitArray
    //   8	53	2	i	int
    //   19	38	3	arrayOfInt1	int[]
    //   58	1	3	localNotFoundException	NotFoundException
    //   69	1	3	arrayOfInt2	int[]
    //   73	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	20	58	com/tencent/mobileqq/mini/zxing/NotFoundException
    //   4	9	73	finally
    //   9	20	73	finally
    //   20	28	73	finally
    //   32	52	73	finally
    //   59	70	73	finally
  }
  
  private static void decodeMiddle(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    while (paramInt1 < paramInt2)
    {
      recordPattern(paramBitArray, paramInt1, arrayOfInt1);
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
      int j = arrayOfInt1.length;
      i = 0;
      while (i < j)
      {
        paramInt1 += arrayOfInt1[i];
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
    int k = paramInt;
    int i = 0;
    int i1 = 0;
    int j = paramInt;
    paramInt = k;
    if (j < n)
    {
      if (paramBitArray.get(j) != i1)
      {
        arrayOfInt[i] += 1;
        k = i;
        i = paramInt;
      }
      for (;;)
      {
        j += 1;
        paramInt = i;
        i = k;
        break;
        if (i == m - 1)
        {
          if (patternMatchVariance(arrayOfInt, paramArrayOfInt, 0.5F) < 0.38F) {
            return new int[] { paramInt, j };
          }
          k = paramInt + (arrayOfInt[0] + arrayOfInt[1]);
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i - 1);
          arrayOfInt[(i - 1)] = 0;
          arrayOfInt[i] = 0;
          paramInt = i - 1;
          i = k;
        }
        for (;;)
        {
          arrayOfInt[paramInt] = 1;
          if (i1 != 0) {
            break label188;
          }
          i1 = 1;
          k = paramInt;
          break;
          k = i + 1;
          i = paramInt;
          paramInt = k;
        }
        label188:
        i1 = 0;
        k = paramInt;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int skipWhiteSpace(BitArray paramBitArray)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    if (j == i) {
      throw NotFoundException.getNotFoundInstance();
    }
    return j;
  }
  
  private void validateQuietZone(BitArray paramBitArray, int paramInt)
  {
    int i = this.narrowLineWidth * 10;
    if (i < paramInt) {
      paramInt -= 1;
    }
    for (;;)
    {
      if ((i <= 0) || (paramInt < 0) || (paramBitArray.get(paramInt)))
      {
        if (i == 0) {
          return;
        }
        throw NotFoundException.getNotFoundInstance();
        i = paramInt;
        break;
      }
      i -= 1;
      paramInt -= 1;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt = decodeStart(paramBitArray);
    Object localObject1 = decodeEnd(paramBitArray);
    Object localObject2 = new StringBuilder(20);
    decodeMiddle(paramBitArray, arrayOfInt[1], localObject1[0], (StringBuilder)localObject2);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramMap != null) {}
    for (paramBitArray = (int[])paramMap.get(DecodeHintType.ALLOWED_LENGTHS);; paramBitArray = null)
    {
      paramMap = paramBitArray;
      if (paramBitArray == null) {
        paramMap = DEFAULT_ALLOWED_LENGTHS;
      }
      int m = ((String)localObject2).length();
      int n = paramMap.length;
      int j = 0;
      int i = 0;
      int k;
      if (j < n)
      {
        k = paramMap[j];
        if (m != k) {}
      }
      for (j = 1;; j = 0)
      {
        k = j;
        if (j == 0)
        {
          k = j;
          if (m > i) {
            k = 1;
          }
        }
        if (k == 0)
        {
          throw FormatException.getFormatInstance();
          if (k <= i) {
            break label228;
          }
          i = k;
        }
        label228:
        for (;;)
        {
          j += 1;
          break;
          paramBitArray = new ResultPoint(arrayOfInt[1], paramInt);
          paramMap = new ResultPoint(localObject1[0], paramInt);
          localObject1 = BarcodeFormat.ITF;
          return new Result((String)localObject2, null, new ResultPoint[] { paramBitArray, paramMap }, (BarcodeFormat)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.ITFReader
 * JD-Core Version:    0.7.0.1
 */