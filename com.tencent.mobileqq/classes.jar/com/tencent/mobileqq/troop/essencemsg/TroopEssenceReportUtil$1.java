package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.HashMap;

final class TroopEssenceReportUtil$1
  implements TroopManager.ITroopMemberInfoCallBack
{
  TroopEssenceReportUtil$1(TroopInfo paramTroopInfo, HashMap paramHashMap) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = TroopEssenceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopMemberInfo);
    this.jdField_a_of_type_JavaUtilHashMap.put("uin_type", String.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil.1
 * JD-Core Version:    0.7.0.1
 */