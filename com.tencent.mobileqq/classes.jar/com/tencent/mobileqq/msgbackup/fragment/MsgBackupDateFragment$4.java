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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkedId = ");
      localStringBuilder.append(paramInt);
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, localStringBuilder.toString());
    }
    if (paramInt == 2131431347) {
      MsgBackupDateFragment.a(this.a, 1);
    } else if (paramInt == 2131431348) {
      MsgBackupDateFragment.a(this.a, 2);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.4
 * JD-Core Version:    0.7.0.1
 */