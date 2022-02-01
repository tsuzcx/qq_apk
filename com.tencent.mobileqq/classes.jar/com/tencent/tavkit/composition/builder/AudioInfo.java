package com.tencent.tavkit.composition.builder;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import java.util.List;

class AudioInfo
{
  TAVTransitionableAudio audio;
  CompositionTrack compositionTrack;
  
  AudioInfo(CompositionTrack paramCompositionTrack, TAVTransitionableAudio paramTAVTransitionableAudio)
  {
    this.compositionTrack = paramCompositionTrack;
    this.audio = paramTAVTransitionableAudio;
  }
  
  @Nullable
  CompositionTrackSegment getCurrentSegmentBy()
  {
    int i = 0;
    while (i < this.compositionTrack.getSegments().size())
    {
      CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)this.compositionTrack.getSegments().get(i);
      if (localCompositionTrackSegment.getTimeMapping().getTarget().equals(this.audio.getTimeRange())) {
        return localCompositionTrackSegment;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioInfo
 * JD-Core Version:    0.7.0.1
 */