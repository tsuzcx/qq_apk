package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class BirthdayHbAdapter$1
  implements View.OnClickListener
{
  BirthdayHbAdapter$1(BirthdayHbAdapter paramBirthdayHbAdapter, BirthdayHbAdapter.DataInfo paramDataInfo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < BirthdayHbAdapter.a().size())
    {
      ((BirthdayHbAdapter.DataInfo)BirthdayHbAdapter.a().get(i)).a(false);
      i += 1;
    }
    this.a.a(true);
    BirthdayHbAdapter.a(this.b).a(this.a);
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter.1
 * JD-Core Version:    0.7.0.1
 */