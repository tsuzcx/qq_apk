package com.tencent.mobileqq.msgbackup.fragment;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgBackupDateFragment$3
  implements RadioGroup.OnCheckedChangeListener
{
  MsgBackupDateFragment$3(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131431606)
    {
      MsgBackupDateFragment.a(this.a, false);
      MsgBackupDateFragment.a(this.a, 0L);
      MsgBackupDateFragment.b(this.a, 0L);
      MsgBackupDateFragment.b(this.a).setVisibility(8);
    }
    else if (paramInt == 2131431607)
    {
      MsgBackupDateFragment.a(this.a, true);
      MsgBackupDateFragment.b(this.a).setVisibility(0);
    }
    if (MsgBackupDateFragment.c(this.a))
    {
      if ((MsgBackupDateFragment.d(this.a)) && (MsgBackupDateFragment.e(this.a))) {
        this.a.n_(true);
      } else if ((!TextUtils.isEmpty(MsgBackupDateFragment.f(this.a))) && (!TextUtils.isEmpty(MsgBackupDateFragment.g(this.a)))) {
        this.a.n_(true);
      } else {
        this.a.n_(false);
      }
    }
    else {
      this.a.n_(true);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.3
 * JD-Core Version:    0.7.0.1
 */