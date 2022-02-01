package com.tencent.mobileqq.loginregister;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class UpdateLoginAction$2
  implements DialogInterface.OnClickListener
{
  UpdateLoginAction$2(UpdateLoginAction paramUpdateLoginAction) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      label7:
      break label7;
    }
    QLog.e("UpdateLoginAction", 1, "showUpdateDialog, setNegativeButton click error : ", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.UpdateLoginAction.2
 * JD-Core Version:    0.7.0.1
 */