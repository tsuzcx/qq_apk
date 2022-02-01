package com.tencent.mobileqq.troop.troopcard;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$24
  extends TroopMngObserver
{
  TroopInfoActivity$24(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramTroopInfo != null))
    {
      if (!Utils.a(paramTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTroopSearch|result = ");
        ((StringBuilder)localObject).append(paramByte);
        ((StringBuilder)localObject).append(", p = ");
        ((StringBuilder)localObject).append(paramTroopInfo);
        QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
      }
      if (paramByte == 0)
      {
        localObject = this.a;
        ((TroopInfoActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
        ((TroopInfoActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 4) {
      return;
    }
    if (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.g(this.a);
      return;
    }
    this.a.a(2131718739, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.24
 * JD-Core Version:    0.7.0.1
 */