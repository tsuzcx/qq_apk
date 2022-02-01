package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class PagingScrollHelper$MyOnTouchListener
  implements View.OnTouchListener
{
  public PagingScrollHelper$MyOnTouchListener(PagingScrollHelper paramPagingScrollHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PagingScrollHelper.k(this.a))
    {
      PagingScrollHelper.a(this.a, false);
      paramView = this.a;
      PagingScrollHelper.a(paramView, PagingScrollHelper.c(paramView));
      paramView = this.a;
      PagingScrollHelper.b(paramView, PagingScrollHelper.e(paramView));
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      PagingScrollHelper.a(this.a, true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.MyOnTouchListener
 * JD-Core Version:    0.7.0.1
 */