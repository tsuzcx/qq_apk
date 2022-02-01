package com.tencent.mobileqq.facetoface;

import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class Face2FaceAddFriendActivity$4$1
  implements Animation.AnimationListener
{
  Face2FaceAddFriendActivity$4$1(Face2FaceAddFriendActivity.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.h.removeView(this.a.b);
    this.a.c.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.b(this.a.c);
    this.a.c.au = true;
    if (Face2FaceAddFriendConstants.a >= Face2FaceAddFriendConstants.b)
    {
      this.a.c.a(Face2FaceAddFriendConstants.a, Face2FaceAddFriendConstants.b);
      return;
    }
    this.a.c.a(Face2FaceAddFriendConstants.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.4.1
 * JD-Core Version:    0.7.0.1
 */