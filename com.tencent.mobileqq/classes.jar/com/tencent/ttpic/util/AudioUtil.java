package com.tencent.ttpic.util;

import com.tencent.ttpic.logic.watermark.FFTData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioUtil
{
  private static final String TAG = "AudioUtil";
  
  public static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getInt();
  }
  
  public static short byteArrayToShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getShort();
  }
  
  public static void fft(AudioUtil.Complex[] paramArrayOfComplex, int paramInt)
  {
    AudioUtil.Complex localComplex1 = new AudioUtil.Complex();
    new AudioUtil.Complex();
    int k = paramInt / 2;
    int i1 = 1;
    int i = paramInt;
    int j = 1;
    for (;;)
    {
      i /= 2;
      if (i <= 1) {
        break;
      }
      j += 1;
    }
    i = k;
    int n = 1;
    int m;
    AudioUtil.Complex localComplex2;
    for (;;)
    {
      m = i1;
      if (n > paramInt - 2) {
        break;
      }
      if (n < i)
      {
        localComplex2 = paramArrayOfComplex[i];
        paramArrayOfComplex[i] = paramArrayOfComplex[n];
        paramArrayOfComplex[n] = localComplex2;
      }
      m = k;
      while (i >= m)
      {
        i -= m;
        m /= 2;
      }
      i += m;
      n += 1;
    }
    while (m <= j)
    {
      n = (int)Math.pow(2.0D, m);
      i1 = n / 2;
      i = 0;
      while (i < i1)
      {
        double d1 = n;
        Double.isNaN(d1);
        d1 = 6.283185307179586D / d1;
        double d2 = i;
        Double.isNaN(d2);
        d1 *= d2;
        localComplex1.real = Math.cos(d1);
        localComplex1.image = (Math.sin(d1) * -1.0D);
        k = i;
        while (k < paramInt)
        {
          int i2 = k + i1;
          localComplex2 = paramArrayOfComplex[i2].cc(localComplex1);
          paramArrayOfComplex[i2] = paramArrayOfComplex[k].cut(localComplex2);
          paramArrayOfComplex[k] = paramArrayOfComplex[k].sum(localComplex2);
          k += n;
        }
        i += 1;
      }
      m += 1;
    }
  }
  
  public static int getPcmDB16Bit(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = pcm16BitToShort(paramArrayOfByte, paramInt);
    return getPcmDBFromShortBuffer(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int getPcmDB8Bit(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = pcm8BitTo16Bit(paramArrayOfByte, paramInt);
    return getPcmDBFromShortBuffer(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int getPcmDBFromShortBuffer(short[] paramArrayOfShort, int paramInt)
  {
    int j = 0;
    double d1 = 0.0D;
    int i = 0;
    while (i < paramInt)
    {
      d2 = Math.abs(paramArrayOfShort[i]);
      Double.isNaN(d2);
      d1 += d2;
      i += 1;
    }
    double d2 = paramInt;
    Double.isNaN(d2);
    d1 /= d2;
    paramInt = j;
    if (d1 > 0.0D) {
      paramInt = (int)(Math.log10(d1) * 20.0D);
    }
    return paramInt;
  }
  
  public static void getPcmFFTFromShortBuffer(short[] paramArrayOfShort, int paramInt, FFTData paramFFTData)
  {
    if (paramInt <= FFTData.BUFFER_SIZE)
    {
      if (paramInt == 0) {
        return;
      }
      int i = up2int(paramInt);
      AudioUtil.Complex[] arrayOfComplex = new AudioUtil.Complex[i];
      paramInt = 0;
      while (paramInt < i)
      {
        arrayOfComplex[paramInt] = new AudioUtil.Complex(Short.valueOf(paramArrayOfShort[paramInt]).doubleValue());
        paramInt += 1;
      }
      fft(arrayOfComplex, i);
      paramFFTData.mFFTSum = 0;
      paramFFTData.mFFTSize = (i / 2);
      i = Math.min(i, paramFFTData.mFFTBuffer.length);
      paramInt = 0;
      while (paramInt < i)
      {
        paramFFTData.mFFTBuffer[paramInt] = arrayOfComplex[paramInt].getIntValue();
        paramFFTData.mFFTSum += paramFFTData.mFFTBuffer[paramInt];
        paramInt += 1;
      }
      paramFFTData.mFFTSum /= 2;
      paramInt = i;
      while (paramInt < paramFFTData.mFFTBuffer.length)
      {
        paramFFTData.mFFTBuffer[paramInt] = 0;
        paramInt += 1;
      }
    }
  }
  
  public static short[] pcm16BitToShort(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt / 2;
    short[] arrayOfShort = new short[i];
    byte[] arrayOfByte = new byte[2];
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramInt * 2;
      arrayOfByte[0] = paramArrayOfByte[j];
      arrayOfByte[1] = paramArrayOfByte[(j + 1)];
      arrayOfShort[paramInt] = byteArrayToShort(arrayOfByte);
      paramInt += 1;
    }
    return arrayOfShort;
  }
  
  private static short[] pcm8BitTo16Bit(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[i] - 128 << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  private static int up2int(int paramInt)
  {
    int i = 1;
    while (i <= paramInt) {
      i <<= 1;
    }
    return i >> 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtil
 * JD-Core Version:    0.7.0.1
 */