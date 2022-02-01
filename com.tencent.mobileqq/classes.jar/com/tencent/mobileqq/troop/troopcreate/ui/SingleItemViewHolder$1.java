package com.tencent.mobileqq.troop.troopcreate.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class SingleItemViewHolder$1
  implements View.OnTouchListener
{
  SingleItemViewHolder$1(SingleItemViewHolder paramSingleItemViewHolder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.a.d.setAlpha(0.15F);
      this.a.h.setAlpha(0.5F);
      this.a.f.setAlpha(0.5F);
    }
    else if ((i == 3) || (i == 1))
    {
      this.a.d.setAlpha(1.0F);
      this.a.h.setAlpha(1.0F);
      this.a.f.setAlpha(1.0F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SingleItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */