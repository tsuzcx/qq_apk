package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVAudio;

class AudioMixInfo
{
  TAVAudio audio;
  CompositionTrack track;
  
  AudioMixInfo(CompositionTrack paramCompositionTrack, TAVAudio paramTAVAudio)
  {
    this.track = paramCompositionTrack;
    this.audio = paramTAVAudio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioMixInfo
 * JD-Core Version:    0.7.0.1
 */