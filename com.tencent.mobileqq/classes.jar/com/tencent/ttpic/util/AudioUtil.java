package com.tencent.ttpic.util;

import com.tencent.ttpic.logic.watermark.FFTData;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class AudioUtil
{
  private static final String TAG = AudioUtil.class.getSimpleName();
  
  public static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getInt();
  }
  
  public static short byteArrayToShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getShort();
  }
  
  public static void cutOrExtendAudio(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      paramString = new RandomAccessFile(paramString, "rws");
      paramString.setLength(paramInt1 * paramInt2 * paramLong / 8L / 1000L * paramInt3);
      paramString.close();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void fft(AudioUtil.Complex[] paramArrayOfComplex, int paramInt)
  {
    AudioUtil.Complex localComplex1 = new AudioUtil.Complex();
    new AudioUtil.Complex();
    int k = paramInt / 2;
    int j = 1;
    int i = paramInt;
    for (;;)
    {
      i /= 2;
      if (i <= 1) {
        break;
      }
      j += 1;
    }
    i = k;
    int m = 1;
    AudioUtil.Complex localComplex2;
    int n;
    while (m <= paramInt - 2)
    {
      if (m < i)
      {
        localComplex2 = paramArrayOfComplex[i];
        paramArrayOfComplex[i] = paramArrayOfComplex[m];
        paramArrayOfComplex[m] = localComplex2;
      }
      n = k;
      while (i >= n)
      {
        i -= n;
        n /= 2;
      }
      i += n;
      m += 1;
    }
    k = 1;
    while (k <= j)
    {
      n = (int)Math.pow(2.0D, k);
      int i1 = n / 2;
      i = 0;
      while (i < i1)
      {
        double d = 6.283185307179586D / n;
        localComplex1.real = Math.cos(i * d);
        localComplex1.image = (Math.sin(d * i) * -1.0D);
        m = i;
        while (m < paramInt)
        {
          int i2 = m + i1;
          localComplex2 = paramArrayOfComplex[i2].cc(localComplex1);
          paramArrayOfComplex[i2] = paramArrayOfComplex[m].cut(localComplex2);
          paramArrayOfComplex[m] = paramArrayOfComplex[m].sum(localComplex2);
          m += n;
        }
        i += 1;
      }
      k += 1;
    }
  }
  
  public static long getAudioDuration(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return 0L;
    }
    return paramString.length() * 1000L / (paramInt1 * paramInt2 * paramInt3 / 8);
  }
  
  public static double getFFTDB(byte[] paramArrayOfByte, int paramInt)
  {
    double d1 = 0.0D;
    int i = paramArrayOfByte.length;
    paramInt = 0;
    while (paramInt < i / 2)
    {
      int j = paramArrayOfByte[(paramInt * 2)];
      int k = paramArrayOfByte[(paramInt * 2 + 1)];
      double d2 = j;
      double d3 = j;
      d1 += Math.log10((k * k + d2 * d3) * 4.0D / (i * i)) * 10.0D;
      paramInt += 1;
    }
    return d1 / (i / 2);
  }
  
  public static int getFrameGain(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    int i1 = paramArrayOfByte.remaining() / 4;
    paramArrayOfByte.rewind();
    paramArrayOfByte.order(ByteOrder.LITTLE_ENDIAN);
    paramArrayOfByte = paramArrayOfByte.asShortBuffer();
    int j = 0;
    double d = 0.0D;
    int i = -1;
    if (j < i1)
    {
      int k = 0;
      int n;
      for (int m = 0; k < 2; m = n)
      {
        n = m;
        if (paramArrayOfByte.remaining() > 0) {
          n = m + Math.abs(paramArrayOfByte.get());
        }
        k += 1;
      }
      d += m;
      k = m / 2;
      if (i >= k) {
        break label147;
      }
      i = k;
    }
    label147:
    for (;;)
    {
      j += 1;
      break;
      j = (int)(Math.log10(d / (i1 * 2)) * 20.0D);
      return (int)Math.sqrt(i);
    }
  }
  
  public static int getFrameGain(short[] paramArrayOfShort, int paramInt)
  {
    int n = paramInt / 2;
    paramInt = -1;
    int j = 0;
    int i = 0;
    if (j < n)
    {
      int m = 0;
      int k = 0;
      while (k < 2)
      {
        m += Math.abs(paramArrayOfShort[i]);
        k += 1;
        i += 1;
      }
      k = m / 2;
      if (paramInt >= k) {
        break label88;
      }
      paramInt = k;
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      return (int)((int)Math.sqrt(paramInt) * 0.7D);
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
  
  public static int getPcmDB8BitV1(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    double d = 0.0D;
    while (i < k)
    {
      d += Math.abs((short)(paramArrayOfByte[i] - 128 << 8));
      i += 1;
    }
    d /= k;
    i = j;
    if (d > 0.0D) {
      i = (int)(20.0D * Math.log10(d));
    }
    return i;
  }
  
  public static int getPcmDBFromShortBuffer(short[] paramArrayOfShort, int paramInt)
  {
    int j = 0;
    int i = 0;
    double d = 0.0D;
    while (i < paramInt)
    {
      d += Math.abs(paramArrayOfShort[i]);
      i += 1;
    }
    d /= paramInt;
    paramInt = j;
    if (d > 0.0D) {
      paramInt = (int)(20.0D * Math.log10(d));
    }
    return paramInt;
  }
  
  public static void getPcmFFTFromShortBuffer(short[] paramArrayOfShort, int paramInt, FFTData paramFFTData)
  {
    if ((paramInt > FFTData.BUFFER_SIZE) || (paramInt == 0)) {}
    for (;;)
    {
      return;
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
  
  private static int getSamplesPerFrame()
  {
    return 1024;
  }
  
  public static short[] pcm16BitToShort(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    byte[] arrayOfByte = new byte[2];
    int i = 0;
    while (i < paramInt / 2)
    {
      arrayOfByte[0] = paramArrayOfByte[(i * 2)];
      arrayOfByte[1] = paramArrayOfByte[(i * 2 + 1)];
      arrayOfShort[i] = byteArrayToShort(arrayOfByte);
      i += 1;
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
  
  public static byte[] trimData(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length - 1;
    while ((i >= 0) && (paramArrayOfByte[i] == paramInt)) {
      i -= 1;
    }
    return Arrays.copyOf(paramArrayOfByte, i + 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtil
 * JD-Core Version:    0.7.0.1
 */