package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExpandProfileEditFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean b;
  private int c;
  private final Rect d = new Rect();
  
  ExpandProfileEditFragment$3(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void onGlobalLayout()
  {
    ExpandProfileEditFragment.d(this.a).getWindowVisibleDisplayFrame(this.d);
    int i = this.d.bottom - this.d.top;
    if (i != this.c)
    {
      int j = ExpandProfileEditFragment.d(this.a).getRootView().getHeight();
      int k = j - i;
      if (k > j / 4)
      {
        ExpandProfileEditFragment.b(this.a, k);
        this.b = true;
        ExpandProfileEditFragment.e(this.a);
      }
      else if (this.b)
      {
        ExpandProfileEditFragment.f(this.a);
      }
      this.c = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.3
 * JD-Core Version:    0.7.0.1
 */