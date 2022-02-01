package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class UpdateLoginAction
  extends BaseLoginAction
{
  public void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("StrTitle");
    String str2 = ((Intent)localObject).getStringExtra("StrUpgradeDesc");
    ((Intent)localObject).getStringExtra("StrUrl");
    localObject = DialogUtil.a(paramActivity, 230).setTitle(str1).setMessage(str2);
    ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131709259), new UpdateLoginAction.1(this, paramActivity));
    ((QQCustomDialog)localObject).setPositiveButtonContentDescription(paramActivity.getString(2131720141));
    ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131710818), new UpdateLoginAction.2(this));
    ((QQCustomDialog)localObject).show();
  }
  
  public void a(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    paramBundle = paramQBaseActivity.getIntent();
    if (paramBundle == null)
    {
      QLog.e("UpdateLoginAction", 1, "onLoginViewCreate intent is null");
      return;
    }
    if (paramBundle.getBooleanExtra("reason_for_upgrade", false)) {
      a(paramQBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.UpdateLoginAction
 * JD-Core Version:    0.7.0.1
 */