package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class MsgBackupDateFragment$6
  implements View.OnClickListener
{
  MsgBackupDateFragment$6(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MsgBackupDateFragment.k(this.a) != null) && (MsgBackupDateFragment.k(this.a).isShowing())) {
      MsgBackupDateFragment.k(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment.6
 * JD-Core Version:    0.7.0.1
 */