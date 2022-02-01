package com.tencent.mobileqq.search.base.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import mqq.app.MobileQQ;

class BaseSearchFragment$1
  implements View.OnTouchListener
{
  BaseSearchFragment$1(BaseSearchFragment paramBaseSearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)MobileQQ.sMobileQQ.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.fragment.BaseSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */