package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExtendFriendSquareFragment$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExtendFriendSquareFragment$5(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.a.getLocationInWindow(arrayOfInt);
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.b.F = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.5
 * JD-Core Version:    0.7.0.1
 */