package com.tencent.mobileqq.facetoface;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceAddFriendAnim$3
  implements Animation.AnimationListener
{
  Face2FaceAddFriendAnim$3(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim, int paramInt, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.c;
    paramAnimation.c = paramAnimation.d;
    ((Face2FaceAddFriendActivity)this.c.C).a(this.a, this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.3
 * JD-Core Version:    0.7.0.1
 */