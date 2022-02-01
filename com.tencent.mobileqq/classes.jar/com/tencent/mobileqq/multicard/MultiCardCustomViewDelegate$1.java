package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class MultiCardCustomViewDelegate$1
  implements View.OnLongClickListener
{
  MultiCardCustomViewDelegate$1(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.i != null)
    {
      paramView = (MultiCardItemFragment)this.a.i.get();
      if (paramView != null) {
        paramView.a(this.a);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate.1
 * JD-Core Version:    0.7.0.1
 */