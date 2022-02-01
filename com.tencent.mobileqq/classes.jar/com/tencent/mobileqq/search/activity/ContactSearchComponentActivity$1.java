package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ContactSearchComponentActivity$1
  implements View.OnTouchListener
{
  ContactSearchComponentActivity$1(ContactSearchComponentActivity paramContactSearchComponentActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (TextUtils.isEmpty(ContactSearchComponentActivity.a(this.a))))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchComponentActivity.1
 * JD-Core Version:    0.7.0.1
 */