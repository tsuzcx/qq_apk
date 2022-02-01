package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.NotNull;

public class AudioResample
{
  public final String TAG;
  @Nullable
  private IAVResample avResample;
  private final AudioInfo destAudioInfo;
  private ByteBuffer destBuffer;
  private AudioInfo srcAudioInfo;
  
  public AudioResample()
  {
    this(newDefaultDestAudioInfo());
  }
  
  public AudioResample(AudioInfo paramAudioInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioResample@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.destAudioInfo = paramAudioInfo;
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioResample() called with: destAudioInfo = [");
    localStringBuilder.append(paramAudioInfo);
    localStringBuilder.append("], thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.i((String)localObject, localStringBuilder.toString());
  }
  
  private void checkReleaseResample()
  {
    IAVResample localIAVResample = this.avResample;
    if (localIAVResample != null)
    {
      localIAVResample.release();
      this.avResample = null;
    }
  }
  
  private boolean compareAudioInfo(@NonNull AudioInfo paramAudioInfo)
  {
    AudioInfo localAudioInfo = this.srcAudioInfo;
    boolean bool2 = false;
    if (localAudioInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localAudioInfo.pcmEncoding == paramAudioInfo.pcmEncoding)
    {
      bool1 = bool2;
      if (this.srcAudioInfo.channelCount == paramAudioInfo.channelCount)
      {
        bool1 = bool2;
        if (this.srcAudioInfo.sampleRate == paramAudioInfo.sampleRate) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @NotNull
  private static AudioInfo newDefaultDestAudioInfo()
  {
    AudioInfo localAudioInfo = new AudioInfo();
    localAudioInfo.channelCount = 1;
    localAudioInfo.sampleRate = 44100;
    localAudioInfo.pcmEncoding = 2;
    return localAudioInfo;
  }
  
  public AudioInfo getDestAudioInfo()
  {
    return this.destAudioInfo;
  }
  
  public void release()
  {
    Logger.d(this.TAG, "release() called");
    checkReleaseResample();
  }
  
  @Nullable
  public ByteBuffer resample(ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resample() called with: srcBuffer = [");
    ((StringBuilder)localObject2).append(paramByteBuffer);
    ((StringBuilder)localObject2).append("], srcAudioInfo = [");
    ((StringBuilder)localObject2).append(paramAudioInfo);
    ((StringBuilder)localObject2).append("]， thread = ");
    ((StringBuilder)localObject2).append(Thread.currentThread().getName());
    Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!compareAudioInfo(paramAudioInfo))
    {
      checkReleaseResample();
      this.avResample = AVResampleFactory.getInstance().newAVResample(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, this.destAudioInfo.sampleRate, this.destAudioInfo.channelCount);
      this.srcAudioInfo = paramAudioInfo;
      localObject1 = this.avResample;
      if (localObject1 != null) {
        localObject1 = localObject1.getClass().getName();
      } else {
        localObject1 = "null";
      }
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resample: 创建重采样库，class = ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", srcAudioInfo = ");
      localStringBuilder.append(paramAudioInfo);
      localStringBuilder.append(", thread = ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.i((String)localObject2, localStringBuilder.toString());
    }
    paramAudioInfo = this.avResample;
    if (paramAudioInfo == null) {
      return null;
    }
    paramAudioInfo = paramAudioInfo.resample(paramByteBuffer, paramByteBuffer.limit());
    if (paramAudioInfo == null)
    {
      paramAudioInfo = this.TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("outBytes == null，srcBuffer = ");
      ((StringBuilder)localObject1).append(paramByteBuffer);
      Logger.w(paramAudioInfo, ((StringBuilder)localObject1).toString());
      return null;
    }
    paramByteBuffer = this.destBuffer;
    if ((paramByteBuffer == null) || (paramAudioInfo.length > paramByteBuffer.limit()))
    {
      this.destBuffer = ByteBuffer.allocateDirect(paramAudioInfo.length);
      this.destBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
    this.destBuffer.clear();
    this.destBuffer.put(paramAudioInfo);
    this.destBuffer.position(0);
    this.destBuffer.limit(paramAudioInfo.length);
    return this.destBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AudioResample
 * JD-Core Version:    0.7.0.1
 */