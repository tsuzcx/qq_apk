package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;

class MsgBackupTransportFragment$2
  implements DialogInterface.OnClickListener
{
  MsgBackupTransportFragment$2(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = MsgBackupTransportProcessor.a().e();
    if (1 == paramInt)
    {
      this.a.m();
      if (this.a.a)
      {
        MsgBackupReporter.a("0X800A253", 3);
        return;
      }
      MsgBackupReporter.a("0X800A253", 1);
      return;
    }
    if (2 == paramInt)
    {
      if (this.a.e) {
        MsgBackupReporter.a("0X800A244", 2);
      } else {
        MsgBackupReporter.a("0X800A244", 1);
      }
      this.a.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment.2
 * JD-Core Version:    0.7.0.1
 */