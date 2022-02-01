package com.tencent.tav.decoder;

import com.tencent.tav.ResourceLoadUtil;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioMixer
{
  public static final int OUTPUT_CHANNEL_COUNT = 1;
  public static final int OUTPUT_SAMPLE_RATE = 44100;
  private static final int SIGNED_SHORT_LIMIT = 32768;
  private static final String TAG = "AudioMixer";
  private static final int UNSIGNED_SHORT_MAX = 65535;
  private ByteBuffer cachedByteBuffer;
  private ByteBuffer cachedMergedBuffer;
  private short[] cachedMergedBytes;
  private int destAudioChannelCount;
  private int destAudioSampleRate;
  private ByteBuffer emptyAudioBuffer;
  private long nativeContext;
  private int pcmEncoding;
  private short[] resampleBuffer;
  private short[] sampleBuffer;
  private float sampleFactor;
  private boolean singleChannel;
  private int srcNumChannels = 1;
  private int srcSampleRate = 44100;
  
  static
  {
    if (!ResourceLoadUtil.isLoaded()) {}
    try
    {
      System.out.println("loadlibrary : tav start");
      System.loadLibrary("tav");
      ResourceLoadUtil.setLoaded(true);
      System.out.println("loadlibrary : tav end");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public AudioMixer()
  {
    this(44100, 1);
  }
  
  public AudioMixer(int paramInt1, int paramInt2)
  {
    this.destAudioSampleRate = paramInt1;
    this.destAudioChannelCount = paramInt2;
    this.nativeContext = nativeSetup(this.destAudioSampleRate, this.destAudioChannelCount);
    this.sampleFactor = 1.0F;
    if (paramInt2 == 1) {}
    for (;;)
    {
      this.singleChannel = bool;
      this.pcmEncoding = 2;
      return;
      bool = false;
    }
  }
  
  private short[] downRemix(short[] paramArrayOfShort)
  {
    ShortBuffer localShortBuffer = ShortBuffer.wrap(paramArrayOfShort);
    paramArrayOfShort = ShortBuffer.allocate(paramArrayOfShort.length);
    downRemix(localShortBuffer, paramArrayOfShort);
    return paramArrayOfShort.array();
  }
  
  private short[] getCachedSampleBuffer(int paramInt)
  {
    if ((this.sampleBuffer == null) || (this.sampleBuffer.length < paramInt))
    {
      short[] arrayOfShort = new short[paramInt];
      this.sampleBuffer = arrayOfShort;
      return arrayOfShort;
    }
    return this.sampleBuffer;
  }
  
  private int getResampleLength(int paramInt)
  {
    int i = (int)(paramInt * this.sampleFactor);
    paramInt = i;
    if (i % 2 == 1) {
      paramInt = i - 1;
    }
    return paramInt;
  }
  
  private native void nativeRelease(long paramLong);
  
  private native long nativeSetup(int paramInt1, int paramInt2);
  
  private native void readShortFromStream(long paramLong, short[] paramArrayOfShort);
  
  private short[] resample(short[] paramArrayOfShort, int paramInt)
  {
    int k = 0;
    int j = 0;
    if (this.sampleFactor == 1.0F) {
      return paramArrayOfShort;
    }
    if (Float.compare(this.sampleFactor, 0.5F) == 0) {
      return downRemix(paramArrayOfShort);
    }
    int m = getResampleLength(paramInt);
    short[] arrayOfShort;
    if ((this.resampleBuffer == null) || (this.resampleBuffer.length < m))
    {
      arrayOfShort = new short[m];
      this.resampleBuffer = arrayOfShort;
    }
    float f;
    for (;;)
    {
      f = 1.0F / this.sampleFactor;
      paramInt = k;
      if (!this.singleChannel) {
        break;
      }
      paramInt = j;
      while (paramInt < m)
      {
        int i = paramArrayOfShort[((int)(paramInt * f))];
        arrayOfShort[(paramInt + 1)] = i;
        arrayOfShort[paramInt] = i;
        paramInt += 2;
      }
      arrayOfShort = this.resampleBuffer;
    }
    while (paramInt < m)
    {
      j = (int)(paramInt * 0.5D * f) * 2;
      arrayOfShort[paramInt] = paramArrayOfShort[j];
      arrayOfShort[(paramInt + 1)] = paramArrayOfShort[(j + 1)];
      paramInt += 2;
    }
    return arrayOfShort;
  }
  
  private native int writeShortToStream(long paramLong, short[] paramArrayOfShort, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public void downRemix(ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2)
  {
    int m = Math.min(paramShortBuffer1.remaining() / 2, paramShortBuffer2.remaining());
    int i = 0;
    while (i < m)
    {
      int k = (paramShortBuffer1.get() + 32768 + (paramShortBuffer1.get() + 32768)) / 2;
      int j = k;
      if (k >= 65536) {
        j = -1;
      }
      paramShortBuffer2.put((short)(j - 32768));
      i += 1;
    }
  }
  
  protected void finalize()
  {
    release();
  }
  
  public int getDestAudioChannelCount()
  {
    return this.destAudioChannelCount;
  }
  
  public ByteBuffer mergeSamples(ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2)
  {
    ShortBuffer localShortBuffer;
    short[] arrayOfShort;
    int m;
    int j;
    label112:
    int k;
    int i;
    if ((this.cachedMergedBuffer == null) || (this.cachedMergedBuffer.capacity() < paramShortBuffer1.limit() * 2))
    {
      this.cachedMergedBuffer = ByteBuffer.allocate(paramShortBuffer1.limit() * 2);
      this.cachedMergedBuffer.order(paramShortBuffer1.order());
      if ((this.cachedMergedBytes == null) || (this.cachedMergedBytes.length < paramShortBuffer1.limit() * 2)) {
        this.cachedMergedBytes = new short[paramShortBuffer1.limit() * 2];
      }
      localShortBuffer = this.cachedMergedBuffer.asShortBuffer();
      arrayOfShort = this.cachedMergedBytes;
      m = Math.min(paramShortBuffer1.limit(), paramShortBuffer2.limit());
      j = 0;
      if (j >= m) {
        break label191;
      }
      k = paramShortBuffer1.get(j) + paramShortBuffer2.get(j);
      if (k >= -32768) {
        break label173;
      }
      i = -32768;
    }
    for (;;)
    {
      arrayOfShort[j] = ((short)i);
      j += 1;
      break label112;
      this.cachedMergedBuffer.clear();
      break;
      label173:
      i = k;
      if (k > 32767) {
        i = 32767;
      }
    }
    label191:
    localShortBuffer.put(arrayOfShort, 0, m);
    if (m < paramShortBuffer1.limit())
    {
      paramShortBuffer1.position(m);
      localShortBuffer.put(paramShortBuffer1);
    }
    this.cachedMergedBuffer.position(0);
    this.cachedMergedBuffer.limit(paramShortBuffer1.limit() * 2);
    return this.cachedMergedBuffer;
  }
  
  public ByteBuffer processBytes(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 1.0F) && (paramFloat3 == 1.0F) && (this.sampleFactor == 1.0F)) {
      return paramByteBuffer;
    }
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    if (this.pcmEncoding == 2)
    {
      localObject2 = paramByteBuffer.asShortBuffer();
      i = ((ShortBuffer)localObject2).limit();
      localObject1 = getCachedSampleBuffer(i);
      ((ShortBuffer)localObject2).get((short[])localObject1, 0, i);
      localObject2 = resample((short[])localObject1, i);
      j = getResampleLength(i);
      if (paramFloat2 != 0.0F) {
        break label268;
      }
      i = (int)(j / paramFloat1);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F) {
        break label344;
      }
      if ((this.emptyAudioBuffer == null) || (this.emptyAudioBuffer.limit() < i * 2))
      {
        this.emptyAudioBuffer = ByteBuffer.allocate(i * 2);
        this.emptyAudioBuffer.order(paramByteBuffer.order());
        this.emptyAudioBuffer.put(new byte[i * 2]);
      }
      paramByteBuffer = this.emptyAudioBuffer;
      paramByteBuffer.position(0);
      paramByteBuffer.limit(i * 2);
      return paramByteBuffer;
      if (this.pcmEncoding != 3) {
        break;
      }
      int k = paramByteBuffer.limit();
      byte[] arrayOfByte = new byte[k];
      paramByteBuffer.get(arrayOfByte, 0, k);
      localObject2 = getCachedSampleBuffer(k);
      j = 0;
      for (;;)
      {
        i = k;
        localObject1 = localObject2;
        if (j >= k) {
          break;
        }
        localObject2[j] = ((short)arrayOfByte[j]);
        j += 1;
      }
      label268:
      if ((paramFloat1 == 1.0F) && (paramFloat2 == 1.0F))
      {
        i = j;
        localObject1 = localObject2;
        if (paramFloat3 == 1.0F) {}
      }
      else
      {
        i = writeShortToStream(this.nativeContext, (short[])localObject2, j / this.destAudioChannelCount, paramFloat1, paramFloat2, paramFloat3) * this.destAudioChannelCount;
        localObject1 = getCachedSampleBuffer(i);
        readShortFromStream(this.nativeContext, (short[])localObject1);
      }
    }
    label344:
    if ((this.cachedByteBuffer == null) || (this.cachedByteBuffer.capacity() < i * 2))
    {
      localObject2 = ByteBuffer.allocate(i * 2);
      this.cachedByteBuffer = ((ByteBuffer)localObject2);
      ((ByteBuffer)localObject2).order(paramByteBuffer.order());
      paramByteBuffer = (ByteBuffer)localObject2;
    }
    for (;;)
    {
      paramByteBuffer.asShortBuffer().put((short[])localObject1, 0, i);
      break;
      paramByteBuffer = this.cachedByteBuffer;
      paramByteBuffer.clear();
    }
  }
  
  public final void release()
  {
    nativeRelease(this.nativeContext);
    this.nativeContext = 0L;
  }
  
  public void setAudioInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.srcSampleRate = paramInt1;
    this.srcNumChannels = paramInt2;
    this.sampleFactor = (this.destAudioSampleRate * this.destAudioChannelCount / (paramInt1 * paramInt2 * 1.0F));
    if (paramInt2 == 1) {}
    for (;;)
    {
      this.singleChannel = bool;
      this.pcmEncoding = paramInt3;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioMixer
 * JD-Core Version:    0.7.0.1
 */