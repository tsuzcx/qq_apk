package com.tencent.mobileqq.mini.zxing.common;

import java.util.Arrays;

public final class BitArray
  implements Cloneable
{
  private int[] bits;
  private int size;
  
  public BitArray()
  {
    this.size = 0;
    this.bits = new int[1];
  }
  
  public BitArray(int paramInt)
  {
    this.size = paramInt;
    this.bits = makeArray(paramInt);
  }
  
  BitArray(int[] paramArrayOfInt, int paramInt)
  {
    this.bits = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.bits.length * 32)
    {
      int[] arrayOfInt1 = makeArray(paramInt);
      int[] arrayOfInt2 = this.bits;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      this.bits = arrayOfInt1;
    }
  }
  
  private static int[] makeArray(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }
  
  public void appendBit(boolean paramBoolean)
  {
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.bits;
      int i = this.size;
      int j = i / 32;
      arrayOfInt[j] = (1 << (i & 0x1F) | arrayOfInt[j]);
    }
    this.size += 1;
  }
  
  public void appendBitArray(BitArray paramBitArray)
  {
    int j = paramBitArray.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      appendBit(paramBitArray.get(i));
      i += 1;
    }
  }
  
  public void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      ensureCapacity(this.size + paramInt2);
      while (paramInt2 > 0)
      {
        boolean bool = true;
        if ((paramInt1 >> paramInt2 - 1 & 0x1) != 1) {
          bool = false;
        }
        appendBit(bool);
        paramInt2 -= 1;
      }
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
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
  
  public BitArray clone()
  {
    return new BitArray((int[])this.bits.clone(), this.size);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BitArray;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BitArray)paramObject;
    bool1 = bool2;
    if (this.size == paramObject.size)
    {
      bool1 = bool2;
      if (Arrays.equals(this.bits, paramObject.bits)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void flip(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = (1 << (paramInt & 0x1F) ^ arrayOfInt[i]);
  }
  
  public boolean get(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.bits[(paramInt / 32)]) != 0;
  }
  
  public int[] getBitArray()
  {
    return this.bits;
  }
  
  public int getNextSet(int paramInt)
  {
    int i = this.size;
    if (paramInt >= i) {
      return i;
    }
    int j = paramInt / 32;
    i = this.bits[j];
    i = -(1 << (paramInt & 0x1F)) & i;
    paramInt = j;
    while (i == 0)
    {
      paramInt += 1;
      int[] arrayOfInt = this.bits;
      if (paramInt == arrayOfInt.length) {
        return this.size;
      }
      i = arrayOfInt[paramInt];
    }
    paramInt = paramInt * 32 + Integer.numberOfTrailingZeros(i);
    i = this.size;
    if (paramInt > i) {
      return i;
    }
    return paramInt;
  }
  
  public int getNextUnset(int paramInt)
  {
    int i = this.size;
    if (paramInt >= i) {
      return i;
    }
    int j = paramInt / 32;
    i = this.bits[j];
    i = -(1 << (paramInt & 0x1F)) & (i ^ 0xFFFFFFFF);
    paramInt = j;
    while (i == 0)
    {
      paramInt += 1;
      int[] arrayOfInt = this.bits;
      if (paramInt == arrayOfInt.length) {
        return this.size;
      }
      i = arrayOfInt[paramInt] ^ 0xFFFFFFFF;
    }
    paramInt = paramInt * 32 + Integer.numberOfTrailingZeros(i);
    i = this.size;
    if (paramInt > i) {
      return i;
    }
    return paramInt;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getSizeInBytes()
  {
    return (this.size + 7) / 8;
  }
  
  public int hashCode()
  {
    return this.size * 31 + Arrays.hashCode(this.bits);
  }
  
  public boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt2 >= paramInt1) && (paramInt1 >= 0) && (paramInt2 <= this.size))
    {
      if (paramInt2 == paramInt1) {
        return true;
      }
      int m = paramInt2 - 1;
      int k = paramInt1 / 32;
      int n = m / 32;
      int i = k;
      while (i <= n)
      {
        int j = 31;
        if (i > k) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1 & 0x1F;
        }
        if (i >= n) {
          j = 0x1F & m;
        }
        j = (2 << j) - (1 << paramInt2);
        int i1 = this.bits[i];
        if (paramBoolean) {
          paramInt2 = j;
        } else {
          paramInt2 = 0;
        }
        if ((i1 & j) != paramInt2) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void reverse()
  {
    int[] arrayOfInt = new int[this.bits.length];
    int j = (this.size - 1) / 32;
    int k = j + 1;
    int i = 0;
    while (i < k)
    {
      long l = this.bits[i];
      l = (l & 0x55555555) << 1 | l >> 1 & 0x55555555;
      l = (l & 0x33333333) << 2 | l >> 2 & 0x33333333;
      l = (l & 0xF0F0F0F) << 4 | l >> 4 & 0xF0F0F0F;
      l = (l & 0xFF00FF) << 8 | l >> 8 & 0xFF00FF;
      arrayOfInt[(j - i)] = ((int)((l & 0xFFFF) << 16 | l >> 16 & 0xFFFF));
      i += 1;
    }
    i = this.size;
    j = k * 32;
    if (i != j)
    {
      int m = j - i;
      j = arrayOfInt[0] >>> m;
      i = 1;
      while (i < k)
      {
        int n = arrayOfInt[i];
        arrayOfInt[(i - 1)] = (j | n << 32 - m);
        j = n >>> m;
        i += 1;
      }
      arrayOfInt[(k - 1)] = j;
    }
    this.bits = arrayOfInt;
  }
  
  public void set(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = (1 << (paramInt & 0x1F) | arrayOfInt[i]);
  }
  
  public void setBulk(int paramInt1, int paramInt2)
  {
    this.bits[(paramInt1 / 32)] = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= paramInt1) && (paramInt1 >= 0) && (paramInt2 <= this.size))
    {
      if (paramInt2 == paramInt1) {
        return;
      }
      int m = paramInt2 - 1;
      int k = paramInt1 / 32;
      int n = m / 32;
      paramInt2 = k;
      while (paramInt2 <= n)
      {
        int j = 31;
        int i;
        if (paramInt2 > k) {
          i = 0;
        } else {
          i = paramInt1 & 0x1F;
        }
        if (paramInt2 >= n) {
          j = 0x1F & m;
        }
        localObject = this.bits;
        localObject[paramInt2] = ((2 << j) - (1 << i) | localObject[paramInt2]);
        paramInt2 += 1;
      }
      return;
    }
    Object localObject = new IllegalArgumentException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (get(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public String toString()
  {
    int i = this.size;
    StringBuilder localStringBuilder = new StringBuilder(i + i / 8 + 1);
    i = 0;
    while (i < this.size)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      char c;
      if (get(i)) {
        c = 'X';
      } else {
        c = '.';
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void xor(BitArray paramBitArray)
  {
    if (this.size == paramBitArray.size)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.bits;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] ^= paramBitArray.bits[i];
        i += 1;
      }
      return;
    }
    paramBitArray = new IllegalArgumentException("Sizes don't match");
    for (;;)
    {
      throw paramBitArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.BitArray
 * JD-Core Version:    0.7.0.1
 */