package com.tencent.mobileqq.selectmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$6$1
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$6$1(SelectMemberActivity.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.mEntrance == 36)
    {
      if (this.a.a.mType == 1) {
        this.a.a.createNewTypeDiscussion();
      } else {
        this.a.a.startCreateOrAdd();
      }
    }
    else {
      this.a.a.startCreateOrAdd();
    }
    paramDialogInterface.dismiss();
    ReportController.b(null, "CliOper", "", "", "0X8004CEE", "0X8004CEE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.6.1
 * JD-Core Version:    0.7.0.1
 */