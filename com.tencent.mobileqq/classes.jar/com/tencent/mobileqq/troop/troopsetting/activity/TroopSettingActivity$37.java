package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$37
  extends TroopGameObserver
{
  TroopSettingActivity$37(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void onModifyMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    Object localObject2 = this.a.a.troopUin;
    Object localObject1 = "";
    if ((localObject2 != null) && (this.a.a.troopUin.equals(String.valueOf(paramLong1))))
    {
      if (!paramBoolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" onModifyMemberGameCardSwitch fail. errCode = ");
        ((StringBuilder)localObject1).append(paramLong2);
        ((StringBuilder)localObject1).append(", errInfo = ");
        ((StringBuilder)localObject1).append(paramString);
        if (((StringBuilder)localObject1).toString() == null) {
          paramString = "";
        }
        QLog.e("Q.chatopttroop", 2, paramString);
        QQToast.a(this.a, 1, HardCodeUtil.a(2131697421), 0).b(this.a.getTitleBarHeight());
      }
      TroopSettingActivity.s(this.a);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" onModifyMemberGameCardSwitch. uin doesn't match. errCode = ");
    ((StringBuilder)localObject2).append(paramLong2);
    ((StringBuilder)localObject2).append(", errInfo = ");
    ((StringBuilder)localObject2).append(paramString);
    if (((StringBuilder)localObject2).toString() == null)
    {
      paramString = (String)localObject1;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      paramString = ((StringBuilder)localObject1).toString();
    }
    QLog.e("Q.chatopttroop", 2, paramString);
  }
  
  protected void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (this.a.a.troopUin != null)
    {
      if (!this.a.a.troopUin.equals(String.valueOf(paramLong1))) {
        return;
      }
      if (!paramBoolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onModifyTroopGameCardSwitch fail. errCode = ");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(", errInfo = ");
        localStringBuilder.append(paramString);
        if (localStringBuilder.toString() == null) {
          paramString = "";
        }
        QLog.e("Q.chatopttroop", 2, paramString);
        QQToast.a(this.a, 1, HardCodeUtil.a(2131697421), 0).b(this.a.getTitleBarHeight());
      }
      TroopSettingActivity.t(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.37
 * JD-Core Version:    0.7.0.1
 */