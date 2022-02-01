package com.tencent.mobileqq.profilecard.base.container;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

final class ProfileBottomContainer$9
  implements DialogInterface.OnClickListener
{
  ProfileBottomContainer$9(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ProfileBottomContainer.enterChat(this.val$app, this.val$activity, this.val$cardInfo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.9
 * JD-Core Version:    0.7.0.1
 */