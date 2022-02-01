package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;

class MsgBackupPcBaseFragment$2
  implements DialogInterface.OnClickListener
{
  MsgBackupPcBaseFragment$2(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgBackupUtil.a("MsgBackup_MsgBackupPcBaseFragment", "showStopMigrateDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)), Boolean.valueOf(this.a.f) });
    MsgBackupManager.a().a().c();
    MsgBackupManager.a().a().a(null);
    if (this.a.jdField_a_of_type_Boolean)
    {
      if ((!this.a.f) && (this.a.b == 1))
      {
        paramDialogInterface = this.a;
        paramDialogInterface.a(paramDialogInterface.getActivity());
      }
      else
      {
        this.a.n();
      }
      if (!this.a.g) {
        if (this.a.b == 1)
        {
          if (this.a.f) {
            MsgBackupReporter.a("0X800A267", 2);
          }
        }
        else if (this.a.b == 2) {
          MsgBackupReporter.a("0X800A289", 1);
        }
      }
    }
    else
    {
      if (this.a.f)
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
      if ((!this.a.g) && (this.a.b == 1) && (this.a.f)) {
        MsgBackupReporter.a("0X800A267", 1);
      }
    }
    if (this.a.g) {
      if (this.a.b == 1)
      {
        if (this.a.f) {
          MsgBackupReporter.a("0X800A267", 3);
        }
      }
      else if (this.a.b == 2) {
        MsgBackupReporter.a("0X800A289", 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */