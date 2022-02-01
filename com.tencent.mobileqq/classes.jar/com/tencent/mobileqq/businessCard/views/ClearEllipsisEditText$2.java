package com.tencent.mobileqq.businessCard.views;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ClearEllipsisEditText$2
  implements View.OnTouchListener
{
  ClearEllipsisEditText$2(ClearEllipsisEditText paramClearEllipsisEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.getCompoundDrawables()[2] == null) {
      return false;
    }
    int i;
    if (paramMotionEvent.getX() > this.a.getWidth() - this.a.getPaddingRight() - ClearEllipsisEditText.a(this.a).getIntrinsicWidth()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramMotionEvent.getAction() == 0) && (i != 0))
    {
      this.a.setText("");
      this.a.setClearButtonVisible(false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText.2
 * JD-Core Version:    0.7.0.1
 */