package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WaveWriter
{
  private static final int OUTPUT_STREAM_BUFFER = 16384;
  private static final String TAG = "WaveWriter";
  private int mBytesWritten;
  private int mChannels;
  private File mOutFile;
  private BufferedOutputStream mOutStream;
  private int mSampleBits;
  private int mSampleRate;
  private ByteArrayOutputStream mTmpStream;
  
  public WaveWriter(File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mOutFile = paramFile;
    this.mSampleRate = paramInt1;
    this.mChannels = paramInt2;
    this.mSampleBits = paramInt3;
    this.mBytesWritten = 0;
  }
  
  public WaveWriter(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    this.mOutFile = new File(localStringBuilder.toString());
    this.mSampleRate = paramInt1;
    this.mChannels = paramInt2;
    this.mSampleBits = paramInt3;
    this.mBytesWritten = 0;
  }
  
  private short[] interpolate(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfShort;
    }
    int j = Math.round(paramArrayOfShort.length / paramInt1 * paramInt2);
    float f1 = j / paramArrayOfShort.length;
    short[] arrayOfShort = new short[j];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      float f2 = paramInt1 / f1;
      int k = (int)f2;
      int i = k + 1;
      paramInt2 = i;
      if (i >= paramArrayOfShort.length) {
        paramInt2 = paramArrayOfShort.length - 1;
      }
      arrayOfShort[paramInt1] = ((short)(int)((paramArrayOfShort[paramInt2] - paramArrayOfShort[k]) * (f2 - k) + paramArrayOfShort[k]));
      paramInt1 += 1;
    }
    return arrayOfShort;
  }
  
  private byte[] reSample(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1 / 8;
    if (i1 <= 0) {
      return null;
    }
    int i2 = paramArrayOfByte.length / i1;
    Object localObject = new short[i2];
    int n = 0;
    int m = 0;
    int j = 0;
    paramInt1 = 0;
    while (j < i2)
    {
      int k = 0;
      int i = 0;
      while (k < i1)
      {
        i = (short)(i | (short)((paramArrayOfByte[paramInt1] & 0xFF) << k * 8));
        k += 1;
        paramInt1 += 1;
      }
      localObject[j] = i;
      j += 1;
    }
    short[] arrayOfShort = interpolate(paramInt2, paramInt3, (short[])localObject);
    paramInt2 = arrayOfShort.length;
    if (i1 == 1)
    {
      localObject = new byte[paramInt2];
      paramInt1 = m;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt1 >= paramInt2) {
          break;
        }
        localObject[paramInt1] = ((byte)arrayOfShort[paramInt1]);
        paramInt1 += 1;
      }
    }
    localObject = new byte[paramInt2 * 2];
    paramInt1 = n;
    for (;;)
    {
      paramArrayOfByte = (byte[])localObject;
      if (paramInt1 >= arrayOfShort.length) {
        break;
      }
      paramInt2 = paramInt1 * 2;
      localObject[paramInt2] = ((byte)(arrayOfShort[paramInt1] & 0xFF));
      localObject[(paramInt2 + 1)] = ((byte)(arrayOfShort[paramInt1] >> 8 & 0xFF));
      paramInt1 += 1;
    }
    this.mSampleRate = paramInt3;
    return paramArrayOfByte;
  }
  
  private static void writeUnsignedShortLE(ByteArrayOutputStream paramByteArrayOutputStream, short paramShort)
  {
    paramByteArrayOutputStream.write(paramShort);
    paramByteArrayOutputStream.write(paramShort >> 8);
  }
  
  private void writeWaveHeader()
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.mOutFile, "rw");
    localRandomAccessFile.seek(0L);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    int i = (this.mSampleBits + 7) / 8;
    try
    {
      localDataOutputStream.writeBytes("RIFF");
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten + 36));
      localDataOutputStream.writeBytes("WAVE");
      localDataOutputStream.writeBytes("fmt ");
      localDataOutputStream.writeInt(Integer.reverseBytes(16));
      localDataOutputStream.writeShort(Short.reverseBytes((short)1));
      localDataOutputStream.writeShort(Short.reverseBytes((short)this.mChannels));
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate));
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate * this.mChannels * i));
      localDataOutputStream.writeShort(Short.reverseBytes((short)(this.mChannels * i)));
      localDataOutputStream.writeShort(Short.reverseBytes((short)this.mSampleBits));
      localDataOutputStream.writeBytes("data");
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten));
      localByteArrayOutputStream.flush();
      localRandomAccessFile.write(localByteArrayOutputStream.toByteArray());
      return;
    }
    finally
    {
      localByteArrayOutputStream.close();
      localDataOutputStream.close();
      localRandomAccessFile.close();
    }
  }
  
  public byte[] changeStereoToMono(byte[] paramArrayOfByte)
  {
    int i = this.mChannels;
    byte[] arrayOfByte = paramArrayOfByte;
    if (i == 2)
    {
      int k = this.mSampleBits / 8;
      long l = paramArrayOfByte.length / i / k;
      arrayOfByte = new byte[(int)(k * l)];
      i = 0;
      while (i < l)
      {
        int j = 0;
        while (j < k)
        {
          int m = this.mChannels;
          arrayOfByte[(i * k + j)] = ((byte)((paramArrayOfByte[(i * m * k + j)] + paramArrayOfByte[((m * i + 1) * k + j)]) / 2));
          j += 1;
        }
        i += 1;
      }
      this.mChannels = 1;
    }
    return arrayOfByte;
  }
  
  public void closeWaveFile()
  {
    Object localObject = this.mOutStream;
    if (localObject != null)
    {
      ((BufferedOutputStream)localObject).flush();
      this.mOutStream.close();
    }
    localObject = this.mTmpStream;
    if (localObject != null)
    {
      ((ByteArrayOutputStream)localObject).flush();
      this.mTmpStream.close();
    }
    writeWaveHeader();
  }
  
  public boolean createWaveFile()
  {
    if (this.mOutFile.exists()) {
      this.mOutFile.delete();
    }
    this.mOutFile.getParentFile().mkdirs();
    if (this.mOutFile.createNewFile())
    {
      this.mOutStream = new BufferedOutputStream(new FileOutputStream(this.mOutFile), 16384);
      this.mTmpStream = new ByteArrayOutputStream();
      this.mOutStream.write(new byte[44]);
      return true;
    }
    return false;
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  public boolean reSampler()
  {
    try
    {
      byte[] arrayOfByte = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
      if (arrayOfByte == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTmpStream length = ");
      localStringBuilder.append(this.mTmpStream.toByteArray().length);
      Logger.d("WaveWriter", localStringBuilder.toString());
      arrayOfByte = changeStereoToMono(arrayOfByte);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("monoData length = ");
      localStringBuilder.append(arrayOfByte.length);
      Logger.d("WaveWriter", localStringBuilder.toString());
      arrayOfByte = reSample(arrayOfByte, this.mSampleBits, 8000, 4000);
      if (arrayOfByte == null) {
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultData length = ");
      localStringBuilder.append(arrayOfByte.length);
      Logger.d("WaveWriter", localStringBuilder.toString());
      this.mBytesWritten = arrayOfByte.length;
      this.mOutStream.write(arrayOfByte);
      return true;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("WaveWriter", localThrowable);
    }
    return false;
  }
  
  public boolean reSamplerTo8K()
  {
    try
    {
      byte[] arrayOfByte = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
      if (arrayOfByte == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTmpStream length = ");
      localStringBuilder.append(this.mTmpStream.toByteArray().length);
      Logger.d("WaveWriter", localStringBuilder.toString());
      arrayOfByte = changeStereoToMono(arrayOfByte);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultData length = ");
      localStringBuilder.append(arrayOfByte.length);
      Logger.d("WaveWriter", localStringBuilder.toString());
      this.mBytesWritten = arrayOfByte.length;
      this.mOutStream.write(arrayOfByte);
      return true;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("WaveWriter", localThrowable);
    }
    return false;
  }
  
  public void setSampleByte(int paramInt)
  {
    this.mSampleBits = paramInt;
  }
  
  public void write(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort[paramInt1]);
        this.mBytesWritten += 2;
        paramInt1 += 1;
      }
      return;
    }
    paramArrayOfShort = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    for (;;)
    {
      throw paramArrayOfShort;
    }
  }
  
  public void write(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt1, int paramInt2)
  {
    if (this.mChannels != 2) {
      return;
    }
    if (paramInt1 <= paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort1[paramInt1]);
        writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort2[paramInt1]);
        this.mBytesWritten += 4;
        paramInt1 += 1;
      }
      return;
    }
    paramArrayOfShort1 = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    for (;;)
    {
      throw paramArrayOfShort1;
    }
  }
  
  public void writeDone()
  {
    try
    {
      this.mOutStream.write(this.mTmpStream.toByteArray());
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e("WaveWriter", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.WaveWriter
 * JD-Core Version:    0.7.0.1
 */