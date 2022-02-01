package com.tencent.mobileqq.newfriend.ui.adapter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class NewFriendMoreSysMsgAdapter$4
  implements DialogInterface.OnClickListener
{
  NewFriendMoreSysMsgAdapter$4(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "cancel click");
    }
    ReportController.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.4
 * JD-Core Version:    0.7.0.1
 */