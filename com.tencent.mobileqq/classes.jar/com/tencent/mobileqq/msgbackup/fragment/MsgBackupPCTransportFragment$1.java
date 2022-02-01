package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;

class MsgBackupPCTransportFragment$1
  implements OnItemSelectListener
{
  MsgBackupPCTransportFragment$1(MsgBackupPCTransportFragment paramMsgBackupPCTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = MsgBackupAuthProcessor.a().a();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + i + ", pcHandler = " + this.a.e);
      }
      this.a.ay_();
      return;
      MsgBackupManager.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + MsgBackupManager.a + ", curSpeed = " + this.a.a + ", hasFinishedCount = " + this.a.d);
      }
      MsgBackupManager.a().a().a(null);
      MsgBackupManager.a().a(this.a.a, this.a.d, i, this.a.getActivity());
      if (this.a.b != 1) {
        break;
      }
    } while (!this.a.e);
    MsgBackupReporter.a("0X800A260");
    return;
    MsgBackupReporter.a("0X800A284");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment.1
 * JD-Core Version:    0.7.0.1
 */