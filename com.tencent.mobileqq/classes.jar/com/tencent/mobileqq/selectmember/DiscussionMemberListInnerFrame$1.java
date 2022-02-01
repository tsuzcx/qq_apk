package com.tencent.mobileqq.selectmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;

class DiscussionMemberListInnerFrame$1
  implements DialogInterface.OnClickListener
{
  DiscussionMemberListInnerFrame$1(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    this.a.d.setChecked(true ^ this.a.d.isChecked());
    paramDialogInterface = this.a;
    paramDialogInterface.onCheckedChanged(paramDialogInterface.d, this.a.d.isChecked());
    if (this.a.f.mEntrance == 32)
    {
      IQWalletApi localIQWalletApi = (IQWalletApi)QRoute.api(IQWalletApi.class);
      if (this.a.d.isChecked()) {
        paramDialogInterface = "friendsfinder.all.confirm";
      } else {
        paramDialogInterface = "friendsfinder.all.cancel";
      }
      localIQWalletApi.reportTenpay(0, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.DiscussionMemberListInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */