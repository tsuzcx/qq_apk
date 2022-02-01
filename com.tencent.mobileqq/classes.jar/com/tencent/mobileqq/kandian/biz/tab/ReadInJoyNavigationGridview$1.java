package com.tencent.mobileqq.kandian.biz.tab;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ReadInJoyNavigationGridview$1
  implements View.OnTouchListener
{
  ReadInJoyNavigationGridview$1(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((MotionEventCompat.getActionMasked(paramMotionEvent) == 0) && (ReadInJoyNavigationGridview.a(this.a) != null)) {
      ReadInJoyNavigationGridview.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview.1
 * JD-Core Version:    0.7.0.1
 */