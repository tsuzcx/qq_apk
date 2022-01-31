package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import java.util.List;

final class CompositionUtils$2
  implements CompositionUtils.TransitionTimeCalculator
{
  CompositionUtils$2(List paramList) {}
  
  public CMTime transition(int paramInt)
  {
    TAVAudioTransition localTAVAudioTransition = ((TAVTransitionableAudio)this.val$transitionableAudios.get(paramInt)).getAudioTransition();
    if (localTAVAudioTransition != null) {
      return localTAVAudioTransition.getDuration();
    }
    return CMTime.CMTimeZero;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.utils.CompositionUtils.2
 * JD-Core Version:    0.7.0.1
 */