package com.tencent.mobileqq.mini.widget.media.danmu;

import android.view.View;
import android.view.animation.Animation;
import java.util.Set;

class BarrageView$2
  extends BarrageView.RemoveViewOnEndAnimListenerAdapter
{
  BarrageView$2(BarrageView paramBarrageView, View paramView)
  {
    super(paramBarrageView, paramView, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    BarrageView.access$200(this.this$0).remove(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.BarrageView.2
 * JD-Core Version:    0.7.0.1
 */