package com.tencent.mobileqq.troop.data;

import aoep;
import bfgz;
import bfhd;
import bfhj;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateLogic$4$1
  implements Runnable
{
  public TroopCreateLogic$4$1(bfhd parambfhd, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = (aoep)this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    ((aoep)localObject1).a(this.jdField_a_of_type_JavaLangString, "TroopCreateLogic.create_new_troop");
    ((aoep)localObject1).f(this.jdField_a_of_type_JavaLangString);
    localObject1 = ((TroopManager)this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    }
    for (;;)
    {
      Object localObject2;
      int j;
      int i;
      if (localObject1 != null)
      {
        ((TroopInfo)localObject1).dwGroupClassExt = this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_Bfhj.jdField_a_of_type_Int;
        ((TroopInfo)localObject1).mRichFingerMemo = this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_Bfhj.d;
        localObject2 = this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_Bfhj.e.split("\\|");
        if (localObject2.length != 4) {
          break label338;
        }
        j = (int)(Float.valueOf(localObject2[1]).floatValue() * 1000000.0F);
        i = (int)(Float.valueOf(localObject2[2]).floatValue() * 1000000.0F);
      }
      for (;;)
      {
        ((TroopInfo)localObject1).troopLat = j;
        ((TroopInfo)localObject1).troopLon = i;
        ((TroopInfo)localObject1).isNewTroop = true;
        ((TroopInfo)localObject1).hasSetNewTroopHead = false;
        ((TroopInfo)localObject1).hasSetNewTroopName = false;
        ((TroopInfo)localObject1).wMemberNum = this.jdField_a_of_type_Int;
        ((TroopInfo)localObject1).wMemberNumClient = ((TroopInfo)localObject1).wMemberNum;
        ((TroopInfo)localObject1).troopowneruin = this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((TroopInfo)localObject1).troopCreateTime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreateLogic", 2, "onGetTroopCreate wMemberNumClient:" + ((TroopInfo)localObject1).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject1).wMemberNum + " troopUin:" + ((TroopInfo)localObject1).troopuin);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwAdditionalFlag = 1L;
        localObject2 = (TroopManager)this.jdField_a_of_type_Bfhd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject2 != null) {
          ((TroopManager)localObject2).b((TroopInfo)localObject1);
        }
        return;
        label338:
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