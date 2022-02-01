package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgBackupBaseFragment$4
  implements DialogInterface.OnClickListener
{
  MsgBackupBaseFragment$4(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.K == 2)
    {
      MsgBackupCompleteFragment.d(this.a.getActivity(), this.a.R, this.a.S);
      return;
    }
    if (this.a.K == 3) {
      MsgBackupCompleteFragment.j(this.a.getActivity(), this.a.R, this.a.S);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */