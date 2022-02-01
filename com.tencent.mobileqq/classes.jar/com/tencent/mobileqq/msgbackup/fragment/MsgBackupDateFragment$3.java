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
    switch (paramInt)
    {
    default: 
      if (MsgBackupDateFragment.a(this.a)) {
        if ((MsgBackupDateFragment.b(this.a)) && (MsgBackupDateFragment.c(this.a))) {
          this.a.setRightButtonEnable(true);
        }
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      MsgBackupDateFragment.a(this.a, false);
      MsgBackupDateFragment.a(this.a, 0L);
      MsgBackupDateFragment.b(this.a, 0L);
      MsgBackupDateFragment.a(this.a).setVisibility(8);
      break;
      MsgBackupDateFragment.a(this.a, true);
      MsgBackupDateFragment.a(this.a).setVisibility(0);
      break;
      if ((!TextUtils.isEmpty(MsgBackupDateFragment.a(this.a))) && (!TextUtils.isEmpty(MsgBackupDateFragment.b(this.a))))
      {
        this.a.setRightButtonEnable(true);
      }
      else
      {
        this.a.setRightButtonEnable(false);
        continue;
        this.a.setRightButtonEnable(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.3
 * JD-Core Version:    0.7.0.1
 */