package com.tencent.mobileqq.mini.widget.media.danmu;

import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;

class BarrageView$1
  extends BarrageView.RemoveViewOnEndAnimListenerAdapter
{
  BarrageView$1(BarrageView paramBarrageView, View paramView, int paramInt)
  {
    super(paramBarrageView, paramView, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    BarrageView.access$100(this.this$0).remove(this.val$bid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.BarrageView.1
 * JD-Core Version:    0.7.0.1
 */