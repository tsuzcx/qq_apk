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
    int[] arrayOfInt1 = { 3, 2, 1, 1 };
    int[] arrayOfInt2 = { 2, 2, 2, 1 };
    int[] arrayOfInt3 = { 2, 1, 2, 2 };
    int[] arrayOfInt4 = { 1, 4, 1, 1 };
    int[] arrayOfInt5 = { 1, 1, 3, 2 };
    int[] arrayOfInt6 = { 1, 1, 1, 4 };
    int[] arrayOfInt7 = { 1, 3, 1, 2 };
    int[] arrayOfInt8 = { 1, 2, 1, 3 };
    L_PATTERNS = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 1, 2, 3, 1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 3, 1, 1, 2 } };
    L_AND_G_PATTERNS = new int[20][];
    System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
    int i = 10;
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
    if (i == 0) {}
    int j;
    do
    {
      return false;
      j = Character.digit(paramCharSequence.charAt(i - 1), 10);
    } while (getStandardUPCEANChecksum(paramCharSequence.subSequence(0, i - 1)) != j);
    return true;
  }
  
  static int decodeDigit(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    float f1 = 0.48F;
    int i = -1;
    int j = paramArrayOfInt1.length;
    paramInt = 0;
    if (paramInt < j)
    {
      float f2 = patternMatchVariance(paramArrayOfInt, paramArrayOfInt1[paramInt], 0.7F);
      if (f2 >= f1) {
        break label70;
      }
      i = paramInt;
      f1 = f2;
    }
    label70:
    for (;;)
    {
      paramInt += 1;
      break;
      if (i >= 0) {
        return i;
      }
      throw NotFoundException.getNotFoundInstance();
    }
  }
  
  static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return findGuardPattern(paramBitArray, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramBitArray.getSize();
    int n;
    int j;
    int i;
    label26:
    int k;
    if (paramBoolean)
    {
      paramInt = paramBitArray.getNextUnset(paramInt);
      n = paramArrayOfInt1.length;
      j = paramInt;
      i = 0;
      if (j >= m) {
        break label212;
      }
      if (paramBitArray.get(j) == paramBoolean) {
        break label87;
      }
      paramArrayOfInt2[i] += 1;
      k = i;
      i = paramInt;
    }
    for (;;)
    {
      j += 1;
      paramInt = i;
      i = k;
      break label26;
      paramInt = paramBitArray.getNextSet(paramInt);
      break;
      label87:
      if (i == n - 1)
      {
        if (patternMatchVariance(paramArrayOfInt2, paramArrayOfInt1, 0.7F) < 0.48F) {
          return new int[] { paramInt, j };
        }
        k = paramInt + (paramArrayOfInt2[0] + paramArrayOfInt2[1]);
        System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 1);
        paramArrayOfInt2[(i - 1)] = 0;
        paramArrayOfInt2[i] = 0;
        paramInt = i - 1;
        i = k;
      }
      for (;;)
      {
        paramArrayOfInt2[paramInt] = 1;
        if (paramBoolean) {
          break label204;
        }
        paramBoolean = true;
        k = paramInt;
        break;
        k = i + 1;
        i = paramInt;
        paramInt = k;
      }
      label204:
      paramBoolean = false;
      k = paramInt;
    }
    label212:
    throw NotFoundException.getNotFoundInstance();
  }
  
  static int[] findStartGuardPattern(BitArray paramBitArray)
  {
    int[] arrayOfInt2 = new int[START_END_PATTERN.length];
    int i = 0;
    Object localObject = null;
    boolean bool = false;
    while (!bool)
    {
      Arrays.fill(arrayOfInt2, 0, START_END_PATTERN.length, 0);
      int[] arrayOfInt1 = findGuardPattern(paramBitArray, i, false, START_END_PATTERN, arrayOfInt2);
      int k = arrayOfInt1[0];
      int j = arrayOfInt1[1];
      int m = k - (j - k);
      i = j;
      localObject = arrayOfInt1;
      if (m >= 0)
      {
        bool = paramBitArray.isRange(m, k, false);
        i = j;
        localObject = arrayOfInt1;
      }
    }
    return localObject;
  }
  
  static int getStandardUPCEANChecksum(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int i = k - 1;
    while (i >= 0)
    {
      int m = paramCharSequence.charAt(i) - '0';
      if ((m < 0) || (m > 9)) {
        throw FormatException.getFormatInstance();
      }
      j += m;
      i -= 2;
    }
    j *= 3;
    i = k - 2;
    while (i >= 0)
    {
      k = paramCharSequence.charAt(i) - '0';
      if ((k < 0) || (k > 9)) {
        throw FormatException.getFormatInstance();
      }
      j += k;
      i -= 2;
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
    if (paramMap == null) {}
    int i;
    int[] arrayOfInt;
    int j;
    for (Object localObject1 = null;; localObject1 = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
    {
      if (localObject1 != null) {
        ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
      }
      localObject2 = this.decodeRowStringBuffer;
      ((StringBuilder)localObject2).setLength(0);
      i = decodeMiddle(paramBitArray, paramArrayOfInt, (StringBuilder)localObject2);
      if (localObject1 != null) {
        ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint(i, paramInt));
      }
      arrayOfInt = decodeEnd(paramBitArray, i);
      if (localObject1 != null) {
        ((ResultPointCallback)localObject1).foundPossibleResultPoint(new ResultPoint((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt));
      }
      i = arrayOfInt[1];
      j = i - arrayOfInt[0] + i;
      if ((j < paramBitArray.getSize()) && (paramBitArray.isRange(i, j, false))) {
        break;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    localObject1 = ((StringBuilder)localObject2).toString();
    if (((String)localObject1).length() < 8) {
      throw FormatException.getFormatInstance();
    }
    if (!checkChecksum((String)localObject1)) {
      throw ChecksumException.getChecksumInstance();
    }
    float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
    float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
    Object localObject2 = getBarcodeFormat();
    paramArrayOfInt = new Result((String)localObject1, null, new ResultPoint[] { new ResultPoint(f1, paramInt), new ResultPoint(f2, paramInt) }, (BarcodeFormat)localObject2);
    try
    {
      paramBitArray = this.extensionReader.decodeRow(paramInt, paramBitArray, arrayOfInt[1]);
      paramArrayOfInt.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, paramBitArray.getText());
      paramArrayOfInt.putAllMetadata(paramBitArray.getResultMetadata());
      paramArrayOfInt.addResultPoints(paramBitArray.getResultPoints());
      paramInt = paramBitArray.getText().length();
      if (paramMap == null)
      {
        paramBitArray = null;
        if (paramBitArray == null) {
          break label435;
        }
        int k = 0;
        int m = paramBitArray.length;
        i = 0;
        j = k;
        if (i < m)
        {
          if (paramInt != paramBitArray[i]) {
            break label426;
          }
          j = 1;
        }
        if (j != 0) {
          break label435;
        }
        throw NotFoundException.getNotFoundInstance();
      }
    }
    catch (ReaderException paramBitArray)
    {
      for (;;)
      {
        paramInt = 0;
        continue;
        paramBitArray = (int[])paramMap.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
        continue;
        label426:
        i += 1;
      }
      label435:
      if ((localObject2 == BarcodeFormat.EAN_13) || (localObject2 == BarcodeFormat.UPC_A))
      {
        paramBitArray = this.eanManSupport.lookupCountryIdentifier((String)localObject1);
        if (paramBitArray != null) {
          paramArrayOfInt.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, paramBitArray);
        }
      }
    }
    return paramArrayOfInt;
  }
  
  abstract BarcodeFormat getBarcodeFormat();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
 * JD-Core Version:    0.7.0.1
 */