package com.tencent.mtt.hippy.utils;

import java.util.Arrays;

public class GrowByteBuffer
{
  private static final byte[] DigitOnes = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  private static final byte[] DigitTens;
  private static final byte[] FALSE_BYTES = { 102, 97, 108, 115, 101 };
  private static final byte[] INT_MIN_BYTES;
  private static final int[] INT_STRING_SIZE_TABLE;
  private static final byte[] LONG_MIN_BYTES;
  private static final int MAX_ARRAY_SIZE = 2147483639;
  private static final byte[] TRUE_BYTES = { 116, 114, 117, 101 };
  private static final byte[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private int count;
  private StringBuilder stringBuilder;
  private byte[] value;
  
  static
  {
    INT_MIN_BYTES = new byte[] { 45, 50, 49, 52, 55, 52, 56, 51, 54, 52, 56 };
    LONG_MIN_BYTES = new byte[] { 45, 57, 50, 50, 51, 51, 55, 50, 48, 51, 54, 56, 53, 52, 55, 55, 53, 56, 48, 56 };
    INT_STRING_SIZE_TABLE = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 2147483647 };
    DigitTens = new byte[] { 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57 };
  }
  
  public GrowByteBuffer(int paramInt)
  {
    this.value = new byte[paramInt];
    this.count = 0;
  }
  
  private void ensureCapacityInternal(int paramInt)
  {
    byte[] arrayOfByte = this.value;
    if (paramInt - arrayOfByte.length > 0) {
      this.value = Arrays.copyOf(arrayOfByte, newCapacity(paramInt));
    }
  }
  
  private static void getBytesFromInt(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i;
    if (paramInt1 < 0)
    {
      i = 45;
      paramInt1 = -paramInt1;
    }
    else
    {
      i = 0;
    }
    int j;
    int k;
    for (;;)
    {
      j = paramInt1;
      k = paramInt2;
      if (paramInt1 < 65536) {
        break;
      }
      j = paramInt1 / 100;
      paramInt1 -= (j << 6) + (j << 5) + (j << 2);
      paramInt2 -= 1;
      paramArrayOfByte[paramInt2] = DigitOnes[paramInt1];
      paramInt2 -= 1;
      paramArrayOfByte[paramInt2] = DigitTens[paramInt1];
      paramInt1 = j;
    }
    for (;;)
    {
      paramInt1 = 52429 * j >>> 19;
      k -= 1;
      paramArrayOfByte[k] = digits[(j - ((paramInt1 << 3) + (paramInt1 << 1)))];
      if (paramInt1 == 0)
      {
        if (i != 0) {
          paramArrayOfByte[(k - 1)] = i;
        }
        return;
      }
      j = paramInt1;
    }
  }
  
  private static void getBytesFromLong(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i;
    if (paramLong < 0L)
    {
      i = 45;
      paramLong = -paramLong;
    }
    else
    {
      i = 0;
    }
    while (paramLong > 2147483647L)
    {
      long l = paramLong / 100L;
      j = (int)(paramLong - ((l << 6) + (l << 5) + (l << 2)));
      paramInt -= 1;
      paramArrayOfByte[paramInt] = DigitOnes[j];
      paramInt -= 1;
      paramArrayOfByte[paramInt] = DigitTens[j];
      paramLong = l;
    }
    int k;
    int m;
    for (int j = (int)paramLong;; j = k)
    {
      k = j;
      m = paramInt;
      if (j < 65536) {
        break;
      }
      k = j / 100;
      j -= (k << 6) + (k << 5) + (k << 2);
      paramInt -= 1;
      paramArrayOfByte[paramInt] = DigitOnes[j];
      paramInt -= 1;
      paramArrayOfByte[paramInt] = DigitTens[j];
    }
    for (;;)
    {
      paramInt = 52429 * k >>> 19;
      m -= 1;
      paramArrayOfByte[m] = digits[(k - ((paramInt << 3) + (paramInt << 1)))];
      if (paramInt == 0)
      {
        if (i != 0) {
          paramArrayOfByte[(m - 1)] = i;
        }
        return;
      }
      k = paramInt;
    }
  }
  
  private int hugeCapacity(int paramInt)
  {
    if (2147483647 - paramInt >= 0) {
      return Math.max(paramInt, 2147483639);
    }
    throw new OutOfMemoryError();
  }
  
  private static int intStringSize(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (paramInt <= INT_STRING_SIZE_TABLE[i]) {
        return i + 1;
      }
      i += 1;
    }
  }
  
  private static int longStringSize(long paramLong)
  {
    int i = 1;
    long l = 10L;
    while (i < 19)
    {
      if (paramLong < l) {
        return i;
      }
      l *= 10L;
      i += 1;
    }
    return 19;
  }
  
  private int newCapacity(int paramInt)
  {
    int j = (this.value.length << 1) + 2;
    int i = j;
    if (j - paramInt < 0) {
      i = paramInt;
    }
    if (i > 0)
    {
      j = i;
      if (2147483639 - i >= 0) {}
    }
    else
    {
      j = hugeCapacity(paramInt);
    }
    return j;
  }
  
  public int capacity()
  {
    return this.value.length;
  }
  
  public StringBuilder getStringBuilderCache()
  {
    if (this.stringBuilder == null) {
      this.stringBuilder = new StringBuilder();
    }
    this.stringBuilder.setLength(0);
    return this.stringBuilder;
  }
  
  public final byte[] getValue()
  {
    return this.value;
  }
  
  public int length()
  {
    return this.count;
  }
  
  public GrowByteBuffer putBoolean(boolean paramBoolean)
  {
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = TRUE_BYTES;
    } else {
      arrayOfByte = FALSE_BYTES;
    }
    return putByteArray(arrayOfByte);
  }
  
  public GrowByteBuffer putByte(byte paramByte)
  {
    ensureCapacityInternal(this.count + 1);
    byte[] arrayOfByte = this.value;
    int i = this.count;
    this.count = (i + 1);
    arrayOfByte[i] = paramByte;
    return this;
  }
  
  public GrowByteBuffer putByteArray(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    ensureCapacityInternal(this.count + i);
    System.arraycopy(paramArrayOfByte, 0, this.value, this.count, i);
    this.count += i;
    return this;
  }
  
  public GrowByteBuffer putChar(char paramChar)
  {
    return putByteArray(Character.toString(paramChar).getBytes());
  }
  
  public GrowByteBuffer putDouble(double paramDouble)
  {
    return putString(Double.toString(paramDouble));
  }
  
  public GrowByteBuffer putFloat(float paramFloat)
  {
    return putString(Float.toString(paramFloat));
  }
  
  public GrowByteBuffer putInt(int paramInt)
  {
    if (paramInt == -2147483648) {
      return putByteArray(INT_MIN_BYTES);
    }
    if (paramInt < 0) {
      i = intStringSize(-paramInt) + 1;
    } else {
      i = intStringSize(paramInt);
    }
    int i = this.count + i;
    ensureCapacityInternal(i);
    getBytesFromInt(paramInt, i, this.value);
    this.count = i;
    return this;
  }
  
  public GrowByteBuffer putLong(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return putByteArray(LONG_MIN_BYTES);
    }
    if (paramLong < 0L) {
      i = longStringSize(-paramLong) + 1;
    } else {
      i = longStringSize(paramLong);
    }
    int i = this.count + i;
    ensureCapacityInternal(i);
    getBytesFromLong(paramLong, i, this.value);
    this.count = i;
    return this;
  }
  
  public GrowByteBuffer putString(String paramString)
  {
    return putByteArray(paramString.getBytes());
  }
  
  public final void reset()
  {
    this.count = 0;
    StringBuilder localStringBuilder = this.stringBuilder;
    if (localStringBuilder != null) {
      localStringBuilder.setLength(0);
    }
  }
  
  public final void trimToSize()
  {
    int i = this.count;
    byte[] arrayOfByte = this.value;
    if (i < arrayOfByte.length) {
      this.value = Arrays.copyOf(arrayOfByte, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.GrowByteBuffer
 * JD-Core Version:    0.7.0.1
 */