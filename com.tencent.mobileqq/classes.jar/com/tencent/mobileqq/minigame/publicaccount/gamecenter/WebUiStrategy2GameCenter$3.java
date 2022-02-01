package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.util.DisplayUtil;

class WebUiStrategy2GameCenter$3
  implements Animation.AnimationListener
{
  WebUiStrategy2GameCenter$3(WebUiStrategy2GameCenter paramWebUiStrategy2GameCenter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)WebUiStrategy2GameCenter.access$300(this.this$0).getLayoutParams();
    paramAnimation.rightMargin = (-DisplayUtil.a(WebUiStrategy2GameCenter.access$300(this.this$0).getContext(), 77.0F));
    WebUiStrategy2GameCenter.access$300(this.this$0).setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.3
 * JD-Core Version:    0.7.0.1
 */