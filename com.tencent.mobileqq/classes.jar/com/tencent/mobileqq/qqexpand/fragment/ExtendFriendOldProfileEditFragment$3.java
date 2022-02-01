package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExtendFriendOldProfileEditFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean b;
  private int c;
  private final Rect d = new Rect();
  
  ExtendFriendOldProfileEditFragment$3(ExtendFriendOldProfileEditFragment paramExtendFriendOldProfileEditFragment) {}
  
  public void onGlobalLayout()
  {
    ExtendFriendOldProfileEditFragment.g(this.a).getWindowVisibleDisplayFrame(this.d);
    int i = this.d.bottom - this.d.top;
    if (i != this.c)
    {
      int j = ExtendFriendOldProfileEditFragment.g(this.a).getRootView().getHeight();
      int k = j - i;
      if (k > j / 4)
      {
        ExtendFriendOldProfileEditFragment.b(this.a, k);
        this.b = true;
        ExtendFriendOldProfileEditFragment.h(this.a);
      }
      else if (this.b)
      {
        ExtendFriendOldProfileEditFragment.i(this.a);
      }
      this.c = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.3
 * JD-Core Version:    0.7.0.1
 */