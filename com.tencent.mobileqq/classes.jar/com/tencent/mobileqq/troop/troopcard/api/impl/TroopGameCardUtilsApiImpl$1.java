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
    if ((paramTroopMemberInfo != null) && ((paramTroopMemberInfo.cmduinFlagEx3Grocery & 1L) == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardApiITroopGameCardUtilsApi$ICheckShowMsgGameGradeLevelBack.a(true);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkoutMsgShowGameGradeLevel memberInfo");
      if (paramTroopMemberInfo == null) {
        paramTroopMemberInfo = "is null";
      } else {
        paramTroopMemberInfo = "disable game member card";
      }
      localStringBuilder.append(paramTroopMemberInfo);
      QLog.d("TroopGameCardUtil", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardApiITroopGameCardUtilsApi$ICheckShowMsgGameGradeLevelBack.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.impl.TroopGameCardUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */