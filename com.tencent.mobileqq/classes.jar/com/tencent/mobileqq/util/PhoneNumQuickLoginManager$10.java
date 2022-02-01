package com.tencent.mobileqq.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.LoginAccountFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class PhoneNumQuickLoginManager$10
  implements PhoneNumQuickLoginManager.OnUinClickListener
{
  PhoneNumQuickLoginManager$10(boolean paramBoolean) {}
  
  public void a(Dialog paramDialog, Map<String, Object> paramMap, PhoneNumQuickLoginManager.AccountInfo paramAccountInfo)
  {
    Object localObject2 = paramDialog.getOwnerActivity();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = QBaseActivity.sTopActivity;
    }
    if (localObject1 == null)
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "onUinItemClick: ownerActivity is null");
      return;
    }
    paramMap = (byte[])paramMap.get("login_tvl_value");
    localObject2 = LoginAccountFragment.a(1, this.a);
    PhoneNumQuickLoginManager.a((Activity)localObject1, HardCodeUtil.a(2131699184), HardCodeUtil.a(2131706424), paramAccountInfo, (Bundle)localObject2, paramMap, 2020);
    PhoneNumQuickLoginManager.b("0X800B8D3");
    paramDialog.setOnDismissListener(null);
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.10
 * JD-Core Version:    0.7.0.1
 */