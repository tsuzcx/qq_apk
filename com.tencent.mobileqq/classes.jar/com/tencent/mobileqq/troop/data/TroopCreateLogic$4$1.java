package com.tencent.mobileqq.troop.data;

import aoip;
import bfqm;
import bfqq;
import bfqw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateLogic$4$1
  implements Runnable
{
  public TroopCreateLogic$4$1(bfqq parambfqq, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = (aoip)this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    ((aoip)localObject1).j(this.jdField_a_of_type_JavaLangString);
    ((aoip)localObject1).f(this.jdField_a_of_type_JavaLangString);
    localObject1 = ((TroopManager)this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    }
    for (;;)
    {
      Object localObject2;
      int j;
      int i;
      if (localObject1 != null)
      {
        ((TroopInfo)localObject1).dwGroupClassExt = this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_Bfqw.jdField_a_of_type_Int;
        ((TroopInfo)localObject1).mRichFingerMemo = this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_Bfqw.d;
        localObject2 = this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_Bfqw.e.split("\\|");
        if (localObject2.length != 4) {
          break label333;
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
        ((TroopInfo)localObject1).troopowneruin = this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((TroopInfo)localObject1).troopCreateTime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreateLogic", 2, "onGetTroopCreate wMemberNumClient:" + ((TroopInfo)localObject1).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject1).wMemberNum + " troopUin:" + ((TroopInfo)localObject1).troopuin);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAdditionalFlag = 1L;
        localObject2 = (TroopManager)this.jdField_a_of_type_Bfqq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject2 != null) {
          ((TroopManager)localObject2).b((TroopInfo)localObject1);
        }
        return;
        label333:
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