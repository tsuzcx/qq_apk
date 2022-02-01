package com.tencent.tav.core;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor
{
  private final String TAG;
  private AudioMixer audioMixer;
  @NonNull
  private final AudioResample audioResample;
  private ShortBuffer currentSamples;
  private ShortBuffer lastSamples;
  
  public AudioCompositor(AudioInfo paramAudioInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioCompositor@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.audioResample = new AudioResample();
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
  
  private AudioInfo resample(CMSampleBuffer paramCMSampleBuffer, AudioInfo paramAudioInfo)
  {
    Object localObject1 = paramCMSampleBuffer.getSampleByteBuffer();
    if ((localObject1 != null) && (((ByteBuffer)localObject1).limit() > 0))
    {
      localObject2 = this.audioResample.resample((ByteBuffer)localObject1, paramAudioInfo);
      if (localObject2 != null)
      {
        paramAudioInfo = this.audioResample.getDestAudioInfo();
        localObject1 = localObject2;
      }
      paramCMSampleBuffer.setSampleByteBuffer((ByteBuffer)localObject1);
      return paramAudioInfo;
    }
    paramCMSampleBuffer = this.audioResample.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resample: 不进行重采样 byteBuffer = ");
    ((StringBuilder)localObject2).append(localObject1);
    Logger.d(paramCMSampleBuffer, ((StringBuilder)localObject2).toString());
    return paramAudioInfo;
  }
  
  public void clear()
  {
    try
    {
      this.currentSamples = null;
      this.lastSamples = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    return this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
  }
  
  public CMSampleBuffer readMergeSample(AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, CMSampleBuffer paramCMSampleBuffer)
  {
    if (paramCMSampleBuffer != null) {}
    try
    {
      if ((paramCMSampleBuffer.getSampleByteBuffer() == null) || (paramAudioDecoderTrack == null)) {
        break label705;
      }
      m = paramCMSampleBuffer.getSampleByteBuffer().asShortBuffer().limit();
      if ((this.currentSamples != null) && (this.currentSamples.capacity() >= m))
      {
        this.currentSamples.clear();
      }
      else
      {
        localObject1 = ByteBuffer.allocate(m * 2);
        ((ByteBuffer)localObject1).order(paramCMSampleBuffer.getSampleByteBuffer().order());
        this.currentSamples = ((ByteBuffer)localObject1).asShortBuffer();
      }
      if ((this.lastSamples != null) && (this.lastSamples.remaining() > 0)) {
        if (m < this.lastSamples.remaining())
        {
          j = this.lastSamples.position();
          i = this.lastSamples.limit();
          localObject1 = this.lastSamples;
          j += m;
          ((ShortBuffer)localObject1).limit(j);
          this.currentSamples.put(this.lastSamples);
          this.lastSamples.limit(i);
          this.lastSamples.position(j);
        }
        else
        {
          this.currentSamples.put(this.lastSamples);
          this.lastSamples.position(this.lastSamples.limit());
        }
      }
      j = this.currentSamples.position();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int m;
        Object localObject1;
        int i;
        int k;
        for (;;)
        {
          throw paramAudioDecoderTrack;
        }
        float f = 1.0F;
        continue;
        i += 1;
        int j = k;
      }
    }
    if (j < m) {}
    try
    {
      localObject1 = paramAudioDecoderTrack.readSample(paramCMSampleBuffer.getTime());
      Object localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readMergeSample: loopCount = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", audioBuffer = ");
      localStringBuilder.append(localObject1);
      Logger.v((String)localObject2, localStringBuilder.toString());
      long l = ((CMSampleBuffer)localObject1).getState().getStateCode();
      if (l <= -1L) {
        return paramCMSampleBuffer;
      }
      paramAudioDecoderTrack.asyncReadNextSample(((CMSampleBuffer)localObject1).getTime());
      if (paramAudioMixInputParameters == null) {
        break label730;
      }
      f = paramAudioMixInputParameters.getVolumeAtTime(((CMSampleBuffer)localObject1).getTime());
      k = j;
      if (((CMSampleBuffer)localObject1).getSampleByteBuffer() == null) {
        break label736;
      }
      if (((CMSampleBuffer)localObject1).getSampleByteBuffer().limit() <= 0)
      {
        k = j;
        break label736;
      }
      localObject2 = resample((CMSampleBuffer)localObject1, paramAudioDecoderTrack.getAudioInfo());
      if ((paramAudioMixInputParameters != null) && (paramAudioMixInputParameters.getAudioTapProcessor() != null)) {
        ((CMSampleBuffer)localObject1).setSampleByteBuffer(paramAudioMixInputParameters.getAudioTapProcessor().processAudioPCM(((CMSampleBuffer)localObject1).getTime(), ((CMSampleBuffer)localObject1).getSampleByteBuffer(), (AudioInfo)localObject2));
      }
      localObject1 = processFrame(((CMSampleBuffer)localObject1).getSampleByteBuffer(), f, 1.0F, (AudioInfo)localObject2).asShortBuffer();
      int n = ((ShortBuffer)localObject1).limit();
      k = m - j;
      if (n > k)
      {
        i = ((ShortBuffer)localObject1).limit() - k;
        if ((this.lastSamples != null) && (this.lastSamples.capacity() >= i))
        {
          this.lastSamples.clear();
        }
        else
        {
          paramAudioDecoderTrack = ByteBuffer.allocate(i * 2);
          paramAudioDecoderTrack.order(paramCMSampleBuffer.getSampleByteBuffer().order());
          this.lastSamples = paramAudioDecoderTrack.asShortBuffer();
        }
        ((ShortBuffer)localObject1).position(k);
        this.lastSamples.put((ShortBuffer)localObject1);
        this.lastSamples.flip();
        ((ShortBuffer)localObject1).position(0);
        ((ShortBuffer)localObject1).limit(k);
        this.currentSamples.put((ShortBuffer)localObject1);
      }
      else
      {
        this.currentSamples.put((ShortBuffer)localObject1);
        k = j + ((ShortBuffer)localObject1).limit();
        break label736;
      }
      this.currentSamples.flip();
      paramAudioDecoderTrack = this.audioMixer.mergeSamples(paramCMSampleBuffer.getSampleByteBuffer().asShortBuffer(), this.currentSamples);
      paramAudioDecoderTrack = new CMSampleBuffer(paramCMSampleBuffer.getTime(), paramAudioDecoderTrack);
      return paramAudioDecoderTrack;
    }
    catch (Throwable paramAudioDecoderTrack)
    {
      Logger.e(this.TAG, "readMergeSample: ", paramAudioDecoderTrack);
      paramAudioDecoderTrack = new CMSampleBuffer(CMSampleState.fromError(-1L, "catch error", paramAudioDecoderTrack));
      return paramAudioDecoderTrack;
    }
    label705:
    this.currentSamples = null;
    this.lastSamples = null;
    return paramCMSampleBuffer;
  }
  
  public void release()
  {
    this.audioResample.release();
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */