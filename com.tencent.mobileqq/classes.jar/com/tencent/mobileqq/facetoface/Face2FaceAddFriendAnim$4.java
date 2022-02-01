package com.tencent.mobileqq.facetoface;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceAddFriendAnim$4
  implements Animation.AnimationListener
{
  Face2FaceAddFriendAnim$4(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.a.C).j();
    this.a.y = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.4
 * JD-Core Version:    0.7.0.1
 */