package com.tencent.mobileqq.olympic.activity;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

class ARTipsManager$1
  implements View.OnTouchListener
{
  private float b;
  private float c;
  private long d;
  
  ARTipsManager$1(ARTipsManager paramARTipsManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ARTipsManager.a(this.a) != null)
    {
      paramView = (ARTipsManager.TipsInfo)ARTipsManager.a(this.a).getTag(2131428720);
      ARTipsManager.ViewHolder localViewHolder = (ARTipsManager.ViewHolder)ARTipsManager.a(this.a).getTag();
      if ((paramView != null) && (localViewHolder != null))
      {
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        int i = paramMotionEvent.getAction();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                return true;
              }
              this.b = 0.0F;
              this.c = 0.0F;
              this.d = 0L;
              localViewHolder.a.setPressed(false);
              return true;
            }
            if ((paramView.a == 1) && (paramView.b == 2))
            {
              f2 -= this.b;
              f1 -= this.c;
              if ((float)Math.sqrt(f2 * f2 + f1 * f1) >= ARTipsManager.b(this.a).getScaledTouchSlop())
              {
                localViewHolder.a.setPressed(false);
                return true;
              }
            }
          }
          else
          {
            f2 -= this.b;
            f1 -= this.c;
            f2 = (float)Math.sqrt(f2 * f2 + f1 * f1);
            long l1 = System.currentTimeMillis();
            long l2 = this.d;
            if (f2 < ARTipsManager.b(this.a).getScaledTouchSlop())
            {
              if (paramView.b == 2)
              {
                ARTipsManager.c(this.a).removeMessages(101);
                ARTipsManager.c(this.a).obtainMessage(101).sendToTarget();
                if (paramView.g != null) {
                  paramView.g.a();
                }
              }
            }
            else if ((f2 > ARTipsManager.b(this.a).getScaledTouchSlop()) && (f1 > 50.0F) && ((float)(l1 - l2) < 300.0F) && (paramView.a == 1))
            {
              ARTipsManager.c(this.a).removeMessages(101);
              ARTipsManager.c(this.a).obtainMessage(101).sendToTarget();
            }
            this.b = 0.0F;
            this.c = 0.0F;
            this.d = 0L;
            localViewHolder.a.setPressed(false);
            return true;
          }
        }
        else
        {
          this.b = f2;
          this.c = f1;
          this.d = System.currentTimeMillis();
          if ((paramView.a == 1) && (paramView.b == 2)) {
            localViewHolder.a.setPressed(true);
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.1
 * JD-Core Version:    0.7.0.1
 */