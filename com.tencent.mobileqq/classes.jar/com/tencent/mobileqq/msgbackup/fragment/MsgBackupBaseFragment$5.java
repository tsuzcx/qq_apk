package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;

class MsgBackupBaseFragment$5
  implements DialogInterface.OnClickListener
{
  MsgBackupBaseFragment$5(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().setResult(1001);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.5
 * JD-Core Version:    0.7.0.1
 */