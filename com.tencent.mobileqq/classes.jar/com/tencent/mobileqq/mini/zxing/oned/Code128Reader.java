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
    int[] arrayOfInt1 = { 2, 2, 2, 1, 2, 2 };
    int[] arrayOfInt2 = { 2, 2, 2, 2, 2, 1 };
    int[] arrayOfInt3 = { 1, 2, 1, 3, 2, 2 };
    int[] arrayOfInt4 = { 1, 3, 1, 2, 2, 2 };
    int[] arrayOfInt5 = { 1, 2, 2, 2, 1, 3 };
    int[] arrayOfInt6 = { 1, 2, 2, 3, 1, 2 };
    int[] arrayOfInt7 = { 1, 3, 2, 2, 1, 2 };
    int[] arrayOfInt8 = { 2, 2, 1, 2, 1, 3 };
    int[] arrayOfInt9 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt10 = { 1, 2, 2, 2, 3, 1 };
    int[] arrayOfInt11 = { 2, 2, 1, 1, 3, 2 };
    int[] arrayOfInt12 = { 2, 2, 1, 2, 3, 1 };
    int[] arrayOfInt13 = { 2, 2, 3, 1, 1, 2 };
    int[] arrayOfInt14 = { 3, 1, 1, 2, 2, 2 };
    int[] arrayOfInt15 = { 3, 2, 1, 1, 2, 2 };
    int[] arrayOfInt16 = { 3, 2, 1, 2, 2, 1 };
    int[] arrayOfInt17 = { 3, 2, 2, 2, 1, 1 };
    int[] arrayOfInt18 = { 2, 1, 2, 3, 2, 1 };
    int[] arrayOfInt19 = { 1, 1, 1, 3, 2, 3 };
    int[] arrayOfInt20 = { 1, 3, 1, 3, 2, 1 };
    int[] arrayOfInt21 = { 1, 1, 2, 3, 1, 3 };
    int[] arrayOfInt22 = { 1, 3, 2, 1, 1, 3 };
    int[] arrayOfInt23 = { 1, 3, 2, 3, 1, 1 };
    int[] arrayOfInt24 = { 2, 1, 1, 3, 1, 3 };
    int[] arrayOfInt25 = { 2, 3, 1, 1, 1, 3 };
    int[] arrayOfInt26 = { 2, 3, 1, 3, 1, 1 };
    int[] arrayOfInt27 = { 1, 1, 2, 1, 3, 3 };
    int[] arrayOfInt28 = { 1, 1, 2, 3, 3, 1 };
    int[] arrayOfInt29 = { 1, 3, 2, 1, 3, 1 };
    int[] arrayOfInt30 = { 1, 1, 3, 3, 2, 1 };
    int[] arrayOfInt31 = { 2, 3, 1, 1, 3, 1 };
    int[] arrayOfInt32 = { 2, 1, 3, 3, 1, 1 };
    int[] arrayOfInt33 = { 3, 1, 1, 3, 2, 1 };
    int[] arrayOfInt34 = { 2, 2, 1, 4, 1, 1 };
    int[] arrayOfInt35 = { 4, 3, 1, 1, 1, 1 };
    int[] arrayOfInt36 = { 1, 1, 1, 2, 2, 4 };
    int[] arrayOfInt37 = { 1, 1, 1, 4, 2, 2 };
    int[] arrayOfInt38 = { 1, 2, 1, 1, 2, 4 };
    int[] arrayOfInt39 = { 1, 4, 1, 1, 2, 2 };
    int[] arrayOfInt40 = { 1, 4, 1, 2, 2, 1 };
    int[] arrayOfInt41 = { 1, 1, 2, 4, 1, 2 };
    int[] arrayOfInt42 = { 1, 2, 2, 1, 1, 4 };
    int[] arrayOfInt43 = { 1, 4, 2, 2, 1, 1 };
    int[] arrayOfInt44 = { 2, 4, 1, 2, 1, 1 };
    int[] arrayOfInt45 = { 4, 1, 3, 1, 1, 1 };
    int[] arrayOfInt46 = { 2, 4, 1, 1, 1, 2 };
    int[] arrayOfInt47 = { 1, 3, 4, 1, 1, 1 };
    int[] arrayOfInt48 = { 1, 1, 1, 2, 4, 2 };
    int[] arrayOfInt49 = { 1, 2, 1, 1, 4, 2 };
    int[] arrayOfInt50 = { 1, 2, 1, 2, 4, 1 };
    int[] arrayOfInt51 = { 1, 1, 4, 2, 1, 2 };
    int[] arrayOfInt52 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt53 = { 4, 1, 1, 2, 1, 2 };
    int[] arrayOfInt54 = { 4, 2, 1, 1, 1, 2 };
    int[] arrayOfInt55 = { 4, 2, 1, 2, 1, 1 };
    int[] arrayOfInt56 = { 1, 1, 1, 1, 4, 3 };
    int[] arrayOfInt57 = { 1, 1, 1, 3, 4, 1 };
    int[] arrayOfInt58 = { 1, 1, 4, 1, 1, 3 };
    int[] arrayOfInt59 = { 1, 1, 4, 3, 1, 1 };
    int[] arrayOfInt60 = { 4, 1, 1, 1, 1, 3 };
    int[] arrayOfInt61 = { 2, 1, 1, 4, 1, 2 };
    int[] arrayOfInt62 = { 2, 3, 3, 1, 1, 1, 2 };
    CODE_PATTERNS = new int[][] { { 2, 1, 2, 2, 2, 2 }, arrayOfInt1, arrayOfInt2, { 1, 2, 1, 2, 2, 3 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 2, 2, 1, 3, 1, 2 }, { 2, 3, 1, 2, 1, 2 }, arrayOfInt9, { 1, 2, 2, 1, 3, 2 }, arrayOfInt10, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, { 2, 2, 3, 2, 1, 1 }, arrayOfInt11, arrayOfInt12, { 2, 1, 3, 2, 1, 2 }, arrayOfInt13, { 3, 1, 2, 1, 3, 1 }, arrayOfInt14, arrayOfInt15, arrayOfInt16, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, arrayOfInt17, { 2, 1, 2, 1, 2, 3 }, arrayOfInt18, { 2, 3, 2, 1, 2, 1 }, arrayOfInt19, { 1, 3, 1, 1, 2, 3 }, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, arrayOfInt29, { 1, 1, 3, 1, 2, 3 }, arrayOfInt30, { 1, 3, 3, 1, 2, 1 }, { 3, 1, 3, 1, 2, 1 }, { 2, 1, 1, 3, 3, 1 }, arrayOfInt31, { 2, 1, 3, 1, 1, 3 }, arrayOfInt32, { 2, 1, 3, 1, 3, 1 }, { 3, 1, 1, 1, 2, 3 }, arrayOfInt33, { 3, 3, 1, 1, 2, 1 }, { 3, 1, 2, 1, 1, 3 }, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, { 3, 1, 4, 1, 1, 1 }, arrayOfInt34, arrayOfInt35, arrayOfInt36, arrayOfInt37, arrayOfInt38, { 1, 2, 1, 4, 2, 1 }, arrayOfInt39, arrayOfInt40, { 1, 1, 2, 2, 1, 4 }, arrayOfInt41, arrayOfInt42, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, arrayOfInt43, arrayOfInt44, { 2, 2, 1, 1, 1, 4 }, arrayOfInt45, arrayOfInt46, arrayOfInt47, arrayOfInt48, arrayOfInt49, arrayOfInt50, arrayOfInt51, { 1, 2, 4, 1, 1, 2 }, arrayOfInt52, arrayOfInt53, arrayOfInt54, arrayOfInt55, { 2, 1, 2, 1, 4, 1 }, { 2, 1, 4, 1, 2, 1 }, { 4, 1, 2, 1, 2, 1 }, arrayOfInt56, arrayOfInt57, { 1, 3, 1, 1, 4, 1 }, arrayOfInt58, arrayOfInt59, arrayOfInt60, { 4, 1, 1, 3, 1, 1 }, { 1, 1, 3, 1, 4, 1 }, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, arrayOfInt61, { 2, 1, 1, 2, 1, 4 }, { 2, 1, 1, 2, 3, 2 }, arrayOfInt62 };
  }
  
  private static int decodeCode(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    float f1 = 0.25F;
    int i = -1;
    paramInt = 0;
    while (paramInt < CODE_PATTERNS.length)
    {
      float f3 = patternMatchVariance(paramArrayOfInt, CODE_PATTERNS[paramInt], 0.7F);
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
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int[] findStartPattern(BitArray paramBitArray)
  {
    int i1 = paramBitArray.getSize();
    int i = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int i2 = arrayOfInt.length;
    int m = i;
    int i3 = 0;
    int j = 0;
    int k;
    int n;
    for (;;)
    {
      if (m < i1) {
        if (paramBitArray.get(m) != i3)
        {
          arrayOfInt[j] += 1;
          k = j;
          j = i;
          i = k;
          m += 1;
          k = i;
          i = j;
          j = k;
        }
        else if (j == i2 - 1)
        {
          float f1 = 0.25F;
          n = -1;
          k = 103;
          label110:
          if (k <= 105)
          {
            float f2 = patternMatchVariance(arrayOfInt, CODE_PATTERNS[k], 0.7F);
            if (f2 >= f1) {
              break label286;
            }
            n = k;
            f1 = f2;
          }
        }
      }
    }
    label286:
    for (;;)
    {
      k += 1;
      break label110;
      if ((n >= 0) && (paramBitArray.isRange(Math.max(0, i - (m - i) / 2), i, false))) {
        return new int[] { i, m, n };
      }
      k = arrayOfInt[0] + arrayOfInt[1] + i;
      System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, j - 1);
      arrayOfInt[(j - 1)] = 0;
      arrayOfInt[j] = 0;
      i = j - 1;
      j = k;
      label245:
      arrayOfInt[i] = 1;
      if (i3 == 0) {}
      for (i3 = 1;; i3 = 0)
      {
        break;
        k = j + 1;
        j = i;
        i = k;
        break label245;
      }
      throw NotFoundException.getNotFoundInstance();
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.ASSUME_GS1))) {}
    int i1;
    for (int i9 = 1;; i9 = 0)
    {
      localObject2 = findStartPattern(paramBitArray);
      i1 = localObject2[2];
      paramMap = new ArrayList(20);
      paramMap.add(Byte.valueOf((byte)i1));
      switch (i1)
      {
      default: 
        throw FormatException.getFormatInstance();
      }
    }
    int i = 101;
    int i6;
    int i2;
    int n;
    int i5;
    int m;
    int i10;
    int i7;
    int i4;
    int j;
    int k;
    int i15;
    int i14;
    int i13;
    int i12;
    int i11;
    for (;;)
    {
      localObject1 = new StringBuilder(20);
      i6 = localObject2[0];
      i2 = localObject2[1];
      localObject3 = new int[6];
      n = 1;
      i5 = 0;
      m = 0;
      i10 = 0;
      i3 = 0;
      i7 = 0;
      i4 = 0;
      j = 0;
      k = i;
      i = i5;
      if (j != 0) {
        break label1892;
      }
      i15 = 0;
      i14 = 0;
      i13 = decodeCode(paramBitArray, (int[])localObject3, i2);
      paramMap.add(Byte.valueOf((byte)i13));
      if (i13 != 106) {
        n = 1;
      }
      i12 = i3;
      i11 = i1;
      if (i13 != 106)
      {
        i12 = i3 + 1;
        i11 = i1 + i12 * i13;
      }
      i3 = localObject3.length;
      i1 = 0;
      i5 = i2;
      while (i1 < i3)
      {
        i5 += localObject3[i1];
        i1 += 1;
      }
      i = 100;
      continue;
      i = 99;
    }
    switch (i13)
    {
    default: 
      switch (k)
      {
      default: 
        i1 = n;
        i3 = k;
        n = 0;
        i6 = m;
        m = i1;
        i1 = j;
        k = i;
        j = i6;
        i = i3;
        label379:
        i3 = i;
        if (i10 != 0) {
          if (i != 101) {
            break label1885;
          }
        }
        break;
      }
      break;
    }
    label1885:
    for (int i3 = 100;; i3 = 101)
    {
      i10 = n;
      n = i3;
      i = k;
      i7 = i4;
      i4 = i13;
      i6 = m;
      k = i1;
      i3 = i12;
      i1 = i11;
      m = j;
      j = k;
      k = n;
      n = i6;
      i6 = i2;
      i2 = i5;
      break;
      throw FormatException.getFormatInstance();
      if (i13 < 64)
      {
        if (m == i) {
          ((StringBuilder)localObject1).append((char)(i13 + 32));
        }
        for (;;)
        {
          i3 = k;
          i6 = 0;
          k = i;
          i7 = 0;
          m = n;
          i1 = j;
          i = i3;
          j = i7;
          n = i6;
          break;
          ((StringBuilder)localObject1).append((char)(i13 + 32 + 128));
        }
      }
      if (i13 < 96)
      {
        if (m == i) {
          ((StringBuilder)localObject1).append((char)(i13 - 64));
        }
        for (;;)
        {
          i3 = k;
          i6 = 0;
          k = i;
          i7 = 0;
          m = n;
          i1 = j;
          i = i3;
          j = i7;
          n = i6;
          break;
          ((StringBuilder)localObject1).append((char)(i13 + 64));
        }
      }
      i6 = n;
      if (i13 != 106) {
        i6 = 0;
      }
      n = m;
      i3 = i;
      int i8 = i14;
      i7 = j;
      i1 = k;
      switch (i13)
      {
      default: 
        i1 = k;
        i7 = j;
        i8 = i14;
        i3 = i;
        n = m;
      }
      for (;;)
      {
        i = i1;
        k = i3;
        j = n;
        m = i6;
        i1 = i7;
        n = i8;
        break;
        n = m;
        i3 = i;
        i8 = i14;
        i7 = j;
        i1 = k;
        if (i9 != 0) {
          if (((StringBuilder)localObject1).length() == 0)
          {
            ((StringBuilder)localObject1).append("]C1");
            n = m;
            i3 = i;
            i8 = i14;
            i7 = j;
            i1 = k;
          }
          else
          {
            ((StringBuilder)localObject1).append('\035');
            n = m;
            i3 = i;
            i8 = i14;
            i7 = j;
            i1 = k;
            continue;
            if ((i == 0) && (m != 0))
            {
              i3 = 1;
              n = 0;
              i8 = i14;
              i7 = j;
              i1 = k;
            }
            else if ((i != 0) && (m != 0))
            {
              i3 = 0;
              n = 0;
              i8 = i14;
              i7 = j;
              i1 = k;
            }
            else
            {
              n = 1;
              i3 = i;
              i8 = i14;
              i7 = j;
              i1 = k;
              continue;
              i8 = 1;
              i1 = 100;
              n = m;
              i3 = i;
              i7 = j;
              continue;
              i1 = 100;
              n = m;
              i3 = i;
              i8 = i14;
              i7 = j;
              continue;
              i1 = 99;
              n = m;
              i3 = i;
              i8 = i14;
              i7 = j;
              continue;
              i7 = 1;
              n = m;
              i3 = i;
              i8 = i14;
              i1 = k;
            }
          }
        }
      }
      if (i13 < 96)
      {
        if (m == i) {
          ((StringBuilder)localObject1).append((char)(i13 + 32));
        }
        for (;;)
        {
          i3 = k;
          i6 = 0;
          k = i;
          i7 = 0;
          m = n;
          i1 = j;
          i = i3;
          j = i7;
          n = i6;
          break;
          ((StringBuilder)localObject1).append((char)(i13 + 32 + 128));
        }
      }
      i6 = n;
      if (i13 != 106) {
        i6 = 0;
      }
      n = m;
      i3 = i;
      i8 = i15;
      i7 = j;
      i1 = k;
      switch (i13)
      {
      default: 
        i1 = k;
        i7 = j;
        i8 = i15;
        i3 = i;
        n = m;
      }
      for (;;)
      {
        i = i1;
        k = i3;
        j = n;
        m = i6;
        i1 = i7;
        n = i8;
        break;
        n = m;
        i3 = i;
        i8 = i15;
        i7 = j;
        i1 = k;
        if (i9 != 0) {
          if (((StringBuilder)localObject1).length() == 0)
          {
            ((StringBuilder)localObject1).append("]C1");
            n = m;
            i3 = i;
            i8 = i15;
            i7 = j;
            i1 = k;
          }
          else
          {
            ((StringBuilder)localObject1).append('\035');
            n = m;
            i3 = i;
            i8 = i15;
            i7 = j;
            i1 = k;
            continue;
            if ((i == 0) && (m != 0))
            {
              i3 = 1;
              n = 0;
              i8 = i15;
              i7 = j;
              i1 = k;
            }
            else if ((i != 0) && (m != 0))
            {
              i3 = 0;
              n = 0;
              i8 = i15;
              i7 = j;
              i1 = k;
            }
            else
            {
              n = 1;
              i3 = i;
              i8 = i15;
              i7 = j;
              i1 = k;
              continue;
              i8 = 1;
              i1 = 101;
              n = m;
              i3 = i;
              i7 = j;
              continue;
              i1 = 101;
              n = m;
              i3 = i;
              i8 = i15;
              i7 = j;
              continue;
              i1 = 99;
              n = m;
              i3 = i;
              i8 = i15;
              i7 = j;
              continue;
              i7 = 1;
              n = m;
              i3 = i;
              i8 = i15;
              i1 = k;
            }
          }
        }
      }
      if (i13 < 100)
      {
        if (i13 < 10) {
          ((StringBuilder)localObject1).append('0');
        }
        ((StringBuilder)localObject1).append(i13);
        i3 = k;
        i7 = 0;
        k = i;
        i6 = m;
        m = n;
        i1 = j;
        i = i3;
        j = i6;
        n = i7;
        break label379;
      }
      if (i13 != 106) {
        n = 0;
      }
      switch (i13)
      {
      case 103: 
      case 104: 
      case 105: 
      default: 
        i1 = n;
        break;
      case 100: 
        i7 = 100;
        i6 = 0;
        k = i;
        i3 = m;
        m = n;
        i1 = j;
        i = i7;
        j = i3;
        n = i6;
        break;
      case 102: 
        i1 = n;
        if (i9 == 0) {
          break;
        }
        if (((StringBuilder)localObject1).length() == 0)
        {
          ((StringBuilder)localObject1).append("]C1");
          i3 = k;
          i7 = 0;
          k = i;
          i6 = m;
          m = n;
          i1 = j;
          i = i3;
          j = i6;
          n = i7;
          break label379;
        }
        ((StringBuilder)localObject1).append('\035');
        i3 = k;
        i7 = 0;
        k = i;
        i6 = m;
        m = n;
        i1 = j;
        i = i3;
        j = i6;
        n = i7;
        break;
      case 101: 
        i7 = 101;
        i6 = 0;
        k = i;
        i3 = m;
        m = n;
        i1 = j;
        i = i7;
        j = i3;
        n = i6;
        break;
      case 106: 
        j = k;
        i3 = 0;
        k = i;
        i1 = m;
        m = n;
        i6 = 1;
        i = j;
        j = i1;
        n = i3;
        i1 = i6;
        break label379;
      }
    }
    label1892:
    i = paramBitArray.getNextUnset(i2);
    if (!paramBitArray.isRange(i, Math.min(paramBitArray.getSize(), (i - i6) / 2 + i), false)) {
      throw NotFoundException.getNotFoundInstance();
    }
    if ((i1 - i3 * i7) % 103 != i7) {
      throw ChecksumException.getChecksumInstance();
    }
    i = ((StringBuilder)localObject1).length();
    if (i == 0) {
      throw NotFoundException.getNotFoundInstance();
    }
    if ((i > 0) && (n != 0))
    {
      if (k != 99) {
        break label2075;
      }
      ((StringBuilder)localObject1).delete(i - 2, i);
    }
    float f1;
    float f2;
    float f3;
    for (;;)
    {
      f1 = (localObject2[1] + localObject2[0]) / 2.0F;
      f2 = i6;
      f3 = (i2 - i6) / 2.0F;
      j = paramMap.size();
      paramBitArray = new byte[j];
      i = 0;
      while (i < j)
      {
        paramBitArray[i] = ((Byte)paramMap.get(i)).byteValue();
        i += 1;
      }
      label2075:
      ((StringBuilder)localObject1).delete(i - 1, i);
    }
    paramMap = ((StringBuilder)localObject1).toString();
    Object localObject1 = new ResultPoint(f1, paramInt);
    Object localObject2 = new ResultPoint(f2 + f3, paramInt);
    Object localObject3 = BarcodeFormat.CODE_128;
    return new Result(paramMap, paramBitArray, new ResultPoint[] { localObject1, localObject2 }, (BarcodeFormat)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.Code128Reader
 * JD-Core Version:    0.7.0.1
 */