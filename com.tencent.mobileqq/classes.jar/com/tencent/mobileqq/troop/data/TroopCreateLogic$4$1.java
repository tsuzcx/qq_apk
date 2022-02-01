package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.qphone.base.util.QLog;

class TroopCreateLogic$4$1
  implements Runnable
{
  TroopCreateLogic$4$1(TroopCreateLogic.4 param4, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    ((TroopInfoHandler)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(this.jdField_a_of_type_JavaLangString, "TroopCreateLogic.create_new_troop");
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(this.jdField_a_of_type_JavaLangString);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    }
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      if (localTroopInfo != null)
      {
        localTroopInfo.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_Int;
        localTroopInfo.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.e.split("\\|");
        if (localObject.length != 4) {
          break label354;
        }
        j = (int)(Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
        i = (int)(Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
      }
      for (;;)
      {
        localTroopInfo.troopLat = j;
        localTroopInfo.troopLon = i;
        localTroopInfo.isNewTroop = true;
        localTroopInfo.hasSetNewTroopHead = false;
        localTroopInfo.hasSetNewTroopName = false;
        localTroopInfo.wMemberNum = this.jdField_a_of_type_Int;
        localTroopInfo.wMemberNumClient = localTroopInfo.wMemberNum;
        localTroopInfo.troopowneruin = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localTroopInfo.troopCreateTime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreateLogic", 2, "onGetTroopCreate wMemberNumClient:" + localTroopInfo.wMemberNumClient + "  wMemberNum:" + localTroopInfo.wMemberNum + " troopUin:" + localTroopInfo.troopuin);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwAdditionalFlag = 1L;
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$4.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null) {
          ((TroopManager)localObject).b(localTroopInfo);
        }
        return;
        label354:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1
 * JD-Core Version:    0.7.0.1
 */