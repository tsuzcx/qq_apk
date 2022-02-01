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
  public final String TAG = "AudioResample@" + Integer.toHexString(hashCode());
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
    this.destAudioInfo = paramAudioInfo;
    Logger.i(this.TAG, "AudioResample() called with: destAudioInfo = [" + paramAudioInfo + "], thread = " + Thread.currentThread().getName());
  }
  
  private void checkReleaseResample()
  {
    if (this.avResample != null)
    {
      this.avResample.release();
      this.avResample = null;
    }
  }
  
  private boolean compareAudioInfo(@NonNull AudioInfo paramAudioInfo)
  {
    if (this.srcAudioInfo == null) {}
    while ((this.srcAudioInfo.pcmEncoding != paramAudioInfo.pcmEncoding) || (this.srcAudioInfo.channelCount != paramAudioInfo.channelCount) || (this.srcAudioInfo.sampleRate != paramAudioInfo.sampleRate)) {
      return false;
    }
    return true;
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
    Logger.v(this.TAG, "resample() called with: srcBuffer = [" + paramByteBuffer + "], srcAudioInfo = [" + paramAudioInfo + "]， thread = " + Thread.currentThread().getName());
    if (!compareAudioInfo(paramAudioInfo))
    {
      checkReleaseResample();
      this.avResample = AVResampleFactory.getInstance().newAVResample(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, this.destAudioInfo.sampleRate, this.destAudioInfo.channelCount);
      this.srcAudioInfo = paramAudioInfo;
      if (this.avResample == null) {
        break label183;
      }
    }
    label183:
    for (String str = this.avResample.getClass().getName();; str = "null")
    {
      Logger.i(this.TAG, "resample: 创建重采样库，class = " + str + ", srcAudioInfo = " + paramAudioInfo + ", thread = " + Thread.currentThread().getName());
      if (this.avResample != null) {
        break;
      }
      Logger.w(this.TAG, "resample: avResample 创建失败！");
      return null;
    }
    paramAudioInfo = this.avResample.resample(paramByteBuffer, paramByteBuffer.limit());
    if (paramAudioInfo == null)
    {
      Logger.w(this.TAG, "outBytes == null，srcBuffer = " + paramByteBuffer);
      return null;
    }
    if ((this.destBuffer == null) || (paramAudioInfo.length > this.destBuffer.limit()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AudioResample
 * JD-Core Version:    0.7.0.1
 */