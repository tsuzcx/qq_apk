package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;

class MsgBackupTransportFragment$4
  implements DialogInterface.OnClickListener
{
  MsgBackupTransportFragment$4(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgBackupManager.a().a().c();
    MsgBackupManager.a().d();
    if (this.a.a)
    {
      this.a.h();
      return;
    }
    paramDialogInterface = this.a;
    paramDialogInterface.a(paramDialogInterface.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment.4
 * JD-Core Version:    0.7.0.1
 */