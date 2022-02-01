package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class CheckAuthLoginAction
  extends BaseLoginAction
{
  private void a(QBaseActivity paramQBaseActivity)
  {
    Object localObject2 = paramQBaseActivity.getIntent();
    Object localObject1 = ((Intent)localObject2).getStringExtra("StrTitle");
    String str4 = ((Intent)localObject2).getStringExtra("StrUpgradeDesc");
    String str1 = ((Intent)localObject2).getStringExtra("StrButton");
    String str2 = ((Intent)localObject2).getStringExtra("StrClientUrl");
    String str3 = ((Intent)localObject2).getStringExtra("StrH5Url");
    localObject2 = ((Intent)localObject2).getStringExtra("StrCode");
    localObject1 = DialogUtil.a(paramQBaseActivity, 230).setTitle((String)localObject1).setMessage(str4);
    ((QQCustomDialog)localObject1).setPositiveButton(str1, new CheckAuthLoginAction.1(this, paramQBaseActivity, str2, str3, (String)localObject2));
    ((QQCustomDialog)localObject1).setNegativeButton(HardCodeUtil.a(2131713937), new CheckAuthLoginAction.2(this, paramQBaseActivity));
    ((QQCustomDialog)localObject1).show();
    ReportController.a(paramQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
  }
  
  public void a(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    paramBundle = paramQBaseActivity.getIntent();
    if (paramBundle == null) {
      QLog.e("CheckAuthLoginAction", 1, "onLoginViewCreate, intent is null");
    }
    while (!paramBundle.getBooleanExtra("reason_for_checkAuth", false)) {
      return;
    }
    a(paramQBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.CheckAuthLoginAction
 * JD-Core Version:    0.7.0.1
 */