package com.tencent.mobileqq.profilecard.bussiness.thirdapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

class ProfileThirdAppComponent$1
  implements DialogInterface.OnClickListener
{
  ProfileThirdAppComponent$1(ProfileThirdAppComponent paramProfileThirdAppComponent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (QLog.isColorLevel())) {
        QLog.i("ProfileThirdAppComponent", 2, "qbShowShareResultDialog stay");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileThirdAppComponent", 2, "qbShowShareResultDialog back");
      }
      paramDialogInterface = ProfileThirdAppComponent.access$000(this.this$0).getIntent();
      if (paramDialogInterface.getIntExtra("source_id", 3999) == 3090) {
        try
        {
          paramDialogInterface = paramDialogInterface.getStringExtra("extra");
          ForwardSdkShareOption.a(ProfileThirdAppComponent.access$100(this.this$0), true, "action_game_make_friend", Long.parseLong(paramDialogInterface), -1, HardCodeUtil.a(2131902904));
        }
        catch (Exception paramDialogInterface)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("feedBackToGameSDK error = ");
          localStringBuilder.append(paramDialogInterface);
          QLog.e("ProfileThirdAppComponent", 1, localStringBuilder.toString());
        }
      }
      ProfileThirdAppComponent.access$200(this.this$0).moveTaskToBack(true);
    }
    ProfileThirdAppComponent.access$300(this.this$0).dismiss();
    com.tencent.mobileqq.activity.AddFriendLogicActivity.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent.1
 * JD-Core Version:    0.7.0.1
 */