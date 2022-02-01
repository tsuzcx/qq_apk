package com.tencent.mobileqq.vastrash.uec;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

class UECPageStayViewer$1
  implements View.OnTouchListener
{
  UECPageStayViewer$1(UECPageStayViewer paramUECPageStayViewer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      UECPageStayViewer.a(this.a, (int)paramMotionEvent.getY());
      return false;
    }
    if (i == 2)
    {
      if ((UECPageStayViewer.a(this.a)) || (Math.abs(paramMotionEvent.getY() - UECPageStayViewer.b(this.a)) > DisplayUtil.a(paramView, 10.0F)))
      {
        UECPageStayViewer.a(this.a, true);
        paramMotionEvent = (WindowManager.LayoutParams)this.a.getLayoutParams();
        paramMotionEvent.y = (j - UECPageStayViewer.b(this.a) - DisplayUtil.a(paramView, 0.0F));
        i = UECPageStayViewer.c(this.a).getDefaultDisplay().getHeight();
        if (paramMotionEvent.y < 0) {
          paramMotionEvent.y = 0;
        } else if (paramMotionEvent.y > i - this.a.getHeight()) {
          paramMotionEvent.y = (i - this.a.getHeight());
        }
        UECPageStayViewer.c(this.a).updateViewLayout(UECPageStayViewer.d(this.a), paramMotionEvent);
      }
      return true;
    }
    if ((i != 1) && (i == 3)) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer.1
 * JD-Core Version:    0.7.0.1
 */