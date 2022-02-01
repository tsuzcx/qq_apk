package com.tencent.mobileqq.msgbackup.fragment;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgBackupDateFragment$4
  implements RadioGroup.OnCheckedChangeListener
{
  MsgBackupDateFragment$4(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "checkedId = " + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      MsgBackupDateFragment.a(this.a, 1);
      continue;
      MsgBackupDateFragment.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.4
 * JD-Core Version:    0.7.0.1
 */