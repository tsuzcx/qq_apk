package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;

class PagingScrollView$1
  implements View.OnTouchListener
{
  PagingScrollView$1(PagingScrollView paramPagingScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.mIsOnSpecialView)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        paramView = this.a;
        paramView.mIsOnSpecialView = false;
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "C.TE ACT_UP or CANCEL");
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PagingScrollView.1
 * JD-Core Version:    0.7.0.1
 */