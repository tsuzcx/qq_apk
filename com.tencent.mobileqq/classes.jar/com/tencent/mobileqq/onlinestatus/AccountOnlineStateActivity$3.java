package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AccountOnlineStateActivity$3
  implements DialogInterface.OnClickListener
{
  AccountOnlineStateActivity$3(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportHelperKt.a("0X800AF9C", 2);
    paramDialogInterface.dismiss();
    AccountOnlineStateActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.3
 * JD-Core Version:    0.7.0.1
 */