package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class DraggableGridView$1
  implements Animation.AnimationListener
{
  DraggableGridView$1(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DraggableGridView.a(this.c).b(this.a, this.b);
    DraggableGridView.b(this.c).notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.1
 * JD-Core Version:    0.7.0.1
 */