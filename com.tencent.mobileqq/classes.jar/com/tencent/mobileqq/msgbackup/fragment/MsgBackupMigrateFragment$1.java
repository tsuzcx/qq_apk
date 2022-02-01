package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class MsgBackupMigrateFragment$1
  implements OnItemSelectListener
{
  MsgBackupMigrateFragment$1(MsgBackupMigrateFragment paramMsgBackupMigrateFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    MsgBackupReporter.a("0X800A242", 1);
    this.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment.1
 * JD-Core Version:    0.7.0.1
 */