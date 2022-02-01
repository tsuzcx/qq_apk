package com.tencent.mobileqq.facetoface;

import android.view.animation.Interpolator;

class Face2FaceAddFriendAnim$EaseOutQuartInterpolator
  implements Interpolator
{
  Face2FaceAddFriendAnim$EaseOutQuartInterpolator(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * paramFloat * paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.EaseOutQuartInterpolator
 * JD-Core Version:    0.7.0.1
 */