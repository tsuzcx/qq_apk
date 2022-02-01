package com.tencent.mobileqq.fragment;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NowLiveFragment$NowLiveWebView$NowLiveTouchWebView
  extends TouchWebView
{
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
    int j = paramMotionEvent.getAction();
    float f = paramMotionEvent.getY();
    f = this.a.jdField_a_of_type_Int + f;
    paramMotionEvent = this.a.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.a.iterator();
    while (paramMotionEvent.hasNext())
    {
      paramView = (Rect)paramMotionEvent.next();
      if ((f > paramView.top) && (f < paramView.bottom))
      {
        i = 1;
        break label92;
      }
    }
    int i = 0;
    label92:
    if (i != 0) {
      if (j == 0)
      {
        paramMotionEvent = (ViewGroup)getParent();
        if (paramMotionEvent != null)
        {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          if (QLog.isDevelopLevel())
          {
            QLog.e("CustomWebView", 4, "NowLiveFrgmentWebView onTouchEvent action down requestDisallowInterceptTouchEvent true");
            return bool;
          }
        }
      }
      else if ((j == 3) || (j == 1))
      {
        paramMotionEvent = (ViewGroup)getParent();
        if (paramMotionEvent != null)
        {
          paramMotionEvent.requestDisallowInterceptTouchEvent(false);
          if (QLog.isDevelopLevel()) {
            QLog.e("CustomWebView", 4, "NowLiveFrgmentWebView onTouchEvent action cancel or up requestDisallowInterceptTouchEvent false");
          }
        }
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.NowLiveWebView.NowLiveTouchWebView
 * JD-Core Version:    0.7.0.1
 */