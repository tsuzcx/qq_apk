package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.HashMap;
import java.util.Map;

final class UPCEANExtension5Support
{
  private static final int[] CHECK_DIGIT_ENCODINGS = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] decodeMiddleCounters = new int[4];
  private final StringBuilder decodeRowStringBuffer = new StringBuilder();
  
  private int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
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
    for (int k = 0; (j < 5) && (i < n); k = m)
    {
      int i1 = UPCEANReader.decodeDigit(paramBitArray, arrayOfInt, i, UPCEANReader.L_AND_G_PATTERNS);
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
        m = k | 1 << 4 - j;
      }
      if (j != 4) {
        i = paramBitArray.getNextUnset(paramBitArray.getNextSet(i));
      }
      j += 1;
    }
    if (paramStringBuilder.length() == 5)
    {
      j = determineCheckDigit(k);
      if (extensionChecksum(paramStringBuilder.toString()) == j) {
        return i;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  private static int determineCheckDigit(int paramInt)
  {
    int i = 0;
    while (i < 10)
    {
      if (paramInt == CHECK_DIGIT_ENCODINGS[i]) {
        return i;
      }
      i += 1;
    }
    NotFoundException localNotFoundException = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw localNotFoundException;
    }
  }
  
  private static int extensionChecksum(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int i = k - 2;
    int j = 0;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    j *= 3;
    i = k - 1;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    return j * 3 % 10;
  }
  
  private static String parseExtension5String(String paramString)
  {
    int i = paramString.charAt(0);
    String str = "";
    if (i != 48)
    {
      if (i != 53)
      {
        if (i == 57)
        {
          if ("90000".equals(paramString)) {
            return null;
          }
          if ("99991".equals(paramString)) {
            return "0.00";
          }
          if ("99990".equals(paramString)) {
            return "Used";
          }
        }
      }
      else {
        str = "$";
      }
    }
    else {
      str = "£";
    }
    int j = Integer.parseInt(paramString.substring(1));
    i = j / 100;
    j %= 100;
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = String.valueOf(j);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append('.');
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static Map<ResultMetadataType, Object> parseExtensionString(String paramString)
  {
    if (paramString.length() != 5) {
      return null;
    }
    paramString = parseExtension5String(paramString);
    if (paramString == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(ResultMetadataType.SUGGESTED_PRICE, paramString);
    return localHashMap;
  }
  
  Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt)
  {
    Object localObject = this.decodeRowStringBuffer;
    ((StringBuilder)localObject).setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfInt, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    paramBitArray = parseExtensionString((String)localObject);
    float f1 = (paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F;
    float f2 = paramInt;
    paramArrayOfInt = new ResultPoint(f1, f2);
    ResultPoint localResultPoint = new ResultPoint(i, f2);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
    paramArrayOfInt = new Result((String)localObject, null, new ResultPoint[] { paramArrayOfInt, localResultPoint }, localBarcodeFormat);
    if (paramBitArray != null) {
      paramArrayOfInt.putAllMetadata(paramBitArray);
    }
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCEANExtension5Support
 * JD-Core Version:    0.7.0.1
 */