package com.tencent.tav.core.audio;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AudioSourceTrack
  implements IAudioSource<AudioDecoderTrack>
{
  public static final String TAG = "AudioCompositionTrackEncoder2";
  private AssetTrack mAssetTrack;
  private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);
  
  public AudioSourceTrack(@NonNull AssetTrack paramAssetTrack)
  {
    this.mAssetTrack = paramAssetTrack;
  }
  
  public CMTime getDuration()
  {
    return this.mAssetTrack.getDuration();
  }
  
  public AudioDecoderTrack getSourceAudioDecoder(CMTimeRange paramCMTimeRange)
  {
    AudioDecoderTrack localAudioDecoderTrack1 = new AudioDecoderTrack();
    if (this.mAssetTrack.getMediaType() == 2)
    {
      AudioDecoderTrack localAudioDecoderTrack2 = new AudioDecoderTrack();
      Object localObject1 = this.mAssetTrack.getSegments();
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject1).next();
        Object localObject2 = DecoderAssetTrack.create(this.mAssetTrack, localAssetTrackSegment);
        CMTimeRange localCMTimeRange = localAssetTrackSegment.getTimeMapping().getSource();
        localObject2 = new DecoderTrackSegment(new CMTimeRange(localCMTimeRange.getStart(), localCMTimeRange.getDuration()), (DecoderAssetTrack)localObject2);
        ((DecoderTrackSegment)localObject2).setScaledDuration(localAssetTrackSegment.getScaleDuration());
        localArrayList.add(localObject2);
      }
      localAudioDecoderTrack2.setTrackID(this.mAssetTrack.getTrackID());
      localAudioDecoderTrack2.setTrackSegments(localArrayList);
      localAudioDecoderTrack2.setFrameRate((int)this.mAssetTrack.getNominalFrameRate());
      localAudioDecoderTrack2.setVolume(this.mAssetTrack.getPreferredVolume());
      localAudioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
      localAudioDecoderTrack2.setAudioInfo(this.mAudioInfo);
      localAudioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(CMTime.CMTimeZero, paramCMTimeRange.getEnd()));
      return localAudioDecoderTrack1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioSourceTrack
 * JD-Core Version:    0.7.0.1
 */