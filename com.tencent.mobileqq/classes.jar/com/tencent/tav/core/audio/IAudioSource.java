package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;

public abstract interface IAudioSource<T extends IDecoderTrack>
{
  public abstract CMTime getDuration();
  
  public abstract T getSourceAudioDecoder(CMTimeRange paramCMTimeRange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.audio.IAudioSource
 * JD-Core Version:    0.7.0.1
 */