package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceAddFriendActivity$3
  implements Animation.AnimationListener
{
  Face2FaceAddFriendActivity$3(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.l = false;
    paramAnimation.a.setVisibility(8);
    this.a.e();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.3
 * JD-Core Version:    0.7.0.1
 */