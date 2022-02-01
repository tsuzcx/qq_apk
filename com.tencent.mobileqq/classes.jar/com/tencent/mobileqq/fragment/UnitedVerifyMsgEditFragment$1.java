package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import anvx;
import com.tencent.mobileqq.app.BaseActivity;
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
    Object localObject1 = this.this$0.getArguments().getString("TROOP_UIN", "");
    TroopManager localTroopManager = (TroopManager)this.this$0.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = localTroopManager.b((String)localObject1);
    localObject1 = localTroopManager.c((String)localObject1, this.this$0.a.app.getAccount());
    if (localObject2 == null)
    {
      localObject2 = "";
      if (localObject1 != null) {
        break label154;
      }
      localObject1 = ContactUtils.getFriendNick(this.this$0.a.app, this.this$0.a.app.getAccount());
      label98:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label256;
      }
    }
    label256:
    for (localObject2 = String.format(Locale.getDefault(), anvx.a(2131715257), new Object[] { localObject1 });; localObject2 = String.format(Locale.getDefault(), anvx.a(2131715258), new Object[] { localObject2, localObject1 }))
    {
      this.this$0.a.runOnUiThread(new UnitedVerifyMsgEditFragment.1.1(this, (String)localObject2, (String)localObject1));
      return;
      localObject2 = ((TroopInfo)localObject2).getTroopName();
      break;
      label154:
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopremark;
        break label98;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopnick;
        break label98;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).autoremark;
        break label98;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).friendnick;
        break label98;
      }
      localObject1 = ContactUtils.getFriendNick(this.this$0.a.app, this.this$0.a.app.getAccount());
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1
 * JD-Core Version:    0.7.0.1
 */