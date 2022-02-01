package com.tencent.mobileqq.msgbackup.fragment;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.msgbackup.controller.IMsgBackupQueryCallback;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import java.util.List;
import mqq.os.MqqHandler;

class MsgBackupSelectionFragment$1
  implements IMsgBackupQueryCallback
{
  MsgBackupSelectionFragment$1(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(List<RecentBaseData> paramList)
  {
    MsgBackupSelectionFragment.a(this.a, true);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.a.clear();
      this.a.a.addAll(paramList);
    }
    else if (MsgBackupSelectionFragment.a(this.a) == 0)
    {
      MsgBackupReporter.a("0X800A232");
    }
    else if (MsgBackupManager.c)
    {
      MsgBackupReporter.a("0X800A257");
    }
    paramList = MsgBackupSelectionFragment.a(this.a).obtainMessage(10000);
    MsgBackupSelectionFragment.a(this.a).sendMessage(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment.1
 * JD-Core Version:    0.7.0.1
 */