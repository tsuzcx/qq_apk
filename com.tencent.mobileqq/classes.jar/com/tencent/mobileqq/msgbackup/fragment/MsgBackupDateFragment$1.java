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
    } else if (MsgBackupManager.s) {
      MsgBackupReporter.a("0X800A25C");
    }
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.1
 * JD-Core Version:    0.7.0.1
 */