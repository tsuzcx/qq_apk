package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public class PagingScrollHelper$MyOnScrollListener
  extends RecyclerView.OnScrollListener
{
  public PagingScrollHelper$MyOnScrollListener(PagingScrollHelper paramPagingScrollHelper) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (PagingScrollHelper.a(this.a) != PagingScrollHelper.ORIENTATION.NULL))
    {
      PagingScrollHelper.ORIENTATION localORIENTATION1 = PagingScrollHelper.a(this.a);
      PagingScrollHelper.ORIENTATION localORIENTATION2 = PagingScrollHelper.ORIENTATION.VERTICAL;
      int i = -1000;
      int m = 1;
      int j = 1;
      int k = 0;
      paramInt = 0;
      if (localORIENTATION1 == localORIENTATION2)
      {
        if (Math.abs(PagingScrollHelper.c(this.a) - PagingScrollHelper.h(this.a)) <= paramRecyclerView.getHeight() / 2) {
          j = 0;
        }
        if (j != 0)
        {
          if (PagingScrollHelper.c(this.a) - PagingScrollHelper.h(this.a) < 0)
          {
            paramInt = i;
            i = k;
            break label204;
          }
          paramInt = 1000;
          i = k;
          break label204;
        }
      }
      else
      {
        if (Math.abs(PagingScrollHelper.e(this.a) - PagingScrollHelper.i(this.a)) > paramRecyclerView.getWidth() / 2) {
          j = m;
        } else {
          j = 0;
        }
        if (j != 0) {
          if (PagingScrollHelper.e(this.a) - PagingScrollHelper.i(this.a) < 0) {
            paramInt = i;
          } else {
            paramInt = 1000;
          }
        }
      }
      j = 0;
      i = paramInt;
      paramInt = j;
      label204:
      PagingScrollHelper.j(this.a).onFling(i, paramInt);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = this.a;
    PagingScrollHelper.c(paramRecyclerView, PagingScrollHelper.c(paramRecyclerView) + paramInt2);
    paramRecyclerView = this.a;
    PagingScrollHelper.d(paramRecyclerView, PagingScrollHelper.e(paramRecyclerView) + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.MyOnScrollListener
 * JD-Core Version:    0.7.0.1
 */