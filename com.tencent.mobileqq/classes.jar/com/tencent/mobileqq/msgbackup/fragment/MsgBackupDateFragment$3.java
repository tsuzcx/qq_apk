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
    if (paramInt == 2131365405)
    {
      MsgBackupDateFragment.a(this.a, false);
      MsgBackupDateFragment.a(this.a, 0L);
      MsgBackupDateFragment.b(this.a, 0L);
      MsgBackupDateFragment.a(this.a).setVisibility(8);
    }
    else if (paramInt == 2131365406)
    {
      MsgBackupDateFragment.a(this.a, true);
      MsgBackupDateFragment.a(this.a).setVisibility(0);
    }
    if (MsgBackupDateFragment.a(this.a))
    {
      if ((MsgBackupDateFragment.b(this.a)) && (MsgBackupDateFragment.c(this.a))) {
        this.a.i_(true);
      } else if ((!TextUtils.isEmpty(MsgBackupDateFragment.a(this.a))) && (!TextUtils.isEmpty(MsgBackupDateFragment.b(this.a)))) {
        this.a.i_(true);
      } else {
        this.a.i_(false);
      }
    }
    else {
      this.a.i_(true);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.3
 * JD-Core Version:    0.7.0.1
 */