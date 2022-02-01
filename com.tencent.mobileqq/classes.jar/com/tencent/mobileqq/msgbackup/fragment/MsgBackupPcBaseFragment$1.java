package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;

class MsgBackupPcBaseFragment$1
  implements DialogInterface.OnClickListener
{
  MsgBackupPcBaseFragment$1(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgBackupUtil.a("MsgBackup_MsgBackupPcBaseFragment", "showDisConnDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.ab)), Boolean.valueOf(this.a.ac) });
    MsgBackupManager.a().d().m();
    MsgBackupManager.a().g();
    if (this.a.T)
    {
      if ((!this.a.ac) && (this.a.K == 1))
      {
        paramDialogInterface = this.a;
        paramDialogInterface.a(paramDialogInterface.getActivity());
        return;
      }
      this.a.v();
      return;
    }
    if (this.a.ac)
    {
      if (this.a.getActivity() != null)
      {
        this.a.getActivity().setResult(1001);
        this.a.getActivity().finish();
      }
    }
    else
    {
      paramDialogInterface = this.a;
      paramDialogInterface.a(paramDialogInterface.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */