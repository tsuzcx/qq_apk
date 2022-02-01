package com.tencent.tav.core.audio;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoder.DecodeType;

public class AudioSourceComposition
  implements IAudioSource<AudioCompositionDecoderTrack>
{
  private Asset mAsset;
  private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);
  
  public AudioSourceComposition(@NonNull Asset paramAsset)
  {
    this.mAsset = paramAsset;
  }
  
  public CMTime getDuration()
  {
    return this.mAsset.getDuration();
  }
  
  public AudioCompositionDecoderTrack getSourceAudioDecoder(CMTimeRange paramCMTimeRange)
  {
    paramCMTimeRange = new AudioCompositionDecoderTrack(this.mAsset.getTracks(), -1);
    paramCMTimeRange.setAudioInfo(this.mAudioInfo);
    paramCMTimeRange.setDecodeType(IDecoder.DecodeType.Audio);
    paramCMTimeRange.setFrameRate(44);
    return paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioSourceComposition
 * JD-Core Version:    0.7.0.1
 */