package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;

class MsgBackupQRFragment$1
  implements OnItemSelectListener
{
  MsgBackupQRFragment$1(MsgBackupQRFragment paramMsgBackupQRFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click left btn");
    }
    MsgBackupManager.a().d();
    this.a.onBackEvent();
    MsgBackupReporter.a("0X800A242", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.1
 * JD-Core Version:    0.7.0.1
 */