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
  private int srcNumChannels;
  private int srcSampleRate = 44100;
  
  static
  {
    if (!ResourceLoadUtil.isLoaded()) {
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
  }
  
  public AudioMixer()
  {
    this(44100, 1);
  }
  
  public AudioMixer(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    this.srcNumChannels = 1;
    this.destAudioSampleRate = paramInt1;
    this.destAudioChannelCount = paramInt2;
    this.nativeContext = nativeSetup(this.destAudioSampleRate, this.destAudioChannelCount);
    this.sampleFactor = 1.0F;
    if (paramInt2 != 1) {
      bool = false;
    }
    this.singleChannel = bool;
    this.pcmEncoding = 2;
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
    short[] arrayOfShort = this.sampleBuffer;
    if ((arrayOfShort != null) && (arrayOfShort.length >= paramInt)) {
      return arrayOfShort;
    }
    arrayOfShort = new short[paramInt];
    this.sampleBuffer = arrayOfShort;
    return arrayOfShort;
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
    float f = this.sampleFactor;
    if (f == 1.0F) {
      return paramArrayOfShort;
    }
    if (Float.compare(f, 0.5F) == 0) {
      return downRemix(paramArrayOfShort);
    }
    int k = getResampleLength(paramInt);
    short[] arrayOfShort2 = this.resampleBuffer;
    short[] arrayOfShort1;
    if (arrayOfShort2 != null)
    {
      arrayOfShort1 = arrayOfShort2;
      if (arrayOfShort2.length >= k) {}
    }
    else
    {
      arrayOfShort1 = new short[k];
      this.resampleBuffer = arrayOfShort1;
    }
    f = 1.0F / this.sampleFactor;
    boolean bool = this.singleChannel;
    paramInt = 0;
    int j = 0;
    if (bool)
    {
      paramInt = j;
      while (paramInt < k)
      {
        int i = paramArrayOfShort[((int)(paramInt * f))];
        arrayOfShort1[(paramInt + 1)] = i;
        arrayOfShort1[paramInt] = i;
        paramInt += 2;
      }
    }
    while (paramInt < k)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      double d2 = f;
      Double.isNaN(d2);
      j = (int)(d1 * 0.5D * d2) * 2;
      arrayOfShort1[paramInt] = paramArrayOfShort[j];
      arrayOfShort1[(paramInt + 1)] = paramArrayOfShort[(j + 1)];
      paramInt += 2;
    }
    return arrayOfShort1;
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
    Object localObject = this.cachedMergedBuffer;
    if ((localObject != null) && (((ByteBuffer)localObject).capacity() >= paramShortBuffer1.limit() * 2))
    {
      this.cachedMergedBuffer.clear();
    }
    else
    {
      this.cachedMergedBuffer = ByteBuffer.allocate(paramShortBuffer1.limit() * 2);
      this.cachedMergedBuffer.order(paramShortBuffer1.order());
    }
    localObject = this.cachedMergedBytes;
    if ((localObject == null) || (localObject.length < paramShortBuffer1.limit() * 2)) {
      this.cachedMergedBytes = new short[paramShortBuffer1.limit() * 2];
    }
    localObject = this.cachedMergedBuffer.asShortBuffer();
    short[] arrayOfShort = this.cachedMergedBytes;
    int m = Math.min(paramShortBuffer1.limit(), paramShortBuffer2.limit());
    int j = 0;
    while (j < m)
    {
      int k = paramShortBuffer1.get(j) + paramShortBuffer2.get(j);
      int i;
      if (k < -32768)
      {
        i = -32768;
      }
      else
      {
        i = k;
        if (k > 32767) {
          i = 32767;
        }
      }
      arrayOfShort[j] = ((short)i);
      j += 1;
    }
    ((ShortBuffer)localObject).put(arrayOfShort, 0, m);
    if (m < paramShortBuffer1.limit())
    {
      paramShortBuffer1.position(m);
      ((ShortBuffer)localObject).put(paramShortBuffer1);
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
    int i = this.pcmEncoding;
    Object localObject1;
    if (i == 2)
    {
      localObject2 = paramByteBuffer.asShortBuffer();
      j = ((ShortBuffer)localObject2).limit();
      localObject1 = getCachedSampleBuffer(j);
      ((ShortBuffer)localObject2).get((short[])localObject1, 0, j);
    }
    else
    {
      if (i != 3) {
        return paramByteBuffer;
      }
      int k = paramByteBuffer.limit();
      byte[] arrayOfByte = new byte[k];
      paramByteBuffer.get(arrayOfByte, 0, k);
      localObject2 = getCachedSampleBuffer(k);
      i = 0;
      for (;;)
      {
        j = k;
        localObject1 = localObject2;
        if (i >= k) {
          break;
        }
        localObject2[i] = ((short)arrayOfByte[i]);
        i += 1;
      }
    }
    Object localObject2 = resample((short[])localObject1, j);
    int j = getResampleLength(j);
    if (paramFloat2 == 0.0F)
    {
      i = (int)(j / paramFloat1);
      localObject1 = localObject2;
    }
    else if ((paramFloat1 == 1.0F) && (paramFloat2 == 1.0F))
    {
      i = j;
      localObject1 = localObject2;
      if (paramFloat3 == 1.0F) {}
    }
    else
    {
      i = writeShortToStream(this.nativeContext, (short[])localObject2, j / this.destAudioChannelCount, paramFloat1, paramFloat2, paramFloat3);
      i = this.destAudioChannelCount * i;
      localObject1 = getCachedSampleBuffer(i);
      readShortFromStream(this.nativeContext, (short[])localObject1);
    }
    if (paramFloat2 == 0.0F)
    {
      localObject1 = this.emptyAudioBuffer;
      if ((localObject1 == null) || (((ByteBuffer)localObject1).limit() < i * 2))
      {
        j = i * 2;
        this.emptyAudioBuffer = ByteBuffer.allocate(j);
        this.emptyAudioBuffer.order(paramByteBuffer.order());
        this.emptyAudioBuffer.put(new byte[j]);
      }
      paramByteBuffer = this.emptyAudioBuffer;
    }
    else
    {
      localObject2 = this.cachedByteBuffer;
      if ((localObject2 != null) && (((ByteBuffer)localObject2).capacity() >= i * 2))
      {
        paramByteBuffer = this.cachedByteBuffer;
        paramByteBuffer.clear();
      }
      else
      {
        localObject2 = ByteBuffer.allocate(i * 2);
        this.cachedByteBuffer = ((ByteBuffer)localObject2);
        ((ByteBuffer)localObject2).order(paramByteBuffer.order());
        paramByteBuffer = (ByteBuffer)localObject2;
      }
      paramByteBuffer.asShortBuffer().put((short[])localObject1, 0, i);
    }
    paramByteBuffer.position(0);
    paramByteBuffer.limit(i * 2);
    return paramByteBuffer;
    return paramByteBuffer;
  }
  
  public final void release()
  {
    nativeRelease(this.nativeContext);
    this.nativeContext = 0L;
  }
  
  public void setAudioInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.srcSampleRate = paramInt1;
    this.srcNumChannels = paramInt2;
    this.sampleFactor = (this.destAudioSampleRate * this.destAudioChannelCount / (paramInt1 * paramInt2 * 1.0F));
    boolean bool = true;
    if (paramInt2 != 1) {
      bool = false;
    }
    this.singleChannel = bool;
    this.pcmEncoding = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioMixer
 * JD-Core Version:    0.7.0.1
 */