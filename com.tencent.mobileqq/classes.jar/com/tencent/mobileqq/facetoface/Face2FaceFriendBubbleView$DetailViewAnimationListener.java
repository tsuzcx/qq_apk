package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceFriendBubbleView$DetailViewAnimationListener
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView = null;
  
  public Face2FaceFriendBubbleView$DetailViewAnimationListener(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt, View paramView)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    if (paramAnimation == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      paramAnimation.setVisibility(0);
      return;
    }
    if (i == 1) {
      paramAnimation.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView.DetailViewAnimationListener
 * JD-Core Version:    0.7.0.1
 */