package com.tencent.mobileqq.msgbackup.fragment;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import java.util.HashSet;

class MsgBackupSelectionFragment$3
  implements MsgBackupListAdapter.OnItemCheckedChangeListener
{
  MsgBackupSelectionFragment$3(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(boolean paramBoolean, RecentBaseData paramRecentBaseData)
  {
    if (paramBoolean) {
      MsgBackupSelectionFragment.d(this.a).h.add(paramRecentBaseData);
    } else {
      MsgBackupSelectionFragment.d(this.a).h.remove(paramRecentBaseData);
    }
    int i = MsgBackupSelectionFragment.d(this.a).h.size();
    MsgBackupSelectionFragment.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment.3
 * JD-Core Version:    0.7.0.1
 */