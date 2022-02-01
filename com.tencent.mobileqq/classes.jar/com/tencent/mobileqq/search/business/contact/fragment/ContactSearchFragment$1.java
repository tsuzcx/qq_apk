package com.tencent.mobileqq.search.business.contact.fragment;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import mqq.app.MobileQQ;

class ContactSearchFragment$1
  implements View.OnTouchListener
{
  ContactSearchFragment$1(ContactSearchFragment paramContactSearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)MobileQQ.sMobileQQ.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */