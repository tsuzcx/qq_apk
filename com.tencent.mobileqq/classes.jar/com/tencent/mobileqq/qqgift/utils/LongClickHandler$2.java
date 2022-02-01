package com.tencent.mobileqq.qqgift.utils;

import android.view.View;
import android.view.View.OnLongClickListener;

class LongClickHandler$2
  implements View.OnLongClickListener
{
  LongClickHandler$2(LongClickHandler paramLongClickHandler, LongClickHandler.OnLongClickListener paramOnLongClickListener, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    LongClickHandler.a(this.c, true);
    this.a.a(LongClickHandler.a(this.c));
    ThreadManager.a(LongClickHandler.e(this.c), this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.LongClickHandler.2
 * JD-Core Version:    0.7.0.1
 */