package com.tencent.mobileqq.quicklogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ClosePCVerifyImpl$2
  implements DialogInterface.OnClickListener
{
  ClosePCVerifyImpl$2(ClosePCVerifyImpl paramClosePCVerifyImpl, BaseQQAppInterface paramBaseQQAppInterface, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE05", "0X800AE05", 0, 0, "", "", "", "");
    this.c.a(false, this.a);
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl.2
 * JD-Core Version:    0.7.0.1
 */