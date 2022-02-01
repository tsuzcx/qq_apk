package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnFlingListener;

public class PagingScrollHelper$MyOnFlingListener
  extends RecyclerView.OnFlingListener
{
  public PagingScrollHelper$MyOnFlingListener(PagingScrollHelper paramPagingScrollHelper) {}
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    if (PagingScrollHelper.a(this.a) == PagingScrollHelper.ORIENTATION.NULL) {
      return false;
    }
    int i = PagingScrollHelper.b(this.a);
    int j;
    if (PagingScrollHelper.a(this.a) == PagingScrollHelper.ORIENTATION.VERTICAL)
    {
      j = PagingScrollHelper.c(this.a);
      if (paramInt2 < 0)
      {
        paramInt1 = i - 1;
      }
      else
      {
        paramInt1 = i;
        if (paramInt2 > 0) {
          paramInt1 = i + 1;
        }
      }
      paramInt1 *= PagingScrollHelper.d(this.a).getHeight();
      paramInt2 = j;
    }
    else
    {
      j = PagingScrollHelper.e(this.a);
      if (paramInt1 < 0)
      {
        paramInt2 = i - 1;
      }
      else
      {
        paramInt2 = i;
        if (paramInt1 > 0) {
          paramInt2 = i + 1;
        }
      }
      paramInt1 = paramInt2 * PagingScrollHelper.d(this.a).getWidth();
      paramInt2 = j;
    }
    i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (PagingScrollHelper.f(this.a) == null)
    {
      PagingScrollHelper localPagingScrollHelper = this.a;
      new ValueAnimator();
      PagingScrollHelper.a(localPagingScrollHelper, ValueAnimator.ofInt(new int[] { paramInt2, i }));
      PagingScrollHelper.f(this.a).setDuration(300L);
      PagingScrollHelper.f(this.a).addUpdateListener(new PagingScrollHelper.MyOnFlingListener.1(this));
      PagingScrollHelper.f(this.a).addListener(new PagingScrollHelper.MyOnFlingListener.2(this));
    }
    else
    {
      PagingScrollHelper.f(this.a).cancel();
      PagingScrollHelper.f(this.a).setIntValues(new int[] { paramInt2, i });
    }
    PagingScrollHelper.f(this.a).start();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.MyOnFlingListener
 * JD-Core Version:    0.7.0.1
 */