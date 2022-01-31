package com.tencent.mobileqq.fragment;

import ajyc;
import android.os.Bundle;
import android.text.TextUtils;
import bbcl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.Locale;

class UnitedVerifyMsgEditFragment$1
  implements Runnable
{
  UnitedVerifyMsgEditFragment$1(UnitedVerifyMsgEditFragment paramUnitedVerifyMsgEditFragment) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.getArguments().getString("TROOP_UIN", "");
    TroopManager localTroopManager = (TroopManager)this.this$0.a.app.getManager(52);
    Object localObject2 = localTroopManager.b((String)localObject1);
    localObject1 = localTroopManager.c((String)localObject1, this.this$0.a.app.getAccount());
    if (localObject2 == null)
    {
      localObject2 = "";
      if (localObject1 != null) {
        break label153;
      }
      localObject1 = bbcl.a(this.this$0.a.app, this.this$0.a.app.getAccount());
      label97:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label255;
      }
    }
    label153:
    label255:
    for (localObject2 = String.format(Locale.getDefault(), ajyc.a(2131715896), new Object[] { localObject1 });; localObject2 = String.format(Locale.getDefault(), ajyc.a(2131715897), new Object[] { localObject2, localObject1 }))
    {
      this.this$0.a.runOnUiThread(new UnitedVerifyMsgEditFragment.1.1(this, (String)localObject2, (String)localObject1));
      return;
      localObject2 = ((TroopInfo)localObject2).getTroopName();
      break;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopremark;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopnick;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).autoremark;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).friendnick;
        break label97;
      }
      localObject1 = bbcl.a(this.this$0.a.app, this.this$0.a.app.getAccount());
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1
 * JD-Core Version:    0.7.0.1
 */