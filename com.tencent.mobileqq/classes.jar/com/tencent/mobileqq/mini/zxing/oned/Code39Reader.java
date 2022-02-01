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

public final class Code39Reader
  extends OneDReader
{
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
  static final int ASTERISK_ENCODING = 148;
  static final int[] CHARACTER_ENCODINGS = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42 };
  private final int[] counters;
  private final StringBuilder decodeRowResult;
  private final boolean extendedMode;
  private final boolean usingCheckDigit;
  
  public Code39Reader()
  {
    this(false);
  }
  
  public Code39Reader(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }
  
  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.usingCheckDigit = paramBoolean1;
    this.extendedMode = paramBoolean2;
    this.decodeRowResult = new StringBuilder(20);
    this.counters = new int[9];
  }
  
  private static String decodeExtended(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(k);
    int i = 0;
    while (i < k)
    {
      char c = paramCharSequence.charAt(i);
      if ((c != '+') && (c != '$') && (c != '%') && (c != '/'))
      {
        localStringBuilder.append(c);
      }
      else
      {
        int j = i + 1;
        i = paramCharSequence.charAt(j);
        if (c != '$')
        {
          if (c != '%') {
            if (c != '+') {
              if (c == '/') {}
            }
          }
          do
          {
            c = '\000';
            break label337;
            if ((i >= 65) && (i <= 79))
            {
              i -= 32;
              break;
            }
            if (i == 90)
            {
              c = ':';
              break label337;
            }
            throw FormatException.getFormatInstance();
            if ((i >= 65) && (i <= 90))
            {
              i += 32;
              break;
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
          if (i == 86)
          {
            c = '@';
          }
          else if (i == 87)
          {
            c = '`';
          }
          else
          {
            if ((i != 88) && (i != 89) && (i != 90)) {
              throw FormatException.getFormatInstance();
            }
            c = '';
          }
        }
        else
        {
          if ((i < 65) || (i > 90)) {
            break label353;
          }
          i -= 64;
          c = (char)i;
        }
        label337:
        localStringBuilder.append(c);
        i = j;
      }
      i += 1;
      continue;
      label353:
      throw FormatException.getFormatInstance();
    }
    return localStringBuilder.toString();
  }
  
  private static int[] findAsteriskPattern(BitArray paramBitArray, int[] paramArrayOfInt)
  {
    int n = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    int i1 = paramArrayOfInt.length;
    int i = k;
    int i2 = 0;
    int j = 0;
    while (k < n)
    {
      int m;
      if (paramBitArray.get(k) != i2)
      {
        paramArrayOfInt[j] += 1;
        m = i;
      }
      else
      {
        if (j == i1 - 1)
        {
          if ((toNarrowWidePattern(paramArrayOfInt) == 148) && (paramBitArray.isRange(Math.max(0, i - (k - i) / 2), i, false))) {
            return new int[] { i, k };
          }
          m = i + (paramArrayOfInt[0] + paramArrayOfInt[1]);
          i = j - 1;
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, i);
          paramArrayOfInt[i] = 0;
          paramArrayOfInt[j] = 0;
          i = j - 1;
          j = m;
        }
        else
        {
          m = j + 1;
          j = i;
          i = m;
        }
        paramArrayOfInt[i] = 1;
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
        return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i);
      }
      i += 1;
    }
    if (paramInt == 148) {
      return '*';
    }
    Object localObject = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private static int toNarrowWidePattern(int[] paramArrayOfInt)
  {
    int i5 = paramArrayOfInt.length;
    int i4 = 0;
    int i;
    for (int j = 0;; j = i)
    {
      int i1 = paramArrayOfInt.length;
      int k = 0;
      for (i = 2147483647; k < i1; i = m)
      {
        n = paramArrayOfInt[k];
        m = i;
        if (n < i)
        {
          m = i;
          if (n > j) {
            m = n;
          }
        }
        k += 1;
      }
      int n = 0;
      j = 0;
      int m = 0;
      int i2;
      for (k = 0; n < i5; k = i1)
      {
        int i6 = paramArrayOfInt[n];
        int i3 = j;
        i2 = m;
        i1 = k;
        if (i6 > i)
        {
          i2 = m | 1 << i5 - 1 - n;
          i3 = j + 1;
          i1 = k + i6;
        }
        n += 1;
        j = i3;
        m = i2;
      }
      if (j == 3)
      {
        n = j;
        j = i4;
        while ((j < i5) && (n > 0))
        {
          i2 = paramArrayOfInt[j];
          i1 = n;
          if (i2 > i)
          {
            i1 = n - 1;
            if (i2 * 2 >= k) {
              return -1;
            }
          }
          j += 1;
          n = i1;
        }
        return m;
      }
      if (j <= 3) {
        return -1;
      }
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    Object localObject1 = this.counters;
    Arrays.fill((int[])localObject1, 0);
    Object localObject2 = this.decodeRowResult;
    ((StringBuilder)localObject2).setLength(0);
    paramMap = findAsteriskPattern(paramBitArray, (int[])localObject1);
    int i = paramBitArray.getNextSet(paramMap[1]);
    int n = paramBitArray.getSize();
    for (;;)
    {
      recordPattern(paramBitArray, i, (int[])localObject1);
      int j = toNarrowWidePattern((int[])localObject1);
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
        ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 1);
        int i1 = localObject1.length;
        k = 0;
        j = 0;
        while (k < i1)
        {
          j += localObject1[k];
          k += 1;
        }
        if ((m != n) && ((m - i - j) * 2 < j)) {
          throw NotFoundException.getNotFoundInstance();
        }
        if (this.usingCheckDigit)
        {
          n = ((StringBuilder)localObject2).length() - 1;
          k = 0;
          m = 0;
          while (k < n)
          {
            m += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.decodeRowResult.charAt(k));
            k += 1;
          }
          if (((StringBuilder)localObject2).charAt(n) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(m % 43)) {
            ((StringBuilder)localObject2).setLength(n);
          } else {
            throw ChecksumException.getChecksumInstance();
          }
        }
        if (((StringBuilder)localObject2).length() != 0)
        {
          if (this.extendedMode) {
            paramBitArray = decodeExtended((CharSequence)localObject2);
          } else {
            paramBitArray = ((StringBuilder)localObject2).toString();
          }
          float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
          float f2 = i;
          float f3 = j / 2.0F;
          float f4 = paramInt;
          paramMap = new ResultPoint(f1, f4);
          localObject1 = new ResultPoint(f2 + f3, f4);
          localObject2 = BarcodeFormat.CODE_39;
          return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
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
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code39Reader
 * JD-Core Version:    0.7.0.1
 */