package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceAddFriendActivity$5
  implements Animation.AnimationListener
{
  Face2FaceAddFriendActivity$5(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AlphaAnimation(0.2F, 0.0F);
    paramAnimation.setDuration(500L);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */