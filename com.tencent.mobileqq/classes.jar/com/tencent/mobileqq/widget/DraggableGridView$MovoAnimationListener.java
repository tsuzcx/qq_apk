package com.tencent.mobileqq.widget;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import com.tencent.widget.ListView;

class DraggableGridView$MovoAnimationListener
  implements Animation.AnimationListener
{
  private Point b;
  private Point c;
  private boolean d;
  private int e = 0;
  
  public DraggableGridView$MovoAnimationListener(DraggableGridView paramDraggableGridView, Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    this.b = new Point(paramPoint1);
    this.c = new Point(paramPoint2);
    this.d = paramBoolean;
    this.e = 0;
    DraggableGridView.b(paramDraggableGridView, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = this.e - 1;
    this.e = i;
    if (i <= 0)
    {
      i = 0;
      while (i < DraggableGridView.m(this.a).getChildCount())
      {
        paramAnimation = DraggableGridView.m(this.a).getChildAt(i);
        if ((paramAnimation instanceof MeasureGridView))
        {
          paramAnimation = (GridView)paramAnimation;
          int j = 0;
          while (j < paramAnimation.getChildCount())
          {
            paramAnimation.getChildAt(j).clearAnimation();
            if ((((Integer)paramAnimation.getTag()).intValue() == DraggableGridView.e(this.a).y) && (j == DraggableGridView.e(this.a).x) && (!this.d)) {
              paramAnimation.getChildAt(j).setVisibility(4);
            } else {
              paramAnimation.getChildAt(j).setVisibility(0);
            }
            j += 1;
          }
        }
        i += 1;
      }
      if (this.d)
      {
        DraggableGridView.a(this.a).b(this.b.y, this.b.x);
        DraggableGridView.e(this.a).set(-1, -1);
      }
      else
      {
        DraggableGridView.a(this.a).a(this.b.y, this.b.x, this.c.y, this.c.x);
      }
      DraggableGridView.b(this.a).notifyDataSetChanged();
      DraggableGridView.b(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.MovoAnimationListener
 * JD-Core Version:    0.7.0.1
 */