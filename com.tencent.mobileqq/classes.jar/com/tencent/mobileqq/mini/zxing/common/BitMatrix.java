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
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowSize = ((paramInt1 + 31) / 32);
    this.bits = new int[this.rowSize * paramInt2];
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
      if (j < this.width)
      {
        if (get(j, i)) {}
        for (String str = paramString1;; str = paramString2)
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      localStringBuilder.append(paramString3);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static BitMatrix parse(String paramString1, String paramString2, String paramString3)
  {
    int i4 = 0;
    if (paramString1 == null) {
      throw new IllegalArgumentException();
    }
    boolean[] arrayOfBoolean = new boolean[paramString1.length()];
    int k = 0;
    int m = 0;
    int i = -1;
    int i1 = 0;
    int j = 0;
    while (k < paramString1.length())
    {
      if ((paramString1.charAt(k) == '\n') || (paramString1.charAt(k) == '\r'))
      {
        int i3 = m;
        n = i;
        int i2 = i1;
        if (j > i1)
        {
          if (i != -1) {
            break label128;
          }
          n = j - i1;
        }
        label128:
        do
        {
          i3 = m + 1;
          i2 = j;
          k += 1;
          m = i3;
          i = n;
          i1 = i2;
          break;
          n = i;
        } while (j - i1 == i);
        throw new IllegalArgumentException("row lengths do not match");
      }
      if (paramString1.substring(k, paramString2.length() + k).equals(paramString2))
      {
        k += paramString2.length();
        arrayOfBoolean[j] = true;
        j += 1;
      }
      else if (paramString1.substring(k, paramString3.length() + k).equals(paramString3))
      {
        k += paramString3.length();
        arrayOfBoolean[j] = false;
        j += 1;
      }
      else
      {
        throw new IllegalArgumentException("illegal character encountered: " + paramString1.substring(k));
      }
    }
    int n = m;
    k = i;
    if (j > i1)
    {
      if (i != -1) {
        break label349;
      }
      k = j - i1;
    }
    label349:
    do
    {
      n = m + 1;
      paramString1 = new BitMatrix(k, n);
      i = i4;
      while (i < j)
      {
        if (arrayOfBoolean[i] != 0) {
          paramString1.set(i % k, i / k);
        }
        i += 1;
      }
      k = i;
    } while (j - i1 == i);
    throw new IllegalArgumentException("row lengths do not match");
    return paramString1;
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
    if (!(paramObject instanceof BitMatrix)) {}
    do
    {
      return false;
      paramObject = (BitMatrix)paramObject;
    } while ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.rowSize != paramObject.rowSize) || (!Arrays.equals(this.bits, paramObject.bits)));
    return true;
  }
  
  public void flip(int paramInt1, int paramInt2)
  {
    paramInt2 = this.rowSize * paramInt2 + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] ^= 1 << (paramInt1 & 0x1F);
  }
  
  public boolean get(int paramInt1, int paramInt2)
  {
    int i = this.rowSize;
    int j = paramInt1 / 32;
    return (this.bits[(i * paramInt2 + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
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
    int k = i / this.rowSize;
    int m = this.rowSize;
    int n = this.bits[i];
    int j = 31;
    while (n >>> j == 0) {
      j -= 1;
    }
    return new int[] { i % m * 32 + j, k };
  }
  
  public int[] getEnclosingRectangle()
  {
    int m = this.width;
    int k = this.height;
    int j = -1;
    int i1 = -1;
    int i = 0;
    int i2;
    label29:
    int n;
    if (i < this.height)
    {
      i2 = 0;
      if (i2 < this.rowSize)
      {
        int i3 = this.bits[(this.rowSize * i + i2)];
        if (i3 == 0) {
          break label300;
        }
        n = k;
        if (i < k) {
          n = i;
        }
        k = i1;
        if (i > i1) {
          k = i;
        }
        if (i2 * 32 >= m) {
          break label293;
        }
        i1 = 0;
        while (i3 << 31 - i1 == 0) {
          i1 += 1;
        }
        if (i2 * 32 + i1 >= m) {
          break label293;
        }
        i1 = i2 * 32 + i1;
        label137:
        if (i2 * 32 + 31 <= j) {
          break label278;
        }
        m = 31;
        while (i3 >>> m == 0) {
          m -= 1;
        }
        if (i2 * 32 + m <= j) {
          break label278;
        }
        i3 = i2 * 32 + m;
        j = k;
        m = n;
        k = i3;
      }
    }
    for (;;)
    {
      i2 += 1;
      n = i1;
      i1 = j;
      j = k;
      k = m;
      m = n;
      break label29;
      i += 1;
      break;
      if ((j < m) || (i1 < k)) {
        return null;
      }
      return new int[] { m, k, j - m + 1, i1 - k + 1 };
      label278:
      m = n;
      n = j;
      j = k;
      k = n;
      continue;
      label293:
      i1 = m;
      break label137;
      label300:
      n = m;
      m = k;
      k = j;
      j = i1;
      i1 = n;
    }
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public BitArray getRow(int paramInt, BitArray paramBitArray)
  {
    if ((paramBitArray == null) || (paramBitArray.getSize() < this.width)) {
      paramBitArray = new BitArray(this.width);
    }
    for (;;)
    {
      int j = this.rowSize;
      int i = 0;
      while (i < this.rowSize)
      {
        paramBitArray.setBulk(i * 32, this.bits[(paramInt * j + i)]);
        i += 1;
      }
      paramBitArray.clear();
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
    while ((i < this.bits.length) && (this.bits[i] == 0)) {
      i += 1;
    }
    if (i == this.bits.length) {
      return null;
    }
    int k = i / this.rowSize;
    int m = this.rowSize;
    int n = this.bits[i];
    int j = 0;
    while (n << 31 - j == 0) {
      j += 1;
    }
    return new int[] { i % m * 32 + j, k };
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return (((this.width * 31 + this.width) * 31 + this.height) * 31 + this.rowSize) * 31 + Arrays.hashCode(this.bits);
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
      localBitArray1 = getRow(j - 1 - i, localBitArray1);
      localBitArray2.reverse();
      localBitArray1.reverse();
      setRow(i, localBitArray1);
      setRow(j - 1 - i, localBitArray2);
      i += 1;
    }
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    paramInt2 = this.rowSize * paramInt2 + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] |= 1 << (paramInt1 & 0x1F);
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 < 1) || (paramInt3 < 1)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.height) || (i > this.width)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.rowSize;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        int[] arrayOfInt = this.bits;
        int k = paramInt3 / 32 + paramInt2 * j;
        arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
  }
  
  public void setRow(int paramInt, BitArray paramBitArray)
  {
    System.arraycopy(paramBitArray.getBitArray(), 0, this.bits, this.rowSize * paramInt, this.rowSize);
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
    paramInt2 = this.rowSize * paramInt2 + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] &= (1 << (paramInt1 & 0x1F) ^ 0xFFFFFFFF);
  }
  
  public void xor(BitMatrix paramBitMatrix)
  {
    if ((this.width != paramBitMatrix.getWidth()) || (this.height != paramBitMatrix.getHeight()) || (this.rowSize != paramBitMatrix.getRowSize())) {
      throw new IllegalArgumentException("input matrix dimensions do not match");
    }
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
        int m = i * k + j;
        arrayOfInt2[m] ^= arrayOfInt1[j];
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.BitMatrix
 * JD-Core Version:    0.7.0.1
 */