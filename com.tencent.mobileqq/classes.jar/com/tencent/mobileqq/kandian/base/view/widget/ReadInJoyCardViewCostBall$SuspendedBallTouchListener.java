package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ReadInJoyCardViewCostBall$SuspendedBallTouchListener
  implements View.OnTouchListener
{
  private int b;
  private int c;
  private float d;
  private float e;
  
  private ReadInJoyCardViewCostBall$SuspendedBallTouchListener(ReadInJoyCardViewCostBall paramReadInJoyCardViewCostBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        ReadInJoyCardViewCostBall.a(this.a).x = (this.b + (int)(this.d - paramMotionEvent.getRawX()));
        ReadInJoyCardViewCostBall.a(this.a).y = (this.c + (int)(paramMotionEvent.getRawY() - this.e));
        ReadInJoyCardViewCostBall.b(this.a).updateViewLayout(paramView, ReadInJoyCardViewCostBall.a(this.a));
      }
    }
    else
    {
      this.b = ReadInJoyCardViewCostBall.a(this.a).x;
      this.c = ReadInJoyCardViewCostBall.a(this.a).y;
      this.d = paramMotionEvent.getRawX();
      this.e = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCardViewCostBall.SuspendedBallTouchListener
 * JD-Core Version:    0.7.0.1
 */