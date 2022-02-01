package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;

class MsgBackupCompleteFragment$1
  implements DialogInterface.OnClickListener
{
  MsgBackupCompleteFragment$1(MsgBackupCompleteFragment paramMsgBackupCompleteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgBackupCompleteFragment.a(this.a);
    if (MsgBackupCompleteFragment.a(this.a) == 1)
    {
      MsgBackupReporter.a("0X800A253", 5);
      return;
    }
    if ((MsgBackupCompleteFragment.a(this.a) == 4) && (MsgBackupCompleteFragment.a(this.a))) {
      MsgBackupReporter.a("0X800A267", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment.1
 * JD-Core Version:    0.7.0.1
 */