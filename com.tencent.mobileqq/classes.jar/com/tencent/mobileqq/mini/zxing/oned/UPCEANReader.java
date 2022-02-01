package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.ResultPointCallback;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader
  extends OneDReader
{
  static final int[] END_PATTERN;
  static final int[][] L_AND_G_PATTERNS;
  static final int[][] L_PATTERNS;
  private static final float MAX_AVG_VARIANCE = 0.48F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.7F;
  static final int[] MIDDLE_PATTERN;
  static final int[] START_END_PATTERN = { 1, 1, 1 };
  private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
  private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
  private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();
  
  static
  {
    MIDDLE_PATTERN = new int[] { 1, 1, 1, 1, 1 };
    END_PATTERN = new int[] { 1, 1, 1, 1, 1, 1 };
    int i = 10;
    int[] arrayOfInt1 = { 3, 2, 1, 1 };
    int[] arrayOfInt2 = { 2, 1, 2, 2 };
    int[] arrayOfInt3 = { 1, 1, 3, 2 };
    int[] arrayOfInt4 = { 1, 2, 3, 1 };
    int[] arrayOfInt5 = { 1, 1, 1, 4 };
    int[] arrayOfInt6 = { 1, 2, 1, 3 };
    int[] arrayOfInt7 = { 3, 1, 1, 2 };
    L_PATTERNS = new int[][] { arrayOfInt1, { 2, 2, 2, 1 }, arrayOfInt2, { 1, 4, 1, 1 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 1, 3, 1, 2 }, arrayOfInt6, arrayOfInt7 };
    L_AND_G_PATTERNS = new int[20][];
    System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
    while (i < 20)
    {
      arrayOfInt1 = L_PATTERNS[(i - 10)];
      arrayOfInt2 = new int[arrayOfInt1.length];
      int j = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[j] = arrayOfInt1[(arrayOfInt1.length - j - 1)];
        j += 1;
      }
      L_AND_G_PATTERNS[i] = arrayOfInt2;
      i += 1;
    }
  }
  
  static boolean checkStandardUPCEANChecksum(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    i -= 1;
    int j = Character.digit(paramCharSequence.charAt(i), 10);
    if (getStandardUPCEANChecksum(paramCharSequence.subSequence(0, i)) == j) {
      bool = true;
    }
    return bool;
  }
  
  static int decodeDigit(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    int j = paramArrayOfInt1.length;
    float f1 = 0.48F;
    int i = -1;
    paramInt = 0;
    while (paramInt < j)
    {
      float f3 = patternMatchVariance(paramArrayOfInt, paramArrayOfInt1[paramInt], 0.7F);
      float f2 = f1;
      if (f3 < f1)
      {
        i = paramInt;
        f2 = f3;
      }
      paramInt += 1;
      f1 = f2;
    }
    if (i >= 0) {
      return i;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return findGuardPattern(paramBitArray, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramBitArray.getSize();
    if (paramBoolean) {
      paramInt = paramBitArray.getNextUnset(paramInt);
    } else {
      paramInt = paramBitArray.getNextSet(paramInt);
    }
    int n = paramArrayOfInt1.length;
    int i = paramInt;
    int k = 0;
    int j = paramInt;
    paramInt = i;
    i = k;
    while (j < m)
    {
      boolean bool2 = paramBitArray.get(j);
      boolean bool1 = true;
      if (bool2 != paramBoolean)
      {
        paramArrayOfInt2[i] += 1;
        k = paramInt;
      }
      else
      {
        if (i == n - 1)
        {
          if (patternMatchVariance(paramArrayOfInt2, paramArrayOfInt1, 0.7F) < 0.48F) {
            return new int[] { paramInt, j };
          }
          k = paramInt + (paramArrayOfInt2[0] + paramArrayOfInt2[1]);
          paramInt = i - 1;
          System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, paramInt);
          paramArrayOfInt2[paramInt] = 0;
          paramArrayOfInt2[i] = 0;
          paramInt = i - 1;
          i = k;
        }
        else
        {
          k = i + 1;
          i = paramInt;
          paramInt = k;
        }
        paramArrayOfInt2[paramInt] = 1;
        if (!paramBoolean) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
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
  
  static int[] findStartGuardPattern(BitArray paramBitArray)
  {
    int[] arrayOfInt2 = new int[START_END_PATTERN.length];
    int[] arrayOfInt1 = null;
    boolean bool = false;
    int i = 0;
    while (!bool)
    {
      Arrays.fill(arrayOfInt2, 0, START_END_PATTERN.length, 0);
      arrayOfInt1 = findGuardPattern(paramBitArray, i, false, START_END_PATTERN, arrayOfInt2);
      int j = arrayOfInt1[0];
      i = arrayOfInt1[1];
      int k = j - (i - j);
      if (k >= 0) {
        bool = paramBitArray.isRange(k, j, false);
      }
    }
    return arrayOfInt1;
  }
  
  static int getStandardUPCEANChecksum(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int i = k - 1;
    int j = 0;
    while (i >= 0)
    {
      int m = paramCharSequence.charAt(i) - '0';
      if ((m >= 0) && (m <= 9))
      {
        j += m;
        i -= 2;
      }
      else
      {
        throw FormatException.getFormatInstance();
      }
    }
    j *= 3;
    i = k - 2;
    while (i >= 0)
    {
      k = paramCharSequence.charAt(i) - '0';
      if ((k >= 0) && (k <= 9))
      {
        j += k;
        i -= 2;
      }
      else
      {
        throw FormatException.getFormatInstance();
      }
    }
    return (1000 - j) % 10;
  }
  
  boolean checkChecksum(String paramString)
  {
    return checkStandardUPCEANChecksum(paramString);
  }
  
  int[] decodeEnd(BitArray paramBitArray, int paramInt)
  {
    return findGuardPattern(paramBitArray, paramInt, false, START_END_PATTERN);
  }
  
  protected abstract int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder);
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    return decodeRow(paramInt, paramBitArray, findStartGuardPattern(paramBitArray), paramMap);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramMap == null) {
      localObject1 = null;
    } else {
      localObject1 = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
    }
    int j = 1;
    if (localObject1 != null) {
      ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
    }
    Object localObject3 = this.decodeRowStringBuffer;
    ((StringBuilder)localObject3).setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfInt, (StringBuilder)localObject3);
    if (localObject1 != null) {
      ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint(i, paramInt));
    }
    int[] arrayOfInt = decodeEnd(paramBitArray, i);
    if (localObject1 != null) {
      ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt));
    }
    i = arrayOfInt[1];
    int k = i - arrayOfInt[0] + i;
    if ((k < paramBitArray.getSize()) && (paramBitArray.isRange(i, k, false)))
    {
      localObject1 = ((StringBuilder)localObject3).toString();
      if (((String)localObject1).length() >= 8) {
        if (checkChecksum((String)localObject1))
        {
          float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
          float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
          localObject3 = getBarcodeFormat();
          float f3 = paramInt;
          paramArrayOfInt = new Result((String)localObject1, null, new ResultPoint[] { new ResultPoint(f1, f3), new ResultPoint(f2, f3) }, (BarcodeFormat)localObject3);
        }
      }
    }
    try
    {
      paramBitArray = this.extensionReader.decodeRow(paramInt, paramBitArray, arrayOfInt[1]);
      paramArrayOfInt.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, paramBitArray.getText());
      paramArrayOfInt.putAllMetadata(paramBitArray.getResultMetadata());
      paramArrayOfInt.addResultPoints(paramBitArray.getResultPoints());
      paramInt = paramBitArray.getText().length();
    }
    catch (ReaderException paramBitArray)
    {
      label349:
      break label349;
    }
    paramInt = 0;
    if (paramMap == null) {
      paramBitArray = localObject2;
    } else {
      paramBitArray = (int[])paramMap.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
    }
    if (paramBitArray != null)
    {
      k = paramBitArray.length;
      i = 0;
      while (i < k)
      {
        if (paramInt == paramBitArray[i])
        {
          paramInt = j;
          break label422;
        }
        i += 1;
      }
      paramInt = 0;
      label422:
      if (paramInt == 0) {
        throw NotFoundException.getNotFoundInstance();
      }
    }
    if ((localObject3 == BarcodeFormat.EAN_13) || (localObject3 == BarcodeFormat.UPC_A))
    {
      paramBitArray = this.eanManSupport.lookupCountryIdentifier((String)localObject1);
      if (paramBitArray != null) {
        paramArrayOfInt.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, paramBitArray);
      }
    }
    return paramArrayOfInt;
    throw ChecksumException.getChecksumInstance();
    throw FormatException.getFormatInstance();
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  abstract BarcodeFormat getBarcodeFormat();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
 * JD-Core Version:    0.7.0.1
 */