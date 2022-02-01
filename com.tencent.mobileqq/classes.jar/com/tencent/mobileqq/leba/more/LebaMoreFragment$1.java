package com.tencent.mobileqq.leba.more;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class LebaMoreFragment$1
  implements DialogInterface.OnClickListener
{
  LebaMoreFragment$1(LebaMoreFragment paramLebaMoreFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("LebaMoreFragment", 1, "showTipDialog onClick confirm");
    paramDialogInterface = this.a;
    paramDialogInterface.y = true;
    paramDialogInterface.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.1
 * JD-Core Version:    0.7.0.1
 */