package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FSBaseInputPopupWindow$3
  implements Animation.AnimationListener
{
  FSBaseInputPopupWindow$3(FSBaseInputPopupWindow paramFSBaseInputPopupWindow) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */