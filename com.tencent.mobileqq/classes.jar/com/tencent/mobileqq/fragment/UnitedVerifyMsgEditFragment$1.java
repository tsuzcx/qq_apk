package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Locale;

class UnitedVerifyMsgEditFragment$1
  implements Runnable
{
  UnitedVerifyMsgEditFragment$1(UnitedVerifyMsgEditFragment paramUnitedVerifyMsgEditFragment) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.getArguments();
    String str = "";
    Object localObject2 = ((Bundle)localObject1).getString("TROOP_UIN", "");
    TroopManager localTroopManager = (TroopManager)this.this$0.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject1 = localTroopManager.b((String)localObject2);
    localObject2 = localTroopManager.c((String)localObject2, this.this$0.a.app.getAccount());
    if (localObject1 != null) {
      str = ((TroopInfo)localObject1).getTroopDisplayName();
    }
    if (localObject2 == null) {
      localObject1 = ContactUtils.a(this.this$0.a.app, this.this$0.a.app.getAccount());
    } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopremark)) {
      localObject1 = ((TroopMemberInfo)localObject2).troopremark;
    } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)) {
      localObject1 = ((TroopMemberInfo)localObject2).troopnick;
    } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark)) {
      localObject1 = ((TroopMemberInfo)localObject2).autoremark;
    } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
      localObject1 = ((TroopMemberInfo)localObject2).friendnick;
    } else {
      localObject1 = ContactUtils.a(this.this$0.a.app, this.this$0.a.app.getAccount());
    }
    if (TextUtils.isEmpty(str)) {
      str = String.format(Locale.getDefault(), HardCodeUtil.a(2131715663), new Object[] { localObject1 });
    } else {
      str = String.format(Locale.getDefault(), HardCodeUtil.a(2131715664), new Object[] { str, localObject1 });
    }
    this.this$0.a.runOnUiThread(new UnitedVerifyMsgEditFragment.1.1(this, str, (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1
 * JD-Core Version:    0.7.0.1
 */