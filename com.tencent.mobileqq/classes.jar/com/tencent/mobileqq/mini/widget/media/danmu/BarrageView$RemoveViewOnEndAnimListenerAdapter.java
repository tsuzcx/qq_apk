package com.tencent.mobileqq.mini.widget.media.danmu;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class BarrageView$RemoveViewOnEndAnimListenerAdapter
  implements Animation.AnimationListener
{
  private final View view;
  
  private BarrageView$RemoveViewOnEndAnimListenerAdapter(BarrageView paramBarrageView, View paramView)
  {
    this.view = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.removeView(this.view);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.BarrageView.RemoveViewOnEndAnimListenerAdapter
 * JD-Core Version:    0.7.0.1
 */