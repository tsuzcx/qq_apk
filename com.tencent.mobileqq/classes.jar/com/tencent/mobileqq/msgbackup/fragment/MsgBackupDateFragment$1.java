package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgBackupDateFragment$1
  implements View.OnClickListener
{
  MsgBackupDateFragment$1(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      MsgBackupReporter.a("0X800A237");
    }
    for (;;)
    {
      this.a.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (MsgBackupManager.c) {
        MsgBackupReporter.a("0X800A25C");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.1
 * JD-Core Version:    0.7.0.1
 */