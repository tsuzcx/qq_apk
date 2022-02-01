package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;

class WebUiStrategy2GameCenter$2
  implements Animation.AnimationListener
{
  WebUiStrategy2GameCenter$2(WebUiStrategy2GameCenter paramWebUiStrategy2GameCenter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)WebUiStrategy2GameCenter.access$300(this.this$0).getLayoutParams();
    paramAnimation.rightMargin = 0;
    WebUiStrategy2GameCenter.access$300(this.this$0).setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.2
 * JD-Core Version:    0.7.0.1
 */