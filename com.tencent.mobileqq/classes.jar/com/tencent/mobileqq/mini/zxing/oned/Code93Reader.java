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
    int j = paramInt1 - 1;
    int k = 0;
    int i = 1;
    while (j >= 0)
    {
      k += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(j)) * i;
      int m = i + 1;
      i = m;
      if (m > paramInt2) {
        i = 1;
      }
      j -= 1;
    }
    if (paramCharSequence.charAt(paramInt1) == ALPHABET[(k % 47)]) {
      return;
    }
    paramCharSequence = ChecksumException.getChecksumInstance();
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  private static String decodeExtended(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(k);
    int i = 0;
    while (i < k)
    {
      char c = paramCharSequence.charAt(i);
      if ((c >= 'a') && (c <= 'd'))
      {
        if (i < k - 1)
        {
          int j = i + 1;
          i = paramCharSequence.charAt(j);
          switch (c)
          {
          default: 
          case 'd': 
          case 'c': 
          case 'b': 
            do
            {
              c = '\000';
              break label327;
              if ((i >= 65) && (i <= 90))
              {
                i += 32;
                break;
              }
              throw FormatException.getFormatInstance();
              if ((i >= 65) && (i <= 79))
              {
                i -= 32;
                break;
              }
              if (i == 90)
              {
                c = ':';
                break label327;
              }
              throw FormatException.getFormatInstance();
              if ((i >= 65) && (i <= 69))
              {
                i -= 38;
                break;
              }
              if ((i >= 70) && (i <= 74))
              {
                i -= 11;
                break;
              }
              if ((i >= 75) && (i <= 79))
              {
                i += 16;
                break;
              }
              if ((i >= 80) && (i <= 84))
              {
                i += 43;
                break;
              }
            } while (i == 85);
            if (i == 86) {
              c = '@';
            } else if (i == 87) {
              c = '`';
            } else if ((i >= 88) && (i <= 90)) {
              c = '';
            } else {
              throw FormatException.getFormatInstance();
            }
            break;
          case 'a': 
            if ((i >= 65) && (i <= 90))
            {
              i -= 64;
              c = (char)i;
            }
            else
            {
              throw FormatException.getFormatInstance();
            }
            break;
          }
          label327:
          localStringBuilder.append(c);
          i = j;
        }
        else
        {
          throw FormatException.getFormatInstance();
        }
      }
      else {
        localStringBuilder.append(c);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private int[] findAsteriskPattern(BitArray paramBitArray)
  {
    int n = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    Arrays.fill(this.counters, 0);
    int[] arrayOfInt = this.counters;
    int i1 = arrayOfInt.length;
    int i = k;
    int i2 = 0;
    int j = 0;
    while (k < n)
    {
      int m;
      if (paramBitArray.get(k) != i2)
      {
        arrayOfInt[j] += 1;
        m = i;
      }
      else
      {
        if (j == i1 - 1)
        {
          if (toPattern(arrayOfInt) == ASTERISK_ENCODING) {
            return new int[] { i, k };
          }
          m = i + (arrayOfInt[0] + arrayOfInt[1]);
          i = j - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[j] = 0;
          i = j - 1;
          j = m;
        }
        else
        {
          m = j + 1;
          j = i;
          i = m;
        }
        arrayOfInt[i] = 1;
        i2 ^= 0x1;
        m = j;
        j = i;
      }
      k += 1;
      i = m;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  private static char patternToChar(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = CHARACTER_ENCODINGS;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] == paramInt) {
        return ALPHABET[i];
      }
      i += 1;
    }
    Object localObject = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private static int toPattern(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    int n = paramArrayOfInt.length;
    k = 0;
    i = 0;
    while (k < n)
    {
      int i1 = Math.round(paramArrayOfInt[k] * 9.0F / j);
      if ((i1 >= 1) && (i1 <= 4))
      {
        if ((k & 0x1) == 0)
        {
          int m = 0;
          while (m < i1)
          {
            i = i << 1 | 0x1;
            m += 1;
          }
        }
        else
        {
          i <<= i1;
        }
        k += 1;
      }
      else
      {
        return -1;
      }
    }
    return i;
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
        break;
      }
      char c = patternToChar(j);
      ((StringBuilder)localObject2).append(c);
      int m = localObject1.length;
      int k = i;
      j = 0;
      while (j < m)
      {
        k += localObject1[j];
        j += 1;
      }
      m = paramBitArray.getNextSet(k);
      if (c == '*')
      {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        int i1 = localObject1.length;
        j = 0;
        k = 0;
        while (j < i1)
        {
          k += localObject1[j];
          j += 1;
        }
        if ((m != n) && (paramBitArray.get(m)))
        {
          if (((StringBuilder)localObject2).length() >= 2)
          {
            checkChecksums((CharSequence)localObject2);
            ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
            paramBitArray = decodeExtended((CharSequence)localObject2);
            float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
            float f2 = i;
            float f3 = k / 2.0F;
            float f4 = paramInt;
            paramMap = new ResultPoint(f1, f4);
            localObject1 = new ResultPoint(f2 + f3, f4);
            localObject2 = BarcodeFormat.CODE_93;
            return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
          }
          throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
      }
      i = m;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code93Reader
 * JD-Core Version:    0.7.0.1
 */