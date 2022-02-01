package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$28
  implements Runnable
{
  TroopInfoActivity$28(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getFriendDisplayName(this.this$0.H, this.this$0.f.troopowneruin);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.f.troopowneruin)))
    {
      this.this$0.f.troopOwnerNick = ((String)localObject1);
      this.this$0.J.sendEmptyMessage(2);
    }
    else
    {
      Object localObject2 = null;
      Object localObject3 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.H, this.this$0.f.troopUin, this.this$0.f.troopowneruin);
      if (localObject3 == null)
      {
        localObject3 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.H, this.this$0.f.troopUin, this.this$0.f.troopowneruin);
        localObject1 = localObject2;
        if (localObject3 != null) {
          if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick))
          {
            localObject1 = ((TroopMemberInfo)localObject3).friendnick;
          }
          else
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick)) {
              localObject1 = ((TroopMemberInfo)localObject3).troopnick;
            }
          }
        }
      }
      else if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
      {
        localObject1 = ((TroopMemberCardInfo)localObject3).nick;
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
          localObject1 = ((TroopMemberCardInfo)localObject3).name;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.this$0.f.troopOwnerNick = ((String)localObject1);
        this.this$0.J.sendEmptyMessage(2);
      }
      else if (!this.this$0.h)
      {
        this.this$0.h = true;
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getFriendInfo(this.this$0.H, this.this$0.f.troopowneruin);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mTroopInfoData.troopOwnerNick = ");
      ((StringBuilder)localObject1).append(this.this$0.f.troopOwnerNick);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.28
 * JD-Core Version:    0.7.0.1
 */