package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExtendFriendSearchFragment$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExtendFriendSearchFragment$8(ExtendFriendSearchFragment paramExtendFriendSearchFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.a.getLocationInWindow(arrayOfInt);
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ExtendFriendSearchFragment localExtendFriendSearchFragment = this.b;
    localExtendFriendSearchFragment.F = arrayOfInt[1];
    localExtendFriendSearchFragment.F += this.a.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.8
 * JD-Core Version:    0.7.0.1
 */