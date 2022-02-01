package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class MsgBackupSelectionFragment$2
  implements OnItemSelectListener
{
  MsgBackupSelectionFragment$2(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = 2;
      MsgBackupUtil.a("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(MsgBackupManager.s) });
      if (MsgBackupSelectionFragment.a(this.a) == 0)
      {
        if (MsgBackupSelectionFragment.c(this.a)) {
          paramInt = 3;
        }
        MsgBackupReporter.a("0X800A242", paramInt);
      }
      else if ((MsgBackupManager.s) && (MsgBackupAuthProcessor.a().c() == 1))
      {
        MsgBackupReporter.a("0X800A266", 5);
      }
      this.a.onBackEvent();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment.2
 * JD-Core Version:    0.7.0.1
 */