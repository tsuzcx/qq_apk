package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Reader;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Lcom.tencent.mobileqq.mini.zxing.DecodeHintType;*>;

public abstract class OneDReader
  implements Reader
{
  private Result doDecode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    int k = paramBinaryBitmap.getWidth();
    int m = paramBinaryBitmap.getHeight();
    Object localObject = new BitArray(k);
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = 8;
    } else {
      j = 5;
    }
    int i2 = Math.max(1, m >> j);
    if (i != 0) {
      j = m;
    } else {
      j = 15;
    }
    int i3 = m / 2;
    int n = 0;
    int i = k;
    for (k = n; k < j; k = n)
    {
      n = k + 1;
      int i1 = n / 2;
      if ((k & 0x1) == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        k = i1;
      } else {
        k = -i1;
      }
      i1 = k * i2 + i3;
      if ((i1 < 0) || (i1 >= m)) {
        break;
      }
      for (;;)
      {
        try
        {
          localBitArray = paramBinaryBitmap.getBlackRow(i1, (BitArray)localObject);
          k = 0;
          if (k < 2)
          {
            localObject = paramMap;
            if (k == 1)
            {
              localBitArray.reverse();
              localObject = paramMap;
              if (paramMap != null)
              {
                localObject = paramMap;
                if (paramMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
                {
                  localObject = new HashMap();
                  ((Map)localObject).putAll(paramMap);
                  ((Map)localObject).remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                }
              }
            }
          }
        }
        catch (NotFoundException localNotFoundException)
        {
          BitArray localBitArray;
          ResultPoint[] arrayOfResultPoint;
          float f1;
          float f2;
          continue;
        }
        try
        {
          paramMap = decodeRow(i1, localBitArray, (Map)localObject);
          if (k == 1)
          {
            paramMap.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
            arrayOfResultPoint = paramMap.getResultPoints();
            if (arrayOfResultPoint != null)
            {
              f1 = i;
              f2 = arrayOfResultPoint[0].getX();
            }
          }
        }
        catch (ReaderException paramMap)
        {
          continue;
        }
        try
        {
          arrayOfResultPoint[0] = new ResultPoint(f1 - f2 - 1.0F, arrayOfResultPoint[0].getY());
        }
        catch (ReaderException paramMap)
        {
          continue;
        }
        try
        {
          arrayOfResultPoint[1] = new ResultPoint(f1 - arrayOfResultPoint[1].getX() - 1.0F, arrayOfResultPoint[1].getY());
          return paramMap;
        }
        catch (ReaderException paramMap)
        {
          continue;
        }
        k += 1;
        paramMap = (Map<DecodeHintType, ?>)localObject;
      }
      localObject = localBitArray;
    }
    paramBinaryBitmap = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBinaryBitmap;
    }
  }
  
  protected static float patternMatchVariance(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat)
  {
    int n = paramArrayOfInt1.length;
    int m = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < n)
    {
      k += paramArrayOfInt1[j];
      i += paramArrayOfInt2[j];
      j += 1;
    }
    if (k < i) {
      return (1.0F / 1.0F);
    }
    float f3 = k;
    float f4 = f3 / i;
    float f1 = 0.0F;
    i = m;
    while (i < n)
    {
      j = paramArrayOfInt1[i];
      float f2 = paramArrayOfInt2[i] * f4;
      float f5 = j;
      if (f5 > f2) {
        f2 = f5 - f2;
      } else {
        f2 -= f5;
      }
      if (f2 > paramFloat * f4) {
        return (1.0F / 1.0F);
      }
      f1 += f2;
      i += 1;
    }
    return f1 / f3;
  }
  
  protected static void recordPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, k, 0);
    int m = paramBitArray.getSize();
    if (paramInt < m)
    {
      boolean bool = paramBitArray.get(paramInt) ^ true;
      int j = 0;
      int i = paramInt;
      paramInt = j;
      for (;;)
      {
        j = paramInt;
        if (i >= m) {
          break;
        }
        if (paramBitArray.get(i) != bool)
        {
          paramArrayOfInt[paramInt] += 1;
        }
        else
        {
          paramInt += 1;
          if (paramInt == k)
          {
            j = paramInt;
            break;
          }
          paramArrayOfInt[paramInt] = 1;
          if (!bool) {
            bool = true;
          } else {
            bool = false;
          }
        }
        i += 1;
      }
      if (j != k)
      {
        if ((j == k - 1) && (i == m)) {
          return;
        }
        throw NotFoundException.getNotFoundInstance();
      }
      return;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  protected static void recordPatternInReverse(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    boolean bool = paramBitArray.get(paramInt);
    while ((paramInt > 0) && (i >= 0))
    {
      int j = paramInt - 1;
      paramInt = j;
      if (paramBitArray.get(j) != bool)
      {
        i -= 1;
        if (!bool)
        {
          bool = true;
          paramInt = j;
        }
        else
        {
          bool = false;
          paramInt = j;
        }
      }
    }
    if (i < 0)
    {
      recordPattern(paramBitArray, paramInt + 1, paramArrayOfInt);
      return;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    Object localObject;
    try
    {
      Result localResult = doDecode(paramBinaryBitmap, paramMap);
      return localResult;
    }
    catch (NotFoundException localNotFoundException)
    {
      int j = 0;
      int i;
      if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (paramBinaryBitmap.isRotateSupported()))
      {
        paramBinaryBitmap = paramBinaryBitmap.rotateCounterClockwise();
        paramMap = doDecode(paramBinaryBitmap, paramMap);
        localObject = paramMap.getResultMetadata();
        int k = 270;
        i = k;
        if (localObject != null)
        {
          i = k;
          if (((Map)localObject).containsKey(ResultMetadataType.ORIENTATION)) {
            i = (((Integer)((Map)localObject).get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
          }
        }
        paramMap.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
        localObject = paramMap.getResultPoints();
        if (localObject != null)
        {
          k = paramBinaryBitmap.getHeight();
          i = j;
          while (i < localObject.length)
          {
            localObject[i] = new ResultPoint(k - localObject[i].getY() - 1.0F, localObject[i].getX());
            i += 1;
          }
        }
        return paramMap;
      }
    }
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public abstract Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap);
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.OneDReader
 * JD-Core Version:    0.7.0.1
 */