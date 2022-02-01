package com.tencent.mobileqq.troop.troopcreate.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.mobileqq.troop.troopmemberlevel.handler.TroopMemberLevelHandler;
import com.tencent.qphone.base.util.QLog;

class TroopCreateServiceImpl$3$1
  implements Runnable
{
  TroopCreateServiceImpl$3$1(TroopCreateServiceImpl.3 param3, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    ((ITroopInfoHandler)TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).getBusinessHandler(TroopInfoHandler.class.getName())).a(this.jdField_a_of_type_JavaLangString, "TroopCreateLogic.create_new_troop");
    ((ITroopMemberLevelHandler)TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).getBusinessHandler(TroopMemberLevelHandler.class.getName())).a(this.jdField_a_of_type_JavaLangString);
    ITroopInfoService localITroopInfoService = (ITroopInfoService)TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).getRuntimeService(ITroopInfoService.class, "");
    Object localObject2 = localITroopInfoService.findTroopInfo(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    }
    if (localObject1 != null)
    {
      ((TroopInfo)localObject1).dwGroupClassExt = TroopCreateServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).classify;
      ((TroopInfo)localObject1).mRichFingerMemo = TroopCreateServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).introduction;
      localObject2 = TroopCreateServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).location.split("\\|");
      int j;
      int i;
      if (localObject2.length == 4)
      {
        j = (int)(Float.valueOf(localObject2[1]).floatValue() * 1000000.0F);
        i = (int)(Float.valueOf(localObject2[2]).floatValue() * 1000000.0F);
      }
      else
      {
        i = 0;
        j = 0;
      }
      ((TroopInfo)localObject1).troopLat = j;
      ((TroopInfo)localObject1).troopLon = i;
      ((TroopInfo)localObject1).isNewTroop = true;
      ((TroopInfo)localObject1).hasSetNewTroopHead = false;
      ((TroopInfo)localObject1).hasSetNewTroopName = false;
      ((TroopInfo)localObject1).wMemberNum = this.jdField_a_of_type_Int;
      ((TroopInfo)localObject1).wMemberNumClient = ((TroopInfo)localObject1).wMemberNum;
      ((TroopInfo)localObject1).troopowneruin = TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$3.a).getCurrentAccountUin();
      ((TroopInfo)localObject1).troopCreateTime = (System.currentTimeMillis() / 1000L);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetTroopCreate wMemberNumClient:");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNumClient);
        ((StringBuilder)localObject2).append("  wMemberNum:");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
        ((StringBuilder)localObject2).append(" troopUin:");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).troopuin);
        QLog.d("TroopCreateServiceImpl", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwAdditionalFlag = 1L;
      localITroopInfoService.saveTroopInfo((TroopInfo)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.3.1
 * JD-Core Version:    0.7.0.1
 */