package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;

class PagingScrollHelper$MyOnFlingListener$2
  extends AnimatorListenerAdapter
{
  PagingScrollHelper$MyOnFlingListener$2(PagingScrollHelper.MyOnFlingListener paramMyOnFlingListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a.a != null) {
      this.a.a.a.a(PagingScrollHelper.g(this.a.a));
    }
    PagingScrollHelper.d(this.a.a).stopScroll();
    PagingScrollHelper.a(this.a.a, PagingScrollHelper.c(this.a.a));
    PagingScrollHelper.b(this.a.a, PagingScrollHelper.e(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.MyOnFlingListener.2
 * JD-Core Version:    0.7.0.1
 */