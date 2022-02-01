package com.tencent.youtu.sdkkitframework.liveness;

import java.util.Comparator;

class ActionLivenessState$BestFrameEyeRating
  implements Comparator<ActionLivenessState.BestFrame>
{
  ActionLivenessState$BestFrameEyeRating(ActionLivenessState paramActionLivenessState) {}
  
  public int compare(ActionLivenessState.BestFrame paramBestFrame1, ActionLivenessState.BestFrame paramBestFrame2)
  {
    float f = paramBestFrame2.eyeScore - paramBestFrame1.eyeScore;
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.BestFrameEyeRating
 * JD-Core Version:    0.7.0.1
 */