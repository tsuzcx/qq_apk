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
  private int length;
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
    this.length = paramInt;
    this.count = 0;
  }
  
  private void ensureCapacityInternal(int paramInt)
  {
    if (paramInt - this.value.length > 0) {
      this.value = Arrays.copyOf(this.value, newCapacity(paramInt));
    }
  }
  
  private static void getBytesFromInt(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int j;
    int i;
    if (paramInt1 < 0)
    {
      j = -paramInt1;
      i = 45;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      int k = paramInt1;
      j = paramInt2;
      if (paramInt2 >= 65536)
      {
        j = paramInt2 / 100;
        paramInt2 -= (j << 6) + (j << 5) + (j << 2);
        paramInt1 -= 1;
        paramArrayOfByte[paramInt1] = DigitOnes[paramInt2];
        paramInt1 -= 1;
        paramArrayOfByte[paramInt1] = DigitTens[paramInt2];
        paramInt2 = j;
      }
      else
      {
        do
        {
          j = paramInt1;
          paramInt1 = 52429 * j >>> 19;
          k -= 1;
          paramArrayOfByte[k] = digits[(j - ((paramInt1 << 3) + (paramInt1 << 1)))];
        } while (paramInt1 != 0);
        if (i != 0) {
          paramArrayOfByte[(k - 1)] = i;
        }
        return;
        i = 0;
        j = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = j;
      }
    }
  }
  
  private static void getBytesFromLong(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i;
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      i = 45;
    }
    for (;;)
    {
      int j;
      if (paramLong > 2147483647L)
      {
        long l = paramLong / 100L;
        j = (int)(paramLong - ((l << 6) + (l << 5) + (l << 2)));
        paramInt -= 1;
        paramArrayOfByte[paramInt] = DigitOnes[j];
        paramInt -= 1;
        paramArrayOfByte[paramInt] = DigitTens[j];
        paramLong = l;
      }
      else
      {
        int k = (int)paramLong;
        j = paramInt;
        paramInt = k;
        while (paramInt >= 65536)
        {
          k = paramInt / 100;
          paramInt -= (k << 6) + (k << 5) + (k << 2);
          j -= 1;
          paramArrayOfByte[j] = DigitOnes[paramInt];
          j -= 1;
          paramArrayOfByte[j] = DigitTens[paramInt];
          paramInt = k;
          continue;
          paramInt = k;
        }
        for (;;)
        {
          k = 52429 * paramInt >>> 19;
          j -= 1;
          paramArrayOfByte[j] = digits[(paramInt - ((k << 3) + (k << 1)))];
          if (k != 0) {
            break;
          }
          if (i != 0) {
            paramArrayOfByte[(j - 1)] = i;
          }
          return;
        }
        i = 0;
      }
    }
  }
  
  private int hugeCapacity(int paramInt)
  {
    if (2147483647 - paramInt < 0) {
      throw new OutOfMemoryError();
    }
    if (paramInt > 2147483639) {
      return paramInt;
    }
    return 2147483639;
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
    if (paramBoolean) {}
    for (byte[] arrayOfByte = TRUE_BYTES;; arrayOfByte = FALSE_BYTES) {
      return putByteArray(arrayOfByte);
    }
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
    this.count = (i + this.count);
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
    if (paramInt < 0) {}
    for (int i = intStringSize(-paramInt) + 1;; i = intStringSize(paramInt))
    {
      i += this.count;
      ensureCapacityInternal(i);
      getBytesFromInt(paramInt, i, this.value);
      this.count = i;
      return this;
    }
  }
  
  public GrowByteBuffer putLong(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return putByteArray(LONG_MIN_BYTES);
    }
    if (paramLong < 0L) {}
    for (int i = longStringSize(-paramLong) + 1;; i = longStringSize(paramLong))
    {
      i += this.count;
      ensureCapacityInternal(i);
      getBytesFromLong(paramLong, i, this.value);
      this.count = i;
      return this;
    }
  }
  
  public GrowByteBuffer putString(String paramString)
  {
    return putByteArray(paramString.getBytes());
  }
  
  public final void reset()
  {
    this.count = 0;
    if (this.stringBuilder != null) {
      this.stringBuilder.setLength(0);
    }
  }
  
  public final void trimToSize()
  {
    if (this.count < this.value.length) {
      this.value = Arrays.copyOf(this.value, this.count);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.GrowByteBuffer
 * JD-Core Version:    0.7.0.1
 */