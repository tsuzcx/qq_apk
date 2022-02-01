package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;

class UpdateLoginAction$1
  implements DialogInterface.OnClickListener
{
  UpdateLoginAction$1(UpdateLoginAction paramUpdateLoginAction, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (UpgradeDetailWrapper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra(UpgradeDetailWrapper.class.getSimpleName());
    UpgradeDetailActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, true, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.UpdateLoginAction.1
 * JD-Core Version:    0.7.0.1
 */