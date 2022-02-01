package com.tencent.mobileqq.troop.troopcard.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardUtilsApiImpl$1
  implements ITroopMemberInfoService.ITroopMemberInfoCallBack
{
  TroopGameCardUtilsApiImpl$1(TroopGameCardUtilsApiImpl paramTroopGameCardUtilsApiImpl, ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack paramICheckShowMsgGameGradeLevelBack) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool = false;
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkoutMsgShowGameGradeLevel memberInfo");
        if (paramTroopMemberInfo == null) {
          paramTroopMemberInfo = "is null";
        } else {
          paramTroopMemberInfo = "disable game member card";
        }
        ((StringBuilder)localObject).append(paramTroopMemberInfo);
        QLog.d("TroopGameCardUtil", 2, ((StringBuilder)localObject).toString());
      }
      this.a.a(false, false);
      return;
    }
    Object localObject = this.a;
    if ((paramTroopMemberInfo.cmduinFlagEx3Grocery & 1L) == 0L) {
      bool = true;
    }
    ((ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack)localObject).a(true, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.impl.TroopGameCardUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */