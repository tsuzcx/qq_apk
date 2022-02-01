package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;

class Face2FaceFriendBubbleView$1
  implements Animation.AnimationListener
{
  Face2FaceFriendBubbleView$1(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (Face2FaceFriendBubbleView.a(this.a) == 1)
    {
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
    }
    else if (Face2FaceFriendBubbleView.a(this.a) == 2)
    {
      Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840098);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
    }
    else if (Face2FaceFriendBubbleView.a(this.a) == 3)
    {
      Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840099);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
    }
    else if (Face2FaceFriendBubbleView.a(this.a) == 4)
    {
      Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840100);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
    }
    Face2FaceFriendBubbleView.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView.1
 * JD-Core Version:    0.7.0.1
 */