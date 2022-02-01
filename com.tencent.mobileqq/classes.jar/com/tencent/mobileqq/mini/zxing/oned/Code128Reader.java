package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Code128Reader
  extends OneDReader
{
  private static final int CODE_CODE_A = 101;
  private static final int CODE_CODE_B = 100;
  private static final int CODE_CODE_C = 99;
  private static final int CODE_FNC_1 = 102;
  private static final int CODE_FNC_2 = 97;
  private static final int CODE_FNC_3 = 96;
  private static final int CODE_FNC_4_A = 101;
  private static final int CODE_FNC_4_B = 100;
  static final int[][] CODE_PATTERNS;
  private static final int CODE_SHIFT = 98;
  private static final int CODE_START_A = 103;
  private static final int CODE_START_B = 104;
  private static final int CODE_START_C = 105;
  private static final int CODE_STOP = 106;
  private static final float MAX_AVG_VARIANCE = 0.25F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.7F;
  
  static
  {
    int[] arrayOfInt1 = { 2, 1, 2, 2, 2, 2 };
    int[] arrayOfInt2 = { 2, 2, 2, 1, 2, 2 };
    int[] arrayOfInt3 = { 2, 2, 2, 2, 2, 1 };
    int[] arrayOfInt4 = { 1, 3, 2, 2, 1, 2 };
    int[] arrayOfInt5 = { 2, 2, 1, 3, 1, 2 };
    int[] arrayOfInt6 = { 2, 3, 1, 2, 1, 2 };
    int[] arrayOfInt7 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt8 = { 1, 1, 3, 2, 2, 2 };
    int[] arrayOfInt9 = { 1, 2, 3, 1, 2, 2 };
    int[] arrayOfInt10 = { 1, 2, 3, 2, 2, 1 };
    int[] arrayOfInt11 = { 2, 2, 3, 2, 1, 1 };
    int[] arrayOfInt12 = { 2, 2, 1, 2, 3, 1 };
    int[] arrayOfInt13 = { 2, 1, 3, 2, 1, 2 };
    int[] arrayOfInt14 = { 2, 2, 3, 1, 1, 2 };
    int[] arrayOfInt15 = { 3, 2, 1, 2, 2, 1 };
    int[] arrayOfInt16 = { 3, 1, 2, 2, 1, 2 };
    int[] arrayOfInt17 = { 3, 2, 2, 1, 1, 2 };
    int[] arrayOfInt18 = { 2, 1, 2, 1, 2, 3 };
    int[] arrayOfInt19 = { 1, 1, 1, 3, 2, 3 };
    int[] arrayOfInt20 = { 1, 3, 1, 1, 2, 3 };
    int[] arrayOfInt21 = { 1, 3, 1, 3, 2, 1 };
    int[] arrayOfInt22 = { 1, 3, 2, 1, 1, 3 };
    int[] arrayOfInt23 = { 2, 1, 1, 3, 1, 3 };
    int[] arrayOfInt24 = { 2, 3, 1, 3, 1, 1 };
    int[] arrayOfInt25 = { 1, 1, 2, 1, 3, 3 };
    int[] arrayOfInt26 = { 1, 3, 2, 1, 3, 1 };
    int[] arrayOfInt27 = { 1, 3, 3, 1, 2, 1 };
    int[] arrayOfInt28 = { 3, 1, 3, 1, 2, 1 };
    int[] arrayOfInt29 = { 2, 1, 1, 3, 3, 1 };
    int[] arrayOfInt30 = { 2, 1, 3, 1, 1, 3 };
    int[] arrayOfInt31 = { 3, 1, 2, 1, 1, 3 };
    int[] arrayOfInt32 = { 3, 1, 2, 3, 1, 1 };
    int[] arrayOfInt33 = { 3, 3, 2, 1, 1, 1 };
    int[] arrayOfInt34 = { 2, 2, 1, 4, 1, 1 };
    int[] arrayOfInt35 = { 1, 1, 1, 4, 2, 2 };
    int[] arrayOfInt36 = { 1, 2, 1, 1, 2, 4 };
    int[] arrayOfInt37 = { 1, 2, 1, 4, 2, 1 };
    int[] arrayOfInt38 = { 1, 1, 2, 2, 1, 4 };
    int[] arrayOfInt39 = { 1, 1, 2, 4, 1, 2 };
    int[] arrayOfInt40 = { 1, 2, 2, 1, 1, 4 };
    int[] arrayOfInt41 = { 2, 4, 1, 2, 1, 1 };
    int[] arrayOfInt42 = { 2, 2, 1, 1, 1, 4 };
    int[] arrayOfInt43 = { 4, 1, 3, 1, 1, 1 };
    int[] arrayOfInt44 = { 2, 4, 1, 1, 1, 2 };
    int[] arrayOfInt45 = { 1, 1, 1, 2, 4, 2 };
    int[] arrayOfInt46 = { 1, 2, 1, 2, 4, 1 };
    int[] arrayOfInt47 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt48 = { 4, 2, 1, 1, 1, 2 };
    int[] arrayOfInt49 = { 4, 2, 1, 2, 1, 1 };
    int[] arrayOfInt50 = { 2, 1, 2, 1, 4, 1 };
    int[] arrayOfInt51 = { 2, 1, 4, 1, 2, 1 };
    int[] arrayOfInt52 = { 4, 1, 2, 1, 2, 1 };
    int[] arrayOfInt53 = { 1, 3, 1, 1, 4, 1 };
    int[] arrayOfInt54 = { 1, 1, 3, 1, 4, 1 };
    int[] arrayOfInt55 = { 4, 1, 1, 1, 3, 1 };
    int[] arrayOfInt56 = { 2, 1, 1, 4, 1, 2 };
    int[] arrayOfInt57 = { 2, 1, 1, 2, 1, 4 };
    CODE_PATTERNS = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, { 1, 2, 1, 2, 2, 3 }, { 1, 2, 1, 3, 2, 2 }, { 1, 3, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 3 }, { 1, 2, 2, 3, 1, 2 }, arrayOfInt4, { 2, 2, 1, 2, 1, 3 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 1, 2, 2, 1, 3, 2 }, { 1, 2, 2, 2, 3, 1 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, { 2, 2, 1, 1, 3, 2 }, arrayOfInt12, arrayOfInt13, arrayOfInt14, { 3, 1, 2, 1, 3, 1 }, { 3, 1, 1, 2, 2, 2 }, { 3, 2, 1, 1, 2, 2 }, arrayOfInt15, arrayOfInt16, arrayOfInt17, { 3, 2, 2, 2, 1, 1 }, arrayOfInt18, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, arrayOfInt19, arrayOfInt20, arrayOfInt21, { 1, 1, 2, 3, 1, 3 }, arrayOfInt22, { 1, 3, 2, 3, 1, 1 }, arrayOfInt23, { 2, 3, 1, 1, 1, 3 }, arrayOfInt24, arrayOfInt25, { 1, 1, 2, 3, 3, 1 }, arrayOfInt26, { 1, 1, 3, 1, 2, 3 }, { 1, 1, 3, 3, 2, 1 }, arrayOfInt27, arrayOfInt28, arrayOfInt29, { 2, 3, 1, 1, 3, 1 }, arrayOfInt30, { 2, 1, 3, 3, 1, 1 }, { 2, 1, 3, 1, 3, 1 }, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, arrayOfInt31, arrayOfInt32, arrayOfInt33, { 3, 1, 4, 1, 1, 1 }, arrayOfInt34, { 4, 3, 1, 1, 1, 1 }, { 1, 1, 1, 2, 2, 4 }, arrayOfInt35, arrayOfInt36, arrayOfInt37, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, arrayOfInt38, arrayOfInt39, arrayOfInt40, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, { 1, 4, 2, 2, 1, 1 }, arrayOfInt41, arrayOfInt42, arrayOfInt43, arrayOfInt44, { 1, 3, 4, 1, 1, 1 }, arrayOfInt45, { 1, 2, 1, 1, 4, 2 }, arrayOfInt46, { 1, 1, 4, 2, 1, 2 }, { 1, 2, 4, 1, 1, 2 }, arrayOfInt47, { 4, 1, 1, 2, 1, 2 }, arrayOfInt48, arrayOfInt49, arrayOfInt50, arrayOfInt51, arrayOfInt52, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, arrayOfInt53, { 1, 1, 4, 1, 1, 3 }, { 1, 1, 4, 3, 1, 1 }, { 4, 1, 1, 1, 1, 3 }, { 4, 1, 1, 3, 1, 1 }, arrayOfInt54, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, arrayOfInt55, arrayOfInt56, arrayOfInt57, { 2, 1, 1, 2, 3, 2 }, { 2, 3, 3, 1, 1, 1, 2 } };
  }
  
  private static int decodeCode(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    float f1 = 0.25F;
    int i = -1;
    paramInt = 0;
    for (;;)
    {
      paramBitArray = CODE_PATTERNS;
      if (paramInt >= paramBitArray.length) {
        break;
      }
      float f3 = patternMatchVariance(paramArrayOfInt, paramBitArray[paramInt], 0.7F);
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
  
  private static int[] findStartPattern(BitArray paramBitArray)
  {
    int i1 = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int i2 = arrayOfInt.length;
    int i = k;
    int i3 = 0;
    int m = 0;
    while (k < i1)
    {
      int j;
      if (paramBitArray.get(k) != i3)
      {
        arrayOfInt[m] += 1;
        j = i;
      }
      else
      {
        if (m == i2 - 1)
        {
          float f1 = 0.25F;
          j = 103;
          int n = -1;
          while (j <= 105)
          {
            float f3 = patternMatchVariance(arrayOfInt, CODE_PATTERNS[j], 0.7F);
            float f2 = f1;
            if (f3 < f1)
            {
              n = j;
              f2 = f3;
            }
            j += 1;
            f1 = f2;
          }
          if ((n >= 0) && (paramBitArray.isRange(Math.max(0, i - (k - i) / 2), i, false))) {
            return new int[] { i, k, n };
          }
          j = i + (arrayOfInt[0] + arrayOfInt[1]);
          i = m - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[m] = 0;
          i = m - 1;
        }
        else
        {
          m += 1;
          j = i;
          i = m;
        }
        arrayOfInt[i] = 1;
        i3 ^= 0x1;
        m = i;
      }
      k += 1;
      i = j;
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int i7 = 0;
    int i5;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.ASSUME_GS1))) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    Object localObject2 = findStartPattern(paramBitArray);
    int i2 = localObject2[2];
    paramMap = new ArrayList(20);
    paramMap.add(Byte.valueOf((byte)i2));
    switch (i2)
    {
    default: 
      throw FormatException.getFormatInstance();
    case 105: 
      i = 99;
      break;
    case 104: 
      i = 100;
      break;
    case 103: 
      i = 101;
    }
    Object localObject1 = new StringBuilder(20);
    int i10 = localObject2[0];
    int n = localObject2[1];
    Object localObject3 = new int[6];
    int i11 = 0;
    int i3 = 0;
    int i1 = 0;
    int k = 0;
    int i4 = 0;
    int j = 1;
    int i6 = 0;
    int m = i;
    int i = i7;
    for (;;)
    {
      i7 = k;
      if (i1 != 0) {
        break;
      }
      i11 = decodeCode(paramBitArray, (int[])localObject3, n);
      paramMap.add(Byte.valueOf((byte)i11));
      if (i11 != 106) {
        j = 1;
      }
      int i9 = i2;
      int i8 = i4;
      if (i11 != 106)
      {
        i8 = i4 + 1;
        i9 = i2 + i8 * i11;
      }
      i4 = localObject3.length;
      i2 = n;
      k = 0;
      while (k < i4)
      {
        i2 += localObject3[k];
        k += 1;
      }
      switch (i11)
      {
      default: 
        switch (m)
        {
        default: 
          k = j;
        }
        break;
      case 103: 
      case 104: 
      case 105: 
        throw FormatException.getFormatInstance();
        if (i11 < 64)
        {
          if (i == i3) {
            ((StringBuilder)localObject1).append((char)(i11 + 32));
          } else {
            ((StringBuilder)localObject1).append((char)(i11 + 32 + 128));
          }
        }
        else if (i11 < 96)
        {
          if (i == i3) {
            ((StringBuilder)localObject1).append((char)(i11 - 64));
          } else {
            ((StringBuilder)localObject1).append((char)(i11 + 64));
          }
        }
        else
        {
          if (i11 != 106) {
            j = 0;
          }
          if (i11 != 106) {
            i4 = j;
          }
        }
        switch (i11)
        {
        default: 
          break;
        case 102: 
          if (i5 != 0) {
            if (((StringBuilder)localObject1).length() == 0) {
              ((StringBuilder)localObject1).append("]C1");
            } else {
              ((StringBuilder)localObject1).append('\035');
            }
          }
          break;
        case 101: 
          if ((i3 == 0) && (i != 0))
          {
            k = 1;
          }
          else
          {
            i4 = j;
            if (i3 == 0) {
              break label846;
            }
            i4 = j;
            if (i == 0) {
              break label846;
            }
            k = 0;
          }
          break;
        case 100: 
          k = 0;
          break;
        case 98: 
          k = 1;
          m = i;
          i4 = 100;
          i = k;
          k = m;
          m = i4;
          break;
        case 96: 
        case 97: 
          break label903;
          i1 = 1;
          break label903;
          if (i11 < 96)
          {
            if (i == i3) {
              ((StringBuilder)localObject1).append((char)(i11 + 32));
            } else {
              ((StringBuilder)localObject1).append((char)(i11 + 32 + 128));
            }
            i = 0;
            k = 0;
          }
          else
          {
            if (i11 != 106) {
              j = 0;
            }
            if (i11 != 106)
            {
              i4 = j;
              switch (i11)
              {
              default: 
                break;
              case 102: 
                if (i5 == 0) {
                  break label903;
                }
                if (((StringBuilder)localObject1).length() == 0) {
                  ((StringBuilder)localObject1).append("]C1");
                } else {
                  ((StringBuilder)localObject1).append('\035');
                }
                break;
              case 101: 
                k = 0;
                break;
              case 100: 
                if ((i3 == 0) && (i != 0)) {}
                for (k = 1;; k = 0)
                {
                  i = 0;
                  i4 = 0;
                  i3 = k;
                  k = i4;
                  break label919;
                  i4 = j;
                  if (i3 == 0) {
                    break;
                  }
                  i4 = j;
                  if (i == 0) {
                    break;
                  }
                }
                label846:
                i = 0;
                k = 1;
                j = i4;
              }
            }
          }
          break;
        }
        k = i;
        i = 0;
        m = 99;
        j = i4;
        break label919;
        k = 1;
        m = i;
        i4 = 101;
        i = k;
        k = m;
        m = i4;
        break label919;
        for (;;)
        {
          label903:
          k = i;
          i = 0;
          break;
          i1 = 1;
        }
        label919:
        break label1114;
        if (i11 < 100)
        {
          if (i11 < 10) {
            ((StringBuilder)localObject1).append('0');
          }
          ((StringBuilder)localObject1).append(i11);
          k = j;
        }
        else
        {
          if (i11 != 106) {
            j = 0;
          }
          if (i11 != 106)
          {
            switch (i11)
            {
            default: 
              k = j;
              break;
            case 102: 
              k = j;
              if (i5 == 0) {
                break;
              }
              if (((StringBuilder)localObject1).length() == 0)
              {
                ((StringBuilder)localObject1).append("]C1");
                k = j;
              }
              else
              {
                ((StringBuilder)localObject1).append('\035');
                k = j;
              }
              break;
            case 101: 
              k = i;
              i = 0;
              m = 101;
              break;
            case 100: 
              k = i;
              i = 0;
              m = 100;
              break;
            }
          }
          else
          {
            k = i;
            i = 0;
            i1 = 1;
          }
        }
        break;
      }
      i4 = 0;
      j = k;
      k = i;
      i = i4;
      label1114:
      if (i6 != 0) {
        if (m == 101) {
          m = 100;
        } else {
          m = 101;
        }
      }
      i6 = i;
      i10 = n;
      i = k;
      n = i2;
      k = i11;
      i11 = i7;
      i2 = i9;
      i4 = i8;
    }
    i = paramBitArray.getNextUnset(n);
    if (paramBitArray.isRange(i, Math.min(paramBitArray.getSize(), (i - i10) / 2 + i), false))
    {
      if ((i2 - i4 * i11) % 103 == i11)
      {
        i = ((StringBuilder)localObject1).length();
        if (i != 0)
        {
          if ((i > 0) && (j != 0)) {
            if (m == 99) {
              ((StringBuilder)localObject1).delete(i - 2, i);
            } else {
              ((StringBuilder)localObject1).delete(i - 1, i);
            }
          }
          float f1 = (localObject2[1] + localObject2[0]) / 2.0F;
          float f2 = i10;
          float f3 = (n - i10) / 2.0F;
          j = paramMap.size();
          paramBitArray = new byte[j];
          i = 0;
          while (i < j)
          {
            paramBitArray[i] = ((Byte)paramMap.get(i)).byteValue();
            i += 1;
          }
          paramMap = ((StringBuilder)localObject1).toString();
          float f4 = paramInt;
          localObject1 = new ResultPoint(f1, f4);
          localObject2 = new ResultPoint(f2 + f3, f4);
          localObject3 = BarcodeFormat.CODE_128;
          return new Result(paramMap, paramBitArray, new ResultPoint[] { localObject1, localObject2 }, (BarcodeFormat)localObject3);
        }
        throw NotFoundException.getNotFoundInstance();
      }
      throw ChecksumException.getChecksumInstance();
    }
    paramBitArray = NotFoundException.getNotFoundInstance();
    for (;;)
    {
      throw paramBitArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code128Reader
 * JD-Core Version:    0.7.0.1
 */