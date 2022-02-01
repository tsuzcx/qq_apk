package com.tencent.mobileqq.vastrash.uec;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class UECPageStayViewer$1
  implements View.OnTouchListener
{
  UECPageStayViewer$1(UECPageStayViewer paramUECPageStayViewer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0) {
      UECPageStayViewer.a(this.a, (int)paramMotionEvent.getY());
    }
    label171:
    do
    {
      return false;
      if (i == 2)
      {
        if ((UECPageStayViewer.a(this.a)) || (Math.abs(paramMotionEvent.getY() - UECPageStayViewer.a(this.a)) > com.tencent.mobileqq.util.DisplayUtil.a(paramView, 10.0F)))
        {
          UECPageStayViewer.a(this.a, true);
          paramMotionEvent = (WindowManager.LayoutParams)this.a.getLayoutParams();
          paramMotionEvent.y = (j - UECPageStayViewer.a(this.a) - com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil.b(paramView, 0.0F));
          i = UECPageStayViewer.a(this.a).getDefaultDisplay().getHeight();
          if (paramMotionEvent.y >= 0) {
            break label171;
          }
          paramMotionEvent.y = 0;
        }
        for (;;)
        {
          UECPageStayViewer.a(this.a).updateViewLayout(UECPageStayViewer.a(this.a), paramMotionEvent);
          return true;
          if (paramMotionEvent.y > i - this.a.getHeight()) {
            paramMotionEvent.y = (i - this.a.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer.1
 * JD-Core Version:    0.7.0.1
 */