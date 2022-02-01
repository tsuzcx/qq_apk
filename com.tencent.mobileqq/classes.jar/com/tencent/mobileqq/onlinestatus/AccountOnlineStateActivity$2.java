package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder;

class AccountOnlineStateActivity$2
  implements DialogInterface.OnClickListener
{
  AccountOnlineStateActivity$2(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportHelperKt.a("0X800AF9C", 1);
    paramDialogInterface.dismiss();
    AccountOnlineStateActivity.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.2
 * JD-Core Version:    0.7.0.1
 */