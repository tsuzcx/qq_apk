package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Face2FaceFriendBubbleView$DetailViewAnimationListener
  implements Animation.AnimationListener
{
  private int b = 0;
  private View c = null;
  
  public Face2FaceFriendBubbleView$DetailViewAnimationListener(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt, View paramView)
  {
    this.b = paramInt;
    this.c = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.c;
    if (paramAnimation == null) {
      return;
    }
    int i = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView.DetailViewAnimationListener
 * JD-Core Version:    0.7.0.1
 */