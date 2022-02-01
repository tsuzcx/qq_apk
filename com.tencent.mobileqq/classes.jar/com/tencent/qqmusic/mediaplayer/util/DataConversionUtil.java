package com.tencent.qqmusic.mediaplayer.util;

import java.nio.ByteOrder;

public class DataConversionUtil
{
  private static final float BASE_16BIT = 32768.0F;
  private static final float BASE_32BIT = 2.147484E+009F;
  private static final boolean IS_LITTLE_ENDIAN;
  
  static
  {
    boolean bool;
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      bool = true;
    } else {
      bool = false;
    }
    IS_LITTLE_ENDIAN = bool;
  }
  
  public static int byteArray16BitToShortArray(byte[] paramArrayOfByte, int paramInt, short[] paramArrayOfShort)
  {
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkShortArrayLength(paramArrayOfShort, paramInt / 2);
    if (paramInt % 2 == 0)
    {
      int k = 0;
      int j = 0;
      while ((k < paramInt) && (j < paramArrayOfShort.length))
      {
        int i;
        if (IS_LITTLE_ENDIAN) {
          i = bytesToShort16bitInLittleEndian(paramArrayOfByte, k);
        } else {
          i = bytesToShort16bitInBigEndian(paramArrayOfByte, k);
        }
        paramArrayOfShort[j] = i;
        k += 2;
        j += 1;
      }
      return j;
    }
    paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 2");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static int byteArray24BitToIntArray(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkIntArrayLength(paramArrayOfInt, paramInt / 3);
    if (paramInt % 3 == 0)
    {
      int j = 0;
      int i = 0;
      while ((j < paramInt) && (i < paramArrayOfInt.length))
      {
        int k;
        if (IS_LITTLE_ENDIAN) {
          k = bytesToInt24bitInLittleEndian(paramArrayOfByte, j);
        } else {
          k = bytesToInt24bitInBigEndian(paramArrayOfByte, j);
        }
        paramArrayOfInt[i] = k;
        j += 3;
        i += 1;
      }
      return i;
    }
    paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 3");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static int byteArray32BitToIntArray(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkIntArrayLength(paramArrayOfInt, paramInt / 4);
    if (paramInt % 4 == 0)
    {
      int j = 0;
      int i = 0;
      while ((j < paramInt) && (i < paramArrayOfInt.length))
      {
        int k;
        if (IS_LITTLE_ENDIAN) {
          k = bytesToInt32bitInLittleEndian(paramArrayOfByte, j);
        } else {
          k = bytesToInt32bitInBigEndian(paramArrayOfByte, j);
        }
        paramArrayOfInt[i] = k;
        j += 4;
        i += 1;
      }
      return i;
    }
    paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 4");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static int byteArrayToFloatArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    checkByteArrayLength(paramArrayOfByte, paramInt1);
    checkFloatArrayLength(paramArrayOfFloat, paramInt1 / paramInt2);
    checkByteArrayProperty(paramInt1, paramInt2);
    int j = 0;
    int i = 0;
    while (j < paramInt1)
    {
      int k = j / paramInt2;
      float f;
      if (paramInt2 == 3) {
        f = bytesToFloat24bit(paramArrayOfByte, j);
      } else {
        f = bytesToFloat32bit(paramArrayOfByte, j);
      }
      paramArrayOfFloat[k] = f;
      j += paramInt2;
      i += 1;
    }
    return i;
  }
  
  public static float bytesToFloat24bit(byte[] paramArrayOfByte, int paramInt)
  {
    if (IS_LITTLE_ENDIAN) {
      return bytesToFloat24bitInLittleEndian(paramArrayOfByte, paramInt);
    }
    return bytesToFloat24bitInBigEndian(paramArrayOfByte, paramInt);
  }
  
  public static float bytesToFloat24bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return bytesToInt24bitInBigEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
  }
  
  public static float bytesToFloat24bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return bytesToInt24bitInLittleEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
  }
  
  public static float bytesToFloat32bit(byte[] paramArrayOfByte, int paramInt)
  {
    if (IS_LITTLE_ENDIAN) {
      return bytesToFloat32bitInLittleEndian(paramArrayOfByte, paramInt);
    }
    return bytesToFloat32bitInBigEndian(paramArrayOfByte, paramInt);
  }
  
  public static float bytesToFloat32bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return bytesToInt32bitInBigEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
  }
  
  public static float bytesToFloat32bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return bytesToInt32bitInLittleEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
  }
  
  public static int bytesToInt24bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 2)];
    int j = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | i << 8 & 0xFF | (j & 0xFF) << 16;
  }
  
  public static int bytesToInt24bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 24 | i << 8 & 0xFF | (j & 0xFF) << 16;
  }
  
  public static int bytesToInt32bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static int bytesToInt32bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static short bytesToShort16bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 1)];
    return (short)((paramArrayOfByte[paramInt] & 0xFF) << 8 | i & 0xFF);
  }
  
  public static short bytesToShort16bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | i & 0xFF);
  }
  
  private static void checkByteArrayLength(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramInt <= paramArrayOfByte.length) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the length param can not larger than byte Array length. param:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", byte array length:");
      localStringBuilder.append(paramArrayOfByte.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("byte Array must not be null or zero length");
  }
  
  private static void checkByteArrayProperty(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 4) && (paramInt2 >= 3))
    {
      if (paramInt1 % paramInt2 == 0) {
        return;
      }
      throw new IllegalArgumentException("length of byteArray must be multiple of bytesPerSample");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytesPerSample of ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" is not supported");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void checkFloatArrayLength(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0))
    {
      if (paramInt <= paramArrayOfFloat.length) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the length param can not larger than float Array length. param:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", float array length:");
      localStringBuilder.append(paramArrayOfFloat.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("float Array must not be null or zero length");
  }
  
  private static void checkIntArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      if (paramInt <= paramArrayOfInt.length) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the length param can not larger than int Array length. param:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", int array length:");
      localStringBuilder.append(paramArrayOfInt.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("int Array must not be null or zero length");
  }
  
  private static void checkShortArrayLength(short[] paramArrayOfShort, int paramInt)
  {
    if ((paramArrayOfShort != null) && (paramArrayOfShort.length != 0))
    {
      if (paramInt <= paramArrayOfShort.length) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the length param can not larger than short Array length. param:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", short array length:");
      localStringBuilder.append(paramArrayOfShort.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("short Array must not be null or zero length");
  }
  
  public static void floatTo2Bytes(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f < -1.0F) {
      paramFloat = -1.0F;
    }
    shortTo2Bytes((short)(int)(paramFloat * 32768.0F), paramArrayOfByte, paramInt);
  }
  
  public static int intArrayToByteArray24Bit(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    checkIntArrayLength(paramArrayOfInt, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 3);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      intTo3Bytes(paramArrayOfInt[j], paramArrayOfByte, i);
      j += 1;
      i += 3;
    }
    return i;
  }
  
  public static int intArrayToByteArray32Bit(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    checkIntArrayLength(paramArrayOfInt, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 4);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      intTo4Bytes(paramArrayOfInt[j], paramArrayOfByte, i);
      j += 1;
      i += 4;
    }
    return i;
  }
  
  public static void intTo3Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 8 & 0xFF));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 24 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public static void intTo4Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16 & 0xFF));
      paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public static int shortArrayToByteArray16Bit(short[] paramArrayOfShort, int paramInt, byte[] paramArrayOfByte)
  {
    checkShortArrayLength(paramArrayOfShort, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 2);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      shortTo2Bytes(paramArrayOfShort[j], paramArrayOfByte, i);
      j += 1;
      i += 2;
    }
    return i;
  }
  
  public static void shortTo2Bytes(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt] = ((byte)(paramShort & 0xFF));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >> 8 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.DataConversionUtil
 * JD-Core Version:    0.7.0.1
 */