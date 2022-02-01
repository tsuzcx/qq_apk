package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class ReadInJoyVideoSearchTagFragment$6
  implements View.OnTouchListener
{
  ReadInJoyVideoSearchTagFragment$6(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = ReadInJoyVideoSearchTagFragment.b(this.a).getCompoundDrawables()[2];
    if ((paramMotionEvent.getAction() == 0) && (paramView != null))
    {
      float f = ReadInJoyVideoSearchTagFragment.b(this.a).getRight() - paramView.getBounds().width();
      if (paramMotionEvent.getRawX() >= f)
      {
        ReadInJoyVideoSearchTagFragment.c(this.a);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoSearchTagFragment.6
 * JD-Core Version:    0.7.0.1
 */