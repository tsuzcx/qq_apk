package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView.OnFlingListener;

class BirthdayHbRecyclerView$MyOnFlingListener
  extends RecyclerView.OnFlingListener
{
  BirthdayHbRecyclerView$MyOnFlingListener(BirthdayHbRecyclerView paramBirthdayHbRecyclerView) {}
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      paramInt1 = 0 - BirthdayHbRecyclerView.a(this.a);
    } else {
      paramInt1 = this.a.getHeight() - BirthdayHbRecyclerView.a(this.a);
    }
    BirthdayHbRecyclerView.b(this.a).startScroll(0, BirthdayHbRecyclerView.a(this.a), 0, paramInt1, 500);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbRecyclerView.MyOnFlingListener
 * JD-Core Version:    0.7.0.1
 */