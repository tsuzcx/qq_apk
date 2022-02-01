package com.tencent.mobileqq.extendfriend.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExtendFriendProfileEditFragment$3
  implements View.OnTouchListener
{
  ExtendFriendProfileEditFragment$3(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      ExtendFriendProfileEditFragment.a(this.a).setVisibility(0);
    }
    while ((i != 1) && (i != 3)) {
      return false;
    }
    ExtendFriendProfileEditFragment.a(this.a).setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.3
 * JD-Core Version:    0.7.0.1
 */