package com.tencent.mobileqq.hotpic;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class HotPicPageView$MyVideoViewHolder$3
  implements Animation.AnimationListener
{
  HotPicPageView$MyVideoViewHolder$3(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.n == 3) {
      this.a.q.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder.3
 * JD-Core Version:    0.7.0.1
 */