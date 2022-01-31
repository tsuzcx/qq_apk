package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import java.util.List;

final class CompositionUtils$1
  implements CompositionUtils.TransitionTimeCalculator
{
  CompositionUtils$1(List paramList) {}
  
  public CMTime transition(int paramInt)
  {
    TAVVideoTransition localTAVVideoTransition = ((TAVTransitionableVideo)this.val$transitionableVideos.get(paramInt)).getVideoTransition();
    if (localTAVVideoTransition != null) {
      return localTAVVideoTransition.getDuration();
    }
    return CMTime.CMTimeZero;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.utils.CompositionUtils.1
 * JD-Core Version:    0.7.0.1
 */