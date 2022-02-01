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
    int i = MsgBackupAuthProcessor.a().c();
    if (paramInt != 2)
    {
      if (paramInt != 8) {
        return;
      }
      MsgBackupManager.a = true;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= ");
        paramView.append(MsgBackupManager.a);
        paramView.append(", curSpeed = ");
        paramView.append(this.a.Q);
        paramView.append(", hasFinishedCount = ");
        paramView.append(this.a.S);
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, paramView.toString());
      }
      MsgBackupManager.a().d().a(null);
      MsgBackupManager.a().a(this.a.Q, this.a.S, i, this.a.getQBaseActivity());
      if (this.a.K == 1)
      {
        if (this.a.ac) {
          MsgBackupReporter.a("0X800A260");
        }
      }
      else {
        MsgBackupReporter.a("0X800A284");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("page is in pc Link page! click cancel! bizType = ");
        paramView.append(i);
        paramView.append(", pcHandler = ");
        paramView.append(this.a.ac);
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, paramView.toString());
      }
      this.a.de_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment.1
 * JD-Core Version:    0.7.0.1
 */