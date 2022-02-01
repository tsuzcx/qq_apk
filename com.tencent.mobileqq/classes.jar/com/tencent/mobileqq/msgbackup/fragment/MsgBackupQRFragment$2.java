package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MsgBackupQRFragment$2
  implements Runnable
{
  MsgBackupQRFragment$2(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void run()
  {
    boolean bool;
    if (NetworkUtil.getSystemNetwork(this.this$0.getActivity()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != MsgBackupQRFragment.a(this.this$0))
    {
      MsgBackupQRFragment.a(this.this$0, bool);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mMigrateQrNetStateRunnable: enable = ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        if ((!MsgBackupQRFragment.b(this.this$0)) && (!MsgBackupQRFragment.c(this.this$0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is not called! current wifi is connected so called it");
          }
          MsgBackupManager.a().a(false);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is called!");
          }
          MsgBackupManager.a().e().a(false);
        }
        localObject = this.this$0.I.obtainMessage(10013);
        this.this$0.I.sendMessage((Message)localObject);
        MsgBackupQRFragment.b(this.this$0, true);
      }
      else
      {
        MsgBackupQRFragment.a(this.this$0, false, false);
      }
    }
    this.this$0.J.postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.2
 * JD-Core Version:    0.7.0.1
 */