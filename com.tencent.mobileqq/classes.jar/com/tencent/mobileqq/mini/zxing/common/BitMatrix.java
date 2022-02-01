package com.tencent.mobileqq.mini.zxing.common;

import java.util.Arrays;

public final class BitMatrix
  implements Cloneable
{
  private final int[] bits;
  private final int height;
  private final int rowSize;
  private final int width;
  
  public BitMatrix(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rowSize = ((paramInt1 + 31) / 32);
      this.bits = new int[this.rowSize * paramInt2];
      return;
    }
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  private BitMatrix(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowSize = paramInt3;
    this.bits = paramArrayOfInt;
  }
  
  private String buildToString(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      while (j < this.width)
      {
        String str;
        if (get(j, i)) {
          str = paramString1;
        } else {
          str = paramString2;
        }
        localStringBuilder.append(str);
        j += 1;
      }
      localStringBuilder.append(paramString3);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static BitMatrix parse(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      boolean[] arrayOfBoolean = new boolean[paramString1.length()];
      int i4 = 0;
      int m = 0;
      int j = 0;
      int n = 0;
      int i = -1;
      int k = 0;
      while (m < paramString1.length())
      {
        if ((paramString1.charAt(m) != '\n') && (paramString1.charAt(m) != '\r'))
        {
          if (paramString1.substring(m, paramString2.length() + m).equals(paramString2))
          {
            m += paramString2.length();
            arrayOfBoolean[j] = true;
          }
          for (;;)
          {
            j += 1;
            break;
            if (!paramString1.substring(m, paramString3.length() + m).equals(paramString3)) {
              break label145;
            }
            m += paramString3.length();
            arrayOfBoolean[j] = false;
          }
          label145:
          paramString2 = new StringBuilder();
          paramString2.append("illegal character encountered: ");
          paramString2.append(paramString1.substring(m));
          throw new IllegalArgumentException(paramString2.toString());
        }
        i1 = n;
        int i2 = i;
        int i3 = k;
        if (j > n)
        {
          if (i == -1) {
            i = j - n;
          } else {
            if (j - n != i) {
              break label240;
            }
          }
          i3 = k + 1;
          i1 = j;
          i2 = i;
          break label250;
          label240:
          throw new IllegalArgumentException("row lengths do not match");
        }
        label250:
        m += 1;
        n = i1;
        i = i2;
        k = i3;
      }
      m = i;
      int i1 = k;
      if (j > n)
      {
        if (i == -1) {
          i = j - n;
        } else {
          if (j - n != i) {
            break label319;
          }
        }
        i1 = k + 1;
        m = i;
        break label329;
        label319:
        throw new IllegalArgumentException("row lengths do not match");
      }
      label329:
      paramString1 = new BitMatrix(m, i1);
      i = i4;
      while (i < j)
      {
        if (arrayOfBoolean[i] != 0) {
          paramString1.set(i % m, i / m);
        }
        i += 1;
      }
      return paramString1;
    }
    paramString1 = new IllegalArgumentException();
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static BitMatrix parse(boolean[][] paramArrayOfBoolean)
  {
    int k = paramArrayOfBoolean.length;
    int m = paramArrayOfBoolean[0].length;
    BitMatrix localBitMatrix = new BitMatrix(m, k);
    int i = 0;
    while (i < k)
    {
      boolean[] arrayOfBoolean = paramArrayOfBoolean[i];
      int j = 0;
      while (j < m)
      {
        if (arrayOfBoolean[j] != 0) {
          localBitMatrix.set(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return localBitMatrix;
  }
  
  public void clear()
  {
    int j = this.bits.length;
    int i = 0;
    while (i < j)
    {
      this.bits[i] = 0;
      i += 1;
    }
  }
  
  public BitMatrix clone()
  {
    return new BitMatrix(this.width, this.height, this.rowSize, (int[])this.bits.clone());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BitMatrix;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BitMatrix)paramObject;
    bool1 = bool2;
    if (this.width == paramObject.width)
    {
      bool1 = bool2;
      if (this.height == paramObject.height)
      {
        bool1 = bool2;
        if (this.rowSize == paramObject.rowSize)
        {
          bool1 = bool2;
          if (Arrays.equals(this.bits, paramObject.bits)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void flip(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = (1 << (paramInt1 & 0x1F) ^ arrayOfInt[paramInt2]);
  }
  
  public boolean get(int paramInt1, int paramInt2)
  {
    int i = this.rowSize;
    int j = paramInt1 / 32;
    return (this.bits[(paramInt2 * i + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int[] getBottomRightOnBit()
  {
    int i = this.bits.length - 1;
    while ((i >= 0) && (this.bits[i] == 0)) {
      i -= 1;
    }
    if (i < 0) {
      return null;
    }
    int k = this.rowSize;
    int m = i / k;
    int n = this.bits[i];
    int j = 31;
    while (n >>> j == 0) {
      j -= 1;
    }
    return new int[] { i % k * 32 + j, m };
  }
  
  public int[] getEnclosingRectangle()
  {
    int j = this.width;
    int i1 = this.height;
    int k = -1;
    int m = -1;
    int i = 0;
    while (i < this.height)
    {
      int n = m;
      m = k;
      int i2 = 0;
      int i4;
      for (k = n;; k = i4)
      {
        n = this.rowSize;
        if (i2 >= n) {
          break;
        }
        int i8 = this.bits[(n * i + i2)];
        int i5 = j;
        int i6 = m;
        int i3 = i1;
        i4 = k;
        if (i8 != 0)
        {
          n = i1;
          if (i < i1) {
            n = i;
          }
          i1 = k;
          if (i > k) {
            i1 = i;
          }
          int i9 = i2 * 32;
          int i7 = 31;
          k = j;
          if (i9 < j)
          {
            k = 0;
            while (i8 << 31 - k == 0) {
              k += 1;
            }
            i3 = k + i9;
            k = j;
            if (i3 < j) {
              k = i3;
            }
          }
          i5 = k;
          i6 = m;
          i3 = n;
          i4 = i1;
          if (i9 + 31 > m)
          {
            j = i7;
            while (i8 >>> j == 0) {
              j -= 1;
            }
            j = i9 + j;
            i5 = k;
            i6 = m;
            i3 = n;
            i4 = i1;
            if (j > m)
            {
              i6 = j;
              i4 = i1;
              i3 = n;
              i5 = k;
            }
          }
        }
        i2 += 1;
        j = i5;
        m = i6;
        i1 = i3;
      }
      i += 1;
      n = k;
      k = m;
      m = n;
    }
    if ((k >= j) && (m >= i1)) {
      return new int[] { j, i1, k - j + 1, m - i1 + 1 };
    }
    return null;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public BitArray getRow(int paramInt, BitArray paramBitArray)
  {
    if ((paramBitArray != null) && (paramBitArray.getSize() >= this.width)) {
      paramBitArray.clear();
    } else {
      paramBitArray = new BitArray(this.width);
    }
    int j = this.rowSize;
    int i = 0;
    while (i < this.rowSize)
    {
      paramBitArray.setBulk(i * 32, this.bits[(paramInt * j + i)]);
      i += 1;
    }
    return paramBitArray;
  }
  
  public int getRowSize()
  {
    return this.rowSize;
  }
  
  public int[] getTopLeftOnBit()
  {
    int i = 0;
    for (;;)
    {
      arrayOfInt = this.bits;
      if ((i >= arrayOfInt.length) || (arrayOfInt[i] != 0)) {
        break;
      }
      i += 1;
    }
    int[] arrayOfInt = this.bits;
    if (i == arrayOfInt.length) {
      return null;
    }
    int k = this.rowSize;
    int m = i / k;
    int n = arrayOfInt[i];
    int j = 0;
    while (n << 31 - j == 0) {
      j += 1;
    }
    return new int[] { i % k * 32 + j, m };
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    int i = this.width;
    return (((i * 31 + i) * 31 + this.height) * 31 + this.rowSize) * 31 + Arrays.hashCode(this.bits);
  }
  
  public void rotate180()
  {
    int i = getWidth();
    int j = getHeight();
    BitArray localBitArray2 = new BitArray(i);
    BitArray localBitArray1 = new BitArray(i);
    i = 0;
    while (i < (j + 1) / 2)
    {
      localBitArray2 = getRow(i, localBitArray2);
      int k = j - 1 - i;
      localBitArray1 = getRow(k, localBitArray1);
      localBitArray2.reverse();
      localBitArray1.reverse();
      setRow(i, localBitArray1);
      setRow(k, localBitArray2);
      i += 1;
    }
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = (1 << (paramInt1 & 0x1F) | arrayOfInt[paramInt2]);
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 >= 0) && (paramInt1 >= 0))
    {
      if ((paramInt4 >= 1) && (paramInt3 >= 1))
      {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if ((paramInt4 <= this.height) && (i <= this.width))
        {
          while (paramInt2 < paramInt4)
          {
            int j = this.rowSize;
            paramInt3 = paramInt1;
            while (paramInt3 < i)
            {
              localObject = this.bits;
              int k = paramInt3 / 32 + j * paramInt2;
              localObject[k] |= 1 << (paramInt3 & 0x1F);
              paramInt3 += 1;
            }
            paramInt2 += 1;
          }
          return;
        }
        throw new IllegalArgumentException("The region must fit inside the matrix");
      }
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    Object localObject = new IllegalArgumentException("Left and top must be nonnegative");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setRow(int paramInt, BitArray paramBitArray)
  {
    paramBitArray = paramBitArray.getBitArray();
    int[] arrayOfInt = this.bits;
    int i = this.rowSize;
    System.arraycopy(paramBitArray, 0, arrayOfInt, paramInt * i, i);
  }
  
  public String toString()
  {
    return toString("X ", "  ");
  }
  
  public String toString(String paramString1, String paramString2)
  {
    return buildToString(paramString1, paramString2, "\n");
  }
  
  @Deprecated
  public String toString(String paramString1, String paramString2, String paramString3)
  {
    return buildToString(paramString1, paramString2, paramString3);
  }
  
  public void unset(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = ((1 << (paramInt1 & 0x1F) ^ 0xFFFFFFFF) & arrayOfInt[paramInt2]);
  }
  
  public void xor(BitMatrix paramBitMatrix)
  {
    if ((this.width == paramBitMatrix.getWidth()) && (this.height == paramBitMatrix.getHeight()) && (this.rowSize == paramBitMatrix.getRowSize()))
    {
      BitArray localBitArray = new BitArray(this.width);
      int i = 0;
      while (i < this.height)
      {
        int k = this.rowSize;
        int[] arrayOfInt1 = paramBitMatrix.getRow(i, localBitArray).getBitArray();
        int j = 0;
        while (j < this.rowSize)
        {
          int[] arrayOfInt2 = this.bits;
          int m = k * i + j;
          arrayOfInt2[m] ^= arrayOfInt1[j];
          j += 1;
        }
        i += 1;
      }
      return;
    }
    paramBitMatrix = new IllegalArgumentException("input matrix dimensions do not match");
    for (;;)
    {
      throw paramBitMatrix;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.BitMatrix
 * JD-Core Version:    0.7.0.1
 */