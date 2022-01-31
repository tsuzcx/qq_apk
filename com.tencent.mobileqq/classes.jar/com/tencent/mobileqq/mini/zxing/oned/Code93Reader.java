package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code93Reader
  extends OneDReader
{
  private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
  static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
  static final int[] CHARACTER_ENCODINGS = { 276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350 };
  private final int[] counters = new int[6];
  private final StringBuilder decodeRowResult = new StringBuilder(20);
  
  private static void checkChecksums(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    checkOneChecksum(paramCharSequence, i - 2, 20);
    checkOneChecksum(paramCharSequence, i - 1, 15);
  }
  
  private static void checkOneChecksum(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 1;
    int k = paramInt1 - 1;
    int m;
    int i1;
    for (int j = 0;; j = i1 * m + j)
    {
      m = i;
      if (k < 0) {
        break;
      }
      i1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(k));
      int n = m + 1;
      i = n;
      if (n > paramInt2) {
        i = 1;
      }
      k -= 1;
    }
    if (paramCharSequence.charAt(paramInt1) != ALPHABET[(j % 47)]) {
      throw ChecksumException.getChecksumInstance();
    }
  }
  
  private static String decodeExtended(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramCharSequence.charAt(i);
      int k;
      if ((c >= 'a') && (c <= 'd'))
      {
        if (i >= j - 1) {
          throw FormatException.getFormatInstance();
        }
        k = paramCharSequence.charAt(i + 1);
        switch (c)
        {
        default: 
          c = '\000';
          label98:
          localStringBuilder.append(c);
          i += 1;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((k >= 65) && (k <= 90))
        {
          c = (char)(k + 32);
          break label98;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 90))
        {
          c = (char)(k - 64);
          break label98;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 69))
        {
          c = (char)(k - 38);
          break label98;
        }
        if ((k >= 70) && (k <= 74))
        {
          c = (char)(k - 11);
          break label98;
        }
        if ((k >= 75) && (k <= 79))
        {
          c = (char)(k + 16);
          break label98;
        }
        if ((k >= 80) && (k <= 84))
        {
          c = (char)(k + 43);
          break label98;
        }
        if (k == 85)
        {
          c = '\000';
          break label98;
        }
        if (k == 86)
        {
          c = '@';
          break label98;
        }
        if (k == 87)
        {
          c = '`';
          break label98;
        }
        if ((k >= 88) && (k <= 90))
        {
          c = '';
          break label98;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 79))
        {
          c = (char)(k - 32);
          break label98;
        }
        if (k == 90)
        {
          c = ':';
          break label98;
        }
        throw FormatException.getFormatInstance();
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  private int[] findAsteriskPattern(BitArray paramBitArray)
  {
    int m = paramBitArray.getSize();
    int i = paramBitArray.getNextSet(0);
    Arrays.fill(this.counters, 0);
    int[] arrayOfInt = this.counters;
    int n = arrayOfInt.length;
    int k = i;
    int i1 = 0;
    int j = 0;
    if (k < m)
    {
      if (paramBitArray.get(k) != i1) {
        arrayOfInt[j] += 1;
      }
      for (;;)
      {
        k += 1;
        break;
        if (j == n - 1)
        {
          if (toPattern(arrayOfInt) == ASTERISK_ENCODING) {
            return new int[] { i, k };
          }
          i += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, j - 1);
          arrayOfInt[(j - 1)] = 0;
          arrayOfInt[j] = 0;
          j -= 1;
        }
        for (;;)
        {
          arrayOfInt[j] = 1;
          if (i1 != 0) {
            break label171;
          }
          i1 = 1;
          break;
          j += 1;
        }
        label171:
        i1 = 0;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static char patternToChar(int paramInt)
  {
    int i = 0;
    while (i < CHARACTER_ENCODINGS.length)
    {
      if (CHARACTER_ENCODINGS[i] == paramInt) {
        return ALPHABET[i];
      }
      i += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int toPattern(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    for (int k = 0; i < j; k = m + k)
    {
      m = paramArrayOfInt[i];
      i += 1;
    }
    int i1 = paramArrayOfInt.length;
    int m = 0;
    for (i = 0;; i = j)
    {
      j = i;
      int i2;
      if (m < i1)
      {
        i2 = Math.round(paramArrayOfInt[m] * 9.0F / k);
        if ((i2 < 1) || (i2 > 4)) {
          j = -1;
        }
      }
      else
      {
        return j;
      }
      if ((m & 0x1) == 0)
      {
        int n = 0;
        for (;;)
        {
          j = i;
          if (n >= i2) {
            break;
          }
          n += 1;
          i = i << 1 | 0x1;
        }
      }
      j = i << i2;
      m += 1;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    paramMap = findAsteriskPattern(paramBitArray);
    int i = paramBitArray.getNextSet(paramMap[1]);
    int n = paramBitArray.getSize();
    Object localObject1 = this.counters;
    Arrays.fill((int[])localObject1, 0);
    Object localObject2 = this.decodeRowResult;
    ((StringBuilder)localObject2).setLength(0);
    for (;;)
    {
      recordPattern(paramBitArray, i, (int[])localObject1);
      int j = toPattern((int[])localObject1);
      if (j < 0) {
        throw NotFoundException.getNotFoundInstance();
      }
      char c = patternToChar(j);
      ((StringBuilder)localObject2).append(c);
      int m = localObject1.length;
      j = 0;
      int k = i;
      while (j < m)
      {
        k += localObject1[j];
        j += 1;
      }
      m = paramBitArray.getNextSet(k);
      if (c == '*')
      {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        k = 0;
        int i1 = localObject1.length;
        j = 0;
        while (j < i1)
        {
          k += localObject1[j];
          j += 1;
        }
        if ((m == n) || (!paramBitArray.get(m))) {
          throw NotFoundException.getNotFoundInstance();
        }
        if (((StringBuilder)localObject2).length() < 2) {
          throw NotFoundException.getNotFoundInstance();
        }
        checkChecksums((CharSequence)localObject2);
        ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
        paramBitArray = decodeExtended((CharSequence)localObject2);
        float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
        float f2 = i;
        float f3 = k / 2.0F;
        paramMap = new ResultPoint(f1, paramInt);
        localObject1 = new ResultPoint(f2 + f3, paramInt);
        localObject2 = BarcodeFormat.CODE_93;
        return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
      }
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code93Reader
 * JD-Core Version:    0.7.0.1
 */