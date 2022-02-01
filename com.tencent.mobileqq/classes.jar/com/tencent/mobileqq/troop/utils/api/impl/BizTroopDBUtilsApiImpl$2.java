package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class BizTroopDBUtilsApiImpl$2
  implements Runnable
{
  BizTroopDBUtilsApiImpl$2(BizTroopDBUtilsApiImpl paramBizTroopDBUtilsApiImpl, ArrayList paramArrayList, RoamSettingDataServiceImpl paramRoamSettingDataServiceImpl) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTroopMsgFilter, saveSettingList.size():");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
    QLog.e("DBUtils", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RoamSetting localRoamSetting = (RoamSetting)((Iterator)localObject).next();
      this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiImplRoamSettingDataServiceImpl.saveRoamSetting(localRoamSetting);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.BizTroopDBUtilsApiImpl.2
 * JD-Core Version:    0.7.0.1
 */