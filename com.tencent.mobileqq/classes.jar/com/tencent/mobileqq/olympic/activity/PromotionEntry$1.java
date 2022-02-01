package com.tencent.mobileqq.olympic.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class PromotionEntry$1
  implements View.OnTouchListener
{
  PromotionEntry$1(PromotionEntry paramPromotionEntry) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PromotionEntry.a(this.a) == null) {
      return false;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      PromotionEntry.a(this.a).setAlpha(255);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      PromotionEntry.a(this.a).setAlpha(100);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.1
 * JD-Core Version:    0.7.0.1
 */