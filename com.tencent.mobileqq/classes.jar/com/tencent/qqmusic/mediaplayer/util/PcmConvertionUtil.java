package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public class PcmConvertionUtil
{
  private static void checkArrayLength(int[] paramArrayOfInt, int paramInt)
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
  
  private static void checkArrayLength(short[] paramArrayOfShort, int paramInt)
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
  
  private static void checkBufferLength(BufferInfo paramBufferInfo)
  {
    if ((paramBufferInfo != null) && (paramBufferInfo.byteBuffer != null) && (paramBufferInfo.bufferSize > 0)) {
      return;
    }
    throw new IllegalArgumentException("bufferInfo must not be null or zero length");
  }
  
  private static void convertBitDepth24To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 != null)
    {
      if (paramInt == 3)
      {
        int k = paramBufferInfo1.bufferSize;
        paramBufferInfo2.setTempByteBufferCapacity(paramBufferInfo1.bufferSize);
        paramInt = 0;
        int j;
        for (int i = 0; paramInt < k; i = j)
        {
          j = i;
          if (paramInt % 3 != 0)
          {
            paramBufferInfo2.tempByteBuffer[i] = paramBufferInfo1.byteBuffer[paramInt];
            j = i + 1;
          }
          paramInt += 1;
        }
        paramBufferInfo2.fillByte(paramBufferInfo2.tempByteBuffer, i);
        paramBufferInfo2.bufferSize = i;
        return;
      }
      throw new IllegalArgumentException("origin bit depth must be 3");
    }
    paramBufferInfo1 = new IllegalArgumentException("BufferInfo dest must not be null");
    for (;;)
    {
      throw paramBufferInfo1;
    }
  }
  
  private static void convertBitDepth32To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 != null)
    {
      if (paramInt == 4)
      {
        int j = paramBufferInfo1.bufferSize;
        paramBufferInfo2.setTempByteBufferCapacity(paramBufferInfo1.bufferSize);
        paramInt = 0;
        int i = 0;
        while (paramInt < j)
        {
          DataConversionUtil.floatTo2Bytes(DataConversionUtil.bytesToFloat32bitInLittleEndian(paramBufferInfo1.byteBuffer, paramInt), paramBufferInfo2.tempByteBuffer, i);
          i += 2;
          paramInt += 4;
        }
        paramBufferInfo2.fillByte(paramBufferInfo2.tempByteBuffer, i);
        paramBufferInfo2.bufferSize = i;
        return;
      }
      throw new IllegalArgumentException("origin bit depth must be 4");
    }
    paramBufferInfo1 = new IllegalArgumentException("BufferInfo dest must not be null");
    for (;;)
    {
      throw paramBufferInfo1;
    }
  }
  
  public static void convertBitDepthTo16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt == 4)
        {
          convertBitDepth32To16(paramBufferInfo1, paramBufferInfo2, paramInt);
          return;
        }
        paramBufferInfo1 = new StringBuilder();
        paramBufferInfo1.append("not support originBitDepth, originBitDepth=");
        paramBufferInfo1.append(paramInt);
        throw new IllegalArgumentException(paramBufferInfo1.toString());
      }
      convertBitDepth24To16(paramBufferInfo1, paramBufferInfo2, paramInt);
      return;
    }
    checkBufferLength(paramBufferInfo1);
    paramBufferInfo1.fillInto(paramBufferInfo2);
  }
  
  public static void convertByteBufferToFloatBuffer(BufferInfo paramBufferInfo, FloatBufferInfo paramFloatBufferInfo, int paramInt)
  {
    checkBufferLength(paramBufferInfo);
    if (paramFloatBufferInfo != null)
    {
      if (paramInt > 0)
      {
        paramFloatBufferInfo.setTempFloatBufferCapacity(paramBufferInfo.bufferSize / paramInt);
        paramFloatBufferInfo.bufferSize = (paramBufferInfo.bufferSize / paramInt);
        DataConversionUtil.byteArrayToFloatArray(paramBufferInfo.byteBuffer, paramBufferInfo.bufferSize, paramInt, paramFloatBufferInfo.tempFloatBuffer);
        paramFloatBufferInfo.fillFloat(paramFloatBufferInfo.tempFloatBuffer, paramFloatBufferInfo.bufferSize);
        return;
      }
      throw new IllegalArgumentException("bit depth must not be zero");
    }
    throw new IllegalArgumentException("BufferInfo dest must not be null");
  }
  
  private static void interpolateIn16Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    int i = paramBufferInfo1.bufferSize / 2;
    float f = i;
    int j = Math.round(1.0F * f / (float)paramLong1 * (float)paramLong2);
    f = j / f;
    short[] arrayOfShort2 = new short[i];
    short[] arrayOfShort1 = new short[j];
    DataConversionUtil.byteArray16BitToShortArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfShort2);
    linearInterpolate(arrayOfShort2, i, arrayOfShort1, j, f);
    paramBufferInfo1 = new byte[arrayOfShort1.length * 2];
    DataConversionUtil.shortArrayToByteArray16Bit(arrayOfShort1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
  }
  
  private static void interpolateIn24Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    int i = paramBufferInfo1.bufferSize / 3;
    float f = i;
    int j = Math.round(1.0F * f / (float)paramLong1 * (float)paramLong2);
    f = j / f;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[j];
    DataConversionUtil.byteArray24BitToIntArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfInt2);
    linearInterpolate(arrayOfInt2, i, arrayOfInt1, j, f);
    paramBufferInfo1 = new byte[arrayOfInt1.length * 3];
    DataConversionUtil.intArrayToByteArray24Bit(arrayOfInt1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
  }
  
  private static void interpolateIn32Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    int i = paramBufferInfo1.bufferSize / 4;
    float f = i;
    int j = Math.round(1.0F * f / (float)paramLong1 * (float)paramLong2);
    f = j / f;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[j];
    DataConversionUtil.byteArray32BitToIntArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfInt2);
    linearInterpolate(arrayOfInt2, i, arrayOfInt1, j, f);
    paramBufferInfo1 = new byte[arrayOfInt1.length * 4];
    DataConversionUtil.intArrayToByteArray32Bit(arrayOfInt1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
  }
  
  private static void linearInterpolate(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, float paramFloat)
  {
    checkArrayLength(paramArrayOfInt1, paramInt1);
    checkArrayLength(paramArrayOfInt2, paramInt2);
    int i = 0;
    while (i < paramInt2)
    {
      float f = i / paramFloat;
      int m = (int)f;
      int k = m + 1;
      int j = k;
      if (k >= paramInt1) {
        j = paramInt1 - 1;
      }
      paramArrayOfInt2[i] = ((int)((paramArrayOfInt1[j] - paramArrayOfInt1[m]) * (f - m) + paramArrayOfInt1[m]));
      i += 1;
    }
  }
  
  private static void linearInterpolate(short[] paramArrayOfShort1, int paramInt1, short[] paramArrayOfShort2, int paramInt2, float paramFloat)
  {
    checkArrayLength(paramArrayOfShort1, paramInt1);
    checkArrayLength(paramArrayOfShort2, paramInt2);
    int i = 0;
    while (i < paramInt2)
    {
      float f = i / paramFloat;
      int m = (int)f;
      int k = m + 1;
      int j = k;
      if (k >= paramInt1) {
        j = paramInt1 - 1;
      }
      paramArrayOfShort2[i] = ((short)(int)((paramArrayOfShort1[j] - paramArrayOfShort1[m]) * (f - m) + paramArrayOfShort1[m]));
      i += 1;
    }
  }
  
  public static void reSample(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 != null)
    {
      if ((paramLong1 != paramLong2) && (paramLong2 > 0L) && (paramLong1 > 0L))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramBufferInfo1.fillInto(paramBufferInfo2);
              return;
            }
            interpolateIn32Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
            return;
          }
          interpolateIn24Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
          return;
        }
        interpolateIn16Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
        return;
      }
      paramBufferInfo1.fillInto(paramBufferInfo2);
      return;
    }
    throw new IllegalArgumentException("BufferInfo dest must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil
 * JD-Core Version:    0.7.0.1
 */