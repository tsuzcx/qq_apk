package com.tencent.mobileqq.troop.data;

import amdu;
import bbqu;
import bbqy;
import bbre;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateLogic$4$1
  implements Runnable
{
  public TroopCreateLogic$4$1(bbqy parambbqy, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    ((amdu)this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).j(this.jdField_a_of_type_JavaLangString);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    }
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      if (localTroopInfo != null)
      {
        localTroopInfo.dwGroupClassExt = this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_Bbre.jdField_a_of_type_Int;
        localTroopInfo.mRichFingerMemo = this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_Bbre.d;
        localObject = this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_Bbre.e.split("\\|");
        if (localObject.length != 4) {
          break label323;
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
        localTroopInfo.troopowneruin = this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localTroopInfo.troopCreateTime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreateLogic", 2, "onGetTroopCreate wMemberNumClient:" + localTroopInfo.wMemberNumClient + "  wMemberNum:" + localTroopInfo.wMemberNum + " troopUin:" + localTroopInfo.troopuin);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAdditionalFlag = 1L;
        localObject = (TroopManager)this.jdField_a_of_type_Bbqy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject != null) {
          ((TroopManager)localObject).b(localTroopInfo);
        }
        return;
        label323:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1
 * JD-Core Version:    0.7.0.1
 */