package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;

class PagingScrollHelper$MyOnFlingListener$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PagingScrollHelper$MyOnFlingListener$1(PagingScrollHelper.MyOnFlingListener paramMyOnFlingListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (PagingScrollHelper.a(this.a.a) == PagingScrollHelper.ORIENTATION.VERTICAL)
    {
      j = PagingScrollHelper.c(this.a.a);
      PagingScrollHelper.d(this.a.a).scrollBy(0, i - j);
      return;
    }
    int j = PagingScrollHelper.e(this.a.a);
    PagingScrollHelper.d(this.a.a).scrollBy(i - j, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.MyOnFlingListener.1
 * JD-Core Version:    0.7.0.1
 */